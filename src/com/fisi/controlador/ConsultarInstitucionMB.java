package com.fisi.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sun.org.mozilla.javascript.internal.ast.ForInLoop;

import com.fisi.modelo.entidades.Institucion;

@ManagedBean(name = "consultarInstitucionMB")
//@ViewScoped
public class ConsultarInstitucionMB implements Serializable {
	private int opcionBusqueda;
	private String filtro="";
	private static final int nombre = 1;
	private static final int ugel = 2;
	private static final int distrito = 3;
	private ArrayList<Institucion> instituciones;
	private ArrayList<Institucion> institucionesFiltro;
	private static final long serialVersionUID = 6586451817677535594L;

	public ConsultarInstitucionMB() {
		init();
	}

	private void init() {
		opcionBusqueda = 1;
		instituciones = new ArrayList<Institucion>();
		institucionesFiltro = new ArrayList<Institucion>();
		// no funciono el ejemplo u.u
		Institucion ejemplo = new Institucion(1, "guadalupe", "ugel 1",
				"San Juan de Lurigancho");
		Institucion ejemplo2 = new Institucion(2, "santa fe", "ugel 2",
				"San Martin de Porres");
		Institucion ejemplo3 = new Institucion(3, "priale", "ugel 3",
				"San Juan de Lurigancho");
		instituciones.add(ejemplo);
		instituciones.add(ejemplo2);
		instituciones.add(ejemplo3);
		copiarTodo(instituciones);
	}

	private void copiarTodo(ArrayList<Institucion> listaInsti) {
		institucionesFiltro.clear();
		for (Institucion institucion : listaInsti)
			institucionesFiltro.add(institucion);
	}

	public int getOpcionBusqueda() {
		return opcionBusqueda;
	}

	public void setOpcionBusqueda(int opcionBusqueda) {
		this.opcionBusqueda = opcionBusqueda;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public void buscar() {
		System.out.println("Hola");
		if (getFiltro() == null)
			copiarTodo(instituciones);
		else if(getFiltro()=="") 
			copiarTodo(instituciones);
		else{
			institucionesFiltro.clear();
			switch (opcionBusqueda) {
			case nombre:
				buscarPorNombre();
				break;
			case ugel:
				buscarPorUgel();
				break;
			case distrito:
				buscarPorDistrito();
				break;
			}
		}
	}

	private void buscarPorDistrito() {
		String distrito, filtro;
		for (Institucion institucion : instituciones) {
			distrito = institucion.getDistrito().toLowerCase();
			filtro = getFiltro().toLowerCase();
			if (distrito.contains(filtro))
				institucionesFiltro.add(institucion);
		}
	}

	private void buscarPorUgel() {
		String ugel, filtro;
		for (Institucion institucion : instituciones) {
			ugel = institucion.getUgel().toLowerCase();
			filtro = getFiltro().toLowerCase();
			if (ugel.contains(filtro))
				institucionesFiltro.add(institucion);
		}
	}

	private void buscarPorNombre() {
		String nombre, filtro;
		for (Institucion institucion : instituciones) {
			nombre = institucion.getNombre().toLowerCase();
			filtro = getFiltro().toLowerCase();
			if (nombre.contains(filtro))
				institucionesFiltro.add(institucion);
		}
	}

	public ArrayList<Institucion> getInstituciones() {
		return instituciones;
	}

	public void setInstituciones(ArrayList<Institucion> instituciones) {
		this.instituciones = instituciones;
	}

	public ArrayList<Institucion> getInstitucionesFiltro() {
		return institucionesFiltro;
	}

	public void setInstitucionesFiltro(
			ArrayList<Institucion> institucionesFiltro) {
		this.institucionesFiltro = institucionesFiltro;
	}

}
