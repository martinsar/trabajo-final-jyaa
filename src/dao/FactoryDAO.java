package dao;

import dao.imp.*;




public class FactoryDAO {
	
	public static IUsuarioDAO getPersonaDao() {
		return new UsuarioDAO();
	}
	
	public static IComentarioDAO getComentarioDAO() {
		return new ComentarioDAO();
	}
	
	public static IDonacionDAO getDonacionDAO() {
		return new DonacionDAO();
		
	}
	
	public static IProductoDAO getProductoDAO() {
		return new ProductoDAO();
		
	}
	
	public static IRecorridoDAO getRecorridoDAO() {
		return new RecorridoDAO();
		
	}
	
	public static IRetiroDAO getRetiroDAO() {
		return new RetiroDAO();
	}
	
	public static IRolDAO getRolDAO() {
		return new RolDAO();
	}

}
