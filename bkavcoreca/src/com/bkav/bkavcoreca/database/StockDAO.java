package com.bkav.bkavcoreca.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Xử lý tương tác thêm, sửa, xóa, cập nhật dữ liệu vào bảng stock trong DB
 * 
 * @author HungDMc
 *
 */
public class StockDAO {
	
	private static final Logger _LOG = Logger.getLogger(StockDAO.class);
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public boolean insert(Stock stock) {
		conn = MySQLConnector.popConnection();
		
		try {
			StringBuilder query = new StringBuilder("INSERT INTO stock (type, name, amounts, command_type, ");
			query.append("price, market, client_data_signed, server_data_signed, transaction_time) ");
			query.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, stock.getType());
			ps.setString(2, stock.getName());
			ps.setInt(3, stock.getAmounts());
			ps.setString(4, stock.getCommandType());
			ps.setDouble(5, stock.getPrice());
			ps.setString(6, stock.getMarket());
			ps.setString(7, stock.getClientDataSigned());
			ps.setString(8, stock.getServerDataSigned());
			ps.setTimestamp(9, new Timestamp(stock.getTransactionTime().getTime()));
			
			int affected = ps.executeUpdate();
			return affected > 0;
		} catch (Exception e) {
			_LOG.error("#insert(?): Exception occurs...\r\n==> ", e);
		} finally {
			MySQLConnector.putConnection(conn);
			
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					_LOG.error("#insert(?): Cannot close statement...\r\n==> ", e);
				}
			}
		}
		return false;
	}
	
	public long insertGetGenerateId(Stock stock) {
		long result = -1;
		conn = MySQLConnector.popConnection();
		
		try {
			StringBuilder query = new StringBuilder("INSERT INTO stock (type, name, amounts, command_type, ");
			query.append("price, market, client_data_signed, server_data_signed, transaction_time) ");
			query.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, stock.getType());
			ps.setString(2, stock.getName());
			ps.setInt(3, stock.getAmounts());
			ps.setString(4, stock.getCommandType());
			ps.setDouble(5, stock.getPrice());
			ps.setString(6, stock.getMarket());
			ps.setString(7, stock.getClientDataSigned());
			ps.setString(8, stock.getServerDataSigned());
			ps.setTimestamp(9, new Timestamp(stock.getTransactionTime().getTime()));
			
			int affected = ps.executeUpdate();
			if (affected > 0) {
				rs = ps.getGeneratedKeys();
				if (rs.next())
					result = rs.getLong(1);
			}
		} catch (Exception e) {
			_LOG.error("#insertGetGenerateId(?): Exception occurs...\r\n==> ", e);
		} finally {
			MySQLConnector.putConnection(conn);
			
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					_LOG.error("#insertGetGenerateId(?): Cannot close statement...\r\n==> ", e);
				}
			}
		}
		return result;
	}
	
	public long count() {
		long result = 0;
		conn = MySQLConnector.popConnection();
		
		try {
			ps = conn.prepareStatement("SELECT COUNT(*) FROM stock");
			rs = ps.executeQuery();
			
			if (rs.next()) {
				result = rs.getLong(1);
			}
		} catch (Exception e) {
			_LOG.error("#count(): Exception occurs...\r\n==> ", e);
		} finally {
			MySQLConnector.putConnection(conn);
			
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					_LOG.error("#count(): Cannot close statement...\r\n==> ", e);
				}
			}
			
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					_LOG.error("#count(): Cannot close result set...\r\n==> ", e);
				}
			}
		}
		return result;
	}
	
	public Stock getStock(int id) {
		conn = MySQLConnector.popConnection();
		
		try {
			ps = conn.prepareStatement("SELECT * FROM stock WHERE stock_id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			Stock stock = null;
			if (rs.next()) {
				stock = new Stock();
				stock.setStockId(rs.getLong("stock_id"));
				stock.setType(rs.getString("type"));
				stock.setName(rs.getString("name"));
				stock.setAmounts(rs.getInt("amounts"));
				stock.setCommandType(rs.getString("command_type"));
				stock.setPrice(rs.getDouble("price"));
				stock.setMarket(rs.getString("market"));
				stock.setClientDataSigned(rs.getString("client_data_signed"));
				stock.setServerDataSigned(rs.getString("server_data_signed"));
				stock.setTransactionTime(new Date(rs.getTimestamp("transaction_time").getTime()));
			}
			return stock;
		} catch (Exception e) {
			_LOG.error("#getStock(?): Exception occurs...\r\n==> ", e);
		} finally {
			MySQLConnector.putConnection(conn);
			
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					_LOG.error("#getStock(?): Cannot close statement...\r\n==> ", e);
				}
			}
			
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					_LOG.error("#getStock(?): Cannot close result set...\r\n==> ", e);
				}
			}
		}
		return null;
	}
	
	public List<Stock> getAllStock() {
		List<Stock> result = new ArrayList<Stock>();
		
		conn = MySQLConnector.popConnection();
		
		try {
			ps = conn.prepareStatement("SELECT * FROM stock ORDER BY stock_id DESC");
			rs = ps.executeQuery();
			
			Stock stock = null;
			while (rs.next()) {
				stock = new Stock();
				stock.setStockId(rs.getLong("stock_id"));
				stock.setType(rs.getString("type"));
				stock.setName(rs.getString("name"));
				stock.setAmounts(rs.getInt("amounts"));
				stock.setCommandType(rs.getString("command_type"));
				stock.setPrice(rs.getDouble("price"));
				stock.setMarket(rs.getString("market"));
				stock.setClientDataSigned(rs.getString("client_data_signed"));
				stock.setServerDataSigned(rs.getString("server_data_signed"));
				stock.setTransactionTime(new Date(rs.getTimestamp("transaction_time").getTime()));
				
				result.add(stock);
			}
		} catch (Exception e) {
			_LOG.error("#getAllStock(): Exception occurs...\r\n==> ", e);
		} finally {
			MySQLConnector.putConnection(conn);
			
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					_LOG.error("#getAllStock(): Cannot close statement...\r\n==> ", e);
				}
			}
			
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					_LOG.error("#getAllStock(): Cannot close result set...\r\n==> ", e);
				}
			}
		}
		return result;
	}
	
	public List<Stock> getStocks(int start, int limit) {
		List<Stock> result = new ArrayList<Stock>();
		
		conn = MySQLConnector.popConnection();
		
		try {
			ps = conn.prepareStatement("SELECT * FROM stock ORDER BY stock_id DESC LIMIT ?, ?");
			ps.setInt(1, start);
			ps.setInt(2, limit);
			rs = ps.executeQuery();
			
			Stock stock = null;
			while (rs.next()) {
				stock = new Stock();
				stock.setStockId(rs.getLong("stock_id"));
				stock.setType(rs.getString("type"));
				stock.setName(rs.getString("name"));
				stock.setAmounts(rs.getInt("amounts"));
				stock.setCommandType(rs.getString("command_type"));
				stock.setPrice(rs.getDouble("price"));
				stock.setMarket(rs.getString("market"));
				stock.setClientDataSigned(rs.getString("client_data_signed"));
				stock.setServerDataSigned(rs.getString("server_data_signed"));
				stock.setTransactionTime(new Date(rs.getTimestamp("transaction_time").getTime()));
				
				result.add(stock);
			}
		} catch (Exception e) {
			_LOG.error("#getStocks(?, ?): Exception occurs...\r\n==> ", e);
		} finally {
			MySQLConnector.putConnection(conn);
			
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					_LOG.error("#getStocks(?, ?): Cannot close statement...\r\n==> ", e);
				}
			}
			
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					_LOG.error("#getStocks(?, ?): Cannot close result set...\r\n==> ", e);
				}
			}
		}
		return result;
	}
}
