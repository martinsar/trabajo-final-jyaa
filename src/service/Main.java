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

import dao.imp.ComentarioDAO;
import dao.imp.DonacionDAO;
import dao.imp.ProductoDAO;
import dao.imp.RecorridoDAO;
import dao.imp.RetiroDAO;
import dao.imp.RolDAO;
import dao.imp.UsuarioDAO;
import modelo.Comentario;
import modelo.Donacion;
import modelo.Producto;
import modelo.Recorrido;
import modelo.Retiro;
import modelo.Rol;
import modelo.Usuario;
public class Main {
	  // Create an EntityManagerFactory when you start the application.
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("bancoAlimentario");

    public static void main(String[] args) {
		/*
    	Rol rol = new Rol();
		RolDAO rdao= new RolDAO();
		rdao.persistir(rol);
*/
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
        	Rol rolDonante = agregarRol("rolDonante");
        	Rol rolAdmin = agregarRol("rolAdmin");
        	Rol rolBanco = agregarRol("rolBanco");
        	
        	
        	Usuario usuarioDonante= agregarUsuario(rolDonante);
        	Usuario usuarioBanco =  	agregarUsuarioBanco();
        	//Usuario usuarioBanco= agregarUsuario(rolBanco);
        	//Usuario usuarioAdmin= agregarUsuario(rolAdmin);
        	Usuario usuarioAdmin = agregarUsuarioAdmin();
        	Donacion donacion = agregarDonacion(usuarioDonante);
        	agregarDonacionAProducto(donacion) ;
        	
        	
        	
        	
        	Recorrido recorrido = agregarRecorrido( usuarioBanco);
      
        	
      
       // 	Usuario nuevoUsuarioDonante = agregarRecorridoAlUsuario(recorrido2,usuarioDonante);  lo agregue en una funcion
        //	System.out.println(nuevoUsuarioDonante);
     //   	donacion =agregarRetiroADonacion(donacion);
        	
           
        	
        	
          // 
            // Commit the transaction
        //    transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
          //      transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
       //     manager.close();
        }

    	
    }


    public static Rol agregarRol(String nombreRol) {
    	RolDAO rdao= new RolDAO();

    	Rol rol1 = new Rol();
    	rol1.setNombreRol(nombreRol);
    	System.out.println("Ingreso rol: "+"Nombre Rol: "+ rol1.getNombreRol()  +" Id: "+rol1.getId()); 
    	
    	return rdao.persistir(rol1);
    }
 
 public static Usuario agregarUsuario(Rol rolDonante) {
	 
	 UsuarioDAO userDAO = new UsuarioDAO();
	 	
		
		/* *************************************************************************************** */
	 List<String> telefonos = new ArrayList<String>();
	 telefonos.add("4515555");
	 telefonos.add("45156666");
	 telefonos.add("451553333");
	 List<String> horariosContacto = new ArrayList<String>();
		 
		// creo el usuario donante
	 Usuario usuarioDonante = new Usuario("usuarioDonante", "passwordDonante", "nombreDonante", "apellidoDonante", "domicilioDonante",
		               telefonos
		               , "emailDonante", "empresa_organizacionDonante", "personaContactoDonante", horariosContacto);
	 	

		System.out.println("----------------------------USUARIO DONANTE-----------------------------------------------");

		System.out.println("----USUARIO COMUN-----USER NAME: "+ usuarioDonante.getUserName()+ usuarioDonante.getPassword() + "APELLIDO: "+ usuarioDonante.getApellido() + "NOMBRE: "+usuarioDonante.getNombre() + "DOMICILIO: " + usuarioDonante.getDomicilio()+" EMAIL: "+ usuarioDonante.getEmail()+"EMPRESA/ORGANIZACION: " +usuarioDonante.getEmpresa_organizacion()+" PERSONA CONTACTO: "+ usuarioDonante.getPersonaContacto()+" Rol del usuario: "+ usuarioDonante.getRol()+  "lista de usuarios: "+ usuarioDonante.getUsuarios());

	 userDAO.persistir(usuarioDonante);
	 
	 usuarioDonante.setRol(rolDonante); 
	System.out.println("----------------------------AGRERO ROL AL USUARIO DONANTE-----------------------------------------------");

	System.out.println("----USUARIO COMUN-----USER NAME: "+ usuarioDonante.getUserName()+ usuarioDonante.getPassword() + "APELLIDO: "+ usuarioDonante.getApellido() + "NOMBRE: "+usuarioDonante.getNombre() + "DOMICILIO: " + usuarioDonante.getDomicilio()+" EMAIL: "+ usuarioDonante.getEmail()+"EMPRESA/ORGANIZACION: " +usuarioDonante.getEmpresa_organizacion()+" PERSONA CONTACTO: "+ usuarioDonante.getPersonaContacto()+" Rol del usuario: "+ usuarioDonante.getRol()+  "lista de usuarios: "+ usuarioDonante.getUsuarios());

	 return userDAO.actualizar(usuarioDonante);
     	 
 }
 
 public static Usuario agregarUsuarioAdmin() {
	 
	UsuarioDAO userDAO = new UsuarioDAO();
	RolDAO rdao= new RolDAO();
 	
	
	/* *************************************************************************************** */
 	List<String> telefono = new ArrayList<String>();
 	List<String> horariosContacto = new ArrayList<String>();
	 
	// creo el usuario admin
 	List<Usuario> usuarios = new ArrayList<Usuario>();
 	Usuario usuarioAdmin = new Usuario("usuarioAdmin", "passwordAdmin", "nombre0", "apellido0", "domicilio0",
	               telefono, "email0", "empresa_organizacion0", "personaContacto0", horariosContacto);
 	
 	 Rol rol1 = new Rol();
 	
 	 rol1.setNombreRol("admin");
 	rdao.persistir(rol1);
 	
 	/* *************************************************************************************** */
 	

    // creo usuarioBanco	    	
     Usuario usuarioAcrear = new Usuario("userComun", "password", "nombre", "apellido", "domicilio",
    			               telefono, "email", "empresa_organizacion", "personaContacto",horariosContacto);
     
    Rol rol2 = new Rol();
    rol1.setNombreRol("usuarioBanco"); 
 	rdao.persistir(rol2);
     
     /* *************************************************************************************** */ 
   
		
	
        
	System.out.println("----------------------------USUARIO COMUN-----------------------------------------------");

	System.out.println("----USUARIO COMUN-----USER NAME: "+ usuarioAcrear.getUserName()+ usuarioAcrear.getPassword() + "APELLIDO: "+ usuarioAcrear.getApellido() + "NOMBRE: "+usuarioAcrear.getNombre() + "DOMICILIO: " + usuarioAcrear.getDomicilio()+" EMAIL: "+ usuarioAcrear.getEmail()+"EMPRESA/ORGANIZACION: " +usuarioAcrear.getEmpresa_organizacion()+" PERSONA CONTACTO: "+ usuarioAcrear.getPersonaContacto()+ "Rol Usuario: "+ usuarioAdmin.getRol()+  "lista de usuarios: "+ usuarioAdmin.getUsuarios());
 	
    Usuario usuarioCreado= userDAO.persistir(usuarioAcrear);
    usuarios.add( usuarioCreado);    
    		
		
	
 	System.out.println("----------------------------USUARIO ADMINISTRADOR-----------------------------------------------");
	System.out.println("---USUARIO ADMIN-----USER NAME: "+ usuarioAdmin.getUserName()+ usuarioAdmin.getPassword() + "APELLIDO: "+ usuarioAdmin.getApellido() + "NOMBRE: "+usuarioAdmin.getNombre() + "DOMICILIO: " + usuarioAdmin.getDomicilio()+" EMAIL: "+ usuarioAdmin.getEmail()+"EMPRESA/ORGANIZACION: " +usuarioAdmin.getEmpresa_organizacion()+" PERSONA CONTACTO: "+ usuarioAdmin.getPersonaContacto()+ "Rol Usuario: "+ usuarioAdmin.getRol()+  "lista de usuarios: "+ usuarioAdmin.getUsuarios());
	 
	userDAO.persistir(usuarioAdmin);
	System.out.println("----------------------------LE AGREGO USUARIOS AL USUARIO ADMINISTRADOR-----------------------------------------------");
	System.out.println("---USUARIO ADMIN-----USER NAME: "+ usuarioAdmin.getUserName()+ usuarioAdmin.getPassword() + "APELLIDO: "+ usuarioAdmin.getApellido() + "NOMBRE: "+usuarioAdmin.getNombre() + "DOMICILIO: " + usuarioAdmin.getDomicilio()+" EMAIL: "+ usuarioAdmin.getEmail()+"EMPRESA/ORGANIZACION: " +usuarioAdmin.getEmpresa_organizacion()+" PERSONA CONTACTO: "+ usuarioAdmin.getPersonaContacto()+ "Rol Usuario: "+ usuarioAdmin.getRol()+  "lista de usuarios: "+ usuarioAdmin.getUsuarios());
	 
	
	usuarioAdmin.setUsuarios(usuarios);
	userDAO.actualizar(usuarioAdmin);
	usuarioAdmin.setRol(rol1); 
	System.out.println("----------------------------LE AGREGO EL ROL AL USUARIO ADMINISTRADOR-----------------------------------------------");
	System.out.println("---USUARIO ADMIN-----USER NAME: "+ usuarioAdmin.getUserName()+ usuarioAdmin.getPassword() + "APELLIDO: "+ usuarioAdmin.getApellido() + "NOMBRE: "+usuarioAdmin.getNombre() + "DOMICILIO: " + usuarioAdmin.getDomicilio()+" EMAIL: "+ usuarioAdmin.getEmail()+"EMPRESA/ORGANIZACION: " +usuarioAdmin.getEmpresa_organizacion()+" PERSONA CONTACTO: "+ usuarioAdmin.getPersonaContacto()+ "Rol Usuario: "+ usuarioAdmin.getRol()+  "lista de usuarios: "+ usuarioAdmin.getUsuarios());
	
	
	
	return userDAO.actualizar(usuarioAdmin);
	
	 
 }
 public static Usuario agregarUsuarioBanco() {
	 
		UsuarioDAO userDAO = new UsuarioDAO();
		RolDAO rdao= new RolDAO();
	 	
		
		/* *************************************************************************************** */
	 	List<String> telefono = new ArrayList<String>();
	 	List<String> horariosContacto = new ArrayList<String>();
		 
		// creo el usuario admin
	 	List<Usuario> usuarios = new ArrayList<Usuario>();
	 	Usuario usuarioBanco = new Usuario("usuarioBanco", "passwordBanco", "nombreBanco", "apellidoBanco", "domicilioBanco",
		               telefono, "emailBanco", "empresa_organizacionBanco", "personaContactoBanco", horariosContacto);
	 	
	 	 Rol rol1 = new Rol();
	 	rol1.setNombreRol("banco");
	 	rdao.persistir(rol1);
	 	
	 	/* *************************************************************************************** */
	 	

	    // creo usuarioBanco	    	
	
	 	Usuario usuarioAcrear = new Usuario("userComun", "password", "nombre", "apellido", "domicilio",
	    			               telefono, "email", "empresa_organizacion", "personaContacto",horariosContacto);
	     
	    Rol rol2 = new Rol();
	    rol1.setNombreRol("usuarioBanco"); 
	 	rdao.persistir(rol2);
	    
	    
	    Usuario usuarioCreado= userDAO.persistir(usuarioAcrear);
	    usuarios.add( usuarioCreado);    
	    
	    
	    // creo usuario admin2
	    Usuario usuarioAdmin2 = new Usuario("userAdmin2", "password2", "nombre", "apellido", "domicilio",
	               telefono, "email", "empresa_organizacion", "personaContacto",horariosContacto);
	 	System.out.println("----------------------------USUARIO ADMINISTRADOR2-----------------------------------------------");
		System.out.println("---USUARIO ADMIN2-----USER NAME: "+ usuarioAdmin2.getUserName()+ usuarioAdmin2.getPassword() + "APELLIDO: "+ usuarioAdmin2.getApellido() + "NOMBRE: "+usuarioAdmin2.getNombre() + "DOMICILIO: " + usuarioAdmin2.getDomicilio()+" EMAIL: "+ usuarioAdmin2.getEmail()+"EMPRESA/ORGANIZACION: " +usuarioAdmin2.getEmpresa_organizacion()+" PERSONA CONTACTO: "+ usuarioAdmin2.getPersonaContacto()+ "Rol Usuario: "+ usuarioBanco.getRol()+  "lista de usuarios: "+ usuarioBanco.getUsuarios());
		userDAO.persistir(usuarioAdmin2);
		usuarios.add( usuarioAdmin2);    
			
		usuarioBanco.setUsuarios(usuarios);
		
		
	     /* *************************************************************************************** */ 
	   
			
	 	System.out.println("----------------------------AGREGO USUARIO BANCO-----------------------------------------------");
		System.out.println("---USUARIO ADMIN-----USER NAME: "+ usuarioBanco.getUserName()+ usuarioBanco.getPassword() + "APELLIDO: "+ usuarioBanco.getApellido() + "NOMBRE: "+usuarioBanco.getNombre() + "DOMICILIO: " + usuarioBanco.getDomicilio()+" EMAIL: "+ usuarioBanco.getEmail()+"EMPRESA/ORGANIZACION: " +usuarioBanco.getEmpresa_organizacion()+" PERSONA CONTACTO: "+ usuarioBanco.getPersonaContacto()+ "Rol Usuario: "+ usuarioBanco.getRol()+  "lista de usuarios: "+ usuarioBanco.getUsuarios());
		 	
  		userDAO.persistir(usuarioBanco);
	 	
	 	
  		usuarioBanco.setRol(rol1); 
  		System.out.println("----------------------------LE AGREGO EL ROL AL USUARIO BANCO-----------------------------------------------");
		System.out.println("---USUARIO ADMIN-----USER NAME: "+ usuarioBanco.getUserName()+ usuarioBanco.getPassword() + "APELLIDO: "+ usuarioBanco.getApellido() + "NOMBRE: "+usuarioBanco.getNombre() + "DOMICILIO: " + usuarioBanco.getDomicilio()+" EMAIL: "+ usuarioBanco.getEmail()+"EMPRESA/ORGANIZACION: " +usuarioBanco.getEmpresa_organizacion()+" PERSONA CONTACTO: "+ usuarioBanco.getPersonaContacto()+ "Rol Usuario: "+ usuarioBanco.getRol()+  "lista de usuarios: "+ usuarioBanco.getUsuarios());
		
		System.out.println("----------------------------CREO USUARIO SIN RELACIONES PARA DESPUES BORRAR---------------------------------");
		Usuario usuarioBorrar = new Usuario("userBorrar", "passwordBorrar", "nombreBorrar", "apellidoBorrar", "domicilioBorrar",
	               telefono, "emailBorrar", "empresa_organizacionBorrar", "personaContactoBorrar",horariosContacto);

		userDAO.persistir(usuarioBorrar);
		
		
		if (userDAO.existe(usuarioBorrar.getUsuarioId())) {
			System.out.println("existe el usuario: "+ usuarioBanco.getUserName());
			userDAO.borrar(usuarioBorrar);
		}else  {
			System.out.println("No existe el usuario: "+ usuarioBanco.getUserName());
		}
  		
		return userDAO.actualizar(usuarioBanco);
		 
	 }
 

 public static Donacion agregarDonacion(Usuario usuarioDonante) {
	DonacionDAO donacionDAO = new DonacionDAO();
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	
	/* *********************************************/
	Date fechaHoraDeRetiro = new Date();
	Date fechaDisponibilidad = new Date();
	Date fechaHorarioRetiro = new Date();
	Retiro retiroA = new Retiro();
    retiroA.setFechaHoraRetiro(fechaDisponibilidad);
	
    
	Donacion donacion = new Donacion("sucursalPRUEBA","direccionRetiroPRUEBA" ,  fechaHorarioRetiro,  fechaDisponibilidad, 1,  2 ,  true, retiroA, 3 );
    donacion.setRetiro(retiroA);
	donacion=donacionDAO.persistir(donacion);

    
    
    retiroA.setDonacion(donacion);
	RecorridoDAO recorridoDAO = new RecorridoDAO();
	Recorrido recorrido = new Recorrido();
	recorrido.setFechaRetiro(fechaHorarioRetiro);
	recorrido.setUsuario(usuarioDonante);
	recorridoDAO.persistir(recorrido);
	Recorrido recorrido2 = agregarRetiroARecorrido(recorrido,donacion); 
	
	
	
	
	List<Donacion> donaciones = new ArrayList<Donacion>();
	if(usuarioDonante.getDonaciones()==null) {
		
		donaciones.add(donacion);
		usuarioDonante.setDonaciones(donaciones);
	}
	else {
		donaciones= usuarioDonante.getDonaciones();
		donaciones.add(donacion);
		usuarioDonante.setDonaciones(donaciones);
	}
 	
    usuarioDAO.actualizar(usuarioDonante);
	
	
	

	return donacion;
	
 }
  public static Recorrido agregarRecorrido(Usuario usuarioBanco) {
	 // se crea un recorrido
	 RecorridoDAO recorridoDAO = new RecorridoDAO();
	 Recorrido recorrido = new Recorrido();
	 Date fechaRecorrido = new Date();
	 recorrido.setFechaRetiro(fechaRecorrido);
	 recorrido.setUsuario(usuarioBanco);
	 recorrido=recorridoDAO.persistir(recorrido);
	 Usuario nuevoUsuarioDonante = agregarRecorridoAlUsuario(recorrido, usuarioBanco);
	
	 
	 
	   // El usuario agrega 5 comentarios
	 for(int i=0;i<=5;i++) {
		 Comentario comentario= agregarComentario();
		 usuarioBanco= usuarioAgregaComentario(comentario,usuarioBanco);
		 Comentario comentarioResult = agregarRecorridoAlComentario(comentario, recorrido);
		 System.out.println(comentarioResult);
	 }
	
	 
	 // el usuario manda los comentarios al recorrido
	 recorrido.setComentarios(usuarioBanco.getComentarios());
	 return recorridoDAO.actualizar(recorrido);
 } 
