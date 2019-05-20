package dao;
import java.util.List;

import modelo.Usuario;
public  interface IUsuarioDAO {
	public List<Usuario> getUsuarios();
	public void insert(Usuario usuario);
	

}
