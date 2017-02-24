<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script language="Javascript">

function confirmarBorrado(mensaje) {
	if (confirm(mensaje)) {
		return true;
	} else {
		return false;
	}
}
function publicar() {
	document.VisualizarUsuariosForm.action = "./CrearUsuariosExternosFrontAction.do";
}
</script>


<h3>
	<bean:message key="servicio.gestionUsuarios" bundle="resources" />
</h3>
<html:form action="/VisualizarUsuariosFrontAction.do?filtrar=si"
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
				<bean:message key="datosusuario.NIF" bundle="resources" />
			</label>
			<html:text name="VisualizarUsuariosForm" property="nif" />
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosusuario.nombre" bundle="resources" />
			</label>
			<html:text name="VisualizarUsuariosForm" property="nombre" />
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosusuario.perfil" bundle="resources" />
			</label>
			<html:select property="opcionPerfiles">
				<html:option value="-1">
					<bean:message key="select.seleccione" bundle="resources" />
				</html:option>
				<html:optionsCollection property="listaPerfiles" label="nombre"
					value="idPerfil" />
			</html:select>
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosusuario.centro" bundle="resources" />
			</label>
			<html:select property="opcionCentros">
				<html:option value="-1">
					<bean:message key="select.seleccione" bundle="resources" />
				</html:option>
				<html:optionsCollection property="listaCentros" label="nombre"
					value="idCentro" />
			</html:select>
		</div>
	</fieldset>

	<div class="botonera">
		<html:submit>
			<bean:message key="boton.filtrar" bundle="resources" />
		</html:submit>
	</div>

	<div>
		<h3>
			<bean:message key="visualizarListaPublicadoresRedactores.titulo"
				bundle="resources" />
		</h3>
	</div>

	<logic:notEmpty name="nuevaListaUsuariosPublicadoresRedactores">

		<display:table export="true"
			name="${VisualizarUsuariosForm.nuevaListaUsuariosPublicadoresRedactores}"
			id="nuevaListaUsuariosPublicadoresRedactores" pagesize="10"
			sort="list" requestURI="./VisualizarUsuariosFrontAction.do">

			<c:set var="nifProperty">
				<bean:message key="cabecera.nifCodigo" bundle="resources" />
			</c:set>

			<display:column class="listado_representantes"
				headerClass="cabecera_tabla" property="numDocumento"
				title="${nifProperty}" />

			<c:set var="nombreProperty">
				<bean:message key="cabecera.nombre" bundle="resources" />
			</c:set>

			<display:column class="listado_representantes"
				headerClass="cabecera_tabla" property="nombreUsuario"
				title="${nombreProperty}" />

			<c:set var="emailProperty">
				<bean:message key="cabecera.email" bundle="resources" />
			</c:set>

			<display:column class="listado_representantes"
				headerClass="cabecera_tabla" property="email"
				title="${emailProperty}" />

			<c:set var="perfilProperty">
				<bean:message key="cabecera.perfil" bundle="resources" />
			</c:set>

			<display:column class="listado_representantes"
				headerClass="cabecera_tabla" property="perfil"
				title="${perfilProperty}" />

			<c:set var="modificarUsuarioProperty">
				<bean:message key="boton.modificarUsuario" bundle="resources" />
			</c:set>

			<display:column media="html" class="listado_representantes"
				headerClass="cabecera_tabla">

				<center>
					
					<html:link action="/ModificarUsuariosFrontAction.do"
						paramId="idUsuarioSeleccionado"
						paramName="nuevaListaUsuariosPublicadoresRedactores"
						paramProperty="numDocumento">
						<img title="${modificarUsuarioProperty}"
							src="${pageContext.request.contextPath}/img/ico16-editar.gif"
							alt="${modificarUsuarioProperty}" />
					</html:link>
					
						
				</center>

			</display:column>

			<c:set var="eliminarUsuarioProperty">
				<bean:message key="boton.eliminarUsuario" bundle="resources" />
			</c:set>
			<c:set var="eliminarUsuarioMensajeConfirmacionProperty">
				<bean:message key="boton.eliminarUsuarioConfirmacion"
					bundle="resources" />
			</c:set>

			<display:column media="html" class="listado_expedientes"
				headerClass="cabecera_tabla">

				<center>
					<html:link action="/BajaUsuarioDo.do"
						paramId="idUsuarioSeleccionado"
						paramName="nuevaListaUsuariosPublicadoresRedactores"
						paramProperty="numDocumento">
						<img title="${eliminarUsuarioProperty}"
							onclick="return confirmarBorrado('${eliminarUsuarioMensajeConfirmacionProperty}');"
							src="${pageContext.request.contextPath}/img/ico16-borrar.gif"
							alt="${eliminarUsuarioProperty}" />
					</html:link>
				</center>

			</display:column>

			<c:set var="verInformacionUsuarioProperty">
				<bean:message key="boton.verInformacionUsuario" bundle="resources" />
			</c:set>

			<display:column media="html" class="listado_expedientes"
				headerClass="cabecera_tabla">
				<center>
					<html:link action="/MuestraInformacionUsuarioFrontAction.do"
						paramId="idUsuarioSeleccionado"
						paramName="nuevaListaUsuariosPublicadoresRedactores"
						paramProperty="numDocumento">
						<img title="${verInformacionUsuarioProperty}"
							src="${pageContext.request.contextPath}/img/ico16-buscar.gif"
							alt="${verInformacionUsuarioProperty}" />
					</html:link>
				</center>

			</display:column>

		</display:table>

	</logic:notEmpty>

	<logic:empty name="nuevaListaUsuariosPublicadoresRedactores">
		<h5>
			<bean:message key="listaPublicadoresRedactores.vacia"
				bundle="resources" />
		</h5>
	</logic:empty>

</html:form>

<br/>

<html:form action="/CrearUsuariosFrontAction.do" method="post"
	enctype="multipart/form-data">
	<div class="botonera">
		
		<html:submit>
			<bean:message key="boton.nuevoUsuario" bundle="resources" />
		</html:submit>
		<html:link  action="./CrearUsuariosExternosFrontAction.do">
				<bean:message key="boton.nuevoUsuarioExterno" bundle="resources" />
			</html:link>
	</div>

</html:form>

