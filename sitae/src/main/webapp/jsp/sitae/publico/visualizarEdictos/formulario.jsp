<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<%
	String accionPublico = (String) session
			.getAttribute("accionPublico");
%>
<c:if test="${(accionPublico=='busquedaAvanzada')}">
	<h3>
		<bean:message key="busquedaAvanzada.titulo" bundle="resources" />
	</h3>
</c:if>
<c:if test="${(accionPublico=='edictosVigor')}">
	<h3>
		<bean:message key="edictosVigor.titulo" bundle="resources" />
	</h3>
</c:if>
<c:if test="${(accionPublico=='historicoEdictos')}">
	<h3>
		<bean:message key="historicoEdictos.titulo" bundle="resources" />
	</h3>
</c:if>
<html:form
	action="/VisualizarEdictoPublicoFrontAction.do?accion=busquedaAvanzada&filtrar=si"
	method="post" enctype="multipart/form-data">
	<logic:messagesPresent>
		<div class="error">
			<html:errors />
		</div>
	</logic:messagesPresent>

	<c:if test="${(accionPublico=='busquedaAvanzada')}">
		<fieldset>
			<legend>
				<bean:message key="comun.buscador" bundle="resources" />
			</legend>
			<div class="detalle">
				<label>
					<bean:message key="datosedicto.tipoEdicto" bundle="resources" />
				</label>
				<html:select property="opcionTipoEdicto">
					<html:option value="-1">
						<bean:message key="select.seleccione" bundle="resources" />
					</html:option>
					<html:optionsCollection property="listaTiposEdictos" label="nombre"
						value="idTipoEdicto" />
				</html:select>
			</div>

			<div class="detalle">
				<label>
					<bean:message key="datosedicto.centroProcedencia"
						bundle="resources" />
				</label>
				<html:select property="opcionCentro">
					<html:option value="-1">
						<bean:message key="select.seleccione" bundle="resources" />
					</html:option>
					<html:optionsCollection property="listaCentros" label="nombre"
						value="idCentro" />
				</html:select>
			</div>
			
			<div class="detalle">
				<label>
					<bean:message key="datosedicto.organismoExterno"
						bundle="resources" />
				</label>
				<html:select property="opcionOrganismoExterno">
					<html:option value="-1">
						<bean:message key="select.seleccione" bundle="resources" />
					</html:option>
					<html:optionsCollection property="listaOrganismosExternos" label="nombre"
						value="idOrg" />
				</html:select>
			</div>
			
			<div class="detalle">
				<label>
					<bean:message key="datosedicto.titulo" bundle="resources" />
				</label>
				<html:text name="VisualizarEdictoPublicoForm" property="titulo" 	maxlength="80" />
			</div>

			<div class="detalle">
				<label>
					<bean:message key="datosedicto.descripcion" bundle="resources" />
				</label>
				<html:text name="VisualizarEdictoPublicoForm" property="descripcion" maxlength="255"   />
			</div>
			<div class="detalle">
				<bean:message key="visualizarListaEdictos.descripcion.advertencia"
					bundle="resources" />
			</div>
<%--			<div class="detalle">--%>
<%--				<label>--%>
<%--					<bean:message key="datosedicto.contenido" bundle="resources" />--%>
<%--				</label>--%>
<%--				<html:text disabled="true" name="VisualizarEdictoPublicoForm"--%>
<%--					property="contenido" maxlength="255" />--%>
<%--			</div>--%>
<%--			<div class="detalle">--%>
<%--				<bean:message key="visualizarListaEdictos.contenido.advertencia"--%>
<%--					bundle="resources" />--%>
<%--			</div>--%>
			<div class="detalle">
				<label>
					<bean:message key="datosedicto.fechaPublicacionEntre"
						bundle="resources" />
				</label>
				<html:text maxlength="10" name="VisualizarEdictoPublicoForm"
					property="fechaPublicacionInicio" styleId="i_date_inicio"
					readonly="false" styleClass="detalleCalendar"
					onchange="ActualizaFechaPublicacion(i_date_inicio)" />
				<html:image bundle="resources" altKey="seleciona.fecha"
					styleClass="input_img" titleKey="seleciona.fecha"
					src="${pageContext.request.contextPath}/img/calendar.gif"
					styleId="i_trigger_inicio" onclick="return false;"
					onmouseover="this.src='${pageContext.request.contextPath}/img/calendar.gif';"
					onmouseout="this.src='${pageContext.request.contextPath}/img/calendar.gif';" />
			</div>
	<script type="text/javascript">

	
	

