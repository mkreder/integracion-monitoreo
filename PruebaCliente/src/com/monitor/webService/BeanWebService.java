/**
 * BeanWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.monitor.webService;

public interface BeanWebService extends java.rmi.Remote {
    public com.monitor.webService.Book[] getBooks() throws java.rmi.RemoteException;
    public void addBook(com.monitor.webService.Book arg0) throws java.rmi.RemoteException;
}
