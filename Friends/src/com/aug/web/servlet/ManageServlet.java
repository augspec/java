package com.aug.web.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aug.db.entities.User;
import com.aug.db.handle.UserDbHandle;
import com.aug.web.util.FriendUtil;
import com.aug.web.util.SHA2Util;

public class ManageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UserDbHandle userDbHandle = new UserDbHandle();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");
		
		System.out.println(username + "\n" + password + "\n" + remember);
		
		String message = "";
		
		if (FriendUtil.isNullOrEmpty(username)
				&& FriendUtil.isNullOrEmpty(password))
			message = "Chưa nhập username và password!";
		else if (FriendUtil.isNullOrEmpty(username))
			message = "Chưa nhập username!";
		else if (FriendUtil.isNullOrEmpty(password))
			message = "Chưa nhập password!";
		
		if (!FriendUtil.isNullOrEmpty(message)) {
			req.setAttribute("message", message);
			req.getRequestDispatcher("/login").forward(req, resp);
			
			return;
		}
		
		User user = userDbHandle.getByUsername(username);
		if (user == null) {
			message = "Không tồn tại tài khoản này!";
			req.setAttribute("message", message);
			req.getRequestDispatcher("/login").forward(req, resp);
			
			return;
		}
		
		try {
			if (!user.getPassword().equalsIgnoreCase(SHA2Util.hash(password))) {
				message = "Mật khẩu không chính xác!";
				req.setAttribute("message", message);
				req.getRequestDispatcher("/login").forward(req, resp);
				
				return;
			}
			
			req.getSession().setAttribute("user", user);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	}

}
