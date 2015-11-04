/**
 * VoVenta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.monitor.webService;

public class VoVenta  implements java.io.Serializable {
    private java.lang.String codigoPortal;

    private int codigoVenta;

    private com.monitor.webService.VoItemVenta[] collectionItems;

    private java.lang.String coordenadasUsuario;

    private java.lang.String dni;

    private java.lang.String estado;

    private java.util.Calendar fechaHoraVenta;

    private java.lang.Float montoTotal;

    public VoVenta() {
    }

    public VoVenta(
           java.lang.String codigoPortal,
           int codigoVenta,
           com.monitor.webService.VoItemVenta[] collectionItems,
           java.lang.String coordenadasUsuario,
           java.lang.String dni,
           java.lang.String estado,
           java.util.Calendar fechaHoraVenta,
           java.lang.Float montoTotal) {
           this.codigoPortal = codigoPortal;
           this.codigoVenta = codigoVenta;
           this.collectionItems = collectionItems;
           this.coordenadasUsuario = coordenadasUsuario;
           this.dni = dni;
           this.estado = estado;
           this.fechaHoraVenta = fechaHoraVenta;
           this.montoTotal = montoTotal;
    }


    /**
     * Gets the codigoPortal value for this VoVenta.
     * 
     * @return codigoPortal
     */
    public java.lang.String getCodigoPortal() {
        return codigoPortal;
    }


    /**
     * Sets the codigoPortal value for this VoVenta.
     * 
     * @param codigoPortal
     */
    public void setCodigoPortal(java.lang.String codigoPortal) {
        this.codigoPortal = codigoPortal;
    }


    /**
     * Gets the codigoVenta value for this VoVenta.
     * 
     * @return codigoVenta
     */
    public int getCodigoVenta() {
        return codigoVenta;
    }


    /**
     * Sets the codigoVenta value for this VoVenta.
     * 
     * @param codigoVenta
     */
    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }


    /**
     * Gets the collectionItems value for this VoVenta.
     * 
     * @return collectionItems
     */
    public com.monitor.webService.VoItemVenta[] getCollectionItems() {
        return collectionItems;
    }


    /**
     * Sets the collectionItems value for this VoVenta.
     * 
     * @param collectionItems
     */
    public void setCollectionItems(com.monitor.webService.VoItemVenta[] collectionItems) {
        this.collectionItems = collectionItems;
    }

    public com.monitor.webService.VoItemVenta getCollectionItems(int i) {
        return this.collectionItems[i];
    }

    public void setCollectionItems(int i, com.monitor.webService.VoItemVenta _value) {
        this.collectionItems[i] = _value;
    }


    /**
     * Gets the coordenadasUsuario value for this VoVenta.
     * 
     * @return coordenadasUsuario
     */
    public java.lang.String getCoordenadasUsuario() {
        return coordenadasUsuario;
    }


    /**
     * Sets the coordenadasUsuario value for this VoVenta.
     * 
     * @param coordenadasUsuario
     */
    public void setCoordenadasUsuario(java.lang.String coordenadasUsuario) {
        this.coordenadasUsuario = coordenadasUsuario;
    }


    /**
     * Gets the dni value for this VoVenta.
     * 
     * @return dni
     */
    public java.lang.String getDni() {
        return dni;
    }


    /**
     * Sets the dni value for this VoVenta.
     * 
     * @param dni
     */
    public void setDni(java.lang.String dni) {
        this.dni = dni;
    }


    /**
     * Gets the estado value for this VoVenta.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this VoVenta.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the fechaHoraVenta value for this VoVenta.
     * 
     * @return fechaHoraVenta
     */
    public java.util.Calendar getFechaHoraVenta() {
        return fechaHoraVenta;
    }


    /**
     * Sets the fechaHoraVenta value for this VoVenta.
     * 
     * @param fechaHoraVenta
     */
    public void setFechaHoraVenta(java.util.Calendar fechaHoraVenta) {
        this.fechaHoraVenta = fechaHoraVenta;
    }


    /**
     * Gets the montoTotal value for this VoVenta.
     * 
     * @return montoTotal
     */
    public java.lang.Float getMontoTotal() {
        return montoTotal;
    }


    /**
     * Sets the montoTotal value for this VoVenta.
     * 
     * @param montoTotal
     */
    public void setMontoTotal(java.lang.Float montoTotal) {
        this.montoTotal = montoTotal;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof VoVenta)) return false;
        VoVenta other = (VoVenta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codigoPortal==null && other.getCodigoPortal()==null) || 
             (this.codigoPortal!=null &&
              this.codigoPortal.equals(other.getCodigoPortal()))) &&
            this.codigoVenta == other.getCodigoVenta() &&
            ((this.collectionItems==null && other.getCollectionItems()==null) || 
             (this.collectionItems!=null &&
              java.util.Arrays.equals(this.collectionItems, other.getCollectionItems()))) &&
            ((this.coordenadasUsuario==null && other.getCoordenadasUsuario()==null) || 
             (this.coordenadasUsuario!=null &&
              this.coordenadasUsuario.equals(other.getCoordenadasUsuario()))) &&
            ((this.dni==null && other.getDni()==null) || 
             (this.dni!=null &&
              this.dni.equals(other.getDni()))) &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.fechaHoraVenta==null && other.getFechaHoraVenta()==null) || 
             (this.fechaHoraVenta!=null &&
              this.fechaHoraVenta.equals(other.getFechaHoraVenta()))) &&
            ((this.montoTotal==null && other.getMontoTotal()==null) || 
             (this.montoTotal!=null &&
              this.montoTotal.equals(other.getMontoTotal())));
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
        if (getCodigoPortal() != null) {
            _hashCode += getCodigoPortal().hashCode();
        }
        _hashCode += getCodigoVenta();
        if (getCollectionItems() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCollectionItems());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCollectionItems(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCoordenadasUsuario() != null) {
            _hashCode += getCoordenadasUsuario().hashCode();
        }
        if (getDni() != null) {
            _hashCode += getDni().hashCode();
        }
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getFechaHoraVenta() != null) {
            _hashCode += getFechaHoraVenta().hashCode();
        }
        if (getMontoTotal() != null) {
            _hashCode += getMontoTotal().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(VoVenta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webService.monitor.com/", "voVenta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoPortal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoPortal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoVenta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoVenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("collectionItems");
        elemField.setXmlName(new javax.xml.namespace.QName("", "collectionItems"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webService.monitor.com/", "voItemVenta"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coordenadasUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coordenadasUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dni");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dni"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaHoraVenta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaHoraVenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("montoTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "montoTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
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
