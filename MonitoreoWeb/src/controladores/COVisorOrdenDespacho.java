package controladores;

import javax.ejb.EJB;

import com.monitor.Fachada.IFachada;

import dominio.Venta;
import vos.VentaDTO;
import vos.VoOrdenDespacho;

public class COVisorOrdenDespacho {

//	private BD controlador = BD.getInstancia();
	@EJB IFachada controlador;
	
	private String enviada;
	private String fecha;
	private String despacho;
	private String codVenta;
	
	public COVisorOrdenDespacho(long idVenta) {
		enviada = new String();
		fecha = new String();
		despacho = new String();
		codVenta = new String();
		cargarDatosOrdenDespacho(idVenta);
	}
	
	public void cargarDatosOrdenDespacho(long idVenta){
		VentaDTO venta = controlador.obtenerVenta(idVenta);
		VoOrdenDespacho od = controlador.obtenerOrdenDespachoDeVenta(idVenta);
		codVenta = String.valueOf(venta.getNroVenta());
		despacho = Long.toString(od.getId());
		if ( od.getEstaEnviada() == true){
			enviada = "Despachada";
		}else{
			enviada = "No Despachada";
		}
		fecha = venta.getFecha();
	}
	
	/* GETTERS Y SETTERS */
	
	public String getEnviada() {
		return enviada;
	}
	
	public void setEnviada(String enviada) {
		this.enviada = enviada;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getDespacho() {
		return despacho;
	}
	
	public void setDespacho(String despacho) {
		this.despacho = despacho;
	}
	
	public String getCodVenta() {
		return codVenta;
	}
	
	public void setCodVenta(String codVenta) {
		this.codVenta = codVenta;
	}
	
}
