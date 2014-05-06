package com.fisi.modelo;

import java.io.Serializable;

public class Institucion implements Serializable{
	private int id;
	private String nombre;
	private String ugel;
	private String distrito;
	
	public Institucion() {
		super();
	}
	
	public Institucion(int id, String nombre, String ugel, String distrito) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ugel = ugel;
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

	public String getUgel() {
		return ugel;
	}

	public void setUgel(String ugel) {
		this.ugel = ugel;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	


}
