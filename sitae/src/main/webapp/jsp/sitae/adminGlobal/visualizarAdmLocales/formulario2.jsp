<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script language="Javascript">

function confirmarBorrado(mensaje) {
	if (confirm(mensaje)) {
		return true;
	} else {
		return false;
	}
}

$(function(){
	$('.org_list').click(function(){
	        
	        var id = this.id;
			height=$(this).height();
			if (height>27){
						$("#"+id+"_sim").removeClass("ui-icon-minusthick");
						$("#"+id+"_sim").addClass("ui-icon-plusthick");
			   $("#"+id).animate({
					height: "27px"
				  }, 500 , function (){
						$(this).height("27px");
						
				  });
				 
			  }else{
				 nodohijo =$(this).children('ul');
				 $("#"+id+"_sim").removeClass("ui-icon-plusthick");
						$("#"+id+"_sim").addClass("ui-icon-minusthick");
			  $("#"+id).animate({
					height: nodohijo.height()+"px"
				  }, 500,function (){
						
						$(this).height("auto");
						
				  });
			  }
	       }); 
	       
	          
});

$(function() {
	
	var listadoOrg=$('.org_list');
	
	
	for (i=0;i<(listadoOrg.length);i++){
	//	$(listadoOrg[i]).height("20px");
		 $(listadoOrg[i]).animate({
	    	    height: "27px"
	    	  }, 10, function() {
	    	    // Animation complete.
	    	  });	
	}
})
</script>

<h3>
	<bean:message key="servicio.gestionUsuarios" bundle="resources" />
</h3>

