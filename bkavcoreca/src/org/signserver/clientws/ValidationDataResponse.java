/**
 * ValidationDataResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.signserver.clientws;

@SuppressWarnings("all")
public class ValidationDataResponse  implements java.io.Serializable {
    private byte[] certificateData;

    private boolean isValid;

    private java.lang.String[] messages;

    private int requestId;

    private int validateCode;

    public ValidationDataResponse() {
    }

    public ValidationDataResponse(
           byte[] certificateData,
           boolean isValid,
           java.lang.String[] messages,
           int requestId,
           int validateCode) {
           this.certificateData = certificateData;
           this.isValid = isValid;
           this.messages = messages;
           this.requestId = requestId;
           this.validateCode = validateCode;
    }


    /**
     * Gets the certificateData value for this ValidationDataResponse.
     * 
     * @return certificateData
     */
    public byte[] getCertificateData() {
        return certificateData;
    }


    /**
     * Sets the certificateData value for this ValidationDataResponse.
     * 
     * @param certificateData
     */
    public void setCertificateData(byte[] certificateData) {
        this.certificateData = certificateData;
    }


    /**
     * Gets the isValid value for this ValidationDataResponse.
     * 
     * @return isValid
     */
    public boolean isIsValid() {
        return isValid;
    }


    /**
     * Sets the isValid value for this ValidationDataResponse.
     * 
     * @param isValid
     */
    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }


    /**
     * Gets the messages value for this ValidationDataResponse.
     * 
     * @return messages
     */
    public java.lang.String[] getMessages() {
        return messages;
    }


    /**
     * Sets the messages value for this ValidationDataResponse.
     * 
     * @param messages
     */
    public void setMessages(java.lang.String[] messages) {
        this.messages = messages;
    }

    public java.lang.String getMessages(int i) {
        return this.messages[i];
    }

    public void setMessages(int i, java.lang.String _value) {
        this.messages[i] = _value;
    }


    /**
     * Gets the requestId value for this ValidationDataResponse.
     * 
     * @return requestId
     */
    public int getRequestId() {
        return requestId;
    }


    /**
     * Sets the requestId value for this ValidationDataResponse.
     * 
     * @param requestId
     */
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }


    /**
     * Gets the validateCode value for this ValidationDataResponse.
     * 
     * @return validateCode
     */
    public int getValidateCode() {
        return validateCode;
    }


    /**
     * Sets the validateCode value for this ValidationDataResponse.
     * 
     * @param validateCode
     */
    public void setValidateCode(int validateCode) {
        this.validateCode = validateCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ValidationDataResponse)) return false;
        ValidationDataResponse other = (ValidationDataResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.certificateData==null && other.getCertificateData()==null) || 
             (this.certificateData!=null &&
              java.util.Arrays.equals(this.certificateData, other.getCertificateData()))) &&
            this.isValid == other.isIsValid() &&
            ((this.messages==null && other.getMessages()==null) || 
             (this.messages!=null &&
              java.util.Arrays.equals(this.messages, other.getMessages()))) &&
            this.requestId == other.getRequestId() &&
            this.validateCode == other.getValidateCode();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCertificateData() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCertificateData());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCertificateData(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += (isIsValid() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getMessages() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMessages());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMessages(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getRequestId();
        _hashCode += getValidateCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ValidationDataResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://clientws.signserver.org/", "validationDataResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("certificateData");
        elemField.setXmlName(new javax.xml.namespace.QName("", "certificateData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isValid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isValid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messages");
        elemField.setXmlName(new javax.xml.namespace.QName("", "messages"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requestId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validateCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "validateCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
