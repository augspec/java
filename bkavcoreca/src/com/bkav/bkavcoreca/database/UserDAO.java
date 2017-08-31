package com.bkav.bkavcoreca.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Logger;

import com.bkav.bkavcoreca.utils.Constant;
import com.bkav.bkavcoreca.utils.HashUtil;
import com.bkav.bkavcoreca.xml.InfoCertificate;

public class UserDAO {
	static final Logger LOGGER = Logger.getLogger(UserDAO.class);

	public static int errorCode = 0;
	private static final String STM_INSERT_USER = "INSERT INTO user values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String STM_GET_USER = "SELECT * FROM user WHERE email=? AND password=?";
	private static final String STM_GET_USER_ = "SELECT * FROM user WHERE email=?";
	private static final String STM_UPDATE_CERT_USER = "UPDATE user "
			+ " SET cert_common_name=?, cert_subject_dn=?, cert_valid_from=?, cert_valid_to=?, cert_serial_number=?"
			+ " WHERE email=?";

	public static void main(String[] args) {
		User user = getUser("admin", "123456");
		System.out.println(user.getCertCommonName());
//		System.out.println(isEmpty());
	}

	public static void insertDefaultUser() {
//		String cert = "MIIENjCCAx6gAwIBAgIIHWN9ADlE21gwDQYJKoZIhvcNAQEFBQAwND"
//				+ "EPMA0GA1UEAwwGVGVzdENBMRQwEgYDVQQKDAtUZXN0Q0EgQ29ycDELMAkG"
//				+ "A1UEBhMCVk4wHhcNMTYwMzE2MTUwOTI3WhcNMjEwMzE1MTUwOTI3WjBzMR"
//				+ "4wHAYKCZImiZPyLGQBAQwOTVNUOjAxMjM0NTY3ODkxFzAVBgNVBAMMDlZT"
//				+ "RCBTU0wgQ2xpZW50MRcwFQYDVQQHDA5IYWkgQsOgIFRyxrBuZzESMBAGA1"
//				+ "UECAwJSMOgIE7hu5lpMQswCQYDVQQGEwJWTjCBnzANBgkqhkiG9w0BAQEF"
//				+ "AAOBjQAwgYkCgYEAnS/QSergLgUNjM4q9kbOYL6dicH3sPnIXJsbFApgMM"
//				+ "WvTO3sIyK/f7OrcrcjxcnEbsnL59IF8Vsao2jhOPRj1dRzP0CtzHVzSxix"
//				+ "IwdrHWN1xk69blKJzh3GgB42o9aZg8wRJ8nloay/cN/WVAezAHy/sDs0zm"
//				+ "npARzm7JW68fkCAwEAAaOCAY8wggGLME0GCCsGAQUFBwEBBEEwPzA9Bggr"
//				+ "BgEFBQcwAYYxaHR0cDovL2xvY2FsaG9zdDo4MDgwL2VqYmNhL3B1YmxpY3"
//				+ "dlYi9zdGF0dXMvb2NzcDAdBgNVHQ4EFgQUomcmV+bgq787eqIEoiRSTlon"
//				+ "/v8wDAYDVR0TAQH/BAIwADAfBgNVHSMEGDAWgBSWXGSq3lsEdlUn+3ycA8"
//				+ "PWBjQUBzAXBgNVHSAEEDAOMAwGCisGAQQB1nkCBQEwgaYGA1UdHwSBnjCB"
//				+ "mzCBmKBhoF+GXWh0dHA6Ly9sb2NhbGhvc3Q6ODA4MC9lamJjYS9wdWJsaW"
//				+ "N3ZWIvd2ViZGlzdC9jZXJ0ZGlzdD9jbWQ9Y3JsJmlzc3Vlcj1DTj1UZXN0"
//				+ "Q0EsTz1BbmFUb20sQz1TRaIzpDEwLzEPMA0GA1UEAwwGVGVzdENBMQ8wDQ"
//				+ "YDVQQKDAZBbmFUb20xCzAJBgNVBAYTAlNFMAsGA1UdDwQEAwIHgDAdBgNV"
//				+ "HSUEFjAUBggrBgEFBQcDAQYIKwYBBQUHAwIwDQYJKoZIhvcNAQEFBQADgg"
//				+ "EBAG4+dGymHfQvxlzF28UPkYiCd7f73iaEsfEy/dRPmCPwpdq82FuwQP5Y"
//				+ "bQCOlNk8N61lUR8tCWhn980OirDppT2U5S7g5/mUS4eTdOnXAU1dKjeG/z"
//				+ "tkv4hok06RuQg9qrP8+uqZ6KoIsc7rl86LNkOIedTrnsCz36nzmI2WUxj3"
//				+ "5imZDnYme8mT/HfQWvMdcigBCWMUYcHhHKSxyKLC+JNbAuqSVUH/C73ey8"
//				+ "EYL5WfYualTPWdOT50h87tqyrUQ2pWTdzus7vpPQcIiZBUk4ypXj26ZxPn"
//				+ "WyR2rXL0mho51Dw/wveELx39l4VisuykuLm1sI+ZV7JlftU25XhguNc=";
//		String password = HashUtil.hash("123456", HashUtil.SHA_256);
//		User user = new User(0, "thangntc@bkav.com", password, "Ngo Thien Thang",
//				"0975025269", "Ban ANM/Ban HTCA/Phòng CA Core", "", cert, 0);
//		insert(user);
	}

	
	public static boolean updateInfoCertByEmail(InfoCertificate infoCertificate, String email) {
		boolean result = true;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = MySQLConnector.popConnection();
			ps = conn.prepareStatement(STM_UPDATE_CERT_USER);
			ps.setString(1, infoCertificate.getCommonName());
			ps.setString(2, infoCertificate.getSubjectDN());
			
			long validFrom = infoCertificate.getValidFrom() != null
					? infoCertificate.getValidFrom().getTime() : -1;
			if (validFrom > -1) {
				ps.setTimestamp(3, new java.sql.Timestamp(
						infoCertificate.getValidFrom().getTime()));
			} else {
				ps.setDate(3, null);
			}
			
			long validTo = infoCertificate.getValidTo() != null
					? infoCertificate.getValidTo().getTime() : -1;
			if (validTo > -1) {
				ps.setTimestamp(4, new java.sql.Timestamp(
						infoCertificate.getValidTo().getTime()));
			} else {
				ps.setDate(4, null);
			}
			ps.setString(5, infoCertificate.getSerialNumber());
			ps.setString(6, email);
			ps.executeUpdate();

			ps.close();
		} catch (Exception ex) {
			LOGGER.error("INSERT FAILE:\n--> " + ex.getMessage());
			result = false;
		} finally {
			MySQLConnector.closeStatement(ps);
			MySQLConnector.putConnection(conn);
		}

