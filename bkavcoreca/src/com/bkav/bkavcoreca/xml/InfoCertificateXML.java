package com.bkav.bkavcoreca.xml;

import java.io.IOException;
import java.io.StringReader;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.bkav.bkavcoreca.database.CertUser;

public class InfoCertificateXML {

	@SuppressWarnings("deprecation")
	public static CertUser getInfoCert(String xml) throws ParserConfigurationException, 
		SAXException, IOException {
		
		CertUser certUser = new CertUser();
		String subjectDN = "";
		if (xml == null || xml.equals("")) {
			return certUser;
		}
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(new InputSource(new StringReader(xml.replaceAll("(\r\n|\n)", ""))));
		
		//Level 1
		NodeList nSubjectDNList = document.getElementsByTagName("SubjectDN");		
		Element eSubjectDN = (Element) nSubjectDNList.item(0);
		NodeList nInSubjectDN = eSubjectDN.getElementsByTagName("*");
		

	    for (int i = 0; i < nInSubjectDN.getLength(); i++)
	    {
	    	
	    	String nodeName = nInSubjectDN.item(i).getNodeName();
	    	String contentOfNode = nInSubjectDN.item(i).getTextContent();
	    	
	    	if (!contentOfNode.isEmpty()) {
	    		subjectDN = subjectDN + nodeName + "=" + contentOfNode;
				if (i != nInSubjectDN.getLength() -1) {
					subjectDN = subjectDN + ", ";				
				}
				
				if(nodeName.equals("CN")) {
					certUser.setCertCommonName(contentOfNode);
				}
	    	}
	    	
	    }
	    certUser.setCertSubjectDN(subjectDN);
	    String serialNumber = 
	    		document.getElementsByTagName("SerialNumber").item(0).getTextContent();
	    certUser.setCertSerialNumber(serialNumber);
	    
	    String timeValidFrom = 
	    		document.getElementsByTagName("TimeValidFrom").item(0).getTextContent();
	    certUser.setCertValidFrom(new Date(timeValidFrom));
	    
	    String timeValidTo = 
	    		document.getElementsByTagName("TimeValidTo").item(0).getTextContent();
	    certUser.setCertValidTo(new Date(timeValidTo));
		
		return certUser;
	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		String xml = "<Certificate><SubjectDN><CN>VSD SSL Client</CN><C>VN</C><L>Hai Bà Trưng</L><ST>Hà Nội</ST><O/><OU/><UID>MST:0123456789</UID><Email/></SubjectDN><IssuerDN><CN>TestCA</CN><C>VN</C><L/><ST/><O>TestCA Corp</O><OU/><UID/><Email/></IssuerDN><SerialNumber>1d637d003944db58</SerialNumber><TimeValidFrom>16/03/2016 22:09:27</TimeValidFrom><TimeValidTo>15/03/2021 22:09:27</TimeValidTo></Certificate>";
		CertUser cert = getInfoCert(xml);
		System.out.println(cert.getCertSubjectDN());
	}
}
