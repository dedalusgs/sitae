<%@ page contentType="text/html" pageEncoding="ISO-8859-15"
	language="java"%>
<jsp:directive.page import="org.apache.axis.encoding.Base64" />
<jsp:directive.page import="java.util.UUID" />
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.Locale, org.apache.struts.Globals"%>
<%@page import="es.novasoft.comun.utils.OrganismoVisualizar"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html:html xhtml="true" >
<head>

	<link rel="shortcut icon" href="img/favicon.ico"/>
	<!-- HTTP 1.1 -->
	<meta http-equiv="Cache-Control" content="no-store" />
	<!-- HTTP 1.0 -->
	<meta http-equiv="Pragma" content="no-cache" />
	
<c:if test="${MuestraInformacionEdictoPublicoForm!=null}">

<!-- FACEBOOK -->
<meta content='blog' property='og:type'/>
<meta content='${organismoSesion.dominio}' property='og:site_name'/>
<meta content='${MuestraInformacionEdictoPublicoForm.edicto.titulo}' property='og:title'/>
<!-- <meta expr:content='data:post.url' property='og:url'/>-->
<meta content='${organismoSesion.url}/${organismoSesion.imagen}' property='og:image'/>
<meta content='${MuestraInformacionEdictoPublicoForm.edicto.descripcion}' property='og:description'/>

<!-- TWITTER CARDS -->
<meta content='summary' name='twitter:card'/>
<meta content='@${organismoSesion.twitter.urlUser}' name='twitter:site'/>
<meta content='@${organismoSesion.twitter.urlUser}' name='twitter:creator'/>
<meta content='https://${organismoSesion.dominio}' name='twitter:domain'/>
<meta content='${organismoSesion.url}/MuestraInformacionEdictoPublicoFrontAction.do?accion=busquedaAvanzada&grupoNavegacion=0&servicioNavegacion=-4&idEdictoSeleccionado=${MuestraInformacionEdictoPublicoForm.edicto.idEdicto}' name='twitter:url'/>
<meta content='${MuestraInformacionEdictoPublicoForm.edicto.titulo}' name='twitter:title'/>
<meta content='${MuestraInformacionEdictoPublicoForm.edicto.descripcion}' name='twitter:description'/>


</c:if>
	<!-- Prevents caching at the Proxy Server -->
	
	<meta http-equiv="Expires" content="0" />
	<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-15"/>	
	<meta name="author" content="NovaSoft" />
	
  	<link href="css/index.css" rel="stylesheet" type="text/css" media="screen" />
    <!--[if IE 6]>
        <link rel="stylesheet" type="text/css" href="css/ie6_only.css" />
        <link href="css/IE6.css" rel="stylesheet" type="text/css" />
    <![endif]-->
    <!--[if IE 7]>
        <link rel="stylesheet" type="text/css" href="css/ie7_only.css" />
        <link href="css/IE7.css" rel="stylesheet" type="text/css" />
    <![endif]-->
    <!--[if IE 8]>
        <link href="css/IE8.css" rel="stylesheet" type="text/css" />
    <![endif]-->
    
    <link href="css/index_cas_verde.css" rel="stylesheet" type="text/css" />
    <link href="css/interior.css" rel="stylesheet" type="text/css" />
    <link href="css/template.css" rel="stylesheet" type="text/css" />
    <link href="css/template.css" rel="stylesheet" type="text/css" />
    <!-- Estilos para SITAE -->
    <link href="css/estilos.css" rel="stylesheet" type="text/css" media="screen" />	
    <link href="css/jquery-ui-1.10.3.custom.min.css" rel="stylesheet" type="text/css" media="screen" />	
	<!-- <link href="css/calendar-green.css" rel="stylesheet" type="text/css" media="all"/> -->

	<% OrganismoVisualizar organismoVisualizar = (OrganismoVisualizar)session.getAttribute("organismoSesion");  %>
	<%if(organismoVisualizar != null){%>
		<link href="css/<%=organismoVisualizar.getTema() %>/color.css" rel="stylesheet" type="text/css" media="screen" />
	<%}else{%>
		<link href="css/verde/color.css" rel="stylesheet" type="text/css" media="screen" />
	<%}%>	
		
	<!-- Javascript -->
	<!--	
	<script src="js/main.js" type="text/javascript"></script>
	-->
	
	
	<link rel="stylesheet" href="js/jquery-tooltip/jquery.tooltip.css" />	
	<script src="js/jquery-tooltip/lib/jquery.js" type="text/javascript"></script>
	<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
	<script src="js/jquery-tooltip/lib/jquery.bgiframe.js" type="text/javascript"></script>
	<script src="js/jquery-tooltip/lib/jquery.dimensions.js" type="text/javascript"></script>
	<script src="js/jquery-tooltip/jquery.tooltip.js" type="text/javascript"></script>
	<script src="calendar2/js/jscal2.js"></script>
    <script src="calendar2/js/lang/es.js"></script>
    <link rel="stylesheet" type="text/css" href="calendar2/css/jscal2.css" />
    <link rel="stylesheet" type="text/css" href="calendar2/css/border-radius.css" />

    <script src='dwr/interface/AjaxSitae.js'></script>
    <script src='dwr/engine.js'></script>
	
	<!-- Utilidades -->
  	<script type="text/javascript" src="js/utilities.js"></script>
	<script type="text/javascript" src="js/modal.js"></script>
	<script type="text/javascript">
	$(function() {
		 var dispositivo = navigator.userAgent.toLowerCase();
		 if( dispositivo.search(/iphone|ipod|ipad|android|blackberry|iemobile|opera/) > -1 ){
			 window.location.href="mobile/HomeFrontAction.do";
		 }
		 
	});
		
	</script>
	<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/jquery.cookiecuttr.js"></script>
