package com.bkav.bkavcoreca.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.activation.DataHandler;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.bkav.bkavcoreca.database.Stock;
import com.bkav.bkavcoreca.database.StockDAO;
import com.bkav.bkavcoreca.database.User;
import com.bkav.bkavcoreca.utils.SSLHandler;
import com.bkavca.axis2.signserver.clientws.ClientWSServiceStub;
import com.bkavca.axis2.signserver.clientws.ClientWSServiceStub.Sign;
import com.bkavca.axis2.signserver.clientws.ClientWSServiceStub.SignData;
import com.bkavca.axis2.signserver.clientws.ClientWSServiceStub.SignE;
import com.bkavca.axis2.signserver.clientws.ClientWSServiceStub.SignResponse;
import com.bkavca.axis2.signserver.clientws.ClientWSServiceStub.SignResponseE;

/**
 * Xử lý thêm stock vào DB
 * 
 * @author HungDMc
 *
 */
@WebServlet("/AddStock")
public class AddStockServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger _LOG = Logger.getLogger(AddStockServlet.class);
	
	StockDAO stockDAO = new StockDAO();

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		User userSession = (User) session.getAttribute("user");
		if (session == null || userSession == null) {
			resp.sendRedirect("login");
			return;
		}
		
		PrintWriter pw = null;
		
		try {
			pw = resp.getWriter();
			
			String type = req.getParameter("type");
			String name = req.getParameter("name");
			int amounts = Integer.valueOf(req.getParameter("amounts"));
			String commandType = req.getParameter("commandType");
			double price = Double.valueOf(req.getParameter("price"));
			String market = req.getParameter("market");
			String clientDataSigned = req.getParameter("clientDataSigned");
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date transactionTime = sdf.parse(req.getParameter("transactionTime"));
			
			// Validate
			boolean valid = true;
			if (isNullOrEmpty(type) 
					|| isNullOrEmpty(name)
					|| amounts == 0 
					|| isNullOrEmpty(commandType)
					|| price == 0d
					|| isNullOrEmpty(market)
					|| isNullOrEmpty(clientDataSigned) 
					|| transactionTime == null)
				valid = false;
			
			JSONObject result = new JSONObject();
			if (!valid) {
				result.put("status", false);
				result.put("message", "một số dữ liệu đầu vào còn thiếu!");
			} else {
				// System.out.println(type + "\n" + name + "\n" + amounts + "\n" + commandType + "\n" + price + "\n" + market + "\n" + clientDataSigned + "\n" + transactionTime);
				Stock stock = new Stock();
				stock.setType(type);
				stock.setName(name);
				stock.setAmounts(amounts);
				stock.setCommandType(commandType);
				stock.setPrice(price);
				stock.setMarket(market);
				stock.setClientDataSigned(clientDataSigned);
				
				// SignServer ký tiếp lên dữ liệu mà client đã ký
				SSLHandler sslHandle = new SSLHandler();
				sslHandle.setSSL();
				byte[] dataSigned = sign(Base64.decodeBase64(clientDataSigned.getBytes()), "3", null);  // 3 la workerId ky test
				String signed = new String(Base64.encodeBase64(dataSigned));
				stock.setServerDataSigned(signed);
				
				stock.setTransactionTime(transactionTime);
				
				boolean inserted = stockDAO.insert(stock);
				if (inserted) {
					result.put("status", true);
					result.put("message", null);
				} else {
					result.put("status", false);
					result.put("message", "không thể thêm phiên giao dịch vào cơ sở dữ liệu!");
				}
			}
			
			pw.println(result.toJSONString());
		} catch (Exception e) {
			_LOG.error("#doGet(?, ?): Exception occurs...\r\n==> ", e);
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

	private boolean isNullOrEmpty(String str) {
		return str == null || str.isEmpty();
	}
	
	public byte[] sign(byte[] data, String workerName, String tagName) {
		
		byte[] result = null;
		
		if (isNullOrEmpty(workerName) 
				|| (data == null || data.length == 0)) {
			
			_LOG.error("#sign(?, ?): Dữ liệu đầu vào không hợp lệ! [byte[] = null | rỗng, hoặc workerName null hoặc rỗng]");
			return result;
		}

		try {
			ClientWSServiceStub stub = new ClientWSServiceStub();
			DataHandler dataToSign = new DataHandler(data, "application/octet-stream");

			SignData param = new SignData();
			param.setDataToSign(dataToSign);
			param.setWorkerName(workerName);
			param.setNodeContainSignature(tagName);
			Sign sign = new Sign();
			sign.setSigndata(param);
			SignE signE = new SignE();
			signE.setSign(sign);
			SignResponseE responseE = stub.sign(signE);
			SignResponse response = responseE.getSignResponse();
			DataHandler signedData = response.get_return().getData();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			signedData.writeTo(out);
			result = out.toByteArray();
		} catch (Exception e) {
			return result;
		}

		return result;
	}
	
}
