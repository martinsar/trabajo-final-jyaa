package dao.imp;

import java.io.Serializable;
import javax.persistence.*;
import javax.transaction.Transaction;

import dao.EMF;
import dao.GenericDAO;

public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {
	
	/*EntityManager entityManager;

	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}*/
	
	protected Class<T> persistentClass;
	
	@Override
	public T persistir(T entity) {
		// TODO Auto-generated method stub
		EntityManager em = EMF.getInstance().getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(entity);
		tx.commit();
		return entity;
	}
	
	

	@Override
	public T actualizar(T entity) {
		// TODO Auto-generated method stub
		EMF.getEMF().createEntityManager().merge(entity);
		return entity;
	}

	
	
	@Override
	public void borrar(T entity) {
		try {
			EntityManager em = EMF.getInstance().getEm();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.remove(entity);
			tx.commit();
			
		} catch (RuntimeException e) {
			throw e; // escribir en un log o mostrar un mensaje
		}

	}


	@Override
	public boolean existe(Serializable id) {
		
			
		T entity= this.recuperar(id);
		
		
		return entity != null;
	}
	
	@SuppressWarnings("unchecked")
	private T getPersistentClass() {
		return (T) persistentClass;
	}
	
	@Override
	public T recuperar(Serializable id) {
		@SuppressWarnings("unchecked")
		EntityManager em = EMF.getInstance().getEm();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		T entity = em.find((Class<T>) this.getPersistentClass(), id);
		
		tx.commit();
		return entity;

	}

	

	@Override
	public T persistirLibre(T entity) {
		// TODO Auto-generated method stub
		return null;
	}


}
