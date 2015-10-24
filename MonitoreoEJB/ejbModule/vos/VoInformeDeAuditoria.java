package vos;

import java.io.Serializable;
import java.util.Date;
 

 
public class VoInformeDeAuditoria {
	/**
	 * 
	 */
	
	private String descripcion;
	private int fechaYHora;
	private String modulo;
	/* GETTERS Y SETTERS */
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getFechaYHora() {
		return fechaYHora;
	}
	
	public void setFechaYHora(int fechaYHora) {
		this.fechaYHora = fechaYHora;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
}