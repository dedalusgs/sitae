package es.novasoft.comun.struts;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import es.novasoft.comun.beans.SessionBean;
import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.exceptions.ConfigurationException;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.login.constantes.ConstantesFirma;

/**
 * <p>
 * Title: ActionBase
 * </p>
 * <p>
 * Description: Clase base para los action de struts
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: NovaSoft
 * </p>
 * 
 */

public abstract class ActionBase extends Action {

	public static final String CANCEL_KEY = Constantes.FORWARD_CANCEL;

	public static final String SUCCESS_KEY = Constantes.SUCCESS;

	public static final String SUCCESS_KEY_2 = Constantes.SUCCESS_2;

	public static final String ERROR_KEY = Constantes.FAILURE;

	public static final String ERROR_KEY_2 = Constantes.FAILURE_2;

	public static final String SESION_EXPIRADA = Constantes.SESION_EXPIRADA;

	public static final String SYSTEM_ERROR_KEY = Constantes.SYSTEM_ERROR_KEY;

	public static final String ERRORFECHA = Constantes.ERROR;

	public static final String ERROR_REQUEST = Constantes.ERROR_REQUEST;

	public static final String MESSAGE_REQUEST = Constantes.MESSAGE_REQUEST;

	protected Log log = LogFactory.getLog(ActionBase.class);

	protected Logger LOGGER = Logger.getLogger(ActionBase.class);

	public static final String SESION_EXPIRADA_EXTRANET = Constantes.SESION_EXPIRADA_EXTRANET;

	public static final String INTRANET_KEY = Constantes.FORWARD_INTRANET;

	public static final String ALTA_USER = Constantes.ALTA_USER;

	public static final String SUCCESS_KEY_3 = Constantes.SUCCESS_3;

