package com.fisi.controlador;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="navegarMB")
@SessionScoped
public class NavegarMB implements Serializable{
	
	public NavegarMB(){
		super();
	}

	private static final long serialVersionUID = 1L;
	
	public String entrar(){
		return "consult"; // Pagina a Redireccionar
	}
}
