<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@page import="java.util.Locale"%>
<%@page import="org.apache.struts.Globals"%>

<link type="text/css" rel="stylesheet" href="js/modal.css" />
<link rel="stylesheet" type="text/css" href="css/tagit-simple-grey.css">
<script type="text/javascript" src="js/jquery-ui.1.8.20.min.js"></script> 
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/modal.js"></script>
<script src="js/tagit.js"></script>
<script type="text/javascript">
$('#correos').tagit({tagSource:availableTags, sortable:true });

function publicar() {
	activarModal();
	document.CrearEdictoMisRedaccionesForm.action = "./CrearEdictoMisRedaccionesDo.do?accion=publicar";
}
function guardar() {
	activarModal();
	document.CrearEdictoMisRedaccionesForm.action = "./CrearEdictoMisRedaccionesDo.do?accion=guardar";
}

function cambiarDisplayCheckOrganismoExterno(elemento) {
	var elementoSeleccionOrganismoExterno = document.getElementById(elemento);
	if (elementoSeleccionOrganismoExterno.style.visibility == 'hidden') {
		elementoSeleccionOrganismoExterno.style.visibility = '';
	} else {
		elementoSeleccionOrganismoExterno.style.visibility = 'hidden';
		elementoSeleccionOrganismoExterno.selectedIndex = 0;
	}
}

function loadFirmantes() {
	document.CrearEdictoMisRedaccionesForm.action = "./CrearEdictoMisRedaccionesFrontAction.do";
	document.CrearEdictoMisRedaccionesForm.submit();
} 
</script>

<%
	Locale locale = (Locale) session.getAttribute(Globals.LOCALE_KEY);
%>

<h3>
	<bean:message key="servicio.misRedacciones" bundle="resources" />
</h3>

