package vos;

import java.util.Date;

public class Criterio {

	private Categoria categoria;
	private float precio_asc;
	private float precio_desc;
	private Date fecha_asc;
	private Date fecha_desc;
	private int ranking;
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public float getPrecio_asc() {
		return precio_asc;
	}
	public void setPrecio_asc(float precio_asc) {
		this.precio_asc = precio_asc;
	}
	public float getPrecio_desc() {
		return precio_desc;
	}
	public void setPrecio_desc(float precio_desc) {
		this.precio_desc = precio_desc;
	}
	public Date getFecha_asc() {
		return fecha_asc;
	}
	public void setFecha_asc(Date fecha_asc) {
		this.fecha_asc = fecha_asc;
	}
	public Date getFecha_desc() {
		return fecha_desc;
	}
	public void setFecha_desc(Date fecha_desc) {
		this.fecha_desc = fecha_desc;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
}
