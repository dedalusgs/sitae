<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@page import="java.util.Locale"%>
<%@page import="org.apache.struts.Globals"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java"%>



<h4><bean:message key="mobile.busqueda.titulo" bundle="resources"/></h4>
			<p><bean:message key="mobile.busqueda.texto2" bundle="resources"/></p>
			
<html:form 	action="/mobile/BusquedaAvanzadaFrontAction2.do" 	method="post" enctype="multipart/form-data">
	<input type="hidden" name="filtrar" value="true"/>
	<logic:messagesPresent>
		<div class="error">
			<html:errors />
		</div>
	</logic:messagesPresent>
		<fieldset>
			
			<div data-role="fieldcontain" >
				<label>
					<bean:message key="datosedicto.tipoEdicto" bundle="resources" />
				</label>
				<html:select property="opcionTipoEdicto">
					<html:option value="-1">
						<bean:message key="select.seleccione" bundle="resources" />
					</html:option>
					<html:optionsCollection property="listaTiposEdictos" label="nombre"
						value="idTipoEdicto" />
				</html:select>
			</div>

			<div data-role="fieldcontain" >
				<label>
					<bean:message key="datosedicto.centroProcedencia"
						bundle="resources" />
				</label>
				<html:select property="opcionCentro">
					<html:option value="-1">
						<bean:message key="select.seleccione" bundle="resources" />
					</html:option>
					<html:optionsCollection property="listaCentros" label="nombre"
						value="idCentro" />
				</html:select>
			</div>
			
			<div data-role="fieldcontain" >
				<label>
					<bean:message key="datosedicto.organismoExterno"
						bundle="resources" />
				</label>
				<html:select property="opcionOrganismoExterno">
					<html:option value="-1">
						<bean:message key="select.seleccione" bundle="resources" />
					</html:option>
					<html:optionsCollection property="listaOrganismosExternos" label="nombre"
						value="idOrg" />
				</html:select>
			</div>
			
			<c:set var="cajatitulo" ><bean:message key="mobile.busqueda.cajaTitulo" bundle="resources" /></c:set>
			<c:set var="cajafecha"><bean:message key="mobile.busqueda.fecha" bundle="resources" /></c:set>
			
			<div data-role="fieldcontain" >
				<label>
					<bean:message key="datosedicto.titulo" bundle="resources" />
				</label>
				<html:text name="VisualizarEdictoPublicoForm" property="titulo"
					maxlength="80" style="\"  placeholder=\"${cajatitulo}" />
			</div>

			

			<div data-role="fieldcontain" >
				<label>
					<bean:message key="datosedicto.fechaPublicacionEntre"
						bundle="resources" />
				</label>
				<html:text maxlength="10" name="VisualizarEdictoPublicoForm" property="fechaPublicacionInicio"  style="\" data-role=\"date\" placeholder=\"${cajafecha}" />
				
			</div>

			<div data-role="fieldcontain" >
				<label>
					<bean:message key="datosedicto.fechaPublicacionEntrey"
						bundle="resources" />
				</label>
				<html:text maxlength="10" name="VisualizarEdictoPublicoForm"
					property="fechaPublicacionFin" styleId="i_date_fin"
					style="\" data-role=\"date\" placeholder=\"${cajafecha}" />
				
			</div>

			<div data-role="fieldcontain" >
				<label>
					<bean:message key="filtro.historico" bundle="resources" />
				</label>
				<html:select property="historico" style="\" data-role=\"slider">
					<html:option value="true">
						Si
					</html:option>
					<html:option value="false">
						No
					</html:option>
					
				</html:select>
			</div>

		</fieldset>
		<div class="botonera">
			<html:submit>
				<bean:message key="boton.filtrar" bundle="resources" />
			</html:submit>
			<html:reset><bean:message key="mobile.busqueda.boton.limpiar" bundle="resources" /></html:reset>
		</div>

</html:form>
