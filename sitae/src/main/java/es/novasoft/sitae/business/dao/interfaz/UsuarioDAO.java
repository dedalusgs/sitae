package es.novasoft.sitae.business.dao.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.objects.Usuario;

public interface UsuarioDAO {

	public void save(Usuario transientInstance) throws DAOException;

	public void delete(Usuario persistentInstance) throws DAOException;

	public Usuario findById(Integer id) throws DAOException;

	public List findByExample(Usuario instance) throws DAOException;

	public List findByProperty(String propertyName, Object value)
			throws DAOException;

	public List findByNombre(Object nombre) throws DAOException;

	public List findByApellido1(Object apellido1) throws DAOException;

	public List findByApellido2(Object apellido2) throws DAOException;

	public List findByTelefono(Object telefono) throws DAOException;

	public List findByMovil(Object movil) throws DAOException;

	public List findByNumeroDocumento(Object numDocumento) throws DAOException;

	public List findByEmail(Object email) throws DAOException;

	public List findAll() throws DAOException;

	public Usuario merge(Usuario detachedInstance) throws DAOException;

	public void attachDirty(Usuario instance) throws DAOException;

	public void attachClean(Usuario instance) throws DAOException;

}
