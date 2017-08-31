
/**
 * InternalServerExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.bkavca.axis2.signserver.clientws;

public class InternalServerExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1503623056616L;
    
    private com.bkavca.axis2.signserver.clientws.ClientWSServiceStub.InternalServerExceptionE faultMessage;

    
        public InternalServerExceptionException() {
            super("InternalServerExceptionException");
        }

        public InternalServerExceptionException(java.lang.String s) {
           super(s);
        }

        public InternalServerExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public InternalServerExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.bkavca.axis2.signserver.clientws.ClientWSServiceStub.InternalServerExceptionE msg){
       faultMessage = msg;
    }
    
    public com.bkavca.axis2.signserver.clientws.ClientWSServiceStub.InternalServerExceptionE getFaultMessage(){
       return faultMessage;
    }
}
    