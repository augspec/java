package com.aug.db.handle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.aug.db.DataSource;
import com.aug.db.entities.User;

public class UserDbHandle implements DbHandleAPI<User> {

	private static final Logger _LOG = Logger.getLogger(UserDbHandle.class);
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public boolean create(User object) {
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
			query.append("user(username, password, nicename, email, address, permission) ");
			query.append("VALUES(?, ?, ?, ?, ?, ?)");
			
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, object.getUsername());
			ps.setString(2, object.getPassword());
			ps.setString(3, object.getNicename());
			ps.setString(4, object.getEmail());
			ps.setString(5, object.getAddress());
			ps.setString(6, object.getPermission());
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			_LOG.error("#create(?): " + e.getMessage(), e);
		} finally {
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
	public boolean update(User object) {
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
			
			StringBuilder query = new StringBuilder("UPDATE user SET username=?, password=?, nicename=?, ");
			query.append("email=?, address=?, permission=? WHERE id=? ");
			
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, object.getUsername());
			ps.setString(2, object.getPassword());
			ps.setString(3, object.getNicename());
			ps.setString(4, object.getEmail());
			ps.setString(5, object.getAddress());
			ps.setString(6, object.getPermission());
			ps.setInt(7, object.getId());
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			_LOG.error("#update(?): " + e.getMessage(), e);
		} finally {
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
	public boolean delete(User object) {
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
			
			StringBuilder query = new StringBuilder("DELETE FROM user WHERE id=?");
			
			ps = conn.prepareStatement(query.toString());
			ps.setInt(1, object.getId());
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			_LOG.error("#delete(?): " + e.getMessage(), e);
		} finally {
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
	public List<User> getAll() {
		try {
			conn = DataSource.getConnection();
			
			if (conn == null || conn.isClosed()) {
				_LOG.error("#getAll(?): connection null hoac khong the ket noi!");
				return null;
			}
			
			StringBuilder query = new StringBuilder("SELECT id, username, password, ");
			query.append("nicename, email, address, permission FROM user");
			
			ps = conn.prepareStatement(query.toString());
			rs = ps.executeQuery();
			
			List<User> list = new ArrayList<User>();
			User temp = null;
			while (rs.next()) {
				temp = new User();
				temp.setId(rs.getInt("id"));
				temp.setUsername(rs.getString("username"));
				temp.setPassword(rs.getString("password"));
				temp.setNicename(rs.getString("nicename"));
				temp.setEmail(rs.getString("email"));
				temp.setAddress(rs.getString("address"));
				temp.setPermission(rs.getString("permission"));
				
				list.add(temp);
			}
			
			return list;
		} catch (Exception e) {
			_LOG.error("#getAll(): " + e.getMessage(), e);
		} finally {
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
	
	public User getByUsername(String username) {
		try {
			conn = DataSource.getConnection();
			
			if (conn == null || conn.isClosed()) {
				_LOG.error("#getByUsername(?): connection null hoac khong the ket noi!");
				return null;
			}
			
			StringBuilder query = new StringBuilder("SELECT id, username, password, ");
			query.append("nicename, email, address, permission FROM user WHERE username=?");
			
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, username);
			rs = ps.executeQuery();
			
			User temp = null;
			if (rs.next()) {
				temp = new User();
				temp.setId(rs.getInt("id"));
				temp.setUsername(rs.getString("username"));
				temp.setPassword(rs.getString("password"));
				temp.setNicename(rs.getString("nicename"));
				temp.setEmail(rs.getString("email"));
				temp.setAddress(rs.getString("address"));
				temp.setPermission(rs.getString("permission"));
				
			}
			
			DataSource.returnConnection(conn);
			
			return temp;
		} catch (Exception e) {
			_LOG.error("#getByUsername(): " + e.getMessage(), e);
		} finally {
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
