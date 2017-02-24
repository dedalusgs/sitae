<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script language="Javascript">			
		
		function confirmarBorrado(mensaje){
			if(confirm(mensaje)){
	  			return true;
	    	}else{
	  			return false;
	   		}
		}
		
</script>
	
		
			<h3><bean:message key="servicio.gestionUsuariosFirmantes" bundle="resources"/></h3>					        
			<html:form action="/VisualizarUsuariosFirmantesFrontAction.do?filtrar=si" method="post" enctype="multipart/form-data">
							 			     
				<fieldset>
				
					<legend><bean:message key="comun.buscador" bundle="resources"/></legend>
						
						<div class="detalle"> 
					 			<label><bean:message key="datosusuario.NIF" bundle="resources"/></label>
								<html:text name="VisualizarUsuariosFirmantesForm" property="nif"/>
						</div>
					
						<div class="detalle"> 
					 			<label><bean:message key="datosusuario.nombre" bundle="resources"/></label>
								<html:text name="VisualizarUsuariosFirmantesForm" property="nombre"/>
						</div>
																										
				</fieldset>		
				
						<div class="botonera">
							<html:submit><bean:message key="boton.filtrar" bundle="resources"/></html:submit>
						</div>
				
						<div>
								<h3><bean:message key="visualizarListaUsuariosFirmantes.titulo" bundle="resources"/></h3>
						</div>
													
						<logic:notEmpty name="listaUsuariosFirmantes">								
								<display:table export="true" name="${VisualizarUsuariosFirmantesForm.listaUsuariosFirmantes}"  sort="external" defaultsort="1" id="nuevaListaUsuariosFirmantes" pagesize="10" partialList="true" size="totalTablaUsuariosFirmantes"
								requestURI="./VisualizarUsuariosFirmantesFrontAction.do">	
								
				    				<c:set var="nifProperty"><bean:message key="cabecera.nif" bundle="resources" /></c:set>
				    						
				    				<display:column class="listado_representantes" headerClass="cabecera_tabla ancho-20" property="numDocumento" title="${nifProperty}"  />
				    				
				    				<c:set var="nombreProperty"><bean:message key="cabecera.nombre" bundle="resources" /></c:set>
				    				
				    				<display:column class="listado_representantes" headerClass="cabecera_tabla ancho-20" property="nombreUsuario" title="${nombreProperty}"  />
				    				
				    				<c:set var="cargoProperty"><bean:message key="cabecera.cargo" bundle="resources" /></c:set>
				    				
				    				<display:column class="listado_representantes" headerClass="cabecera_tabla ancho-60" property="cargo" title="${cargoProperty}"  /> 
				    				 
				    								    																																								
									
																		
									<c:set var="modificarUsuarioProperty"><bean:message key="boton.modificarUsuario" bundle="resources" /></c:set>
																	
									<display:column media="html" class="listado_representantes" headerClass="cabecera_tabla ancho-20">
									 																																															
										<center>											
												<html:link action="/ModificarUsuariosFirmantesFrontAction.do" paramId="idUsuarioSeleccionado" paramName="nuevaListaUsuariosFirmantes" paramProperty="numDocumento">			
													<img title="${modificarUsuarioProperty}" src="${pageContext.request.contextPath}/img/ico16-editar.gif" alt="${modificarUsuarioProperty}"/>
												</html:link>											
										</center>							
												
									</display:column>
									
									<c:set var="eliminarUsuarioProperty"><bean:message key="boton.eliminarUsuario" bundle="resources" /></c:set>
									<c:set var="eliminarUsuarioMensajeConfirmacionProperty"><bean:message key="boton.eliminarUsuarioConfirmacion" bundle="resources" /></c:set>
									
									<display:column media="html" class="listado_expedientes" headerClass="cabecera_tabla ancho-20">					
												
										<center>										
											<html:link action="/BajaUsuarioFirmanteDo.do" paramId="idUsuarioSeleccionado" paramName="nuevaListaUsuariosFirmantes" paramProperty="numDocumento" >
												<img title="${eliminarUsuarioProperty}" onclick="return confirmarBorrado('${eliminarUsuarioMensajeConfirmacionProperty}');"
												src="${pageContext.request.contextPath}/img/ico16-borrar.gif"
												alt="${eliminarUsuarioProperty}"/>	
											</html:link>											
										</center>
												
									</display:column>
									
									<c:set var="verInformacionUsuarioProperty"><bean:message key="boton.verInformacionUsuario" bundle="resources" /></c:set>
									
									<display:column media="html" class="listado_expedientes" headerClass="cabecera_tabla ancho-20">																	
										<center>
											<html:link action="/MuestraInformacionUsuarioFirmanteFrontAction.do" paramId="idUsuarioSeleccionado" paramName="nuevaListaUsuariosFirmantes" paramProperty="numDocumento" >
												<img title="${verInformacionUsuarioProperty}" src="${pageContext.request.contextPath}/img/ico16-buscar.gif"
													  alt="${verInformacionUsuarioProperty}"/>													
											</html:link>
										</center>
												
									</display:column>
									
										
								</display:table>							 		  				
	  				
	  					</logic:notEmpty>
	  					  						  				
	  					<logic:empty name="listaUsuariosFirmantes">	  					  			
								<h5><bean:message key="listaUsuariosFirmantes.vacia" bundle="resources" /></h5>						  			
	  					</logic:empty>					  			
  				   												
			</html:form>
			
			<br/>
			
			<html:form action="/CrearUsuariosFirmantesFrontAction.do" method="post" enctype="multipart/form-data">						
					<div class="botonera">						
						<html:submit><bean:message key="boton.nuevoUsuario" bundle="resources"/></html:submit>
					</div>				
			</html:form>			
			
															
	