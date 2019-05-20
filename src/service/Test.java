package service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Usuario;

public class Test {
	/*
	// Create an EntityManagerFactory when you start the application
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("JEETut3");
    
    public static void main(String[] args) {
    	Usuario us = new Usuario();
		us.setUserName("user");
		us.setPassword("password");
		us.setNombre("martin");
		us.setApellido("sarachaga");
		us.setDomicilio("69");
		us.setEmail("correo");
		us.setEmpresa_organizacion("empresa");
		us.setPersonaContacto("personaContacto");
    }
    public static void addCustomer(int id, String fname, String lname) {
        // The EntityManager class allows operations such as create, read, update, delete
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        // Used to issue transactions on the EntityManager
        EntityTransaction et = null;
 
        try {
            // Get transaction and start
            et = em.getTransaction();
            et.begin();
 
            // Create and set values for new customer
            Customer cust = new Customer();
            cust.setID(id);
            cust.setFName(fname);
            cust.setLName(lname);
 
            // Save the customer object
            em.persist(cust);
            et.commit();
        } catch (Exception ex) {
            // If there is an exception rollback changes
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            // Close EntityManager
            em.close();
        }
    }
    
*/
}
