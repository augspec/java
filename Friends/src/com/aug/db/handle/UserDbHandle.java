package com.aug.db.handle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import com.aug.db.DataSource;
import com.aug.db.entities.User;
import com.aug.web.util.FriendUtil;

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
			query.append("user(id, username, password, nicename, email, address, permission) ");
			query.append("VALUES(?, ?, ?, ?, ?, ?, ?)");
			
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, generateId() + "");
			ps.setString(2, object.getUsername());
			ps.setString(3, object.getPassword());
			ps.setString(4, object.getNicename());
			ps.setString(5, object.getEmail());
			ps.setString(6, object.getAddress());
			ps.setString(7, object.getPermission());
			
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
			query.append("email=?, address=?, permission=? WHERE rowid=? ");
			
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, object.getUsername());
			ps.setString(2, object.getPassword());
			ps.setString(3, object.getNicename());
			ps.setString(4, object.getEmail());
			ps.setString(5, object.getAddress());
			ps.setString(6, object.getPermission());
			ps.setInt(7, object.getRowid());
			
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
			
			StringBuilder query = new StringBuilder("DELETE FROM user WHERE rowid=?");
			
			ps = conn.prepareStatement(query.toString());
			ps.setInt(1, object.getRowid());
			
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
	public List<User> getAll() {
		try {
			conn = DataSource.getConnection();
			
			if (conn == null || conn.isClosed()) {
				_LOG.error("#getAll(): connection null hoac khong the ket noi!");
				return null;
			}
			
			StringBuilder query = new StringBuilder("SELECT rowid, id, username, password, ");
			query.append("nicename, email, address, permission FROM user ORDER BY rowid DESC");
			
			ps = conn.prepareStatement(query.toString());
			rs = ps.executeQuery();
			
			List<User> list = new ArrayList<User>();
			User temp = null;
			while (rs.next()) {
				temp = new User();
				temp.setRowid(rs.getInt("rowid"));
				temp.setId(rs.getString("id"));
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
	
	public User getByUsername(String username) {
		try {
			conn = DataSource.getConnection();
			
			if (conn == null || conn.isClosed()) {
				_LOG.error("#getByUsername(?): connection null hoac khong the ket noi!");
				return null;
			}
			
			StringBuilder query = new StringBuilder("SELECT rowid, id, username, password, ");
			query.append("nicename, email, address, permission FROM user WHERE username=?");
			
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, username);
			rs = ps.executeQuery();
			
			User temp = null;
			if (rs.next()) {
				temp = new User();
				temp.setRowid(rs.getInt("rowid"));
				temp.setId(rs.getString("id"));
				temp.setUsername(rs.getString("username"));
				temp.setPassword(rs.getString("password"));
				temp.setNicename(rs.getString("nicename"));
				temp.setEmail(rs.getString("email"));
				temp.setAddress(rs.getString("address"));
				temp.setPermission(rs.getString("permission"));
				
			}
			
			return temp;
		} catch (Exception e) {
			_LOG.error("#getByUsername(): " + e.getMessage(), e);
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
	
	private int generateId() {
		Random r = new Random(new Date().getTime());
		
		return r.nextInt();
	}
	
	public int count() {
		try {
			conn = DataSource.getConnection();
			
			if (conn == null || conn.isClosed()) {
				_LOG.error("#count(): connection null hoac khong the ket noi!");
				return 0;
			}
			
			StringBuilder query = new StringBuilder("SELECT COUNT(*) FROM user");
			
			ps = conn.prepareStatement(query.toString());
			rs = ps.executeQuery();
			
			int count = 0;
			if (rs.next()) {
				count = rs.getInt(1);
			}
			
			return count;
		} catch (Exception e) {
			_LOG.error("#count(): " + e.getMessage(), e);
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
		
		return 0;
	}
	
	public int searchCount(String str) {
		try {
			conn = DataSource.getConnection();
			
			if (conn == null || conn.isClosed()) {
				_LOG.error("#searchCount(): connection null hoac khong the ket noi!");
				return 0;
			}
			
			StringBuilder query = new StringBuilder("SELECT COUNT(*) FROM user WHERE user MATCH '" + str + "*'");
			
			ps = conn.prepareStatement(query.toString());
			rs = ps.executeQuery();
			
			int count = 0;
			if (rs.next()) {
				count = rs.getInt(1);
			}
			
			return count;
		} catch (Exception e) {
			_LOG.error("#searchCount(): " + e.getMessage(), e);
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
		
		return 0;
	}
	
	public List<User> search(String str, int start, int rowCount, String orderColumn, String orderType) {
		if (FriendUtil.isNullOrEmpty(str))
			return getAll();
		
		try {
			conn = DataSource.getConnection();
			
			if (conn == null || conn.isClosed()) {
				_LOG.error("#search(?, ?, ?, ?, ?): connection null hoac khong the ket noi!");
				return null;
			}
			
			StringBuilder query = new StringBuilder("SELECT rowid, id, username, password, ");
			query.append("nicename, email, address, permission FROM user WHERE user MATCH '" + str + "*'");
			
			if (!FriendUtil.isNullOrEmpty(orderColumn) && !FriendUtil.isNullOrEmpty(orderType))
				query.append(" ORDER BY " + orderColumn + " " + orderType);
			else
				query.append(" ORDER BY rowid DESC");
			
			if (rowCount > 0)
				query.append(" LIMIT " + start + ", " + rowCount);
			
			ps = conn.prepareStatement(query.toString());
			rs = ps.executeQuery();
			
			List<User> list = new ArrayList<User>();
			User temp = null;
			while (rs.next()) {
				temp = new User();
				temp.setRowid(rs.getInt("rowid"));
				temp.setId(rs.getString("id"));
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
			_LOG.error("#search(?, ?, ?, ?, ?): " + e.getMessage(), e);
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
	
	public List<User> getByLimit(int start, int rowCount, String orderColumn, String orderType) {
		try {
			conn = DataSource.getConnection();
			
			if (conn == null || conn.isClosed()) {
				_LOG.error("#getByLimit(?, ?, ?, ?): connection null hoac khong the ket noi!");
				return null;
			}
			
			StringBuilder query = new StringBuilder("SELECT rowid, id, username, password, ");
			query.append("nicename, email, address, permission FROM user");
			
			if (!FriendUtil.isNullOrEmpty(orderColumn) && !FriendUtil.isNullOrEmpty(orderType))
				query.append(" ORDER BY " + orderColumn + " " + orderType);
			else
				query.append(" ORDER BY rowid DESC");
			
			if (rowCount > 0)
				query.append(" LIMIT " + start + ", " + rowCount);
			
			ps = conn.prepareStatement(query.toString());
			rs = ps.executeQuery();
			
			List<User> list = new ArrayList<User>();
			User temp = null;
			while (rs.next()) {
				temp = new User();
				temp.setRowid(rs.getInt("rowid"));
				temp.setId(rs.getString("id"));
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
			_LOG.error("#getByLimit(?, ?, ?, ?): " + e.getMessage(), e);
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
	
	public static void main(String[] args) {
		UserDbHandle hd = new UserDbHandle();
		List<User> list = hd.search("a", 2, 1, "username", "DESC");
		
		System.out.println(list.size());
	}
	
}
