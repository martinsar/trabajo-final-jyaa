package dao.imp;

import java.util.List;

import dao.IUsuarioDAO;
import modelo.Usuario;

public class UsuarioDAO extends GenericDAOHibernateJPA<Usuario> implements IUsuarioDAO {

	@Override
	public List<Usuario> getUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

}
