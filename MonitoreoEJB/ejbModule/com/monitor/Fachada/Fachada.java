package com.monitor.Fachada;

import java.text.ParseException;
import java.util.ArrayList;

import javax.ejb.*;

import com.monitor.business.ISBInformesAuditoria;
import com.monitor.business.SBVentaBeanLocal;

import vos.LogDTO;
import vos.VentaDTO;
import vos.VoOrdenDespacho;

 

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
	@Override
	public ArrayList<VentaDTO> obtenerVentasSinOrdenesDeDespacho() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<VoOrdenDespacho> obtenerDespachosActivos() {
		// TODO Auto-generated method stub
		return null;
	}
	}

 