<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@page import="java.util.Locale"%>
<%@page import="org.apache.struts.Globals"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java"%>

 <div data-role="panel" class="jqm-navmenu-panel" data-position="left" data-display="push" data-theme="a">
	<ul class="jqm-list ui-alt-icon ui-nodisc-icon">
	
	<c:if test="${opcionMobile == 'inicio' }">
			<li data-theme="b" data-icon="home" ><bean:message key="portal.inicio" bundle="resources"/></li>
	</c:if>
	
	<c:if test="${opcionMobile != 'inicio' }">
		<li data-icon="home"><a  rel="external" data-transition="slidefade" href="./HomeFrontAction.do"  ><bean:message key="portal.inicio" bundle="resources"/></a></li>
	</c:if>
	
	<c:if test="${opcionMobile == 'vigor' }">
		<li data-theme="b" ><bean:message key="servicio.edictosVigor" bundle="resources"/></li>
	</c:if>
	<c:if test="${opcionMobile != 'vigor' }">
		<li><a data-transition="slidefade" href="./VigorFrontAction.do" ><bean:message key="servicio.edictosVigor" bundle="resources"/></a></li>
	</c:if>
	
	<c:if test="${opcionMobile == 'historico' }">
		<li data-theme="b" ><bean:message key="servicio.historicoEdictos" bundle="resources"/></li>
	</c:if>
	<c:if test="${opcionMobile != 'historico' }">
		<li><a data-transition="slidefade" href="./HistoricoFrontAction.do" ><bean:message key="servicio.historicoEdictos" bundle="resources"/></a></li>
	</c:if>
	
	<c:if test="${opcionMobile == 'avanzada' }">
		<li data-theme="b" ><bean:message key="servicio.busquedaAvanzada" bundle="resources"/></li>
	</c:if>
	<c:if test="${opcionMobile != 'avanzada' }">
		<li><a data-transition="slidefade" href="./BusquedaAvanzadaFrontAction.do" ><bean:message key="servicio.busquedaAvanzada" bundle="resources"/></a></li>
	</c:if>
	
	</ul>
</div>
