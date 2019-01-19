package org.Sokoba.tpjavaee.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.Sokoba.tpjavaee.model.Maire;

@Stateless
public class MaireEJB {
	
	@PersistenceContext(unitName="tp-rest")
	private EntityManager em;
	
	public Maire retrieveMaire(long id) {
		Maire maire = new Maire();		
		maire = em.find(maire.getClass(), id);
		return maire;
	}
	
	public void deleteMaire(long id) {
		Maire maire = new Maire();	
		maire = em.find(maire.getClass(), id);
		em.remove(maire);
	}
	
	public long createMaire(String nom, String prenom) {
		Maire maire = new Maire();
		maire.setPrenom(prenom);
		maire.setNom(nom);
		em.persist(maire);
		return maire.getId();
	}
	
	
	
}