<html:form action="/VisualizarAdmLocalFrontAction.do?actualizando=si" method="post"
	enctype="multipart/form-data">
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
			<html:text name="VisualizarAdmLocalForm" property="nif" />
		</div>
		<div class="detalle">
			<label>
				<bean:message key="datosorganismo.titulo" bundle="resources" />
			</label>
			<html:select styleClass="" property="opcionOrganismo"
				title="Organismo" styleId="objetoOrganismo">
				<html:option value="">
					<bean:message key="select.seleccione" bundle="resources" />
				</html:option>
				<html:optionsCollection property="listaOrganismos" label="nombre"
					value="cif" />
			</html:select>
		</div>
	</fieldset>
	
	<div class="botonera">
		<html:submit>
			<bean:message key="boton.filtrar" bundle="resources" />
		</html:submit>
	</div>
	<logic:equal name="VisualizarAdmLocalForm" property="cambio" value="1">

		<h3>
			<bean:message key="visualizarListaAdmLocales.titulo"
				bundle="resources" />
		</h3>
		<logic:notEmpty name="nuevaListaAdmLocales">
			<display:table name="${VisualizarAdmLocalForm.nuevaListaAdmLocales}"
				id="nuevaListaAdmLocales" pagesize="10" sort="list" export="true"
				requestURI="./VisualizarAdmLocalFrontAction.do">

				<c:set var="nifProperty">
					<bean:message key="cabecera.nif" bundle="resources" />
				</c:set>

				<display:column class="listado_representantes aliniar-arriba"
					headerClass="cabecera_tabla ancho-60" property="numDocumento"
					title="${nifProperty}" />

				<c:set var="nombreProperty">
					<bean:message key="cabecera.nombre" bundle="resources" />
				</c:set>

				<display:column class="listado_representantes aliniar-arriba"
					headerClass="cabecera_tabla ancho-160" property="nombreUsuario"
					title="${nombreProperty}" />

				<c:set var="emailProperty">
					<bean:message key="cabecera.email" bundle="resources" />
				</c:set>

				<display:column class="listado_representantes aliniar-arriba"
					headerClass="cabecera_tabla ancho-60" property="email"
					title="${emailProperty}" />

				<c:set var="administradorGlobalProperty">
					<bean:message key="cabecera.administradorGlobal" bundle="resources" />
				</c:set>

				<display:column media="html" class="listado_representantes aliniar-arriba"
					headerClass="cabecera_tabla ancho-60"
					title="${administradorGlobalProperty}">
					<c:if test="${(nuevaListaAdmLocales.administrador=='true')}">
						<center>
							SI
						</center>
					</c:if>
					<c:if test="${(nuevaListaAdmLocales.administrador=='false')}">
						<center>
							NO
						</center>
					</c:if>
				</display:column>

				<display:column media="csv pdf" class="listado_representantes aliniar-arriba"
					headerClass="cabecera_tabla ancho-60"
					title="${administradorGlobalProperty}">
					<c:if test="${(nuevaListaAdmLocales.administrador=='true')}">
							SI
					</c:if>
					<c:if test="${(nuevaListaAdmLocales.administrador=='false')}">
							NO
					</c:if>
				</display:column>
				
				<c:set var="organismosAdmLocalProperty">
					<bean:message key="cabecera.organismosAdmLocal" bundle="resources" />
				</c:set>
				<c:set var="eliminarUsuarioMensajeConfirmacionProperty">
					<bean:message key="boton.eliminarUsuarioConfirmacion"
						bundle="resources" />
				</c:set>

				<display:column media="html" class="listado_representantes aliniar-arriba"
					headerClass="cabecera_tabla" title="${organismosAdmLocalProperty}">
					
					<logic:notEmpty name="nuevaListaAdmLocales" property="organismos">
					 <c:if test="${fn:length(nuevaListaAdmLocales.organismos)>1}" >
					<div class="org_list" id="usu_${nuevaListaAdmLocales.numDocumento}">
					<span class="ui-state-default" style="float:left;"><span id="usu_${nuevaListaAdmLocales.numDocumento}_sim" class="ui-icon ui-icon-plusthick"></span></span>
					<ul class="ul_orglist" >
						<logic:iterate id="listaOrganismos" name="nuevaListaAdmLocales"
							property="organismos">
							<li>
								<bean:write name="listaOrganismos" property="nombre" />
							</li>
						</logic:iterate>
						</ul>
						</div>
						</c:if>
						<c:if test="${fn:length(nuevaListaAdmLocales.organismos)==1}" >
						<logic:iterate id="listaOrganismos" name="nuevaListaAdmLocales"
							property="organismos">
							
								<bean:write name="listaOrganismos" property="nombre" />
							
						</logic:iterate>
						</c:if>
					</logic:notEmpty>
				</display:column>
				
				<display:column media="csv pdf" class="listado_representantes aliniar-arriba"
					headerClass="cabecera_tabla" title="${organismosAdmLocalProperty}">
					
					<logic:notEmpty name="nuevaListaAdmLocales" property="organismos">
					  
						<logic:iterate id="listaOrganismos" name="nuevaListaAdmLocales"
							property="organismos">
								<bean:write name="listaOrganismos" property="nombre" />
						</logic:iterate>
					
					</logic:notEmpty>
				</display:column>
				
				<c:set var="modificarAdmLocalProperty">
					<bean:message key="boton.modificarAdmLocal" bundle="resources" />
				</c:set>

				<display:column media="html" class="listado_representantes aliniar-arriba"
					headerClass="cabecera_tabla">

					<center>
						<html:link action="/ModificarAdmLocalFrontAction.do"
							paramId="idAdmLocalSelecionado" paramName="nuevaListaAdmLocales"
							paramProperty="numDocumento">
							<img title="${modificarAdmLocalProperty}"
								src="${pageContext.request.contextPath}/img/ico16-editar.gif"
								alt="${modificarAdmLocalProperty}" />
						</html:link>
					</center>

				</display:column>

				<c:set var="borrarAdmLocalProperty">
					<bean:message key="boton.borrarAdmLocal" bundle="resources" />
				</c:set>

				<display:column media="html" class="listado_expedientes aliniar-arriba"
					headerClass="cabecera_tabla">

					<center>
						<html:link action="/BajaAdmLocalDo.do"
							paramId="idAdmLocalSelecionado" paramName="nuevaListaAdmLocales"
							paramProperty="numDocumento">
							<img title="${borrarAdmLocalProperty}"
								onclick="return confirmarBorrado('${eliminarUsuarioMensajeConfirmacionProperty}');"
								src="${pageContext.request.contextPath}/img/ico16-borrar.gif"
								alt="${borrarAdmLocalProperty}" />
						</html:link>
					</center>

				</display:column>

				<c:set var="verInformacionAdmLocalProperty">
					<bean:message key="boton.verInformacionAdmLocal" bundle="resources" />
				</c:set>

				<display:column media="html" class="listado_expedientes aliniar-arriba"
					headerClass="cabecera_tabla">

					<center>
						<html:link
							action="/MuestraInformacionUsuarioAdmLocalFrontAction.do"
							paramId="idAdmLocalSelecionado" paramName="nuevaListaAdmLocales"
							paramProperty="numDocumento">
							<img title="${verInformacionAdmLocalProperty}"
								src="${pageContext.request.contextPath}/img/ico16-buscar.gif"
								alt="${verInformacionAdmLocalProperty}" />
						</html:link>
					</center>

				</display:column>

			</display:table>

		</logic:notEmpty>

		<logic:empty name="nuevaListaAdmLocales">
			<h5>
				<bean:message key="listaUsuarios.vacia" bundle="resources" />
			</h5>
		</logic:empty>


	</logic:equal>


</html:form>
<br/>
<html:form action="/AltaAdmLocalFrontAction.do" method="post"
	enctype="multipart/form-data">

	<div class="botonera">
		<html:submit>
			<bean:message key="boton.nuevoAdministradorLocal" bundle="resources" />
		</html:submit>
	</div>

</html:form>
