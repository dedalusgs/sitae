<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fn" uri="/WEB-INF/tld/fn.tld" %>

<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>

<c:set var="idPerfiles" value="objetoPerfil" />
<c:set var="idSeccionTiposPermitidos" value="idSeccionTiposPermitidos" />
<c:set var="idSeccionCentrosPermitidos"
	value="idSeccionCentrosPermitidos" />

<script type="text/javascript">
		
		function confirmarModificacion(mensaje){
			if(confirm(mensaje)){				
	  			return true;
	    	}else{
	  			return false;
	   		}
		}

		function CambiaPerfil(objetoPerfil) {							
				document.ModificarUsuariosForm.action = "./ModificarUsuariosExternosFrontAction.do?recarga=si" ;									
				document.ModificarUsuariosForm.submit();				
		}
	</script>



<h3>
	<bean:message key="servicio.gestionUsuarios" bundle="resources" />
</h3>

<c:set var="modificarAdmLocalConfirmarProperty">
	<bean:message key="boton.modificarAdmLocalConfirmar" bundle="resources" />
</c:set>

<html:form action="/ModificarUsuariosExternosDo.do"
	onsubmit="return confirmarModificacion('${modificarAdmLocalConfirmarProperty}');"
	method="post" enctype="multipart/form-data">

	<logic:messagesPresent>
		<div class="error">
			<html:errors />
		</div>
	</logic:messagesPresent>

	<fieldset>
		<legend>
			<bean:message key="modificarUsuario.titulo" bundle="resources" />
		</legend>

		<div class="detalle">
			<label>
				<bean:message key="datosusuario.passwordActual" bundle="resources" />
			</label>
			<html:password name="ModificarUsuariosForm" property="passwordActual"
				size="20" />
		</div>
		<div class="detalle">
			<label>
				<bean:message key="datosusuario.passwordNuevo" bundle="resources" />
			</label>
			<html:password name="ModificarUsuariosForm" property="passwordNuevo"
				size="20" />
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosusuario.email" bundle="resources" />
				(*)
			</label>
			<html:text name="ModificarUsuariosForm" property="usuario.email" />
		</div>

		<div class="detalle">
			<label>
				<bean:message key="datosusuario.perfil" bundle="resources" />
				(*)
			</label>
			<html:select styleClass="" name="ModificarUsuariosForm"
				property="opcionPerfil" title="Perfil" styleId="objetoPerfil"
				onchange="CambiaPerfil(objetoPerfil);">
				<html:optionsCollection name="ModificarUsuariosForm"
					property="listaPerfil" label="nombre" value="idPerfil" />
			</html:select>
		</div>

		<c:if
			test="${ModificarUsuariosForm.opcionPerfil=='3' && fn:length(ModificarUsuariosForm.listaCentrosProcedenciaAsignados) == 0  }">

			<div>
				<label>
					<bean:message key="datosusuario.centro" bundle="resources" />
					(*)
				</label>
				<html:select name="ModificarUsuariosForm" property="opcionCentro">
					<html:option value="-1">
						<bean:message key="select.seleccione" bundle="resources" />
					</html:option>
					<html:optionsCollection name="ModificarUsuariosForm"
						property="listaCentros" label="nombre" value="idCentro" />
				</html:select>
			</div>
		</c:if>

		<div align="right">
			<i><bean:message key="campos.obligatorios" bundle="resources" />
			</i>
		</div>

		<div class="hr">
			<hr />
		</div>

		<html:hidden name="ModificarUsuariosForm" property="usuario.interno"
			value="true" />

		<div class="botonera">
			<html:submit>
				<bean:message key="boton.guardar" bundle="resources" />
			</html:submit>
		</div>
