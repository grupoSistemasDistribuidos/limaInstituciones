package com.fisi.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.fisi.modelo.Institucion;
@ManagedBean(name="consultarInstitucionMB")
@ApplicationScoped
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
		//no funciono el ejemplo u.u
		Institucion ejemplo=new Institucion(1, "guadalupe", "ugel 1","San Juan de Lurigancho");
		instituciones.add(ejemplo);

	}
	public int getOpcionBusqueda() {
		return opcionBusqueda;
	}
	public void setOpcionBusqueda(int opcionBusqueda) {
		this.opcionBusqueda = opcionBusqueda;
	}
	public ArrayList<Institucion> getInstituciones() {
		return instituciones;
	}
	public void setInstituciones(ArrayList<Institucion> instituciones) {
		this.instituciones = instituciones;
	}
	
}
