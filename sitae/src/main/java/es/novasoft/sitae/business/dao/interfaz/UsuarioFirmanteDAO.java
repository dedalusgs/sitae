package es.novasoft.sitae.business.dao.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.objects.UsuarioFirmante;

public interface UsuarioFirmanteDAO {

	public void save(UsuarioFirmante transientInstance) throws DAOException;

	public void delete(UsuarioFirmante persistentInstance) throws DAOException;

	public UsuarioFirmante findById(Integer id) throws DAOException;

	public List findByExample(UsuarioFirmante instance) throws DAOException;

	public List findByProperty(String propertyName, Object value)
			throws DAOException;

	public List findByNombre(Object nombre) throws DAOException;

	public List findByApellido1(Object apellido1) throws DAOException;

	public List findByApellido2(Object apellido2) throws DAOException;

	public List findByCargo(Object cargo) throws DAOException;

	public List findByNumeroDocumento(Object numDocumento) throws DAOException;

	public List findAll() throws DAOException;

	public UsuarioFirmante merge(UsuarioFirmante detachedInstance)
			throws DAOException;

	public void attachDirty(UsuarioFirmante instance) throws DAOException;

	public void attachClean(UsuarioFirmante instance) throws DAOException;

	public List findByIdOrg(Integer idOrg) throws DAOException;

	public List findByIdOrgNumeroDocumento(Integer idOrg, String numDocumento)
			throws DAOException;

	public int findByFilterCont(Integer idOrg, String nombre, String nif)
			throws DAOException;

	public List findByFilter(Integer idOrg, String nombre, String nif,
			Integer numPag, Integer tamPag) throws DAOException;

}
