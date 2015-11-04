package com.monitor.webService;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.monitor.Fachada.IFachada;
import com.monitor.webServiceInterface.IWSInformeAuditoria;

import dominio.InformeDeAuditoria;
import vos.LogDTO;

 
@Stateless
@WebService
public class WSInformeAuditoriaBean implements IWSInformeAuditoria {

	@EJB
	IFachada fachada;
	
    public WSInformeAuditoriaBean() {

    }

    @WebMethod
    @Override
    public boolean agregarInforme(LogDTO informeAuditoria){
    	 
    	try {
    		 
        	//Agregar el modulo q lo mando supongo q el id
        	fachada.generarInformeAuditoria(informeAuditoria);
        	return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    	
    }
}