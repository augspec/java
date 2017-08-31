package com.bkav.bkavcoreca.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.DataHandler;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.bkav.bkavcoreca.database.CertUser;
import com.bkav.bkavcoreca.database.CertUserDAO;
import com.bkav.bkavcoreca.database.User;
//import com.bkav.bkavcoreca.utils.CodeSignerFactory;
import com.bkav.bkavcoreca.utils.RemoteCodeSigner;
import com.bkav.bkavcoreca.utils.SSLHandler;
import com.bkavca.axis2.signserver.clientws.ClientWSServiceStub;
import com.bkavca.axis2.signserver.clientws.ClientWSServiceStub.ValidationDataResponse;
import com.bkavca.axis2.signserver.clientws.ClientWSServiceStub.Verify;
import com.bkavca.axis2.signserver.clientws.ClientWSServiceStub.VerifyData;
import com.bkavca.axis2.signserver.clientws.ClientWSServiceStub.VerifyE;
import com.bkavca.axis2.signserver.clientws.ClientWSServiceStub.VerifyResponse;
import com.bkavca.axis2.signserver.clientws.ClientWSServiceStub.VerifyResponseE;

@WebServlet("/FileSign")
public class FileSignServlet  extends HttpServlet {
	
	private final Logger LOG = Logger.getLogger(FileSignServlet.class);
	
	private static final long serialVersionUID = 1L;
	private static final String PARA_TYPE_ACTION = "action";

	final String VIEW = "/filesign/filesign.jsp";
	RemoteCodeSigner remoteCodeSigner = new RemoteCodeSigner();
	public FileSignServlet() {
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
		String action = request.getParameter(PARA_TYPE_ACTION);
		if ("verify".equals(action)) {
			verify(request, response);
		}
	} 

