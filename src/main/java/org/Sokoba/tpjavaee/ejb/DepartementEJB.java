package org.Sokoba.tpjavaee.ejb;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.Sokoba.tpjavaee.model.Commune;
import org.Sokoba.tpjavaee.model.Departement;

@Stateless
public class DepartementEJB {

	
	@PersistenceContext(unitName="tp-rest")
	private EntityManager em;
	
	
	public Departement retrieveDepartement(long id) {
		Departement departement = new Departement();		
		departement = em.find(departement.getClass(), id);
		return departement;
	}
	
	
	
	

}
