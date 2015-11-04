/**
 * VoInformeDeAuditoria.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.monitor.webService;

public class VoInformeDeAuditoria  implements java.io.Serializable {
    private java.lang.String descripcion;

    private int fechaYHora;

    private java.lang.String modulo;

    public VoInformeDeAuditoria() {
    }

    public VoInformeDeAuditoria(
           java.lang.String descripcion,
           int fechaYHora,
           java.lang.String modulo) {
           this.descripcion = descripcion;
           this.fechaYHora = fechaYHora;
           this.modulo = modulo;
    }


    /**
     * Gets the descripcion value for this VoInformeDeAuditoria.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this VoInformeDeAuditoria.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the fechaYHora value for this VoInformeDeAuditoria.
     * 
     * @return fechaYHora
     */
    public int getFechaYHora() {
        return fechaYHora;
    }


    /**
     * Sets the fechaYHora value for this VoInformeDeAuditoria.
     * 
     * @param fechaYHora
     */
    public void setFechaYHora(int fechaYHora) {
        this.fechaYHora = fechaYHora;
    }


    /**
     * Gets the modulo value for this VoInformeDeAuditoria.
     * 
     * @return modulo
     */
    public java.lang.String getModulo() {
        return modulo;
    }


    /**
     * Sets the modulo value for this VoInformeDeAuditoria.
     * 
     * @param modulo
     */
    public void setModulo(java.lang.String modulo) {
        this.modulo = modulo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof VoInformeDeAuditoria)) return false;
        VoInformeDeAuditoria other = (VoInformeDeAuditoria) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            this.fechaYHora == other.getFechaYHora() &&
            ((this.modulo==null && other.getModulo()==null) || 
             (this.modulo!=null &&
              this.modulo.equals(other.getModulo())));
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
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        _hashCode += getFechaYHora();
        if (getModulo() != null) {
            _hashCode += getModulo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(VoInformeDeAuditoria.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webService.monitor.com/", "voInformeDeAuditoria"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaYHora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaYHora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modulo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "modulo"));
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
