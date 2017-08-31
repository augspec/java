/**
 * ClientWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.signserver.clientws;

public interface ClientWS extends java.rmi.Remote {
    public org.signserver.clientws.DataResponse getCertificateFromSignedData(byte[] data) throws java.rmi.RemoteException;
    public byte[] getCMSOriginalData(byte[] signedData) throws java.rmi.RemoteException;
    public org.signserver.clientws.DataResponse processData(java.lang.String worker, org.signserver.clientws.Metadata[] metadata, byte[] data) throws java.rmi.RemoteException, org.signserver.clientws.InternalServerException, org.signserver.clientws.RequestFailedException;
    public org.signserver.clientws.ValidationDataResponse verify(java.lang.String worker, org.signserver.clientws.Metadata[] metadata, byte[] data) throws java.rmi.RemoteException, org.signserver.clientws.InternalServerException, org.signserver.clientws.RequestFailedException;
    public org.signserver.clientws.DataResponse sign(org.signserver.clientws.SignData signdata) throws java.rmi.RemoteException, org.signserver.clientws.InternalServerException, org.signserver.clientws.RequestFailedException;
    public org.signserver.clientws.SodResponse processSOD(java.lang.String worker, org.signserver.clientws.Metadata[] metadata, org.signserver.clientws.SodRequest sodData) throws java.rmi.RemoteException, org.signserver.clientws.InternalServerException, org.signserver.clientws.RequestFailedException;
    public org.signserver.clientws.DataResponse getCertificateFromAD(java.lang.String userName, java.lang.String password) throws java.rmi.RemoteException;
}
