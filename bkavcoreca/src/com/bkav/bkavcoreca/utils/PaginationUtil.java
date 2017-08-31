package com.bkav.bkavcoreca.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Chứa các phương thức hỗ trợ phân trang.
 * 
 * @author HungDMc
 *
 */
public class PaginationUtil {
	
	private static final Logger _log = Logger.getLogger(PaginationUtil.class);
	
	/**
	 * Cạnh phân trang, là số trang lân cận của trang hiện tại.<br/>
	 * Ví dụ: trang hiện tại là 11 và EGED = 2 thì sẽ hiển thị dạng ... <b>9</b> <b>10</b> <i>11</i> <b>12</b> <b>13</b>
	 * <br/> tương tự số trang lân cận được hiển thị tùy thuộc vào việc gán giá trị cho EDGE, mặc định EDGE = 2.
	 */
	private static final int EDGE = 2;
	
	/**
	 * Là key dùng để lấy giá trị <b>start</b> hỗ trợ cho hàm {@code generatePaginationHTML}.
	 */
	public static final String START_RECORD = "start";
	
	/**
	 * Là key dùng để lấy giá trị <b>html</b> hỗ trợ cho hàm {@code generatePaginationHTML}.
	 */
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
	 * @param action là action mà sẽ xử lý để lấy dữ liệu hiển thị.
	 * @return Map&lt;String, Object&gt;
	 * @author HungDMc
	 */
	public static Map<String, Object> generatePaginationHTML(int totalItems, int itemsOnPage, int indexPage, 
			String paramIndexPage, String action) {
		Map<String, Object> result = new HashMap<String, Object>();
		StringBuilder html = new StringBuilder("<nav aria-label=\"Page navigation\"><ul class=\"pagination\">");
		try {
			if (totalItems < 1 || itemsOnPage < 1 || itemsOnPage > totalItems) {
				return null;
			}
			
			if (isNullOrEmpty(paramIndexPage)) {
				_log.warn("#generatePaginationHTML(...) - paramIndexPage bắt buộc phải có giá trị!");
				return null;
			}
			
			int totalPages = 0;
			if (totalItems % itemsOnPage == 0) {
				totalPages = totalItems / itemsOnPage;
			} else {
				totalPages = Math.round(totalItems / itemsOnPage) + 1;
			}
			
			if (indexPage < 1) {
				indexPage = 1;
			}
			if (indexPage > totalPages) {
				indexPage = totalPages;
			}
			
			int start = (indexPage * itemsOnPage) - itemsOnPage;
			String _itemsDisplay = "Hiển thị " + ((start == 0) ? 1 : (start + 1)) + " đến " 
					+ (((start + itemsOnPage) > totalItems) ? totalItems : (start + itemsOnPage)) + " trong " + totalItems + " bản ghi";
			
			// Previous
			if (totalPages > 1) {
				String _class = indexPage > 1 ? "" : "disabled";
				StringBuilder prevURL = new StringBuilder("");
				String href = _class.equals("") ? (action + "?" + paramIndexPage + "=" + (indexPage - 1) + "&itemsOnPage=" + itemsOnPage) : "javascript:;";
				prevURL.append("<li class='" + _class + "'><a href='" + href + "' aria-label='Previous'><span aria-hidden=\"true\">&laquo;</span></a></li>");
				html.append(prevURL.toString());
			}
			
			boolean showDot = true;
			if (totalPages > 1) {
				for (int i = 1; i <= totalPages; i++) {				
					if (i > 0 && i <= totalPages) {
						if ((i >= (indexPage - EDGE)) && (i <= (indexPage + EDGE))
								|| (i == 1 || i == 2 || i == totalPages || i == (totalPages -1))) {
							showDot = true;
							if (i == indexPage) {
								StringBuilder url = new StringBuilder("");
								url.append("<li class='active'><a href='" + action + "?" + paramIndexPage + "=" + i + "&itemsOnPage=" + itemsOnPage + "'>" + i + "</a></li>");
								html.append(url.toString());
							} else {
								StringBuilder url = new StringBuilder("");
								url.append("<li><a href='" + action + "?" + paramIndexPage + "=" + i + "&itemsOnPage=" + itemsOnPage + "'>" + i + "</a></li>");
								html.append(url.toString());
							}
						} else {
							if (showDot) {
								showDot = false;
								StringBuilder url = new StringBuilder("");
								url.append("<li><a href='#' onclick='return false' style='cursor: default;'>&hellip;</a></li>");
								html.append(url.toString());
							}
						}
					}
				}
			}
			
			// Next
			if (totalPages > 1) {
				String _class = indexPage < totalPages ? "" : "disabled";
				StringBuilder nextvURL = new StringBuilder("");
				String href = _class.equals("") ? (action + "?" + paramIndexPage + "=" + (indexPage + 1) + "&itemsOnPage=" + itemsOnPage) : "javascript:;";
				nextvURL.append("<li class='" + _class + "'><a href='" + href + "' aria-label='Next'><span aria-hidden=\"true\">&raquo;</span></a></li>");
				html.append(nextvURL.toString());
			}
			html.append("</ul></nav>");
			String htmlResult = "";
			if (totalPages > 1) {
				htmlResult = "<div style='display: inline-block; width: 100%;'><div class='frt'>" 
						+  html.toString() + "</div><div class='flt' style='margin: 27px 10px 0 0;'>" 
						+ _itemsDisplay + "</div></div>";
			}
			
			result.put(START_RECORD, start);
			result.put(HTML, htmlResult);
			return result;
		} catch (Exception e) {
			_log.error("#generatePaginationHTML(...) - " + e);
		}
		return null;
	}
	
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
		StringBuilder html = new StringBuilder("<nav aria-label=\"Page navigation\"><ul class=\"pagination\">");
		try {
			if (totalItems < 1 || itemsOnPage < 1 || itemsOnPage > totalItems) {
				return null;
			}
			
			if (isNullOrEmpty(paramIndexPage)) {
				_log.warn("#generatePaginationHTML(...) - paramIndexPage bắt buộc phải có giá trị!");
				return null;
			}
			
			int totalPages = 0;
			if (totalItems % itemsOnPage == 0) {
				totalPages = totalItems / itemsOnPage;
			} else {
				totalPages = Math.round(totalItems / itemsOnPage) + 1;
			}
			
			if (indexPage < 1) {
				indexPage = 1;
			}
			if (indexPage > totalPages) {
				indexPage = totalPages;
			}
			
			int start = (indexPage * itemsOnPage) - itemsOnPage;
			String _itemsDisplay = "Hiển thị " + ((start == 0) ? 1 : (start + 1)) + " đến " 
					+ (((start + itemsOnPage) > totalItems) ? totalItems : (start + itemsOnPage)) + " trong " + totalItems + " bản ghi";
			
			// Previous
			if (totalPages > 1) {
				String _class = indexPage > 1 ? "" : "disabled";
				StringBuilder prevURL = new StringBuilder("");
				String href = _class.equals("") ? (action + "?" + paramIndexPage + "=" + (indexPage - 1) + "&itemsOnPage=" + itemsOnPage + "&" + paramFilter + "=" + filterValue) : "javascript:;";
				prevURL.append("<li class='" + _class + "'><a href='" + href + "' aria-label='Previous'><span aria-hidden=\"true\">&laquo;</span></a></li>");
				html.append(prevURL.toString());
			}
			
			boolean showDot = true;
			if (totalPages > 1) {
				for (int i = 1; i <= totalPages; i++) {				
					if (i > 0 && i <= totalPages) {
						if ((i >= (indexPage - EDGE)) && (i <= (indexPage + EDGE))
								|| (i == 1 || i == 2 || i == totalPages || i == (totalPages -1))) {
							showDot = true;
							if (i == indexPage) {
								StringBuilder url = new StringBuilder("");
								url.append("<li class='active'><a href='" + action + "?" + paramIndexPage + "=" + i 
										+ "&itemsOnPage=" + itemsOnPage 
										+ "&" + paramFilter + "=" + filterValue 
										+ "'>" + i + "</a></li>");
								html.append(url.toString());
							} else {
								StringBuilder url = new StringBuilder("");
								url.append("<li><a href='" + action + "?" + paramIndexPage + "=" + i + "&itemsOnPage=" + itemsOnPage 
										+ "&" + paramFilter + "=" + filterValue 
										+ "'>" + i + "</a></li>");
								html.append(url.toString());
							}
						} else {
							if (showDot) {
								showDot = false;
								StringBuilder url = new StringBuilder("");
								url.append("<li><a href='#' onclick='return false' style='cursor: default;'>&hellip;</a></li>");
								html.append(url.toString());
							}
						}
					}
				}
			}
			
			// Next
			if (totalPages > 1) {
				String _class = indexPage < totalPages ? "" : "disabled";
				StringBuilder nextvURL = new StringBuilder("");
				String href = _class.equals("") ? (action + "?" + paramIndexPage + "=" + (indexPage + 1) + "&itemsOnPage=" + itemsOnPage + "&" + paramFilter + "=" + filterValue) : "javascript:;";
				nextvURL.append("<li class='" + _class + "'><a href='" + href + "' aria-label='Next'><span aria-hidden=\"true\">&raquo;</span></a></li>");
				html.append(nextvURL.toString());
			}
			html.append("</ul></nav>");
			String htmlResult = "";
			if (totalPages > 1) {
				htmlResult = "<div style='display: inline-block; width: 100%;'><div class='frt'>" 
						+  html.toString() + "</div><div class='flt' style='margin: 27px 10px 0 0;'>" 
						+ _itemsDisplay + "</div></div>";
			}
			result.put(START_RECORD, start);
			result.put(HTML, htmlResult);
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
