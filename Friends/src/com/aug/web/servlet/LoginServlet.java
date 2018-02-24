package com.aug.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aug.web.util.Encryptor;
import com.aug.web.util.FriendUtil;
import com.aug.web.util.Constants.KeyInitVectorEncryptor;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		
		String username = null;
		String password = null;
		
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("aug_c_username")) {
					username = Encryptor.decrypt(KeyInitVectorEncryptor.KEY.getValue(), KeyInitVectorEncryptor.INIT_VECTOR.getValue(), c.getValue());
				}
				
				if (c.getName().equals("aug_c_password")) {
					password = Encryptor.decrypt(KeyInitVectorEncryptor.KEY.getValue(), KeyInitVectorEncryptor.INIT_VECTOR.getValue(), c.getValue());
				}
			}
		}
		
		if (!FriendUtil.isNullOrEmpty(username) 
				&& !FriendUtil.isNullOrEmpty(password)) {
			req.setAttribute("username", username);
			req.setAttribute("password", password);
			
			req.getRequestDispatcher("/manage").forward(req, resp);
			
			return;
		}

		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
