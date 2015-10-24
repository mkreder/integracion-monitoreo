/**
 * BeanService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.monitor.webService;

public interface BeanService extends javax.xml.rpc.Service {
    public java.lang.String getBeanWebServicePortAddress();

    public com.monitor.webService.BeanWebService getBeanWebServicePort() throws javax.xml.rpc.ServiceException;

    public com.monitor.webService.BeanWebService getBeanWebServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
