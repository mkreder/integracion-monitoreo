package com.monitor.webService;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.monitor.Fachada.IFachada;
import com.monitor.webServiceInterface.IWSInformeAuditoria;

import dominio.InformeDeAuditoria;
import vos.VoInformeDeAuditoria;
 
@Stateless
@WebService
public class WSInformeAuditoriaBean implements IWSInformeAuditoria {

	@EJB
	IFachada fachada;
	
    public WSInformeAuditoriaBean() {

    }

    @WebMethod
    @Override
    public boolean agregarInforme(VoInformeDeAuditoria informeAuditoria){
    	InformeDeAuditoria i= new InformeDeAuditoria();
    	try {
    		i.setDescripcion(informeAuditoria.getDescripcion());
        	i.setFecha(new Date());
        	//Agregar el modulo q lo mando supongo q el id
        	fachada.generarInformeAuditoria(i);
        	return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    	
    }
}