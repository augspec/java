package com.aug.soapclient;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.SOAP12Constants;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;

public class AxiomClient {
	
	private static ServiceClient serviceClient;
	static {
		try {
			ConfigurationContext context = ConfigurationContextFactory.createConfigurationContextFromFileSystem("E:\\GitHub\\java\\SoapClientConsumeWS\\META-INF", "E:\\GitHub\\java\\SoapClientConsumeWS\\META-INF\\conf\\axis2.xml");
	        
	        serviceClient = new ServiceClient(context, null); 
	        Options opts = new Options();
	        opts.setTo(new EndpointReference("https://103.9.200.65:9999/TaxServiceExt.svc?wsdl"));
	        opts.setAction("http://tempuri.org/ITaxServiceExt/getTaxInfo");
	        opts.setProperty(org.apache.axis2.transport.http.HTTPConstants.CHUNKED, Boolean.FALSE);
	        opts.setSoapVersionURI(SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI);
	        
	        serviceClient.engageModule("addressing");
	        serviceClient.setOptions(opts);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static OMElement createPayLoad(String taxCode) {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace("http://tempuri.org/", "ns1");
        OMElement getTaxtInfo = fac.createOMElement("getTaxInfo", omNs);
        OMElement parameter = fac.createOMElement("maSoThue", omNs);
        parameter.setText(taxCode);
        getTaxtInfo.addChild(parameter);
        
        return getTaxtInfo;
    }
	
	public static TaxInfo getTaxInfo(String taxCode) {
		TaxInfo info = null;
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		
		try {
	        OMElement result = serviceClient.sendReceive(createPayLoad(taxCode));
	        
	        OMElement taxInfo = (OMElement) result.getChildrenWithName(new QName("getTaxInfoResult")).next();
	        OMElement data = (OMElement) taxInfo.getChildrenWithName(new QName("Data")).next();
	        OMElement status = (OMElement) taxInfo.getChildrenWithName(new QName("Status")).next();
	        OMElement message = (OMElement) taxInfo.getChildrenWithName(new QName("Message")).next();
	        
	        if (status.getText().equals("1")) {
	        	@SuppressWarnings("unchecked")
				Iterator<OMElement> iterate = data.getChildElements();
	        	
	        	Field[] fields = TaxInfo.class.getDeclaredFields();
	        	info = new TaxInfo();
	        	
	            while (iterate.hasNext()) {
	            	OMElement e = iterate.next();
	            	
	            	for (Field field : fields) {
	            		if (field.getName().equals(e.getLocalName())) {
	            			field.setAccessible(true);
	            			if (field.getName().equals("NgayCapDKKD") 
	            					|| field.getName().equals("NgayCapNhat") 
	            					|| field.getName().equals("NgayDangKyMST")) {
	            				Date date = sdf.parse(e.getText().trim());
		            			field.set(info, date);
	            			} else
		            			field.set(info, e.getText().trim());
	            			field.setAccessible(false);
	            			
	            			break;
	            		}
	            	}
	            }
	        } else
	        	System.out.println(message.getText());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (serviceClient != null) {
				try {
					serviceClient.cleanup();
				} catch (AxisFault e) {
					e.printStackTrace();
				}
				try {
					serviceClient.cleanupTransport();
				} catch (AxisFault e) {
					e.printStackTrace();
				}
			}
		}
		
		return info;
	}

    public static void main(String[] args)throws AxisFault, ParseException {
        TaxInfo info = getTaxInfo("0101360697");
        System.out.println("MST: " + info.getMaSoThue() + "\nTenGiaoDich: " + info.getTenGiaoDich() + "\nNgayDangKyMST: " + info.getNgayDangKyMST());
    }
}
