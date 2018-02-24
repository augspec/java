package com.aug.web.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aug.db.entities.User;
import com.aug.db.handle.UserDbHandle;
import com.aug.web.util.Constants.KeyInitVectorEncryptor;
import com.aug.web.util.Encryptor;
import com.aug.web.util.FriendUtil;
import com.aug.web.util.SHA2Util;

public class ManageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UserDbHandle userDbHandle = new UserDbHandle();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String _username = (String) req.getAttribute("username");
		String _password = (String) req.getAttribute("password");
		
		if (FriendUtil.isNullOrEmpty(_username) || FriendUtil.isNullOrEmpty(_password)) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String remember = req.getParameter("remember");
			
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
				
				if (!FriendUtil.isNullOrEmpty(remember) 
						&& !remember.equals("null")
						&& remember.equals("remember-me")) {
					username = Encryptor.encrypt(KeyInitVectorEncryptor.KEY.getValue(), KeyInitVectorEncryptor.INIT_VECTOR.getValue(), username);
					password = Encryptor.encrypt(KeyInitVectorEncryptor.KEY.getValue(), KeyInitVectorEncryptor.INIT_VECTOR.getValue(), password);
					
					Cookie cUsername = new Cookie("aug_c_username", username);
					Cookie cPassword = new Cookie("aug_c_password", password);
					cUsername.setMaxAge(60*60*24*365);
					cPassword.setMaxAge(60*60*24*365);
					
					resp.addCookie(cUsername);
					resp.addCookie(cPassword);
				}
				
				if (user.getUsername().equals("admin"))
					req.getSession().setAttribute("isAdmin", true);
				
				req.getSession().setAttribute("user", user);
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		} else {
			String message = "";
			User user = userDbHandle.getByUsername(_username);
			if (user == null) {
				message = "Không tồn tại tài khoản này!";
				req.setAttribute("message", message);
				req.getRequestDispatcher("/login").forward(req, resp);
				
				return;
			}
			
			try {
				if (!user.getPassword().equalsIgnoreCase(SHA2Util.hash(_password))) {
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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		this.doGet(req, resp);
	}

}
