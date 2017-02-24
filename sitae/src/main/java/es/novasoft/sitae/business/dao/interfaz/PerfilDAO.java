package es.novasoft.sitae.business.dao.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.objects.Perfil;

public interface PerfilDAO {

	public void save(Perfil transientInstance) throws DAOException;

	public void delete(Perfil persistentInstance) throws DAOException;

	public Perfil findById(Integer id) throws DAOException;

	public List findByExample(Perfil instance) throws DAOException;

	public List findByProperty(String propertyName, Object value)
			throws DAOException;

	public List findByNombre(Object nombre) throws DAOException;

	public List findAll() throws DAOException;

	public Perfil merge(Perfil detachedInstance) throws DAOException;

	public void attachDirty(Perfil instance) throws DAOException;

	public void attachClean(Perfil instance) throws DAOException;

}
