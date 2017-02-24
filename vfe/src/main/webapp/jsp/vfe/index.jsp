<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@page import="es.novasoft.castellon.vfe.business.objects.Organismo"%>
<%@page import="java.util.Locale,org.apache.struts.Globals"%>

<%
	Organismo org = (Organismo) request.getSession().getAttribute(
			"organismoSesion");
%>
<%
	Locale locale = (Locale) session.getAttribute(Globals.LOCALE_KEY);
%>

<h2><bean:message key="servicio.inicio" bundle="resources"/></h2>	

<%
	String nombreOrg = org.getNombre();
	if (locale != null) {
		if (locale.getLanguage().equals("va")) {
			nombreOrg = org.getNombreVa();
		}
	}
%>

<div class="content">
<p><bean:message key="portal.textoinicio11" bundle="resources" /> <%=nombreOrg%><bean:message
	key="portal.textoinicio" bundle="resources" /></p>
<p><bean:message key="portal.textoinicio2" bundle="resources" /> <%=nombreOrg%><bean:message
	key="portal.textoinicio22" bundle="resources" /> <%=nombreOrg%><bean:message
	key="portal.textoinicio23" bundle="resources" /></p>
<div class="hr">
<hr />
</div>
<p><bean:message key="portal.textoinicio3" bundle="resources" /><%=nombreOrg%><bean:message
	key="portal.textoinicio32" bundle="resources" /></p>
</div>


<logic:messagesPresent>
	<div class="error"><html:errors /></div>
</logic:messagesPresent>

<form action="./VerificarFrontAction.do" method="post">
<fieldset>
<div><label for=""><bean:message
	key="datosVerificar.codigo" bundle="resources" /></label><input type="text"
	name="codigo" id="codigo"></div>
<div>
<p><img src="./stickyImg" /></p>
<label for=""><bean:message key="datosVerificar.captcha"
	bundle="resources" /></label> <input type="text" name="captcha" id="captcha" /></div>
<input type="submit" class="boton"
	value="<bean:message key="boton.validar"
	bundle="resources" />"></fieldset>
</form>
