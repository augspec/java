package com.bkav.bkavcoreca.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.JSONObject;
import org.xml.sax.SAXException;

import com.bkav.bkavcoreca.database.BankTransactionDAO;
import com.bkav.bkavcoreca.database.CertUser;
import com.bkav.bkavcoreca.database.CertUserDAO;
import com.bkav.bkavcoreca.database.User;
import com.bkav.bkavcoreca.pdf.BankReceipt;
import com.bkav.bkavcoreca.pdf.BankReceiptPDF;
import com.bkav.bkavcoreca.utils.Base64;
import com.bkav.bkavcoreca.utils.RemoteCodeSigner;
import com.bkav.bkavcoreca.xml.BankTransactionXML;

@WebServlet("/BankTransaction")
public class BankTransactionServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	final String VIEW = "/bank/bankTransaction.jsp";
	
	public BankTransactionServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession session = request.getSession();
		
		if (session == null || session.getAttribute("user") == null) {
			response.sendRedirect("login");
			return;
		}
		
		User user = (User) session.getAttribute("user");

		List<CertUser> certUserList = CertUserDAO.getCertUserByEmail(user.getEmail());
		
		request.setCharacterEncoding("utf-8");
		request.setAttribute("certUserList", certUserList);
		
		RequestDispatcher view = request.getRequestDispatcher(VIEW);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if (session == null || session.getAttribute("user") == null) {
			response.sendRedirect("login");
			return;
		}
		
		Map<String, String> messageReturnAjax = new HashMap<String, String>();
		
		String currentTimeM = Long.toString(System.currentTimeMillis());
		//String pathFiletoSign = "";
		//String pathfileSigned = "";
		String pathToSign = "S://Ban HTCA/Temp/CodeThangNTc/CodeThangNTc/datawebdemo/" + currentTimeM + ".pdf";
		String pathToSigned = "S://Ban HTCA/Temp/CodeThangNTc/CodeThangNTc/datawebdemo/" + currentTimeM + "signed.pdf";
		
		String logTransactionSigned = request.getParameter("logTransactionSigned");
		System.out.println(logTransactionSigned);		
		
		if (logTransactionSigned == null || logTransactionSigned.isEmpty()) {
			
			messageReturnAjax.put("message", "false");
			forward(request, response, messageReturnAjax);
		}
		
		try {
			
			BankReceipt bankReceipt = BankTransactionXML.getBankReceipt(logTransactionSigned);
			if (bankReceipt.getCodeOTP() == null || bankReceipt.getCodeOTP().isEmpty()) {
				messageReturnAjax.put("message", "false");
				forward(request, response, messageReturnAjax);
				return;
			}
			
			boolean statusCreateBankReceipt = BankReceiptPDF.createBankReceiptPDF(bankReceipt, pathToSign);
			if (!statusCreateBankReceipt) {
				messageReturnAjax.put("message", "false");
				forward(request, response, messageReturnAjax);
				return;
			}
			
			/*boolean statusSignPDFBySignServer = signPDFBySignServer(pathToSign, pathToSigned);			
			if (!statusSignPDFBySignServer) {
				messageReturnAjax.put("message", "false");
				forward(request, response, messageReturnAjax);
				return;
			}*/
			
			String xml = new String(Base64.decode(logTransactionSigned.getBytes()), "UTF-8");
			OutputStream out = new FileOutputStream(pathToSigned + ".xml");
			out.write(xml.getBytes());
			out.close();
			
			boolean statusInsertBankTransaction = BankTransactionDAO.insert(bankReceipt, pathToSigned);			
			if (!statusInsertBankTransaction) {
				messageReturnAjax.put("message", "false");
				forward(request, response, messageReturnAjax);
				return;
			}
			
		} catch (ParserConfigurationException | SAXException e) {
			e.printStackTrace();
			messageReturnAjax.put("message", "false");
			forward(request, response, messageReturnAjax);
			return;
		}
		
		
		messageReturnAjax.put("message", "ok");
		forward(request, response, messageReturnAjax);
		
		
/*		String username = request.getParameter("xmlTransation");
		RequestDispatcher view = request.getRequestDispatcher(VIEW);
		view.forward(request, response);*/
				
	}	
	
	protected void forward(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> messageReturnAjax) throws IOException {
		
		JSONObject json = new JSONObject(messageReturnAjax);		
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		return;
	}
	
	public boolean signPDFBySignServer(String filetoSign, String fileSigned) {
		boolean result = true;
		
		try {
			
			Path pdfPath = Paths.get(filetoSign);
			byte[] pdfByte = Files.readAllBytes(pdfPath);
			
			RemoteCodeSigner remoteCodeSigner = new RemoteCodeSigner();
			byte[] pdfSignedByte = remoteCodeSigner.sign(pdfByte, "PDFSigner1"); //worker: 0101360697_PDF - 24
						
			OutputStream out = new FileOutputStream(fileSigned);
			out.write(pdfSignedByte);
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		
		for (int i = 0; i < 100000; i++) {
			Path pdfPath = Paths.get("S://Ban HTCA/Temp/CodeThangNTc/CodeThangNTc/center_texted.pdf");
			byte[] pdfByte = Files.readAllBytes(pdfPath);
			
			RemoteCodeSigner remoteCodeSigner = new RemoteCodeSigner();
			@SuppressWarnings("unused")
			int pdfSignedByte = remoteCodeSigner.verify(pdfByte, "0101360697_V_PDF");//Validator: 0101360697_PDF - 25
			
			new BankTransactionServlet().signPDFBySignServer
			("S://Ban HTCA/Temp/CodeThangNTc/CodeThangNTc/sign.pdf" , "S://Ban HTCA/Temp/CodeThangNTc/CodeThangNTc/center_texted.pdf");
			
		}
		

		
//		OutputStream out = new FileOutputStream("/home/thangntc/Desktop/createPDF/center_texted.pdf");
//		out.write(pdfSignedByte);
//		out.close();	
	}
}
