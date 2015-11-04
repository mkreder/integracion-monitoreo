package vos;

import java.io.Serializable;

public class VoCarrito  implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idBusqueda;
	private VoCarrito carrito;
	public int getIdBusqueda() {
		return idBusqueda;
	}
	public void setIdBusqueda(int idBusqueda) {
		this.idBusqueda = idBusqueda;
	}
	public VoCarrito getCarrito() {
		return carrito;
	}
	public void setCarrito(VoCarrito carrito) {
		this.carrito = carrito;
	}
	 
}
