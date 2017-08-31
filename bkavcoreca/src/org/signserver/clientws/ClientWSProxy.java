package org.signserver.clientws;

public class ClientWSProxy implements org.signserver.clientws.ClientWS {
  private String _endpoint = null;
  private org.signserver.clientws.ClientWS clientWS = null;
  
  public ClientWSProxy() {
    _initClientWSProxy();
  }
  
  public ClientWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initClientWSProxy();
  }
  
  private void _initClientWSProxy() {
    try {
      clientWS = (new org.signserver.clientws.ClientWSServiceLocator()).getClientWSPort();
      if (clientWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)clientWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)clientWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (clientWS != null)
      ((javax.xml.rpc.Stub)clientWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.signserver.clientws.ClientWS getClientWS() {
    if (clientWS == null)
      _initClientWSProxy();
    return clientWS;
  }
  
  public org.signserver.clientws.DataResponse getCertificateFromSignedData(byte[] data) throws java.rmi.RemoteException{
    if (clientWS == null)
      _initClientWSProxy();
    return clientWS.getCertificateFromSignedData(data);
  }
  
  public byte[] getCMSOriginalData(byte[] signedData) throws java.rmi.RemoteException{
    if (clientWS == null)
      _initClientWSProxy();
    return clientWS.getCMSOriginalData(signedData);
  }
  
  public org.signserver.clientws.DataResponse processData(java.lang.String worker, org.signserver.clientws.Metadata[] metadata, byte[] data) throws java.rmi.RemoteException, org.signserver.clientws.InternalServerException, org.signserver.clientws.RequestFailedException{
    if (clientWS == null)
      _initClientWSProxy();
    return clientWS.processData(worker, metadata, data);
  }
  
  public org.signserver.clientws.ValidationDataResponse verify(java.lang.String worker, org.signserver.clientws.Metadata[] metadata, byte[] data) throws java.rmi.RemoteException, org.signserver.clientws.InternalServerException, org.signserver.clientws.RequestFailedException{
    if (clientWS == null)
      _initClientWSProxy();
    return clientWS.verify(worker, metadata, data);
  }
  
  public org.signserver.clientws.DataResponse sign(org.signserver.clientws.SignData signdata) throws java.rmi.RemoteException, org.signserver.clientws.InternalServerException, org.signserver.clientws.RequestFailedException{
    if (clientWS == null)
      _initClientWSProxy();
    return clientWS.sign(signdata);
  }
  
  public org.signserver.clientws.SodResponse processSOD(java.lang.String worker, org.signserver.clientws.Metadata[] metadata, org.signserver.clientws.SodRequest sodData) throws java.rmi.RemoteException, org.signserver.clientws.InternalServerException, org.signserver.clientws.RequestFailedException{
    if (clientWS == null)
      _initClientWSProxy();
    return clientWS.processSOD(worker, metadata, sodData);
  }
  
  public org.signserver.clientws.DataResponse getCertificateFromAD(java.lang.String userName, java.lang.String password) throws java.rmi.RemoteException{
    if (clientWS == null)
      _initClientWSProxy();
    return clientWS.getCertificateFromAD(userName, password);
  }
  
  
}