package com.monitor.Fachada;

import javax.ejb.*;

import com.monitor.business.ISBInformesAuditoria;
import com.monitor.business.SBVentaBeanLocal;

import dominio.InformeDeAuditoria;
import vos.VoVenta;

@Stateless
public class Fachada implements IFachada {
		
	@EJB 
	SBVentaBeanLocal SBventa;
	@EJB 
	ISBInformesAuditoria SBinforme;
	@Override
	public String procesarVenta(VoVenta venta) {
		return SBventa.procesarVenta(venta);
	}
	@Override
	public void generarInformeAuditoria(InformeDeAuditoria i) {
		SBinforme.generarInformeAuditoria(i);
		
	}
}
 