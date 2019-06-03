package dao.imp;

import dao.IRecorridoDAO;
import modelo.Recorrido;
import modelo.Usuario;


public class RecorridoDAO extends GenericDAOHibernateJPA<Recorrido>implements IRecorridoDAO{
	public Class<Recorrido> getPersistentClass() {
		return  Recorrido.class;
	}
}
