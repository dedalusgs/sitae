package es.novasoft.sitae.business.services.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.objects.UsuarioFirmante;

public interface UsuarioFirmanteService {

	public void save(UsuarioFirmante transientInstance) throws ServiceException;

	public void delete(UsuarioFirmante persistentInstance)
			throws ServiceException;

	public UsuarioFirmante findById(Integer id) throws ServiceException;

	public List findByExample(UsuarioFirmante instance) throws ServiceException;

	public List findByProperty(String propertyName, Object value)
			throws ServiceException;

	public List findByNombre(Object nombre) throws ServiceException;

	public List findByApellido1(Object apellido1) throws ServiceException;

	public List findByApellido2(Object apellido2) throws ServiceException;

	public List findByCargo(Object cargo) throws ServiceException;

	public List findByNumeroDocumento(Object numDocumento)
			throws ServiceException;

	public List findAll() throws ServiceException;

	public UsuarioFirmante merge(UsuarioFirmante detachedInstance)
			throws ServiceException;

	public void attachDirty(UsuarioFirmante instance) throws ServiceException;

	public void attachClean(UsuarioFirmante instance) throws ServiceException;

	public List findByIdOrg(Integer idOrg) throws ServiceException;

	public List findByIdOrgNumeroDocumento(Integer idOrg, String numDocumento)
			throws ServiceException;

	public int findByFilterCont(Integer idOrg, String nombre, String nif)
			throws ServiceException;

	public List findByFilter(Integer idOrg, String nombre, String nif,
			int numPag, int tamPag) throws ServiceException;

}
