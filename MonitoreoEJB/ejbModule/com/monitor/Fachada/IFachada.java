package com.monitor.Fachada;

import java.text.ParseException;
import java.util.ArrayList;

import javax.ejb.Remote;

import dominio.OrdenDespacho;
import vos.LogDTO;
import vos.VentaDTO;
import vos.VoOrdenDespacho;


@Remote
public interface IFachada {

	String procesarVenta(VentaDTO venta);

	void generarInformeAuditoria(LogDTO i) throws ParseException;

	String procesarCarrito(String notificacion);

	ArrayList<VentaDTO> obtenerVentasSinOrdenesDeDespacho();

	ArrayList<VoOrdenDespacho> obtenerDespachosActivos();
}