	/**
	 * 
	 */
	public ActionBase() {
		super();

	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		log.info(Constantes.COMIENZA_METODO);
		try {
			log.info(Constantes.FIN_METODO);
			return executeAction(mapping, form, request, response);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Metodo que deberan implementar todas las clases que heredan de
	 * SecurityAction. En este metodo se realizaran las tareas especificas de la
	 * accion que se quiere realizar.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws ConfigurationException
	 * @throws ServiceException
	 * @throws ServiceException
	 * @throws Exception
	 * @throws Throwable
	 * @throws
	 * @throws BadArgumentException
	 */

	protected abstract ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ConfigurationException,
			ServiceException, Exception, Throwable;

	/**
	 * Devuelve el Action Errors de la request o null si no hay.
	 * 
	 * @return Returns the errors.
	 */
	public ActionMessages getError(HttpServletRequest request) {
		return (ActionMessages) request.getAttribute(ERROR_REQUEST);
	}

	/**
	 * @param errors
	 *            The errors to set.
	 */
	public void setErrors(HttpServletRequest request, ActionMessages errors) {
		request.setAttribute(ERROR_REQUEST, errors);

	}

	/**
	 * @return Returns the msgs.
	 */
	public ActionMessages getMsgs(HttpServletRequest request) {
		return (ActionMessages) request.getAttribute(MESSAGE_REQUEST);
	}

	/**
	 * @param msgs
	 *            The msgs to set.
	 */
	public void setMsgs(HttpServletRequest request, ActionMessages msgs) {
		request.setAttribute(MESSAGE_REQUEST, msgs);
	}

	/**
	 * A ade un Mensaje a la cola de mensajes, crea los mensajes si no est n
	 * creados.
	 * 
	 * @param key
	 * @param msgKey
	 */
	protected void addMsg(HttpServletRequest request, String key, String msgKey) {
		ActionMessages msgs = getMsgs(request);
		if (msgs == null)
			msgs = new ActionMessages();
		msgs.add(key, new ActionMessage(msgKey));
		setMsgs(request, msgs);
	}

	/**
	 * Sobrecarga el anterior para utilizar par metros en los mensajes.
	 * 
	 * @param request
	 * @param key
	 * @param msgKey
	 * @param params
	 */
	protected void addMsg(HttpServletRequest request, String key,
			String msgKey, Object[] params) {
		ActionMessages msgs = getMsgs(request);
		if (msgs == null)
			msgs = new ActionMessages();
		msgs.add(key, new ActionMessage(msgKey, params));
		setMsgs(request, msgs);
	}

	/**
	 * Sobrecargado para enviarlo todo en un array con la key en la posici n 0.
	 * 
	 * @param request
	 * @param key
	 * @param oMsg
	 */

	protected void addMsg(HttpServletRequest request, String key, Object[] oMsg) {
		ActionMessages msgs = getMsgs(request);
		if (msgs == null)
			msgs = new ActionMessages();
		ActionMessage msg = null;
		if (oMsg.length > 1) {
			Object[] params = new Object[oMsg.length - 1];
			for (int i = 0; i < params.length; i++)
				params[i] = oMsg[i + 1];
			msg = new ActionMessage((String) oMsg[0], params);
		} else {
			msg = new ActionMessage((String) oMsg[0]);
		}

		msgs.add(key, msg);
		setMsgs(request, msgs);
	}

	/**
	 * A ade un error a la cola de errores, y crea esta si no existe.
	 * 
	 * @param key
	 * @param errorKey
	 */
	protected void addError(HttpServletRequest request, String key,
			String errorKey) {
		ActionMessages errors = getError(request);
		if (errors == null)
			errors = new ActionMessages();
		errors.add(key, new ActionMessage(errorKey));
		setErrors(request, errors);
	}

	/**
	 * Sobrecarga el anterior para pasar parametros a los errores.
	 * 
	 * @param request
	 * @param key
	 * @param errorKey
	 * @param params
	 */
	protected void addError(HttpServletRequest request, String key,
			String errorKey, Object[] params) {
		ActionMessages errors = getError(request);
		if (errors == null)
			errors = new ActionErrors();
		ActionMessage error = new ActionMessage(errorKey, params);
		errors.add(key, error);
		setErrors(request, errors);
	}

	/**
	 * Sobrecargado para pasar todo en un array, la errorKey es el elem 0.
	 * 
	 * @param request
	 * @param key
	 * @param oError
	 */

	protected void addError(HttpServletRequest request, String key,
			Object[] oError) {
		ActionMessages errors = getError(request);
		if (errors == null)
			errors = new ActionErrors();
		ActionMessage error = null;
		if (oError.length > 1) {
			Object[] params = new Object[oError.length - 1];
			for (int i = 0; i < params.length; i++)
				params[i] = oError[i + 1];
			error = new ActionMessage((String) oError[0], params);
		} else {
			error = new ActionMessage((String) oError[0]);
		}

		errors.add(key, error);
		setErrors(request, errors);
	}

	/**
	 * Devuelve el forward buscado pero antes salva los mensajes, si hay errores
	 * en la cola de errores los salva y redirecciona a la clave
	 * ActionBase.ERROR_KEY
	 * 
	 * @param request
	 * @param mapping
	 * @param fwdstr
	 * @return
	 */
	protected ActionForward forward(HttpServletRequest request,
			ActionMapping mapping, String fwdstr) {
		ActionForward resultfwd = null;
		ActionMessages errors = getError(request);
		if (errors != null) {
			saveErrors(request, errors);
			resultfwd = mapping.findForward(ActionBase.ERROR_KEY);
			if (resultfwd == null)
				resultfwd = mapping.findForward(ActionBase.SYSTEM_ERROR_KEY);
			if (fwdstr.equals(Constantes.SESION_EXPIRADA)) {
				resultfwd = mapping.findForward(ActionBase.SESION_EXPIRADA);
			}
			if (fwdstr.equals(Constantes.SESION_EXPIRADA_EXTRANET)) {
				resultfwd = mapping
						.findForward(ActionBase.SESION_EXPIRADA_EXTRANET);
			}
			if (fwdstr.equals("errorFecha")) {
				resultfwd = mapping.findForward(ActionBase.ERRORFECHA);
			}

		} else {
			ActionMessages msgs = getMsgs(request);
			if (msgs != null)
				saveMessages(request, msgs);
			resultfwd = mapping.findForward(fwdstr);

		}
		return resultfwd;
	}

	/*
	 * public static UsuarioAutentificado obtenerUsuario (Usuario usuario){
	 * 
	 * UsuarioAutentificado ua = new UsuarioAutentificado();
	 * 
	 * String tipoDocumento = usuario.getNumDocumento();
	 * 
	 * if(tipoDocumento != null && !tipoDocumento.equals("") &&
	 * tipoDocumento.equals("NIF")){
	 * 
	 * ua.setDni(solicitud.getMasterInteresadosSolicitante().getNumeroDocumento());
	 * ua.setNombre(solicitud.getMasterInteresadosSolicitante().getNombre());
	 * ua.setPrimerapellido(solicitud.getMasterInteresadosSolicitante().getApellido1());
	 * ua.setSegundoapellido(solicitud.getMasterInteresadosSolicitante().getApellido2());
	 * 
	 * }else if(tipoDocumento != null && !tipoDocumento.equals("") &&
	 * tipoDocumento.equals("CIF")){
	 * 
	 * ua.setCifEntidad(solicitud.getMasterInteresadosSolicitante().getNumeroDocumento());
	 * ua.setNombreEntidad(solicitud.getMasterInteresadosSolicitante().getNombre()); }
	 * 
	 * ua.setEmail(solicitud.getMasterInteresadosSolicitante().getEmail());
	 * 
	 * return ua; }
	 */

	protected boolean usuarioAutenticado(HttpServletRequest request) {

		HttpSession session = request.getSession();

		SessionBean sb = (SessionBean) session
				.getAttribute(ConstantesFirma.SESSION_BEAN_FIRMA);

		UsuarioAutentificado ua = null;

		Boolean usuario = false;

		String idSes = null;

		if (sb != null) {

			List lista = sb.getLista();

			Iterator it = lista.iterator();

			if (it.hasNext()) {
				ua = (UsuarioAutentificado) it.next();
			}

			if (it.hasNext()) {
				idSes = it.next().toString();
			}

			if (idSes.equals(request.getSession().getId())) {

				if (ua != null) {
					usuario = true;
				}
			}
		}

		return usuario;
	}

	protected UsuarioAutentificado obtenerUsuario(HttpServletRequest request) {

		HttpSession session = request.getSession();

		SessionBean sb = (SessionBean) session
				.getAttribute(ConstantesFirma.SESSION_BEAN_FIRMA);

		UsuarioAutentificado ua = null;

		if (sb != null) {

			List lista = sb.getLista();

			Iterator it = lista.iterator();

			if (it.hasNext()) {
				ua = (UsuarioAutentificado) it.next();
			}
		}

		return ua;
	}

}