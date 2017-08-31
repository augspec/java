/**
 * SodRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.signserver.clientws;

@SuppressWarnings("all")
public class SodRequest  implements java.io.Serializable {
    private org.signserver.clientws.DataGroup[] dataGroup;

    private java.lang.String ldsVersion;

    private java.lang.String unicodeVersion;

    public SodRequest() {
    }

    public SodRequest(
           org.signserver.clientws.DataGroup[] dataGroup,
           java.lang.String ldsVersion,
           java.lang.String unicodeVersion) {
           this.dataGroup = dataGroup;
           this.ldsVersion = ldsVersion;
           this.unicodeVersion = unicodeVersion;
    }


    /**
     * Gets the dataGroup value for this SodRequest.
     * 
     * @return dataGroup
     */
    public org.signserver.clientws.DataGroup[] getDataGroup() {
        return dataGroup;
    }


    /**
     * Sets the dataGroup value for this SodRequest.
     * 
     * @param dataGroup
     */
    public void setDataGroup(org.signserver.clientws.DataGroup[] dataGroup) {
        this.dataGroup = dataGroup;
    }

    public org.signserver.clientws.DataGroup getDataGroup(int i) {
        return this.dataGroup[i];
    }

    public void setDataGroup(int i, org.signserver.clientws.DataGroup _value) {
        this.dataGroup[i] = _value;
    }


    /**
     * Gets the ldsVersion value for this SodRequest.
     * 
     * @return ldsVersion
     */
    public java.lang.String getLdsVersion() {
        return ldsVersion;
    }


    /**
     * Sets the ldsVersion value for this SodRequest.
     * 
     * @param ldsVersion
     */
    public void setLdsVersion(java.lang.String ldsVersion) {
        this.ldsVersion = ldsVersion;
    }


    /**
     * Gets the unicodeVersion value for this SodRequest.
     * 
     * @return unicodeVersion
     */
    public java.lang.String getUnicodeVersion() {
        return unicodeVersion;
    }


    /**
     * Sets the unicodeVersion value for this SodRequest.
     * 
     * @param unicodeVersion
     */
    public void setUnicodeVersion(java.lang.String unicodeVersion) {
        this.unicodeVersion = unicodeVersion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SodRequest)) return false;
        SodRequest other = (SodRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dataGroup==null && other.getDataGroup()==null) || 
             (this.dataGroup!=null &&
              java.util.Arrays.equals(this.dataGroup, other.getDataGroup()))) &&
            ((this.ldsVersion==null && other.getLdsVersion()==null) || 
             (this.ldsVersion!=null &&
              this.ldsVersion.equals(other.getLdsVersion()))) &&
            ((this.unicodeVersion==null && other.getUnicodeVersion()==null) || 
             (this.unicodeVersion!=null &&
              this.unicodeVersion.equals(other.getUnicodeVersion())));
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
        if (getDataGroup() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDataGroup());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDataGroup(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLdsVersion() != null) {
            _hashCode += getLdsVersion().hashCode();
        }
        if (getUnicodeVersion() != null) {
            _hashCode += getUnicodeVersion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SodRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://clientws.signserver.org/", "sodRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://clientws.signserver.org/", "dataGroup"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ldsVersion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ldsVersion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unicodeVersion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unicodeVersion"));
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
