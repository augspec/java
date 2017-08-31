package com.bkav.bkavcoreca.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bkav.bkavcoreca.database.CertUser;
import com.bkav.bkavcoreca.database.CertUserDAO;
import com.bkav.bkavcoreca.database.User;

@WebServlet("/SockMarket")
public class SockMarketServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	final String VIEW = "/stock/stock.jsp";
	
	public SockMarketServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if (session == null || session.getAttribute("user") == null) {
			response.sendRedirect("login");
			return;
		}
		
		User user = (User) session.getAttribute("user");

		List<CertUser> certUserList = CertUserDAO.getCertUserByEmail(user.getEmail());
		
		request.setCharacterEncoding("utf-8");
		request.setAttribute("certUserList", certUserList);
		
		RequestDispatcher view = request.getRequestDispatcher(VIEW);
		view.forward(request, response);
	}
	
	

}
