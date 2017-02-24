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
	<c:if test="${(LoginCertificadoForm.administradorLocal==true)}">
		<bean:message key="servicio.publicaciones" bundle="resources" />
	</c:if>
	<c:if test="${(LoginCertificadoForm.publicador==true)}">
		<bean:message key="servicio.misPublicaciones" bundle="resources" />
	</c:if>
</h3>

<html:form action="/VisualizarEdictoPublicadorFrontAction.do?filtrar=si"
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
			<html:text maxlength="10" name="VisualizarEdictoPublicadorForm"
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
	onSelect   : function() { this.hide(); }
	
});</script> 

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
			<logic:equal name="VisualizarEdictoPublicadorForm"
				property="historico" value="true">
				<html:select styleId="estadoSelect" disabled="true"
					property="opcionEstado">
					<html:option value="-1">
						<bean:message key="select.seleccione" bundle="resources" />
					</html:option>
					<html:optionsCollection property="listaEstados" label="nombre"
						value="idEstado" />
				</html:select>
			</logic:equal>

			<logic:notEqual name="VisualizarEdictoPublicadorForm"
				property="historico" value="true">
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
			<html:text name="VisualizarEdictoForm" maxlength="80"
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
				<bean:message key="datosedicto.codigo" bundle="resources" />
			</label>
			<html:text name="VisualizarEdictoForm" maxlength="80"
				property="codigoEdicto" />
		</div>

		<div class="detalle">

			<label>
				<bean:message key="filtro.historico" bundle="resources" />
			</label>

			<logic:equal name="VisualizarEdictoPublicadorForm"
				property="historico" value="true">
				<input class="check" type="checkbox" name="historico"
					onclick="changeHistorico(this.checked)" checked />
			</logic:equal>

			<logic:notEqual name="VisualizarEdictoPublicadorForm"
				property="historico" value="true">
				<input class="check" type="checkbox"
					onclick="changeHistorico(this.checked)" name="historico" />
			</logic:notEqual>

		</div>

		<div class="botonera">
			<html:submit>
				<bean:message key="boton.filtrar" bundle="resources" />
			</html:submit>
		</div>

	</fieldset>

	<div>
		<h3>
			<c:if test="${(LoginCertificadoForm.administradorLocal==true)}">
				<bean:message key="visualizarListaEdictosPublicaciones.tituloAdm"
					bundle="resources" />
			</c:if>
			<c:if test="${(LoginCertificadoForm.publicador==true)}">
				<bean:message key="visualizarListaEdictosPublicaciones.titulo"
					bundle="resources" />
			</c:if>
		</h3>
		<h4>
			<c:if test="${(LoginCertificadoForm.administradorLocal==true)}">
				<bean:message key="visualizarListaEdictosPublicaciones.subtituloAdm"
					bundle="resources" />
			</c:if>
			<c:if test="${(LoginCertificadoForm.publicador==true)}">
				<bean:message key="visualizarListaEdictosPublicaciones.subtitulo"
					bundle="resources" />
			</c:if>
		</h4>
	</div>
	<logic:notEmpty name="VisualizarEdictoPublicadorForm"
		property="listaPublicados">
		<display:table export="true"
			name="${VisualizarEdictoPublicadorForm.listaPublicados}"
			sort="external" defaultsort="1" pagesize="10"
			id="nuevaListaPublicados" partialList="${listaParcial}" size="totalTablaEdictos"
			requestURI="./VisualizarEdictoPublicadorFrontAction.do">

			<c:set var="publicadoProperty">
				<bean:message key="cabecera.publicado" bundle="resources" />
			</c:set>

			<display:column media="html" class="listado_expedientes"
				headerClass="cabecera_tabla">

				<c:if test="${(nuevaListaPublicados.publicado=='true')}">
					<img title="${publicadoProperty}"
						src="${pageContext.request.contextPath}/img/ico-publicado.gif" />
				</c:if>

			</display:column>

			<c:set var="tituloProperty">
				<bean:message key="cabecera.titulo" bundle="resources" />
			</c:set>

			<display:column class="listado_representantes"
				headerClass="cabecera_tabla ancho-200" property="titulo"
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

			<display:column class="listado_representantes"
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

			<c:set var="verInformacionEdictoProperty">
				<bean:message key="boton.verInformacionEdicto" bundle="resources" />
			</c:set>

			<display:column media="html" class="listado_expedientes"
				headerClass="cabecera_tabla">

				<center>
					<c:if test="${ nuevaListaPublicados.publicadorAsignado == true}">
						<html:link
							action="/MuestraInformacionEdictoFrontAction.do?visualizar=misPublicaciones"
							paramId="idEdictoSeleccionado" paramName="nuevaListaPublicados"
							paramProperty="id">
							<img title="${verInformacionEdictoProperty}"
								src="${pageContext.request.contextPath}/img/ico16-buscar.gif"
								alt="${verInformacionEdictoProperty}" />
						</html:link>
					</c:if>
					<c:if test="${ nuevaListaPublicados.publicadorAsignado == false}">
						<html:link
							action="/MuestraInformacionEdictoFrontAction.do?visualizar=publicacionOcupada"
							paramId="idEdictoSeleccionado" paramName="nuevaListaPublicados"
							paramProperty="id">
							<img title="${verInformacionEdictoProperty}"
								src="${pageContext.request.contextPath}/img/ico16-buscar.gif"
								alt="${verInformacionEdictoProperty}" />
						</html:link>
					</c:if>
				</center>

			</display:column>

			<c:set var="darBajaPublicacionProperty">
				<bean:message key="boton.darBajaPublicacion" bundle="resources" />
			</c:set>

			<display:column media="html" class="listado_expedientes"
				headerClass="cabecera_tabla">
				<c:if test="${(nuevaListaPublicados.idEstado=='5')}">
					<center>
						<html:link action="/DarBajaPublicacionFrontAction.do"
							paramId="idEdictoSeleccionado" paramName="nuevaListaPublicados"
							paramProperty="id">
							<img title="${darBajaPublicacionProperty}"
								src="${pageContext.request.contextPath}/img/ico-dar-baja.gif"
								alt="${darBajaPublicacionProperty}" />
						</html:link>
					</center>
				</c:if>
			</display:column>

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
				<display:column media="html" class="listado_expedientes"
					headerClass="cabecera_tabla">
					<center>

						<html:link target="_blank"
							href="DescargarDiligencia.do?codigo=${nuevaListaPublicados.codigo}">
							<img title="${descargarDiligenciaEdictoProperty}"
								src="${pageContext.request.contextPath}/img/ico-descargar-diligencia.gif"
								alt="${descargarDiligenciaEdictoProperty}" />
						</html:link>

					</center>
				</display:column>
			</c:if>

			<c:set var="rechazarPublicacionProperty">
				<bean:message key="boton.rechazarPublicacion" bundle="resources" />
			</c:set>

			<display:column media="html" class="listado_expedientes"
				headerClass="cabecera_tabla">
				<c:if
					test="${(nuevaListaPublicados.idEstado=='3' || nuevaListaPublicados.idEstado=='9') && nuevaListaPublicados.publicadorAsignado == true}">
					<center>
						<html:link action="/RechazarPublicacionFrontAction.do"
							paramId="idEdictoSeleccionado" paramName="nuevaListaPublicados"
							paramProperty="id">
							<img title="${rechazarPublicacionProperty}"
								src="${pageContext.request.contextPath}/img/ico16-rechazar.gif"
								alt="${rechazarPublicacionProperty}" />
						</html:link>
					</center>
				</c:if>

			</display:column>

			<c:set var="publicarEdictoProperty">
				<bean:message key="boton.publicarEdicto" bundle="resources" />
			</c:set>

			<display:column media="html" class="listado_expedientes"
				headerClass="cabecera_tabla">
				<c:if
					test="${(nuevaListaPublicados.idEstado=='3') && nuevaListaPublicados.publicadorAsignado == true}">
					<center>
						<html:link action="/PublicarEdictoDo.do"
							paramId="idEdictoSeleccionado" paramName="nuevaListaPublicados"
							paramProperty="id">
							<img title="${publicarEdictoProperty}"
								src="${pageContext.request.contextPath}/img/ico16-publicar.gif"
								alt="${publicarEdictoProperty}" />
						</html:link>
					</center>
				</c:if>
			</display:column>

			<c:set var="modificarEdictoProperty">
				<bean:message key="boton.modificarEdicto" bundle="resources" />
			</c:set>

			<display:column media="html" class="listado_expedientes"
				headerClass="cabecera_tabla">
				<c:if
					test="${((nuevaListaPublicados.idEstado=='3' || nuevaListaPublicados.idEstado=='9')&& nuevaListaPublicados.publicadorAsignado == true)}">
					<center>
						<html:link action="/ActualizarEdictoPublicadoFrontAction.do"
							paramId="idEdictoSeleccionado" paramName="nuevaListaPublicados"
							paramProperty="id">
							<img title="${modificarEdictoProperty}"
								src="${pageContext.request.contextPath}/img/ico16-editar.gif"
								alt="${modificarEdictoProperty}" />
						</html:link>
					</center>
				</c:if>
			</display:column>

			<c:set var="descargarDiligenciaEdictoProperty">
				<bean:message key="boton.descargarDiligenciaEdicto"
					bundle="resources" />
			</c:set>

			<c:set var="liberarPublicacionProperty">
				<bean:message key="boton.liberarPublicacion" bundle="resources" />
			</c:set>

			<display:column media="html" class="listado_expedientes"
				headerClass="cabecera_tabla">
				<c:if
					test="${(nuevaListaPublicados.idEstado=='3' && nuevaListaPublicados.publicadorAsignado==false)}">
					<center>
						<html:link action="/LiberarPublicacionFrontAction.do"
							paramId="idEdictoSeleccionado" paramName="nuevaListaPublicados"
							paramProperty="id">
							<img title="${liberarPublicacionProperty}"
								src="${pageContext.request.contextPath}/img/ico16-rechazar.gif"
								alt="${liberarPublicacionProperty}" />
						</html:link>
					</center>
				</c:if>
			</display:column>

		</display:table>
	</logic:notEmpty>
	<logic:empty name="VisualizarEdictoPublicadorForm"
		property="listaPublicados">
		<span class="bold"> <c:if
				test="${(LoginCertificadoForm.administradorLocal==true)}">
				<bean:message
					key="visualizarListaEdictosPublicaciones.listaVaciaAdm"
					bundle="resources" />
			</c:if> <c:if test="${(LoginCertificadoForm.publicador==true)}">
				<bean:message key="visualizarListaEdictosPublicaciones.listaVacia"
					bundle="resources" />
			</c:if> </span>
	</logic:empty>

</html:form>