Calendar.setup( {
	inputField : "i_date_inicio",
	dateFormat : "%d/%m/%Y",
	showsTime : false,
	timeFormat : "24",
	trigger : "i_trigger_inicio",
	onSelect   : function() { this.hide(); }
	
});</script> 

			<div class="detalle">
				<label>
					<bean:message key="datosedicto.fechaPublicacionEntrey"
						bundle="resources" />
				</label>
				<html:text maxlength="10" name="VisualizarEdictoPublicoForm"
					property="fechaPublicacionFin" styleId="i_date_fin"
					readonly="false" styleClass="detalleCalendar"
					onchange="ActualizaFechaPublicacion(i_date_fin)" />
				<html:image bundle="resources" altKey="seleciona.fecha"
					styleClass="input_img" titleKey="seleciona.fecha"
					src="${pageContext.request.contextPath}/img/calendar.gif"
					styleId="i_trigger_fin" onclick="return false;"
					onmouseover="this.src='${pageContext.request.contextPath}/img/calendar.gif';"
					onmouseout="this.src='${pageContext.request.contextPath}/img/calendar.gif';" />
			</div>

			<script type="text/javascript">

Calendar.setup( {
	inputField : "i_date_fin",
	dateFormat : "%d/%m/%Y",
	showsTime : false,
	timeFormat : "24",
	trigger : "i_trigger_fin",
	onSelect   : function() { this.hide() }
	
});
</script>

			<div class="detalle">
				<label>
					<bean:message key="filtro.historico" bundle="resources" />
				</label>
				<logic:equal name="VisualizarEdictoPublicoForm" property="historico"
					value="true">
					<input class="check" type="checkbox" name="historico" checked />
				</logic:equal>

				<logic:notEqual name="VisualizarEdictoPublicoForm"
					property="historico" value="true">
					<input class="check" type="checkbox" name="historico" />
				</logic:notEqual>
			</div>

		</fieldset>
		<div class="botonera">
			<html:submit>
				<bean:message key="boton.filtrar" bundle="resources" />
			</html:submit>
		</div>
	</c:if>

	<logic:notEmpty name="VisualizarEdictoPublicoForm"
		property="listaPublicados">

		<display:table name="${VisualizarEdictoPublicoForm.listaPublicados}"
			sort="external" defaultsort="1" id="nuevaListaPublicados"
			pagesize="10" partialList="${listaParcial}" size="totalTablaEdictos"
			requestURI="./VisualizarEdictoPublicoFrontAction.do" export="true">

			<c:set var="verInformacionEdictoProperty">
				<bean:message key="boton.verInformacionEdicto" bundle="resources" />
			</c:set>

			<c:set var="tituloProperty">
				<bean:message key="cabecera.titulo" bundle="resources" />
			</c:set>

			<display:column class="listado_representantes" media="html"
				headerClass="cabecera_tabla ancho-400" title="${tituloProperty}">
				<html:link title="${verInformacionEdictoProperty}"
					action="/MuestraInformacionEdictoPublicoFrontAction.do"
					paramId="idEdictoSeleccionado" paramName="nuevaListaPublicados"
					paramProperty="id">
					<bean:write name="nuevaListaPublicados" property="titulo" />
				</html:link>
				</br>
				<div id="setDescripcion${nuevaListaPublicados.id}">
					<bean:write name="nuevaListaPublicados" property="descripcionCorta" />
				</div>

				<script type="text/javascript">
