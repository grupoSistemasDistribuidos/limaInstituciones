package com.fisi.controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import sun.org.mozilla.javascript.internal.ast.ForInLoop;

import com.fisi.modelo.dao.InstitucionDAO;
import com.fisi.modelo.daoImpl.InstitucionDAOImpl;
import com.fisi.modelo.entidades.Institucion;

@ManagedBean(name = "consultarInstitucionMB")
//@ViewScoped
public class ConsultarInstitucionMB implements Serializable {
	private int opcionBusqueda;
	private int searchUgel;
	private int sUgel;
	private boolean busqNombre;
	private boolean busqUgel;
	private boolean busqDistrito;
	private String filtro="";
	private String filtro3="";
	private static final int nombre = 1;
	private static final int ugel = 2;
	private static final int distrito = 3;
	private ArrayList<Institucion> instituciones;
	private ArrayList<Institucion> institucionesFiltro;
	private static final long serialVersionUID = 6586451817677535594L;
	private InstitucionDAO institucionDAO= new InstitucionDAOImpl();
	private Institucion selectedInstitucion;
	
	public ConsultarInstitucionMB() {
		init();
	}

	private void init() {
		busqNombre = false;
		busqUgel = true;
		busqDistrito = true;
		opcionBusqueda = 1;
		instituciones = new ArrayList<Institucion>();
		institucionesFiltro = new ArrayList<Institucion>();
		/*cargarBaseDatosInstituciones();
		Institucion ejemplo = new Institucion(new Long(1), "guadalupe", "1",
				"San Juan de Lurigancho");
		Institucion ejemplo2 = new Institucion(new Long(2), "santa fe", "2",
				"San Martin de Porres");
		Institucion ejemplo3 = new Institucion(new Long(3), "priale", "3",
				"San Juan de Lurigancho");
		instituciones.add(ejemplo);
		instituciones.add(ejemplo2);
		instituciones.add(ejemplo3);*/
		institucionDAO.insertarTodoInstitucion(leerTxtInstituciones());
		instituciones.clear();
		instituciones=institucionDAO.buscarInstituciones();
		copiarTodo(instituciones);
	}

	private ArrayList<Institucion> leerTxtInstituciones() {
		ArrayList<Institucion> instituciones = new ArrayList<Institucion>();
		ServletContext servletContext=(ServletContext) FacesContext.getCurrentInstance ().getExternalContext().getContext();
		String web_infpath= servletContext.getRealPath("/resources/datos");
		//String web_infpath= servletContext.getRealPath(separator+"WEB-INF"+separator);
		try {
			FileReader lectura = new FileReader(web_infpath+ "/instituciones.txt");
			BufferedReader entrada = new BufferedReader(lectura);
			String linea = entrada.readLine();
			while (linea != null && linea.length() > 0) {
				StringTokenizer marca = new StringTokenizer(linea, ",");
				Institucion xInstitucion = new Institucion();
				xInstitucion.setId(Long.parseLong(marca.nextToken()));
				xInstitucion.setSector(marca.nextToken());
				xInstitucion.setUgel(marca.nextToken());
				xInstitucion.setNombre(marca.nextToken());
				xInstitucion.setDireccion(marca.nextToken());
				xInstitucion.setDistrito(marca.nextToken());
				instituciones.add(xInstitucion);
				linea = entrada.readLine();
			}
			entrada.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return instituciones;
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
		System.out.println("Búsqueda: "+opcionBusqueda);
		if (getFiltro() == null || getFiltro()=="")
			copiarTodo(instituciones);
		//else if(getFiltro()=="") 
		//	copiarTodo(instituciones);
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
	
	public void buscarUgel(){
		institucionesFiltro.clear();
		buscarPorUgel();
	}
	
	public void buscarDistrito(){
		buscarPorDistrito();
	}
	
	private void buscarPorDistrito() {
		institucionesFiltro.clear();
		String distrito, filtro;
		for (Institucion institucion : instituciones) {
			distrito = institucion.getDistrito().toLowerCase();
			filtro = getFiltro3().toLowerCase();			
			if (distrito.contains(filtro))
				institucionesFiltro.add(institucion);
		}
	}

	private void buscarPorUgel() {
		int ugel; 
		int filtro;
		for (Institucion institucion : instituciones) {
			ugel = Integer.parseInt(institucion.getUgel());			
			filtro = getsUgel();
			System.out.println("Compara: "+ugel+" - "+filtro);
			if (ugel == filtro)
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
	
	public void opcionActiva(){
		System.out.println("---> "+opcionBusqueda);
		switch(opcionBusqueda){
		case nombre:
			actualizar(false,true,true);
		case ugel:
			actualizar(true,false,true);
		case distrito:
			actualizar(true,true,false);
		}
	}
	
	private void actualizar(boolean c1, boolean c2, boolean c3){
		setBusqNombre(c1);
		setBusqUgel(c2);
		setBusqDistrito(c3);
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

	public int getSearchUgel() {
		return searchUgel;
	}

	public void setSearchUgel(int searchUgel) {
		this.searchUgel = searchUgel;
	}

	public boolean getBusqNombre() {
		System.out.println("bN-"+busqNombre);
		return busqNombre;
	}

	public void setBusqNombre(boolean busqNombre) {
		this.busqNombre = busqNombre;
	}

	public boolean getBusqUgel() {
		System.out.println("bU-"+busqUgel);
		return busqUgel;
	}

	public void setBusqUgel(boolean busqUgel) {
		this.busqUgel = busqUgel;
	}

	public boolean getBusqDistrito() {
		System.out.println("bD-"+busqDistrito);
		return busqDistrito;
	}

	public void setBusqDistrito(boolean busqDistrito) {
		this.busqDistrito = busqDistrito;
	}

	public String getFiltro3() {
		return filtro3;
	}

	public void setFiltro3(String filtro3) {
		this.filtro3 = filtro3;
	}

	public int getsUgel() {
		return sUgel;
	}

	public void setsUgel(int sUgel) {
		this.sUgel = sUgel;
	}

	public Institucion getSelectedInstitucion() {
		return selectedInstitucion;
	}

	public void setSelectedInstitucion(Institucion selectedInstitucion) {
		this.selectedInstitucion = selectedInstitucion;
	}

}
