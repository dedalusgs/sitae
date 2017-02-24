<%@ page contentType="text/html" pageEncoding="ISO-8859-15" language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>					
			<div class="menu">
	        	<h2><bean:message key="servicio.edictos" bundle="resources" /></h2>
	           	<ul class="edictos">		            		
	           		<li><a title='<bean:message key="servicio.edictosVigor" bundle="resources"/>' href="/sitae/VisualizarEdictoPublicoFrontAction.do?accion=edictosVigor&grupoNavegacion=0&servicioNavegacion=-2"><bean:message key="servicio.edictosVigor" bundle="resources"/></a></li>
	           		<li><a title='<bean:message key="servicio.historicoEdictos" bundle="resources"/>' href="/sitae/VisualizarEdictoPublicoFrontAction.do?accion=historicoEdictos&filtrar=s&grupoNavegacion=0&servicioNavegacion=-3"><bean:message key="servicio.historicoEdictos" bundle="resources"/></a></li>
	           		<li><a title='<bean:message key="servicio.busquedaAvanzada" bundle="resources"/>' href="/sitae/VisualizarEdictoPublicoFrontAction.do?accion=busquedaAvanzada&grupoNavegacion=0&servicioNavegacion=-4"><bean:message key="servicio.busquedaAvanzada" bundle="resources"/></a></li>
	           	</ul>  	
			</div>
