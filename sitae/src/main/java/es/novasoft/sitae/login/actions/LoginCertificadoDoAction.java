package es.novasoft.sitae.login.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.novasoft.comun.constantes.Constantes;
import es.novasoft.comun.struts.ActionBase;

public class LoginCertificadoDoAction extends ActionBase {

	protected Log log = LogFactory.getLog(this.getClass());

	@Override
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * log.debug(Constantes.COMIENZA_METODO);
		 * 
		 * PerfilService perfilService =(PerfilService)
		 * Factory.getBean(ServiceConstants.PERFIL_SERVICIO_BEAN_NAME);
		 * RelPerfFuncService relPerfFuncService =(RelPerfFuncService)
		 * Factory.getBean(ServiceConstants.REL_PERF_FUNC_BEAN_NAME);
		 * FuncionalidadService funcionalidadService =(FuncionalidadService)
		 * Factory.getBean(ServiceConstants.FUNCIONALIDAD_BEAN_NAME);
		 * 
		 * LoginCertificadoForm formulario = (LoginCertificadoForm)
		 * request.getSession().getAttribute("LoginCertificadoForm"); String
		 * nombrePerfil = formulario.getOpcionPerfil();
		 * 
		 * Perfil perfil = (Perfil)
		 * perfilService.findByNombre(nombrePerfil).get(0); Integer idPerfil =
		 * perfil.getIdPerfil();
		 * 
		 * List listaRelPerfFunc = relPerfFuncService.findByPerfil(idPerfil);
		 * List listaFuncionalidad = new ArrayList<Funcionalidad>();
		 * 
		 * Iterator it = listaRelPerfFunc.iterator();
		 * 
		 * while (it.hasNext()){
		 * 
		 * RelPerfFunc relPerfFunc = (RelPerfFunc) it.next(); Funcionalidad
		 * funcionalidad =
		 * funcionalidadService.findById(relPerfFunc.getFuncionalidad().getIdFuncionalidad());
		 * listaFuncionalidad.add(funcionalidad); }
		 * 
		 * formulario.setListaFuncionalidad(listaFuncionalidad);
		 * 
		 * if(request.getParameter("volver")!=null){ String volver = "1";
		 * request.getSession().setAttribute("volver", volver); }
		 * 
		 * //Guardamos en la session el cif para luego al trabajar con el edicto
		 * ver con quien entramos
		 * //request.getSession().setAttribute("idPerfil", idPerfil.toString());
		 * request.getSession().setAttribute("cif",
		 * formulario.getOpcionOrganismo());
		 */
		return mapping.findForward(Constantes.PANTALLA_INICIO);

