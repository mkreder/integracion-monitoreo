package vos;

import java.io.Serializable;

public class VoProducto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	private long codigo;//El codigo es propio del producto pero nosotros lo guardamos por ID
	private String descripcion;
	private float precio;
	private long cantidadVendidos;
	
	/*GETTERS Y SETTERS*/
	
	 
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getCcantidadVendidos() {
		return cantidadVendidos;
	}
	
	public void setcantidadVendidos(long cantidadVendidos) {
		this.cantidadVendidos = cantidadVendidos;
	}
	
	public long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}