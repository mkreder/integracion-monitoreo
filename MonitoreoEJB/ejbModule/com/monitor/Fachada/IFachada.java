package com.monitor.Fachada;

import java.text.ParseException;

import javax.ejb.Remote;


import vos.LogDTO;
import vos.VentaDTO;
 
@Remote
public interface IFachada {

	String procesarVenta(VentaDTO venta);

	void generarInformeAuditoria(LogDTO i) throws ParseException;

	String procesarCarrito(String notificacion);
}
