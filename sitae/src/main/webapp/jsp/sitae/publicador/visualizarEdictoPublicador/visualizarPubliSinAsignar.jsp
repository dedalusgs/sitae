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
</script>



<h3>
	<bean:message key="servicio.publicacionesSinAsignar" bundle="resources" />
</h3>

<html:form
	action="/VisualizarPublicacionesSinAsignarFrontAction.do?filtrar=si"
	method="post" enctype="multipart/form-data">

	<logic:messagesPresent>
		<div class="error">
			<html:errors />
		</div>
	</logic:messagesPresent>



	<h3>
		<bean:message key="visualizarListaEdictosSinAsignar.titulo"
			bundle="resources" />
	</h3>
	<h4>
		<c:if test="${(LoginCertificadoForm.administradorLocal==true)}">
			<bean:message key="visualizarListaEdictosSinAsignar.subtituloAdm"
				bundle="resources" />
		</c:if>
		<c:if test="${(LoginCertificadoForm.publicador==true)}">
			<bean:message key="visualizarListaEdictosSinAsignar.subtitulo"
				bundle="resources" />
		</c:if>
	</h4>
	<display:table export="true"
		name="${VisualizarPublicacionesSinAsignarForm.listaPublicados}"
		sort="external" defaultsort="1" pagesize="10"
		id="nuevaListaPublicados" partialList="true" size="totalTablaEdictos"
		requestURI="./VisualizarPublicacionesSinAsignarFrontAction.do">


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
			headerClass="cabecera_tabla ancho-60" property="estado"
			title="${estadoProperty}" />

		<c:set var="fechaRedaccionProperty">
			<bean:message key="cabecera.fecha_redaccion" bundle="resources" />
		</c:set>

		<display:column class="listado_representantes"
			headerClass="cabecera_tabla ancho-60" property="fechaRedaccion"
			title="${fechaRedaccionProperty}" />

		<c:set var="fechaPublicacionProperty">
			<bean:message key="cabecera.fecha_publicacion" bundle="resources" />
		</c:set>

		<display:column class="listado_representantes"
			headerClass="cabecera_tabla ancho-60" property="fechaPublicacion"
			title="${fechaPublicacionProperty}" />

		<c:set var="nombreCentroProperty">
			<bean:message key="cabecera.centro_de_procedencia" bundle="resources" />
		</c:set>

		<display:column class="listado_representantes"
			headerClass="cabecera_tabla ancho-60" property="nombreCentro"
			title="${nombreCentroProperty}" />

		<c:set var="tipoEdictoProperty">
			<bean:message key="cabecera.tipo_de_edicto" bundle="resources" />
		</c:set>

		<display:column class="listado_representantes"
			headerClass="cabecera_tabla" property="tipoEdicto"
			title="${tipoEdictoProperty}" />

		<display:column media="html" class="listado_expedientes"
			headerClass="cabecera_tabla">

			<c:set var="verInformacionEdictoProperty">
				<bean:message key="boton.verInformacionEdicto" bundle="resources" />
			</c:set>

			<center>
				<html:link
					action="/MuestraInformacionEdictoFrontAction.do?visualizar=sinAsignar"
					paramId="idEdictoSeleccionado" paramName="nuevaListaPublicados"
					paramProperty="id">
					<img title="${verInformacionEdictoProperty}"
						src="${pageContext.request.contextPath}/img/ico16-buscar.gif"
						alt="${verInformacionEdictoProperty}" />
				</html:link>
			</center>

		</display:column>

		<c:set var="asignarEdictoPendientePublicacionConfirmacionProperty">
			<bean:message
				key="boton.asignarEdictoPendientePublicacionConfirmacion"
				bundle="resources" />
		</c:set>
		<c:set var="asignarEdictoPendientePublicacionProperty">
			<bean:message key="boton.asignarEdictoPendientePublicacion"
				bundle="resources" />
		</c:set>

		<display:column media="html" class="listado_expedientes"
			headerClass="cabecera_tabla">

			<center>
				<html:link action="/AsignarPublicacionPendienteDoAction.do"
					paramId="idEdictoSeleccionado" paramName="nuevaListaPublicados"
					paramProperty="id">
					<img title="${asignarEdictoPendientePublicacionProperty}"
						src="${pageContext.request.contextPath}/img/ico16-asignar.gif"
						onclick="return confirmarBorrado('${asignarEdictoPendientePublicacionConfirmacionProperty}');"
						alt="${asignarEdictoPendientePublicacionProperty}" />
				</html:link>
			</center>

		</display:column>

	</display:table>


</html:form>

