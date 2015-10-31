package com.monitor.webService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.monitor.Fachada.IFachada;
import com.monitor.webServiceInterface.IWSProcVenta;

import vos.VoVenta;

 
 

@Stateless
@WebService
public class WSProcVentaBean implements IWSProcVenta {
	
	@EJB
	IFachada fachada;

	public WSProcVentaBean() {
	}
	@SuppressWarnings("unchecked")
	@Override
	@WebMethod
	public String procesarVenta(VoVenta venta) {
		 return fachada.procesarVenta(venta);
		 
	}	
	
}