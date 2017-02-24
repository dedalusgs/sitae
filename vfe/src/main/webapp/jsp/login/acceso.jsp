<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>


<body class="popup">

<div id="cuerpo">

<div id="contenido">


<h2><bean:message key="acceso.admin" bundle="resources" /></h2>

<div class="fondo-top"><html:form action="/LoginDoAction.do"
	method="post" enctype="multipart/form-data">
	<logic:messagesPresent name="errores">
		<div class="error"><html:errors name="errores" /></div>
	</logic:messagesPresent>


	<fieldset><legend><bean:message
		key="acceso.leyendaFormulario" bundle="resources" /></legend>

	<div class="detalle"><label><bean:message
		key="acceso.usuario" bundle="resources" /></label> <html:text name="LoginForm"
		property="usuario" /></div>
	<div class="detalle"><label><bean:message
		key="acceso.password" bundle="resources" /></label> <html:password
		name="LoginForm" property="password" /></div>

	<div class="botonera"><html:submit>
		<bean:message key="boton.entrar" bundle="resources" />
	</html:submit></div>
	</fieldset>

</html:form></div>


</div>

</div>

</body>