	@SuppressWarnings("unchecked")
	private void verify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean check = ServletFileUpload.isMultipartContent(request);
		if (check) {
			List<FileItem> multiparts;
			try {
				multiparts = new ServletFileUpload(new DiskFileItemFactory())
						.parseRequest(request);

				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						if (item.getContentType().startsWith("")) {
							byte[] ks = item.get();
							if (ks != null) {
								
//								int result = CodeSignerFactory.sign(item, user);
								int result = 100;
								
								byte[] dataToVerify = item.get();								
								String fileName = item.getName();
								int index = fileName.lastIndexOf(".");
								
								String extension = fileName.substring(index + 1);
								fileName = fileName.substring(0, index) + "_" + new Date().getTime()
										+ fileName.substring(index);
								System.out.println(extension);
								switch (extension) {
								case "xml":
									//result = remoteCodeSigner.verify(dataToVerify, "XML Validator");
									SSLHandler sslHandle = new SSLHandler();
									sslHandle.setSSL();
									result = verify(dataToVerify, "4");  // 4 la workerId verify xml cua cks test
									break;
								case "docx":
								case "xlsx":
								case "pptx":
									result = remoteCodeSigner.verify(dataToVerify, "OFFICE Validator");
									break;
								case "pdf":
									result = remoteCodeSigner.verify(dataToVerify, "PDF Validator");
									break;
								default:
									result = 15;
									break;
								}
								
								LOG.info("Uploaded file " + item.getName() + " " + item.getSize());
								response.setContentType("json/application; charset=UTF-8");
								PrintWriter out = response.getWriter();

								Map<String, String> map = new HashMap<String, String>();
								if(result == 0){
									map.put("message", "OK");	
									map.put("file", "" + result);
								} else{
									map.put("message", "" + codeRetunrVerifyOCSPOfSignServer(result));
								}
								JSONObject obj = new JSONObject(map);
								out.print(obj);
								out.flush();
							} else {
								forward(request, response,
										"[Error] No file uploaded");
							}
						} else {
							forward(request, response,
									"[Error] File type not allowed");
						}
					}
				}
			} catch (FileUploadException e) {
				LOG.error("FileUploadException", e);
				forward(request, response, "[Error] " + e.getMessage());
			} catch (Exception e) {
				LOG.error("Exception", e);
				forward(request, response, "[Error] " + e.getMessage());
			}

		}
	}
	
	private String codeRetunrVerifyOCSPOfSignServer(int code) {
		String message = "";
		switch (code) {
		case 0:
			message = "Chữ ký hợp lệ";
			break;
		case -1:
			message = "Không thể load được dữ liệu đã ký";
			break;
		case -2:
			message = "Không tìm thấy chữ ký số trong dữ liệu";
			break;
		case -3:
			message = "Chữ ký đã bị thay đổi";
			break;
		case -4:
			message = "Đường dẫn tin tưởng (Trustpath) không hợp lệ";
			break;
		case -5:
			message = "Không tìm thấy chứng thư số của CA";
			break;
		case -6:
			message = "Không thể xác thực file, có ngoại lệ xảy ra";
			break;
		case 1:
			message = "Chứng thư số chưa đến hạn sử dụng";
			break;
		case 2:
			message = "Chứng thư số đã hết hạn";
			break;
		case 3:
			message = "Chứng thư số không có quyền ký";
			break;
		case 4:
			message = "Chứng thư số đã bị thu hồi";
			break;
		case 5:
			message = "Không thể kiểm tra trạng thái chứng thư số";
			break;
		case 6:
			message = "Không thể kiểm tra chứng thư số qua OCSP: Không tồn tại url trong chứng thư số";
			break;
		case 7:
			message = "Không tìm thấy chứng thư số trong chữ ký";
			break;
		case 8:
			message = "Không thể kiểm tra chứng thư số qua OCSP: response null";
			break;
		case 9:
			message = "Không thể kiểm tra chứng thư số qua CRL";
			break;	
		case 10:
			message = "Không thể kiểm tra chứng thư số qua OCSP: url không tồn tại";
			break;	
		case 11:
			message = "Chữ ký trong OCSP response không hợp lệ";
			break;	
		case 12:
			message = "Không thể khởi tạo OCSP request";
			break;	
		case 13:
			message = "Chữ ký số của CA trên chứng thư số không hợp lệ";
			break;	
		case 14:
			message = "Dùng cho ký CMS: Không có dữ liệu trong chữ ký";
			break;
		case 15:
			message = "Không hỗ trợ  xác thực chữ ký cho loại tập tin này.";
			break;				
			
		default:
			message = "Không xác định được loại lỗi. Liên hệ ban quan trị dịch vụ";
			break;
		}		
		return message;
	}
	
	private void forward(HttpServletRequest request,
			HttpServletResponse response, String message)
			throws ServletException, IOException {
		LOG.error(message);
		request.setAttribute("message", message);
		HttpSession session = request.getSession();
		if(session != null && session.getAttribute("user") != null){
			try {
				User user = (User) session.getAttribute("user");
				request.setAttribute("username", user.getFullName());
			} catch(Exception e){}
		}
		RequestDispatcher view = request.getRequestDispatcher(VIEW);
		view.forward(request, response);
	}
	
	public int verify(byte[] dataToVerify, String workerName) {
		int result = 0;
		if ((workerName == null || workerName.isEmpty()) 
				|| (dataToVerify == null || dataToVerify.length == 0)) {
			
			return -1;
		}
		
		try {
			ClientWSServiceStub stub = new ClientWSServiceStub();
			DataHandler dataHandle = new DataHandler(dataToVerify, "application/octet-stream");
			
			VerifyData verifyData = new VerifyData();
			verifyData.setSignedBytes(dataHandle);
			verifyData.setWorkerName(workerName);
			
			Verify verify = new Verify();
			verify.setData(dataHandle);
			verify.setWorker(workerName);
			
			VerifyE verifyE = new VerifyE();
			verifyE.setVerify(verify);
		
			 
			VerifyResponseE responseE = stub.verify(verifyE);
			VerifyResponse verifyResponse = responseE.getVerifyResponse();
			ValidationDataResponse response = verifyResponse.get_return();
			
			result = response.getValidateCode();
		} catch (Exception e) {
			result = -6;
		}
		
		return result;
	}
	
}
