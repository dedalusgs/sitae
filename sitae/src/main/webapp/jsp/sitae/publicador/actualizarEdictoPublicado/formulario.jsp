<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<%@page import="java.util.Locale"%>
<%@page import="org.apache.struts.Globals"%>

<script type="text/javascript">

function confirmarModificacion(mensaje) {
	if (confirm(mensaje)) {
		return true
	} else {
		return false;
	}
}
</script>


	<c:set var="sustituirEdictoProperty">
		<bean:message key="muestraInformacionEdicto.botonSustituir.alt"
			bundle="resources" />
	</c:set>

	<c:set var="cancelarSustituirEdictoProperty">
		<bean:message key="muestraInformacionEdicto.botonSustituir.borrar"
			bundle="resources" />
	</c:set>
	<%
	Locale locale = (Locale) session.getAttribute(Globals.LOCALE_KEY);
%>
<h3>
	<bean:message key="servicio.misPublicaciones" bundle="resources" />
</h3>

<c:set var="modificarEdictoConfirmacionProperty">
	<bean:message key="boton.modificarEdictoConfirmacion"
		bundle="resources" />
</c:set>
<html:form action="/ActualizarEdictoPublicadoDo.do"
	onsubmit="return confirmarModificacion('${modificarEdictoConfirmacionProperty}');"
	method="post" enctype="multipart/form-data">

	<logic:messagesPresent>
		<div class="error">
			<html:errors />
		</div>
	</logic:messagesPresent>

	<fieldset>
		<legend>
			<bean:message key="actualizarEdictoPublicado.titulo"
				bundle="resources" />
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
				<html:text name="ActualizarEdictoPublicadoForm"
					property="edicto.titulo" maxlength="80" />
				<div style="display: block; height: 1px; margin: 8px 0;"></div>
				<div class="subRayado">
					<bean:message key="lenguaje.va" bundle="resources" />
				</div>
				<html:text name="ActualizarEdictoPublicadoForm"
					property="edicto.tituloVa" maxlength="80" />
			</div>
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosedicto.descripcion" bundle="resources" />
				(*)
			</label>
			<div style="float: left;">
				<div class="subRayado">
					<bean:message key="lenguaje.es" bundle="resources" />
				</div>
				<html:textarea name="ActualizarEdictoPublicadoForm"
					property="edicto.descripcion" />
				<div style="display: block; height: 1px; margin: 8px 0;"></div>
				<br />
				<div class="subRayado">
					<bean:message key="lenguaje.va" bundle="resources" />
				</div>
				<html:textarea name="ActualizarEdictoPublicadoForm"
					property="edicto.descripcionVa" />
			</div>
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosedicto.numExp" bundle="resources" />
			</label>
			<html:text name="ActualizarEdictoPublicadoForm" maxlength="50"
				property="edicto.numExp" />
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
			<html:text style="width:30%;" name="ActualizarEdictoPublicadoForm"
				property="fechaPublicacionPropuesta" styleId="i_date" readonly="false"
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
			<html:text name="ActualizarEdictoPublicadoForm"
				style="width:30px;" property="diasExposicion" styleId="diasPublicacion"
				onchange="GEdictoActualizadoFechaInicio()" />
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosedicto.fechaRetiradaPropuesta"
					bundle="resources" />
			</label>
			<html:text style="width:30%;" name="ActualizarEdictoPublicadoForm"
				property="fechaRetiradaPropuesta" styleId="i_fecha" readonly="false"
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
			<logic:notEmpty name="ActualizarEdictoPublicadoForm"
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
					paramName="ActualizarEdictoPublicadoForm"
					paramProperty="edictoSust.idEdicto">
					<bean:write name="ActualizarEdictoPublicadoForm"
						property="edictoSust.tituloVa" />
				</html:link>

				<%
					} else {
				%>
				<html:link title="${verInformacionEdictoProperty}"
					action="/CrearEdictoMisRedaccionesFrontAction.do"
					paramId="idEdictoSeleccionado"
					paramName="ActualizarEdictoPublicadoForm"
					paramProperty="edictoSust.idEdicto">
					<bean:write name="ActualizarEdictoPublicadoForm"
						property="edictoSust.titulo" />
				</html:link>

				<%
					}
				%>
				<%
					}
				%>
				<html:link
					href="SustituirPublicacionesDo.do?accion=baja&idEdicto=${ActualizarEdictoPublicadoForm.edicto.idEdicto}&origen=publicadorMisRedacciones&id=${ActualizarEdictoPublicadoForm.edictoSust.idEdicto }">
					<img title="${cancelarSustituirEdictoProperty}"
						src="${pageContext.request.contextPath}/img/ico16-rechazar.gif"
						alt="${cancelarSustituirEdictoProperty}" />
				</html:link>
			</logic:notEmpty>
			<logic:empty name="ActualizarEdictoPublicadoForm" property="edictoSust">
				<html:link
					href="SustituirPublicacionesFrontAction.do?idEdicto=${ActualizarEdictoPublicadoForm.edicto.idEdicto}&origen=publicadorMisRedacciones">
					<img title="${sustituirEdictoProperty}"
						src="${pageContext.request.contextPath}/img/ico-historicos.gif"
						alt="${sustituirEdictoProperty}" />
				</html:link>
			</logic:empty>
		</div>
		
		<div class="detalle" align="center">
			<a target="_blank"
				title='<bean:message key="boton.descargarEdicto" bundle="resources"/>'
				href="DescargarBorrador.do?id=${ActualizarEdictoPublicadoForm.edicto.idEdicto }"><bean:message
					key="boton.descargarEdicto" bundle="resources" />
			</a>
		</div>

	</fieldset>
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
				<c:set target="${ActualizarEdictoPublicadoForm}" property="listaCorreo" value="true"/>
	</div>
	
	<div class="detalle">
		<label><bean:message key="datosedicto.otrasdirecciones" bundle="resources" /></label><html:text disabled="${not ActualizarEdictoPublicadoForm.listaCorreo}" styleId="otrosCorreos"  name="ActualizarEdictoPublicadoForm"
				property="edicto.otrosCorreos" maxlength="512" />
	</div>
	<div class="detalle"><bean:message key="datosedicto.aclaracionOtrosCorreos" bundle="resources" /></div>
	<div class="detalle"><label><bean:message key="redesSociales.tituloGestion" bundle="resources" /></label>
	<input checked="checked" name="redesSociales" disabled="disabled" type="checkbox">
				<c:set target="${ActualizarEdictoPublicadoForm}" property="redesSociales" value="true"/>
	</div>
	<div class="detalle">
		<label>HashTags Twitter</label><html:text  disabled="${not ActualizarEdictoPublicadoForm.redesSociales}" name="ActualizarEdictoPublicadoForm" property="edicto.hashtags" styleId="hashtags" maxlength="50"  />
		
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
		<html:submit>
			<bean:message key="boton.guardar" bundle="resources" />
		</html:submit>
	</div>

