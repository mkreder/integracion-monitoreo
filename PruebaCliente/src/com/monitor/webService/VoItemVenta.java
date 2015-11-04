/**
 * VoItemVenta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.monitor.webService;

public class VoItemVenta  implements java.io.Serializable {
    private java.lang.Integer cantidad;

    private java.lang.Integer codigo;

    private float precio;

    private com.monitor.webService.VoProducto producto;

    public VoItemVenta() {
    }

    public VoItemVenta(
           java.lang.Integer cantidad,
           java.lang.Integer codigo,
           float precio,
           com.monitor.webService.VoProducto producto) {
           this.cantidad = cantidad;
           this.codigo = codigo;
           this.precio = precio;
           this.producto = producto;
    }


    /**
     * Gets the cantidad value for this VoItemVenta.
     * 
     * @return cantidad
     */
    public java.lang.Integer getCantidad() {
        return cantidad;
    }


    /**
     * Sets the cantidad value for this VoItemVenta.
     * 
     * @param cantidad
     */
    public void setCantidad(java.lang.Integer cantidad) {
        this.cantidad = cantidad;
    }


    /**
     * Gets the codigo value for this VoItemVenta.
     * 
     * @return codigo
     */
    public java.lang.Integer getCodigo() {
        return codigo;
    }


    /**
     * Sets the codigo value for this VoItemVenta.
     * 
     * @param codigo
     */
    public void setCodigo(java.lang.Integer codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets the precio value for this VoItemVenta.
     * 
     * @return precio
     */
    public float getPrecio() {
        return precio;
    }


    /**
     * Sets the precio value for this VoItemVenta.
     * 
     * @param precio
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }


    /**
     * Gets the producto value for this VoItemVenta.
     * 
     * @return producto
     */
    public com.monitor.webService.VoProducto getProducto() {
        return producto;
    }


    /**
     * Sets the producto value for this VoItemVenta.
     * 
     * @param producto
     */
    public void setProducto(com.monitor.webService.VoProducto producto) {
        this.producto = producto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof VoItemVenta)) return false;
        VoItemVenta other = (VoItemVenta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cantidad==null && other.getCantidad()==null) || 
             (this.cantidad!=null &&
              this.cantidad.equals(other.getCantidad()))) &&
            ((this.codigo==null && other.getCodigo()==null) || 
             (this.codigo!=null &&
              this.codigo.equals(other.getCodigo()))) &&
            this.precio == other.getPrecio() &&
            ((this.producto==null && other.getProducto()==null) || 
             (this.producto!=null &&
              this.producto.equals(other.getProducto())));
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
        if (getCantidad() != null) {
            _hashCode += getCantidad().hashCode();
        }
        if (getCodigo() != null) {
            _hashCode += getCodigo().hashCode();
        }
        _hashCode += new Float(getPrecio()).hashCode();
        if (getProducto() != null) {
            _hashCode += getProducto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(VoItemVenta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webService.monitor.com/", "voItemVenta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidad");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cantidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("precio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "precio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webService.monitor.com/", "voProducto"));
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
