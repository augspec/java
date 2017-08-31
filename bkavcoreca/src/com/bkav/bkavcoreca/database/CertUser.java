package com.bkav.bkavcoreca.database;


import java.util.Date;


public class CertUser {
	public static final int IS_ADMIN = 1;
	private int id;
	private User user;
	private String certCommonName;
	private String certSubjectDN;
	private Date certValidFrom;
	private Date certValidTo;
	private String certSerialNumber;

	public CertUser() {
	}

	public CertUser(int id, User user, String certCommonName, String certSubjectDN, Date certValidFrom,
			Date certValidTo,String certSerialNumber ) {
		this.id = id;
		this.user = user;
		this.certCommonName = certCommonName;
		this.certSubjectDN = certSubjectDN;
		this.setCertValidFrom(certValidFrom);
		this.certValidTo = certValidTo;
		this.certSerialNumber = certSerialNumber;		
	}
	
	public CertUser(int id, String certCommonName, String certSubjectDN, Date certValidFrom,
			Date certValidTo,String certSerialNumber ) {
		this.id = id;
		this.certCommonName = certCommonName;
		this.certSubjectDN = certSubjectDN;
		this.setCertValidFrom(certValidFrom);
		this.certValidTo = certValidTo;
		this.certSerialNumber = certSerialNumber;		
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCertValidFrom() {
		return certValidFrom;
	}

	public void setCertValidFrom(Date certValidFrom) {
		this.certValidFrom = certValidFrom;
	}

}
