package com.monitor.Fachada;

import javax.ejb.Remote;

import dominio.InformeDeAuditoria;

import vos.VoVenta;

@Remote
public interface IFachada {

	boolean procesarVenta(VoVenta venta);

	void generarInformeAuditoria(InformeDeAuditoria i);
}
