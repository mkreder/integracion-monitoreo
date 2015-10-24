package vos;

import java.io.Serializable;
import java.util.Date;

public class VoOrdenDespacho implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private boolean estaEnviada;
	private Date fecha;
	private VoDespacho despacho;
	private VoVenta venta;
	
	/*GETTERS Y SETTERS*/
	
 
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public void setEstaEnviada(boolean estaEnviada) {
		this.estaEnviada = estaEnviada;
	}
	
	public boolean getEstaEnviada(){
		return estaEnviada;
	}

	 
	public VoDespacho getDespacho() {
		return despacho;
	}
	
	public void setDespacho(VoDespacho despacho) {
		this.despacho = despacho;
	}
	
 
	public VoVenta getVenta() {
		return venta;
	}
	
	public void setVenta(VoVenta venta) {
		this.venta = venta;
	}
	
}