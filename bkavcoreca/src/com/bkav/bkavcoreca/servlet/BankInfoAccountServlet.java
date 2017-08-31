package com.bkav.bkavcoreca.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/BankInfoAccount")
public class BankInfoAccountServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	final String VIEW = "/bank/bankInfoAccount.jsp";
	
	public BankInfoAccountServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if (session == null || session.getAttribute("user") == null) {
			response.sendRedirect("login");
			return;
		}
		
		RequestDispatcher view = request.getRequestDispatcher(VIEW);
		view.forward(request, response);
	}	

}
