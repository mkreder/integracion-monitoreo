package businessDelegate;

import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.monitor.Fachada.*;

import vos.ArticuloDTO;
import vos.InformeAuditoriaDTO;
import vos.PortalDTO;
import vos.VentaDTO;
import vos.VoOrdenDespacho;
import dominio.Despacho;
import dominio.OrdenDespacho;
import dominio.Portal;
import dominio.Producto;
import dominio.Venta;

public class BD {

	private static BD instancia;
	private IFachada adminFachada;
	private BD() {
		lookupService();
	}

	public static BD getInstancia() {
		if (instancia == null)
			instancia = new BD();
		return instancia;
	}
	
	/* LOOKUP DE FACHADA */
	
	private void lookupService() {
		try {
//			final String appName = "TPO_Logistica_Y_MonitoreoEAR";
//			final String moduleName = "TPO_Logistica_Y_MonitoreoEJB";
//			final String sessionBeanName = "FachadaLogYMonBean";
//			final String viewClassName = FachadaLogYMon.class.getName();
//			Properties jndiProps = new Properties();
//			jndiProps.put(Context.INITIAL_CONTEXT_FACTORY,
//					"org.jboss.naming.remote.client.InitialContextFactory");
//			jndiProps.put(Context.PROVIDER_URL, "remote://127.0.0.1:4447/");
			// AdminUser: test
			// AdminPass: test1234.

			// username
			// usuario de servidor: managementuser
			// password: cristian10!
//			jndiProps.put(Context.SECURITY_PRINCIPAL, "appuser");
			// password
//			jndiProps.put(Context.SECURITY_CREDENTIALS, "cristian10!");
			// This is an important property to set if you want to do EJB
			// invocations via the remote-naming project
//			jndiProps.put("jboss.naming.client.ejb.context", true);
			// create a context passing these properties

			Context context = new InitialContext();
			
//			 adminFachada = (FachadaLogYMon) context
//					.lookup(appName + "/" + moduleName + "/" + sessionBeanName
//							+ "!" + viewClassName);
   			 adminFachada = (IFachada)context.lookup("java:global/MonitoreoEAR/MonitoreoEJB/Fachada!sessionFacade.IFachada");

		} catch (Exception e) {
			System.out.println("error al levantar servicio");
			e.printStackTrace();
		}
	}

	/* METODOS DE LA FACHADA */
	public ArrayList<VentaDTO> obtenerVentasSinOrdenesDeDespacho() {
		return adminFachada.obtenerVentasSinOrdenesDeDespacho();
	}

	public void asociarOrdenesDeDespachoAVentas(ArrayList<Long> idsVentas, ArrayList<Long> idsDespachos) {
		adminFachada.asociarOrdenesDeDespachoAVentas(idsVentas, idsDespachos);
	}

	public ArrayList<VentaDTO> obtenerVentas() {
		return adminFachada.obtenerVentas();
	}

	public ArrayList<VentaDTO> obtenerVentasDePortal(long idPortal){
		return adminFachada.obtenerVentasDePortal(idPortal);
	}

	public VoOrdenDespacho obtenerOrdenDespachoDeVenta(long idVenta){
		return adminFachada.obtenerOrdenDespachoDeVenta(idVenta);
	}

	public ArrayList<VoOrdenDespacho> obtenerDespachosActivos(){
		return adminFachada.obtenerDespachosActivos();
	}
	
	public ArrayList<ArticuloDTO> obtenerProductosBestSeller(){
		return adminFachada.obtenerProductosBestSeller();
	}
	
	public void cambiarEstadoOrdenDeDespacho(long idOrdenDeDespacho){
		adminFachada.cambiarEstadoOrdenDespacho(idOrdenDeDespacho);
	}
	
	public ArrayList<InformeAuditoriaDTO> obtenerInformesAuditoriaNearOnLine(){
		return adminFachada.cargarInformesAuditoriaNearOnLine();
	}
	
	public ArrayList<PortalDTO> obtenerPortales(){
		return adminFachada.obtenerPortales();
	}

	public VentaDTO obtenerVenta(long idVenta){
		return adminFachada.obtenerVenta(idVenta);
	}
	
}
