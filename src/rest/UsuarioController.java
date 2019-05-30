package rest;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@WebService
@Path("/usuario")
public class UsuarioController {
	   @GET
	   @Path("/persist")
	  // @ProduceMime("text/html")
	   @WebMethod
	   public int addNumbers(@QueryParam("n1") int number1, @QueryParam("n2") int number2) /* throws  AddNumbersException */{
	 
	 
	      if (number1 < 0 || number2 < 0) {
	   //      throw new AddNumbersException("Negative number cant be added! Numbers: " + number1 + ", " + number2);
	   }
	   return number1 + number2;
	} 

}
