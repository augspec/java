package com.aug.soapclient;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPMessage;

import com.aug.util.SSLOneWayHandler;

public class Test {

	static {
	    HttpsURLConnection.setDefaultHostnameVerifier( 
	        new HostnameVerifier(){
				@Override
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
	    });
	}
	
	public static void main(String[] args) throws Exception {
		/*SSLOneWayHandler handle = new SSLOneWayHandler();
		handle.setSSL();
		
		StringBuilder request = new StringBuilder();
		request.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns1=\"http://tempuri.org/\">");
		request.append("<soapenv:Header/>");
		request.append("<soapenv:Body>");
		request.append("<ns1:Add>");
		request.append("<ns1:n1>4</ns1:n1>");
		request.append("<ns1:n2>67</ns1:n2>");
		request.append("</ns1:Add>");
		request.append("</soapenv:Body>");
		request.append("</soapenv:Envelope>");

		String targetNamespace = "http://tempuri.org/";
		QName serviceName = new QName(targetNamespace, "WebServiceForTesting");
		QName portName = new QName(targetNamespace, "BasicHttpsBinding_IWebServiceForTesting");
		String endpointUrl = "https://servicebeta.bkavca.vn:8443/WebServiceForTesting.svc?wsdl";
		String SOAPAction = "http://tempuri.org/IWebServiceForTesting/Add";

		SOAPMessage response = SoapClientUtil.invoke(serviceName, portName,
				endpointUrl, SOAPAction, request.toString());
		SOAPBody body = response.getSOAPBody();
		if (body.hasFault()) {
			System.out.println(body.getFault());
		} else {
			System.out.println(response.getSOAPBody().getFirstChild()
					.getTextContent().trim());
		}*/
		
		StringBuilder request = new StringBuilder();
		request.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns1=\"http://tempuri.org/\">");
		request.append("<soapenv:Header/>");
		request.append("<soapenv:Body>");
		request.append("<ns1:getTaxInfo>");
		request.append("<ns1:maSoThue>0101360697</ns1:maSoThue>");
		request.append("</ns1:getTaxInfo>");
		request.append("</soapenv:Body>");
		request.append("</soapenv:Envelope>");

		String targetNamespace = "http://tempuri.org/";
		QName serviceName = new QName(targetNamespace, "TaxServiceExt");
		QName portName = new QName(targetNamespace, "WSHttpBinding_ITaxServiceExt");
		String endpointUrl = "https://103.9.200.65:9999/TaxServiceExt.svc?wsdl";
		String SOAPAction = "http://tempuri.org/ITaxServiceExt/getTaxInfo";

		SOAPMessage response = SoapClientUtil.invoke(serviceName, portName,
				endpointUrl, SOAPAction, request.toString());
		SOAPBody body = response.getSOAPBody();
		if (body.hasFault()) {
			System.out.println(body.getFault());
		} else {
			System.out.println(response.getSOAPBody().getFirstChild()
					.getTextContent().trim());
		}
	}
}
