package org.Sokoba.tpjavaee.ejb;

import javax.ejb.Stateless;
import javax.persistence.*;
import org.Sokoba.tpjavaee.model.Commune;

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

	public void deleteCommune(long id) {
		Commune commune = new Commune();	
		commune = em.find(commune.getClass(), id);
		em.remove(commune);
	}


}
