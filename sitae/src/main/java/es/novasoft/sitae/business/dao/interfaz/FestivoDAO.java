package es.novasoft.sitae.business.dao.interfaz;

import java.util.Date;
import java.util.List;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.objects.Festivo;
import es.novasoft.sitae.business.objects.Organismo;

public interface FestivoDAO {

	public void save(Festivo transientInstance) throws DAOException;

	public void delete(Festivo persistentInstance)
			throws DAOException;

	public Festivo findById(Integer id) throws DAOException;

	public List findByExample(Festivo instance) throws DAOException;

	public List findByProperty(String propertyName, Object value)
			throws DAOException;

	public List findByNombre(Object nombre) throws DAOException;

	public List findAll() throws DAOException;

	public Festivo merge(Festivo detachedInstance)
			throws DAOException;

	public void attachDirty(Festivo instance) throws DAOException;

	public void attachClean(Festivo instance) throws DAOException;




	public List findByDate(Integer idOrg, Date fecha) throws DAOException;
	public List findByOrgAnio(Organismo org, Integer anio) throws DAOException;
	public List findByIdOrgAnio(Integer idOrg, Integer anio) throws DAOException;

}
