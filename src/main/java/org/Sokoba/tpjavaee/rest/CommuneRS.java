package org.Sokoba.tpjavaee.rest;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.Sokoba.tpjavaee.ejb.CommuneEJB;
import org.Sokoba.tpjavaee.model.Commune;
import org.Sokoba.tpjavaee.model.Maire;
import org.Sokoba.tpjavaee.rest.annotations.LINK;

@Path("commune")
public class CommuneRS {

	@EJB
	private CommuneEJB communeEJB = new  CommuneEJB();


	//CRUD OPERATIONS


	//RETRIEVE

	@GET @Path("{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Commune getCommune(@PathParam("id") long id) {
		Commune commune = communeEJB.retrieveCommune(id);
		return commune; 
	}
	
	//REMOVE

	@GET @Path("remove/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public void removeCommune(@PathParam("id") long id) {
		communeEJB.deleteCommune(id);		
	}



	//CREATE

	@POST @Path("create")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response create(@FormParam("name") String nom){
		long id = communeEJB.createCommune(nom);		
		return Response.ok()
				.entity("commune créée avec l'id"+id)
				.build();
	}
	
	//UPDATE
	@POST @Path("update")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response update(@FormParam("id") String id, @FormParam("nouveauNom") String nouveauNom, @FormParam("nouveauCodePostal") String nouveauCodePostal){
		communeEJB.updateCommune(Long.parseLong(id), nouveauNom, nouveauCodePostal);		
		return Response.ok()
				.entity("mise a jour ok")
				.build();
	}


	
	//LIER UNE COMMUNE A UN MAIRE
	@LINK 
	@Path("{idCommune}/maire/{idMaire}")	
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response linkMaireToCommune(@PathParam("idCommune") long idCommune, @PathParam("idMaire") long idMaire) {
		Maire updatedMaire = communeEJB.linkCommuneToMaire(idMaire,idCommune);
		return Response.ok()
				.entity(updatedMaire)
				.build(); 
	}





}