public static Comentario agregarRecorridoAlComentario(Comentario comentario, Recorrido recorrido ) {
	ComentarioDAO comentarioDAO = new ComentarioDAO();
	comentario.setRecorrido(recorrido);
	RecorridoDAO recorridoDAO = new RecorridoDAO();
	
	if(recorrido.getComentarios()==null) {
		List<Comentario> listaDeComentarios= new ArrayList<Comentario>();
		listaDeComentarios.add(comentario);
		recorrido.setComentarios(listaDeComentarios);
		
	}
	else {
		List<Comentario> listaAnteriorDeLosComentarios =recorrido.getComentarios();
		listaAnteriorDeLosComentarios.add(comentario);
		recorrido.setComentarios(listaAnteriorDeLosComentarios);
	}

	recorridoDAO.actualizar(recorrido);
	
	return comentarioDAO.actualizar(comentario);
}
 
 
public static Donacion agregarDonacionAProducto(Donacion d) {
	ProductoDAO productoDAO = new ProductoDAO();
	DonacionDAO donacionDAO = new DonacionDAO();
	
	Producto p = new Producto();
	p.setCantidadUnidades(22);
	p.setMarca("marcaPrueba");
	p.setPeso(33.1);
	p=productoDAO.persistir(p);
	
	
	
	if(d.getProductos()==null) {
		List<Producto> listaDeProductos= new ArrayList<Producto>();
		listaDeProductos.add(p);
		d.setProductos(listaDeProductos);
		
	}
	else {
		List<Producto> listaAnteriorDeLosProductos = d.getProductos();
		listaAnteriorDeLosProductos.add(p);
		d.setProductos(listaAnteriorDeLosProductos);
	}
	
	
	
	
	return donacionDAO.actualizar(d);
}


