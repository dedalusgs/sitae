package es.novasoft.sitae.business.dao.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.objects.Interesado;
import es.novasoft.sitae.business.objects.Organismo;

public interface InteresadoDAO {

	public void save(Interesado transientInstance) throws DAOException;

	public void delete(Interesado persistentInstance) throws DAOException;

	public Interesado findById(Integer id) throws DAOException;

	public List findByExample(Interesado instance) throws DAOException;

	public List findByProperty(String propertyName, Object value) throws DAOException;

	public List findByEmail(Object nombre) throws DAOException;

	public List findAll() throws DAOException;

	public Interesado merge(Interesado detachedInstance) throws DAOException;

	public void attachDirty(Interesado instance) throws DAOException;

	public void attachClean(Interesado instance) throws DAOException;

	public Interesado findByEmailOrganismoActivo(String email, Organismo org, Boolean activo) throws DAOException;

	public List findAllByOrg(Organismo org, Boolean activo) throws DAOException;
}
