package com.fisi.managedBean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.fisi.modelo.Institucion;
@ManagedBean(name="consultarInstitucionMB")
@SessionScoped
public class ConsultarInstitucionMB implements Serializable{
	private int opcionBusqueda;
	private ArrayList<Institucion> instituciones;
	private static final long serialVersionUID = 6586451817677535594L;
	public ConsultarInstitucionMB(){
		init();
	}
	private void init() {
		opcionBusqueda=1;
		instituciones=new ArrayList<Institucion>();
		Institucion ejemplo=new Institucion(1, "Von Newman", "Lima", "Lima","San Juan de Lurigancho");
		instituciones.add(ejemplo);
	}
	public int getOpcionBusqueda() {
		return opcionBusqueda;
	}
	public void setOpcionBusqueda(int opcionBusqueda) {
		this.opcionBusqueda = opcionBusqueda;
	}
	
}
