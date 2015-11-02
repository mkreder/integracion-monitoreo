package com.monitor.Fachada;

import java.util.ArrayList;

import javax.ejb.Remote;

import dominio.InformeDeAuditoria;
=======
import vos.VoCarrito;
import vos.VoVenta;
import vos.VoDespacho;

@Remote
public interface IFachada {

	String procesarVenta(VoVenta venta);

	void generarInformeAuditoria(InformeDeAuditoria i);

	ArrayList<VoVenta> obtenerVentasSinOrdenesDeDespacho();

	ArrayList<VoDespacho> obtenerDespachosActivos();

	String procesarCarrito(VoCarrito carrito);
}
