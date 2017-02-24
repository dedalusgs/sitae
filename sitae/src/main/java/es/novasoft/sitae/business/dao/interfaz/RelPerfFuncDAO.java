package es.novasoft.sitae.business.dao.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.objects.RelPerfFunc;

public interface RelPerfFuncDAO {

	public void save(RelPerfFunc transientInstance) throws DAOException;

	public void delete(RelPerfFunc persistentInstance) throws DAOException;

	public RelPerfFunc findById(Integer id) throws DAOException;

	public List findByExample(RelPerfFunc instance) throws DAOException;

	public List findByProperty(String propertyName, Object value)
			throws DAOException;

	public List findAll() throws DAOException;

	public RelPerfFunc merge(RelPerfFunc detachedInstance) throws DAOException;

	public void attachDirty(RelPerfFunc instance) throws DAOException;

	public void attachClean(RelPerfFunc instance) throws DAOException;

	public List findByPerfil(Integer idPerfil) throws DAOException;

	public List findByIdFuncionalidad(Integer idPerfil) throws DAOException;

}
