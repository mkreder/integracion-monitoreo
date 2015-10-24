package vos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class VoVenta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String estado;
	private Date fecha;
	private long codigo;
	private VoCliente cliente;
	private VoPortal portal;
	private VoOrdenDespacho ordenDespacho;
	
	private List<VoItemVenta> itemsVenta;

	//CONSTANTES
	public static final String  con_noDespachada 		= "NO";
	public static final String con_despachada 			= "SI";
	
	public float calcularMonto(){
		float monto = 0;
		float i=0;
		for(ItemVenta itemVenta : this.getItemsVenta()){
			i= itemVenta.getProducto().getPrecio()*itemVenta.getCantidad();
			monto=monto+i
		}
		return monto;	
	}
	
	/*GETTERS Y SETTERS*/
	
 
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
 
	 
	public VoCliente getCliente() {
		return cliente;
	}
	
	public void setCliente(VoCliente cliente) {
		this.cliente = cliente;
	}
	
	public long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
 
	public List<VoItemVenta> getItemsVenta() {
		return itemsVenta;
	}
	
	public void setItemsVenta(List<VoItemVenta> itemsVenta) {
		this.itemsVenta = itemsVenta;
	}

 
	public VoPortal getPortal() {
		return portal;
	}
	
	public void setPortal(VoPortal portal) {
		this.portal = portal;
	}
	
 
	public VoOrdenDespacho getOrdenDespacho() {
		return ordenDespacho;
	}
	
	public void setOrdenDespacho(VoOrdenDespacho ordenDespacho) {
		this.ordenDespacho = ordenDespacho;
	}
	
}