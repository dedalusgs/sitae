<%@page import="es.novasoft.comun.constantes.Constantes"%>
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
<script type="text/javascript">var switchTo5x=true;</script>
<script type="text/javascript" src="http://w.sharethis.com/button/buttons.js"></script>
<script type="text/javascript">stLight.options({publisher: "fbc1bd27-4a55-465d-95ce-c5e5cd757671", doNotHash: false, doNotCopy: false, hashAddressBar: false});</script>



<%
	String accionPublico = (String) session
			.getAttribute("accionPublico");
	String idAddthis=Constantes.getPropiedad(Constantes.ADDTHIS_ID);
	request.setAttribute("idAddthis", idAddthis);
	
%>

<c:if test="${not empty MuestraInformacionEdictoPublicoForm.edicto.urlAcortada}">
	<c:set var="urlAcortadaEdicto"  >addthis:url="${MuestraInformacionEdictoPublicoForm.edicto.urlAcortada}"</c:set>
</c:if>

<div style="float:right; margin-top:-15px">
<!-- AddThis Button BEGIN -->
<div class="addthis_toolbox addthis_default_style" ${urlAcortadaEdicto}   addthis:title="${MuestraInformacionEdictoPublicoForm.edicto.titulo}">
<a class="addthis_button_facebook_like" fb:like:layout="button_count"  ${urlAcortadaEdicto}  addthis:title="${MuestraInformacionEdictoPublicoForm.edicto.titulo}"></a>
<a class="addthis_button_tweet"   ${urlAcortadaEdicto} tw:text="${MuestraInformacionEdictoPublicoForm.edicto.titulo}" tw:hashtags="${MuestraInformacionEdictoPublicoForm.edicto.hashtags}" tw:via="${organismoSesion.twitter.urlUser}"></a>
<a class="addthis_button_google_plusone" g:plusone:size="medium"  ${urlAcortadaEdicto}  addthis:title="${MuestraInformacionEdictoPublicoForm.edicto.titulo}"></a>
<a class="addthis_counter addthis_pill_style"   ${urlAcortadaEdicto}  addthis:title="${MuestraInformacionEdictoPublicoForm.edicto.titulo}"></a>
</div>

<script type="text/javascript" src="https://s7.addthis.com/js/300/addthis_widget.js#pubid=${idAddthis}"></script>
<!-- AddThis Button END -->
</div>

<c:if test="${(accionPublico=='edictosVigor')}">
	<h3>
		<bean:message key="servicio.edictosVigor" bundle="resources" />
	</h3>
</c:if>
<c:if test="${(accionPublico=='historicoEdictos')}">
	<h3>
		<bean:message key="servicio.historicoEdictos" bundle="resources" />
	</h3>
</c:if>
<c:if test="${(accionPublico=='busquedaAvanzada')}">
	<h3>
		<bean:message key="servicio.busquedaAvanzada" bundle="resources" />
	</h3>
</c:if>
<c:if test="${(accionPublico=='inicio')}">
	<h3>
		<bean:message key="ultimosEdictosPublicados.titulo" bundle="resources" />
	</h3>
</c:if>
<c:if test="${empty accionPublico}">
	<h3>
		<bean:message key="servicio.busquedaAvanzada" bundle="resources" />
	</h3>
