package dao.imp;

import java.io.Serializable;
import javax.persistence.*;
import javax.transaction.Transaction;

import dao.EMF;
import dao.GenericDAO;
import modelo.Usuario;

public class GenericDAOHibernateJPA<T> implements GenericDAO<T>{
	
	/*EntityManager entityManager;

	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}*/
	
	protected Class<T> persistentClass;
	
	public T persistir(T entity) {
		// TODO Auto-generated method stub
		EntityManager em = EMF.getInstance().getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(entity);
		tx.commit();
		return entity;
	}
	
	

	public T actualizar(T entity) {
		// TODO Auto-generated method stub
		EMF.getEMF().createEntityManager().merge(entity);
		return entity;
	}

	
	
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


	public boolean existe(Serializable id) {
		
			
		T entity= this.recuperar(id);
		
		
		return entity != null;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Class<T> getPersistentClass() {
		return (Class<T>) persistentClass;
	}
	
	@SuppressWarnings("unchecked")
	public T recuperar(Serializable id) {
		
		
		System.out.println("this.getClass() " + this.getClass().getClassLoader());
		System.out.println("this.getClass() " + this.getClass().getName());
	
		System.out.println("this.getPersistentClass()" + this.getPersistentClass());
	
		
		EntityManager em = EMF.getInstance().getEm();
		T entity = (T) em.find((Class<T>) this.getPersistentClass(), id);
	        if (entity == null) {
	            throw new EntityNotFoundException("Can't find Artist for ID "
	                + id);
	        }
	        return entity;

	}

	

	public T persistirLibre(T entity) {
		// TODO Auto-generated method stub
		return null;
	}


}
