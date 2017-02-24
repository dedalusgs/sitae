<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>


<h3>
	<bean:message key="servicio.misRedacciones" bundle="resources" />
</h3>

<h4>
	<bean:message key="publicarEdicto.titulo" bundle="resources" />
</h4>
<html:form action="/VisualizarMisRedaccionesFrontAction.do">

	<div class="correcto">
		<p>
			<bean:message key="publicarEdicto.correcto" bundle="resources" />
		</p>
	</div>
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


	<div align="center" class="botonera border">
		<html:submit>
			<bean:message key="boton.volver" bundle="resources" />
		</html:submit>
	</div>
	<html:hidden name="PublicarEdictoMisRedaccionesForm"
		property="idEdicto" />
</html:form>


