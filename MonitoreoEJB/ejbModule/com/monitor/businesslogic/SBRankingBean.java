package com.monitor.businesslogic;


import javax.ejb.Stateless;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.monitor.business.SBRankingBeanLocal;
import com.monitor.business.SBRankingBeanRemote;

import dominio.Producto;

/**
 * Session Bean implementation class SBRankingBean
 */
@Stateless
public class SBRankingBean implements SBRankingBeanRemote, SBRankingBeanLocal {

    /**
     * Default constructor. 
     */
    public SBRankingBean() {
        // TODO Auto-generated constructor stub
    }
 

    	@PersistenceContext(unitName = "CRM")
    	private EntityManager manager;

     
    	@Override
    	@SuppressWarnings("unchecked")
    	//Puede retornar null
    	public ArrayList<Producto> obtenerProductosMasVendidos() {
    		ArrayList<Producto> productos = (ArrayList<Producto>) manager
    				.createQuery(
    						"SELECT p FROM Producto p ORDER BY p.cantidadVentas desc, p.id")
    				.setMaxResults(10).getResultList();
    	 		return productos;
    	}
    
}
