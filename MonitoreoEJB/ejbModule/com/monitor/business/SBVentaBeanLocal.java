package com.monitor.business;

import javax.ejb.Local;

import vos.VoVenta;

@Local
public interface SBVentaBeanLocal {

	boolean procesarVenta(VoVenta voVenta);

}
