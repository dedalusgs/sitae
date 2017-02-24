<%@ page contentType="text/html"
    pageEncoding="UTF-8" language="java"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<ul id="breadcrumbs">
		<% String servicioNavegacion = (String)session.getAttribute("idServicioNavegacion"); %>
		<% String grupoNavegacion = (String)session.getAttribute("idGrupoNavegacion");%>		
		<% if(servicioNavegacion==null){ servicioNavegacion= "-1";}%>
		<% if(grupoNavegacion==null){ grupoNavegacion= "-1";}%>		
		<% if( !grupoNavegacion.equals("-1")){%>
			<li class="first"><a title='<bean:message key="servicio.inicio" bundle="resources"/>' href="./InitDoAction.do?servicioNavegacion=-1&grupoNavegacion=-1"><bean:message key="servicio.inicio" bundle="resources"/></a></li>						
			<% if(grupoNavegacion.equals("0")){%>
				<li><bean:message key="servicio.edictos" bundle="resources"/></li>
			<% } %>
			<% if(grupoNavegacion.equals("1")){%>
				<li><bean:message key="comun.AdmGlobal" bundle="resources"/></li>				
			<% } %>			
			<% if(grupoNavegacion.equals("2")){%>
				<li><bean:message key="comun.AdmLocal" bundle="resources"/></li>
			<% } %>			
			<% if(grupoNavegacion.equals("3")){%>
				<li><bean:message key="comun.publicador" bundle="resources"/></li>
			<% } %>
			<% if(grupoNavegacion.equals("4")){%>
				<li><bean:message key="comun.redactor" bundle="resources"/></li>
			<% } %>
		<% } else { %>
			<li class="first"><a href="#"><bean:message key="servicio.inicio" bundle="resources"/></a></li>			
		<% } %>											
</ul>
<% if( !servicioNavegacion.equals("-1")){%>	
	<% if(servicioNavegacion.equals("-2")){%>
		<h2 class="tit_certificat"><bean:message key="servicio.edictosVigor" bundle="resources"/></h2>	
	<% } %>
	<% if(servicioNavegacion.equals("-3")){%>
		<h2 class="tit_certificat"><bean:message key="servicio.historicoEdictos" bundle="resources"/></h2>	
	<% } %>
	<% if(servicioNavegacion.equals("-4")){%>
		<h2 class="tit_certificat"><bean:message key="servicio.busquedaAvanzada" bundle="resources"/></h2>	
	<% } %>	
	
	<% if(servicioNavegacion.equals("1")){%>
		<h2 class="tit_certificat"><bean:message key="servicio.gestionAdministradoresLocales" bundle="resources"/></h2>	
	<% } %>
	<% if(servicioNavegacion.equals("10")){%>
		<h2 class="tit_certificat"><bean:message key="servicio.descagarDoc" bundle="resources"/></h2>	
	<% } %>
	<% if(servicioNavegacion.equals("2")){%>
		<h2 class="tit_certificat"><bean:message key="servicio.gestionOrganismos" bundle="resources"/></h2>	
	<% } %>
	<% if(servicioNavegacion.equals("81")){%>
		<h2 class="tit_certificat"><bean:message key="servicio.gestionOrganismosExternos" bundle="resources"/></h2>	
	<% } %>
	
	
	<% if(servicioNavegacion.equals("6")){%>
		<h2 class="tit_certificat"><bean:message key="servicio.misRedacciones" bundle="resources"/></h2>	
	<% } %>
	<% if(servicioNavegacion.equals("5")){%>
		<h2 class="tit_certificat"><bean:message key="servicio.misPublicaciones" bundle="resources"/></h2>	
	<% } %>
	
	<% if(servicioNavegacion.equals("41")){%>
		<h2 class="tit_certificat"><bean:message key="servicio.publicacionesSinAsignar" bundle="resources"/></h2>	
	<% } %>
	
	<% if(servicioNavegacion.equals("3")){%>
		<h2 class="tit_certificat"><bean:message key="servicio.gestionUsuarios" bundle="resources"/></h2>	
	<% } %>
	
	<% if(servicioNavegacion.equals("7")){%>
		<h2 class="tit_certificat"><bean:message key="servicio.gestionCentrosProcedencia" bundle="resources"/></h2>	
	<% } %>
	<% if(servicioNavegacion.equals("61")){%>
		<h2 class="tit_certificat"><bean:message key="servicio.gestionTiposEdictos" bundle="resources"/></h2>	
	<% } %>
	<% if(servicioNavegacion.equals("101")){%>
		<h2 class="tit_certificat"><bean:message key="servicio.gestionUsuariosFirmantes" bundle="resources"/></h2>	
	<% } %>
	<% if(servicioNavegacion.equals("-20")){%>
		<h2 class="tit_certificat"><bean:message key="servicio.gestionEdictos" bundle="resources"/></h2>	
	<% } %>	
	<% if(servicioNavegacion.equals("-30")){%>
		<h2 class="tit_certificat"><bean:message key="servicio.contacto" bundle="resources"/></h2>	
	<% } %>
	<% if(servicioNavegacion.equals("-31")){%>
		<h2 class="tit_certificat"><bean:message key="servicio.ayuda" bundle="resources"/></h2>	
	<% } %>
	<% if(servicioNavegacion.equals("-32")){%>
		<h2 class="tit_certificat"><bean:message key="servicio.mapaWeb" bundle="resources"/></h2>	
	<% } %>		
	<% if(servicioNavegacion.equals("-33")){%>
		<h2 class="tit_certificat"><bean:message key="servicio.accesibilidad" bundle="resources"/></h2>	
	<% } %>
	<% if(servicioNavegacion.equals("-34")){%>
		<h2 class="tit_certificat"><bean:message key="servicio.avisoLegal" bundle="resources"/></h2>	
	<% } %>
	<% if(servicioNavegacion.equals("-35")){%>
		<h2 class="tit_certificat"><bean:message key="servicio.acercaDe" bundle="resources"/></h2>	
	<% } %>
<% } else { %>
	<h2 class="tit_certificat">&nbsp;</h2>
<% } %>
