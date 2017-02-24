<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script language="Javascript">		
				
		function BuscarUsuario(){
				document.CrearUsuariosFirmantesForm.action = "./CrearUsuariosFirmantesDo.do?accion=buscar" ;
		}
		
</script>
			
			<h3><bean:message key="servicio.gestionUsuariosFirmantes" bundle="resources"/></h3>	
			
			<html:form action="/CrearUsuariosFirmantesDo.do" method="post" enctype="multipart/form-data">			
				 
				<logic:messagesPresent>
			 		<div class="error">
			  			<html:errors/>
			 		</div>				 	
				</logic:messagesPresent>			    

			  	<fieldset>	
			  	
			  		<legend><bean:message key="altaUsuarioFirmador.titulo" bundle="resources"/></legend>					
						
						<div class="detalle"> 
					 	   <label><bean:message key="datosusuario.NIF" bundle="resources"/>(*)</label>
					 	   <logic:equal name ="CrearUsuariosFirmantesForm" property="desactivarCampos" value="false">
								<html:text name="CrearUsuariosFirmantesForm" property="usuarioFirmante.numDocumento" disabled="true"/>
							</logic:equal>	
							<logic:equal name ="CrearUsuariosFirmantesForm" property="desactivarCampos" value="true">
								<html:text name="CrearUsuariosFirmantesForm" property="usuarioFirmante.numDocumento" maxlength="20" disabled="false"/>
							</logic:equal>
							<div class="botonera desactivarEstilosBotonera">				
								<logic:equal name ="CrearUsuariosFirmantesForm" property="desactivarCampos" value="false">
									<html:submit onclick="BuscarUsuario()" disabled="true"><bean:message key="boton.comprobar" bundle="resources"/></html:submit>
								</logic:equal>
								<logic:equal name ="CrearUsuariosFirmantesForm" property="desactivarCampos" value="true">
									<html:submit onclick="BuscarUsuario()" disabled="false"><bean:message key="boton.comprobar" bundle="resources"/></html:submit>
								</logic:equal>
							</div>							
						</div> 
					 	
					 	<div class="detalle"> 
					 	   <label><bean:message key="datosusuario.nombre" bundle="resources"/>(*)</label>
							<html:text name="CrearUsuariosFirmantesForm" property="usuarioFirmante.nombre" maxlength="20" disabled="${CrearUsuariosFirmantesForm.desactivarCampos}"/>
						</div> 
						
					 	<div class="detalle"> 
					 		<label><bean:message key="datosusuario.apellido1" bundle="resources"/>(*)</label>
							<html:text name="CrearUsuariosFirmantesForm" property="usuarioFirmante.apellido1" maxlength="20" disabled="${CrearUsuariosFirmantesForm.desactivarCampos}"/>
						</div>
						
						<div class="detalle">	
							<label><bean:message key="datosusuario.apellido2" bundle="resources"/>(*)</label>
							<html:text name="CrearUsuariosFirmantesForm" property="usuarioFirmante.apellido2" maxlength="20" disabled="${CrearUsuariosFirmantesForm.desactivarCampos}"/>
						</div>
						
						<div class="detalle">	
							<label><bean:message key="datosusuario.cargo" bundle="resources"/>(*)</label>
							<html:text name="CrearUsuariosFirmantesForm" property="usuarioFirmante.cargo" maxlength="300" disabled="${CrearUsuariosFirmantesForm.desactivarCampos}"/>
						</div>
						
						
						
						
					</fieldset>
	
 				<div align="right">
					<i><bean:message key="campos.obligatorios" bundle="resources" /></i>
				</div>
					
				<div class="hr"><hr /> </div>
									
				<div class="botonera">
						<html:submit><bean:message key="boton.guardar" bundle="resources"/></html:submit>
					</div>			       		
				</html:form>
				
				<html:form action="/VisualizarUsuariosFirmantesFrontAction.do">
						<div class="botonera border">
						<html:submit><bean:message key="boton.volver" bundle="resources"/></html:submit>  
					</div>  	
				</html:form> 
				