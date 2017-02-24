<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@page import="java.util.Locale"%>
<%@page import="org.apache.struts.Globals"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java"%>

<div data-role="footer" data-position="fixed" data-tap-toggle="false" class="jqm-footer">
			<div data-role="navbar" data-theme="b">
			<ul>
				<li> 
					<a href="./MobileServiciosPortalFrontAction.do?accion=contacto" data-icon="user" data-theme="b"><bean:message key="servicio.contacto" bundle="resources"/></a>
				</li>
				<li> 
					<a href="./MobileServiciosPortalFrontAction.do?accion=avisoLegal" data-icon="alert" data-theme="b" ><bean:message key="servicio.avisoLegal" bundle="resources"/></a>
				</li>
<li> 
					<a href="./MobileServiciosPortalFrontAction.do?accion=acercaDe" data-icon="info" data-theme="b" ><bean:message key="servicio.acercaDe" bundle="resources"/></a>
				</li>
				<li> 
					<a href="/vfe" rel="external" data-icon="action" data-theme="b" ><bean:message key="servicio.vfe" bundle="resources"/></a>
				</li>
			
			</ul>
			</div>
			
</div>