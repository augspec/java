package com.bkav.bkavcoreca.servlet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bkav.bkavcoreca.database.BankTransaction;
import com.bkav.bkavcoreca.database.BankTransactionDAO;
import com.bkav.bkavcoreca.utils.FileUtil;

@WebServlet("/BankTransactionHistory")
public class BankTransactionHistoryServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	final String VIEW = "/bank/bankTransactionHistory.jsp";
	
	public BankTransactionHistoryServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if (session == null || session.getAttribute("user") == null) {
			response.sendRedirect("login");
			return;
		}
		
		
		String id = request.getParameter("id");
		
		if (id == null || "".equals(id)) {
			List<BankTransaction> bankTranscations = new ArrayList<BankTransaction>();
			
			bankTranscations = BankTransactionDAO.getAllBankTR();
			request.setAttribute("bankTranscations", bankTranscations);
			
			RequestDispatcher view = request.getRequestDispatcher(VIEW);
			view.forward(request, response);
			return;
		}
		
		if ("download".equals(id)) {
			
			String para = request.getParameter("file");
			if (para != null && !"".equals(para)) {
				int idLog = -1;
				try{
					idLog = Integer.parseInt(para);
				}catch(Exception e){
					
				}
				if(idLog < 0){
					return;
				}
				BankTransaction log = BankTransactionDAO.getBankTRById(idLog);
				if(log == null){
					return;
				}
				
				byte[] data = FileUtil.readBytesFromFile(log.getSignedPath());
				
				if (data != null) {
					response.setContentType("PDF");
					response.setHeader("Content-Disposition",
							"attachment; filename=\"" + "logBank.pdf" + "\"");

					ByteArrayInputStream inStream = new ByteArrayInputStream(
							data);
					byte[] buffer = new byte[1024];
					ServletOutputStream out = response.getOutputStream();
					int i;
					while ((i = inStream.read(buffer)) != -1) {
						out.write(buffer, 0, i);
					}
					inStream.close();
					out.close();
				}
			}
			
		}
		
		if ("downloadxml".equals(id)) {
			
			String para = request.getParameter("file");
			if (para != null && !"".equals(para)) {
				int idLog = -1;
				try{
					idLog = Integer.parseInt(para);
				}catch(Exception e){
					
				}
				if(idLog < 0){
					return;
				}
				BankTransaction log = BankTransactionDAO.getBankTRById(idLog);
				if(log == null){
					return;
				}
				
				byte[] data = FileUtil.readBytesFromFile(log.getSignedPath() + ".xml");
				
				if (data != null) {
					response.setContentType("PDF");
					response.setHeader("Content-Disposition",
							"attachment; filename=\"" + "logBank.xml" + "\"");

					ByteArrayInputStream inStream = new ByteArrayInputStream(
							data);
					byte[] buffer = new byte[1024];
					ServletOutputStream out = response.getOutputStream();
					int i;
					while ((i = inStream.read(buffer)) != -1) {
						out.write(buffer, 0, i);
					}
					inStream.close();
					out.close();
				}
			}
			
		}

	}
}
