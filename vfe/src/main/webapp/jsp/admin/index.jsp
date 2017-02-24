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

<div class="fondo-top">



<fieldset><legend><bean:message key="admin.index"
	bundle="resources" /></legend>
<div class="detalle">
<h4><a
	title='<bean:message key="admin.gestionOrganismos" bundle="resources" />'
	href="./VisualizarOrganismoFrontAction.do"> <bean:message key="admin.gestionOrganismos"
	bundle="resources" /> </a></h4>
</div>
<div class="detalle">
<h4><a
	title='<bean:message key="admin.gestionUsuario" bundle="resources" />'
	href="./AdminGestionUsuarioFront.do"> <bean:message
	key="admin.gestionUsuario" bundle="resources" /> </a></h4>
</div>
</fieldset>



</div>

</div>

</div>

</body>
