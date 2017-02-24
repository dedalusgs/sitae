package es.novasoft.sitae.business.services.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.objects.Usuario;

public interface UsuarioService {

	public void save(Usuario transientInstance) throws ServiceException;

	public void delete(Usuario persistentInstance) throws ServiceException;

	public Usuario findById(Integer id) throws ServiceException;

	public List findByExample(Usuario instance) throws ServiceException;

	public List findByProperty(String propertyName, Object value)
			throws ServiceException;

	public List findByNombre(Object nombre) throws ServiceException;

	public List findByApellido1(Object apellido1) throws ServiceException;

	public List findByApellido2(Object apellido2) throws ServiceException;

	public List findByTelefono(Object telefono) throws ServiceException;

	public List findByMovil(Object movil) throws ServiceException;

	public List findByEmail(Object email) throws ServiceException;

	public List findByNumeroDocumento(Object numDocumento)
			throws ServiceException;

	public List findAll() throws ServiceException;

	public Usuario merge(Usuario detachedInstance) throws ServiceException;

	public void attachDirty(Usuario instance) throws ServiceException;

	public void attachClean(Usuario instance) throws ServiceException;

}
