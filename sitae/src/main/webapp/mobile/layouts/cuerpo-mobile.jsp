<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@page import="java.util.Locale"%>
<%@page import="org.apache.struts.Globals"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java"%>

<h4  >Inicio</h4>
			
				<p><bean:message key="mobile.home.texto1" bundle="resources"/> <b> ${nombre}</b> <bean:message key="mobile.home.texto2" bundle="resources"/></p>
				<p><img alt="Dispositivos" width="60%" src="./imagenes/TabletAndSmartphone.jpg"></p>