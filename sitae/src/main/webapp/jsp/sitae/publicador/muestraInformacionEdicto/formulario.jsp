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



<logic:equal name="MuestraInformacionEdictoForm" property="visualizar"
	value="misRedacciones">
	<h3>
		<bean:message key="servicio.misRedacciones" bundle="resources" />
	</h3>
</logic:equal>

<logic:equal name="MuestraInformacionEdictoForm" property="visualizar"
	value="sinAsignar">
	<h3>
		<bean:message key="servicio.publicacionesSinAsignar"
			bundle="resources" />
	</h3>
</logic:equal>

<logic:equal name="MuestraInformacionEdictoForm" property="visualizar"
	value="misPublicaciones">
	<h3>
		<bean:message key="servicio.misPublicaciones" bundle="resources" />
	</h3>
</logic:equal>

<logic:equal name="MuestraInformacionEdictoForm" property="visualizar"
	value="publicacionOcupada">
	<h3>
		<bean:message key="servicio.misPublicaciones" bundle="resources" />
	</h3>
</logic:equal>
<html:form action="/MuestraInformacionEdictoFrontAction.do"
	method="post" enctype="multipart/form-data">
	<html:hidden name="MuestraInformacionEdictoForm" property="idEdicto" />

	<logic:messagesPresent>
		<div class="error">
			<html:errors />
		</div>
	</logic:messagesPresent>
	<%
		Locale locale = (Locale) session
					.getAttribute(Globals.LOCALE_KEY);
	%>
	<logic:notEmpty name="MuestraInformacionEdictoForm"
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
				action="/MuestraInformacionEdictoFrontAction.do?visualizar=misPublicaciones"
				paramId="idEdictoSeleccionado"
				paramName="MuestraInformacionEdictoForm"
				paramProperty="edicto.sustituidoPor.idEdicto">
				<bean:write name="MuestraInformacionEdictoForm"
					property="edicto.sustituidoPor.tituloVa" />
			</html:link>
			<%
				} else {
			%>
			<html:link title="${verInformacionEdictoProperty}"
				action="/MuestraInformacionEdictoFrontAction.do?visualizar=misPublicaciones"
				paramId="idEdictoSeleccionado"
				paramName="MuestraInformacionEdictoForm"
				paramProperty="edicto.sustituidoPor.idEdicto">
				<bean:write name="MuestraInformacionEdictoForm"
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
						<bean:write name="MuestraInformacionEdictoForm"
							property="edicto.titulo" />
					</div>
					<div class="subRayado">
						<bean:message key="lenguaje.va" bundle="resources" />
					</div>
					<div>
						<bean:write name="MuestraInformacionEdictoForm"
							property="edicto.tituloVa" />
					</div>
				</div>
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
						<bean:write name="MuestraInformacionEdictoForm"
							property="edicto.descripcion" />
					</div>
					<div class="subRayado">
						<bean:message key="lenguaje.va" bundle="resources" />
					</div>
					<div>
						<bean:write name="MuestraInformacionEdictoForm"
							property="edicto.descripcionVa" />
					</div>
				</div>
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.codigo" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoForm"
					property="edicto.codigo" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.numExp" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoForm"
					property="edicto.numExp" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.estado" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoForm"
					property="edicto.estado.nombre" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.centroProcedencia" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoForm"
					property="edicto.centro.nombre" />
			</dd>
		</div>

		<logic:notEqual name="MuestraInformacionEdictoForm"
			property="edicto.organismoExterno" value="">
			<div class="detalle">
				<dt>
					<bean:message key="datosedicto.organismoExterno" bundle="resources" />
				</dt>
				<dd>
					<bean:write name="MuestraInformacionEdictoForm"
						property="edicto.organismoExterno.nombre" />
				</dd>
			</div>
		</logic:notEqual>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.tipoEdicto" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoForm"
					property="edicto.tipoEdicto.nombre" />
			</dd>
		</div>


		<div class="detalle">
			<dt>
				<bean:message key="muestraInformacionEdicto.sustituye"
					bundle="resources" />
			</dt>
			<dd>
				<logic:notEmpty name="MuestraInformacionEdictoForm"
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
						paramName="MuestraInformacionEdictoForm"
						paramProperty="edicto.sustituyeA.idEdicto">
						<bean:write name="MuestraInformacionEdictoForm"
							property="edicto.sustituyeA.tituloVa" />
					</html:link>

					<%
						} else {
					%>
					<html:link title="${verInformacionEdictoProperty}"
						action="/MuestraInformacionEdictoFrontAction.do"
						paramId="idEdictoSeleccionado"
						paramName="MuestraInformacionEdictoForm"
						paramProperty="edicto.sustituyeA.idEdicto">
						<bean:write name="MuestraInformacionEdictoForm"
							property="edicto.sustituyeA.titulo" />
					</html:link>

					<%
						}
					%>
					<%
						}
					%>

					<c:if
						test="${(MuestraInformacionEdictoForm.edicto.estado.idEstado!=5 && MuestraInformacionEdictoForm.edicto.estado.idEstado!=6)}">
						<html:link
							href="SustituirPublicacionesDo.do?idEdicto=${MuestraInformacionEdictoForm.edicto.idEdicto}&accion=baja&id=${MuestraInformacionEdictoForm.edicto.sustituyeA.idEdicto }&origen=publicadorMisRedacciones">
							<img title="${cancelarSustituirEdictoProperty}"
								src="${pageContext.request.contextPath}/img/ico16-rechazar.gif"
								alt="${cancelarSustituirEdictoProperty}" />
						</html:link>
					</c:if>
					<c:if
						test="${(MuestraInformacionEdictoForm.edicto.estado.idEstado==5 || MuestraInformacionEdictoForm.edicto.estado.idEstado==6)}">
						<html:link
							href="SustituirPublicacionesDo.do?idEdicto=${MuestraInformacionEdictoForm.edicto.idEdicto}&accion=baja&id=${MuestraInformacionEdictoForm.edicto.sustituyeA.idEdicto }&origen=publicador">
							<img title="${cancelarSustituirEdictoProperty}"
								src="${pageContext.request.contextPath}/img/ico16-rechazar.gif"
								alt="${cancelarSustituirEdictoProperty}" />
						</html:link>
					</c:if>
				</logic:notEmpty>
				<logic:empty name="MuestraInformacionEdictoForm"
					property="edicto.sustituyeA">
					<c:if
						test="${(MuestraInformacionEdictoForm.edicto.estado.idEstado!=5 && MuestraInformacionEdictoForm.edicto.estado.idEstado!=6)}">
						<html:link
							href="SustituirPublicacionesFrontAction.do?idEdicto=${MuestraInformacionEdictoForm.edicto.idEdicto}&origen=publicadorMisRedacciones">
							<img title="${sustituirEdictoProperty}"
								src="${pageContext.request.contextPath}/img/ico-historicos.gif"
								alt="${sustituirEdictoProperty}" />
						</html:link>
					</c:if>
					<c:if
						test="${(MuestraInformacionEdictoForm.edicto.estado.idEstado==5 || MuestraInformacionEdictoForm.edicto.estado.idEstado==6)}">
						<html:link
							href="SustituirPublicacionesFrontAction.do?idEdicto=${MuestraInformacionEdictoForm.edicto.idEdicto}&origen=publicador">
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
				<bean:message key="datosedicto.fechaPublicacionPropuesta"
					bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoForm"
					property="fechaPublicacionPropuesta" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.diasPublicados" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoForm"
					property="diasPublicados" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.fechaRetiradaPropuesta"
					bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoForm"
					property="fechaRetiradaPropuesta" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.fechaRedaccion" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoForm"
					property="fechaRedaccion" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.fechaUltimaModificacion"
					bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoForm"
					property="fechaUltimaModificacion" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.redactor" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoForm"
					property="nombreRedactor" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.fechaPublicacion" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoForm"
					property="fechaPublicacion" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.fechaRetirada" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoForm"
					property="fechaRetirada" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.publicador" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoForm"
					property="nombrePublicador" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.motivos" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoForm"
					property="edicto.motivoBaja" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.motivosVa" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoForm"
					property="edicto.motivoBajaVa" />
			</dd>
		</div>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.despublicador" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoForm"
					property="nombreDespublicador" />
			</dd>
		</div>
		<c:set var="descargarEdictoProperty">
		     <bean:message key="boton.descargarEdicto" bundle="resources"/>
		</c:set>
		<c:set var="descargarCerficadoDiligenciaEdictoProperty">
		     <bean:message key="boton.descargarCerficadoDiligenciaEdicto" bundle="resources"/>
		</c:set>
		<c:set var="descargarDiligenciaEdictoProperty">
			<bean:message key="boton.descargarDiligenciaEdicto" bundle="resources" /> 
		</c:set>
		<c:if
			test="${(MuestraInformacionEdictoForm.edicto.estado.idEstado!=5 && MuestraInformacionEdictoForm.edicto.estado.idEstado!=6)}">
			<div class="detalle" align="center">
				<a target="_blank"
					title='<bean:message key="boton.descargarEdicto" bundle="resources"/>'
					href="DescargarBorrador.do?id=${MuestraInformacionEdictoForm.edicto.idEdicto }"><bean:message
						key="boton.descargarEdicto" bundle="resources" /> </a>

			</div>
		</c:if>
		<c:if
			test="${(MuestraInformacionEdictoForm.edicto.estado.idEstado==5)}">
			<div class="detalle" align="center">
				<a target="_blank"
					title='<bean:message key="boton.descargarEdicto" bundle="resources"/>'
					href="DescargarAnuncio.do?codigo=${MuestraInformacionEdictoForm.edicto.codigo}"><bean:message
						key="boton.descargarEdicto" bundle="resources" /> 
						<img title="${descargarEdictoProperty}"
							src="${pageContext.request.contextPath}/img/ico-descarga-edicto.gif"
							alt="${descargarEdictoProperty}" />
						</a>
			</div>

			<div class="detalle" align="center">
				<a target="_blank"
					title='<bean:message key="boton.descargarCerficadoPublicacionEdicto" bundle="resources"/>'
					href="DescargarCertificadoPublicacion.do?codigo=${MuestraInformacionEdictoForm.edicto.codigo }"><bean:message
						key="boton.descargarCerficadoPublicacionEdicto" bundle="resources" />
						<img title="${descargarCerficadoDiligenciaEdictoProperty}"
								src="${pageContext.request.contextPath}/img/ico-descargar-publicacion.gif"
								alt="${descargarCerficadoDiligenciaEdictoProperty}" />
				</a>
			</div>
		</c:if>

		<c:if
			test="${(MuestraInformacionEdictoForm.edicto.estado.idEstado==6)}">
			
			
			<div class="detalle" align="center">
			
				<a target="_blank"
					title='${descargarEdictoProperty}'
					href="DescargarAnuncioRetirado.do?codigo=${MuestraInformacionEdictoForm.edicto.codigo}"><bean:message
						key="boton.descargarEdicto" bundle="resources" /> 
						<img title="${descargarEdictoProperty}"
							src="${pageContext.request.contextPath}/img/ico-descarga-edicto.gif"
							alt="${descargarEdictoProperty}" />
						</a>
			</div>
			<div class="detalle" align="center">
			
				<a target="_blank"
					title='${descargarCerficadoDiligenciaEdictoProperty}'
					href="DescargarInformeRevision.do?codigo=${MuestraInformacionEdictoForm.edicto.codigo}"><bean:message
						key="boton.descargarCerficadoDiligenciaEdicto" bundle="resources" />
						<img title="${descargarCerficadoDiligenciaEdictoProperty}"
								src="${pageContext.request.contextPath}/img/ico-descargar-publicacion.gif"
								alt="${descargarCerficadoDiligenciaEdictoProperty}" />
				</a>
			</div>
			<div class="detalle" align="center">
			
				<a target="_blank"
					title='${descargarDiligenciaEdictoProperty}'
					href="DescargarDiligencia.do?codigo=${MuestraInformacionEdictoForm.edicto.codigo}">		
					<bean:message key="boton.descargarDiligenciaEdicto" bundle="resources" />
					<img title="${descargarDiligenciaEdictoProperty}"
								src="${pageContext.request.contextPath}/img/ico-descargar-diligencia.gif"
								alt="${descargarDiligenciaEdictoProperty}" />
				</a>
			</div>	
			
			
			
			
			
			
		</c:if>

	</fieldset>
		<fieldset>
	<legend><bean:message key="datosedicto.difusion" bundle="resources" /></legend>
	<div class="detalle">
		<dt><bean:message key="datosedicto.listacorreo" bundle="resources" /></dt>
		<dd><bean:write name="MuestraInformacionEdictoForm"	property="edicto.listaCorreo" /></dd>
	</div>
	
	<div class="detalle">
		<dt><bean:message key="datosedicto.otrasdirecciones" bundle="resources" /></dt>
		<dd><bean:write name="MuestraInformacionEdictoForm"	property="edicto.otrosCorreos" /></dd>
	</div>
	
	<div class="detalle">
		<dt><bean:message key="redesSociales.tituloGestion" bundle="resources" /></dt>
		<dd><bean:write name="MuestraInformacionEdictoForm"	property="edicto.redesSociales" /></dd>
	</div>
	
	<div class="detalle">
		<dt>HashTags Twitter</dt>
		<dd><bean:write name="MuestraInformacionEdictoForm"	property="edicto.hashtags" /></dd>
	</div>
	
	
	</fieldset>
