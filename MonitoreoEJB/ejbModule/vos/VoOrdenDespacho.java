package vos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

 
 
 
public class VoOrdenDespacho implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int codigoOrdenDeDespacho;
	private String nombrePortalWeb;
	private String nombreLogisticaYMonitoreo;
	private List<VoDetalleOrden> detalle;
	
	/* GETTERS Y SETTERS */
	
	public int getCodigoOrdenDeDespacho() {
		return codigoOrdenDeDespacho;
	}
	
	public void setCodigoOrdenDeDespacho(int codigoOrdenDeDespacho) {
		this.codigoOrdenDeDespacho = codigoOrdenDeDespacho;
	}
	
	public String getNombreLogisticaYMonitoreo() {
		return nombreLogisticaYMonitoreo;
	}
	
	public void setNombreLogisticaYMonitoreo(String nombreLogisticaYMonitoreo) {
		this.nombreLogisticaYMonitoreo = nombreLogisticaYMonitoreo;
	}
	
	public void setNombrePortalWeb(String nombrePortalWeb) {
		this.nombrePortalWeb = nombrePortalWeb;
	}
	
	public String getNombrePortalWeb() {
		return nombrePortalWeb;
	}
	
	public List<VoDetalleOrden> getDetallerOrden() {
		return detalle;
	}
	
	public void setDetallerOrden(
			List<VoDetalleOrden> detalle) {
		this.detalle = detalle;
	}
	
}