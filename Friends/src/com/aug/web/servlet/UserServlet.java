package com.aug.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aug.db.entities.User;
import com.aug.db.handle.UserDbHandle;
import com.aug.web.util.FriendUtil;
import com.aug.web.util.PaginationUtil;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UserDbHandle userDbHandle = new UserDbHandle();
	
	private List<User> userList;
	private int count = userDbHandle.count();
	
	private String pagination = "";
	private int page = 1;
	private int itemsOnPage = 1;
	private String filterBy = "";
	private String q = "";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO: check user authentication
		
		_setValue(req);
		
		String paginationHtml = "";
		String orderColumn = "";
		String orderType = "";
		int start = 0;
		
		if (!FriendUtil.isNullOrEmpty(filterBy)) {
			String[] filters = filterBy.split("_");
			orderColumn = filters[0];
			orderType = filters[1];
		}
		
		// is searching...
		if (!FriendUtil.isNullOrEmpty(q)) {
			count = userDbHandle.searchCount(q);
			
			Map<String, Object> pagination = PaginationUtil.generatePaginationHTML(count, itemsOnPage, page, "p", filterBy, "filterBy", "user");
			if (pagination != null) {
				start = (Integer) pagination.get(PaginationUtil.START);
				paginationHtml = (String) pagination.get(PaginationUtil.HTML);
				
				Pattern pattern = Pattern.compile("href='(.*?)'");
				Matcher matcher = pattern.matcher(paginationHtml);
				while (matcher.find()) {
					String href = matcher.group(1);
					if (!href.equals("javascript:;")) {
						String href2 = matcher.group(1) + "&q=" + q;
						paginationHtml = paginationHtml.replace(href, href2);
					}
				}
			}
			
			userList = userDbHandle.search(q, start, itemsOnPage, orderColumn, orderType);
		} else {
			// select list user and paginate to display
			count = userDbHandle.count();
			
			Map<String, Object> pagination = PaginationUtil.generatePaginationHTML(count, itemsOnPage, page, "p", filterBy, "filterBy", "user");
			if (pagination != null) {
				start = (Integer) pagination.get(PaginationUtil.START);
				paginationHtml = (String) pagination.get(PaginationUtil.HTML);
			}
			
			userList = userDbHandle.getByLimit(start, itemsOnPage, orderColumn, orderType);	
		}
		
		req.setAttribute("userList", userList);
		req.setAttribute("pagination", paginationHtml);
		req.setAttribute("itemsOnPage", itemsOnPage);
		req.setAttribute("q", q);
		
		req.getRequestDispatcher("/user.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		this.doGet(req, resp);
	}
	
	private void _setValue(HttpServletRequest req) {
		pagination = "";
		page = Integer.valueOf(req.getParameter("p") != null ? req.getParameter("p") : "1");
		itemsOnPage = Integer.valueOf(req.getParameter("itemsOnPage") != null ? req.getParameter("itemsOnPage") : "1");
		filterBy = req.getParameter("filterBy") !=  null ? req.getParameter("filterBy") : "";
		q = req.getParameter("q") != null ? req.getParameter("q") : "";
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getPagination() {
		return pagination;
	}

	public void setPagination(String pagination) {
		this.pagination = pagination;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getItemsOnPage() {
		return itemsOnPage;
	}

	public void setItemsOnPage(int itemsOnPage) {
		this.itemsOnPage = itemsOnPage;
	}

	public String getFilterBy() {
		return filterBy;
	}

	public void setFilterBy(String filterBy) {
		this.filterBy = filterBy;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

}