<html:form action="/CrearEdictoMisRedaccionesDo.do" method="post"
	enctype="multipart/form-data">

	<logic:messagesPresent>
		<div class="error">
			<html:errors />
		</div>
	</logic:messagesPresent>

	<c:set var="verInformacionEdictoProperty">
		<bean:message key="boton.verInformacionEdicto" bundle="resources" />
	</c:set>

	<c:set var="sustituirEdictoProperty">
		<bean:message key="muestraInformacionEdicto.botonSustituir.alt"
			bundle="resources" />
	</c:set>

	<c:set var="cancelarSustituirEdictoProperty">
		<bean:message key="muestraInformacionEdicto.botonSustituir.borrar"
			bundle="resources" />
	</c:set>

	<fieldset>

		<legend>
			<bean:message key="crearEdicto.titulo" bundle="resources" />
		</legend>

		<div class="detalle">
			<label>
				<bean:message key="datosedicto.titulo" bundle="resources" />
				(*)
			</label>
			<div style="float: left;">
				<div class="subRayado">
					<bean:message key="lenguaje.es" bundle="resources" />
				</div>
				<html:textarea name="CrearEdictoMisRedaccionesForm"
					property="edicto.titulo" />
				<div style="display: block; height: 1px; margin: 8px 0;"></div>
				<br />
				<div class="subRayado">
					<bean:message key="lenguaje.va" bundle="resources" />
				</div>
				<html:textarea name="CrearEdictoMisRedaccionesForm"
					property="edicto.tituloVa" />
			</div>
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosedicto.descripcion" bundle="resources" />
			</label>
			<div style="float: left;">
				<div class="subRayado">
					<bean:message key="lenguaje.es" bundle="resources" />
				</div>
				<html:textarea name="CrearEdictoMisRedaccionesForm"
					property="edicto.descripcion" />
				<div style="display: block; height: 1px; margin: 8px 0;"></div>
				<br />
				<div class="subRayado">
					<bean:message key="lenguaje.va" bundle="resources" />
				</div>
				<html:textarea name="CrearEdictoMisRedaccionesForm"
					property="edicto.descripcionVa" />
			</div>
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosedicto.numExp" bundle="resources" />
			</label>
			<html:text name="CrearEdictoMisRedaccionesForm"
				property="edicto.numExp" maxlength="50" />
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosedicto.centroProcedencia" bundle="resources" />
				(*)
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
			<logic:equal name="CrearEdictoMisRedaccionesForm"
				property="seleccionadoOrganismoExterno" value="true">
				<input class="check" type="checkbox"
					name="seleccionadoOrganismoExterno" checked styleClass="check"
					style="width: 40px;"
					onclick="cambiarDisplayCheckOrganismoExterno('opcionOrganismoExterno');" />
				<html:select property="opcionOrganismoExterno"
					styleId="opcionOrganismoExterno">
					<html:option value="-1">
						<bean:message key="select.seleccione" bundle="resources" />
					</html:option>
					<html:optionsCollection property="listaOrganismosExternos"
						label="nombre" value="idOrg" />
				</html:select>

			</logic:equal>

			<logic:notEqual name="CrearEdictoMisRedaccionesForm"
				property="seleccionadoOrganismoExterno" value="true">
				<input class="check" type="checkbox"
					name="seleccionadoOrganismoExterno" styleClass="check"
					style="width: 40px;"
					onclick="cambiarDisplayCheckOrganismoExterno('opcionOrganismoExterno');" />
				<html:select property="opcionOrganismoExterno"
					style="visibility:hidden;" styleId="opcionOrganismoExterno">
					<html:option value="-1">
						<bean:message key="select.seleccione" bundle="resources" />
					</html:option>
					<html:optionsCollection property="listaOrganismosExternos"
						label="nombre" value="idOrg" />
				</html:select>
			</logic:notEqual>
		</div>


		<div class="detalle">
			<label>
				<bean:message key="datosedicto.tipoEdicto" bundle="resources" />
				(*)
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
				<bean:message key="datosedicto.tipoPublicacion" 	bundle="resources" />
		</label>
				 
				   <html:radio onchange="GEdictoActualizadoFechaInicio()"  styleId="tipoPublicacion"  style="float: none; width: 40px;" property="tipoPublicacion"  value="LAB"><bean:message key="datosedicto.diasLaborables" 	bundle="resources" /></html:radio>
				   <html:radio onchange="GEdictoActualizadoFechaInicio()" styleId="tipoPublicacion" style="float: none; margin-left:40px ;width: 40px;" property="tipoPublicacion" value="NAT"><bean:message key="datosedicto.diasNaturales" 	bundle="resources" /></html:radio> 
				 
        </div>


		<div class="detalle">
			<label>
				<bean:message key="datosedicto.fechaPublicacionPropuesta"
					bundle="resources" />
				(*)
			</label>
			<html:text maxlength="10" name="CrearEdictoMisRedaccionesForm"
				property="fechaPublicacion" styleId="i_date" readonly="false"
				styleClass="detalleCalendar"
				onchange="GEdictoActualizadoFechaInicio()" />
			<html:image bundle="resources" altKey="seleciona.fecha"
				styleClass="input_img" titleKey="seleciona.fecha"
				src="${pageContext.request.contextPath}/img/calendar.gif"
				styleId="i_trigger"  onclick="return false;"
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
	onSelect   : function() { this.hide() ;GEdictoActualizadoFechaInicio();}
	
});
</script>
		<div class="detalle">
			<label>
				<bean:message key="datosedicto.diasPublicados" bundle="resources" />
				(*)
			</label>
			<html:text name="CrearEdictoMisRedaccionesForm" maxlength="4"
				style="width:30px;" property="diasPublicados" styleId="diasPublicacion"
				onchange="GEdictoActualizadoFechaInicio()" />
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosedicto.fechaRetiradaPropuesta"
					bundle="resources" />
				(*)
			</label>
			<html:text maxlength="10" name="CrearEdictoMisRedaccionesForm"
				property="fechaRetirada" styleId="i_fecha" readonly="false"
				styleClass="detalleCalendar"
				onchange="GEdictoActualizadoFechaFin()" />
			<html:image bundle="resources" altKey="seleciona.fecha"
				styleClass="input_img" titleKey="seleciona.fecha"
				src="${pageContext.request.contextPath}/img/calendar.gif"
				styleId="trigger"  onclick="return false;"
				onmouseover="this.src='${pageContext.request.contextPath}/img/calendar.gif';"
				onmouseout="this.src='${pageContext.request.contextPath}/img/calendar.gif';" />
		</div>


		<script type="text/javascript">
		Calendar.setup( {
			inputField : "i_fecha",
			dateFormat : "%d/%m/%Y",
			showsTime : false,
			timeFormat : "24",
			trigger : "trigger",
			onSelect   : function() { this.hide();GEdictoActualizadoFechaFin(); }
			
		});

