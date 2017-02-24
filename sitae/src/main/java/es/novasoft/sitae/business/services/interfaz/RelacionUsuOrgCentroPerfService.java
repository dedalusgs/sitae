package es.novasoft.sitae.business.services.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;

public interface RelacionUsuOrgCentroPerfService {

	public void save(RelacionUsuOrgCentroPerf transientInstance)
			throws ServiceException;

	public void delete(RelacionUsuOrgCentroPerf persistentInstance)
			throws ServiceException;

	public RelacionUsuOrgCentroPerf findById(Integer id)
			throws ServiceException;

	public List findByExample(RelacionUsuOrgCentroPerf instance)
			throws ServiceException;

	public List findByProperty(String propertyName, Object value)
			throws ServiceException;

	public List findAll() throws ServiceException;

	public RelacionUsuOrgCentroPerf merge(
			RelacionUsuOrgCentroPerf detachedInstance) throws ServiceException;

	public void attachDirty(RelacionUsuOrgCentroPerf instance)
			throws ServiceException;

	public void attachClean(RelacionUsuOrgCentroPerf instance)
			throws ServiceException;

	public List findByOrgUsuPerf(String cif, String dni, String id_pefil)
			throws ServiceException;

	public List findByUsuPerf(String dni, String id_pefil)
			throws ServiceException;

	public List findByCentroUsuPerf(String idCentro, String dni, String id_pefil)
			throws ServiceException;

	public List findByCif(String cif) throws ServiceException;

	public List findByPerfil(Integer idPerfil) throws ServiceException;

	public List findByUsuario(String dni) throws ServiceException;

	public List findByCifDni(String cif, String dni) throws ServiceException;

	public List findByCentroPerfil(Integer idCentro, Integer idPerfil)
			throws ServiceException;

	public List findByCentro(Integer idCentro) throws ServiceException;

	public List findByOrgPerf(String cif, String idPerfil)
			throws ServiceException;

	public List findByOrgIncluyendoPerfiles(String cif, List perfiles)
			throws ServiceException;

	public List findByOrgNifIncluyendoPerfiles(String cif, String nif,
			List perfiles) throws ServiceException;

}
