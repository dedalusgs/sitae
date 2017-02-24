package es.novasoft.sitae.business.dao.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.objects.CentroProcedencia;

public interface CentroProcedenciaDAO {
	
	public void save(CentroProcedencia transientInstance) throws DAOException;
	
	public void delete(CentroProcedencia persistentInstance) throws DAOException;
	
	public CentroProcedencia findById(Integer id) throws DAOException;
	
	public List findByExample(CentroProcedencia instance) throws DAOException;
	
	public List findByProperty(String propertyName, Object value) throws DAOException;
	
	public List findByNombre(Object nombre) throws DAOException;
	
	public List findAll() throws DAOException;
	
	public CentroProcedencia merge(CentroProcedencia detachedInstance) throws DAOException;
	
	public void attachDirty(CentroProcedencia instance) throws DAOException;
	
	public void attachClean(CentroProcedencia instance) throws DAOException;
	
	// public List findByIdOrg(Integer idOrg) throws DAOException;
	
	public List findByNombreCif(String nombre, String cif) throws DAOException;
	
}
