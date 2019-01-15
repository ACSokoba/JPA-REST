package org.Sokoba.tpjavaee.rest;

import javax.ejb.EJB;

import org.Sokoba.tpjavaee.ejb.MaireEJB;

public class DepartementRS {
	@EJB
	private MaireEJB maireEJB = new  MaireEJB();
	
}
