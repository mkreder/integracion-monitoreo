package com.monitor.Fachada;

import java.text.ParseException;

import javax.ejb.*;

import com.monitor.business.ISBInformesAuditoria;
import com.monitor.business.SBVentaBeanLocal;

import vos.LogDTO;
import vos.VentaDTO;

 

@Stateless
public class Fachada implements IFachada {
		
	@EJB 
	SBVentaBeanLocal SBventa;
	@EJB 
	ISBInformesAuditoria SBinforme;
	@Override
	public String procesarVenta(VentaDTO venta) {
		return SBventa.procesarVenta(venta);
	}
	@Override
	public void generarInformeAuditoria(LogDTO i) throws ParseException {
		SBinforme.generarInformeAuditoria(i);
		
	}
	public String procesarCarrito(String carrito){
		return SBventa.procesarCarrito(carrito);
	}
	}

 