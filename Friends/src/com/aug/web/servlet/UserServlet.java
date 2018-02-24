package com.aug.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aug.db.entities.User;
import com.aug.db.handle.UserDbHandle;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UserDbHandle userDbHandle = new UserDbHandle();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO: check user authentication
		
		// select list user and paginate to display
		List<User> userList = userDbHandle.getAll();
		req.setAttribute("userList", userList);
		
		req.getRequestDispatcher("/user.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		this.doGet(req, resp);
	}

}
