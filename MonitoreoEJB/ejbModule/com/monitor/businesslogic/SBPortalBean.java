package com.monitor.businesslogic;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;

import com.monitor.business.SBPortalBeanLocal;

import dominio.Portal;

/**
 * Session Bean implementation class SBPortalBean
 */
@Stateless
@LocalBean
public class SBPortalBean implements SBPortalBeanLocal {

    /**
     * Default constructor. 
     */
    public SBPortalBean() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName = "CRM")
   	private EntityManager manager;

   	@SuppressWarnings("unchecked")
   	@Override
   	public ArrayList<Portal> obtenerPortales() {
   		ArrayList<Portal> portales = new ArrayList<Portal>();
   		Query query = manager.createQuery("SELECT p FROM Portal p");
   		portales = (ArrayList<Portal>)query.getResultList();
   		return portales;
   	}
       
}
