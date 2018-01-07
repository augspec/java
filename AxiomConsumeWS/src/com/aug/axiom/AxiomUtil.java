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

/**
 * Handler call web service.
 * 
 * @author AUG
 *
 */
public class AxiomUtil {

	public static final String ENPOINT_URI = "Some enpoint";
	
	/**
	 * Absolute path of axis2 repository, read by key 'axiom-ws.repository' from axiom-config.properties
	 */
	public static final String REPOSITORY_PATH = Utils.getProp().getProperty("axiom-ws.repository");
	
	/**
	 * Absolute path of axis2 xml configuration file, read by key 'axiom-ws.axis2xml' from axiom-config.properties
	 */
	public static final String AXIS2XML_PATH = Utils.getProp().getProperty("axiom-ws.axis2xml");
	
	/**
	 * Boolean value to set property org.apache.axis2.transport.http.HTTPConstants.CHUNKED for ServiceClient
	 */
	public static final boolean CHUNKED = Utils.getProp().getProperty("axiom-ws.transport.chunked")
			.equalsIgnoreCase("true") ? true : false;
	
	/**
	 * Soap version set for ServiceClient
	 */
	public static final boolean IS_SOAP12 = Utils.getProp().getProperty("axiom-ws.soap12")
			.equalsIgnoreCase("true") ? true : false;
	
	/**
	 * Timeout when call web service (milliseconds)
	 */
	public static final int TIMEOUT = isNullOrEmplty(Utils.getProp().getProperty("axiom-ws.timeOutInMilliSeconds")) ? 0 
			: Integer.valueOf(Utils.getProp().getProperty("axiom-ws.timeOutInMilliSeconds"));
	
	/**
	 * Boolean value to set engage module 'addressing'
	 */
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
	
	private static OMElement _createPayload(String namespace, String method, Map<String, Object> paramsAndValuesMap) {
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
	
	/**
	 * Call a web service method and return OMElement.
	 * 
	 * @param enpointUri is WSDL address.
	 * @param soapAction is soapAction in WSDL document.
	 * @param targetNamespace is targetNamespace attribute in tag root of WSDL document.
	 * @param method is name of method (action) to call web service.
	 * @param paramsAndValuesMap is list of parameters of method store in Map&lt;String, Object&gt; 
	 * with parameter name is key (String) and value is an object (recommended String).
	 * @return OMElement contain result when execute web service successfully, otherwise return null.
	 * @throws Exception contain a message to notice.
	 * @author AUG
	 */
	public static OMElement callService(String enpointUri, String soapAction, String targetNamespace, 
			String method, Map<String, Object> paramsAndValuesMap) throws Exception {
		if (isNullOrEmplty(enpointUri) || isNullOrEmplty(soapAction) 
				|| isNullOrEmplty(targetNamespace) || isNullOrEmplty(method))
			throw new Exception("Some parameters value is null or empty!");
		
		Options opts = new Options();
		opts.setTo(new EndpointReference(enpointUri));
		opts.setAction(soapAction);
		serviceClient.setOverrideOptions(opts);
		
		OMElement result = null;
		try {
			result = serviceClient.sendReceive(_createPayload(targetNamespace, method, paramsAndValuesMap));
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
	
	private static boolean isNullOrEmplty (String str) {
		
		return str == null || str.isEmpty();
	}
}
