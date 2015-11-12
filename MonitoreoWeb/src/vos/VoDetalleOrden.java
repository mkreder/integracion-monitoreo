package vos;

public class VoDetalleOrden {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int Codproducto;
	private int cantidad;
	
	/* GETTERS Y SETTERS */
	
	public int getCantidad() {
		return cantidad;
	}
	
	public int getCodproducto() {
		return Codproducto;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void setCodproducto(int Codproducto) {
		this.Codproducto = Codproducto;
	}
	
}