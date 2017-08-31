package com.bkav.bkavcoreca.database;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;

import org.bouncycastle.util.encoders.Base64;

public class User {
	public static final int IS_ADMIN = 1;
	private int id;
	private String email;
	private String password;
	private String fullName;
	private String phoneNumber;
	private String department;
	private String image;
	private String cert;
	private int isAdmin;
	private String certCommonName;
	private String certSubjectDN;
	private Date certValidForm;
	private Date certValidTo;
	private String certSerialNumber;

	public User() {
	}

	public User(int id, String email, String password, String fullName,
			String phoneNumber, String department, String image, String cert,
			int isAdmin, String certCommonName, String certSubjectDN, Date certValidForm,
			Date certValidTo,String certSerialNumber ) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.setDepartment(department);
		this.setImage(image);
		this.setCert(cert);
		this.setIsAdmin(isAdmin);
		this.certCommonName = certCommonName;
		this.certSubjectDN = certSubjectDN;
		this.certValidForm = certValidForm;
		this.certValidTo = certValidTo;
		this.certSerialNumber = certSerialNumber;		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCert() {
		return cert;
	}

	
	public String getCertCommonName() {
		return certCommonName;
	}

	public void setCertCommonName(String certCommonName) {
		this.certCommonName = certCommonName;
	}

	public String getCertSubjectDN() {
		return certSubjectDN;
	}

	public void setCertSubjectDN(String certSubjectDN) {
		this.certSubjectDN = certSubjectDN;
	}

	public Date getCertValidForm() {
		return certValidForm;
	}

	public void setCertValidForm(Date certValidForm) {
		this.certValidForm = certValidForm;
	}

	public Date getCertValidTo() {
		return certValidTo;
	}

	public void setCertValidTo(Date certValidTo) {
		this.certValidTo = certValidTo;
	}

	public String getCertSerialNumber() {
		return certSerialNumber;
	}

	public void setCertSerialNumber(String certSerialNumber) {
		this.certSerialNumber = certSerialNumber;
	}

	public X509Certificate getX509Certificate() {
		byte[] decoded = null;
		try {
			decoded = Base64.decode(cert);
		} catch (Exception e) {
			return null;
		}
		if (decoded == null) {
			return null;
		}

		InputStream inStream = new ByteArrayInputStream(decoded);
		try {
			CertificateFactory certFactory = CertificateFactory
					.getInstance("X509");
			Certificate cert = certFactory.generateCertificate(inStream);
			if (cert != null && cert instanceof X509Certificate) {
				return (X509Certificate) cert;
			} else {
				return null;
			}
		} catch (CertificateException e) {
			return null;
		}

	}

	public void setCert(String cert) {
		this.cert = cert;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

}
