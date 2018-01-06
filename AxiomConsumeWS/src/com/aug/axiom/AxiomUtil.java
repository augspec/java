package com.aug.axiom;

import java.util.Map;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.SOAP11Constants;
import org.apache.axiom.soap.SOAP12Constants;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;

public class AxiomUtil {

	public static final String ENPOINT_URI = "Some enpoint";
	
	public static final String REPOSITORY_PATH = Utils.getProp().getProperty("axiom-ws.repository");
	public static final String AXIS2XML_PATH = Utils.getProp().getProperty("axiom-ws.axis2xml");
	public static final boolean CHUNKED = Utils.getProp().getProperty("axiom-ws.transport.chunked")
			.equalsIgnoreCase("true") ? true : false;
	public static final boolean IS_SOAP12 = Utils.getProp().getProperty("axiom-ws.soap12")
			.equalsIgnoreCase("true") ? true : false;
	public static final int TIMEOUT = isNullOrEmplty(Utils.getProp().getProperty("axiom-ws.timeOutInMilliSeconds")) ? 0 
			: Integer.valueOf(Utils.getProp().getProperty("axiom-ws.timeOutInMilliSeconds"));
	public static final boolean IS_ENGAGE_ADDRESSING = Utils.getProp().getProperty("axiom-ws.engageModule.addressing")
			.equalsIgnoreCase("true") ? true : false;
	
	private static ServiceClient serviceClient;
	
	static {
		try {
			ConfigurationContext context = ConfigurationContextFactory.createConfigurationContextFromFileSystem(REPOSITORY_PATH, AXIS2XML_PATH);
			serviceClient = new ServiceClient(context, null);
			
			Options opts = new Options();
	        opts.setProperty(org.apache.axis2.transport.http.HTTPConstants.CHUNKED, CHUNKED);
	        opts.setSoapVersionURI(IS_SOAP12 ? SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI : SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI);
	        opts.setTimeOutInMilliSeconds(TIMEOUT > 0 ? TIMEOUT : 60000);  // 1 phut
	        if (IS_ENGAGE_ADDRESSING)
	        	serviceClient.engageModule("addressing");
	        
	        serviceClient.setOptions(opts);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static OMElement createPayload(String namespace, String method, Map<String, Object> paramsAndValuesMap) {
		if (isNullOrEmplty(namespace) || isNullOrEmplty(method))
			return null;
		
		OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace(namespace, "ns");
        
        OMElement methodExecute = fac.createOMElement(method, omNs);
        if (paramsAndValuesMap != null) {
	        for (Map.Entry<String, Object> entry : paramsAndValuesMap.entrySet()) {
	        	String paramName = entry.getKey();
	        	Object paramValue = entry.getValue();
	        	
	        	OMElement paramElement = fac.createOMElement(paramName, omNs);
	        	paramElement.setText(String.valueOf(paramValue));
	        	
	        	methodExecute.addChild(paramElement);
	        }
        }
		
		return methodExecute;
	}
	
	public static OMElement callService(String enpointUri, String action, String namespace, 
			String method, Map<String, Object> paramsAndValuesMap) {
		// TODO: validate
		OMElement payload = createPayload(namespace, method, paramsAndValuesMap);
		
		Options opts = new Options();
		opts.setTo(new EndpointReference(enpointUri));
		opts.setAction(action);
		serviceClient.setOverrideOptions(opts);
		
		OMElement result = null;
		try {
			result = serviceClient.sendReceive(payload);
		} catch (AxisFault e) {
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
		
		return result;
	}
	
	public static void main(String[] args) {
		
		System.out.println(TIMEOUT);
	}
	
	private static boolean isNullOrEmplty (String str) {
		
		return str == null || str.isEmpty();
	}
}
