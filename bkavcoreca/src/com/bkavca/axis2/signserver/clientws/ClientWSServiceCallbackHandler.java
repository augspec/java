
/**
 * ClientWSServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.bkavca.axis2.signserver.clientws;

    /**
     *  ClientWSServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ClientWSServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ClientWSServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ClientWSServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for decryptSessionKey method
            * override this method for handling normal response from decryptSessionKey operation
            */
           public void receiveResultdecryptSessionKey(
                    com.bkavca.axis2.signserver.clientws.ClientWSServiceStub.DecryptSessionKeyResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from decryptSessionKey operation
           */
            public void receiveErrordecryptSessionKey(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCertificateFromSignedData method
            * override this method for handling normal response from getCertificateFromSignedData operation
            */
           public void receiveResultgetCertificateFromSignedData(
                    com.bkavca.axis2.signserver.clientws.ClientWSServiceStub.GetCertificateFromSignedDataResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCertificateFromSignedData operation
           */
            public void receiveErrorgetCertificateFromSignedData(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCMSOriginalData method
            * override this method for handling normal response from getCMSOriginalData operation
            */
           public void receiveResultgetCMSOriginalData(
                    com.bkavca.axis2.signserver.clientws.ClientWSServiceStub.GetCMSOriginalDataResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCMSOriginalData operation
           */
            public void receiveErrorgetCMSOriginalData(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for processData method
            * override this method for handling normal response from processData operation
            */
           public void receiveResultprocessData(
                    com.bkavca.axis2.signserver.clientws.ClientWSServiceStub.ProcessDataResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from processData operation
           */
            public void receiveErrorprocessData(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for verify method
            * override this method for handling normal response from verify operation
            */
           public void receiveResultverify(
                    com.bkavca.axis2.signserver.clientws.ClientWSServiceStub.VerifyResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from verify operation
           */
            public void receiveErrorverify(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for sign method
            * override this method for handling normal response from sign operation
            */
           public void receiveResultsign(
                    com.bkavca.axis2.signserver.clientws.ClientWSServiceStub.SignResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sign operation
           */
            public void receiveErrorsign(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for processSOD method
            * override this method for handling normal response from processSOD operation
            */
           public void receiveResultprocessSOD(
                    com.bkavca.axis2.signserver.clientws.ClientWSServiceStub.ProcessSODResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from processSOD operation
           */
            public void receiveErrorprocessSOD(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCertificateFromAD method
            * override this method for handling normal response from getCertificateFromAD operation
            */
           public void receiveResultgetCertificateFromAD(
                    com.bkavca.axis2.signserver.clientws.ClientWSServiceStub.GetCertificateFromADResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCertificateFromAD operation
           */
            public void receiveErrorgetCertificateFromAD(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for verifySignature method
            * override this method for handling normal response from verifySignature operation
            */
           public void receiveResultverifySignature(
                    com.bkavca.axis2.signserver.clientws.ClientWSServiceStub.VerifySignatureResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from verifySignature operation
           */
            public void receiveErrorverifySignature(java.lang.Exception e) {
            }
                


    }
    