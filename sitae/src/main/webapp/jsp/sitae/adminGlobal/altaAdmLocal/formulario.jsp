<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<script language="Javascript">

	function BuscarUsuario(){
			document.AltaAdmLocalForm.action = "./AltaAdmLocalDo.do?accion=buscar" ;
	}
	
	</script>			
			<h3><bean:message key="servicio.gestionAdministradoresLocales" bundle="resources"/></h3>
			
			<html:form action="/AltaAdmLocalDo.do" method="post" enctype="multipart/form-data">			
				 
				<logic:messagesPresent>
			 		<div class="error">
			  			<html:errors/>
			 		</div>				 	
				</logic:messagesPresent>			    

			  	<fieldset>	
			  	
			  		<legend><bean:message key="altaAdmLocal.titulo" bundle="resources"/></legend>					
						
						<div class="detalle"> 
					 	   <label><bean:message key="datosusuario.NIF" bundle="resources"/>(*)</label>
					 	   <logic:equal name ="AltaAdmLocalForm" property="desactivarCampos" value="false">
								<html:text name="AltaAdmLocalForm" property="usuario.numDocumento" disabled="true"/>
						   </logic:equal>						   														
						   <logic:equal name ="AltaAdmLocalForm" property="desactivarCampos" value="true">
						   		<html:text name="AltaAdmLocalForm" property="usuario.numDocumento" disabled="false"/>
						   </logic:equal>
								<div class="botonera desactivarEstilosBotonera">
								<logic:equal name ="AltaAdmLocalForm" property="desactivarCampos" value="false">				
									<html:submit  onclick="BuscarUsuario()" disabled="true"><bean:message key="boton.comprobar" bundle="resources"/></html:submit>
								</logic:equal>
								<logic:equal name ="AltaAdmLocalForm" property="desactivarCampos" value="true">
										<html:submit  onclick="BuscarUsuario()" disabled="false"><bean:message key="boton.comprobar" bundle="resources"/></html:submit>
								</logic:equal>
								</div>							
						</div> 
					 	
					 	<div class="detalle"> 
					 	   <label><bean:message key="datosusuario.nombre" bundle="resources"/>(*)</label>
							<html:text name="AltaAdmLocalForm" property="usuario.nombre" disabled="${AltaAdmLocalForm.desactivarCampos}"/>
						</div> 
						
					 	<div class="detalle"> 
					 		<label><bean:message key="datosusuario.apellido1" bundle="resources"/>(*)</label>
							<html:text name="AltaAdmLocalForm" property="usuario.apellido1" disabled="${AltaAdmLocalForm.desactivarCampos}"/>
						</div>
						
						<div class="detalle">	
							<label><bean:message key="datosusuario.apellido2" bundle="resources"/>(*)</label>
							<html:text name="AltaAdmLocalForm" property="usuario.apellido2" disabled="${AltaAdmLocalForm.desactivarCampos}"/>
						</div>
						
						<div class="detalle">	
							<label><bean:message key="datosusuario.telefono" bundle="resources"/></label>
							<html:text name="AltaAdmLocalForm" property="usuario.telefono" disabled="${AltaAdmLocalForm.desactivarCampos}"/>
						</div>

						<div class="detalle">
							<label><bean:message key="datosusuario.movil" bundle="resources"/></label>
							<html:text name="AltaAdmLocalForm" property="usuario.movil" disabled="${AltaAdmLocalForm.desactivarCampos}"/>
						</div>
						
						<div class="detalle">
							<label><bean:message key="datosusuario.email" bundle="resources"/>(*)</label>
							<html:text name="AltaAdmLocalForm" property="usuario.email" disabled="${AltaAdmLocalForm.desactivarCampos}"/>
						</div>				
						
						<div class="detalle">	
							<label><bean:message key="datosusuario.administradorGlobal" bundle="resources"/>(*)</label>
				   	  		<html:checkbox styleClass="check" name="AltaAdmLocalForm" property="administradorGlobal" disabled="${AltaAdmLocalForm.desactivarCampos}"/> 
									   	  		
						</div>
						
						<div class="detalle">	
							<label><bean:message key="datosusuario.organismo" bundle="resources"/>(*)</label>
							<html:select property="opcion" disabled="${AltaAdmLocalForm.desactivarCampos}">
								<logic:equal name="AltaAdmLocalForm" property="opcion" value="">
									<html:option value=""><bean:message key="select.seleccione" bundle="resources" /></html:option>
								</logic:equal>
							   		<html:optionsCollection property="listaOrganismos" label="nombre" value="cif"/>								   
					        </html:select>				   	  		
						</div>
						
					</fieldset>
	
 				<div align="right">
					<i><bean:message key="campos.obligatorios" bundle="resources" /></i>
				</div>
					
				<div class="hr">
					<hr />
				</div>
									
				<div class="botonera">
					<html:submit><bean:message key="boton.guardar" bundle="resources"/></html:submit>
				</div>
			       		
				</html:form>
				
				<html:form action="/VisualizarAdmLocalFrontAction.do?volver=si">
					<div align="center" class="botonera border">
						<html:submit><bean:message key="boton.volver" bundle="resources"/></html:submit>  
					</div>  	
				</html:form> 						
