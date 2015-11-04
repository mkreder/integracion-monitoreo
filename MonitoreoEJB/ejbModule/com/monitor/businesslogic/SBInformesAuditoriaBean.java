package com.monitor.businesslogic;




import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.monitor.business.ISBInformesAuditoria;

import dominio.InformeDeAuditoria;
import vos.LogDTO;


 
@Stateless
@LocalBean
public class SBInformesAuditoriaBean implements ISBInformesAuditoria {

	@PersistenceContext(unitName="CRM")
	private EntityManager manager;
	
    public SBInformesAuditoriaBean() {
    }

	@Override
	public void generarInformeAuditoria(LogDTO i) throws ParseException {
		InformeDeAuditoria informeAuditoria= new InformeDeAuditoria();
		 
			informeAuditoria.setFecha(new Date());
		informeAuditoria.setModulo(i.getIdModulo());
		informeAuditoria.setDescripcion(i.getMensaje());
		
		
		
		manager.persist(informeAuditoria);
		System.out.println("GRABE");
	}


	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<InformeDeAuditoria> obtenerInformesAuditoria() {
		ArrayList<InformeDeAuditoria> informes  = new ArrayList<InformeDeAuditoria>();
		 Calendar fechaActual = Calendar.getInstance();
		 fechaActual.setTime(new Date());
     DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
     DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
     System.out.println("FECHA ACTUAL: "+formatoFecha.format(fechaActual)+"HORA ACTUAL: "+formatoHora.format(fechaActual)+"");
    //REVISAR LA RESTA
    fechaActual.add(Calendar.SECOND,-3);
     System.out.println("una vez restados los 3 segundos");
     System.out.println("FECHA ACTUAL: "+formatoFecha.format(fechaActual)+"HORA ACTUAL: "+formatoHora.format(fechaActual)+"");
  
     //REVISAR QUERY
     Query query = manager.createQuery("select i from InformeDeAuditoria i e order by i.id desc").setMaxResults(10);
      
 //	   Properties properties = new Properties();
 //	  properties.setProperty("timeZone", databaseTimeZone);
 //	  query.setParameter("date", fechaActual.getTime(), Hibernate.custom(LocalizedDateType.class, properties));
 	informes=(ArrayList<InformeDeAuditoria>)query.getResultList();
  
		return informes;
	}


}