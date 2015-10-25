package businessDelegate;

import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.monitor.Fachada.IFachada;

import vos.VoDespacho;
import vos.VoVenta;
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
			adminFachada = (IFachada)context.lookup("java:global/TPO_Logistica_Y_MonitoreoEAR/TPO_Logistica_Y_MonitoreoEJB/FachadaLogYMonBean!sessionFacade.FachadaLogYMon");

		} catch (Exception e) {
			System.out.println("error al levantar servicio");
			e.printStackTrace();
		}
	}

	/* METODOS DE LA FACHADA */
	
	public ArrayList<VoVenta> obtenerVentasSinOrdenesDeDespacho() {
		return adminFachada.obtenerVentasSinOrdenesDeDespacho();
	}

	public ArrayList<VoDespacho> obtenerDespachosActivos(){
		return adminFachada.obtenerDespachosActivos();
	}
	
}
