package org.Sokoba.tpjavaee.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.Sokoba.tpjavaee.ejb.MaireEJB;

@Path("maire")
public class MaireRS {

	@EJB
	private MaireEJB maireEJB = new  MaireEJB();


	/*@GET @Path("{id}")
	public Maire getMaire(@PathParam("id") long id) {
		Maire maire = new (id, "Paris");
		return commune; 
	}*/
	
	@POST @Path("create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response create(@FormParam("nom") String nom,@FormParam("prenom") String prenom ){
		long id = maireEJB.createMaire(nom,prenom);		
		return Response.ok()
				.entity("commune créée avec l'id"+id)
				.build();
	}
	

}
