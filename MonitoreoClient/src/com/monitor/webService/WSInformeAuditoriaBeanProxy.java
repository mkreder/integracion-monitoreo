package com.monitor.webService;

public class WSInformeAuditoriaBeanProxy implements com.monitor.webService.WSInformeAuditoriaBean {
  private String _endpoint = null;
  private com.monitor.webService.WSInformeAuditoriaBean wSInformeAuditoriaBean = null;
  
  public WSInformeAuditoriaBeanProxy() {
    _initWSInformeAuditoriaBeanProxy();
  }
  
  public WSInformeAuditoriaBeanProxy(String endpoint) {
    _endpoint = endpoint;
    _initWSInformeAuditoriaBeanProxy();
  }
  
  private void _initWSInformeAuditoriaBeanProxy() {
    try {
      wSInformeAuditoriaBean = (new com.monitor.webService.WSInformeAuditoriaBeanServiceLocator()).getWSInformeAuditoriaBeanPort();
      if (wSInformeAuditoriaBean != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wSInformeAuditoriaBean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wSInformeAuditoriaBean)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wSInformeAuditoriaBean != null)
      ((javax.xml.rpc.Stub)wSInformeAuditoriaBean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.monitor.webService.WSInformeAuditoriaBean getWSInformeAuditoriaBean() {
    if (wSInformeAuditoriaBean == null)
      _initWSInformeAuditoriaBeanProxy();
    return wSInformeAuditoriaBean;
  }
  
  public boolean agregarInforme(com.monitor.webService.VoInformeDeAuditoria arg0) throws java.rmi.RemoteException{
    if (wSInformeAuditoriaBean == null)
      _initWSInformeAuditoriaBeanProxy();
    return wSInformeAuditoriaBean.agregarInforme(arg0);
  }
  
  
}