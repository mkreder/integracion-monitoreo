package com.monitor.business;

import javax.ejb.Local;

import dominio.InformeDeAuditoria;
@Local
public interface ISBInformesAuditoria {

	void generarInformeAuditoria(InformeDeAuditoria i);

}
