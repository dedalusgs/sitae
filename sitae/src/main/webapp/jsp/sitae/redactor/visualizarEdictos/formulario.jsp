<%@page import="es.novasoft.comun.constantes.Constantes"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script language="Javascript">

function confirmarBorrado(mensaje) {
	if (confirm(mensaje)) {
		return true;
	} else {
		return false;
	}
}
function changeHistorico(disableIt) {
	document.getElementById("estadoSelect").disabled = disableIt;
	document.getElementById("estadoSelect").selectedIndex = 0;
}
</script>

<h3>
	<bean:message key="servicio.gestionEdictos" bundle="resources" />
</h3>
<html:form action="/VisualizarEdictoFrontAction.do?filtrar=si"
	method="post" enctype="multipart/form-data">

	<logic:messagesPresent>
		<div class="error">
			<html:errors />
		</div>
	</logic:messagesPresent>

	<fieldset>
		<legend>
			<bean:message key="comun.buscador" bundle="resources" />
		</legend>
		<div class="detalle">
			<label>
				<bean:message key="datosedicto.fechaRedaccion" bundle="resources" />
			</label>
			<html:text maxlength="10" name="VisualizarEdictoForm"
				property="fechaRedaccion" styleId="i_date" readonly="false"
				styleClass="detalleCalendar"
				onchange="ActualizaFechaPublicacion(i_date)" />
			<html:image bundle="resources" altKey="seleciona.fecha"
				styleClass="input_img" titleKey="seleciona.fecha"
				src="${pageContext.request.contextPath}/img/calendar.gif"
				styleId="i_trigger" onclick="return false;"
				onmouseover="this.src='${pageContext.request.contextPath}/img/calendar.gif';"
				onmouseout="this.src='${pageContext.request.contextPath}/img/calendar.gif';" />
		</div>


<script type="text/javascript">