		return result;
	}
	/**
	 * Check user table is empty
	 * 
	 * @return
	 */
	public static boolean isEmpty() {
		boolean check = true;
		Connection conn = MySQLConnector.popConnection();
		PreparedStatement ps = null;
		if (conn == null) {
			LOGGER.error("CANNOT CONNECT TO DATABASE SERVER");
			return check;
		}
		try {
			ps = conn.prepareStatement("SELECT * FROM user WHERE email=? and password=?");
			ps.setString(1, "thangntc@bkav.com");
			String hash = HashUtil.hash("123456", HashUtil.SHA_256);
			ps.setString(2, hash);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return false;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnector.closeStatement(ps);
			MySQLConnector.putConnection(conn);
		}
		return check;
	}

	/**
	 * Check exist user
	 * 
	 * @param userName
	 * @return
	 */
	public static int checkUser(String userName) {
		int result = Constant.CREATE_COMPONENT_SUCCESS;
		Connection conn = null;
		PreparedStatement ps = null;
		try {

			if (!"".equalsIgnoreCase(userName)) {
				conn = MySQLConnector.popConnection();
				if (conn == null) {
					errorCode = Constant.CANNOT_CONNECT_DB;
				}
				ps = conn.prepareStatement(
						"SELECT id FROM USER WHERE username = ?");
				ps.setString(1, userName);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					result = Constant.USERNAME_ALREADY_EXIST;
				}
				rs.close();
				ps.close();
			} else {
				result = Constant.USERNAME_NULL;
			}
		} catch (Exception ex) {
			LOGGER.error("DATABASE CONNECTION ERROR: " + ex.getMessage());
			result = Constant.CREATE_COMPONENT_FAILED;
		} finally {
			MySQLConnector.closeStatement(ps);
			MySQLConnector.putConnection(conn);
		}
		return result;
	}

	/**
	 * Remove monitor user
	 * 
	 * @param id
	 * @return
	 */
	public static int delete(int id) {
		Connection conn = MySQLConnector.popConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("DELETE FROM USER WHERE id = ?");

			ps.setInt(1, id);
			int rs = ps.executeUpdate();

			TransactionLogDAO.deleteUserLog(id);

			return rs;
		} catch (SQLException e) {
			return 0;
		} finally {
			MySQLConnector.closeStatement(ps);
			MySQLConnector.putConnection(conn);
		}
	}

	/**
	 * Update user information
	 * 
	 * @param user
	 * @return
	 */
	public static int update(User user) {
		Connection conn = MySQLConnector.popConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("UPDATE user SET pass=?, sodutienmat=?,"
					+ " fullname=?, tienungtruoc=?, email=?, taikhoangiaodich=?,"
					+ " soducothegiaodich=?, khoiluongcothemua=?, tientreogoc=? WHERE id = ?");
			int rs = ps.executeUpdate();

			return rs;
		} catch (SQLException e) {
			LOGGER.error(
					"CANNOT UPDATE USER INFORMATION: \n-->" + e.getMessage());
			return 0;
		} finally {
			MySQLConnector.closeStatement(ps);
			MySQLConnector.putConnection(conn);
		}
	}

	/**
	 * Add new user
	 * 
	 * @param user
	 * @return
	 */
	public static int insert(User user) {
		int result = Constant.CREATE_COMPONENT_SUCCESS;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = MySQLConnector.popConnection();
			ps = conn.prepareStatement(STM_INSERT_USER);
			ps.setInt(1, 0);
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getFullName());
			ps.setString(5, user.getPhoneNumber());
			ps.setString(6, user.getDepartment());
			ps.setString(7, user.getImage());
			ps.setString(8, user.getCert());
			ps.setInt(9, user.getIsAdmin());
			ps.executeUpdate();

			ps.close();
		} catch (Exception ex) {
			LOGGER.error("INSERT USER FAILE:\n--> " + ex.getMessage());
			result = Constant.CREATE_COMPONENT_FAILED;
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
	public static User getUser(String userName, String password) {
		Connection conn = MySQLConnector.popConnection();
		User user = null;
		PreparedStatement ps = null;
		if (conn == null) {
			errorCode = Constant.CANNOT_CONNECT_DB;
			return null;
		}
		try {
			ps = conn.prepareStatement(STM_GET_USER);
			ps.setString(1, userName);
			String hash = HashUtil.hash(password, HashUtil.SHA_256);
			ps.setString(2, hash);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String email = rs.getString("email");
				String fullName = rs.getString("fullname");
				String phone = rs.getString("phone");
				String department = rs.getString("department");
				String image = rs.getString("image");
				String cert = rs.getString("cert");
				int isAdmin = rs.getInt("isadmin");
				String certCommonName = rs.getString("cert_common_name");
				String certSubjectDN = rs.getString("cert_subject_dn");			
				Date certValidFrom = rs.getDate("cert_valid_from");
				Date certValidTo = rs.getDate("cert_valid_to");
				String certSerialNumber = rs.getString("cert_serial_number");
				
				user = new User(id, email, "", fullName, phone, department,
						image, cert, isAdmin, certCommonName, certSubjectDN,
						certValidFrom, certValidTo, certSerialNumber);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnector.closeStatement(ps);
			MySQLConnector.putConnection(conn);
		}
		return user;
	}

	public static User getUser(String userName) {
		Connection conn = MySQLConnector.popConnection();
		User user = null;
		PreparedStatement ps = null;
		if (conn == null) {
			errorCode = Constant.CANNOT_CONNECT_DB;
			return null;
		}
		try {
			ps = conn.prepareStatement(STM_GET_USER_);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String email = rs.getString("email");
				String fullName = rs.getString("fullname");
				String phone = rs.getString("phone");
				String department = rs.getString("department");
				String image = rs.getString("image");
				String cert = rs.getString("cert");
				int isAdmin = rs.getInt("isadmin");
				String certCommonName = rs.getString("cert_common_name");
				String certSubjectDN = rs.getString("cert_subject_dn");			
				Date certValidFrom = rs.getDate("cert_valid_from");
				Date certValidTo = rs.getDate("cert_valid_to");
				String certSerialNumber = rs.getString("cert_serial_number");
				
				user = new User(id, email, "", fullName, phone, department,
						image, cert, isAdmin, certCommonName, certSubjectDN,
						certValidFrom, certValidTo, certSerialNumber);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnector.closeStatement(ps);
			MySQLConnector.putConnection(conn);
		}
		return user;
	}
	
//	/**
//	 * Get user from user id
//	 * 
//	 * @param id
//	 * @return
//	 */
//	public static User getUser(int id) {
//		Connection conn = MySQLConnector.popConnection();
//		User user = null;
//		PreparedStatement ps = null;
//		if (conn == null) {
//			errorCode = Constant.CANNOT_CONNECT_DB;
//			return null;
//		}
//		try {
//			ps = conn.prepareStatement("SELECT * FROM USER WHERE id = ?");
//			ps.setInt(1, id);
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				String userName = rs.getString("username");
//				String password = rs.getString("pass");
//				String fullName = rs.getString("fullname");
//				String email = rs.getString("email");
//				String taikhoangiaodich = rs.getString("taikhoangiaodich");
//				int soDuTienMat = rs.getInt("sodutienmat");
//				int tienUngTruoc = rs.getInt("tienungtruoc");
//				int soDuCoTheGiaoDich = rs.getInt("soducothegiaodich");
//				int khoiLuongCoTheMua = rs.getInt("khoiluongcothemua");
//				int tienTreoGoc = rs.getInt("tientreogoc");
//
//				user = new User();
//			}
//			rs.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			MySQLConnector.closeStatement(ps);
//			MySQLConnector.putConnection(conn);
//		}
//		return user;
//	}
//
//	/**
//	 * List all monitor user
//	 * 
//	 * @return
//	 */
//	public static ArrayList<User> listUser() {
//		ArrayList<User> tmp = new ArrayList<User>();
//		Connection conn = MySQLConnector.popConnection();
//		User user = null;
//		PreparedStatement ps = null;
//		if (conn == null) {
//			errorCode = Constant.CANNOT_CONNECT_DB;
//			return null;
//		}
//		try {
//			ps = conn.prepareStatement("SELECT * FROM USER WHERE level = 1");
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				int id = rs.getInt("id");
//				String userName = rs.getString("username");
//				String password = rs.getString("pass");
//				String fullName = rs.getString("fullname");
//				String email = rs.getString("email");
//				String taikhoangiaodich = rs.getString("taikhoangiaodich");
//				int soDuTienMat = rs.getInt("sodutienmat");
//				int tienUngTruoc = rs.getInt("tienungtruoc");
//				int soDuCoTheGiaoDich = rs.getInt("soducothegiaodich");
//				int khoiLuongCoTheMua = rs.getInt("khoiluongcothemua");
//				int tienTreoGoc = rs.getInt("tientreogoc");
//
//				user = new User();
//				tmp.add(user);
//			}
//			rs.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			MySQLConnector.closeStatement(ps);
//			MySQLConnector.putConnection(conn);
//		}
//
//		return tmp;
//	}
}
