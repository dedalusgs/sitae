<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script language="Javascript">		
		
		function CambiaPerfil(objetoPerfil) {
				document.CrearUsuariosForm.action = "./CrearUsuariosFrontAction.do?recarga=si" ;
				document.CrearUsuariosForm.submit();
		}
		function BuscarUsuario(){
				document.CrearUsuariosForm.action = "./CrearUsuariosDo.do?accion=buscar" ;
		}
		
</script>
			
			<h3><bean:message key="servicio.gestionUsuarios" bundle="resources"/></h3>	
			
			<html:form action="/CrearUsuariosDo.do" method="post" enctype="multipart/form-data">			
				 
				<logic:messagesPresent>
			 		<div class="error">
			  			<html:errors/>
			 		</div>				 	
				</logic:messagesPresent>			    

			  	<fieldset>	
			  	
			  		<legend><bean:message key="altaUsuario.titulo" bundle="resources"/></legend>					
						
						<div class="detalle"> 
					 	   <label><bean:message key="datosusuario.NIF" bundle="resources"/>(*)</label>
					 	   <logic:equal name ="CrearUsuariosForm" property="desactivarCampos" value="false">
								<html:text name="CrearUsuariosForm" property="usuario.numDocumento" disabled="true"/>
							</logic:equal>	
							<logic:equal name ="CrearUsuariosForm" property="desactivarCampos" value="true">
								<html:text name="CrearUsuariosForm" property="usuario.numDocumento" disabled="false"/>
							</logic:equal>
							<div class="botonera desactivarEstilosBotonera">				
								<logic:equal name ="CrearUsuariosForm" property="desactivarCampos" value="false">
									<html:submit  onclick="BuscarUsuario()" disabled="true"><bean:message key="boton.comprobar" bundle="resources"/></html:submit>
								</logic:equal>
								<logic:equal name ="CrearUsuariosForm" property="desactivarCampos" value="true">
									<html:submit  onclick="BuscarUsuario()" disabled="false"><bean:message key="boton.comprobar" bundle="resources"/></html:submit>
								</logic:equal>
							</div>							
						</div> 
					 	
					 	<div class="detalle"> 
					 	   <label><bean:message key="datosusuario.nombre" bundle="resources"/>(*)</label>
							<html:text name="CrearUsuariosForm" property="usuario.nombre" disabled="${CrearUsuariosForm.desactivarCampos}"/>
						</div> 
						
					 	<div class="detalle"> 
					 		<label><bean:message key="datosusuario.apellido1" bundle="resources"/>(*)</label>
							<html:text name="CrearUsuariosForm" property="usuario.apellido1" disabled="${CrearUsuariosForm.desactivarCampos}"/>
						</div>
						
						<div class="detalle">	
							<label><bean:message key="datosusuario.apellido2" bundle="resources"/>(*)</label>
							<html:text name="CrearUsuariosForm" property="usuario.apellido2" disabled="${CrearUsuariosForm.desactivarCampos}"/>
						</div>
						
						<div class="detalle">	
							<label><bean:message key="datosusuario.telefono" bundle="resources"/></label>
							<html:text name="CrearUsuariosForm" property="usuario.telefono" disabled="${CrearUsuariosForm.desactivarCampos}"/>
						</div>

						<div class="detalle">
							<label><bean:message key="datosusuario.movil" bundle="resources"/></label>
							<html:text name="CrearUsuariosForm" property="usuario.movil" disabled="${CrearUsuariosForm.desactivarCampos}"/>
						</div>
						
						<div class="detalle">
							<label><bean:message key="datosusuario.email" bundle="resources"/>(*)</label>
							<html:text name="CrearUsuariosForm" property="usuario.email" disabled="${CrearUsuariosForm.desactivarCampos}"/>
						</div>							
						
						<div class="detalle">
							<label><bean:message key="datosusuario.perfil" bundle="resources" />(*)</label>							
							<html:select styleClass="" disabled="${CrearUsuariosForm.desactivarCampos}" 
								property="opcionPerfil" title="Perfil"
								styleId="objetoPerfil"
								onchange="CambiaPerfil(objetoPerfil);">			
								<html:optionsCollection property="listaPerfil" label="nombre" value="idPerfil"/>
							</html:select>							
						</div>	
						
						<logic:equal name="CrearUsuariosForm" property="opcionPerfil" value="3">													
							
							<div>	
								<label><bean:message key="datosusuario.centro" bundle="resources"/>(*)</label>
								<html:select name="CrearUsuariosForm" property="opcionCentro" disabled="${CrearUsuariosForm.desactivarCampos}">
									<html:option value="-1"><bean:message key="select.seleccione" bundle="resources" /></html:option>
								   	<html:optionsCollection property="listaCentros" label="nombre" value="idCentro"/>								   
						        </html:select>				   	  		
							</div>
							
						
							
						</logic:equal>
						
					</fieldset>
	
 				<div align="right">
					<i><bean:message key="campos.obligatorios" bundle="resources" /></i>
				</div>
					
				<div class="hr"><hr /> </div>
									
				<div class="botonera">
						<html:submit><bean:message key="boton.guardar" bundle="resources"/></html:submit>
					</div>			       		
				</html:form>
				
				<html:form action="/VisualizarUsuariosFrontAction.do">
						<div class="botonera border">
						<html:submit><bean:message key="boton.volver" bundle="resources"/></html:submit>  
					</div>  	
				</html:form> 
				