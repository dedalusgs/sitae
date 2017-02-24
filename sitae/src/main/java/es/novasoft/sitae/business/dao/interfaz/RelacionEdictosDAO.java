package es.novasoft.sitae.business.dao.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.objects.RelacionEdictos;

public interface RelacionEdictosDAO {

	public void save(RelacionEdictos transientInstance) throws DAOException;

	public void delete(RelacionEdictos persistentInstance) throws DAOException;

	public RelacionEdictos findById(Integer id) throws DAOException;

	public List findByExample(RelacionEdictos instance) throws DAOException;

	public List findByProperty(String propertyName, Object value)
			throws DAOException;

	public List findAll() throws DAOException;

	public RelacionEdictos merge(RelacionEdictos detachedInstance) throws DAOException;

	public void attachDirty(RelacionEdictos instance) throws DAOException;

	public void attachClean(RelacionEdictos instance) throws DAOException;

	public List findByEdicto(Integer idEdicto) throws DAOException;

}
