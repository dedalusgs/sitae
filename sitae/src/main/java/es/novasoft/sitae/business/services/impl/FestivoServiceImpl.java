package es.novasoft.sitae.business.services.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.novasoft.comun.exceptions.DAOException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.comun.utils.FechasUtil;
import es.novasoft.sitae.business.dao.interfaz.FestivoDAO;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Festivo;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.FestivoService;

public class FestivoServiceImpl implements FestivoService {
	
	private static Log	log	= LogFactory.getFactory().getInstance(FestivoServiceImpl.class);
	
	private FestivoDAO	festivoDAO;
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.services.impl.FestivoService#getFestivoDao()
	 */
	public FestivoDAO getFestivoDao() {
		return festivoDAO;
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.services.impl.FestivoService#setFestivoDAO
	 * (es.novasoft.sitae.business.dao.interfaz.FestivoDAO)
	 */
	public void setFestivoDAO(FestivoDAO FestivoDAO) {
		this.festivoDAO = FestivoDAO;
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.services.impl.FestivoService#save(es.novasoft
	 * .sitae.business.objects.Festivo)
	 */
	public void save(Festivo transientInstance) throws ServiceException {
		log.debug("save Festivo");
		try {
			festivoDAO.save(transientInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.services.impl.FestivoService#delete(es.novasoft
	 * .sitae.business.objects.Festivo)
	 */
	public void delete(Festivo persistentInstance) throws ServiceException {
		log.debug("deleting Festivo instance");
		try {
			festivoDAO.delete(persistentInstance);
			log.debug("delete successful");
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.services.impl.FestivoService#findById(java
	 * .lang.Integer)
	 */
	public Festivo findById(Integer id) throws ServiceException {
		log.debug("getting Festivo instance with id: " + id);
		try {
			return festivoDAO.findById(id);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.services.impl.FestivoService#findByExample
	 * (es.novasoft.sitae.business.objects.Festivo)
	 */
	public List findByExample(Festivo instance) throws ServiceException {
		log.debug("finding Festivo instance by example");
		try {
			return festivoDAO.findByExample(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.services.impl.FestivoService#findByProperty
	 * (java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) throws ServiceException {
		try {
			return festivoDAO.findByProperty(propertyName, value);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.services.impl.FestivoService#findByNombre(
	 * java.lang.Object)
	 */
	public List findByNombre(Object nombre) throws ServiceException {
		log.debug("findByNombre");
		try {
			return festivoDAO.findByNombre(nombre);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see es.novasoft.sitae.business.services.impl.FestivoService#findAll()
	 */
	public List findAll() throws ServiceException {
		log.debug("findAll Centro de Procedencia");
		try {
			return festivoDAO.findAll();
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.services.impl.FestivoService#merge(es.novasoft
	 * .sitae.business.objects.Festivo)
	 */
	public Festivo merge(Festivo detachedInstance) throws ServiceException {
		log.debug("merging Festivo instance");
		try {
			return festivoDAO.merge(detachedInstance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.services.impl.FestivoService#attachDirty(es
	 * .novasoft.sitae.business.objects.Festivo)
	 */
	public void attachDirty(Festivo instance) throws ServiceException {
		log.debug("attaching dirty Festivo instance");
		try {
			festivoDAO.attachDirty(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.services.impl.FestivoService#attachClean(es
	 * .novasoft.sitae.business.objects.Festivo)
	 */
	public void attachClean(Festivo instance) throws ServiceException {
		log.debug("attaching clean Festivo instance");
		try {
			festivoDAO.attachClean(instance);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.services.impl.FestivoService#findByIdOrgAnio
	 * (java.lang.Integer, java.lang.Integer)
	 */
	public List findByIdOrgAnio(Integer idOrg, Integer anio) throws ServiceException {
		log.debug("finding Festivo instance by example");
		try {
			return festivoDAO.findByIdOrgAnio(idOrg, anio);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.services.impl.FestivoService#findByOrgAnio
	 * (es.novasoft.sitae.business.objects.Organismo, java.lang.Integer)
	 */
	public List findByOrgAnio(Organismo org, Integer anio) throws ServiceException {
		log.debug("finding Festivo instance by example");
		try {
			return festivoDAO.findByOrgAnio(org, anio);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * es.novasoft.sitae.business.services.impl.FestivoService#findByDate(java
	 * .lang.Integer, java.util.Date)
	 */
	public List findByDate(Integer idOrg, Date fecha) throws ServiceException {
		log.debug("finding Festivo instance by example");
		try {
			return festivoDAO.findByDate(idOrg, fecha);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage(), e.getExceptionkey());
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see es.novasoft.sitae.business.services.impl.FestivoService#
	 * obtenerFechaFinPublicacionDiasLaborables(java.util.Date,
	 * es.novasoft.sitae.business.objects.Organismo, java.lang.Integer)
	 */
	public Date obtenerFechaFinPublicacion(Date fechaInicio, Organismo org, Integer diaslaborables, String tipo) throws ServiceException {
		
		Date fechaFin = null;
		String fechaInicioString = FechasUtil.convertDateToString(fechaInicio, FechasUtil.typeSdfDate);
		Calendar inicio = new GregorianCalendar();
		inicio.setTime(FechasUtil.convertStringToDate(fechaInicioString, FechasUtil.typeSdfDate));
		if (tipo.equals(Edicto.TIPO_PUBLICACION_NATURALES)) {
			fechaFin = FechasUtil.addDays(inicio.getTime(), diaslaborables);
		} else {
			
			Integer anio = inicio.get(Calendar.YEAR);
			List listaFestivosOrg = null;
			try {
				listaFestivosOrg = festivoDAO.findByOrgAnio(org, anio);
				listaFestivosOrg.addAll(festivoDAO.findByOrgAnio(org, anio + 1));
				listaFestivosOrg.addAll(festivoDAO.findByOrgAnio(null, anio));
				listaFestivosOrg.addAll(festivoDAO.findByOrgAnio(null, anio + 1));
			} catch (DAOException e) {
				log.error(e.getMessage());
				throw new ServiceException(e.getMessage(), e.getExceptionkey());
			}
			Set<Date> conjuntoFestivosOrg = new HashSet<Date>();
			
			Iterator<Festivo> iteradorFestivo = listaFestivosOrg.iterator();
			while (iteradorFestivo.hasNext()) {
				Festivo aux = iteradorFestivo.next();
				conjuntoFestivosOrg.add(aux.getFecha());
			}
			int contadorDiasLaborables = diaslaborables.intValue();
			Calendar auxInicio = (Calendar) inicio.clone();
			// El primer dia no Cuenta
			
			while (contadorDiasLaborables > 0) {
				auxInicio.add(Calendar.DAY_OF_YEAR, 1);
				if (!conjuntoFestivosOrg.contains(auxInicio.getTime()) && (auxInicio.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)
				        && (auxInicio.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY)) {
					contadorDiasLaborables--;
				}
			}
			fechaFin = auxInicio.getTime();
			
		}
		
		return fechaFin;
	}
	
	public Integer obtenerDiasPublicacion(Date fechaInicio, Date fechaFin, Organismo org, String tipo) throws ServiceException {
		
		Integer numeroDias = 0;
		if (tipo.equals(Edicto.TIPO_PUBLICACION_NATURALES)) {
			numeroDias = new Double(FechasUtil.getDifferenceByDays(fechaInicio, fechaFin)).intValue();
		} else {
			String stringFechaInicio = FechasUtil.convertDateToString(fechaInicio, FechasUtil.typeSdfDate);
			Calendar inicio = new GregorianCalendar();
			inicio.setTime(FechasUtil.convertStringToDate(stringFechaInicio, FechasUtil.typeSdfDate));
			
			String stringFechaFin = FechasUtil.convertDateToString(fechaFin, FechasUtil.typeSdfDate);
			Calendar fin = new GregorianCalendar();
			fin.setTime(FechasUtil.convertStringToDate(stringFechaFin, FechasUtil.typeSdfDate));
			
			Integer anio = inicio.get(Calendar.YEAR);
			List listaFestivosOrg = null;
			try {
				listaFestivosOrg = festivoDAO.findByOrgAnio(org, anio);
				listaFestivosOrg.addAll(festivoDAO.findByOrgAnio(org, anio + 1));
				listaFestivosOrg.addAll(festivoDAO.findByOrgAnio(null, anio));
				listaFestivosOrg.addAll(festivoDAO.findByOrgAnio(null, anio + 1));
			} catch (DAOException e) {
				log.error(e.getMessage());
				throw new ServiceException(e.getMessage(), e.getExceptionkey());
			}
			Set<Date> conjuntoFestivosOrg = new HashSet<Date>();
			
			Iterator<Festivo> iteradorFestivo = listaFestivosOrg.iterator();
			while (iteradorFestivo.hasNext()) {
				Festivo aux = iteradorFestivo.next();
				conjuntoFestivosOrg.add(aux.getFecha());
			}
			int contadorDiasLaborables = 0;
			Calendar auxInicio = (Calendar) inicio.clone();
			// El primer dia no Cuenta
			// auxInicio.add(Calendar.DAY_OF_YEAR,1);
			while (auxInicio.compareTo(fin) < 0) {
				auxInicio.add(Calendar.DAY_OF_YEAR, 1);
				if (!conjuntoFestivosOrg.contains(auxInicio.getTime()) && auxInicio.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY
				        && (auxInicio.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY)) {
					contadorDiasLaborables++;
				}
			}
			numeroDias = contadorDiasLaborables;
			
		}
		
		return numeroDias;
	}
	
}
