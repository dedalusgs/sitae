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

<h3>
	<bean:message key="servicio.gestionEdictos" bundle="resources" />
</h3>

<html:form action="/MuestraInformacionEdictoRedactorFrontAction.do"
	method="post" enctype="multipart/form-data">
	<html:hidden name="MuestraInformacionEdictoRedactorForm" property="id" />
	<logic:messagesPresent>
		<div class="error">
			<html:errors />
		</div>
	</logic:messagesPresent>

	<%
		Locale locale = (Locale) session
					.getAttribute(Globals.LOCALE_KEY);
	%>

	<logic:notEmpty name="MuestraInformacionEdictoRedactorForm"
		property="edicto.sustituidoPor">
		<fieldset>
			<legend>
				<bean:message key="muestraInformacionEdicto.importante"
					bundle="resources" />
			</legend>
			<bean:message key="muestraInformacionEdicto.importante.texto"
				bundle="resources" />

			<%
				if (locale != null) {
			%>
			<%
				if (locale.getLanguage().equals("va")) {
			%>
			<html:link title="${verInformacionEdictoProperty}"
				action="/MuestraInformacionEdictoRedactorFrontAction.do"
				paramId="idEdictoSeleccionado"
				paramName="MuestraInformacionEdictoRedactorForm"
				paramProperty="edicto.sustituidoPor.idEdicto">
				<bean:write name="MuestraInformacionEdictoRedactorForm"
					property="edicto.sustituidoPor.tituloVa" />
			</html:link>
			<%
				} else {
			%>
			<html:link title="${verInformacionEdictoProperty}"
				action="/MuestraInformacionEdictoRedactorFrontAction.do"
				paramId="idEdictoSeleccionado"
				paramName="MuestraInformacionEdictoRedactorForm"
				paramProperty="edicto.sustituidoPor.idEdicto">
				<bean:write name="MuestraInformacionEdictoRedactorForm"
					property="edicto.sustituidoPor.titulo" />
			</html:link>

			<%
				}
			%>
			<%
				}
			%>
		</fieldset>
	</logic:notEmpty>
	<fieldset>

		<legend>
			<bean:message key="muestraInformacionEdicto.titulo"
				bundle="resources" />
		</legend>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.titulo" bundle="resources" />
			</dt>
			<dd>
				<div style="float: left;">
					<div class="subRayado">
						<bean:message key="lenguaje.es" bundle="resources" />
					</div>
					<div>
						<bean:write name="MuestraInformacionEdictoRedactorForm"
							property="edicto.titulo" />
					</div>
					<div class="subRayado">
						<bean:message key="lenguaje.va" bundle="resources" />
					</div>
					<div>
						<bean:write name="MuestraInformacionEdictoRedactorForm"
							property="edicto.tituloVa" />
					</div>
				</div>
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.codigo" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoRedactorForm"
					property="edicto.codigo" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.numExp" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoRedactorForm"
					property="edicto.numExp" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.estado" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoRedactorForm"
					property="edicto.estado.nombre" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.descripcion" bundle="resources" />
			</dt>
			<dd>
				<div style="float: left;">
					<div class="subRayado">
						<bean:message key="lenguaje.es" bundle="resources" />
					</div>
					<div>
						<bean:write name="MuestraInformacionEdictoRedactorForm"
							property="edicto.descripcion" />
					</div>
					<div class="subRayado">
						<bean:message key="lenguaje.va" bundle="resources" />
					</div>
					<div>
						<bean:write name="MuestraInformacionEdictoRedactorForm"
							property="edicto.descripcionVa" />
					</div>
				</div>
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.centroProcedencia" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoRedactorForm"
					property="edicto.centro.nombre" />
			</dd>
		</div>


		<logic:notEqual name="MuestraInformacionEdictoRedactorForm"
			property="edicto.organismoExterno" value="">
			<div class="detalle">
				<dt>
					<bean:message key="datosedicto.organismoExterno" bundle="resources" />
				</dt>
				<dd>
					<bean:write name="MuestraInformacionEdictoRedactorForm"
						property="edicto.organismoExterno.nombre" />
				</dd>
			</div>
		</logic:notEqual>

		<div class="detalle">
			<dt>
				<bean:message key="muestraInformacionEdicto.sustituye"
					bundle="resources" />
			</dt>
			<dd>
				<logic:notEmpty name="MuestraInformacionEdictoRedactorForm"
					property="edicto.sustituyeA">

					<%
						if (locale != null) {
					%>
					<%
						if (locale.getLanguage().equals("va")) {
					%>
					<html:link title="${verInformacionEdictoProperty}"
						action="/MuestraInformacionEdictoFrontAction.do"
						paramId="idEdictoSeleccionado"
						paramName="MuestraInformacionEdictoRedactorForm"
						paramProperty="edicto.sustituyeA.idEdicto">
						<bean:write name="MuestraInformacionEdictoRedactorForm"
							property="edicto.sustituyeA.tituloVa" />
					</html:link>

					<%
						} else {
					%>
					<html:link title="${verInformacionEdictoProperty}"
						action="/MuestraInformacionEdictoFrontAction.do"
						paramId="idEdictoSeleccionado"
						paramName="MuestraInformacionEdictoRedactorForm"
						paramProperty="edicto.sustituyeA.idEdicto">
						<bean:write name="MuestraInformacionEdictoRedactorForm"
							property="edicto.sustituyeA.titulo" />
					</html:link>

					<%
						}
					%>
					<%
						}
					%>

	<c:set var="sustituirEdictoProperty">
		<bean:message key="muestraInformacionEdicto.botonSustituir.alt"
			bundle="resources" />
	</c:set>

	<c:set var="cancelarSustituirEdictoProperty">
		<bean:message key="muestraInformacionEdicto.botonSustituir.borrar"
			bundle="resources" />
	</c:set>
	
					<c:if
						test="${MuestraInformacionEdictoRedactorForm.edicto.estado.idEstado==1}">
						<html:link
							href="SustituirPublicacionesDo.do?idEdicto=${MuestraInformacionEdictoRedactorForm.edicto.idEdicto}&accion=baja&id=${MuestraInformacionEdictoRedactorForm.edicto.sustituyeA.idEdicto }&origen=publicadorMisRedacciones">
							<img title="${cancelarSustituirEdictoProperty}"
								src="${pageContext.request.contextPath}/img/ico16-rechazar.gif"
								alt="${cancelarSustituirEdictoProperty}" />
						</html:link>
					</c:if>
				</logic:notEmpty>
				<logic:empty name="MuestraInformacionEdictoRedactorForm"
					property="edicto.sustituyeA">
					<c:if
						test="${MuestraInformacionEdictoRedactorForm.edicto.estado.idEstado==1}">
						<html:link
							href="SustituirPublicacionesFrontAction.do?idEdicto=${MuestraInformacionEdictoRedactorForm.edicto.idEdicto}&origen=publicadorMisRedacciones">
							<img title="${sustituirEdictoProperty}"
								src="${pageContext.request.contextPath}/img/ico-historicos.gif"
								alt="${sustituirEdictoProperty}" />
						</html:link>
					</c:if>
				</logic:empty>
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.tipoEdicto" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoRedactorForm"
					property="edicto.tipoEdicto.nombre" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.fechaPublicacionPropuesta"
					bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoRedactorForm"
					property="fechaPublicacionPropuesta" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.diasPublicados" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoRedactorForm"
					property="diasPublicados" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.fechaRetiradaPropuesta"
					bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoRedactorForm"
					property="fechaRetiradaPropuesta" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.fechaRedaccion" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoRedactorForm"
					property="fechaRedaccion" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.fechaUltimaModificacion"
					bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoRedactorForm"
					property="fechaUltimaModificacion" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.redactor" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoRedactorForm"
					property="nombreRedactor" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.fechaPublicacion" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoRedactorForm"
					property="fechaPublicacion" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.fechaRetirada" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoRedactorForm"
					property="fechaRetirada" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.publicador" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoRedactorForm"
					property="nombrePublicador" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.motivos" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoRedactorForm"
					property="edicto.motivoBaja" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.motivosVa" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoRedactorForm"
					property="edicto.motivoBajaVa" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.despublicador" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoRedactorForm"
					property="nombreDespublicador" />
			</dd>
		</div>

		<c:if
			test="${(MuestraInformacionEdictoRedactorForm.edicto.estado.idEstado<5) }">
			<c:if
				test="${(MuestraInformacionEdictoRedactorForm.edicto.estado.idEstado>6) }">

				<div class="detalle" align="center">
					<a target="_blank"
						title="<bean:message key="boton.descargarEdicto" bundle="resources"/>"
						href="DescargarBorrador.do?id=${MuestraInformacionEdictoRedactorForm.edicto.idEdicto }"><bean:message
							key="boton.descargarEdicto" bundle="resources" /> </a>
				</div>
			</c:if>
		</c:if>
		<c:if
			test="${(MuestraInformacionEdictoRedactorForm.edicto.estado.idEstado==5) }">
			<div class="detalle" align="center">
				<a target="_blank"
					title='<bean:message key="boton.descargarCerficadoPublicacionEdicto" bundle="resources"/>'
					href="DescargarCertificadoPublicacion.do?codigo=${MuestraInformacionEdictoRedactorForm.edicto.codigo}"><bean:message
						key="boton.descargarCerficadoPublicacionEdicto" bundle="resources" />
				</a>
			</div>
		</c:if>

		<c:if
			test="${(MuestraInformacionEdictoRedactorForm.edicto.estado.idEstado==6)}">
			<div class="detalle" align="center">
				<a target="_blank"
					title='<bean:message key="boton.descargarCerficadoDiligenciaEdicto" bundle="resources"/>'
					href="DescargarInformeRevision.do?codigo=${MuestraInformacionEdictoRedactorForm.edicto.idEdicto }"><bean:message
						key="boton.descargarCerficadoDiligenciaEdicto" bundle="resources" />
				</a>
			</div>
		</c:if>
	</fieldset>
	<fieldset>
	<legend><bean:message key="datosedicto.difusion" bundle="resources" /></legend>
	<div class="detalle">
		<dt><bean:message key="datosedicto.listacorreo" bundle="resources" /></dt>
		<dd><bean:write name="MuestraInformacionEdictoRedactorForm"	property="edicto.listaCorreo" /></dd>
	</div>
	
	<div class="detalle">
		<dt><bean:message key="datosedicto.otrasdirecciones" bundle="resources" /></dt>
		<dd><bean:write name="MuestraInformacionEdictoRedactorForm"	property="edicto.otrosCorreos" /></dd>
	</div>
	
	<div class="detalle">
		<dt><bean:message key="redesSociales.tituloGestion" bundle="resources" /></dt>
		<dd><bean:write name="MuestraInformacionEdictoRedactorForm"	property="edicto.redesSociales" /></dd>
	</div>
	
	<div class="detalle">
		<dt>HashTags Twitter</dt>
		<dd><bean:write name="MuestraInformacionEdictoRedactorForm"	property="edicto.hashtags" /></dd>
	</div>
	
	
	</fieldset>