		/*
		 * try{ log.debug("INICIO LoginCertificadoDoAction2");
		 * 
		 * String target = Constantes.FORWARD_SUCCESS; String nif = ""; String
		 * nombre = ""; String apellido1 = ""; String apellido2 = ""; String
		 * nombreEntidad = ""; String cifEntidad = ""; String email = ""; String
		 * ca = ""; String tipoAfirma =""; String anagrama = ""; String
		 * tipoCertificado =""; String nombreYApellidosRepresentado = ""; String
		 * nifRepresentado = ""; String pais = ""; String provincia = ""; String
		 * poblacion = ""; String caducidad = "";
		 * 
		 * 
		 * String sClave =
		 * ConstantesFirma.getPropiedad(ConstantesFirma.CERTIFICADO_TRIPLEDESKEY);
		 * log.debug("sClave: " + sClave); String sDatos =
		 * (String)request.getParameter("datos"); log.debug("sDatos: " +
		 * sDatos); HashMap valores = decryptAuthenticationValues(sClave,
		 * sDatos); log.debug("DEBUG: Datos Desencriptados con �xito"); int
		 * error = Integer.parseInt((String)valores.get("ERROR"));
		 * 
		 * if(error > 0) { String motivo = getErrorMensaje(error); if(motivo !=
		 * null && !motivo.equals("")) throw new Exception(motivo); else throw
		 * new Exception("Error desconocido en autenticaci\363n."); }
		 * log.info("Comprobando los ID\264s de sessi\363n...");
		 * 
		 * log.info("idSession: " + request.getSession().getId()); String
		 * idSession = request.getSession().getId(); if(idSession != null &&
		 * !idSession.equals("")) { String idSessionAutenticacion =
		 * (String)valores.get("IDSESSION"); log.info("idSessionAutenticacion: " +
		 * idSessionAutenticacion); if(idSessionAutenticacion != null &&
		 * !idSessionAutenticacion.equals("") &&
		 * idSessionAutenticacion.equals(idSession)){ log.info("La sesiones de
		 * la aplicaci\363n y de la autenticaci\363n son coincidentes,
		 * autenticaci\363n correcta."); } else { throw new Exception("Los
		 * ID\264s de sesi\363n no son coincidentes, acceda al proceso de
		 * autenticaci\363n desde la pantalla de bienvenida de la
		 * aplicaci\363n."); } } else { throw new Exception("Acceso indebido en
		 * el proceso de autenticaci\363n, acceda al proceso de autenticaci\363n
		 * desde la pantalla de bienvenida de la aplicaci\363n."); }
		 * log.info("Parseando valores del hashMap al Bean..."); ca =
		 * (String)valores.get("CA"); tipoAfirma =
		 * (String)valores.get("TIPOAFIRMA"); nombre =
		 * (String)valores.get("NOMBRE"); apellido1 =
		 * (String)valores.get("APELLIDO1"); apellido2 =
		 * (String)valores.get("APELLIDO2"); nif = (String)valores.get("NIF");
		 * anagrama = (String)valores.get("ANAGRAMA"); email =
		 * (String)valores.get("EMAIL"); tipoCertificado =
		 * (String)valores.get("TIPOCERTIFICADO"); nombreEntidad =
		 * (String)valores.get("razonSocial"); cifEntidad =
		 * (String)valores.get("CIFENTIDAD"); nombreYApellidosRepresentado =
		 * (String)valores.get("NOMBREYAPELLIDOSREPRESENTADO"); nifRepresentado =
		 * (String)valores.get("NIFREPRESENTADO"); pais =
		 * (String)valores.get("PAIS"); provincia =
		 * (String)valores.get("PROVINCIA"); poblacion =
		 * (String)valores.get("POBLACION"); caducidad =
		 * (String)valores.get("CADUCIDAD"); String sfecCre =
		 * (String)valores.get("FECHACREACION");
		 * 
		 * log.debug("Valores obtenidos desde Certificado.... "); log.debug("
		 * NOMBRE: " + valores.get("NOMBRE")); log.debug(" APELLIDO1: " +
		 * valores.get("APELLIDO1")); log.debug(" NIF: " + valores.get("NIF"));
		 * log.debug(" ANAGRAMA: " + valores.get("ANAGRAMA")); log.debug("
		 * NOMBREENTIDAD: " + valores.get("razonSocial")); log.debug("
		 * CIFENTIDAD: " + valores.get("CIFENTIDAD")); log.debug(" IDSESSION: " +
		 * valores.get("IDSESSION"));
		 * 
		 * log.info("Valores parseados del hashMap al Bean con \351xito.");
		 * if(error != 0) { target = Constantes.FORWARD_FAILURE; return
		 * mapping.findForward(target); } log.info("Autenticaci\363n completa
		 * del usuario realizada con \351xito.");
		 * 
		 * //INTRODUCIMOS EL USUARIO DEL CERTIFICADO EN SESSION PARA COMPROBAR
		 * QUE SE PUEDE EJECUTAR FIRM@ log.debug("El proceso de logado por
		 * certificado es correcto"); HttpSession sesion = request.getSession();
		 * SessionBean sessionBean = new SessionBean(); List lista =
		 * sessionBean.getLista(); UsuarioAutentificado usuarioAutentificado =
		 * new UsuarioAutentificado(); usuarioAutentificado.setNombre(nombre);
		 * usuarioAutentificado.setDni(nif);
		 * usuarioAutentificado.setPrimerapellido(apellido1);
		 * usuarioAutentificado.setSegundoapellido(apellido2);
		 * usuarioAutentificado.setCifEntidad(cifEntidad);
		 * usuarioAutentificado.setNombreEntidad(nombreEntidad);
		 * usuarioAutentificado.setAnagrama(anagrama);
		 * lista.add(usuarioAutentificado); lista.add(sesion.getId());
		 * sessionBean.setLista(lista);
		 * sesion.setAttribute(ConstantesFirma.SESSION_BEAN_FIRMA, sessionBean);
		 * String sessionID = request.getSession().getId();
		 * 
		 * String usuario; if(cifEntidad!=null && !cifEntidad.equals(""))
		 * usuario=nombreEntidad; else usuario = nombre + " " + apellido1 + " " +
		 * apellido2;
		 * 
		 * request.getSession().setAttribute("nombreUsuario", usuario);
		 * 
		 * log.debug(sessionID + "Al salir de FIRM@");
		 * log.debug(Constantes.TERMINA_METODO);
		 * 
		 * //COMPRUEBO QUE EL USUARIO ESTA DADO DE ALTA EN NUESTRA BBDD try{ if
		 * (!isRegistradoBBDD(usuarioAutentificado)){ return
		 * mapping.findForward(ActionBase.ALTA_USER); }
		 * 
		 * }catch (Exception e) { e.printStackTrace(); log.error("Error en
		 * LoginCertificadoDo",e); return forward(request, mapping,
		 * ActionBase.ERROR_KEY); } //FIN COMPROBACION
		 * 
		 * String s = sesion.getAttribute("red").toString();//NUEVO return
		 * mapping.findForward(s); } catch(Exception e) { log.error(e);
		 * 
		 * request.setAttribute("error","Se ha producido un error en la
		 * autenticaci�n:"+e.getMessage()); log.error(e.getCause());
		 * log.error(e.getStackTrace()); return
		 * mapping.findForward(Constantes.FORWARD_FAILURE); }
		 */

