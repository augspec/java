package com.aug.web.servlet.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class FriendFilter implements Filter {

	private static final Logger _LOG = Logger.getLogger(FriendFilter.class);
	
	@Override
	public void destroy() {
		_LOG.info("Filter is destroyed.");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) req;
		HttpServletResponse servletResponse = (HttpServletResponse) resp;
		
		String requestUri = servletRequest.getRequestURI();
		requestUri = requestUri.substring(requestUri.lastIndexOf("/") + 1, requestUri.length());
		
		if (requestUri.equals("login") || requestUri.isEmpty()) {
			servletRequest.getSession().invalidate();
			servletRequest.getRequestDispatcher("/login").forward(servletRequest, servletResponse);
			
			return;
		}
		
		if (requestUri.equals("logout")) {
			Cookie cUsername = new Cookie("aug_c_username", "");
			Cookie cPassword = new Cookie("aug_c_password", "");
			cUsername.setMaxAge(0);
			cPassword.setMaxAge(0);
			
			servletResponse.addCookie(cUsername);
			servletResponse.addCookie(cPassword);
			
			servletRequest.getSession().invalidate();
			servletResponse.sendRedirect(servletRequest.getContextPath() + "/login");
			
			return;
		}
		
		if (requestUri.equals("#") 
				|| requestUri.equals("manage") 
				|| requestUri.isEmpty())
			servletRequest.getSession().setAttribute("tabActive", "friend");
		else if (requestUri.equals("group"))
			servletRequest.getSession().setAttribute("tabActive", "group");
		else if (requestUri.equals("user"))
			servletRequest.getSession().setAttribute("tabActive", "user");
		
		chain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		_LOG.info("Filter is initialized.");
	}

}
