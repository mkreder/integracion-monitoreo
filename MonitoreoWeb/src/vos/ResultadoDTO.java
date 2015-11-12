package vos;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "resultado")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResultadoDTO {

	public ResultadoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ResultadoDTO(String estado, String mensaje) {
		this.estado = estado;
		this.mensaje = mensaje;
	}
	
	@XmlElement
	private String estado;
	@XmlElement
	private String mensaje;
	
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public boolean isOK() {
		return this.getEstado().equalsIgnoreCase("OK");
	}

}
