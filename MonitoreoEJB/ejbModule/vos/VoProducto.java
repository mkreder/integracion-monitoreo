
package vos;

import java.io.Serializable;
 
 
public class VoProducto implements Serializable{

	private static final long serialVersionUID = 1L;
	
 
	private long codigo; 
 
	private float precio;
	private long cantidadVendidos;
	
  
	
	public long getCantidadVendidos() {
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
 
	
}
