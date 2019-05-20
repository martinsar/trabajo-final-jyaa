package service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modelo.Comentario;
import modelo.Donacion;
import modelo.Producto;
import modelo.Recorrido;
import modelo.Retiro;
import modelo.Rol;
import modelo.Student;
import modelo.Usuario;
public class Main {
	  // Create an EntityManagerFactory when you start the application.
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("bancoAlimentario");

    public static void main(String[] args) {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
          	Usuario us = new Usuario();
          	List<Usuario> listUsuarios = new ArrayList<Usuario>();
          	Usuario us2 = new Usuario();
          	Usuario us3 = new Usuario();
          	listUsuarios.add(us2);
          	listUsuarios.add(us2);
          	listUsuarios.add(us3);
          //	us.setUsuarios(listUsuarios);
    		List<String> telefonos = new ArrayList<String>();
    		List<String> horariosContanto = new ArrayList<String>();
    		
    		telefonos.add("4510856");
    		telefonos.add("4529043");
    		
    		horariosContanto.add("14:00");
    		horariosContanto.add("17:00");
    		
    		us.setHorariosContacto(horariosContanto);
    		us.setTelelefono(telefonos);
          	us.setUserName("user");
    		us.setPassword("password");
    		us.setNombre("martin");
    		us.setApellido("sarachaga");
    		us.setDomicilio("69");
    		us.setEmail("correo");
    		us.setEmpresa_organizacion("empresa");
    		us.setPersonaContacto("personaContacto");
    		
    		Comentario com = new Comentario();
    		Date fecha = new Date();
    		com.setTextoComentario("textoComentario");
    		com.setUsuario(us);
    		com.setDia(fecha);
    		
    		Comentario com2 = new Comentario();
    		Date fecha2 = new Date();
    		com2.setDia(fecha2);
    		com2.setTextoComentario("textoComentario2");
    		com2.setUsuario(us);
    		
    		List<Comentario> lista = new ArrayList<Comentario>();
    		lista.add(com);
    		lista.add(com2);
    		//us.setComentarios(lista);
    		
    		Rol rol = new Rol();
    		rol.setNombreRol("nombre");
    		us.setRol(rol);
    	
    		
    		List<Recorrido> listRecorrido = new ArrayList<Recorrido>();
    		
    		Recorrido recorrido1 = new Recorrido();
    		/*
    		List<Retiro> listRetiro = new ArrayList<Retiro>();
    		
    		Retiro retiroA = new Retiro();
    		Donacion donacionA = new Donacion();
    		donacionA.setDireccionRetiro("69 966");
    		donacionA.setFechaDisponibilidad(fecha2);
    		retiroA.setDonacion(donacionA);
    		retiroA.setFechaHoraRetiro(fecha);
    		retiroA.setRecorrido(recorrido1);
    	
    		Retiro retiroB = new Retiro();
    		Donacion donacionB = new Donacion();
    		donacionB.setDireccionRetiro("69 966");
    		donacionB.setFechaDisponibilidad(fecha2);
    		retiroB.setDonacion(donacionB);
    		retiroB.setFechaHoraRetiro(fecha);
    		retiroB.setRecorrido(recorrido1);
    	
    		listRetiro.add(retiroA);
    		listRetiro.add(retiroB);
    		
    		recorrido1.setRetiros(listRetiro);
    		*/
    		recorrido1.setFechaRetiro(fecha);
    		recorrido1.setUsuario(us);
    		
    		
    		Recorrido recorrido2 = new Recorrido();
    		recorrido2.setFechaRetiro(fecha2);
    		recorrido2.setUsuario(us);
    		recorrido2.setComentarios(lista);
    		
    		listRecorrido.add(recorrido1);
    		listRecorrido.add(recorrido2);
    		
    		
    		Comentario comentario = new Comentario();
    		comentario.setTextoComentario("textoComentario");
    		comentario.setDia(fecha2);
    		comentario.setUsuario(us);
    		comentario.setRecorrido(recorrido1);
    		
    		
    		Comentario comentario2 = new Comentario();
    		comentario2.setTextoComentario("textoComentari2");
    		comentario2.setDia(fecha);
    		comentario2.setUsuario(us);
    		
    		List<Comentario> listComentario = new ArrayList<Comentario>();
    		listComentario.add(comentario);
    		listComentario.add(comentario2);
    		
    		Retiro retiro = new Retiro();
    		Donacion donacion = new Donacion();
    		donacion.setDireccionRetiro("69 966");
    		donacion.setFechaDisponibilidad(fecha2);
    		donacion.setRecorrido(recorrido2);
    		donacion.setRetiro(retiro);
    		
    		retiro.setDonacion(donacion);
    		retiro.setFechaHoraRetiro(fecha);
    		retiro.setRecorrido(recorrido1);
    		
    		
    		us.setRecorridos(listRecorrido);
    		
    		Producto producto = new Producto();
    		producto.setCantidadUnidades(2);
    		producto.setCapacidadPorEnvase(23.2);
    		producto.setDonacion(donacion);
    		producto.setFechaVencimiento(fecha2);
    		producto.setMarca("marca");
    		producto.setPeso(89.2);
    		producto.setTipo("tipo");
    		producto.setDonacion(donacion);
    	
    
    //	us.setComentarios(listComentario);
    	    // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Create a new Student object
         

            // Save the student object
            manager.persist(producto);
            manager.persist(donacion);
            manager.persist(retiro);
            manager.persist(comentario);
            manager.persist(comentario2);
            manager.persist(rol);  
        	manager.persist(us);
            
          // 
            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }

    	
    }
    

}
/*

    public static void main(String[] args) {

        // Create two Students
        create(1, "Alice", 22); // Alice will get an id 1
        create(2, "Bob", 20); // Bob will get an id 2
        create(3, "Charlie", 25); // Charlie will get an id 3

        // Update the age of Bob using the id
        upate(2, "Bob", 25);

        // Delete the Alice from database
        delete(1);

        // Print all the Students
        @SuppressWarnings("rawtypes")
		List students = readAll();
        if (students != null) {
       //     for (Student stu : students) {
        //        System.out.println(stu);
           // }
        }

        // NEVER FORGET TO CLOSE THE ENTITY_MANAGER_FACTORY
        ENTITY_MANAGER_FACTORY.close();
    }

    //
    // Create a new Student.
    // 
    // @param name
    // @param age
    //
    public static void create(int id, String name, int age) {
        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
          	Usuario us = new Usuario();
    		us.setUserName("user");
    		us.setPassword("password");
    		us.setNombre("martin");
    		us.setApellido("sarachaga");
    		us.setDomicilio("69");
    		us.setEmail("correo");
    		us.setEmpresa_organizacion("empresa");
    		us.setPersonaContacto("personaContacto");
    		
    		Comentario com = new Comentario();
    		Date fecha = new Date();
    		com.setTextoComentario("textoComentario");
    		com.setUsuario(us);
    		com.setDia(fecha);
    		
    		Comentario com2 = new Comentario();
    		Date fecha2 = new Date();
    		com2.setDia(fecha2);
    		com2.setTextoComentario("textoComentario2");
    		com2.setUsuario(us);
    		
    		List<Comentario> lista = new ArrayList<Comentario>();
    		lista.add(com);
    		lista.add(com2);
    		//us.setComentarios(lista);
    		
    		Rol rol = new Rol();
    		rol.setNombreRol("nombre");
    		//us.setRol(rol);
    		
    	    // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Create a new Student object
            Student stu = new Student();
            stu.setId(id);
            stu.setName(name);
            stu.setAge(age);

            // Save the student object
        	manager.persist(us);
            
            manager.persist(stu);
          // 
            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    }

    //
     // Read all the Students.
    //
    // @return a List of Students
     //
    public static List readAll() {

        List students = null;

        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get a List of Students
          //  students = manager.createQuery("SELECT s FROM Student s",
          //          Student.class).getResultList();

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
        return students;
    }

    //
    // Delete the existing Student.
    // 
    // @param id
     //
    public static void delete(int id) {
        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get the Student object
            Student stu = manager.find(Student.class, id);

            // Delete the student
            manager.remove(stu);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    }

    //
     // Update the existing Student.
     //
     // @param id
     // @param name
     // @param age
     //
    public static void upate(int id, String name, int age) {
        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get the Student object
            Student stu = manager.find(Student.class, id);

            // Change the values
            stu.setName(name);
            stu.setAge(age);

            // Update the student
            manager.persist(stu);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    }
    
    
}

*/