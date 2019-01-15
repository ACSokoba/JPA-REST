package org.Sokoba.tpjavaee.rest;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.Sokoba.tpjavaee.ejb.CommuneEJB;
import org.Sokoba.tpjavaee.model.Commune;

@Path("commune")
public class CommuneRS {

	@EJB
	private CommuneEJB communeEJB = new  CommuneEJB();


	/*@GET @Path("{id}")
	public Commune getCommune(@PathParam("id") long id) {
		Commune commune = new Commune(id, "Paris");
		return commune; 
	}*/
	
	@POST @Path("retrieve")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    // @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response retrieve(@FormParam("id") long id){
		Commune commune = communeEJB.retrieveCommune(id);		
		return Response.ok()
				.entity(commune)
				.build();
	}

	@POST @Path("create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response create(@FormParam("name") String nom){
		long id = communeEJB.createCommune(nom);		
		return Response.ok()
				.entity("commune créée avec l'id"+id)
				.build();
	}





}