</html:form>

<logic:notEmpty name="MuestraInformacionEdictoForm"
	property="listaEdictosRelacionados">
	<fieldset>
		<legend>
			<bean:message key="muestraInformacionEdicto.anunciosRelacionados"
				bundle="resources" />
		</legend>
		<logic:equal name="MuestraInformacionEdictoForm" property="visualizar"
			value="misPublicaciones">

			<div align="center" class="botonera">

				<html:form
					action="/RelacionarPublicacionesFrontAction.do?idEdicto=${MuestraInformacionEdictoForm.edicto.idEdicto}&origen=publicador">
					<html:submit>
						<bean:message key="boton.relacionarPublicaciones"
							bundle="resources" />
					</html:submit>
				</html:form>

			</div>
		</logic:equal>
		<logic:equal name="MuestraInformacionEdictoForm" property="visualizar"
			value="publicacionOcupada">

			<div align="center" class="botonera">

				<html:form
					action="/RelacionarPublicacionesFrontAction.do?idEdicto=${MuestraInformacionEdictoForm.edicto.idEdicto}&origen=publicador">
					<html:submit>
						<bean:message key="boton.relacionarPublicaciones"
							bundle="resources" />
					</html:submit>
				</html:form>

			</div>
		</logic:equal>
		<display:table
			name="${MuestraInformacionEdictoForm.listaEdictosRelacionados}"
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
						action="/MuestraInformacionEdictoFrontAction.do"
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

