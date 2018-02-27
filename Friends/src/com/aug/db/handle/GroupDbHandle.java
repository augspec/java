package com.aug.db.handle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.aug.db.DataSource;
import com.aug.db.entities.Group;

public class GroupDbHandle implements DbHandleAPI<Group> {
	
	private static final Logger _LOG = Logger.getLogger(GroupDbHandle.class);
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public boolean create(Group object) {
		if (object == null) {
			_LOG.error("#create(?): tham so dau vao null!");
			return false;
		}
		
		try {
			conn = DataSource.getConnection();
			
			if (conn == null || conn.isClosed()) {
				_LOG.error("#create(?): connection null hoac khong the ket noi!");
				return false;
			}
			
			StringBuilder query = new StringBuilder("INSERT INTO ");
			query.append("`group`(id, name, description, user_id) ");
			query.append("VALUES(?, ?, ?, ?)");
			
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, object.getId());
			ps.setString(2, object.getName());
			ps.setString(3, object.getDescription());
			ps.setString(4, object.getUserId());
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			_LOG.error("#create(?): " + e.getMessage(), e);
		} finally {
			DataSource.returnConnection(conn);
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}

	@Override
	public boolean update(Group object) {
		if (object == null) {
			_LOG.error("#update(?): tham so dau vao null!");
			return false;
		}
		
		try {
			conn = DataSource.getConnection();
			
			if (conn == null || conn.isClosed()) {
				_LOG.error("#update(?): connection null hoac khong the ket noi!");
				return false;
			}
			
			StringBuilder query = new StringBuilder("UPDATE `group` SET name=?, description=?, ");
			query.append("user_id=? WHERE id=?");
			
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, object.getName());
			ps.setString(2, object.getDescription());
			ps.setString(3, object.getUserId());
			ps.setString(4, object.getId());
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			_LOG.error("#update(?): " + e.getMessage(), e);
		} finally {
			DataSource.returnConnection(conn);
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return false;
	}

	@Override
	public boolean delete(Group object) {
		if (object == null) {
			_LOG.error("#delete(?): tham so dau vao null!");
			return false;
		}
		
		try {
			conn = DataSource.getConnection();
			
			if (conn == null || conn.isClosed()) {
				_LOG.error("#delete(?): connection null hoac khong the ket noi!");
				return false;
			}
			
			StringBuilder query = new StringBuilder("DELETE FROM `group` WHERE id=?");
			
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, object.getId());
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			_LOG.error("#delete(?): " + e.getMessage(), e);
		} finally {
			DataSource.returnConnection(conn);
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}

	@Override
	public List<Group> getAll() {
		try {
			conn = DataSource.getConnection();
			
			if (conn == null || conn.isClosed()) {
				_LOG.error("#getAll(?): connection null hoac khong the ket noi!");
				return null;
			}
			
			StringBuilder query = new StringBuilder("SELECT id, name, description, user_id FROM `group`");
			
			ps = conn.prepareStatement(query.toString());
			rs = ps.executeQuery();
			
			List<Group> list = new ArrayList<Group>();
			Group temp = null;
			while (rs.next()) {
				temp = new Group();
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setDescription(rs.getString("description"));
				temp.setUserId(rs.getString("user_id"));
				
				list.add(temp);
			}
			
			return list;
		} catch (Exception e) {
			_LOG.error("#getAll(): " + e.getMessage(), e);
		} finally {
			DataSource.returnConnection(conn);
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}
}
