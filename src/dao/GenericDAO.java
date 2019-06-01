package dao;

import java.io.Serializable;
import java.util.List;


public interface GenericDAO<T> {
	
	public T actualizar(T entity);
	public void borrar(T entity);
	public boolean existe(Serializable id);
	public T persistir(T entity);
	public T persistirLibre(T entity);
	public T recuperar(Serializable id);
	public Class<T> getPersistentClass();
	

}
