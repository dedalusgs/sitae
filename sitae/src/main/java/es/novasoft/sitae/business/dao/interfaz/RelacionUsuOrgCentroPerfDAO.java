package es.novasoft.sitae.business.dao.interfaz;

import java.util.List;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.sitae.business.objects.RelacionUsuOrgCentroPerf;

public interface RelacionUsuOrgCentroPerfDAO {

	public void save(RelacionUsuOrgCentroPerf transientInstance)
			throws DAOException;

	public void delete(RelacionUsuOrgCentroPerf persistentInstance)
			throws DAOException;

	public RelacionUsuOrgCentroPerf findById(Integer id) throws DAOException;

	public List findByExample(RelacionUsuOrgCentroPerf instance)
			throws DAOException;

	public List findByProperty(String propertyName, Object value)
			throws DAOException;

	public List findAll() throws DAOException;

	public RelacionUsuOrgCentroPerf merge(
			RelacionUsuOrgCentroPerf detachedInstance) throws DAOException;

	public void attachDirty(RelacionUsuOrgCentroPerf instance)
			throws DAOException;

	public void attachClean(RelacionUsuOrgCentroPerf instance)
			throws DAOException;

	public List findByOrgUsuPerf(String cif, String dni, String id_pefil)
			throws DAOException;

	public List findByUsuPerf(String dni, String id_pefil) throws DAOException;

	public List findByCentroUsuPerf(String idCentro, String dni, String id_pefil)
			throws DAOException;

	public List findByCif(String cif) throws DAOException;

	public List findByPerfil(Integer idPerfil) throws DAOException;

	public List findByUsuario(String dni) throws DAOException;

	public List findByCifDni(String cif, String dni) throws DAOException;

	public List findByCentroPerfil(Integer idCentro, Integer idPerfil)
			throws DAOException;

	public List findByCentro(Integer idCentro) throws DAOException;

	public List findByOrgPerf(String cif, String idPerfil) throws DAOException;

	public List findByOrgIncluyendoPerfiles(String cif, List perfiles)
			throws DAOException;

	public List findByOrgNifIncluyendoPerfiles(String cif, String nif,
			List perfiles) throws DAOException;

}
