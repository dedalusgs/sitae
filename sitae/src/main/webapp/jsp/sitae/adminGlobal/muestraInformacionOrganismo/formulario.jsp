<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>


<h3>
	<bean:message key="servicio.gestionOrganismos" bundle="resources" />
</h3>

<html:form action="/MuestraInformacionOrganismoFrontAction.do"
	method="post" enctype="multipart/form-data">

	<logic:messagesPresent>
		<div class="error">
			<html:errors />
		</div>
	</logic:messagesPresent>

	<fieldset>

		<legend>
			<bean:message key="muestraInformacionOrganismo.titulo"
				bundle="resources" />
		</legend>

		<div class="detalle">
			<label>
				<bean:message key="datosorganismo.cif" bundle="resources" />
			</label>
			<bean:write name="MuestraInformacionOrganismoForm"
				property="organismo.cif" />
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosorganismo.codigo" bundle="resources" />
			</label>
			<bean:write name="MuestraInformacionOrganismoForm"
				property="organismo.codigo" />
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosorganismo.nombre" bundle="resources" />
			</label>
			<div style="float: left;">
				<div class="subRayado">
					<bean:message key="lenguaje.es" bundle="resources" />
				</div>
				<div>
					<bean:write name="MuestraInformacionOrganismoForm"
						property="organismo.nombre" />
				</div>
				<div class="subRayado">
					<bean:message key="lenguaje.va" bundle="resources" />
				</div>
				<div>
					<bean:write name="MuestraInformacionOrganismoForm"
						property="organismo.nombreVa" />
				</div>
			</div>
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosorganismo.direccion" bundle="resources" />
			</label>
			<div style="float: left;">
				<div class="subRayado">
					<bean:message key="lenguaje.es" bundle="resources" />
				</div>
				<div>
					<bean:write name="MuestraInformacionOrganismoForm"
						property="organismo.direccion" />
				</div>
				<div class="subRayado">
					<bean:message key="lenguaje.va" bundle="resources" />
				</div>
				<div>
					<bean:write name="MuestraInformacionOrganismoForm"
						property="organismo.direccionVa" />
				</div>
			</div>
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosorganismo.telefono" bundle="resources" />
			</label>
			<bean:write name="MuestraInformacionOrganismoForm"
				property="organismo.telefono" />
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosorganismo.fax" bundle="resources" />
			</label>
			<bean:write name="MuestraInformacionOrganismoForm"
				property="organismo.fax" />
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosorganismo.email" bundle="resources" />
			</label>
			<bean:write name="MuestraInformacionOrganismoForm"
				property="organismo.email" />
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosorganismo.dominio" bundle="resources" />
			</label>
			<bean:write name="MuestraInformacionOrganismoForm"
				property="organismo.dominio" />
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosorganismo.aliasSello" bundle="resources" />
				(*)
			</label>
			<bean:write name="MuestraInformacionOrganismoForm"
				property="organismo.aliasSello" />
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosorganismo.tema" bundle="resources" />
			</label>

			<logic:iterate id="listaTemas" name="MuestraInformacionOrganismoForm"
				property="listaTemas">
				<logic:equal name="MuestraInformacionOrganismoForm"
					property="organismo.tema" value="${listaTemas.id}">
					<bean:write name="listaTemas" property="nombre" />
				</logic:equal>
			</logic:iterate>
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosorganismo.imagen" bundle="resources" />
			</label>
			<img
				src='<bean:write name="MuestraInformacionOrganismoForm" property="imagenActual"/>' />
		</div>

		<div class="hr"></div>
		<h4>
			<bean:message key="visualizarListaAdmLocales.titulo"
				bundle="resources" />
		</h4>
		<logic:notEmpty name="listaUsuarios">



			<display:table
				name="${MuestraInformacionOrganismoForm.listaUsuarios}"
				id="idUsuario" pagesize="10" sort="list"
				requestURI="./MuestraInformacionOrganismoFrontAction.do">

				<c:set var="nifProperty">
					<bean:message key="cabecera.nif" bundle="resources" />
				</c:set>

				<display:column class="listado_representantes"
					headerClass="cabecera_tabla" property="numDocumento"
					title="${nifProperty}" />

				<c:set var="nombreProperty">
					<bean:message key="cabecera.nombre" bundle="resources" />
				</c:set>

				<display:column class="listado_representantes"
					headerClass="cabecera_tabla" property="nombre"
					title="${nombreProperty}" />

				<c:set var="primerApellidoProperty">
					<bean:message key="cabecera.primer_apellido" bundle="resources" />
				</c:set>

				<display:column class="listado_representantes"
					headerClass="cabecera_tabla" property="apellido1"
					title="${primerApellidoProperty}" />

				<c:set var="segundoApellidoProperty">
					<bean:message key="cabecera.segundo_apellido" bundle="resources" />
				</c:set>

				<display:column class="listado_representantes"
					headerClass="cabecera_tabla" property="apellido2"
					title="${segundoApellidoProperty}" />

				<c:set var="emailProperty">
					<bean:message key="cabecera.email" bundle="resources" />
				</c:set>

				<display:column class="listado_representantes"
					headerClass="cabecera_tabla" property="email"
					title="${emailProperty}" />

				<c:set var="telefonoProperty">
					<bean:message key="cabecera.telefono" bundle="resources" />
				</c:set>

				<display:column class="listado_representantes"
					headerClass="cabecera_tabla" property="telefono"
					title="${telefonoProperty}" />

				<c:set var="movilProperty">
					<bean:message key="cabecera.movil" bundle="resources" />
				</c:set>

				<display:column class="listado_representantes"
					headerClass="cabecera_tabla" property="movil"
					title="${movilProperty}" />

			</display:table>
		</logic:notEmpty>
		<logic:empty name="listaUsuarios">
			<h5>
				<bean:message key="listaUsuarios.vacia" bundle="resources" />
			</h5>
		</logic:empty>

	</fieldset>

</html:form>

<html:form action="/VisualizarOrganismoFrontAction.do">
	<div align="center" class="botonera border">
		<html:submit>
			<bean:message key="boton.volver" bundle="resources" />
		</html:submit>
	</div>
</html:form>
