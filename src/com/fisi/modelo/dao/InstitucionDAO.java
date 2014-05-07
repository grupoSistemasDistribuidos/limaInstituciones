package com.fisi.modelo.dao;

import java.util.ArrayList;

import com.fisi.modelo.entidades.Institucion;

public interface InstitucionDAO {
	public ArrayList<Institucion> buscarInstituciones();
	public void insertarTodoInstitucion(ArrayList<Institucion> instituciones);
}
