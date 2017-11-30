package com.aug.hibernate;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.aug.annotations.hibernate.Column;
import com.aug.annotations.hibernate.Id;
import com.aug.annotations.hibernate.Table;
import com.aug.annotations.hibernate.handleruntime.HibernateHandleRuntime;
import com.aug.annotations.util.Constant.JsonKey;

public class Session {
	
	HibernateHandleRuntime handle = new HibernateHandleRuntime();
	
	private String entity;
	private String holderColumnIdName;
	private Class<?> holderClass;

	public Integer save(Object obj, Connection conn) throws Exception {
		validate(obj);
		
		JSONObject json = handle.processing(obj);
		String tableName = String.valueOf(json.get(JsonKey.TABLE));
		JSONArray columns = (JSONArray) json.get(JsonKey.COLUMN);
		
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO " + tableName + "(");
		
		List<String> listKey = new ArrayList<String>();
		List<Object> listValue = new ArrayList<Object>();
		for (int i = 0; i < columns.size(); i++) {			
			JSONObject column = (JSONObject) columns.get(i);
			
			for (Object key : column.keySet()) {
				listKey.add(String.valueOf(key));
				Object value = column.get(key);
				if (value instanceof String) {
					value = "'" + value + "'";
				}
				listValue.add(value);
			}
		}
		
		query.append(StringUtils.join(listKey, ",") + ") ");
		query.append("VALUES (" + StringUtils.join(listValue, ",") + ")");
		
		System.out.println(query.toString());
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		int affected = ps.executeUpdate();
		if (affected == 0)
			return 0;
		
		int id = 0;
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			id = rs.getInt(1);
		}
		
		ps.close();
		rs.close();
		
		return id;
	}
	
	public void update(Object obj, Connection conn) throws Exception {
		validate(obj);
		
		Class<?> clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Object valueId = null;
		String columnIdName = "";
		
		StringBuilder query = new StringBuilder();
		query.append("UPDATE " + entity + " SET ");
		
		List<Object> updateColumns = new ArrayList<Object>();
		for (Field field : fields) {
			field.setAccessible(true);
			
			if (field.isAnnotationPresent(Id.class) 
					&& field.isAnnotationPresent(Column.class)) {
				valueId = field.get(obj);
				
				Column column = field.getAnnotation(Column.class);
				if (column != null)
					columnIdName = column.name();
				if (valueId == null)
					throw new Exception("Identity field cannot be null");
				
				continue;
			}
			
			Column column = field.getAnnotation(Column.class);
			
			Object value = field.get(obj);
			if (value instanceof String) {
				value = "'" + value + "'";
			}
			updateColumns.add((column != null ? column.name() : "") + "=" + value);
		}
		
		query.append(StringUtils.join(updateColumns, ",") + " WHERE " + columnIdName + "=" + valueId);
		System.out.println(query.toString());
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		ps.executeUpdate();
		
		ps.close();
	}
	
	public void delete(Object obj, Connection conn) throws Exception {
		validate(obj);
		
		Class<?> clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Object valueId = null;
		String columnIdName = "";
		
		StringBuilder query = new StringBuilder();
		
		for (Field field : fields) {
			if (field.isAnnotationPresent(Id.class) && field.isAnnotationPresent(Column.class)) {
				field.setAccessible(true);
				valueId = field.get(obj);
				
				Column column = field.getAnnotation(Column.class);
				if (column != null)
					columnIdName = column.name();
				if (valueId == null)
					throw new Exception("Identity field cannot be null");
				
				break;
			}
		}
		
		query.append("DELETE FROM " + entity + " WHERE " + columnIdName + "=" + valueId);
		System.out.println(query.toString());
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		ps.executeUpdate();
		
		ps.close();
	}
	
	public Object get(int id, Connection conn) throws Exception {
		if (id <= 0)
			throw new Exception("Identity cannot small than or equal to zero");
			
		if (entity == null || entity.isEmpty())
			throw new Exception("Please set entity to get value");
		
		if (holderColumnIdName == null || holderColumnIdName.isEmpty())
			throw new Exception("Identity not set in entity, please indicated @Id");
		
		if (holderClass == null)
			throw new Exception("@Table cannot indicated for entity");
		
		Field[] fields = holderClass.getDeclaredFields();
		
		List<String> columns = new ArrayList<String>();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				if (column != null)
					columns.add(column.name());
			}
		}
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT " + StringUtils.join(columns, ",") + " FROM " + entity + " WHERE " + holderColumnIdName + "=" + id);
		System.out.println(query.toString());
		
		Class<?> clazz = Class.forName(holderClass.getName());
		Constructor<?> constructor = clazz.getConstructors()[0];
		Object resultObj = constructor.newInstance(new Object[] {});
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Field[] fields2 = resultObj.getClass().getDeclaredFields();
			for (Field field : fields2) {
				if (field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					if (column != null) {
						field.setAccessible(true);
						field.set(resultObj, rs.getObject(column.name()));
					}
				}
			}
		}
		
		ps.close();
		rs.close();
		
		return resultObj;
	}
	
	public Object fetchAll(Connection conn) throws Exception {
		if (entity == null || entity.isEmpty())
			throw new Exception("Please set entity to get value");
		
		if (holderClass == null)
			throw new Exception("@Table cannot indicated for entity");
		
		Field[] fields = holderClass.getDeclaredFields();
		
		List<String> columns = new ArrayList<String>();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				if (column != null)
					columns.add(column.name());
			}
		}
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT " + StringUtils.join(columns, ",") + " FROM " + entity);
		System.out.println(query.toString());
		
		List<Object> listReturn = new ArrayList<Object>();
		
		Class<?> clazz = Class.forName(holderClass.getName());
		Constructor<?> constructor = clazz.getConstructors()[0];
		Object resultObj = null;
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			resultObj = constructor.newInstance(new Object[] {});
			
			Field[] fields2 = resultObj.getClass().getDeclaredFields();
			for (Field field : fields2) {
				if (field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					if (column != null) {
						field.setAccessible(true);
						field.set(resultObj, rs.getObject(column.name()));
					}
				}
			}
			listReturn.add(resultObj);
		}
		
		ps.close();
		rs.close();
		
		return listReturn;
	}
	
	private void validate(Object obj) throws Exception {
		if (obj == null)
			throw new Exception("First parameter cannot be null");
		
		if (entity == null || entity.isEmpty()) {
			Class<?> clazz = obj.getClass();
			
			if (clazz.isAnnotationPresent(Table.class)) {
				Table table = clazz.getAnnotation(Table.class);
				if (table == null)
					throw new Exception("@Table cannot be null");
				
				this.entity = table.name();
			} else {
				throw new Exception("@Table not use for this class");
			}
		}
		
		if (entity == null || entity.isEmpty())
			throw new Exception("Table name cannot be null in annotation @Table");
	}
	
	public String getEntity() {
		return entity;
	}
	
	public void setEntity(Class<?> clazz) throws Exception {
		if (clazz.isAnnotationPresent(Table.class)) {
			Table table = clazz.getAnnotation(Table.class);
			if (table == null)
				throw new Exception("@Table cannot be null");
			
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				if (field.isAnnotationPresent(Id.class) 
						&& field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					if (column != null)
					 this.holderColumnIdName = column.name();
					
					break;
				}
			}
			
			this.entity = table.name();
			this.holderClass = clazz;
		} else {
			throw new Exception("@Table not use for this class");
		}
	}
}
