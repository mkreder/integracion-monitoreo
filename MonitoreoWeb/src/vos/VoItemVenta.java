package vos;

import java.io.Serializable;

public class VoItemVenta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	private long cantidad;
	private VoProducto producto;
	
	/*GETTERS Y SETTERS*/
	
 
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}
 
	public VoProducto getProducto() {
		return producto;
	}
	
	public void setProducto(VoProducto producto) {
		this.producto = producto;
	}
	
}