package org.Sokoba.tpjavaee.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MaireEJB {
	
	@PersistenceContext(unitName="tp-rest")
	private EntityManager em;
	
	
	
	
	
}
