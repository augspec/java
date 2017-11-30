package com.aug.soapclient;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPMessage;

public class Test {

	public static void main(String[] args) throws Exception {
		StringBuilder request = new StringBuilder();
		request.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns1=\"http://www.dataaccess.com/webservicesserver/\">");
		request.append("<soapenv:Header/>");
		request.append("<soapenv:Body>");
		request.append("<ns1:NumberToDollars>");
		request.append("<ns1:dNum>1</ns1:dNum>");
		request.append("</ns1:NumberToDollars>");
		request.append("</soapenv:Body>");
		request.append("</soapenv:Envelope>");
		
		String targetNamespace = "http://www.dataaccess.com/webservicesserver/";
		QName serviceName = new QName(targetNamespace, "NumberConversion");
        QName portName = new QName(targetNamespace, "NumberConversionSoap");
        String endpointUrl = "http://www.dataaccess.com/webservicesserver/numberconversion.wso?wsdl";
        String SOAPAction = "";

        SOAPMessage response = SoapClientUtil.invoke(serviceName, portName, endpointUrl, SOAPAction, request.toString());
        SOAPBody body = response.getSOAPBody();
        if (body.hasFault()) {
            System.out.println(body.getFault());
        } else {
        	System.out.println(response.getSOAPBody().getFirstChild().getTextContent().trim());
        }
	}
}
