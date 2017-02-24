<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>


		<h3><bean:message key="servicio.gestionUsuarios" bundle="resources"/></h3>
						    			   		  
	  		  
	  		  	<html:form action="/MuestraInformacionUsuarioFrontAction.do" method="post" enctype="multipart/form-data">
	  		  	
	  		  	<logic:messagesPresent>
			 		<div class="error">
			  			<html:errors/>
			 		</div>				 	
				</logic:messagesPresent>
	  		     
	  		     <fieldset>
				 
			   		<legend><bean:message key="muestraInformacionUsuario.titulo" bundle="resources"/></legend>					
						
							<div class="detalle"> 
						 	   <label><bean:message key="datosusuario.NIF" bundle="resources"/></label>
								<bean:write name="MuestraInformacionUsuarioForm" property="usuario.numDocumento"/>
							</div> 
						 	
						 	<div class="detalle"> 
						 	   <label><bean:message key="datosusuario.nombre" bundle="resources"/></label>
								<bean:write name="MuestraInformacionUsuarioForm" property="usuario.nombre"/>
							</div> 
							
						 	<div class="detalle"> 
						 		<label><bean:message key="datosusuario.apellido1" bundle="resources"/></label>
								<bean:write name="MuestraInformacionUsuarioForm" property="usuario.apellido1"/>
							</div>
							
							<div class="detalle">	
								<label><bean:message key="datosusuario.apellido2" bundle="resources"/></label>
								<bean:write name="MuestraInformacionUsuarioForm" property="usuario.apellido2"/>
							</div>
							
							<div class="detalle">	
								<label><bean:message key="datosusuario.telefono" bundle="resources"/></label>
								<bean:write name="MuestraInformacionUsuarioForm" property="usuario.telefono" />
							</div>
	
							<div class="detalle">
								<label><bean:message key="datosusuario.movil" bundle="resources"/></label>
								<bean:write name="MuestraInformacionUsuarioForm" property="usuario.movil"/>
							</div>
							
							<div class="detalle">
								<label><bean:message key="datosusuario.email" bundle="resources"/></label>
								<bean:write name="MuestraInformacionUsuarioForm" property="usuario.email"/>
							</div>		
							<div class="detalle">
								<label><bean:message key="datosusuario.administradorGlobal" bundle="resources"/></label>								
								<logic:equal name="MuestraInformacionUsuarioForm" property="administradorGlobal" value="true">
									SI	
								</logic:equal>
								<logic:notEqual name="MuestraInformacionUsuarioForm" property="administradorGlobal" value="true">
									NO
								</logic:notEqual>
							</div>		
				

	  		  	</fieldset>
	  		  	
	  		  	</html:form>
				
				  
				<br/>
										
				<h3><bean:message key="visualizarListaAdmLocales.tituloOrganismosAsociados" bundle="resources"/></h3>
				
				<logic:notEmpty name="MuestraInformacionUsuarioForm" property="listaOrganismosAsignados">					
																		 								 								
							<display:table name="${MuestraInformacionUsuarioForm.listaOrganismosAsignados}"  id="listaOrganismosAsignados" pagesize="10" sort="list">

									<c:set var="organismoProperty"><bean:message key="cabecera.organismo" bundle="resources" /></c:set>
				    						
				    				<display:column class="listado_representantes" headerClass="cabecera_tabla" property="nombre" title="${organismoProperty}"  />
				    								    								    																					
							</display:table>
							 		  					  			
	  				</logic:notEmpty>
	  				
	  				<logic:empty name="MuestraInformacionUsuarioForm" property="listaOrganismosAsignados">	  				
	  				
	  					<h5><bean:message key="listaOrganismosUsuario.vacia" bundle="resources"/></h5>
	  				
	  				</logic:empty>		
			
				
					
				<html:form action="/VisualizarAdmLocalFrontAction.do?actualizando=si">
					<div align="center" class="botonera border">
						<html:submit><bean:message key="boton.volver" bundle="resources"/>
						</html:submit>  
					</div>  	
				</html:form> 							  		  	
  	  		  					
