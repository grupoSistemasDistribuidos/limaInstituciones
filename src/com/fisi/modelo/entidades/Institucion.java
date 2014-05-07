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
    @Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private int id;
	@Persistent
	private String nombre;
	@Persistent
	private String ugel;
	@Persistent
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
