package com.monitor.business;

import java.text.ParseException;
import java.util.ArrayList;

import javax.ejb.Local;

import dominio.InformeDeAuditoria;
import vos.LogDTO;
@Local
public interface ISBInformesAuditoria {

	void generarInformeAuditoria(LogDTO i) throws ParseException;

	ArrayList<InformeDeAuditoria> obtenerInformesAuditoria();

}
