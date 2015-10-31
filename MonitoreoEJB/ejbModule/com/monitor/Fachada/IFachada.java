package com.monitor.Fachada;

import javax.ejb.Remote;

import dominio.InformeDeAuditoria;
import vos.VoCarrito;
import vos.VoVenta;

@Remote
public interface IFachada {

	String procesarVenta(VoVenta venta);

	void generarInformeAuditoria(InformeDeAuditoria i);

	String procesarCarrito(VoCarrito carrito);
}
