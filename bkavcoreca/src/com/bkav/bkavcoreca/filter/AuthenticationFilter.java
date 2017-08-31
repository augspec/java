package com.bkav.bkavcoreca.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebFilter("/*")
public class AuthenticationFilter implements Filter{
	
	Logger LOG = Logger.getLogger(AuthenticationFilter.class);
	
	public static String pathProject = null;
	
	public AuthenticationFilter() {
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unused")
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		

		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		if (pathProject == null) {
			ServletContext servletContext = req.getServletContext();
			pathProject = servletContext.getRealPath("/");
		}
		
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
			
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
}
