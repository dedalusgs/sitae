<%@ page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@page import="es.novasoft.comun.constantes.Constantes"%>
<div id="contenido-menu-principal">
<ul>
	<li><a
		title='<bean:message key="portal.inicio" bundle="resources"/>'
		href="./InitDoAction.do"><bean:message
		key="portal.inicio" bundle="resources" /></a></li>
		
		<c:if test="${(LoginForm.registrado==true)}">
		<c:if
			test="${(LoginForm.usuario!='') && (LoginForm.usuario!=null)}">
			<li><a
		title='<bean:message key="admin.index" bundle="resources"/>'
		href="./IndexAdmin.do"><bean:message
		key="admin.index" bundle="resources" /></a></li>
		</c:if>

	</c:if>
</ul>
</div>

<ul class="menu-login">
	<c:if test="${((LoginForm==null) || LoginForm.registrado==false)}">

	</c:if>
	<c:if test="${(LoginForm.registrado==true)}">
		<c:if
			test="${(LoginForm.usuario!='') && (LoginForm.usuario!=null)}">
			<li class="user" style="color: white;"><bean:write
				name="LoginForm" property="usuario" /></li>
		</c:if>
		<li><a
			title='<bean:message key="portal.salir" bundle="resources"/>'
			href="./Logout.do"><bean:message key="portal.salir"
			bundle="resources" /></a></li>
	</c:if>
</ul>
