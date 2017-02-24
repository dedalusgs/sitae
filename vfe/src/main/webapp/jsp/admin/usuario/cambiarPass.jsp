<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>


<body class="popup">

<div id="cuerpo">

<div id="contenido">


<h2><bean:message key="admin.usuario.cambiarPass"
	bundle="resources" /></h2>

<div class="fondo-top"><html:form action="/AdminGestionUsuarioDoAction.do"
	method="post" enctype="multipart/form-data">
	<logic:messagesPresent name="errores">
		<div class="error"><html:errors name="errores" /></div>
	</logic:messagesPresent>

	<fieldset><legend><bean:message
		key="admin.usuario.cambiarPass" bundle="resources" /></legend>
	<div class="detalle"><label><bean:message
		key="admin.usuario.oldPassword" bundle="resources" /></label> <html:password
		name="AdminGestionUsuarioForm" property="oldPassword" /></div>
	<div class="detalle"><label><bean:message
		key="admin.usuario.newPassword" bundle="resources" /></label> <html:password
		name="AdminGestionUsuarioForm" property="newPassword" /></div>
	<div class="detalle"><label><bean:message
		key="admin.usuario.newPasswordCopy" bundle="resources" /></label> <html:password
		name="AdminGestionUsuarioForm" property="newPasswordCopy" /></div>
	<div class="botonera"><html:submit>
		<bean:message key="boton.entrar" bundle="resources" />
	</html:submit></div>
	</fieldset>

</html:form>
<form action="./IndexAdmin.do">
<div class="botonera border"> <input
	 type="submit"  bundle="resources" value='<bean:message key="boton.volver" bundle="resources" />'  ></input>   </div>
</form>
</div>



</div>

</div>


</body>