Calendar.setup( {
	inputField : "i_date",
	dateFormat : "%d/%m/%Y",
	showsTime : false,
	timeFormat : "24",
	trigger : "i_trigger",
	onSelect   : function() { this.hide() }
	
});
</script>
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
				<bean:message key="datosedicto.centroProcedencia" bundle="resources" />
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
				<bean:message key="datosedicto.organismoExterno" bundle="resources" />
			</label>
			<html:select property="opcionOrganismoExterno">
				<html:option value="-1">
					<bean:message key="select.seleccione" bundle="resources" />
				</html:option>
				<html:optionsCollection property="listaOrganismosExternos"
					label="nombre" value="idOrg" />
			</html:select>
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosedicto.estado" bundle="resources" />
			</label>
			<logic:equal name="VisualizarEdictoForm" property="historico"
				value="true">
				<html:select styleId="estadoSelect" disabled="true"
					property="opcionEstado">
					<html:option value="-1">
						<bean:message key="select.seleccione" bundle="resources" />
					</html:option>
					<html:optionsCollection property="listaEstados" label="nombre"
						value="idEstado" />
				</html:select>
			</logic:equal>

			<logic:notEqual name="VisualizarEdictoForm" property="historico"
				value="true">
				<html:select styleId="estadoSelect" property="opcionEstado">
					<html:option value="-1">
						<bean:message key="select.seleccione" bundle="resources" />
					</html:option>
					<html:optionsCollection property="listaEstados" label="nombre"
						value="idEstado" />
				</html:select>
			</logic:notEqual>

		</div>
		<div class="detalle">
			<label>
				<bean:message key="datosedicto.titulo" bundle="resources" />
			</label>
			<html:text maxlength="80" name="VisualizarEdictoForm"
				property="titulo" />
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosedicto.numExp" bundle="resources" />
			</label>
			<html:text name="VisualizarEdictoForm" maxlength="20"
				property="numeroExpediente" />
		</div>
		<div class="detalle">
			<label>
				<bean:message key="filtro.historico" bundle="resources" />
			</label>
			<logic:equal name="VisualizarEdictoForm" property="historico"
				value="true">
				<input class="check" type="checkbox" name="historico"
					onclick="changeHistorico(this.checked)" checked />
			</logic:equal>

			<logic:notEqual name="VisualizarEdictoForm" property="historico"
				value="true">
				<input class="check" type="checkbox"
					onclick="changeHistorico(this.checked)" name="historico" />
			</logic:notEqual>
		</div>



	</fieldset>

	<div class="botonera">
		<html:submit>
			<bean:message key="boton.filtrar" bundle="resources" />
		</html:submit>
	</div>
	<h3>
		<bean:message key="visualizarListaEdictos.titulo" bundle="resources" />
	</h3>
	<h4>
		<bean:message key="visualizarListaEdictos.subtitulo"
			bundle="resources" />
	</h4>
	<logic:notEmpty name="VisualizarEdictoForm" property="listaPublicados">


		<display:table export="true" name="${VisualizarEdictoForm.listaPublicados}"
			sort="external" defaultsort="1" pagesize="10"
			id="nuevaListaPublicados" partialList="true" size="totalTablaEdictos"
			requestURI="./VisualizarEdictoFrontAction.do">

			<c:set var="publicadoProperty">
				<bean:message key="cabecera.publicado" bundle="resources" />
			</c:set>
			<display:column media="html" class="listado_expedientes"
				headerClass="cabecera_tabla">

				<c:if test="${(nuevaListaPublicados.publicado=='true')}">
					<img title="${publicadoProperty}" alt="${publicadoProperty}"
						src="${pageContext.request.contextPath}/img/ico-publicado.gif" />
				</c:if>

			</display:column>

			<c:set var="tituloProperty">
				<bean:message key="cabecera.titulo" bundle="resources" />
			</c:set>

			<display:column class="listado_representantes ancho-200"
				headerClass="cabecera_tabla" property="titulo"
				title="${tituloProperty}" />

			<c:set var="estadoProperty">
				<bean:message key="cabecera.estado" bundle="resources" />
			</c:set>

			<display:column class="listado_representantes"
				headerClass="cabecera_tabla" property="estado"
				title="${estadoProperty}" />

			<c:set var="fechaRedaccionProperty">
				<bean:message key="cabecera.fecha_redaccion" bundle="resources" />
			</c:set>

			<display:column class="listado_representantes"
				headerClass="cabecera_tabla" property="fechaRedaccion"
				title="${fechaRedaccionProperty}" />

			<c:set var="fechaPublicacionProperty">
				<bean:message key="cabecera.fecha_publicacion" bundle="resources" />
			</c:set>

			<display:column class="listado_representantes ancho-60"
				headerClass="cabecera_tabla" property="fechaPublicacion"
				title="${fechaPublicacionProperty}" />

			<c:set var="nombreCentroProperty">
				<bean:message key="cabecera.centro_de_procedencia"
					bundle="resources" />
			</c:set>

			<display:column class="listado_representantes"
				headerClass="cabecera_tabla" property="nombreCentro"
				title="${nombreCentroProperty}" />

			<c:set var="tipoEdictoProperty">
				<bean:message key="cabecera.tipo_de_edicto" bundle="resources" />
			</c:set>

			<display:column class="listado_representantes"
				headerClass="cabecera_tabla" property="tipoEdicto"
				title="${tipoEdictoProperty}" />

			<c:set var="modificarEdictoProperty">
				<bean:message key="boton.modificarEdicto" bundle="resources" />
			</c:set>

			<display:column media="html" class="listado_representantes"
				headerClass="cabecera_tabla">

				<center>
					<c:if
						test="${(nuevaListaPublicados.idEstado=='1') || (nuevaListaPublicados.idEstado=='2') || (nuevaListaPublicados.idEstado=='4')}">
						<html:link action="/ModificarEdictoFrontAction.do"
							paramId="idEdictoSeleccionado" paramName="nuevaListaPublicados"
							paramProperty="id">
							<img title="${modificarEdictoProperty}"
								src="${pageContext.request.contextPath}/img/ico16-editar.gif"
								alt="${modificarEdictoProperty}" />
						</html:link>
					</c:if>
				</center>

			</display:column>

			<c:set var="eliminarEdictoProperty">
				<bean:message key="boton.eliminarEdicto" bundle="resources" />
			</c:set>
			<c:set var="eliminarEdictoMensajeConfirmacionProperty">
				<bean:message key="boton.eliminarEdictoMensajeConfirmacion"
					bundle="resources" />
			</c:set>

			<display:column media="html" class="listado_expedientes"
				headerClass="cabecera_tabla">

				<center>
					<c:if
						test="${(nuevaListaPublicados.idEstado=='1') || (nuevaListaPublicados.idEstado=='4')}">
						<html:link action="/EliminarEdictoDo.do"
							paramId="idEdictoSeleccionado" paramName="nuevaListaPublicados"
							paramProperty="id">
							<img title="${eliminarEdictoProperty}"
								onclick="return confirmarBorrado('${eliminarEdictoMensajeConfirmacionProperty}');"
								src="${pageContext.request.contextPath}/img/ico16-borrar.gif"
								alt="${eliminarEdictoProperty}" />
						</html:link>
					</c:if>
				</center>

			</display:column>


			<c:set var="verInformacionEdictoProperty">
				<bean:message key="boton.verInformacionEdicto" bundle="resources" />
			</c:set>

			<display:column media="html" class="listado_expedientes"
				headerClass="cabecera_tabla">

				<center>
					<html:link action="/MuestraInformacionEdictoRedactorFrontAction.do"
						paramId="idEdictoSeleccionado" paramName="nuevaListaPublicados"
						paramProperty="id">
						<img title="${verInformacionEdictoProperty}"
							src="${pageContext.request.contextPath}/img/ico16-buscar.gif"
							alt="${verInformacionEdictoProperty}" />
					</html:link>
				</center>

			</display:column>

			<c:set var="solicitarPublicacionEdictoProperty">
				<bean:message key="boton.solicitarPublicacionEdicto"
					bundle="resources" />
			</c:set>
			<c:set var="solicitarPublicacionEdictoMensajeConfirmacionProperty">
				<bean:message
					key="boton.solicitarPublicacionEdictoMensajeConfirmacion"
					bundle="resources" />
			</c:set>

			<display:column media="html" class="listado_expedientes"
				headerClass="cabecera_tabla">

				<center>
					<c:if
						test="${(nuevaListaPublicados.idEstado=='1') || (nuevaListaPublicados.idEstado=='4') }">
						<html:link action="/SolicitarPublicacionDoAction.do"
							paramId="idEdictoSeleccionado" paramName="nuevaListaPublicados"
							paramProperty="id">
							<img title="${solicitarPublicacionEdictoProperty}"
								src="${pageContext.request.contextPath}/img/ico16-solicitar.gif"
								onclick="return confirmarBorrado('${solicitarPublicacionEdictoMensajeConfirmacionProperty}');"
								alt="${solicitarPublicacionEdictoProperty}" />
						</html:link>
					</c:if>
				</center>

			</display:column>

			<c:set var="cancelarPublicacionEdictoProperty">
				<bean:message key="boton.cancelarPublicacionEdicto"
					bundle="resources" />
			</c:set>
			<c:set var="cancelarPublicacionEdictoConfirmacionProperty">
				<bean:message key="boton.cancelarPublicacionEdictoConfirmacion"
					bundle="resources" />
			</c:set>

			<display:column media="html" class="listado_expedientes"
				headerClass="cabecera_tabla">

				<center>
					<c:if test="${(nuevaListaPublicados.idEstado=='2')}">
						<html:link action="/CancelarPublicacionDoAction.do"
							paramId="idEdictoSeleccionado" paramName="nuevaListaPublicados"
							paramProperty="id">
							<img title="${cancelarPublicacionEdictoProperty}"
								src="${pageContext.request.contextPath}/img/ico16-cancelar.gif"
								onclick="return confirmarBorrado('${cancelarPublicacionEdictoConfirmacionProperty}');"
								alt="${cancelarPublicacionEdictoProperty}" />
						</html:link>
					</c:if>
				</center>

			</display:column>

		</display:table>
	</logic:notEmpty>
	<logic:empty name="VisualizarEdictoForm" property="listaPublicados">
		<span class="bold"><bean:message
				key="visualizarListaEdictos.listaVacia" bundle="resources" /> </span>
	</logic:empty>
</html:form>

<br/>
<html:form action="/CrearEdictoFrontAction.do" method="post"
	enctype="multipart/form-data">

	<div class="botonera">
		<html:submit>
			<bean:message key="boton.crearEdicto" bundle="resources" />
		</html:submit>
	</div>

</html:form>

