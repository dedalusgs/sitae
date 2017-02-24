<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@page import="java.util.Locale"%>
<%@page import="org.apache.struts.Globals"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java"%>

<ul data-role="listview" data-ajax="false" data-inset="true">
<li data-role="list-divider"><bean:message key="mobile.home.consulta.anuncio" bundle="resources"/></li>
<li><a data-transition="slidefade" href="./anucios-vigor.html" ><bean:message key="servicio.edictosVigor" bundle="resources"/></a></li>
<li><a data-transition="slidefade" href="./historico.html"><bean:message key="servicio.historicoEdictos" bundle="resources"/></a></li>
<li><a data-transition="slidefade" href="./busqueda-avanzada.html" data-ajax="false"><bean:message key="servicio.busquedaAvanzada" bundle="resources"/></a></li>
</ul>