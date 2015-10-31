package com.monitor.business;

import javax.ejb.Local;

import dominio.OrdenDespacho;

@Local
public interface SBOrdenDespachoBeanLocal {

	OrdenDespacho obtenerOrdenDespachoDeVenta(long idVenta);

}