public static Donacion agregarRetiroADonacion(Donacion d) {
	
	
	RetiroDAO retiroDao= new RetiroDAO();
	DonacionDAO donacionDAO = new DonacionDAO();
	
	
	
	/* *****************************/
	/*  crear el retirio*/
    Retiro retiroA = new Retiro();
    Date fecha = new Date();
    retiroA.setFechaHoraRetiro(fecha);
    retiroDao.persistir(retiroA);
	
	
	/* actualizar el retiro*/
	d.setRetiro(retiroA);
	return donacionDAO.actualizar(d);

}
 
 
 public static Comentario agregarComentario() {
	 
	 ComentarioDAO comentarioDAO = new ComentarioDAO();
	 Comentario comentario= new Comentario();
	 comentario.setTextoComentario("lalalall");
	 
	 comentario=comentarioDAO.persistir(comentario);
	 
	 
	 
	 return comentario;
	 

	 
	 
 }
 // agregado por mi y no hace una mierda
 public static Usuario agregarRecorridoAlUsuario(Recorrido recorrido,Usuario usuarioDonante) {
	    UsuarioDAO usuarioDAO = new UsuarioDAO();
	    RecorridoDAO recorridoDAO = new RecorridoDAO();
	    
		if(usuarioDonante.getRecorridos()==null) {
			List<Recorrido> recorridos = new ArrayList<Recorrido>();
			recorridos.add(recorrido);
			usuarioDonante.setRecorridos(recorridos);
		}
		else {
			List<Recorrido>  recorridos= usuarioDonante.getRecorridos();
			recorridos.add(recorrido);
			usuarioDonante.setRecorridos(recorridos);
		}
		return usuarioDAO.actualizar(usuarioDonante);
		
 }


 public static Usuario usuarioAgregaComentario(Comentario comentario, Usuario user ) {

	 
	/* ********************************************************************************* */
	UsuarioDAO userDAO= new UsuarioDAO();
	
	
	if(user.getComentarios()==null) {
		List<Comentario> listaDeComentarios= new ArrayList<Comentario>();
		listaDeComentarios.add(comentario);
		user.setComentarios(listaDeComentarios);
		
	}
	else {
		List<Comentario> listaAnteriorDeLosComentarios =user.getComentarios();
		listaAnteriorDeLosComentarios.add(comentario);
		user.setComentarios(listaAnteriorDeLosComentarios);
	}
	/*
	if(user.getRecorridos()==null) {
		List<Recorrido> recorridos = new ArrayList<Recorrido>();
		recorridos.add(recorrido);
		user.setRecorridos(recorridos);
	}
	else {
		List<Recorrido>  recorridos= user.getRecorridos();
		recorridos.add(recorrido);
		user.setRecorridos(recorridos);
	}
	*/
	
	
	
	
	 
	 return userDAO.actualizar(user);
 }
 
 
 public static Recorrido agregarRetiroARecorrido(Recorrido recorrido, Donacion donacion) {
/*
	 RetiroDAO retiroDAO= new RetiroDAO();
	 
	 Date fecha = new Date();
	 Retiro retiro=donacion.getRetiro();
	 retiro.setRecorrido(recorrido);
	 retiro.setFechaHoraRetiro(fecha);
	 retiro = retiroDAO.actualizar(retiro);
	 
	 System.out.println(retiro.getRecorrido());
	 return retiro.getRecorrido();
	 // agregado por mi y no hace un carajo
	*/
	 
	 RecorridoDAO recorridoDAO= new RecorridoDAO();
	 Retiro retiro = donacion.getRetiro();
	 if(recorrido.getRetiros()==null) {
			List<Retiro> listaDeRetiros= new ArrayList<Retiro>();
			listaDeRetiros.add(retiro);
			recorrido.setRetiros(listaDeRetiros);
			
		}
		else {
			List<Retiro> listaDeRetiros = recorrido.getRetiros();
			listaDeRetiros.add(retiro);
			recorrido.setRetiros(listaDeRetiros);
		}
	 
	 return recorridoDAO.actualizar(recorrido);
	 
	 
 }
 
 
 
 
 

 


}

