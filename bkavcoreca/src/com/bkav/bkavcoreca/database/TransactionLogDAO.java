package com.bkav.bkavcoreca.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

public class TransactionLogDAO {
	// Loger log4j
	static final Logger LOGGER = Logger.getLogger(TransactionLogDAO.class);

	private static final String STM_INSERT_LOG = "INSERT INTO transactionlog values(?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String STM_QUERY_ALL_LOG = "SELECT * FROM transactionlog WHERE userid=? ORDER BY id DESC LIMIT ?,?";
	private static final String STM_REMOVE_LOG = "DELETE FROM transactionlog WHERE id = ?";
	private static final String STM_QUERY_LOG = "SELECT * FROM transactionlog WHERE id=?";

	public static TransactionLog queryLog(int id) {
		TransactionLog log = null;
		Connection connection = MySQLConnector.popConnection();
		if (connection != null) {
			PreparedStatement statement = null;
			try {
				statement = connection.prepareStatement(STM_QUERY_LOG);
				statement.setInt(1, id);

				ResultSet resultSet = statement.executeQuery();

				if (resultSet.next()) {
					TransactionLog userLog = new TransactionLog();
					userLog.setId(resultSet.getInt("id"));
					userLog.setFileName(resultSet.getString("filename"));
					userLog.setTranTime(new Date(
							resultSet.getTimestamp("trantime").getTime()));
					userLog.setFileSize(resultSet.getLong("filesize"));
					userLog.setFileType(resultSet.getString("filetype"));
					userLog.setSignedPath(resultSet.getString("signedpath"));
					log = userLog;
				}
			} catch (SQLException e) {
				LOGGER.error("Query log with id = " + id + " falsed.");
			} finally {
				MySQLConnector.closeStatement(statement);
				MySQLConnector.putConnection(connection);
			}
		}
		return log;
	}

	/**
	 * Get all user log record
	 * 
	 * @param idUser
	 * @param date
	 * @return
	 */
	public static ArrayList<TransactionLog> listUserLog(int idUser, int index,
			int max) {
		ArrayList<TransactionLog> result = new ArrayList<TransactionLog>();

		Connection connection = MySQLConnector.popConnection();
		if (connection != null) {
			PreparedStatement statement = null;
			try {
				statement = connection.prepareStatement(STM_QUERY_ALL_LOG);
				statement.setInt(1, idUser);
				statement.setInt(2, index);
				statement.setInt(3, max);

				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next()) {
					TransactionLog userLog = new TransactionLog();
					userLog.setId(resultSet.getInt("id"));
					userLog.setFileName(resultSet.getString("filename"));
					userLog.setTranTime(new Date(
							resultSet.getTimestamp("trantime").getTime()));
					double size = resultSet.getLong("filesize");
					String[] sizeNames = { "Bytes", "KBs", "MBs", "GBs" };
					int indexSize = 0;
					while (size > 1024 && indexSize < sizeNames.length - 1) {
						size = size * 1.0 / 1024;
						indexSize++;
					}
					DecimalFormat df = new DecimalFormat("##,##0.0#");
					userLog.setFileSizeText(
							df.format(size) + " " + sizeNames[indexSize]);
					userLog.setFileSize(resultSet.getLong("filesize"));
					userLog.setFileType(resultSet.getString("filetype"));
					userLog.setSignedPath(resultSet.getString("signedpath"));
					result.add(userLog);
				}
			} catch (SQLException e) {
				LOGGER.error("CANNOT GET LIST USER LOG FOR USER WITH ID "
						+ idUser + "\n-->" + e.getMessage());
			} finally {
				MySQLConnector.closeStatement(statement);
				MySQLConnector.putConnection(connection);
			}
		}

		return result;
	}

	/**
	 * Add new log record
	 * 
	 * @param userLog
	 * @return
	 */
	public static long insertUserLog(TransactionLog userLog) {
		Connection connection = MySQLConnector.popConnection();
		if (connection != null) {
			PreparedStatement statement = null;
			try {
				statement = connection.prepareStatement(STM_INSERT_LOG,
                        Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, userLog.getId());
				statement.setInt(2, userLog.getUserId());
				long tranTime = userLog.getTranTime() != null
						? userLog.getTranTime().getTime() : -1;
				if (tranTime > -1) {
					statement.setTimestamp(3, new java.sql.Timestamp(
							userLog.getTranTime().getTime()));
				} else {
					statement.setDate(3, null);
				}
				statement.setString(4, userLog.getFileName());
				statement.setLong(5, userLog.getFileSize());
				statement.setString(6, userLog.getFileType());
				statement.setString(7, userLog.getSignedPath());
				statement.setInt(8, userLog.getStatus());

				int affectedRows = statement.executeUpdate();

				if (affectedRows == 0) {
					return -1;
				}

				try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						return generatedKeys.getLong(1);
					} else {
						return -1;
					}
				}
			} catch (SQLException e) {
				LOGGER.error("CANNOT INSERT USER LOG " + e.getMessage());
			} finally {
				MySQLConnector.closeStatement(statement);
				MySQLConnector.putConnection(connection);
			}
		}
		return -1;
	}

	/**
	 * Remove all user log record
	 * 
	 * @param logId
	 */
	public static void deleteUserLog(int logId) {
		Connection connection = MySQLConnector.popConnection();
		if (connection != null) {
			PreparedStatement statement = null;
			try {
				statement = connection.prepareStatement(STM_REMOVE_LOG);
				statement.setInt(1, logId);
				statement.execute();
			} catch (SQLException e) {
				LOGGER.error("CANNOT DELETE USER LOG");
			} finally {
				MySQLConnector.closeStatement(statement);
				MySQLConnector.putConnection(connection);
			}
		}
	}
}
