/**
 * SignData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.signserver.clientws;

@SuppressWarnings("all")
public class SignData  implements java.io.Serializable {
    private byte[] dataToSign;

    private java.lang.String nodeContainSignature;

    private java.lang.String nodeName;

    private java.lang.String reference;

    private org.signserver.clientws.Metadata[] requestMetadata;

    private java.lang.String workerName;

    public SignData() {
    }

    public SignData(
           byte[] dataToSign,
           java.lang.String nodeContainSignature,
           java.lang.String nodeName,
           java.lang.String reference,
           org.signserver.clientws.Metadata[] requestMetadata,
           java.lang.String workerName) {
           this.dataToSign = dataToSign;
           this.nodeContainSignature = nodeContainSignature;
           this.nodeName = nodeName;
           this.reference = reference;
           this.requestMetadata = requestMetadata;
           this.workerName = workerName;
    }


    /**
     * Gets the dataToSign value for this SignData.
     * 
     * @return dataToSign
     */
    public byte[] getDataToSign() {
        return dataToSign;
    }


    /**
     * Sets the dataToSign value for this SignData.
     * 
     * @param dataToSign
     */
    public void setDataToSign(byte[] dataToSign) {
        this.dataToSign = dataToSign;
    }


    /**
     * Gets the nodeContainSignature value for this SignData.
     * 
     * @return nodeContainSignature
     */
    public java.lang.String getNodeContainSignature() {
        return nodeContainSignature;
    }


    /**
     * Sets the nodeContainSignature value for this SignData.
     * 
     * @param nodeContainSignature
     */
    public void setNodeContainSignature(java.lang.String nodeContainSignature) {
        this.nodeContainSignature = nodeContainSignature;
    }


    /**
     * Gets the nodeName value for this SignData.
     * 
     * @return nodeName
     */
    public java.lang.String getNodeName() {
        return nodeName;
    }


    /**
     * Sets the nodeName value for this SignData.
     * 
     * @param nodeName
     */
    public void setNodeName(java.lang.String nodeName) {
        this.nodeName = nodeName;
    }


    /**
     * Gets the reference value for this SignData.
     * 
     * @return reference
     */
    public java.lang.String getReference() {
        return reference;
    }


    /**
     * Sets the reference value for this SignData.
     * 
     * @param reference
     */
    public void setReference(java.lang.String reference) {
        this.reference = reference;
    }


    /**
     * Gets the requestMetadata value for this SignData.
     * 
     * @return requestMetadata
     */
    public org.signserver.clientws.Metadata[] getRequestMetadata() {
        return requestMetadata;
    }


    /**
     * Sets the requestMetadata value for this SignData.
     * 
     * @param requestMetadata
     */
    public void setRequestMetadata(org.signserver.clientws.Metadata[] requestMetadata) {
        this.requestMetadata = requestMetadata;
    }

    public org.signserver.clientws.Metadata getRequestMetadata(int i) {
        return this.requestMetadata[i];
    }

    public void setRequestMetadata(int i, org.signserver.clientws.Metadata _value) {
        this.requestMetadata[i] = _value;
    }


    /**
     * Gets the workerName value for this SignData.
     * 
     * @return workerName
     */
    public java.lang.String getWorkerName() {
        return workerName;
    }


    /**
     * Sets the workerName value for this SignData.
     * 
     * @param workerName
     */
    public void setWorkerName(java.lang.String workerName) {
        this.workerName = workerName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SignData)) return false;
        SignData other = (SignData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dataToSign==null && other.getDataToSign()==null) || 
             (this.dataToSign!=null &&
              java.util.Arrays.equals(this.dataToSign, other.getDataToSign()))) &&
            ((this.nodeContainSignature==null && other.getNodeContainSignature()==null) || 
             (this.nodeContainSignature!=null &&
              this.nodeContainSignature.equals(other.getNodeContainSignature()))) &&
            ((this.nodeName==null && other.getNodeName()==null) || 
             (this.nodeName!=null &&
              this.nodeName.equals(other.getNodeName()))) &&
            ((this.reference==null && other.getReference()==null) || 
             (this.reference!=null &&
              this.reference.equals(other.getReference()))) &&
            ((this.requestMetadata==null && other.getRequestMetadata()==null) || 
             (this.requestMetadata!=null &&
              java.util.Arrays.equals(this.requestMetadata, other.getRequestMetadata()))) &&
            ((this.workerName==null && other.getWorkerName()==null) || 
             (this.workerName!=null &&
              this.workerName.equals(other.getWorkerName())));
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
        if (getDataToSign() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDataToSign());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDataToSign(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNodeContainSignature() != null) {
            _hashCode += getNodeContainSignature().hashCode();
        }
        if (getNodeName() != null) {
            _hashCode += getNodeName().hashCode();
        }
        if (getReference() != null) {
            _hashCode += getReference().hashCode();
        }
        if (getRequestMetadata() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRequestMetadata());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRequestMetadata(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getWorkerName() != null) {
            _hashCode += getWorkerName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SignData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://clientws.signserver.org/", "signData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataToSign");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataToSign"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nodeContainSignature");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nodeContainSignature"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nodeName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nodeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reference");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestMetadata");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requestMetadata"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://clientws.signserver.org/", "metadata"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workerName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "workerName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
