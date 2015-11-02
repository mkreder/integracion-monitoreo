package vos;


import java.io.Serializable;

 

 
public class VoCliente implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private	long dni;
	private String coordenada;//Por ahora las manejamos como STRING hay que ver q hacen los otros grupos
 
 

	/*GETTERS Y SETTERS*/
	
 
		
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