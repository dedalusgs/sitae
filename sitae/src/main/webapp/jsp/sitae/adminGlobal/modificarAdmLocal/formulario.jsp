<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld"%>
<%@taglib prefix="fn" uri="//WEB-INF/tld/fn.tld"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>


<script type="text/javascript">
							
		function confirmarModificacion(mensaje){
			if(confirm(mensaje)){				
	  			return true
	    	}else{
	  			return false;
	   		}
		}
		
				
	</script>

<h3>
	<bean:message key="servicio.gestionAdministradoresLocales"
		bundle="resources" />
</h3>

<c:set var="modificarAdmLocalConfirmarProperty">
	<bean:message key="boton.modificarAdmLocalConfirmar" bundle="resources" />
</c:set>

<html:form action="/ModificarAdmLocalDo.do"
	onsubmit="return confirmarModificacion('${modificarAdmLocalConfirmarProperty}');"
	method="post" enctype="multipart/form-data">

	<logic:messagesPresent>
		<div class="error">
			<html:errors />
		</div>
	</logic:messagesPresent>

	<fieldset>

		<legend>
			<bean:message key="modificarAdminLocal.titulo" bundle="resources" />
		</legend>

		<div class="detalle">
			<label>
				<bean:message key="datosusuario.NIF" bundle="resources" />
			</label>
			<html:text name="ModificarAdmLocalForm"
				property="usuario.numDocumento" disabled="true" />
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosusuario.nombre" bundle="resources" />
				(*)
			</label>
			<html:text name="ModificarAdmLocalForm" property="usuario.nombre" />
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosusuario.apellido1" bundle="resources" />
				(*)
			</label>
			<html:text name="ModificarAdmLocalForm" property="usuario.apellido1" />
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosusuario.apellido2" bundle="resources" />
				(*)
			</label>
			<html:text name="ModificarAdmLocalForm" property="usuario.apellido2" />
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosusuario.telefono" bundle="resources" />
				
			</label>
			<html:text name="ModificarAdmLocalForm" property="usuario.telefono" />
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosusuario.movil" bundle="resources" />
			</label>
			<html:text name="ModificarAdmLocalForm" property="usuario.movil" />
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosusuario.email" bundle="resources" />
				(*)
			</label>
			<html:text name="ModificarAdmLocalForm" property="usuario.email" />
		</div>
		<div class="detalle">
			<label>
				<bean:message key="datosusuario.administradorGlobal"
					bundle="resources" />
				(*)
			</label>

			<logic:equal name="ModificarAdmLocalForm"
				property="administradorGlobal" value="true">
				<input class="check" type="checkbox" name="administradorGlobal"
					checked />
			</logic:equal>
			<logic:notEqual name="ModificarAdmLocalForm"
				property="administradorGlobal" value="true">
				<input class="check" type="checkbox" name="administradorGlobal" />
			</logic:notEqual>
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


<fieldset>
	<legend>
		<bean:message key="modificarAdminLocal.tituloPermisos"
			bundle="resources" />
	</legend>
	<html:form action="/AsignarOrganismosAdmLocalDo.do?accion=add"
		method="post" enctype="multipart/form-data">

		<div class="detalle">
			<label>
				<bean:message key="datosorganismo.titulo" bundle="resources" />
			</label>
			<c:if
				test="${fn:length(ModificarAdmLocalForm.listaOrganismos) > 0  }">
				<html:select styleClass="" property="opcionOrganismo"
					styleId="objetoOrganismo">
					<html:optionsCollection property="listaOrganismos" label="nombre"
						value="cif" />
				</html:select>
				<div class="botonera">
					<html:submit>
						<bean:message key="boton.asignar" bundle="resources" />
					</html:submit>
				</div>
			</c:if>
			<c:if
				test="${fn:length(ModificarAdmLocalForm.listaOrganismos) == 0  }">
				<html:select disabled="true" styleClass=""
					property="opcionOrganismo" styleId="objetoOrganismo">
				</html:select>
				<div class="botonera ">
					<html:submit disabled="true">
						<bean:message key="boton.asignar" bundle="resources" />
					</html:submit>
				</div>
			</c:if>
		</div>

		<h4>
			<bean:message
				key="visualizarListaAdmLocales.tituloOrganismosAsociados"
				bundle="resources" />
		</h4>
		<logic:notEmpty name="ModificarAdmLocalForm"
			property="listaOrganismosAsignados">

			<c:set var="eliminiarOrganismoAdmLocalProperty">
				<bean:message key="boton.eliminiarOrganismoAdmLocal"
					bundle="resources" />
			</c:set>
			<display:table
				name="${ModificarAdmLocalForm.listaOrganismosAsignados}"
				id="listaOrganismosAsignados" pagesize="10" sort="list">

				<c:set var="organismoProperty">
					<bean:message key="cabecera.organismo" bundle="resources" />
				</c:set>

				<display:column class="listado_representantes"
					headerClass="cabecera_tabla" property="nombre"
					title="${organismoProperty}" />

				<c:set var="eliminiarOrganismoAdmLocalProperty">
					<bean:message key="boton.eliminiarOrganismoAdmLocal"
						bundle="resources" />
				</c:set>

				<display:column class="listado_representantes"
					headerClass="cabecera_tabla">
					<c:if
						test="${fn:length(ModificarAdmLocalForm.listaOrganismosAsignados) > 1  || ModificarAdmLocalForm.administradorGlobal=='true'}">
						<center>
							<html:link action="/AsignarOrganismosAdmLocalDo.do?accion=del"
								paramId="idOrgSelecionado" paramName="listaOrganismosAsignados"
								paramProperty="idOrg">
								<img
									src="${pageContext.request.contextPath}/img/ico16-borrar.gif"
									alt="${eliminiarOrganismoAdmLocalProperty}" />
							</html:link>
						</center>
					</c:if>

				</display:column>

			</display:table>



		</logic:notEmpty>

		<logic:empty name="ModificarAdmLocalForm"
			property="listaOrganismosAsignados">

			<h5>
				<bean:message key="listaOrganismosUsuario.vacia" bundle="resources" />
			</h5>

		</logic:empty>

	</html:form>
</fieldset>
<html:form action="/VisualizarAdmLocalFrontAction.do?actualizando=si">
	<div class="botonera border">
		<html:submit>
			<bean:message key="boton.volver" bundle="resources" />
		</html:submit>
	</div>
</html:form>
