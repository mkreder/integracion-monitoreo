/**
 * BeanServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.monitor.webService;

public class BeanServiceLocator extends org.apache.axis.client.Service implements com.monitor.webService.BeanService {

    public BeanServiceLocator() {
    }


    public BeanServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BeanServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BeanWebServicePort
    private java.lang.String BeanWebServicePort_address = "http://localhost:8080/PruebaEjb/BeanService/BeanWebService";

    public java.lang.String getBeanWebServicePortAddress() {
        return BeanWebServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BeanWebServicePortWSDDServiceName = "BeanWebServicePort";

    public java.lang.String getBeanWebServicePortWSDDServiceName() {
        return BeanWebServicePortWSDDServiceName;
    }

    public void setBeanWebServicePortWSDDServiceName(java.lang.String name) {
        BeanWebServicePortWSDDServiceName = name;
    }

    public com.monitor.webService.BeanWebService getBeanWebServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BeanWebServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBeanWebServicePort(endpoint);
    }

    public com.monitor.webService.BeanWebService getBeanWebServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.monitor.webService.BeanServiceSoapBindingStub _stub = new com.monitor.webService.BeanServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getBeanWebServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBeanWebServicePortEndpointAddress(java.lang.String address) {
        BeanWebServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.monitor.webService.BeanWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.monitor.webService.BeanServiceSoapBindingStub _stub = new com.monitor.webService.BeanServiceSoapBindingStub(new java.net.URL(BeanWebServicePort_address), this);
                _stub.setPortName(getBeanWebServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BeanWebServicePort".equals(inputPortName)) {
            return getBeanWebServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webService.monitor.com/", "BeanService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webService.monitor.com/", "BeanWebServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BeanWebServicePort".equals(portName)) {
            setBeanWebServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