		/*
		 * HttpSession sesion = request.getSession(); String s =
		 * sesion.getAttribute("funcion").toString();//NUEVO return
		 * mapping.findForward(s);
		 */
	}

	/**
	 * Rellena el array de bytes con decode
	 * 
	 * @param tokentripledeskey
	 * @param TRIPLEDESKEY
	 * @param cont
	 * @return
	 */
	/*
	 * private int rellenarConDecode(StringTokenizer tokentripledeskey, byte[]
	 * TRIPLEDESKEY, int cont) { while (tokentripledeskey.hasMoreTokens()) {
	 * String token = tokentripledeskey.nextToken(); token = token.trim(); //
	 * int hexadecimal=Integer.valueOf(token); log.debug("El valor del token
	 * es:" + token); TRIPLEDESKEY[cont] = Byte.decode(token).byteValue();
	 * cont++; } return cont; }
	 */

	/*
	 * private HashMap decryptAuthenticationValues(String sClave, String sDatos)
	 * throws Exception{ HashMap valores = new HashMap(); byte TRIPLEDESKEY[] =
	 * StringParser.claveAutenticacionStringToByte(sClave); DESedeKeySpec
	 * deskeySpec = new DESedeKeySpec(TRIPLEDESKEY); SecretKeyFactory kf =
	 * SecretKeyFactory.getInstance("DESede"); log.debug("Antes del SecretKey");
	 * javax.crypto.SecretKey k = kf.generateSecret(deskeySpec);
	 * log.debug("Despu�s del SecretKey"); Cipher cd =
	 * Cipher.getInstance("DESede"); log.debug("Despu�s del cd"); cd.init(2,
	 * k);
	 * 
	 * //BASE64Decoder decoder = new BASE64Decoder(); //log.debug("Antes del
	 * decoder"); //byte dLimpios[] = cd.doFinal(decoder.decodeBuffer(sDatos));
	 * //log.debug("Despu�s del decoder"); //String sLimpios = new
	 * String(dLimpios);
	 * 
	 * //DECODIFICAR DesEncrypter utf8 = new DesEncrypter(); String sLimpios =
	 * utf8.decrypt(sDatos);
	 * 
	 * log.debug("DEBUG:"+sLimpios); String pares[] = sLimpios.split(";");
	 * for(int i = 0; i < pares.length; i++) { String paresValores[] =
	 * pares[i].split(":"); if(i == 0 && paresValores.length == 1) {
	 * log.info("ERROR:" + paresValores[0]); valores.put("ERROR",
	 * paresValores[0]); } else if(paresValores.length > 0)
	 * if(paresValores.length > 1) { log.info(paresValores[0] + ":" +
	 * paresValores[1]); valores.put(paresValores[0], paresValores[1]); } else {
	 * log.info(paresValores[0]); valores.put("IDSESSION", paresValores[0]); } }
	 * 
	 * return valores;
	 * 
	 *  } private String getErrorMensaje(int error) { String motivo = "";
	 * switch(error) { case 6: // '\006' motivo = "Error al obtener el
	 * IDentificador o el NIF"; break;
	 * 
	 * case 7: // '\007' motivo = "Error al obtener el NIF"; break;
	 * 
	 * case 8: // '\b' motivo = "Por motivos de seguridad, s\363lo se permite
	 * una entrada por sesi\363n de navegador"; break;
	 * 
	 * case 9: // '\t' motivo = "Por motivos de seguridad, s\363lo se permite
	 * una entrada por sesi\363n de navegador"; break;
	 * 
	 * case 11: // '\013' motivo = "Algoritmo de firma en certificado de cliente
	 * inv\341lido"; break;
	 * 
	 * case 12: // '\f' motivo = "Clave en certificado cliente no v\341lida";
	 * break;
	 * 
	 * case 13: // '\r' motivo = "Proveedor de certificado cliente no
	 * encontrado"; break;
	 * 
	 * case 14: // '\016' motivo = "Error al comprobar la firma del certificado
	 * de cliente"; break;
	 * 
	 * case 15: // '\017' motivo = "Error al obtener los campos obligatorios del
	 * certificado"; break;
	 * 
	 * case 16: // '\020' motivo = "No se ha encontrado el certificado de la CA
	 * de este certificado"; break;
	 * 
	 * case 17: // '\021' motivo = "No se ha construido el objeto de forma
	 * correcta"; break;
	 * 
	 * case 18: // '\022' motivo = "Error al chequear la fecha del certificado";
	 * break;
	 * 
	 * case 19: // '\023' motivo = "No se ha encontrado la CRL"; break;
	 * 
	 * case 20: // '\024' motivo = "Error al descargar la CRL"; break;
	 * 
	 * case 21: // '\025' motivo = "Error al verificar la crl con el certificado
	 * de su CA"; break;
	 * 
	 * case 22: // '\026' motivo = "No se ha encontrado el certificado de la CA
	 * de esta CRL"; break;
	 * 
	 * case 23: // '\027' motivo = "Error al crear el objecto X09CRL"; break;
	 * 
	 * case 24: // '\030' motivo = "Certificado revocado"; break;
	 * 
	 * case 25: // '\031' motivo = "Certificado revocado, clave comprometida";
	 * break;
	 * 
	 * case 26: // '\032' motivo = "Certificado revocado, clave CA
	 * comprometida"; break;
	 * 
	 * case 27: // '\033' motivo = "Certificado revocado, cambio
	 * informaci\363n"; break;
	 * 
	 * case 28: // '\034' motivo = "Certificado revocado, certificado
	 * reemplazado"; break;
	 * 
	 * case 29: // '\035' motivo = "Certificado revocado, prop\363sito original
	 * del certificado ya no v\341lido"; break;
	 * 
	 * case 30: // '\036' motivo = "Certificado revocado, certificado suspendido
	 * temporalmente"; break;
	 * 
	 * case 31: // '\037' motivo = "Certificado revocado, el certificado debe
	 * ser removido de una CRL anterior"; break;
	 * 
	 * case 32: // ' ' motivo = "Certificado revocado, un privilegio del
	 * certificaso ha sido retirado"; break;
	 * 
	 * case 33: // '!' motivo = "Certificado revocado, AA compretida"; break;
	 * 
	 * case 34: // '"' motivo = "Certificado sin puntos de distribuci\363n de
	 * CRL"; break;
	 * 
	 * case 35: // '#' motivo = "No tiene puesto de trabajo asignado"; break; }
	 * return motivo; }
	 */

	/*
	 * private boolean isRegistradoBBDD(UsuarioAutentificado ciudadano){
	 * 
	 * MasterDatosPersonalesService masterDatosPersonalesService =
	 * (MasterDatosPersonalesService)
	 * Factory.getBean(ServiceConstants.MASTER_DATOS_PERSONALES_SERVICIO_BEAN_NAME);
	 * 
	 * List<MasterDatosPersonales> solicitantes = new LinkedList<MasterDatosPersonales>();
	 * List<MasterDatosPersonales> representantes = new LinkedList<MasterDatosPersonales>();
	 * 
	 * try {
	 * 
	 * //SI ENTRAMOS CON CIF DE EMPRESA RELLENAMOS COMO SOLICITANTE LA EMPRESA Y
	 * REPRESENTANTE EL USUARIO ASOCIADO if
	 * ((ciudadano.getCifEntidad()!=null)&&!(ciudadano.getCifEntidad().equals("
	 * "))){ solicitantes =
	 * masterDatosPersonalesService.findByNumeroDocumento(ciudadano.getCifEntidad());
	 * representantes =
	 * masterDatosPersonalesService.findByNumeroDocumento(ciudadano.getDni());
	 * 
	 * //EN CASO CONTRARIO SOLO RELLENAMOS EL SOLICITANTE }else{ solicitantes =
	 * masterDatosPersonalesService.findByNumeroDocumento(ciudadano.getDni()); }
	 * 
	 * //COMPRUEBO SI EXISTE EL USUARIO PARA DARLE DE ALTA O NO. SI EL
	 * SOLICITANTE EXISTE, COMPROBAMOS EL REPRESENTANTE SI LO HUBIESE if
	 * (!solicitantes.isEmpty()){ if
	 * ((ciudadano.getCifEntidad()!=null)&&!(ciudadano.getCifEntidad().equals("
	 * "))){ if (!representantes.isEmpty()){ return true; }else{ return false; } }
	 * return true; }else{ return false; }
	 *  } catch (ServiceException e) { log.error("Se ha producido un error al
	 * recuperar datos de la BBDD"); log.error(e.getCause()); return false; }
	 * catch (Exception e) { log.error("Se ha producido un error al recuperar
	 * datos de la BBDD"); log.error(e.getCause()); return false; } }
	 */

}