</html:form>

<logic:notEmpty name="MuestraInformacionEdictoRedactorForm"
	property="listaEdictosRelacionados">
	<fieldset>
		<legend>
			<bean:message key="muestraInformacionEdicto.anunciosRelacionados"
				bundle="resources" />
		</legend>
		<div align="center" class="botonera">

			<html:form
				action="/RelacionarPublicacionesFrontAction.do?idEdicto=${MuestraInformacionEdictoRedactorForm.edicto.idEdicto}&origen=publicador">
				<html:submit>
					<bean:message key="boton.relacionarPublicaciones"
						bundle="resources" />
				</html:submit>
			</html:form>

		</div>
		<display:table
			name="${MuestraInformacionEdictoRedactorForm.listaEdictosRelacionados}"
			sort="external" defaultsort="1" id="nuevaListaPublicados"
			requestURI="./VisualizarEdictoRedactorFrontAction.do">

			<c:set var="verInformacionEdictoProperty">
				<bean:message key="boton.verInformacionEdicto" bundle="resources" />
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

<logic:empty name="MuestraInformacionEdictoRedactorForm"
	property="listaEdictosRelacionados">
	<fieldset>
		<legend>
			<bean:message key="muestraInformacionEdicto.anunciosRelacionados"
				bundle="resources" />
		</legend>
		<div align="center" class="botonera">

			<html:form
				action="/RelacionarPublicacionesFrontAction.do?idEdicto=${MuestraInformacionEdictoRedactorForm.edicto.idEdicto}&origen=publicador">
				<html:submit>
					<bean:message key="boton.relacionarPublicaciones"
						bundle="resources" />
				</html:submit>
			</html:form>

		</div>

		<span class="bold"> <c:if
				test="${(LoginCertificadoForm.administradorLocal==true)}">
				<bean:message
					key="visualizarListaEdictosPublicaciones.listaVaciaAdm"
					bundle="resources" />
			</c:if> <c:if test="${(LoginCertificadoForm.publicador==true)}">
				<bean:message key="visualizarListaEdictosPublicaciones.listaVacia"
					bundle="resources" />
			</c:if> </span>
	</fieldset>
</logic:empty>

<html:form action="/VisualizarEdictoFrontAction.do">
	<div class="botonera border">
		<html:submit>
			<bean:message key="boton.volver" bundle="resources" />
		</html:submit>
	</div>
</html:form>




