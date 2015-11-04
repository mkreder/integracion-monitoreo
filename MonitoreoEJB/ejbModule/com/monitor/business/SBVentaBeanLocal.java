package com.monitor.business;

import java.util.ArrayList;

import javax.ejb.Local;

import dominio.Despacho;
import dominio.DespachoSugerido;
import dominio.Venta;
import vos.VentaDTO;
 

@Local
public interface SBVentaBeanLocal {

	String procesarVenta(VentaDTO voVenta);

	ArrayList<DespachoSugerido> obtenerVentasSinOrdenesDeDespacho();

	void asociarOrdenesDeDespachoAVentas(ArrayList<Long> idsVentas, ArrayList<Long> idsDespachos);

	ArrayList<Venta> obtenerVentas();

	ArrayList<Venta> obtenerVentasDePortal(long idPortal);

	ArrayList<Despacho> obtenerDespachosActivos();

	Venta obtenerVenta(long idVenta);

	Venta obtenerVentaPorCodigo(long codVta);

	String procesarCarrito(String carrito);

}
