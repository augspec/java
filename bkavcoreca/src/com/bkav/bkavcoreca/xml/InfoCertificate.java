package com.bkav.bkavcoreca.xml;

import java.util.Date;

public class InfoCertificate {

	String subjectDN;
	String commonName;
	String serialNumber;
	Date validFrom;
	Date validTo;
	
	public InfoCertificate() {
		
	}
	
	public InfoCertificate(String subjectDN, String commonName, 
			String serialNumber, Date validFrom, Date validTo) {
		this.subjectDN = subjectDN;
		this.commonName = commonName;
		this.serialNumber = serialNumber;
		this.validFrom = validFrom;
		this.validTo = validTo;
	}

	public String getSubjectDN() {
		return subjectDN;
	}

	public void setSubjectDN(String subjectDN) {
		this.subjectDN = subjectDN;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	
	
	
}
