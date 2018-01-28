package com.aug.web.servlet.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
		
		// TODO: do something here to filters
		System.out.println("doFilter is runned.");
		
		chain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		_LOG.info("Filter is initialized.");
	}

}
