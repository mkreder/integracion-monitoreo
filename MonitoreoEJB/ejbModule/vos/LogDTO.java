package vos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
 

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "log")
@XmlAccessorType(XmlAccessType.FIELD)
public class LogDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	private String fecha;
	@XmlElement
	private String idModulo;
	@XmlElement
	private String mensaje;
	
	public LogDTO() {
		super();
	}
	public LogDTO(String mensaje) {
		super();
		this.mensaje = mensaje;		 
		this.fecha = this.getFechaActual();
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(String idModulo) {
		this.idModulo = idModulo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	private String getFechaActual (){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
		return format.format(fecha);		
	}
	
	

}