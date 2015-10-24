package com.monitor.businesslogic;




import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import com.monitor.business.ISBInformesAuditoria;

import dominio.InformeDeAuditoria;


 
@Stateless
@LocalBean
public class SBInformesAuditoriaBean implements ISBInformesAuditoria {

	@PersistenceContext(unitName="CRM")
	private EntityManager manager;
	
    public SBInformesAuditoriaBean() {
    }

	@Override
	public void generarInformeAuditoria(InformeDeAuditoria informeAuditoria) {
		manager.persist(informeAuditoria);
		System.out.println("GRABE");
	}

 

}