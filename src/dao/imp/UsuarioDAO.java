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
	

	public Class<Usuario> getPersistentClass() {
		return  Usuario.class;
	}
}