$(function() {
	$('#setDescripcion${nuevaListaPublicados.id}').tooltip( {
		delay : 0,
		showURL : false,
		bodyHandler : function() {
			return $("#textDescripcion${nuevaListaPublicados.id}").text();
		}
	});
});
</script>

				<div id="textDescripcion${nuevaListaPublicados.id}"
					style="display: none;">
					<bean:write name="nuevaListaPublicados" property="descripcion" />
				</div>

			</display:column>

			<display:column media="csv pdf" 
				title="${tituloProperty}" property="titulo">

			</display:column>

			<c:set var="descripcionProperty">
				<bean:message key="cabecera.descripcion" bundle="resources" />
			</c:set>

			<display:column media="csv pdf"
				 title="${descripcionProperty}" property="descripcion">
			</display:column>
			
			<c:set var="tipoEdictoProperty">
				<bean:message key="cabecera.tipo_de_edicto" bundle="resources" />
			</c:set>

			<display:column class="listado_representantes"
				headerClass="cabecera_tabla" property="tipoEdicto"
				title="${tipoEdictoProperty}" />

			<c:set var="nombreCentroProperty">
				<bean:message key="cabecera.centro_de_procedencia"
					bundle="resources" />
			</c:set>
			
			<display:column class="listado_representantes" 
				headerClass="cabecera_tabla" property="nombreCentro"
				title="${nombreCentroProperty}" />

			<c:set var="fechaPublicacionProperty">
				<bean:message key="cabecera.fecha_publicacion" bundle="resources" />
			</c:set>

			<c:set var="fechaPublicacionExportProperty">
				<bean:message key="cabecera.fecha_publicacion_export" bundle="resources" />
			</c:set>
			
			<display:column class="listado_representantes" media="html"
				headerClass="cabecera_tabla" property="fechaPublicacion"
				title="${fechaPublicacionProperty}" />
				
			<display:column class="listado_representantes" media="csv pdf"
				headerClass="cabecera_tabla" property="fechaPublicacion"
				title="${fechaPublicacionExportProperty}" />
				
				<c:set var="fechaRetiradaPublicacionProperty">
					<bean:message key="cabecera.fecha_retirada" bundle="resources" />
				</c:set>
				
				<c:set var="fechaRetiradaPublicacionExportProperty">
					<bean:message key="cabecera.fecha_retirada_export" bundle="resources" />
				</c:set>
			<c:if test="${(nuevaListaPublicados.idEstado=='6')}">
				<display:column class="listado_representantes" 
					headerClass="cabecera_tabla" property="fechaRetirada"
					title="${fechaRetiradaPublicacionProperty}" />

			</c:if>
			<c:if test="${(nuevaListaPublicados.idEstado!='6')}">
				<display:column class="listado_representantes"
					headerClass="cabecera_tabla" property="fechaRetiradaPropuesta"
					title="${fechaRetiradaPublicacionProperty}" />

			</c:if>

			<c:set var="codigoProperty">
				<bean:message key="cabecera.codigo" bundle="resources" />
			</c:set>

			<display:column media="csv pdf"
				 title="${codigoProperty}" property="codigo">
			</display:column>
			
			<c:set var="descargarEdictoProperty">
				<bean:message key="boton.descargarEdicto" bundle="resources" />
			</c:set>

			<c:set var="descargarCerficadoPublicacionEdictoProperty">
				<bean:message key="boton.descargarCerficadoPublicacionEdicto"
					bundle="resources" />
			</c:set>
<c:if test="${(nuevaListaPublicados.idEstado=='5')}">
			<display:column media="html" class="listado_expedientes"
				headerClass="cabecera_tabla">
				<center>
					<html:link target="_blank"
						href="DescargarAnuncio.do?codigo=${nuevaListaPublicados.codigo }">
						<img title="${descargarEdictoProperty}"
							src="${pageContext.request.contextPath}/img/ico-descarga-edicto.gif"
							alt="${descargarEdictoProperty}" />
					</html:link>
				</center>
			</display:column>
			<display:column media="html" class="listado_expedientes"
				headerClass="cabecera_tabla">
				<center>
						<html:link target="_blank"
							href="DescargarCertificadoPublicacion.do?codigo=${nuevaListaPublicados.codigo}">
							<img title="${descargarCerficadoPublicacionEdictoProperty}"
								src="${pageContext.request.contextPath}/img/ico-descargar-publicacion.gif"
								alt="${descargarCerficadoPublicacionEdictoProperty}" />
						</html:link>
				</center>
			</display:column>
					</c:if>
			<c:set var="descargarCerficadoDiligenciaEdictoProperty">
				<bean:message key="boton.descargarCerficadoDiligenciaEdicto"
					bundle="resources" />
			</c:set>
			<c:if test="${(nuevaListaPublicados.idEstado=='6')}">
			
			<display:column media="html" class="listado_expedientes"
				headerClass="cabecera_tabla">
				<center>
						<html:link target="_blank"
							href="DescargarInformeRevision.do?codigo=${nuevaListaPublicados.codigo}">
							<img title="${descargarCerficadoDiligenciaEdictoProperty}"
								src="${pageContext.request.contextPath}/img/ico-descargar-publicacion.gif"
								alt="${descargarCerficadoDiligenciaEdictoProperty}" />
						</html:link>
				</center>
			</display:column>
			<c:if test="${(nuevaListaPublicados.idEstado=='6')}">
				<display:column media="html" class="listado_expedientes"
					headerClass="cabecera_tabla">
					<center>
			<c:set var="descargarDiligenciaEdictoProperty">
				<bean:message key="boton.descargarDiligenciaEdicto"
					bundle="resources" />
			</c:set>
						<html:link target="_blank"
							href="DescargarDiligencia.do?codigo=${nuevaListaPublicados.codigo}">
							<img title="${descargarDiligenciaEdictoProperty}"
								src="${pageContext.request.contextPath}/img/ico-descargar-diligencia.gif"
								alt="${descargarDiligenciaEdictoProperty}" />
						</html:link>

					</center>
				</display:column>
			</c:if>
			</c:if>
		</display:table>
	</logic:notEmpty>

	<logic:empty name="VisualizarEdictoPublicoForm"
		property="listaPublicados">
		<span class="bold"><bean:message key="listaEdictos.vacia"
				bundle="resources" />
		</span>
	</logic:empty>

</html:form>

