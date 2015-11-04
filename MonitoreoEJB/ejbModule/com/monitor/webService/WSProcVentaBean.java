package com.monitor.webService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.monitor.Fachada.IFachada;
import com.monitor.webServiceInterface.IWSProcVenta;

import vos.ResultadoDTO;

import vos.VentaDTO;

 
 

@Stateless
@WebService
public class WSProcVentaBean implements IWSProcVenta {
	
	@EJB
	IFachada fachada;
	@Override
	@WebMethod
	public java.lang.String notificarCarrito(String notificacion) {
		
		fachada.procesarCarrito(notificacion);
	return "OK";
	
	}
	@Override
	@WebMethod
	public ResultadoDTO notificarVenta(VentaDTO venta){
		
 

	ResultadoDTO res= new ResultadoDTO();
	
	res.setEstado(fachada.procesarVenta(venta));
	
	return res;
	}
	public WSProcVentaBean() {
	}

	 
	
}