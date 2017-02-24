package es.novasoft.sitae.business.dao.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.objects.RedSocial;

public interface RedSocialDAO {

	public void save(RedSocial transientInstance) throws DAOException;

	public void delete(RedSocial persistentInstance) throws DAOException;

	public RedSocial findById(Integer id) throws DAOException;

	public List findByExample(RedSocial instance) throws DAOException;

	public List findByProperty(String propertyName, Object value) throws DAOException;

	public List findAll() throws DAOException;

	public RedSocial merge(RedSocial detachedInstance) throws DAOException;

	public void attachDirty(RedSocial instance) throws DAOException;

	public void attachClean(RedSocial instance) throws DAOException;

}
