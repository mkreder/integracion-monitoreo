package com.monitor.Fachada;

import java.text.ParseException;
import java.util.ArrayList;

import javax.ejb.*;

import com.monitor.business.ISBInformesAuditoria;
import com.monitor.business.SBVentaBeanLocal;

import vos.ArticuloDTO;
import vos.InformeAuditoriaDTO;
import vos.LogDTO;
import vos.PortalDTO;
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
	public void procesarCarrito(String carrito){
		 SBventa.procesarCarrito(carrito);
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
	@Override
	public void asociarOrdenesDeDespachoAVentas(ArrayList<Long> idsVentas, ArrayList<Long> idsDespachos) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<VentaDTO> obtenerVentas() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<VentaDTO> obtenerVentasDePortal(long idPortal) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public VoOrdenDespacho obtenerOrdenDespachoDeVenta(long idVenta) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<ArticuloDTO> obtenerProductosBestSeller() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void cambiarEstadoOrdenDespacho(long idOrdenDeDespacho) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<InformeAuditoriaDTO> cargarInformesAuditoriaNearOnLine() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<PortalDTO> obtenerPortales() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public VentaDTO obtenerVenta(long idVenta) {
		// TODO Auto-generated method stub
		return null;
	}
	}

 