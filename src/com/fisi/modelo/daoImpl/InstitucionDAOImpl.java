package com.fisi.modelo.daoImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.fisi.modelo.PMF;
import com.fisi.modelo.dao.InstitucionDAO;
import com.fisi.modelo.entidades.Institucion;


public class InstitucionDAOImpl implements InstitucionDAO{

	@Override
	public ArrayList<Institucion> buscarInstituciones() {
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Query query = pm.newQuery(Institucion.class);
		// query.setRange(0, FETCH_MAX_RESULTS);
		return(new ArrayList<Institucion>((List<Institucion>)query.execute()));
	}
	@Override
	public void insertarTodoInstitucion(ArrayList<Institucion> instituciones) {

		final PersistenceManager pm = PMF.get().getPersistenceManager();
		Collection<Institucion> institucionesCol=(Collection<Institucion>)instituciones;
		pm.makePersistentAll(instituciones);
		System.out.println("Termino de carga de Instituciones");
	}
}