</html:form>

<logic:notEmpty name="ActualizarEdictoPublicadoForm"
	property="listaEdictosRelacionados">
	<fieldset>
		<legend>
			<bean:message key="muestraInformacionEdicto.anunciosRelacionados"
				bundle="resources" />
		</legend>

		<div align="center" class="botonera">

			<html:form
				action="/RelacionarPublicacionesFrontAction.do?idEdicto=${ActualizarEdictoPublicadoForm.edicto.idEdicto}&origen=publicador">
				<html:submit>
					<bean:message key="boton.relacionarPublicaciones"
						bundle="resources" />
				</html:submit>
			</html:form>

		</div>


		<display:table
			name="${ActualizarEdictoPublicadoForm.listaEdictosRelacionados}"
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

			<div class="detalle">
				<label>
					<bean:message key="muestraInformacionEdicto.sustituye"
						bundle="resources" />
				</label>

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

<logic:empty name="ActualizarEdictoPublicadoForm"
	property="listaEdictosRelacionados">
	<fieldset>
		<legend>
			<bean:message key="muestraInformacionEdicto.anunciosRelacionados"
				bundle="resources" />
		</legend>
		<div align="center" class="botonera">

			<html:form
				action="/RelacionarPublicacionesFrontAction.do?idEdicto=${ActualizarEdictoPublicadoForm.edicto.idEdicto}&origen=publicador">
				<html:submit>
					<bean:message key="boton.relacionarPublicaciones"
						bundle="resources" />
				</html:submit>
			</html:form>

		</div>
	</fieldset>
</logic:empty>

<html:form action="/VisualizarEdictoPublicadorFrontAction.do">
	<div align="center" class="botonera border">
		<html:submit>
			<bean:message key="boton.volver" bundle="resources" />
		</html:submit>
	</div>
</html:form>



