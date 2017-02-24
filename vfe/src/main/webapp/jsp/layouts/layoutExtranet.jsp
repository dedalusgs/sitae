<%@ page contentType="text/html" pageEncoding="ISO-8859-15"
	language="java"%>
<jsp:directive.page import="org.apache.axis.encoding.Base64" />
<jsp:directive.page import="java.util.UUID" />
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.Locale, org.apache.struts.Globals"%>
<%@page import="es.novasoft.castellon.vfe.business.objects.Organismo"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html:html xhtml="true" >
<head>

	<link rel="shortcut icon" href="img/favicon.ico"/>
	<!-- HTTP 1.1 -->
	<meta http-equiv="Cache-Control" content="no-store" />
	<!-- HTTP 1.0 -->
	<meta http-equiv="Pragma" content="no-cache" />
	
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
    
    <!-- Estilos para SITAE -->
    <link href="css/estilos.css" rel="stylesheet" type="text/css" media="screen" />	
    
	<link href="css/calendar-green.css" rel="stylesheet" type="text/css" media="all"/>

	<% Organismo organismoVisualizar = (Organismo)session.getAttribute("organismoSesion"); %>
	<%if(organismoVisualizar != null){%>
		<link href="css/<%=organismoVisualizar.getTema() %>/color.css" rel="stylesheet" type="text/css" media="screen" />
	<%}else{%>
		<link href="css/verde/color.css" rel="stylesheet" type="text/css" media="screen" />
	<%}%>	
		
	<!-- Javascript -->
		
	<script src="js/main.js" type="text/javascript"></script>
	
	
	<link rel="stylesheet" href="js/jquery-tooltip/jquery.tooltip.css" />	
	<script src="js/jquery-tooltip/lib/jquery.js" type="text/javascript"></script>
	<script src="js/jquery-tooltip/lib/jquery.bgiframe.js" type="text/javascript"></script>
	<script src="js/jquery-tooltip/lib/jquery.dimensions.js" type="text/javascript"></script>
	<script src="js/jquery-tooltip/jquery.tooltip.js" type="text/javascript"></script>
	
	
	<!-- Utilidades -->
  	<script type="text/javascript" src="js/utilities.js"></script>
	
	<!-- main calendar program -->
  	<script type="text/javascript" src="js/calendar.js"></script>
  	
	<!-- language for the calendar -->  
	
	<% Locale locale = (Locale)session.getAttribute(Globals.LOCALE_KEY); %>
	
	<% if (locale!=null){ %>	
		<%if(locale.getLanguage().equals("va")){%>	
		  	<script type="text/javascript" src="js/calendar-va.js"></script>
		<%}else {%>
			<script type="text/javascript" src="js/calendar-es.js"></script>
		<%}%>	  
	<%}%>
  
  	<script type="text/javascript" src="js/calendar-setup.js"></script>

    <title>VFE. Verificador de Firma Electrónica</title>
    
</head>

<body>

<div id="container">
		
		<tiles:insert name="top"/>
				
		<tiles:insert name="cabecera"/>
					
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
			</div>	
         	<hr class="display-no" />
              
			<div id="contenido_central">
												
			<tiles:insert name="cuerpo"/>
			
			</div>
    
	</div>
    <hr class="display-no" /> 						
	<div id="pie">	
		<tiles:insert name="pie"/>			    
	</div>
	
</div>

</body>
</html:html>

				

