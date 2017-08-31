/**
 * ClientWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.signserver.clientws;

@SuppressWarnings("all")
public class ClientWSServiceLocator extends org.apache.axis.client.Service implements org.signserver.clientws.ClientWSService {

    public ClientWSServiceLocator() {
    }


    public ClientWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ClientWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ClientWSPort
    private java.lang.String ClientWSPort_address = "http://localhost:8080/signserver/ClientWSService/ClientWS";

    public java.lang.String getClientWSPortAddress() {
        return ClientWSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ClientWSPortWSDDServiceName = "ClientWSPort";

    public java.lang.String getClientWSPortWSDDServiceName() {
        return ClientWSPortWSDDServiceName;
    }

    public void setClientWSPortWSDDServiceName(java.lang.String name) {
        ClientWSPortWSDDServiceName = name;
    }

    public org.signserver.clientws.ClientWS getClientWSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ClientWSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getClientWSPort(endpoint);
    }

    public org.signserver.clientws.ClientWS getClientWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.signserver.clientws.ClientWSServiceSoapBindingStub _stub = new org.signserver.clientws.ClientWSServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getClientWSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setClientWSPortEndpointAddress(java.lang.String address) {
        ClientWSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.signserver.clientws.ClientWS.class.isAssignableFrom(serviceEndpointInterface)) {
                org.signserver.clientws.ClientWSServiceSoapBindingStub _stub = new org.signserver.clientws.ClientWSServiceSoapBindingStub(new java.net.URL(ClientWSPort_address), this);
                _stub.setPortName(getClientWSPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ClientWSPort".equals(inputPortName)) {
            return getClientWSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://clientws.signserver.org/", "ClientWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://clientws.signserver.org/", "ClientWSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ClientWSPort".equals(portName)) {
            setClientWSPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
