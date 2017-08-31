package com.bkav.bkavcoreca.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bkav.bkavcoreca.pdf.BankReceipt;

public class BankTransactionDAO {

	static final Logger LOGGER = Logger.getLogger(BankTransactionDAO.class);

	private static final String STM_INSERT_BANKTR = "INSERT INTO banktransaction values(?, ?, ?, ?, ?, ?)";
	private static final String STM_GET_BANKTR_BY_ID = "SELECT * FROM banktransaction WHERE id=?";
	private static final String STM_GET_BANKTR = "SELECT * FROM banktransaction";
	
	public static void main(String[] args) {
		System.out.println(getAllBankTR().size());
	}
	
	
	public static boolean insert(BankReceipt bankReceipt, String pathfileSigned) {
		boolean result = true;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = MySQLConnector.popConnection();
			ps = conn.prepareStatement(STM_INSERT_BANKTR);
			ps.setInt(1, 0);
			long tranTime = bankReceipt.getDateTransaction() != null
					? bankReceipt.getDateTransaction().getTime() : -1;
			if (tranTime > -1) {
				ps.setTimestamp(2, new java.sql.Timestamp(
						bankReceipt.getDateTransaction().getTime()));
			} else {
				ps.setDate(2, null);
			}
			ps.setString(3, bankReceipt.getAccountNumberBeneficiary());
			ps.setString(4, bankReceipt.getNumberMoney());
			ps.setString(5, "Chuyen tien");
			ps.setString(6, pathfileSigned);
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
	
	public static List<BankTransaction> getAllBankTR() {
		List<BankTransaction> bankTranscations = new ArrayList<BankTransaction>();
		
		
		Connection conn = MySQLConnector.popConnection();
		PreparedStatement ps = null;
		
		if (conn == null) {			
			return bankTranscations;
		}
		
		try {
			ps = conn.prepareStatement(STM_GET_BANKTR);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				BankTransaction bankTranscation = new BankTransaction();
				bankTranscation.setId(rs.getInt("id"));
				bankTranscation.setDateTransaction(rs.getDate("date_transaction"));
				bankTranscation.setNumberBeneficiary(rs.getString("number_beneficiary"));
				bankTranscation.setNumberMoney(rs.getString("number_money"));
				bankTranscation.setTypeTransaction(rs.getString("type_transaction"));
				bankTranscation.setSignedPath(rs.getString("signed_path"));
				
				bankTranscations.add(bankTranscation);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnector.closeStatement(ps);
			MySQLConnector.putConnection(conn);
		}
		
		return bankTranscations;
	}
	
	public static BankTransaction getBankTRById(int id) {
		
		BankTransaction bankTranscation = new BankTransaction();
		
		Connection conn = MySQLConnector.popConnection();
		PreparedStatement ps = null;
		
		if (conn == null) {			
			return bankTranscation;
		}
		
		try {
			ps = conn.prepareStatement(STM_GET_BANKTR_BY_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				bankTranscation.setId(rs.getInt("id"));
				bankTranscation.setDateTransaction(rs.getDate("date_transaction"));
				bankTranscation.setNumberBeneficiary(rs.getString("number_beneficiary"));
				bankTranscation.setNumberMoney(rs.getString("number_money"));
				bankTranscation.setTypeTransaction(rs.getString("type_transaction"));
				bankTranscation.setSignedPath(rs.getString("signed_path"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnector.closeStatement(ps);
			MySQLConnector.putConnection(conn);
		}
		
		return bankTranscation;
	}
}
