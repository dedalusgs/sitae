<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="es.novasoft.comun.utils.OrganismoVisualizar"%>
	
				<div id="mapa-web">
						<h3><a title='<bean:message key="servicio.inicio" bundle="resources"/>' href="./InitDoAction.do?servicioNavegacion=-1&grupoNavegacion=-1"><bean:message key="servicio.inicio" bundle="resources"/></a></h3>
						<ul>

							<li class="first"><a href="ServiciosPortalFrontAction.do?accion=contacto&grupoNavegacion=-2&servicioNavegacion=-30" title='<bean:message key="servicio.contacto" bundle="resources"/>'><bean:message key="servicio.contacto" bundle="resources"/></a></li>
							<li><a href="#" title='<bean:message key="servicio.ayuda" bundle="resources"/>'><bean:message key="servicio.ayuda" bundle="resources"/></a></li>									
							<li><a href="ServiciosPortalFrontAction.do?accion=mapaWeb&grupoNavegacion=-2&servicioNavegacion=-32" title='<bean:message key="servicio.mapaWeb" bundle="resources"/>'><bean:message key="servicio.mapaWeb" bundle="resources"/></a></li>
							<li><a href="ServiciosPortalFrontAction.do?accion=accesibilidad&grupoNavegacion=-2&servicioNavegacion=-33" title='<bean:message key="servicio.accesibilidad" bundle="resources"/>'><bean:message key="servicio.accesibilidad" bundle="resources"/></a></li>
							<li><a href="ServiciosPortalFrontAction.do?accion=avisoLegal&grupoNavegacion=-2&servicioNavegacion=-34" title='<bean:message key="servicio.avisoLegal" bundle="resources"/>'><bean:message key="servicio.avisoLegal" bundle="resources"/></a></li>
							<li><a href="ServiciosPortalFrontAction.do?accion=acercaDe&grupoNavegacion=-2&servicioNavegacion=-35" title='<bean:message key="servicio.acercaDe" bundle="resources"/>'><bean:message key="servicio.acercaDe" bundle="resources"/></a></li>	
						</ul>

						<h3><a title='<bean:message key="servicio.edictos" bundle="resources"/>' href="#"><bean:message key="servicio.edictos" bundle="resources"/></a></h3>
						<ul>
							<li><a title='<bean:message key="servicio.edictosVigor" bundle="resources"/>' href="VisualizarEdictoPublicoFrontAction.do?accion=edictosVigor&grupoNavegacion=0&servicioNavegacion=-2"><bean:message key="servicio.edictosVigor" bundle="resources"/></a></li>
			           		<li><a title='<bean:message key="servicio.historicoEdictos" bundle="resources"/>' href="VisualizarEdictoPublicoFrontAction.do?accion=historicoEdictos&filtrar=s&grupoNavegacion=0&servicioNavegacion=-3"><bean:message key="servicio.historicoEdictos" bundle="resources"/></a></li>
	    		       		<li><a title='<bean:message key="servicio.busquedaAvanzada" bundle="resources"/>' href="VisualizarEdictoPublicoFrontAction.do?accion=busquedaAvanzada&grupoNavegacion=0&servicioNavegacion=-4"><bean:message key="servicio.busquedaAvanzada" bundle="resources"/></a></li>	
						</ul>
				</div>	
				