<link href="js/cookiecuttr.css" rel="stylesheet" type="text/css"/>
	
	<script type="text/javascript">
if(jQuery.cookie("cc_cookie_accept") == "cc_cookie_accept") {
//Código que no queremos que cargue hasta que el usuario acepte. Aquí pondríamos el código de Google Analytics o lo que nos interese.
}
jQuery(document).ready(function () {
    jQuery.cookieCuttr({
      cookieDeclineButton: false,
      cookiePolicyLink: true,
      cookieAnalyticsMessage: "Este sitio web utiliza cookies para que usted tenga la mejor experiencia de usuario. Si continúa navegando está dando su consentimiento para la aceptación de las mencionadas cookies y la aceptación de nuestra política de cookies.",
      cookieAcceptButtonText: "De acuerdo",
      cookieDeclineButtonText: "No acepto",
      cookieWhatAreLinkText: "Más información",
      cookieWhatAreTheyLink: "./ServiciosPortalFrontAction.do?accion=avisoLegal&grupoNavegacion=-1&servicioNavegacion=-34"
    });
  });
</script>
	<!-- main calendar program
  <!--	<script type="text/javascript" src="js/calendar.js"></script>
  	 
	<!-- language for the calendar -->  
	<!--
	<% Locale locale = (Locale)session.getAttribute(Globals.LOCALE_KEY); %>
	
	<% if (locale!=null){ %>	
		<%if(locale.getLanguage().equals("va")){%>	
		  	<script type="text/javascript" src="js/calendar-va.js"></script>
		<%}else {%>
			<script type="text/javascript" src="js/calendar-es.js"></script>
		<%}%>	  
	<%}%>
  
  	<script type="text/javascript" src="js/calendar-setup.js"></script>
-->
    <title><tiles:getAsString name="titulo"/></title>
    
</head>

<body>

<div id="container">
		
		<tiles:insert name="top"/>
				
		<tiles:insert name="cabecera"/>
				
				<tiles:insert name="scripts"/>	
		<div id="contenido">        	
			<div id="contenido-menu">
				<tiles:insert name="botonera"/>					            
			</div>
		
			<div id="contenido-cuerpo">
				<div id="titular">
					<tiles:insert name="migaDePan"/>					
				</div>	
   				<hr class="display-no" />    		
	    		<div id="sidebar-left">	    				
	         	<tiles:insert name="menuPublico"/>
	         	<tiles:insert name="menuAdministracion"/>	         
			</div>	
         	<hr class="display-no" />
              
			<div id="contenido_central">
			<div id="redesSociales">
			<a href="./AltaSuscripcionFront.do?grupoNavegacion=5&servicioNavegacion=-5"  title="<bean:message key="redesSociales.listacorreo.siga" bundle="resources"/>"><img src="./images/email-32.png" ></img></a>
			<c:if test="${not empty organismoSesion.facebook}" >
					<a href="${organismoSesion.facebook.urlUser}"  target="_blank" title="<bean:message key="redesSociales.facebook.siga" bundle="resources"/>"><img src="images/facebook-32.png" ></img></a>
			</c:if>
			<c:if test="${not empty organismoSesion.twitter}" >
				<a href="https://twitter.com/${organismoSesion.twitter.urlUser}" target="_blank" title="<bean:message key="redesSociales.twitter.siga" bundle="resources"/>"><img src="images/twitter-32.png" ></img></a>
			</c:if>
			<c:if test="${not empty organismoSesion.google}" >
				<a href="${organismoSesion.google.urlUser}" target="_blank" title="<bean:message key="redesSociales.google.siga" bundle="resources"/>"><img src="images/google+-32.png" ></img></a>
			</c:if>
			
			
			</div>				
			<% String grupoNavegacion = (String)session.getAttribute("idGrupoNavegacion");%>					
			<% if(grupoNavegacion==null){ grupoNavegacion= "-1";}%>		
			<% if( !grupoNavegacion.equals("-1")){%>												
				<% if(grupoNavegacion.equals("0")){%>					
					<h2><bean:message key="servicio.edictos" bundle="resources"/></h2>	
				<% } %>
				<% if(grupoNavegacion.equals("1")){%>
					<h2><bean:message key="comun.AdmGlobal" bundle="resources"/></h2>					
				<% } %>			
				<% if(grupoNavegacion.equals("2")){%>
					<h2><bean:message key="comun.AdmLocal" bundle="resources"/></h2>	
				<% } %>			
				<% if(grupoNavegacion.equals("3")){%>
					<h2><bean:message key="comun.publicador" bundle="resources"/></h2>	
				<% } %>
				<% if(grupoNavegacion.equals("4")){%>
					<h2><bean:message key="comun.redactor" bundle="resources"/></h2>
				<% } %> 
				<% if(grupoNavegacion.equals("5")){%>
					<h2><bean:message key="listaCorreo.titulo" bundle="resources"/></h2>
				<% } %>
			<% } else { %>
					<h2><bean:message key="servicio.inicio" bundle="resources"/></h2>	
			<% } %>													
				<tiles:insert name="cuerpo"/>
			</div>
    
	</div>
    <hr class="display-no" /> 						
	<div id="pie">	
		<tiles:insert name="pie"/>			    
	</div>
	
</div>
	  		    
		<%
				if (session.getAttribute("loginUUID") == null) {
				String uuid = Base64.encode(UUID.randomUUID().toString()
				.getBytes());
				request.getSession().setAttribute("loginUUID", uuid);
			}
		%>
		

</body>
</html:html>

				

