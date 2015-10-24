package dominio;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idCliente;
	private String coordenada;//Por ahora las manejamos como STRING hay que ver q hacen los otros grupos
	private long dni;
	private String nombre;
	private String apelido;

	/*GETTERS Y SETTERS*/
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApelido() {
		return apelido;
	}
	
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
		
	public long getDni() {
		return dni;
	}
	
	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getCoordenada() {
		return coordenada;
	}
	
	public void setCoordenada(String coordenada) {
		this.coordenada = coordenada;
	}
	
}