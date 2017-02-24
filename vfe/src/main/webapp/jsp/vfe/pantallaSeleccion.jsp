<%@page import="es.novasoft.comun.constantes.Constantes"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>

<%
String urlArangi=Constantes.getPropiedad(Constantes.RUTA_URL_ARANGI);
request.setAttribute("urlArangi",urlArangi);
%>
<body class="popup">

<div id="cuerpo">

<div id="contenido">

<h2><bean:message key="servicio.descargaDoc" bundle="resources"/></h2>	

<div class="fondo-top">

<fieldset>
<legend><bean:message key="vfe.legend" bundle="resources" /></legend>

<div class="detalle"><label style="padding-top: 0px;"><bean:message
	key="datosVerificar.nombreFirmante" bundle="resources" /></label> <bean:write
	name="VerificarForm" property="verificador.datosFirmante.nombre" /></div>
<c:if test="${(VerificarForm.verificador.datosFirmante.fecha!='') && (VerificarForm.verificador.datosFirmante.fecha!=null)}">
			
<div class="detalle"><label style="padding-top: 0px;"><bean:message
	key="datosVerificar.fecha" bundle="resources" /></label> <bean:write
	name="VerificarForm" property="verificador.datosFirmante.fecha" /></div>
</c:if>	
	
<div class="hr">
<hr />
</div>

<div class="detalle">
<h4><a
	title='<bean:message key="vfe.descargaDocumentoOriginal" bundle="resources" />'
	href="./DescargarDocumentoOriginal.do"> <bean:message
	key="vfe.descargaDocumentoOriginal" bundle="resources" /> </a></h4>
</div>
<div class="detalle">
<h4><a
	title='<bean:message key="vfe.descargaFirmaElectronica" bundle="resources" />'
	href="./DescargarFirmaElectronica.do"> <bean:message
	key="vfe.descargaFirmaElectronica" bundle="resources" /> </a></h4>
</div>
<div class="detalle">
<h4><a
	title='<bean:message key="vfe.descargaDocumentoFirmado" bundle="resources" />'
	href="./DescargarDocumentoFirmado.do"> <bean:message
	key="vfe.descargaDocumentoFirmado" bundle="resources" /> </a></h4>
</div>

<div class="content">
<p><bean:message key="datosVerificar.textoValide" bundle="resources" /> <html:link target="_blank"  href="${urlArangi}"><bean:message key="datosVerificar.enlace" bundle="resources" /></html:link> </p>
</div>
</fieldset>



</div>

</div>

</div>

</body>
