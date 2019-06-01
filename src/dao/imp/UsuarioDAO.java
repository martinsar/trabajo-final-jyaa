package dao.imp;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;

import dao.EMF;
import dao.IUsuarioDAO;
import modelo.Usuario;

public class UsuarioDAO extends GenericDAOHibernateJPA<Usuario> implements IUsuarioDAO {
	
/*
	@SuppressWarnings("unchecked")
	public Usuario recuperar(Serializable id) {

		EntityManager em = EMF.getInstance().getEm();
		Usuario user = em.find(Usuario.class, id);
	        if (user == null) {
	            throw new EntityNotFoundException("Can't find Artist for ID "
	                + id);
	        }
	        return user;

	}
	
	public boolean existe(Serializable id) {
		
		
		Usuario entity= this.recuperar(id);
		
		
		return entity != null;
	}

*/
	public Class<Usuario> getPersistentClass() {
		return  Usuario.class;
	}
}
