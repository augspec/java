/**
 * 
 */
package com.aug.annotations.hibernate.handleruntime;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.aug.annotations.hibernate.Column;
import com.aug.annotations.hibernate.Id;
import com.aug.annotations.hibernate.Table;
import com.aug.annotations.util.Constant.JsonKey;

/**
 * Xử lý runtime cho @Table, @Column
 * 
 * @author AUG
 *
 */
public class HibernateHandleRuntime {

	/**
	 * Xử lý runtime cho @Table, @Column
	 * 
	 * @param obj object sử dụng @Table, @Column
	 * @return trả về một JsonObject hoặc null.
	 * @author AUG
	 */
	@SuppressWarnings("unchecked")
	public JSONObject processing(Object obj) {
		if (obj == null)
			return null;
		
		Class<?> clazz = obj.getClass();
		JSONObject root = new JSONObject();
		
		if (clazz.isAnnotationPresent(Table.class)) {
			Table table = clazz.getAnnotation(Table.class);
			if (table == null)
				return null;
			
			root.put(JsonKey.TABLE, table.name());
			
			JSONArray columns = new JSONArray();
			
			// Xử lý các fields
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				if (field.isAnnotationPresent(Column.class) 
						&& !field.isAnnotationPresent(Id.class)) {
					Column column = field.getAnnotation(Column.class);
					if (column == null)
						continue;
					
					field.setAccessible(true);
					JSONObject jColumn = new JSONObject();
					try {
						Object value = field.get(obj);
						if (!column.allowNull() && value == null)
							throw new Exception("Column " + column.name() + " cannot be null");
						
						jColumn.put(column.name(), value);
						columns.add(jColumn);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
			// xử lý các getters
			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) {
				// Kiểm tra nếu có đánh dấu @Column và là getter
				if (method.isAnnotationPresent(Column.class) 
						&& !method.isAnnotationPresent(Id.class) 
						&& method.getName().startsWith("get")) {
					Column column = method.getAnnotation(Column.class);
					if (column == null)
						continue;
					
					method.setAccessible(true);
					JSONObject jColumn = new JSONObject();
					try {
						Object value = method.invoke(obj, new Object[]{});
						if (!column.allowNull() && value == null)
							throw new Exception("Column " + column.name() + " cannot be null");
						
						jColumn.put(column.name(), value);
						columns.add(jColumn);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
			root.put(JsonKey.COLUMN, columns);
		}
		
		return root;
	}
}
