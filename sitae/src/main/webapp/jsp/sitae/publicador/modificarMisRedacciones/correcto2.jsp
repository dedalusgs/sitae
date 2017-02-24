<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>


<h3>
	<bean:message key="servicio.misRedacciones" bundle="resources" />
</h3>

<h4>
	<bean:message key="modificarEdicto.titulo" bundle="resources" />
</h4>

<div align="center" class="correcto">
	<p>
		<bean:message key="resultado.exitoPublicacion2" bundle="resources" />
	</p>
</div>
 <logic:present name="festivos">
						<div class="correcto">
						       <p><bean:message key="creado.festivosNoDeclarados" bundle="resources"/></p>
						</div>
						</logic:present>	
<div class="detalle" align="center">
	<a target="_blank"
		title='<bean:message key="boton.descargarEdicto" bundle="resources"/>'
		href="DescargarAnuncio.do?codigo=<%=request.getAttribute("codigo")%>"><bean:message
			key="boton.descargarEdicto" bundle="resources" />
	</a>
</div>

<div class="detalle" align="center">
	<a target="_blank"
		title='<bean:message key="boton.descargarCerficadoPublicacionEdicto" bundle="resources"/>'
		href="DescargarCertificadoPublicacion.do?codigo=<%=request.getAttribute("codigo")%>"><bean:message
			key="boton.descargarCerficadoPublicacionEdicto" bundle="resources" />
	</a>
</div>

<html:form action="/VisualizarMisRedaccionesFrontAction.do">
	<div class="botonera border">
		<html:submit>
			<bean:message key="boton.volver" bundle="resources" />
		</html:submit>
	</div>
</html:form>
