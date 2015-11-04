 
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
		public String procesarVenta(VentaDTO voVenta) {
			System.out.println("Estoy procesando la venta");
		 /*
		Venta venta = new Venta();
			Cliente cliente = (Cliente) manager
					.createQuery("select c from Cliente c where c.dni= :Dni")
					.setMaxResults(1)
					.setParameter("Dni", Long.valueOf(voVenta.getDni()))
					.getSingleResult();
			if (cliente != null)
				venta.setCliente(cliente);
			else
				return "Error al procesar la venta";
			venta.setCodigo(voVenta.getCodigoVenta());
			venta.setEstado((Venta.con_noDespachada));//Esto sacarlo que cuando se cree la venta se inicialice el estado sin despachar
			venta.setFecha(voVenta.getFechaHoraVenta());
			List<VoItemVenta> itemsVOVenta = voVenta.getCollectionItems();
			if (itemsVOVenta.size() == 0)
				return "Error al procesar la venta";
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
					return "Error al procesar la venta";
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
			System.out.println(voVenta.getCodigoPortal());
			
			Portal portal = (Portal) manager
					.createQuery(
							"select p from Portal p where p.codigo = :codPortal")
					.setParameter("codPortal",
							Long.valueOf(voVenta.getCodigoPortal()))
					.setMaxResults(1).getSingleResult();
			if (portal == null)
				return "Error al procesar la venta";
			venta.setPortal(portal);
			//ver si me guarda los items relacionados a la venta
					manager.persist(venta);
			
			//Busco posible despacho
			ArrayList<Despacho> despachosActivos = new ArrayList<Despacho>();
			Query queryDespachos = manager
					.createQuery("select d from Despacho d where d.estado = true");
			despachosActivos = (ArrayList<Despacho>) queryDespachos.getResultList();
			if (despachosActivos.size() <= 0)
				return "Error al procesar la venta";

			float cordenadasX = Float.valueOf(voVenta.getCoordenadasUsuario().split(",")[0]);
			float cordenadasY = Float.valueOf(voVenta.getCoordenadasUsuario().split(",")[1]);
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
			return "OK al procesar la venta";
			*/
			return "error al procesar la venta";
		}

		@SuppressWarnings("unchecked")
		@Override
		public ArrayList<DespachoSugerido> obtenerVentasSinOrdenesDeDespacho() {

			ArrayList<Venta> ventas = new ArrayList<Venta>();
			ArrayList<Long> ids = new ArrayList<Long>();
			Query query = manager
					.createQuery("select v from Venta v where v.ordenDeDespacho IS NULL");
			ventas = (ArrayList<Venta>) query.getResultList();
			ArrayList<DespachoSugerido> sugeridos = new ArrayList<DespachoSugerido>();

			for (Venta v : ventas) 
				ids.add(v.getId());

			for (Long idVenta : ids) {
				DespachoSugerido despachoSugerido = (DespachoSugerido) manager
						.createQuery(
								"select d from DespachoSugerido d where d.venta.id=:idVenta")
						.setParameter("idVenta", idVenta).setMaxResults(1)
						.getSingleResult();
				sugeridos.add(despachoSugerido);

			}

			return sugeridos;
		}

		@Override
		public void asociarOrdenesDeDespachoAVentas(ArrayList<Long> idsVentas,
				ArrayList<Long> idsDespachos) {
			int i = 0;
			try {
				for (Long idDespacho : idsDespachos) {
					Despacho despacho = manager.find(Despacho.class, idDespacho);
					Venta venta = manager
							.find(Venta.class, (Long) idsVentas.get(i));

					OrdenDespacho ordenDespacho = new OrdenDespacho();
					ordenDespacho.setDespacho(despacho);
					ordenDespacho.setVenta(venta);
					ordenDespacho.setFecha(new Date());
					ordenDespacho.setEstaEnviada(false);
					manager.persist(ordenDespacho);
					venta.setOrdenDespacho(ordenDespacho);
					manager.merge(venta);
					manager.flush();
					i++;
					// Envio de orden de despacho a Despacho --> segun WSDL de santi esta esto
			/*ACA IRIA CON EL WSDL QUE NOS MANDA DESPACHO
			VoOrdenDeDespacho voOrdenDeDespacho = new VoOrdenDeDespacho();
					voOrdenDeDespacho.setIdVenta(Integer.valueOf(""+venta.getCodigo()));
					voOrdenDeDespacho.setIdOrdenDeDespacho(Integer.valueOf(String.valueOf(ordenDespacho.getId())));
					voOrdenDeDespacho.setNombreLogisticaYMonitoreo("LOGISTICA2"); //SIEMPRE SOMOS LOGISTICA 2 NOSOTROS
					voOrdenDeDespacho.setNombrePortalWeb(venta.getPortal().getDescripcion());
					for (ItemVenta itemVenta : venta.getItemsVenta()){
						VoDetalleOrdenDeDespacho voDetalleOrdenDeDespacho = new VoDetalleOrdenDeDespacho();
						voDetalleOrdenDeDespacho.setCantidad(Integer.valueOf(String.valueOf(itemVenta.getCantidad())));
						voDetalleOrdenDeDespacho.setCodigoArticulo(Integer.valueOf(String.valueOf(itemVenta.getProducto().getCodigo())));
						voOrdenDeDespacho.getDetallesOrdenDeDespachoVO().add(voDetalleOrdenDeDespacho);
					}
					if(venta.getOrdenDespacho().getDespacho().getNombre().equalsIgnoreCase("DESPACHO1")){
						System.out.println("DESPACHO1");
					    System.out.println("***********************");
					    System.out.println("Create Web Service Client...");
					    AdministradorOrdenDeDespachoBeanService service1 = new AdministradorOrdenDeDespachoBeanService();
					    System.out.println("Create Web Service...");
					    AdministradorOrdenDeDespachoBean port1 = service1.getAdministradorOrdenDeDespachoBeanPort();
					    
					    System.out.println("Call Web Service Operation...");
					    System.out.println("Server said: " + port1.recepcionOrdenDeDespacho(voOrdenDeDespacho));
					    System.out.println("***********************");
					    System.out.println("Call Over!");
					}else{
						URL url = new URL("http://172.16.164.40:8080/TPO_Despacho_Barril_Magaldi/AdministradorOrdenDeDespachoBean?wsdl");
						System.out.println("DESPACHO2");
						System.out.println("***********************");
					    System.out.println("Create Web Service Client...");
					    AdministradorOrdenDeDespachoBeanService service1 = new AdministradorOrdenDeDespachoBeanService(url);
					    System.out.println("Create Web Service...");
					    AdministradorOrdenDeDespachoBean port1 = service1.getAdministradorOrdenDeDespachoBeanPort();
					    System.out.println("Call Web Service Operation...");
					    System.out.println("Server said: " + port1.recepcionOrdenDeDespacho(voOrdenDeDespacho));
					    System.out.println("***********************");
					    System.out.println("Call Over!");
					}
					*/
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@SuppressWarnings("unchecked")
		@Override
		public ArrayList<Venta> obtenerVentas() {
			ArrayList<Venta> ventas = new ArrayList<Venta>();
			Query query = manager.createQuery("select v from Venta v");
			ventas = (ArrayList<Venta>) query.getResultList();
			return ventas;
		}

		@SuppressWarnings("unchecked")
		@Override
		public ArrayList<Venta> obtenerVentasDePortal(long idPortal) {
			Portal portal = (Portal) manager
					.createQuery("select p from Portal p where p.id = :idPortal")
					.setParameter("idPortal", idPortal).setMaxResults(1)
					.getSingleResult();
			ArrayList<Venta> ventas = new ArrayList<Venta>();
			if (portal != null) {
				Query query = manager.createQuery("select v from Venta v where v.portal.id=:idPortal")
						.setParameter("idPortal", portal.getId())
						.setMaxResults(10);
				ventas = (ArrayList<Venta>) query.getResultList();
			}
			return ventas;
		}

		@SuppressWarnings("unchecked")
		@Override
		public ArrayList<Despacho> obtenerDespachosActivos() {
			ArrayList<Despacho> despachos = new ArrayList<Despacho>();
			Query query = manager
					.createQuery("select d from Despacho d where d.estaActivo = true order by d.id");
			despachos = (ArrayList<Despacho>) query.getResultList();
			return despachos;
		}

		@Override
		public Venta obtenerVenta(long idVenta) {
			Venta venta = new Venta();
			Query query = manager
					.createQuery("SELECT v FROM Venta v where v.id = :idVenta")
					.setMaxResults(1).setParameter("idVenta", idVenta);
			venta = (Venta) query.getSingleResult();
			return venta;
		}

		@Override
		public Venta obtenerVentaPorCodigo(long codVta) {
			Venta venta = new Venta();
			Query query = manager
					.createQuery("SELECT v FROM Venta v where v.codigo = :codigoVenta")
					.setMaxResults(1).setParameter("codigoVenta", codVta);
			venta = (Venta) query.getSingleResult();
			return venta;
		}
		@Override
		public String procesarCarrito(String carrito){
			System.out.println("SIMULO QUE HAGO ALGO CON EL CARRITO");
			return "Carrito OK";
		}

	
		
}