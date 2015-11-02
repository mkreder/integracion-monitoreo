package com.monitor.business;

import java.util.ArrayList;

import javax.ejb.Local;

import dominio.InformeDeAuditoria;
@Local
public interface ISBInformesAuditoria {

	void generarInformeAuditoria(InformeDeAuditoria i);

	ArrayList<InformeDeAuditoria> obtenerInformesAuditoria();

}
