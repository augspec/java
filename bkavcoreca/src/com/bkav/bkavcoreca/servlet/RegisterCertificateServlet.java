package com.bkav.bkavcoreca.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.bkav.bkavcoreca.database.CertUser;
import com.bkav.bkavcoreca.database.CertUserDAO;
import com.bkav.bkavcoreca.database.User;
import com.bkav.bkavcoreca.database.UserDAO;
import com.bkav.bkavcoreca.xml.InfoCertificateXML;

@WebServlet("/RegisterCertificate")
public class RegisterCertificateServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	final String VIEW = "/registercertificate/registercertificate.jsp";
	
	public RegisterCertificateServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		User userSession = (User) session.getAttribute("user");
		if (session == null || session.getAttribute("user") == null) {
			response.sendRedirect("login");
			return;
		}
		
		List<CertUser> certUserList = CertUserDAO.getCertUserByEmail(userSession.getEmail());
		
		request.setAttribute("certUserList", certUserList);
		RequestDispatcher view = request.getRequestDispatcher(VIEW);
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		User userSession = (User) session.getAttribute("user");
		if (session == null || session.getAttribute("user") == null) {
			response.sendRedirect("login");
			return;
		}
		
		String typeAction = request.getParameter("typeAction");
		
		if (typeAction.equals("addcert")) {
			Map<String, String> messageReturnAjax = new HashMap<String, String>();
			
			String infoCert = request.getParameter("infoCert");
			String user = request.getParameter("user");
			
			if (infoCert == null || infoCert.equals("") || user == null || user.equals("")) {
				messageReturnAjax.put("message", "false");
				forward(request, response, messageReturnAjax);
			}
			
			try {
												
				CertUser certUser = InfoCertificateXML.getInfoCert(infoCert);
				certUser.setUser(userSession);
				
				int isDuplicateCert = CertUserDAO.isDuplicateBySerialNumber(certUser.getCertSerialNumber());
				
				if (isDuplicateCert == CertUserDAO.DUPLICATE_SERIAL_FALSE) {
					
					boolean insertInfoCert= CertUserDAO.insert(certUser);
										
					if (!insertInfoCert) {
						messageReturnAjax.put("message", "false");
						messageReturnAjax.put("log", "");
						forward(request, response, messageReturnAjax);
					} else {
						messageReturnAjax.put("message", "ok");
						forward(request, response, messageReturnAjax);
					}
				} else {
					messageReturnAjax.put("message", "false");
					messageReturnAjax.put("log", "Chữ ký số đã được đăng ký trên hệ thống");
					forward(request, response, messageReturnAjax);
				}
							
				
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
				messageReturnAjax.put("message", "false");
				messageReturnAjax.put("log", "");
				forward(request, response, messageReturnAjax);
			} catch (SAXException e) {
				e.printStackTrace();
				messageReturnAjax.put("message", "false");
				messageReturnAjax.put("log", "");
				forward(request, response, messageReturnAjax);
			}
		}
		
		if (typeAction.equals("deletecert")) {
			
			Map<String, String> messageReturnAjax = new HashMap<String, String>();				
			try {
				String certUserIdString = request.getParameter("certUserId");
				int certUserId = Integer.parseInt(certUserIdString);
				
				boolean deteleCert = CertUserDAO.delete(certUserId);
				
				if (!deteleCert) {
					messageReturnAjax.put("message", "false");
					messageReturnAjax.put("log", "");
					forward(request, response, messageReturnAjax);
				} else {
					messageReturnAjax.put("message", "ok");
					forward(request, response, messageReturnAjax);
				}			
				
			} catch (IOException e) {
				e.printStackTrace();
				messageReturnAjax.put("message", "false");
				messageReturnAjax.put("log", "");
				forward(request, response, messageReturnAjax);
			}
		}		
		
	}

	protected void forward(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> messageReturnAjax) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);
		
		User userSession = (User) session.getAttribute("user");
		User user = UserDAO.getUser(userSession.getEmail());
		session.removeAttribute("user");
		session.setAttribute("user", user);
		
		JSONObject json = new JSONObject(messageReturnAjax);		
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		return;

	}
}
