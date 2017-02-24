<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@page import="java.util.Locale"%>
<%@page import="org.apache.struts.Globals"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java"%>

<h4><bean:message key="portal.inicio" bundle="resources"/></h4>
			
				<p><bean:message key="mobile.home.texto1" bundle="resources"/> <b>${nombre}</b> <bean:message key="mobile.home.texto2" bundle="resources"/></p>
				<p><img alt="Dispositivos" width="60%" src="./imagenes/TabletAndSmartphone.jpg"></p>
			<ul data-role="listview" data-ajax="false" data-inset="true">
<li data-role="list-divider"><bean:message key="mobile.home.consulta.anuncio" bundle="resources"/></li>
<li><a data-transition="slidefade" href="./VigorFrontAction.do" ><bean:message key="servicio.edictosVigor" bundle="resources"/></a></li>
<li><a data-transition="slidefade" href="./HistoricoFrontAction.do"><bean:message key="servicio.historicoEdictos" bundle="resources"/></a></li>
<li><a data-transition="slidefade" href="./BusquedaAvanzadaFrontAction.do" data-ajax="false"><bean:message key="servicio.busquedaAvanzada" bundle="resources"/></a></li>
</ul>