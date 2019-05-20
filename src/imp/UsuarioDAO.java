 package imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import modelo.Usuario;

public class UsuarioDAO {

	//@Override
	public void insert(Usuario usuario){
		Usuario us = new Usuario();
		us.setUserName("user");
		us.setPassword("password");
		us.setNombre("martin");
		us.setApellido("sarachaga");
		us.setDomicilio("69");
		us.setEmail("correo");
		us.setEmpresa_organizacion("empresa");
		us.setPersonaContacto("personaContacto");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bancoAlimentario");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		em.persist(us); 
	}
}
