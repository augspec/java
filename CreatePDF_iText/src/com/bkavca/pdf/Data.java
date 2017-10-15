package com.bkavca.pdf;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Data implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String numberId;
	private String commonName;
	private String certSerial;
	private SubjectDN subjectDn;
	private IssuerDN issuerDn;
	private String pairOfKeysLength;
	private String properties;
	private String startEndDate;
	private String publishDate;
	
	public Data() {
		super();
	}

	public Data(String numberId, String commonName, String certSerial,
			SubjectDN subjectDn, IssuerDN issuerDn, String pairOfKeysLength,
			String properties, String startEndDate, String publishDate) {
		super();
		this.numberId = numberId;
		this.commonName = commonName;
		this.certSerial = certSerial;
		this.subjectDn = subjectDn;
		this.issuerDn = issuerDn;
		this.pairOfKeysLength = pairOfKeysLength;
		this.properties = properties;
		this.startEndDate = startEndDate;
		this.publishDate = publishDate;
	}

	public String getNumberId() {
		return numberId;
	}

	public void setNumberId(int incidentId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yy");
		String year = sdf.format(new Date());
		
		this.numberId = incidentId + "/BkavCA" + year;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getCertSerial() {
		return certSerial;
	}

	public void setCertSerial(String certSerial) {
		this.certSerial = certSerial;
	}

	public SubjectDN getSubjectDn() {
		return subjectDn;
	}

	public void setSubjectDn(SubjectDN subjectDn) {
		this.subjectDn = subjectDn;
	}

	public IssuerDN getIssuerDn() {
		return issuerDn;
	}

	public void setIssuerDn(IssuerDN issuerDn) {
		this.issuerDn = issuerDn;
	}

	public String getPairOfKeysLength() {
		return pairOfKeysLength;
	}

	public void setPairOfKeysLength(int pairOfKeysLength) {
		this.pairOfKeysLength = pairOfKeysLength + " bits";
	}

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	public String getStartEndDate() {
		return startEndDate;
	}

	public void setStartEndDate(Date startDate, Date endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String _startDate = sdf.format(startDate);
		String _endDate = sdf.format(endDate);
		
		this.startEndDate = _startDate + " - " + _endDate;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.publishDate = sdf.format(publishDate);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\n");
		sb.append("\tnumberId: " + this.numberId + ",\n");
		sb.append("\tcommonName: " + this.commonName + ",\n");
		sb.append("\tcertSerial: " + this.certSerial + ",\n");
		
		sb.append("\tsubjectDn: {\n");
		sb.append("\t\tcN: " + this.subjectDn.getcN() + ",\n");
		sb.append("\t\tuId: " + this.subjectDn.getuId() + ",\n");
		sb.append("\t\tl: " + this.subjectDn.getL() + ",\n");
		sb.append("\t\ts: " + this.subjectDn.getS() + ",\n");
		sb.append("\t\tc: " + this.subjectDn.getC() + "\n");
		sb.append("\t},\n");
		
		sb.append("\tissuerDn: {\n");
		sb.append("\t\tcN: " + this.issuerDn.getcN() + ",\n");
		sb.append("\t\to: " + this.issuerDn.getO() + ",\n");
		sb.append("\t\tl: " + this.issuerDn.getL() + ",\n");
		sb.append("\t\tc: " + this.issuerDn.getC() + "\n");
		sb.append("\t},\n");
		
		sb.append("\tpairOfKeysLength: " + this.pairOfKeysLength + ",\n");
		sb.append("\tproperties: " + this.properties + ",\n");
		sb.append("\tstartEndDate: " + this.startEndDate + ",\n");
		sb.append("\tpublishDate: " + this.publishDate + "\n");
		sb.append("}");
		
		return sb.toString();
	}

	public static void main(String[] args) {
		Data data = new Data();
		data.setNumberId(1789);
		data.setCommonName("Bkav");
		data.setCertSerial("54034e89d5dd6a6afab24d656a3a93bd");

		SubjectDN sjDn = new SubjectDN();
		sjDn.setcN("CÔNG TY CỔ PHẦN KỸ THUẬT CÔNG NGHIỆP Á CHÂU");
		sjDn.setuId("MST: 0102073536");
		sjDn.setC("VN");
		sjDn.setL("Ba Đình");
		sjDn.setS("Hà Nội");
		
		data.setSubjectDn(sjDn);
		
		IssuerDN isDn = new IssuerDN();
		isDn.setcN("BkavCA");
		isDn.setO("Bkav Corporation");
		isDn.setL("Hanoi");
		isDn.setC("VN");
		
		data.setIssuerDn(isDn);
		data.setPairOfKeysLength(1024);
		data.setProperties("Documents Signing");
		data.setStartEndDate(new Date(), new Date());
		data.setPublishDate(new Date());
		
		String s = data.toString();
		System.out.println(s);
	}
	
}
