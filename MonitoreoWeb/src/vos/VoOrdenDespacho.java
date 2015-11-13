package vos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import dominio.Despacho;
import dominio.Venta;

 
 
 
public class VoOrdenDespacho implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private boolean estaEnviada;
	private Date fecha;
	private Despacho despacho;
	private Venta venta;
	
	/*GETTERS Y SETTERS*/
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public void setEstaEnviada(boolean estaEnviada) {
		this.estaEnviada = estaEnviada;
	}
	
	public boolean getEstaEnviada(){
		return estaEnviada;
	}

	@ManyToOne
	@JoinColumn(name="id_Despacho")
	public Despacho getDespacho() {
		return despacho;
	}
	
	public void setDespacho(Despacho despacho) {
		this.despacho = despacho;
	}
	
	@OneToOne(mappedBy = "ordenDespacho")
	public Venta getVenta() {
		return venta;
	}
	
	public void setVenta(Venta venta) {
		this.venta = venta;
	}	
}