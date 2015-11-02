package vos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dominio.Cliente;

 

 
public class VoVenta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 
	private Cliente cliente;
	private Integer codigoVenta;
	private Date fecha;
	private String estado;
	private ArrayList<VoItemVenta> collectionItems;

	public VoVenta() {
	}



	public int getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fechaHoraVenta) {
		this.fecha = fechaHoraVenta;
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