</c:if>
<html:form action="/MuestraInformacionEdictoPublicoFrontAction.do"
	method="post" enctype="multipart/form-data">
	<html:hidden name="MuestraInformacionEdictoPublicoForm" property="id" />
	<logic:messagesPresent>
		<div class="error">
			<html:errors />
		</div>
	</logic:messagesPresent>
	<%
			Locale locale = (Locale) session
						.getAttribute(Globals.LOCALE_KEY);
		%>
	<logic:notEmpty name="MuestraInformacionEdictoPublicoForm"
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
					action="/MuestraInformacionEdictoPublicoFrontAction.do"
					paramId="idEdictoSeleccionado" paramName="MuestraInformacionEdictoPublicoForm"
					paramProperty="edicto.sustituidoPor.idEdicto">
					<bean:write name="MuestraInformacionEdictoPublicoForm" property="edicto.sustituidoPor.tituloVa" />
				</html:link>
			<%
			} else {
		%>
							<html:link title="${verInformacionEdictoProperty}"
					action="/MuestraInformacionEdictoPublicoFrontAction.do"
					paramId="idEdictoSeleccionado" paramName="MuestraInformacionEdictoPublicoForm"
					paramProperty="edicto.sustituidoPor.idEdicto">
					<bean:write name="MuestraInformacionEdictoPublicoForm" property="edicto.sustituidoPor.titulo" />
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


		<%
			if (locale != null) {
		%>
		<%
			if (locale.getLanguage().equals("va")) {
		%>


		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.titulo" bundle="resources" />
			</dt>
			<dd>
				<b> <bean:write name="MuestraInformacionEdictoPublicoForm"
						property="edicto.tituloVa" /> </b>
			</dd>
		</div>

		<logic:notEmpty name="MuestraInformacionEdictoPublicoForm"
			property="edicto.descripcionVa">
			<div class="detalle">
				<dt>
					<bean:message key="datosedicto.descripcion" bundle="resources" />
				</dt>
				<dd>
					<bean:write name="MuestraInformacionEdictoPublicoForm"
						property="edicto.descripcionVa" />
				</dd>
			</div>
		</logic:notEmpty>
		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.tipoEdicto" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoPublicoForm"
					property="edicto.tipoEdicto.nombre" />
			</dd>
		</div>
		<%
			} else {
		%>
		<div class="detalleGrande">
			<dt>
				<bean:message key="datosedicto.titulo" bundle="resources" />
			</dt>
			<dd>
				<b> <bean:write name="MuestraInformacionEdictoPublicoForm"
						property="edicto.titulo" /> </b>
			</dd>
		</div>

		<br />
		<logic:notEmpty name="MuestraInformacionEdictoPublicoForm"
			property="edicto.descripcion">
			<div class="detalle">
				<dt>
					<bean:message key="datosedicto.descripcion" bundle="resources" />
				</dt>
				<dd>

					<bean:write name="MuestraInformacionEdictoPublicoForm"
						property="edicto.descripcion" />
				</dd>
			</div>
		</logic:notEmpty>
		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.tipoEdicto" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoPublicoForm"
					property="edicto.tipoEdicto.nombre" />
			</dd>
		</div>
		<%
			}
		%>
		<%
			}
		%>
		<logic:empty name="MuestraInformacionEdictoPublicoForm"
			property="edicto.organismoExterno">
			<div class="detalle">
				<dt>
					<bean:message key="datosedicto.procedencia" bundle="resources" />
				</dt>
				<dd>
					<bean:write name="MuestraInformacionEdictoPublicoForm"
						property="edicto.centro.nombre" />
				</dd>
			</div>
		</logic:empty>

		<logic:notEmpty name="MuestraInformacionEdictoPublicoForm"
			property="edicto.organismoExterno">
			<div class="detalle">
				<dt>
					<bean:message key="datosedicto.procedencia" bundle="resources" />
				</dt>
				<dd>
					<bean:write name="MuestraInformacionEdictoPublicoForm"
						property="edicto.organismoExterno.nombre" />
				</dd>
			</div>
		</logic:notEmpty>

	<logic:notEmpty name="MuestraInformacionEdictoPublicoForm"
		property="edicto.sustituyeA">
			<%
			if (locale != null) {
		%>
			<%
			if (locale.getLanguage().equals("va")) {
		%>
			<div class="detalle">
				<dt>
					<bean:message key="muestraInformacionEdicto.sustituye" bundle="resources" />
				</dt>
				<dd>
<html:link title="${verInformacionEdictoProperty}"
					action="/MuestraInformacionEdictoPublicoFrontAction.do"
					paramId="idEdictoSeleccionado" paramName="MuestraInformacionEdictoPublicoForm"
					paramProperty="edicto.sustituyeA.idEdicto">
					<bean:write name="MuestraInformacionEdictoPublicoForm" property="edicto.sustituyeA.tituloVa" />
				</html:link>
				</dd>
			</div>
			<%
			} else {
		%>
			<div class="detalle">
				<dt>
					<bean:message key="muestraInformacionEdicto.sustituye" bundle="resources" />
				</dt>
				<dd>
<html:link title="${verInformacionEdictoProperty}"
					action="/MuestraInformacionEdictoPublicoFrontAction.do"
					paramId="idEdictoSeleccionado" paramName="MuestraInformacionEdictoPublicoForm"
					paramProperty="edicto.sustituyeA.idEdicto">
					<bean:write name="MuestraInformacionEdictoPublicoForm" property="edicto.sustituyeA.titulo" />
				</html:link>
				</dd>
			</div>

			<%
			}
		%>
			<%
			}
		%>
	</logic:notEmpty>



		<logic:notEqual name="MuestraInformacionEdictoPublicoForm"
			property="nombrePublicador" value="">

			<logic:notEqual name="MuestraInformacionEdictoPublicoForm"
				property="fechaPublicacion" value="">

				<div class="detalle">
					<dt>
						<bean:message key="datosedicto.fechaPublicacion"
							bundle="resources" />
					</dt>
					<dd>
						<bean:write name="MuestraInformacionEdictoPublicoForm"
							property="fechaPublicacion" />
					</dd>
				</div>

			</logic:notEqual>
			<logic:notEqual name="MuestraInformacionEdictoPublicoForm"
				property="fechaRetirada" value="">

				<div class="detalle">
					<dt>
						<bean:message key="datosedicto.fechaPublicacionFin"
							bundle="resources" />
					</dt>
					<dd>
						<bean:write name="MuestraInformacionEdictoPublicoForm"
							property="fechaRetirada" />
					</dd>
				</div>

			</logic:notEqual>
			<logic:equal name="MuestraInformacionEdictoPublicoForm"
				property="fechaRetirada" value="">
				<div class="detalle">
					<dt>
						<bean:message key="datosedicto.fechaRetirada" bundle="resources" />
					</dt>
					<dd>
						<bean:write name="MuestraInformacionEdictoPublicoForm"
							property="fechaPropuestaRetirada" />
					</dd>
				</div>
			</logic:equal>
			<logic:notEqual name="MuestraInformacionEdictoPublicoForm"
				property="nombreDespublicador" value="">
				<%
					if (locale != null) {
				%>
				<%
					if (locale.getLanguage().equals("va")) {
				%>
				<div class="detalle">
					<dt>
						<bean:message key="datosedicto.motivos" bundle="resources" />
					</dt>
					<dd>
						<bean:write name="MuestraInformacionEdictoPublicoForm"
							property="edicto.motivoBajaVa" />
					</dd>
				</div>
				<%
					} else {
				%>

				<div class="detalle">
					<dt>
						<bean:message key="datosedicto.motivos" bundle="resources" />
					</dt>
					<dd>
						<bean:write name="MuestraInformacionEdictoPublicoForm"
							property="edicto.motivoBaja" />
					</dd>
				</div>
				<%
					}
				%>
				<%
					}
				%>
			</logic:notEqual>
		</logic:notEqual>

		<div class="detalle">
			<dt>
				<bean:message key="datosedicto.estado" bundle="resources" />
			</dt>
			<dd>
				<bean:write name="MuestraInformacionEdictoPublicoForm"
					property="edicto.estado.nombre" />
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
			test="${(MuestraInformacionEdictoPublicoForm.edicto.estado.nombre=='PUBLICADO')}">
			<div class="detalle" align="center">
				<a target="_blank"
					title='<bean:message key="boton.descargarEdicto" bundle="resources"/>'
					href="DescargarAnuncio.do?codigo=${MuestraInformacionEdictoPublicoForm.edicto.codigo}"><bean:message
						key="boton.descargarEdicto" bundle="resources" />
						<img title="${descargarEdictoProperty}"
							src="${pageContext.request.contextPath}/img/ico-descarga-edicto.gif"
							alt="${descargarEdictoProperty}" />
						
						</a>
						
			</div>
			<div class="detalle" align="center">
				<a target="_blank"
					title='<bean:message key="boton.descargarCerficadoPublicacionEdicto" bundle="resources"/>'
					href="DescargarCertificadoPublicacion.do?codigo=${MuestraInformacionEdictoPublicoForm.edicto.codigo}"><bean:message
						key="boton.descargarCerficadoPublicacionEdicto" bundle="resources" />
						<img title="${descargarCerficadoDiligenciaEdictoProperty}"
								src="${pageContext.request.contextPath}/img/ico-descargar-publicacion.gif"
								alt="${descargarCerficadoDiligenciaEdictoProperty}" />
				</a>
			</div>

		</c:if>

		<c:if
			test="${(MuestraInformacionEdictoPublicoForm.edicto.estado.nombre=='RETIRADO')}">
	
			<div class="detalle" align="center">
			
				<a target="_blank"
					title='${descargarCerficadoDiligenciaEdictoProperty}'
					href="DescargarInformeRevision.do?codigo=${MuestraInformacionEdictoPublicoForm.edicto.codigo}"><bean:message
						key="boton.descargarCerficadoDiligenciaEdicto" bundle="resources" />
						<img title="${descargarCerficadoDiligenciaEdictoProperty}"
								src="${pageContext.request.contextPath}/img/ico-descargar-publicacion.gif"
								alt="${descargarCerficadoDiligenciaEdictoProperty}" />
				</a>
			</div>
			<div class="detalle" align="center">
			
				<a target="_blank"
					title='${descargarDiligenciaEdictoProperty}'
					href="DescargarDiligencia.do?codigo=${MuestraInformacionEdictoPublicoForm.edicto.codigo}">		
					<bean:message key="boton.descargarDiligenciaEdicto" bundle="resources" />
					<img title="${descargarDiligenciaEdictoProperty}"
								src="${pageContext.request.contextPath}/img/ico-descargar-diligencia.gif"
								alt="${descargarDiligenciaEdictoProperty}" />
				</a>
			</div>	
			
		</c:if>
	</fieldset>
</html:form>

<logic:notEmpty name="MuestraInformacionEdictoPublicoForm"
	property="listaEdictosRelacionados">
	<fieldset>
		<legend>
			<bean:message key="muestraInformacionEdicto.anunciosRelacionados"
				bundle="resources" />
		</legend>
		<display:table
			name="${MuestraInformacionEdictoPublicoForm.listaEdictosRelacionados}"
			sort="external" defaultsort="1" id="nuevaListaPublicados"
			requestURI="./VisualizarEdictoPublicoFrontAction.do">

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

<c:if test="${(accionPublico=='busquedaAvanzada')}">
	<html:form
		action="/VisualizarEdictoPublicoFrontAction.do?accion=busquedaAvanzada&volver=">
		<div class="botonera border">
			<html:submit>
				<bean:message key="boton.volver" bundle="resources" />
			</html:submit>
		</div>
	</html:form>
</c:if>
<c:if test="${(accionPublico=='edictosVigor')}">
	<html:form
		action="/VisualizarEdictoPublicoFrontAction.do?accion=edictosVigor">
		<div class="botonera border">
			<html:submit>
				<bean:message key="boton.volver" bundle="resources" />
			</html:submit>
		</div>
	</html:form>
</c:if>
<c:if test="${(accionPublico=='historicoEdictos')}">
	<html:form
		action="/VisualizarEdictoPublicoFrontAction.do?accion=historicoEdictos&filtrar=s">
		<div class="botonera border">
			<html:submit>
				<bean:message key="boton.volver" bundle="resources" />
			</html:submit>
		</div>
	</html:form>
</c:if>
<c:if test="${(accionPublico=='inicio')}">
	<html:form action="/InitDoAction.do">
		<div class="botonera border">
			<html:submit>
				<bean:message key="boton.volver" bundle="resources" />
			</html:submit>
		</div>
	</html:form>
</c:if>

