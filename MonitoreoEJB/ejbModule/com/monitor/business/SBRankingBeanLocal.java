package com.monitor.business;

import java.util.ArrayList;

import javax.ejb.Local;

import dominio.Producto;

@Local
public interface SBRankingBeanLocal {

	ArrayList<Producto> obtenerProductosMasVendidos();

}
