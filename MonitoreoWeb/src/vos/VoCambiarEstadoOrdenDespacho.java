package vos;

import java.io.Serializable;

public class VoCambiarEstadoOrdenDespacho implements Serializable{

	private static final long serialVersionUID = 1L;

	int idOrdenDeDespacho;
	
	public int getIdOrdenDeDespacho() {
		return idOrdenDeDespacho;
	}
	
	public void setIdOrdenDeDespacho(int idOrdenDeDespacho) {
		this.idOrdenDeDespacho = idOrdenDeDespacho;
	}
	
}
