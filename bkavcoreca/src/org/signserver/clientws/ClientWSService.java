/**
 * ClientWSService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.signserver.clientws;

public interface ClientWSService extends javax.xml.rpc.Service {
    public java.lang.String getClientWSPortAddress();

    public org.signserver.clientws.ClientWS getClientWSPort() throws javax.xml.rpc.ServiceException;

    public org.signserver.clientws.ClientWS getClientWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
