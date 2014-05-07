package com.fisi.modelo;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public class PMF {
	private static final PersistenceManagerFactory pmfInstancia =
			JDOHelper.getPersistenceManagerFactory("transactions-optional");
	public PMF() {
		// TODO Auto-generated constructor stub
	}
   public static PersistenceManagerFactory get(){
	   return pmfInstancia;
   }
}
