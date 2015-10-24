package com.monitor.businesslogic;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.monitor.business.SBVentaBeanLocal;
import com.monitor.business.SBVentaBeanRemote;

import dominio.*;
import vos.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 * Session Bean implementation class SBVentaBean
 */
@Stateless
@LocalBean
public class SBVentaBean implements SBVentaBeanRemote, SBVentaBeanLocal {

 
		@PersistenceContext(unitName = "CRM")
		private EntityManager manager;

		public SBVentaBean() {
		}

		@SuppressWarnings("unchecked")
		@Override
		public boolean procesarVenta(VoVenta voVenta) {
			System.out.println("LLEGUEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
			return true;
		/*	Venta venta = new Venta();
			Cliente cliente = (Cliente) manager
					.createQuery("select c from Cliente c where c.dni= :Dni")
					.setMaxResults(1)
					.setParameter("Dni", Long.valueOf(voVenta.getCliente().getDni()))
					.getSingleResult();
			if (cliente != null)
				venta.setCliente(cliente);
			else
				return false;
			venta.setCodigo(voVenta.getCodigo());
			venta.setEstado((Venta.con_noDespachada));//Esto sacarlo que cuando se cree la venta se inicialice el estado sin despachar
			venta.setFecha(voVenta.getFecha());
			List<VoItemVenta> itemsVOVenta = voVenta.getItemsVenta();
			if (itemsVOVenta.size() == 0)
				return false;
			List<ItemVenta> itemsVenta = new ArrayList<ItemVenta>();
			for (VoItemVenta item : itemsVOVenta) {
				Producto producto = (Producto) manager
						.createQuery(
								"select p from Producto p where p.codigo = :cod")
						.setMaxResults(1)
						.setParameter("cod",
								Long.valueOf(item.getProducto().getCodigo()))
						.getSingleResult();
				if (producto == null)
					return false;
				ItemVenta itemVenta = new ItemVenta();
				itemVenta.setProducto(producto);
				itemVenta.setCantidad(item.getCantidad());
				itemsVenta.add(itemVenta);
				
				//ACA nose si se guarda asi, porque no estoy teniendo en cuanta la relacion con VENTA 
				manager.persist(itemVenta);
				producto.setcantidadVendidos(producto.getCantidadVendidos()+itemVenta.getCantidad());
				manager.merge(producto);
			}
			venta.setItemsVenta(itemsVenta);
			venta.setOrdenDespacho(null);
			//No hace falta
			System.out.println(voVenta.getPortal().getCodigo());
			
			Portal portal = (Portal) manager
					.createQuery(
							"select p from Portal p where p.codigo = :codPortal")
					.setParameter("codPortal",
							Long.valueOf(voVenta.getPortal().getCodigo()))
					.setMaxResults(1).getSingleResult();
			if (portal == null)
				return false;
			venta.setPortal(portal);
			//ver si me guarda los items relacionados a la venta
					manager.persist(venta);
			
			//Busco posible despacho
			ArrayList<Despacho> despachosActivos = new ArrayList<Despacho>();
			Query queryDespachos = manager
					.createQuery("select d from Despacho d where d.estado = true");
			despachosActivos = (ArrayList<Despacho>) queryDespachos.getResultList();
			if (despachosActivos.size() <= 0)
				return false;

			float cordenadasX = Float.valueOf(voVenta.getCliente().getCoordenada().split(",")[0]);
			float cordenadasY = Float.valueOf(voVenta.getCliente().getCoordenada().split(",")[1]);
			DespachoSugerido sugerido = new DespachoSugerido();
			sugerido.setVenta(venta);
			// Busco el despacho m?s cercano al usuario segun sus cordenadas
			float dif = -1;
			for (Despacho despacho : despachosActivos) {
				float corDespX = Float
						.valueOf(despacho.getCoordenadas().split(",")[0]);
				float corDespY = Float
						.valueOf(despacho.getCoordenadas().split(",")[1]);
				if (dif == -1
						|| cordenadasX + cordenadasY - corDespX - corDespY < dif) {
					sugerido.setDespacho(despacho);
					dif = cordenadasX + cordenadasY - corDespX - corDespY;
				}
			}
			manager.persist(sugerido);
			return true;
			*/
		}
}