package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
	
    private static EMF instanciaUnica;

	
	private static final EntityManagerFactory em =Persistence.createEntityManagerFactory("bancoAlimentario");
	
	private EntityManager entityManager;
	
	public EntityManager getEm() {
		if(entityManager == null) entityManager=em.createEntityManager();
		return entityManager;
	}
	
	private EMF() {}
	 
	public static EMF getInstance() {
	    if (instanciaUnica == null) {
	       instanciaUnica = new EMF();
	    }
	     
	    return instanciaUnica;
	}
	
	public static EntityManagerFactory getEMF() {
		return em;
	}

}