<logic:empty name="MuestraInformacionEdictoForm"
	property="listaEdictosRelacionados">
	<fieldset>
		<legend>
			<bean:message key="muestraInformacionEdicto.anunciosRelacionados"
				bundle="resources" />
		</legend>
		<div align="center" class="botonera">

			<html:form
				action="/RelacionarPublicacionesFrontAction.do?idEdicto=${MuestraInformacionEdictoForm.edicto.idEdicto}&origen=publicador">
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

<logic:equal name="MuestraInformacionEdictoForm" property="visualizar"
	value="misPublicaciones">

	<div align="center" class="botonera">

		<c:if
			test="${(MuestraInformacionEdictoForm.edicto.estado.idEstado==3)}">

			<html:form action="/RechazarPublicacionFrontAction.do">

				<html:submit styleClass="boton-150">
					<bean:message key="boton.rechazarPublicacion" bundle="resources" />
				</html:submit>
			</html:form>
		</c:if>

		<c:if
			test="${(MuestraInformacionEdictoForm.edicto.estado.idEstado==5)}">

			<html:form action="/DarBajaPublicacionFrontAction.do">
				<html:submit>
					<bean:message key="boton.darBajaPublicacion" bundle="resources" />
				</html:submit>
			</html:form>

		</c:if>

		<c:if
			test="${(MuestraInformacionEdictoForm.edicto.estado.idEstado==3)}">

			<html:form action="/PublicarEdictoDo.do">
				<html:submit>
					<bean:message key="boton.publicarEdicto" bundle="resources" />
				</html:submit>
			</html:form>
		</c:if>
		<c:if
			test="${(MuestraInformacionEdictoForm.edicto.estado.idEstado==3)}">

			<html:form action="/ActualizarEdictoPublicadoFrontAction.do">
				<html:submit>
					<bean:message key="boton.modificarEdicto" bundle="resources" />
				</html:submit>
			</html:form>

		</c:if>

	</div>