</script>
		<div class="detalle">
			<label>
				<bean:message key="muestraInformacionEdicto.sustituye"
					bundle="resources" />
			</label>
				<logic:notEmpty name="CrearEdictoMisRedaccionesForm"
					property="edictoSust">

					<%
						if (locale != null) {
					%>
					<%
						if (locale.getLanguage().equals("va")) {
					%>
					<html:link title="${verInformacionEdictoProperty}"
						action="/CrearEdictoMisRedaccionesFrontAction.do"
						paramId="idEdictoSeleccionado"
						paramName="CrearEdictoMisRedaccionesForm"
						paramProperty="edictoSust.idEdicto">
						<bean:write name="CrearEdictoMisRedaccionesForm"
							property="edictoSust.tituloVa" />
					</html:link>

					<%
						} else {
					%>
					<html:link title="${verInformacionEdictoProperty}"
						action="/CrearEdictoMisRedaccionesFrontAction.do"
						paramId="idEdictoSeleccionado"
						paramName="CrearEdictoMisRedaccionesForm"
						paramProperty="edictoSust.idEdicto">
						<bean:write name="CrearEdictoMisRedaccionesForm"
							property="edictoSust.titulo" />
					</html:link>

					<%
						}
					%>
					<%
						}
					%>
					<html:link
						href="SustituirPublicacionesDo.do?accion=baja&idEdicto=0&origen=crearMisRedacciones&id=${CrearEdictoMisRedaccionesForm.edictoSust.idEdicto }">
						<img title="${cancelarSustituirEdictoProperty}"
							src="${pageContext.request.contextPath}/img/ico16-rechazar.gif"
							alt="${cancelarSustituirEdictoProperty}" />
					</html:link>
				</logic:notEmpty>
				<logic:empty name="CrearEdictoMisRedaccionesForm"
					property="edictoSust">
					<html:link href="SustituirPublicacionesFrontAction.do?idEdicto=0&origen=crearMisRedacciones">
						<img title="${sustituirEdictoProperty}"
							src="${pageContext.request.contextPath}/img/ico-historicos.gif"
							alt="${sustituirEdictoProperty}" />
					</html:link>
				</logic:empty>
		</div>
		
		
		
		<logic:equal name="CrearEdictoMisRedaccionesForm"
			property="opcionTipoFirma" value="-1">
		<div class="detalle">
			<label>
				<bean:message key="datosedicto.tipoFirma" bundle="resources" />
				(*)
			</label>
			<html:select property="opcionTipoFirma" onchange="loadFirmantes();">
				<html:option value="-1">
					<bean:message key="select.seleccione" bundle="resources" />
				</html:option>
				<html:optionsCollection property="listaTiposFirma" label="nombre"
					value="idTipoFirma" />
			</html:select>
		</div>
		</logic:equal>


		<logic:equal name="CrearEdictoMisRedaccionesForm"
			property="opcionTipoFirma" value="2">

			<div class="detalle" id="menuDiv">
				<label>
					<bean:message key="datosusuario.firmante" bundle="resources" />
					(*)
				</label>
				<html:select property="opcionFirmantes">
					<html:option value="-1">
						<bean:message key="select.seleccione" bundle="resources" />
					</html:option>
					<html:optionsCollection property="listaFirmantesNombres"
						label="nombre" value="idUsuarioFirmante" />
				</html:select>
			</div>



		</logic:equal>

		<div class="detalle">
			<label>
				<bean:message key="datosedicto.docAdjunto" bundle="resources" />
				(*)
			</label>
			<html:file name="CrearEdictoMisRedaccionesForm" property="pdf"
				styleClass="file" />
		</div>

	</fieldset>
	
	<script type="text/javascript">
	function redesSocialesfun(check){
		
		if ($(check).is(":checked")){
			
			$("#hashtags").removeAttr('disabled');
			
		}else{
			$("#hashtags").attr('disabled','disabled');
			$("#hashtags").val("");
			
		}
	}
	
	function listaCorreofun(check){
		if ($(check).is(":checked")){
			$("#otrosCorreos").removeAttr('disabled');
		}else{
			$("#otrosCorreos").attr('disabled','disabled');
			$("#otrosCorreos").val("");
		}
	}
	
	</script>
	<fieldset>
	<legend><bean:message key="datosedicto.difusion" bundle="resources" /></legend>
	<div class="detalle"><label><bean:message key="datosedicto.listacorreo" bundle="resources" /></label>
	<input checked="checked" name="listaCorreo" disabled="disabled" type="checkbox">
	<c:set target="${CrearEdictoMisRedaccionesForm}" property="listaCorreo" value="true"/>
	</div>
	
	<div class="detalle">
		<label><bean:message key="datosedicto.otrasdirecciones" bundle="resources" /></label><html:text disabled="${not CrearEdictoMisRedaccionesForm.listaCorreo}" styleId="otrosCorreos"  name="CrearEdictoMisRedaccionesForm"
				property="edicto.otrosCorreos" maxlength="512" />
	</div>
	
	<div class="detalle"><bean:message key="datosedicto.aclaracionOtrosCorreos" bundle="resources" /></div>
	<div class="detalle"><label><bean:message key="redesSociales.tituloGestion" bundle="resources" /></label>
	<input checked="checked" name="redesSociales" disabled="disabled" type="checkbox">
	<c:set target="${CrearEdictoMisRedaccionesForm}" property="redesSociales" value="true"/>
	</div>
	<div class="detalle">
		<label>HashTags Twitter</label><html:text  disabled="${not CrearEdictoMisRedaccionesForm.redesSociales}" name="CrearEdictoMisRedaccionesForm"
				property="edicto.hashtags" styleId="hashtags" maxlength="50"  />
	</div>
	
	
	</fieldset>
	
	
	<div align="right">
		<i><bean:message key="campos.obligatorios" bundle="resources" />
		</i>
	</div>

	<div class="hr">
		<hr />
	</div>

	<div class="botonera">
		<html:submit onclick="guardar()" >
			<bean:message key="boton.guardar" bundle="resources" />
		</html:submit>
		<logic:equal name="CrearEdictoMisRedaccionesForm"
			property="opcionTipoFirma" value="2">
			<html:submit styleClass="boton-150" 
				onclick="publicar()">
				<bean:message key="boton.portafirmas" bundle="resources" />
			</html:submit>
		</logic:equal>
		<logic:notEqual name="CrearEdictoMisRedaccionesForm"
			property="opcionTipoFirma" value="2">
			<html:submit onclick="publicar()" styleId="button2">
				<bean:message key="boton.publicarEdicto" bundle="resources" />
			</html:submit>
		</logic:notEqual>
	</div>

