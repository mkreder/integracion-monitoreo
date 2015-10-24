package com.monitor.business;

import javax.ejb.Remote;

import vos.VoVenta;

@Remote
public interface SBVentaBeanRemote {
	boolean procesarVenta(VoVenta voVenta);

}
