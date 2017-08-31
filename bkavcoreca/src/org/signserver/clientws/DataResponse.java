/**
 * DataResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.signserver.clientws;

@SuppressWarnings("all")
public class DataResponse  implements java.io.Serializable {
    private java.lang.String archiveId;

    private byte[] data;

    private org.signserver.clientws.Metadata[] metadata;

    private int requestId;

    private byte[] signerCertificate;

    public DataResponse() {
    }

    public DataResponse(
           java.lang.String archiveId,
           byte[] data,
           org.signserver.clientws.Metadata[] metadata,
           int requestId,
           byte[] signerCertificate) {
           this.archiveId = archiveId;
           this.data = data;
           this.metadata = metadata;
           this.requestId = requestId;
           this.signerCertificate = signerCertificate;
    }


    /**
     * Gets the archiveId value for this DataResponse.
     * 
     * @return archiveId
     */
    public java.lang.String getArchiveId() {
        return archiveId;
    }


    /**
     * Sets the archiveId value for this DataResponse.
     * 
     * @param archiveId
     */
    public void setArchiveId(java.lang.String archiveId) {
        this.archiveId = archiveId;
    }


    /**
     * Gets the data value for this DataResponse.
     * 
     * @return data
     */
    public byte[] getData() {
        return data;
    }


    /**
     * Sets the data value for this DataResponse.
     * 
     * @param data
     */
    public void setData(byte[] data) {
        this.data = data;
    }


    /**
     * Gets the metadata value for this DataResponse.
     * 
     * @return metadata
     */
    public org.signserver.clientws.Metadata[] getMetadata() {
        return metadata;
    }


    /**
     * Sets the metadata value for this DataResponse.
     * 
     * @param metadata
     */
    public void setMetadata(org.signserver.clientws.Metadata[] metadata) {
        this.metadata = metadata;
    }

    public org.signserver.clientws.Metadata getMetadata(int i) {
        return this.metadata[i];
    }

    public void setMetadata(int i, org.signserver.clientws.Metadata _value) {
        this.metadata[i] = _value;
    }


    /**
     * Gets the requestId value for this DataResponse.
     * 
     * @return requestId
     */
    public int getRequestId() {
        return requestId;
    }


    /**
     * Sets the requestId value for this DataResponse.
     * 
     * @param requestId
     */
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }


    /**
     * Gets the signerCertificate value for this DataResponse.
     * 
     * @return signerCertificate
     */
    public byte[] getSignerCertificate() {
        return signerCertificate;
    }


    /**
     * Sets the signerCertificate value for this DataResponse.
     * 
     * @param signerCertificate
     */
    public void setSignerCertificate(byte[] signerCertificate) {
        this.signerCertificate = signerCertificate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DataResponse)) return false;
        DataResponse other = (DataResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.archiveId==null && other.getArchiveId()==null) || 
             (this.archiveId!=null &&
              this.archiveId.equals(other.getArchiveId()))) &&
            ((this.data==null && other.getData()==null) || 
             (this.data!=null &&
              java.util.Arrays.equals(this.data, other.getData()))) &&
            ((this.metadata==null && other.getMetadata()==null) || 
             (this.metadata!=null &&
              java.util.Arrays.equals(this.metadata, other.getMetadata()))) &&
            this.requestId == other.getRequestId() &&
            ((this.signerCertificate==null && other.getSignerCertificate()==null) || 
             (this.signerCertificate!=null &&
              java.util.Arrays.equals(this.signerCertificate, other.getSignerCertificate())));
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
        if (getArchiveId() != null) {
            _hashCode += getArchiveId().hashCode();
        }
        if (getData() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getData());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getData(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMetadata() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMetadata());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMetadata(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getRequestId();
        if (getSignerCertificate() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSignerCertificate());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSignerCertificate(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DataResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://clientws.signserver.org/", "dataResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("archiveId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "archiveId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("data");
        elemField.setXmlName(new javax.xml.namespace.QName("", "data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metadata");
        elemField.setXmlName(new javax.xml.namespace.QName("", "metadata"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://clientws.signserver.org/", "metadata"));
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
        elemField.setFieldName("signerCertificate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "signerCertificate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
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