</html:form>

<logic:notEmpty name="CrearEdictoMisRedaccionesForm"
	property="listaEdictosRelacionados">
	<fieldset>
		<legend>
			<bean:message key="muestraInformacionEdicto.anunciosRelacionados"
				bundle="resources" />
		</legend>

			<div align="center" class="botonera">

				<html:form
					action="/RelacionarPublicacionesFrontAction.do?idEdicto=0&origen=crearMisRedacciones">
					<html:submit>
						<bean:message key="boton.relacionarPublicaciones"
							bundle="resources" />
					</html:submit>
				</html:form>

			</div>


		<display:table
			name="${CrearEdictoMisRedaccionesForm.listaEdictosRelacionados}"
			sort="external" defaultsort="1" id="nuevaListaPublicados"
			requestURI="./VisualizarEdictoFrontAction.do">

			<c:set var="verInformacionEdictoProperty">
				<bean:message key="boton.verInformacionEdicto" bundle="resources" />
			</c:set>

			<c:set var="sustituirEdictoProperty">
				<bean:message key="muestraInformacionEdicto.botonSustituir.alt"
					bundle="resources" />
			</c:set>

			<c:set var="cancelarSustituirEdictoProperty">
				<bean:message key="muestraInformacionEdicto.botonSustituir.borrar"
					bundle="resources" />
			</c:set>

			<c:set var="tituloProperty">
				<bean:message key="cabecera.titulo" bundle="resources" />
			</c:set>

			<display:column class="listado_representantes" media="html"
				headerClass="cabecera_tabla ancho-400" title="${tituloProperty}">
				<c:if test="${(nuevaListaPublicados.idEstado=='6') || (nuevaListaPublicados.idEstado=='5')}">
					<html:link title="${verInformacionEdictoProperty}"
						action="/MuestraInformacionEdictoPublicoFrontAction.do"
						paramId="idEdictoSeleccionado" paramName="nuevaListaPublicados"
						paramProperty="id">
						<bean:write name="nuevaListaPublicados" property="titulo" />
					</html:link>
				</c:if>
				<c:if test="${(nuevaListaPublicados.idEstado!='6') && (nuevaListaPublicados.idEstado!='5')}">
					<bean:write name="nuevaListaPublicados" property="titulo" />
					<span>[<bean:message key="cabecera.nopublicado"
							bundle="resources" />]</span>
				</c:if>
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


			<display:column class="listado_representantes" media="html"
				headerClass="cabecera_tabla" property="fechaPublicacion"
				title="${fechaPublicacionProperty}" />

			<c:set var="fechaRetiradaPublicacionProperty">
				<bean:message key="cabecera.fecha_retirada" bundle="resources" />
			</c:set>

			<c:if test="${(nuevaListaPublicados.idEstado=='6')}">
				<display:column media="html" class="listado_representantes"
					headerClass="cabecera_tabla" property="fechaRetirada"
					title="${fechaRetiradaPublicacionProperty}" />

			</c:if>

		</display:table>
	</fieldset>
</logic:notEmpty>

<logic:empty name="CrearEdictoMisRedaccionesForm"
	property="listaEdictosRelacionados">
	<fieldset>
		<legend>
			<bean:message key="muestraInformacionEdicto.anunciosRelacionados"
				bundle="resources" />
		</legend>
		<div align="center" class="botonera">

			<html:form
				action="/RelacionarPublicacionesFrontAction.do?idEdicto=0&origen=crearMisRedacciones">
				<html:submit>
					<bean:message key="boton.relacionarPublicaciones"
						bundle="resources" />
				</html:submit>
			</html:form>

		</div>
	</fieldset>
</logic:empty>


<html:form action="/VisualizarMisRedaccionesFrontAction.do">
	<div class="botonera border">
		<html:submit>
			<bean:message key="boton.volver" bundle="resources" />
		</html:submit>
	</div>
</html:form>



