package org.Sokoba.tpjavaee.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.Sokoba.tpjavaee.model.Commune;
import org.Sokoba.tpjavaee.model.Maire;

@Stateless
public class CommuneEJB {

	@PersistenceContext(unitName="tp-rest")
	private EntityManager em;


	public long createCommune(String name) {
		Commune commune = new Commune();
		commune.setNom(name);
		em.persist(commune);
		return commune.getId();
	}


	public Commune retrieveCommune(long id) {
		Commune commune = new Commune();		
		commune = em.find(commune.getClass(), id);
		return commune;
	}
	
	public void updateCommune(long id,String nouveauNom,String nouveauCodePostal) {
		Commune commune = new Commune();		
		commune = em.find(commune.getClass(), id);
		commune.setNom(nouveauNom);
		commune.setCodePostal(nouveauCodePostal);
		
	}

	public void deleteCommune(long id) {
		Commune commune = new Commune();	
		commune = em.find(commune.getClass(), id);
		em.remove(commune);
	}
	
	public Maire linkCommuneToMaire(long maireId,long communeId) {
		Commune commune = new Commune();
		Maire maire = new Maire();
		commune = em.find(commune.getClass(), communeId);
		maire = em.find(maire.getClass(), maireId);
		maire.setCommune(commune);
		return maire;
		
	}
	


}
