package org.Sokoba.tpjavaee.rest;

import javax.ejb.EJB;
import javax.ws.rs.Path;

import org.Sokoba.tpjavaee.ejb.MaireEJB;

// @Path("maire")
public class MaireRS {

	@EJB
	private MaireEJB maireEJB = new  MaireEJB();


	/*@GET @Path("{id}")
	public Maire getMaire(@PathParam("id") long id) {
		Maire maire = new (id, "Paris");
		return commune; 
	}*/
}
