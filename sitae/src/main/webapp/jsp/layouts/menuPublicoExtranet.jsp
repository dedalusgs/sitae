<%@ page contentType="text/html" pageEncoding="ISO-8859-15"
	language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="menu">
	<h2>
		<bean:message key="servicio.edictos" bundle="resources" />
	</h2>
	<ul class="admin">
		<c:set var="vigorProperty">
			<bean:message key="servicio.edictosVigor" bundle="resources" />
		</c:set>
		<li>
			<html:link title="${vigorProperty}"
				action="./VisualizarEdictoPublicoFrontAction.do?accion=edictosVigor&grupoNavegacion=0&servicioNavegacion=-2">
				<bean:message key="servicio.edictosVigor" bundle="resources" />
			</html:link>
		</li>
		<c:set var="historicoProperty">
			<bean:message key="servicio.historicoEdictos" bundle="resources" />
		</c:set>
		<li>
			<html:link title="${historicoProperty}"
				action="./VisualizarEdictoPublicoFrontAction.do?accion=historicoEdictos&filtrar=s&grupoNavegacion=0&servicioNavegacion=-3">
				<bean:message key="servicio.historicoEdictos" bundle="resources" />
			</html:link>
		</li>
		<c:set var="busquedaAvanzadaProperty">
			<bean:message key="servicio.busquedaAvanzada" bundle="resources" />
		</c:set>
		<li>
			<html:link title="${busquedaAvanzadaProperty}"
				action="./VisualizarEdictoPublicoFrontAction.do?accion=busquedaAvanzada&grupoNavegacion=0&servicioNavegacion=-4">
				<bean:message key="servicio.busquedaAvanzada" bundle="resources" />
			</html:link>
		</li>
	</ul>
</div>
