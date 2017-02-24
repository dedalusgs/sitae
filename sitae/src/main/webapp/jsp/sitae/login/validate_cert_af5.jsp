		   
<jsp:directive.page import="java.util.Locale"/>
<jsp:directive.page import="java.io.FileNotFoundException"/>
<jsp:directive.page import="java.util.Properties"/>
<jsp:directive.page import="es.novasoft.comun.struts.ActionBase"/>
<jsp:directive.page import="org.apache.commons.logging.LogFactory"/>
<jsp:directive.page import="java.io.InputStream"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page pageEncoding="ISO-8859-1" %>

<%@ page import="org.opencms.firma.*" %>
<%@ page import="org.opencms.arrobafirma5.*" %>
<%@ page import="org.apache.commons.logging.Log" %>
<%--<%@ page import="es.cice.plataformaintegracion.Tramitacion.GestionFlujos.Interesado.servicios.CGFException" %>--%>
<%@ page import="javax.xml.rpc.ServiceException" %>

<%@page import="java.io.StringReader"%>
<%@page import="javax.xml.bind.JAXBContext"%>
<%@page import="javax.xml.bind.Unmarshaller"%>
<%@page import="javax.xml.rpc.ServiceException"%>

<%		//************************* Obtenemos fichero de properties para conexión con @firma
		
		Log log = LogFactory.getLog(ActionBase.class);
				
		String uri=(String)request.getParameter("uri");

	 	String prop=null;
	 			
		  
  	try {
   		InputStream is = (this.getClass().getResourceAsStream("/conf/configuracion.properties"));
   		prop=is.toString();
      		
   		InfoData data=new InfoData(prop);
   		
//		String endpoint=data.getData("endpoint5");
//		String timeout=data.getData("timeout5");
   		
	}catch(Exception f){

	}

		//************************* Certificado Digital
		String firma = request.getParameter("fichero");
		
		//**********************Obtención del idioma*****************************//
		
		//-- Validamos el UUID
		String loginUUID = (String)request.getSession().getAttribute("loginUUID");
		String uuid = request.getParameter("uuid");
		
		if (!loginUUID.equals(uuid)){
			request.getSession().setAttribute("valuerror","valor del error"); //OJOOOO!!!
         	request.getSession().setAttribute("causerror","CAUSA DEL ERROR");  	//OJOOO!!!
         	%>
         	<c:redirect url="./error.jsp"/> 
         	<%
		}
		
		//************************* Llamada a Web Service
		Object result = null;
		InfoCert info=null;
		String motivo = "Error no especificado";
		
		try {    
		    arrobaFirma5Cliente af5c = new arrobaFirma5Cliente(prop);
		    String cert = af5c.validarFirma(firma, uuid);
		    
		    if (cert == null){
		    	request.getSession().setAttribute("valuerror","valor del error"); //OJOOOO!!!
         		request.getSession().setAttribute("causerror","CAUSA DEL ERROR");  	//OJOOO!!!
         		%>
         			<c:redirect url="./error.jsp"/> 
         		<%
		    }
		    
		    result = af5c.ValidarCertificado(cert);
			
//////////////////////////////////////////////////////////////////////////////////
		    /// AUTENTICACION MANUAL (DESCOMENTAR CUANDO SE QUIERA UTILIZAR)   ///
		    /// (Y COMENTAR LA LINEA result = af5c.ValidarCertificado(cert); ) ///
		    //////////////////////////////////////////////////////////////////////
		    //info = new InfoCert();
		    //info.setNif("12345678Z");
		    //info.setNombre("Juan");
		    //info.setApellido1("Pérez");
		    //info.setApellido2("Gutierrez");
		    //info.setEmail("");
		    //info.setCa("FNMT");
		    //info.setTipocertificado("FNMT PF");
		    //info.setFechacreacion("2008-02-13 mié 19:29:45 +0100");
		    //info.setFechacaducidad("2011-02-13 dom 19:29:45 +0100");
		    //info.setTipoafirma("0");
		    //result = info;
		    ///////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
		    
			if (result != null) {
				if (result instanceof InfoCert){ //Autenticacion OK
					info = (InfoCert)result;
					
					
					//END - EMB - numero de notificaciones en session
				}
				else if(result instanceof String){ //Autenticacion NO OK
					motivo = (String)result;
					log.error(motivo);
					request.getSession().setAttribute("valuerror","valor del error"); //OJOOOO!!!
         		request.getSession().setAttribute("causerror","CAUSA DEL ERROR");  	//OJOOO!!!
         		%>
         			<c:redirect url="./error.jsp"/> 
         		<%
			}
			}
			else { //Peticion no valida a @firma
				log.error("Petición no válida realizada a arrobafirma:");
				request.getSession().setAttribute("valuerror","valor del error"); //OJOOOO!!!
         		request.getSession().setAttribute("causerror","CAUSA DEL ERROR");  	//OJOOO!!!
         		%>
         			<c:redirect url="./error.jsp"/> 
         		<%
			}

		} catch (Exception e) {
			 
				log.error("Error de conexion con servidor de autenticación de firma digital:"+e);
				request.getSession().setAttribute("valuerror","valor del error"); //OJOOOO!!!
         		request.getSession().setAttribute("causerror","CAUSA DEL ERROR");  	//OJOOO!!!
         		%>
         			<c:redirect url="./error.jsp"/> 
         		<% 			
		} 
%>


		   