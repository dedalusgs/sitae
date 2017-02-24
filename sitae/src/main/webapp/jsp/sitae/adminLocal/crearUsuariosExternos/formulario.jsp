<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="idPerfiles" value="objetoPerfil" />
<c:set var="idSeccionCentrosPermitidos"
	value="idSeccionCentrosPermitidos" />

<script type="text/javascript">		
		function CambiaPerfil(objetoPerfil) {
				document.CrearUsuariosForm.action = "./CrearUsuariosExternosFrontAction.do?recarga=si" ;
				document.CrearUsuariosForm.submit();
		}
</script>

<h3>
	<bean:message key="servicio.gestionUsuarios" bundle="resources" />
</h3>

<html:form action="/CrearUsuariosExternosDo.do" method="post"
	enctype="multipart/form-data">

	<logic:messagesPresent>
		<div class="error">
			<html:errors />
		</div>
	</logic:messagesPresent>

	<fieldset>

		<legend>
			<bean:message key="altaOrganismoAplicacion.titulo" bundle="resources" />
		</legend>

		<div class="detalle"> 
			<label><bean:message key="datosusuario.nombreUsuario" bundle="resources"/>(*) (Max 9 Caracteres)</label>
			<html:text name="CrearUsuariosForm" property="usuario.numDocumento" />
		</div>

		<div class="detalle">
			<label>
				<bean:message key="organismoExterno.aplicacion" bundle="resources" />
				(*)(Max 20 Caracteres)
			</label>
			<html:text name="CrearUsuariosForm" property="usuario.nombre" />
		</div>
		
		<div class="detalle">
			<label>
				<bean:message key="datosusuario.password" bundle="resources" />
				(*)
			</label>
			<html:password name="CrearUsuariosForm"
				property="usuarioExterno.password" size="20" />
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosusuario.email" bundle="resources" />
				(*)
			</label>
			<html:text name="CrearUsuariosForm" property="usuario.email" />
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosusuario.perfil" bundle="resources" />
				(*)
			</label>
			<html:select styleClass="" property="opcionPerfil" title="Perfil"
				styleId="objetoPerfil" onchange="CambiaPerfil(objetoPerfil);">
				<html:optionsCollection property="listaPerfil" label="nombre"
					value="idPerfil" />
			</html:select>
		</div>

		<logic:equal name="CrearUsuariosForm" property="opcionPerfil"
			value="3">

			<div>
				<label>
					<bean:message key="datosusuario.centro" bundle="resources" />
					(*)
				</label>
				<html:select name="CrearUsuariosForm" property="opcionCentro">
					<html:option value="-1">
						<bean:message key="select.seleccione" bundle="resources" />
					</html:option>
					<html:optionsCollection property="listaCentros" label="nombre"
						value="idCentro" />
				</html:select>
			</div>



		</logic:equal>

	</fieldset>

	<div align="right">
		<i><bean:message key="campos.obligatorios" bundle="resources" />
		</i>
	</div>

	<div class="hr">
		<hr />
	</div>

	<html:hidden name="CrearUsuariosForm" property="usuario.interno"
		value="true" />

	<div class="botonera">
		<html:submit>
			<bean:message key="boton.guardar" bundle="resources" />
		</html:submit>
	</div>
</html:form>

<html:form action="/VisualizarUsuariosFrontAction.do">
	<div class="botonera border">
		<html:submit>
			<bean:message key="boton.volver" bundle="resources" />
		</html:submit>
	</div>
</html:form>
