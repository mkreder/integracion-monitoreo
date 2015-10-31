package com.monitor.Fachada;

import java.util.ArrayList;

import javax.ejb.*;

import com.monitor.business.ISBInformesAuditoria;
import com.monitor.business.SBVentaBeanLocal;

import dominio.InformeDeAuditoria;
import vos.VoDespacho;
import vos.VoVenta;

@Stateless
public class Fachada implements IFachada {
		
	@EJB 
	SBVentaBeanLocal SBventa;
	@EJB 
	ISBInformesAuditoria SBinforme;
	@Override
	public boolean procesarVenta(VoVenta venta) {
		return SBventa.procesarVenta(venta);
	}
	@Override
	public void generarInformeAuditoria(InformeDeAuditoria i) {
		SBinforme.generarInformeAuditoria(i);
		
	}
	@Override
	public ArrayList<VoVenta> obtenerVentasSinOrdenesDeDespacho() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<VoDespacho> obtenerDespachosActivos() {
		// TODO Auto-generated method stub
		return null;
	}
}
 