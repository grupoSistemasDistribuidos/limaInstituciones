package com.fisi.modelo.entidades;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Institucion implements Serializable{
	private static final long serialVersionUID = 3896230783384250347L;
	@PrimaryKey
	//@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private String nombre;
	@Persistent
	private String ugel;
	@Persistent
	private String distrito;
	@Persistent
	private String sector;
	@Persistent
	private String direccion;
	
	public Institucion() {
		super();
	}
	
	public Institucion(Long id, String nombre, String ugel, String distrito) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ugel = ugel;
		this.distrito = distrito;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	


}
