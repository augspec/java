package com.bkav.bkavcoreca.servlet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.bkav.bkavcoreca.database.Stock;
import com.bkav.bkavcoreca.database.StockDAO;
import com.bkav.bkavcoreca.utils.Base64;
import com.bkav.bkavcoreca.utils.PaginationUtil;

/**
 * 
 * @author HungDMc
 *
 */
@WebServlet("/StockMarketHistory")
public class StockMarketHistoryServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(StockMarketHistoryServlet.class);
	
	private static final String PAGE_PARAM = "page";
	private static final String DOWNLOAD_CLIENT_SIGNED = "clientSigned";
	private static final String DOWNLOAD_SERVER_SIGNED = "serverSigned";
	
	StockDAO stockDAO = new StockDAO();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if (session == null || session.getAttribute("user") == null) {
			response.sendRedirect("login");
			return;
		}
		
		String download = request.getParameter("download");
		String fileId = request.getParameter("file");
		if (!isNullOrEmpty(download) && !isNullOrEmpty(fileId)) {
			int stockId = 0;
			try {
				stockId = Integer.valueOf(fileId);
			} catch (NumberFormatException e) {
				LOG.error("#doGet(?, ?): Exception occurs... \r\n==> ", e);
				return;
			}
			
			String signed = null;
			String fileName = null;
			Stock stock = stockDAO.getStock(stockId);
			if (stock == null)
				return;
			
			if (download.equalsIgnoreCase(DOWNLOAD_CLIENT_SIGNED)) {
				signed = stock.getClientDataSigned();
				fileName = "ClientSigned.xml";
			} else if (download.equalsIgnoreCase(DOWNLOAD_SERVER_SIGNED)) {
				signed = stock.getServerDataSigned();
				fileName = "ServerSigned.xml";
			}
			
			if (!isNullOrEmpty(signed) && !isNullOrEmpty(fileName)) {
				byte[] xmlSigned = Base64.decode(signed.getBytes());
				
				downloadFile(xmlSigned, response, fileName);
			} else {
				response.getWriter().println("<b>File not found!</b>");
			}
			
			return;
		}
		
		int page = 1;
		int itemsOnPage = 10;
		String pagination;
		if (!isNullOrEmpty(request.getParameter(PAGE_PARAM)))
			page = Integer.valueOf(request.getParameter(PAGE_PARAM)) > 0 ? Integer.valueOf(request.getParameter(PAGE_PARAM)) : page;
		if (!isNullOrEmpty(request.getParameter("itemsOnPage")))
			itemsOnPage = Integer.valueOf(request.getParameter("itemsOnPage")) > 0 ? Integer.valueOf(request.getParameter("itemsOnPage")) : itemsOnPage;
		
		long totalStocks = stockDAO.count();
		Map<String, Object> paginate = PaginationUtil.generatePaginationHTML((int) totalStocks, itemsOnPage, page, PAGE_PARAM, "StockMarketHistory");
		
		int start = 0;
		if (paginate != null) {
			pagination = String.valueOf(paginate.get(PaginationUtil.HTML));
			start = Integer.valueOf(paginate.get(PaginationUtil.START_RECORD).toString());
			
			request.setAttribute("pagination", pagination);
		}
		
		List<Stock> stockList = stockDAO.getStocks(start, itemsOnPage);
		request.setAttribute("stockList", stockList);
		
		request.getRequestDispatcher("/stock/stockHistory.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	private boolean isNullOrEmpty(String str) {
		return str == null || str.isEmpty();
	}
	
	private void downloadFile(byte[] data, HttpServletResponse response, String fileName) throws IOException {
		if (data != null) {
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
			
			ByteArrayInputStream inStream = new ByteArrayInputStream(data);
			ServletOutputStream out = response.getOutputStream();
			try {
				byte[] buffer = new byte[1024];
				int i;
				while ((i = inStream.read(buffer)) != -1) {
					out.write(buffer, 0, i);
				}
				out.flush();
			} catch (Exception e) {
				LOG.error("#downloadFile(?, ?, ?): Exception occurs... \r\n==> ", e);
			} finally {
				inStream.close();
				out.close();
			}
		}
	}

}
