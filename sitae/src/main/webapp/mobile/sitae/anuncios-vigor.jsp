<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@page import="java.util.Locale"%>
<%@page import="org.apache.struts.Globals"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java"%>




<h4><bean:message key="servicio.edictosVigor" bundle="resources" /></h4>
			<p><bean:message key="mobile.envigor.texto" bundle="resources" /></p>
			
<logic:notEmpty name="VisualizarEdictoPublicoForm"
		property="listaPublicados">

		<display:table name="${VisualizarEdictoPublicoForm.listaPublicados}"
			sort="external" class="ui-responsive sitae" style="\" data-role=\"table"    id="nuevaListaPublicados"
			pagesize="10" partialList="${listaParcial}" size="totalTablaEdictos"
			requestURI="./VigorFrontAction.do" export="false">

			<c:set var="verInformacionEdictoProperty">
				<bean:message key="boton.verInformacionEdicto" bundle="resources" />
			</c:set>

			<c:set var="tituloProperty">
				<bean:message key="cabecera.titulo" bundle="resources" />
			</c:set>

			<display:column class="listado_representantes" media="html"	 title="${tituloProperty}">
				
					<bean:write name="nuevaListaPublicados" property="titulo" />
			</display:column>

		
			<c:set var="tipoEdictoProperty">
				<bean:message key="cabecera.tipo_de_edicto" bundle="resources" />
			</c:set>

			<display:column  property="tipoEdicto"	title="${tipoEdictoProperty}" />

			<c:set var="nombreCentroProperty">
				<bean:message key="cabecera.centro_de_procedencia"
					bundle="resources" />
			</c:set>
			
			<display:column class="listado_representantes"  property="nombreCentro" 	title="${nombreCentroProperty}" />

			<c:set var="fechaPublicacionProperty">
				<bean:message key="cabecera.fecha_publicacion" bundle="resources" />
			</c:set>

			
			
			<display:column class="listado_representantes" media="html"  property="fechaPublicacion" 	title="${fechaPublicacionProperty}" />
				
					
				<c:set var="fechaRetiradaPublicacionProperty">
					<bean:message key="cabecera.fecha_retirada" bundle="resources" />
				</c:set>
				
				<c:set var="fechaRetiradaPublicacionExportProperty">
					<bean:message key="cabecera.fecha_retirada_export" bundle="resources" />
				</c:set>
			<c:if test="${(nuevaListaPublicados.idEstado=='6')}">
				<display:column property="fechaRetirada" 	title="${fechaRetiradaPublicacionProperty}" />

			</c:if>
			<c:if test="${(nuevaListaPublicados.idEstado!='6')}">
				<display:column  property="fechaRetiradaPropuesta" 	title="${fechaRetiradaPublicacionProperty}" />

			</c:if>

			<c:set var="codigoProperty">
				<bean:message key="cabecera.codigo" bundle="resources" />
			</c:set>

			<c:set var="descargarEdictoProperty">
				<bean:message key="boton.descargarEdicto" bundle="resources" />
			</c:set>

			<c:set var="descargarCerficadoPublicacionEdictoProperty">
				<bean:message key="boton.descargarCerficadoPublicacionEdicto"
					bundle="resources" />
			</c:set>
		
			<display:column media="html" class="listado_expedientes" headerClass="cabecera_tabla">
				<center>
					<a href="./MuestraInfoEdictoFrontAction.do?idEdictoSeleccionado=${nuevaListaPublicados.id}" data-transition="slidefade" data-ajax="false" class=" ui-btn ui-btn-icon-notext ui-corner-all ui-icon-action ui-nodisc-icon ui-alt-icon"></a>
				</center>
			</display:column>
	
		</display:table>
	</logic:notEmpty>

	<logic:empty name="VisualizarEdictoPublicoForm"
		property="listaPublicados">
		<span class="bold"><bean:message key="listaEdictos.vacia" bundle="resources" />
		</span>
	</logic:empty>
	
	