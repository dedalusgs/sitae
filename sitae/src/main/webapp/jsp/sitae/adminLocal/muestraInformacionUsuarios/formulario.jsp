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
				 
			   		<legend><span><label><bean:message key="muestraInformacionUsuario.titulo" bundle="resources"/></label></span></legend>					
						
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
								<bean:write name="MuestraInformacionUsuarioForm" property="usuario.apellido2" />
							</div>
							
							<div class="detalle">	
								<label><bean:message key="datosusuario.telefono" bundle="resources"/></label>
								<bean:write name="MuestraInformacionUsuarioForm" property="usuario.telefono"/>
							</div>
	
							<div class="detalle">
								<label><bean:message key="datosusuario.movil" bundle="resources"/></label>
								<bean:write name="MuestraInformacionUsuarioForm" property="usuario.movil" />
							</div>
							
							<div class="detalle">
								<label><bean:message key="datosusuario.email" bundle="resources"/></label>
								<bean:write name="MuestraInformacionUsuarioForm" property="usuario.email"/>
							</div>	
							
							<div class="detalle">
								<label><bean:message key="datosusuario.perfil" bundle="resources"/></label>
								<bean:write name="MuestraInformacionUsuarioForm" property="usuario.perfil"/>
							</div>																
							<c:if test="${(MuestraInformacionUsuarioForm.usuario.idPerfil=='3')}">
								<div class="hr"><hr /></div>   
								<logic:notEmpty name="MuestraInformacionUsuarioForm" property="listaCentrosAsignados">																																			
									<h4><bean:message key="muestraInformacionUsuario.tituloCentrosAsociados" bundle="resources"/></h4>																																						 								 								
									<display:table name="${MuestraInformacionUsuarioForm.listaCentrosAsignados}"  id="listaCentrosAsignados" pagesize="10" sort="list" requestURI="./MuestraInformacionUsuarioFrontAction.do" >
		
											<c:set var="centroProcedenciaProperty"><bean:message key="cabecera.centro_de_procedencia" bundle="resources" /></c:set>
						    						
						    				<display:column class="listado_representantes" headerClass="cabecera_tabla" property="nombre" title="${centroProcedenciaProperty}"  />
						    								    								    																					
									</display:table>
								 		  					  			
		  						</logic:notEmpty>
		  				
		  						<logic:empty name="MuestraInformacionUsuarioForm" property="listaCentrosAsignados">	  						  				
		  							<h5><bean:message key="listaCentrosUsuario.vacia" bundle="resources"/></h5>		  				
		  						</logic:empty>														
							</c:if> 
					</fieldset>  

	  		  	</html:form>									
			
				<html:form action="/VisualizarUsuariosFrontAction.do">
					<div class="botonera  border">
						<html:submit><bean:message key="boton.volver" bundle="resources"/>
						</html:submit>  
					</div>  	
				</html:form> 							  		  	
	  		  								
