package vos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

 

 
public class VoVenta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 
	private String dni;
	private Integer codigoVenta;
	private Date fechaHoraVenta;
	private String coordenadasUsuario;
	private Float montoTotal;
	private String codigoPortal;
	private String estado;
	private ArrayList<VoItemVenta> collectionItems;

	public VoVenta() {
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public Date getFechaHoraVenta() {
		return fechaHoraVenta;
	}

	public void setFechaHoraVenta(Date fechaHoraVenta) {
		this.fechaHoraVenta = fechaHoraVenta;
	}

	public String getCoordenadasUsuario() {
		return coordenadasUsuario;
	}

	public void setCoordenadasUsuario(String coordenadasUsuario) {
		this.coordenadasUsuario = coordenadasUsuario;
	}

	public Float getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Float montoTotal) {
		this.montoTotal = montoTotal;
	}

	public String getCodigoPortal() {
		return codigoPortal;
	}

	public void setCodigoPortal(String codigoPortal) {
		this.codigoPortal = codigoPortal;
	}

	public ArrayList<VoItemVenta> getCollectionItems() {
		return collectionItems;
	}

	public void setCollectionItems(ArrayList<VoItemVenta> collectionItems) {
		this.collectionItems = collectionItems;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}

}