</html:form>
<c:if test="${ModificarUsuariosForm.opcionPerfil=='3' && fn:length(ModificarUsuariosForm.listaCentrosProcedenciaAsignados) > 0  }">								
						  			
  					<fieldset>
  				 	<legend><bean:message key="modificarUsuario.tituloPermisos" bundle="resources"/></legend>	
					<html:form action="/AsignarCentrosUsuariosExternosDo.do?accion=add" method="post" enctype="multipart/form-data">
														
	  						<div class="detalle">
								<label><bean:message key="datoscentro.titulo" bundle="resources" /></label>								
								<c:if test="${fn:length(ModificarUsuariosForm.listaCentrosProcedencia) > 0  }">								
									<html:select styleClass="" name="ModificarUsuariosForm" property="opcionCentro" styleId="objetoCentro">  									
											<html:optionsCollection name="ModificarUsuariosForm" property="listaCentrosProcedencia" label="nombre" value="idCentro"/>																																
									</html:select>
									<div class="botonera">
										<html:submit><bean:message key="boton.asignar" bundle="resources"/></html:submit>
									</div>
								</c:if>																
								<c:if test="${fn:length(ModificarUsuariosForm.listaCentrosProcedencia) == 0  }">								
									<html:select disabled="true" styleClass="" name="ModificarUsuariosForm" property="opcionCentro" styleId="objetoCentro"></html:select>
									<div class="botonera">
										<html:submit disabled="true"><bean:message key="boton.asignar" bundle="resources"/></html:submit>
									</div>									
								</c:if>
							</div>											
							 									
						<logic:notEmpty name="ModificarUsuariosForm" property="listaCentrosProcedenciaAsignados">					
													
							<h4><bean:message key="muestraInformacionUsuario.tituloCentrosAsociados" bundle="resources"/></h4>
													 								 	
							 <c:set var="eliminiarOrganismoAdmLocalProperty"><bean:message key="boton.eliminiarOrganismoAdmLocal" bundle="resources" /></c:set>
							 
								<display:table name="${ModificarUsuariosForm.listaCentrosProcedenciaAsignados}"  id="listaCentrosProcedenciaAsignados" pagesize="10" sort="list">

									<c:set var="centroProcedenciaProperty"><bean:message key="cabecera.centro_de_procedencia" bundle="resources" /></c:set>
				    						
				    				<display:column class="listado_representantes" headerClass="cabecera_tabla" property="nombre" title="${centroProcedenciaProperty}"  />
				    								    												
									<c:set var="eliminiarOrganismoAdmLocalProperty"><bean:message key="boton.eliminiarOrganismoAdmLocal" bundle="resources" /></c:set>
									
									<display:column class="listado_representantes" headerClass="cabecera_tabla">
												
										<center>		
											<c:if test="${fn:length(ModificarUsuariosForm.listaCentrosProcedenciaAsignados) > 1  }">									
												<html:link action="/AsignarCentrosUsuariosExternosDo.do?accion=del" paramId="idCentroSelecionado" paramName="listaCentrosProcedenciaAsignados" paramProperty="idCentro">			
													<img src="${pageContext.request.contextPath}/img/ico16-borrar.gif" alt="${eliminiarOrganismoAdmLocalProperty}"/>
												</html:link>	
											</c:if>												
										</center>							
												
									</display:column>																					
								</display:table>							 		  					  			
	  				</logic:notEmpty>
	  				
	  				<logic:empty name="ModificarUsuariosForm" property="listaCentrosProcedenciaAsignados">	  
	  				<h4><bean:message key="muestraInformacionUsuario.tituloCentrosAsociados" bundle="resources"/></h4>
	  					<h5><bean:message key="listaCentrosUsuario.vacia" bundle="resources"/></h5>	
	  				
	  				</logic:empty>					
						  						
				</html:form>
				</fieldset> 	
			</c:if>

<html:form action="/VisualizarUsuariosFrontAction.do?actualizando=si">
	<div class="botonera border">
		<html:submit>
			<bean:message key="boton.volver" bundle="resources" />
		</html:submit>
	</div>
</html:form>
