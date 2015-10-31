package com.monitor.business;

import java.util.ArrayList;

import javax.ejb.Local;

import dominio.Portal;

@Local
public interface SBPortalBeanLocal {

	ArrayList<Portal> obtenerPortales();

}
