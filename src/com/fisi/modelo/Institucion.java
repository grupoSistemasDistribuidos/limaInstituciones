package com.fisi.modelo;

import java.io.Serializable;

public class Institucion implements Serializable{
	private int id;
	private String nombre;
	private String ciudad;
	private String provincia;
	private String distrito;
	
	public Institucion() {
		super();
	}
	
	public Institucion(int id, String nombre, String ciudad, String provincia,
			String distrito) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.distrito = distrito;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	
}
