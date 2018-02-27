package com.aug.db.handle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.aug.db.DataSource;
import com.aug.db.entities.Region;

public class RegionDbHandle implements DbHandleAPI<Region> {

	private static final Logger _LOG = Logger.getLogger(RegionDbHandle.class);
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public boolean create(Region object) {
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
			query.append("region(id, name, code, active, parent_id) ");
			query.append("VALUES(?, ?, ?, ?, ?)");
			
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, object.getId());
			ps.setString(2, object.getName());
			ps.setString(3, object.getCode());
			ps.setString(4, object.getActive());
			ps.setString(5, object.getParentId());
			
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
	public boolean update(Region object) {
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
			
			StringBuilder query = new StringBuilder("UPDATE region SET name=?, code=?, active=?, ");
			query.append("parent_id=? WHERE id=? ");
			
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, object.getName());
			ps.setString(2, object.getCode());
			ps.setString(3, object.getActive());
			ps.setString(4, object.getParentId());
			ps.setString(5, object.getId());
			
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
	public boolean delete(Region object) {
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
			
			StringBuilder query = new StringBuilder("DELETE FROM region WHERE id=?");
			
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
	public List<Region> getAll() {
		try {
			conn = DataSource.getConnection();
			
			if (conn == null || conn.isClosed()) {
				_LOG.error("#getAll(?): connection null hoac khong the ket noi!");
				return null;
			}
			
			StringBuilder query = new StringBuilder("SELECT id, name, code, ");
			query.append("active, parent_id FROM region");
			
			ps = conn.prepareStatement(query.toString());
			rs = ps.executeQuery();
			
			List<Region> list = new ArrayList<Region>();
			Region temp = null;
			while (rs.next()) {
				temp = new Region();
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setCode(rs.getString("code"));
				temp.setActive(rs.getString("active"));
				temp.setParentId(rs.getString("parent_id"));
				
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
