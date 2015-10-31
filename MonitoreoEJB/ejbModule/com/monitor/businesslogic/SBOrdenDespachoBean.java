package com.monitor.businesslogic;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;
import javax.persistence.Query;

import com.monitor.business.SBOrdenDespachoBeanLocal;
import com.monitor.business.SBOrdenDespachoBeanRemote;

import dominio.OrdenDespacho;
import dominio.Venta;

/**
 * Session Bean implementation class SBOrdenDespachoBean
 */
@Stateless
@LocalBean
public class SBOrdenDespachoBean implements SBOrdenDespachoBeanRemote, SBOrdenDespachoBeanLocal {

    /**
     * Default constructor. 
     */
    public SBOrdenDespachoBean() {
        // TODO Auto-generated constructor stub
    }

	@PersistenceContext(unitName="CRM")
	private EntityManager manager;
public boolean cambiarEstadoOrdenDespacho(Long idOrdenDespacho) {
		
		
		OrdenDespacho ordenDespacho=(OrdenDespacho)manager.find(OrdenDespacho.class, Long.valueOf(idOrdenDespacho));
		ordenDespacho.setEstaEnviada(true);
		Venta venta = (Venta)ordenDespacho.getVenta();
		
		venta.setEstado(venta.con_despachada);
		manager.merge(ordenDespacho);
		manager.merge(venta);
		OrdenDespacho ordenDespachoTest=(OrdenDespacho)manager.find(OrdenDespacho.class, idOrdenDespacho);
		if(ordenDespachoTest.getEstaEnviada())
		return true;
		else
		return false;
		}
	

	@Override
	public OrdenDespacho obtenerOrdenDespachoDeVenta(long idVenta) {
		OrdenDespacho ordenDespacho = new OrdenDespacho();
		Query query = manager.createQuery("select o from OrdenDespacho o where o.venta.id =:idVenta").setParameter("idVenta", idVenta).setMaxResults(1);
		ordenDespacho = (OrdenDespacho)query.getSingleResult();
			return ordenDespacho;
	}


}
