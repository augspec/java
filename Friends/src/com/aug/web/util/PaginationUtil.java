package com.aug.web.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class PaginationUtil {
	
	private static final Logger _log = Logger.getLogger(PaginationUtil.class);
	
	public static final String START = "start";
	public static final String HTML = "html";

	/**
	 * Gen HTML phân trang, dùng để hiển thị trên trang JSP.<br/>
	 * Ví dụ sử dụng: <br/>
	 * {@code Map<String, Object> pagination = 
	 * PaginationUtil.generatePaginationHTML(total, items, indexPage, "page", "someAction");}<br/>
	 * Lấy HTML: <br/> {@code String html = String.valueOf(pagination.get(PaginationUtil.HTML));} <br/>
	 * Lấy start (thường dùng để truy vấn LIMIT trong database): <br/>
	 * {@code int start = Integer.valueOf(pagination.get(PaginationUtil.START_RECORD));}
	 * 
	 * @param totalItems là tổng số bản ghi (ví dụ lấy tổng số bản ghi của 1 bảng trong database).
	 * @param itemsOnPage là số bản ghi sẽ hiển thị trên 1 trang (ví dụ: 10).
	 * @param indexPage là trang muốn hiển thị (thường lấy tham số trên URL).
	 * @param paramIndexPage là chuỗi tên tham số của trang muốn hiển thị (ví dụ: page).
	 * @param filterValue giá trị lọc (thường lấy tham số trên URL).
	 * @param paramFilter là chuỗi tên tham số của trang muốn hiển thị (ví dụ: filterBy).
	 * @param action là action mà sẽ xử lý để lấy dữ liệu hiển thị.
	 * @return Map&lt;String, Object&gt;
	 * @author HungDMc
	 */
	public static Map<String, Object> generatePaginationHTML(int totalItems, int itemsOnPage, int indexPage, 
			String paramIndexPage, String filterValue, String paramFilter, String action) {
		Map<String, Object> result = new HashMap<String, Object>();
		StringBuilder html = new StringBuilder("<nav aria-label=\"...\"><ul class=\"pager\">");
		
		try {
			if (totalItems < 1 || itemsOnPage < 1 || itemsOnPage > totalItems)
				return null;
			
			if (isNullOrEmpty(paramIndexPage)) {
				_log.warn("#generatePaginationHTML(...) - paramIndexPage bắt buộc phải có giá trị!");
				
				return null;
			}
			
			int totalPages = 0;
			if (totalItems % itemsOnPage == 0)
				totalPages = totalItems / itemsOnPage;
			else
				totalPages = Math.round(totalItems / itemsOnPage) + 1;
			
			if (indexPage < 1)
				indexPage = 1;
			
			if (indexPage > totalPages)
				indexPage = totalPages;
			
			int start = (indexPage * itemsOnPage) - itemsOnPage;
			
			// Previous
			if (totalPages > 1) {
				String _class = indexPage > 1 ? "" : "disabled";
				StringBuilder prevURL = new StringBuilder("");
				String href = _class.equals("") ? (action + "?" + paramIndexPage + "=" + (indexPage - 1) + "&itemsOnPage=" + itemsOnPage + "&" + paramFilter + "=" + filterValue) : "javascript:;";
				prevURL.append("<li class='" + _class + "'><a href='" + href + "'>Previous</a></li>");
				html.append(prevURL.toString());
			}
			
			// Next
			if (totalPages > 1) {
				String _class = indexPage < totalPages ? "" : "disabled";
				StringBuilder nextvURL = new StringBuilder("");
				String href = _class.equals("") ? (action + "?" + paramIndexPage + "=" + (indexPage + 1) + "&itemsOnPage=" + itemsOnPage + "&" + paramFilter + "=" + filterValue) : "javascript:;";
				nextvURL.append("<li class='" + _class + "'><a href='" + href + "'>Next</a></li>");
				html.append(nextvURL.toString());
			}
			
			html.append("</ul></nav>");
			
			result.put(START, start);
			result.put(HTML, html.toString());
			
			return result;
		} catch (Exception e) {
			_log.error("#generatePaginationHTML(...) - " + e);
		}
		
		return null;
	}
	
	private static boolean isNullOrEmpty(String str) {
		return str == null || str.isEmpty();
	}
}