</logic:equal>

<logic:equal name="MuestraInformacionEdictoForm" property="visualizar"
	value="misRedacciones">
	<html:form action="/VisualizarMisRedaccionesFrontAction.do">
		<div class="botonera border">
			<html:submit>
				<bean:message key="boton.volver" bundle="resources" />
			</html:submit>
		</div>
	</html:form>
</logic:equal>

<logic:equal name="MuestraInformacionEdictoForm" property="visualizar"
	value="sinAsignar">
	<html:form action="/VisualizarPublicacionesSinAsignarFrontAction.do">
		<div class="botonera border">
			<html:submit>
				<bean:message key="boton.volver" bundle="resources" />
			</html:submit>
		</div>
	</html:form>
</logic:equal>

<logic:equal name="MuestraInformacionEdictoForm" property="visualizar"
	value="misPublicaciones">

	<html:form action="/VisualizarEdictoPublicadorFrontAction.do">
		<div class="botonera border">
			<html:submit>
				<bean:message key="boton.volver" bundle="resources" />
			</html:submit>
		</div>
	</html:form>
</logic:equal>
<logic:equal name="MuestraInformacionEdictoForm" property="visualizar"
	value="publicacionOcupada">

	<html:form action="/VisualizarEdictoPublicadorFrontAction.do">
		<div class="botonera border">
			<html:submit>
				<bean:message key="boton.volver" bundle="resources" />
			</html:submit>
		</div>
	</html:form>
</logic:equal>

