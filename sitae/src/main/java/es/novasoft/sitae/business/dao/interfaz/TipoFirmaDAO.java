package es.novasoft.sitae.business.dao.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.objects.TipoFirma;

public interface TipoFirmaDAO {
	public void save(TipoFirma transientInstance) throws DAOException;

	public void delete(TipoFirma persistentInstance) throws DAOException;

	public TipoFirma findById(Integer id) throws DAOException;

	public List findByExample(TipoFirma instance) throws DAOException;

	public List findByProperty(String propertyName, Object value)
			throws DAOException;

	public List findByNombre(Object nombre) throws DAOException;

	public List findAll() throws DAOException;

	public TipoFirma merge(TipoFirma detachedInstance)
			throws DAOException;

	public void attachDirty(TipoFirma instance) throws DAOException;

	public void attachClean(TipoFirma instance) throws DAOException;

}
