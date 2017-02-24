package es.novasoft.sitae.business.dao.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.objects.Funcionalidad;

public interface FuncionalidadDAO {

	public void save(Funcionalidad transientInstance) throws DAOException;

	public void delete(Funcionalidad persistentInstance) throws DAOException;

	public Funcionalidad findById(Integer id) throws DAOException;

	public List findByExample(Funcionalidad instance) throws DAOException;

	public List findByProperty(String propertyName, Object value)
			throws DAOException;

	public List findByNombre(Object nombre) throws DAOException;

	public List findAll() throws DAOException;

	public Funcionalidad merge(Funcionalidad detachedInstance)
			throws DAOException;

	public void attachDirty(Funcionalidad instance) throws DAOException;

	public void attachClean(Funcionalidad instance) throws DAOException;

}
