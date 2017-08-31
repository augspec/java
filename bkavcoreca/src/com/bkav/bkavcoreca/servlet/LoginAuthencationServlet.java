package com.bkav.bkavcoreca.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bkav.bkavcoreca.database.User;
import com.bkav.bkavcoreca.database.UserDAO;

@WebServlet("/login")
public class LoginAuthencationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	final String VIEW = "/dashboard/login.jsp";
	
	public LoginAuthencationServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		if (id != null && id.equals("logout")) {
			
			HttpSession session = request.getSession();
			try {
				session.removeAttribute("user");
			} catch (Exception e) {
				e.printStackTrace();
			}			
			
			RequestDispatcher view = request.getRequestDispatcher(VIEW);
			view.forward(request, response);
			return;
		}
		
		if (id == null || id.equals("")) {
			RequestDispatcher view = request.getRequestDispatcher(VIEW);
			view.forward(request, response);
			return;
		}	
		
		HttpSession session1 = request.getSession(false);		
		if(session1 != null && session1.getAttribute("user") != null) {
			response.sendRedirect("login");
			return;
		}
		
				
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = UserDAO.getUser(username, password);
		@SuppressWarnings("unused")
		String message = "";
		if (user == null) {
			message = "[ERROR] Tên tài khoản hoặc mật khẩu không chính xác";
			RequestDispatcher view = request.getRequestDispatcher(VIEW);
			view.forward(request, response);
		} else {
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(60*60);
			session.setAttribute("user", user);
			session.setAttribute("logined", true);
			response.sendRedirect("dashboard");
		}
	}
}
