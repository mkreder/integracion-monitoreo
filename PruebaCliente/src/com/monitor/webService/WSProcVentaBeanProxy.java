package com.monitor.webService;

public class WSProcVentaBeanProxy implements com.monitor.webService.WSProcVentaBean {
  private String _endpoint = null;
  private com.monitor.webService.WSProcVentaBean wSProcVentaBean = null;
  
  public WSProcVentaBeanProxy() {
    _initWSProcVentaBeanProxy();
  }
  
  public WSProcVentaBeanProxy(String endpoint) {
    _endpoint = endpoint;
    _initWSProcVentaBeanProxy();
  }
  
  private void _initWSProcVentaBeanProxy() {
    try {
      wSProcVentaBean = (new com.monitor.webService.WSProcVentaBeanServiceLocator()).getWSProcVentaBeanPort();
      if (wSProcVentaBean != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wSProcVentaBean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wSProcVentaBean)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wSProcVentaBean != null)
      ((javax.xml.rpc.Stub)wSProcVentaBean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.monitor.webService.WSProcVentaBean getWSProcVentaBean() {
    if (wSProcVentaBean == null)
      _initWSProcVentaBeanProxy();
    return wSProcVentaBean;
  }
  
  public boolean procesarVenta(com.monitor.webService.VoVenta arg0) throws java.rmi.RemoteException{
    if (wSProcVentaBean == null)
      _initWSProcVentaBeanProxy();
    return wSProcVentaBean.procesarVenta(arg0);
  }
  
  
}