package com.bkav.bkavcoreca.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.bkav.bkavcoreca.utils.Constant;

public class CertUserDAO {
	static final Logger LOGGER = Logger.getLogger(CertUserDAO.class);

	public static int errorCode = 0;
	private static final String STM_INSERT_CERT_USER = "INSERT INTO cert_user values(?, ?, ?, ?, ?, ?, ?)";
	@SuppressWarnings("unused")
	private static final String STM_GET_USER = "SELECT * FROM user WHERE email=? AND password=?";
	@SuppressWarnings("unused")
	private static final String STM_GET_USER_ = "SELECT * FROM user WHERE email=?";
	@SuppressWarnings("unused")
	private static final String STM_UPDATE_CERT_USER = "UPDATE user "
			+ " SET cert_common_name=?, cert_subject_dn=?, cert_valid_from=?, cert_valid_to=?, cert_serial_number=?"
			+ " WHERE email=?";

	public static final int DUPLICATE_SERIAL_TRUE = 0;
	public static final int DUPLICATE_SERIAL_FALSE = 1;
	public static final int DUPLICATE_SERIAL_UNDEFINED = 2;
	
	public static void main(String[] args) {

		System.out.println(getCertUserByEmail("corecademo").size());

	}

	
	public static int isDuplicateBySerialNumber(String serial_number) {
		int result = DUPLICATE_SERIAL_FALSE;
		Connection conn = MySQLConnector.popConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("SELECT cert_serial_number FROM cert_user WHERE cert_serial_number=?");
			ps.setString(1, serial_number);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				if (serial_number.equals(rs.getString("cert_serial_number"))) {
					result = DUPLICATE_SERIAL_TRUE;
				} 
			}
			
			ps.close();
		} catch (SQLException e) {
			LOGGER.error("SELECT Cert_User by serial =>" + e);			
			result = DUPLICATE_SERIAL_UNDEFINED;
		} finally {
			MySQLConnector.closeStatement(ps);
			MySQLConnector.putConnection(conn);
		}		
		
		return result;		
	}


	public static boolean delete(int id) {
		
		boolean result = true;
		
		Connection conn = MySQLConnector.popConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("DELETE FROM cert_user where id=?");

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error("Delete Cert_User =>" + e);
			result = false;
		} finally {
			MySQLConnector.closeStatement(ps);
			MySQLConnector.putConnection(conn);
		}
		
		return result;
	}


	public static boolean insert(CertUser certUser) {
		boolean result = true;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = MySQLConnector.popConnection();
			ps = conn.prepareStatement(STM_INSERT_CERT_USER);
			ps.setInt(1, 0);
			ps.setInt(2, certUser.getUser().getId());
			ps.setString(3, certUser.getCertCommonName());
			ps.setString(4, certUser.getCertSubjectDN());

			long validFrom = certUser.getCertValidFrom() != null
					? certUser.getCertValidFrom().getTime() : -1;
			if (validFrom > -1) {
				ps.setTimestamp(5, new java.sql.Timestamp(
						certUser.getCertValidFrom().getTime()));
			} else {
				ps.setDate(5, null);
			}
			
			long validTo = certUser.getCertValidTo() != null
					? certUser.getCertValidTo().getTime() : -1;
			if (validTo > -1) {
				ps.setTimestamp(6, new java.sql.Timestamp(
						certUser.getCertValidTo().getTime()));
			} else {
				ps.setDate(6, null);
			}
			
			ps.setString(7, certUser.getCertSerialNumber());
			ps.executeUpdate();

			ps.close();
		} catch (Exception ex) {
			LOGGER.error("INSERT CERT USER FAILE:\n--> " + ex);
			result = false;

		} finally {
			MySQLConnector.closeStatement(ps);
			MySQLConnector.putConnection(conn);
		}

		return result;
	}

	/**
	 * Get user from username and password
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public static List<CertUser> getCertUserByEmail(String email) {
		
		List<CertUser> certUsers = new ArrayList<CertUser>();
		
		Connection conn = MySQLConnector.popConnection();
		PreparedStatement ps = null;
		
		if (conn == null) {
			errorCode = Constant.CANNOT_CONNECT_DB;
			return null;
		}
		
		try {
			ps = conn.prepareStatement("select cert_user.id, cert_user.cert_common_name, cert_user.cert_serial_number, "
					+ "cert_user.cert_subject_dn, cert_user.cert_valid_from, cert_user.cert_valid_to "
					+ " from user INNER JOIN cert_user ON user.id = cert_user.user_id " 
					+ " where user.email=?");
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				CertUser certUser = null;
				int id = rs.getInt("id");
				String certCommonName = rs.getString("cert_common_name");
				String certSubjectDN = rs.getString("cert_subject_dn");			
				Date certValidFrom = rs.getDate("cert_valid_from");
				Date certValidTo = rs.getDate("cert_valid_to");
				String certSerialNumber = rs.getString("cert_serial_number");
				
				certUser = new CertUser(id, certCommonName, certSubjectDN, certValidFrom, certValidTo, certSerialNumber);
				certUsers.add(certUser);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnector.closeStatement(ps);
			MySQLConnector.putConnection(conn);
		}
		
		return certUsers;
	}
	
}
