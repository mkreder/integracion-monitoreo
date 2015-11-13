package com.monitor.Fachada;

import java.text.ParseException;
import java.util.ArrayList;

import javax.ejb.Remote;

import dominio.OrdenDespacho;
import dominio.Venta;
import vos.ArticuloDTO;
import vos.InformeAuditoriaDTO;
import vos.LogDTO;
import vos.PortalDTO;
import vos.VentaDTO;
import vos.VoOrdenDespacho;


@Remote
public interface IFachada {
	ArrayList<VentaDTO> obtenerVentasSinOrdenesDeDespacho();
	void asociarOrdenesDeDespachoAVentas(ArrayList<Long> idsVentas, ArrayList<Long> idsDespachos);
	ArrayList<VentaDTO> obtenerVentas();
	ArrayList<VentaDTO> obtenerVentasDePortal(long idPortal);
	VoOrdenDespacho obtenerOrdenDespachoDeVenta(long idVenta);
	ArrayList<VoOrdenDespacho> obtenerDespachosActivos();
	ArrayList<ArticuloDTO> obtenerProductosBestSeller();
	void cambiarEstadoOrdenDespacho(long idOrdenDeDespacho);
	ArrayList<InformeAuditoriaDTO> cargarInformesAuditoriaNearOnLine();
	ArrayList<PortalDTO> obtenerPortales();
	VentaDTO obtenerVenta(long idVenta);
	
}
