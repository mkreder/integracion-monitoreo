package vos;

import java.io.Serializable;

public class VoDespachoSugerido implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private VoDespacho despacho;
	private VoVenta venta;
	
	/* GETTERS Y SETTERS */
	 
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	 
	public VoVenta getVenta() {
		return venta;
	}
	
	public void setVenta(VoVenta venta) {
		this.venta = venta;
	}
	
 
	public VoDespacho getDespacho() {
		return despacho;
	}
	
	public void setDespacho(VoDespacho despacho) {
		this.despacho = despacho;
	}
	
}