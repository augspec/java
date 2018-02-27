package com.aug.db.handle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.aug.db.DataSource;
import com.aug.db.entities.Friend;

public class FriendDbHandle implements DbHandleAPI<Friend> {

	private static final Logger _LOG = Logger.getLogger(FriendDbHandle.class);
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public boolean create(Friend object) {
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
			query.append("friend(name, phone, email, address, _group, state, district, ");
			query.append("wards, invite_status, money, description, username) ");
			query.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, object.getName());
			ps.setString(2, object.getPhone());
			ps.setString(3, object.getEmail());
			ps.setString(4, object.getAddress());
			ps.setString(5, object.getGroup());
			ps.setString(6, object.getState());
			ps.setString(7, object.getDistrict());
			ps.setString(8, object.getWards());
			ps.setString(9, object.getInviteStatus());
			ps.setString(10, object.getMoney());
			ps.setString(11, object.getDescription());
			ps.setString(12, object.getUsername());
			
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
	public boolean update(Friend object) {
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
			
			StringBuilder query = new StringBuilder("UPDATE friend SET name=?, phone=?, email=?, ");
			query.append("address=?, _group=?, state=?, district=?, wards=?, invite_status=?, ");
			query.append("money=?, description=?, username=? WHERE rowid=?");
			
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, object.getName());
			ps.setString(2, object.getPhone());
			ps.setString(3, object.getEmail());
			ps.setString(4, object.getAddress());
			ps.setString(5, object.getGroup());
			ps.setString(6, object.getState());
			ps.setString(7, object.getDistrict());
			ps.setString(8, object.getWards());
			ps.setString(9, object.getInviteStatus());
			ps.setString(10, object.getMoney());
			ps.setString(11, object.getDescription());
			ps.setString(12, object.getUsername());
			ps.setInt(13, object.getRowid());
			
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
	public boolean delete(Friend object) {
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
			
			StringBuilder query = new StringBuilder("DELETE FROM friend WHERE rowid=?");
			
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
	public List<Friend> getAll() {
		try {
			conn = DataSource.getConnection();
			
			if (conn == null || conn.isClosed()) {
				_LOG.error("#getAll(?): connection null hoac khong the ket noi!");
				return null;
			}
			
			StringBuilder query = new StringBuilder("SELECT rowid, name, phone, email, address, _group, ");
			query.append("state, district, wards, invite_status, money, description, username FROM friend");
			
			ps = conn.prepareStatement(query.toString());
			rs = ps.executeQuery();
			
			List<Friend> list = new ArrayList<Friend>();
			Friend temp = null;
			while (rs.next()) {
				temp = new Friend();
				temp.setRowid(rs.getInt("rowid"));
				temp.setName(rs.getString("name"));
				temp.setPhone(rs.getString("phone"));
				temp.setEmail(rs.getString("email"));
				temp.setAddress(rs.getString("address"));
				temp.setGroup(rs.getString("_group"));
				temp.setState(rs.getString("state"));
				temp.setDistrict(rs.getString("district"));
				temp.setWards(rs.getString("wards"));
				temp.setInviteStatus(rs.getString("invite_status"));
				temp.setMoney(rs.getString("money"));
				temp.setDescription(rs.getString("description"));
				temp.setUsername(rs.getString("username"));
				
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
