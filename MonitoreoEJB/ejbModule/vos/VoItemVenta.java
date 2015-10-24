package vos;

import java.io.Serializable;

 

 
public class VoItemVenta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VoProducto producto;
	private Integer cantidad;
	private float precio;
	private Integer codigo;
	
	public VoItemVenta() {
	}

	/* GETTERS Y SETTERS */
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
 
	
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public VoProducto getProducto() {
		return producto;
	}

	public void setProducto(VoProducto producto) {
		this.producto = producto;
	}

}