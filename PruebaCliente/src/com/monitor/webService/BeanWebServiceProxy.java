package com.monitor.webService;

public class BeanWebServiceProxy implements com.monitor.webService.BeanWebService {
  private String _endpoint = null;
  private com.monitor.webService.BeanWebService beanWebService = null;
  
  public BeanWebServiceProxy() {
    _initBeanWebServiceProxy();
  }
  
  public BeanWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initBeanWebServiceProxy();
  }
  
  private void _initBeanWebServiceProxy() {
    try {
      beanWebService = (new com.monitor.webService.BeanServiceLocator()).getBeanWebServicePort();
      if (beanWebService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)beanWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)beanWebService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (beanWebService != null)
      ((javax.xml.rpc.Stub)beanWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.monitor.webService.BeanWebService getBeanWebService() {
    if (beanWebService == null)
      _initBeanWebServiceProxy();
    return beanWebService;
  }
  
  public com.monitor.webService.Book[] getBooks() throws java.rmi.RemoteException{
    if (beanWebService == null)
      _initBeanWebServiceProxy();
    return beanWebService.getBooks();
  }
  
  public void addBook(com.monitor.webService.Book arg0) throws java.rmi.RemoteException{
    if (beanWebService == null)
      _initBeanWebServiceProxy();
    beanWebService.addBook(arg0);
  }
  
  
}