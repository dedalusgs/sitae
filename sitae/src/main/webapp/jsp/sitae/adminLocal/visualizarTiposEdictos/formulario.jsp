<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<script language="Javascript">		
		
		
		function confirmarBorrado(mensaje){
			if(confirm(mensaje)){
	  			return true;
	    	}else{
	  			return false;
	   		}
		}
		
</script>

			<h3><bean:message key="servicio.gestionTiposEdictos" bundle="resources"/></h3>			
			
			<html:form action="/VisualizarTiposEdictosFrontAction.do" method="post" enctype="multipart/form-data">							     							
					
						<logic:notEmpty name="VisualizarTiposEdictosForm" property="nuevalistaTipoEdicto" >						
																			
								<display:table export="true" name="${VisualizarTiposEdictosForm.nuevalistaTipoEdicto}"  id="nuevalistaTipoEdicto" pagesize="10" sort="list"
								requestURI="./VisualizarTiposEdictosFrontAction.do">
				    					
				    				<c:set var="nombreProperty"><bean:message key="cabecera.nombre" bundle="resources" /></c:set>	
				    				<display:column class="listado_representantes" headerClass="cabecera_tabla" property="nombre" title="${nombreProperty}"  />
				    				
				    				<c:set var="modificarTipoEdictoProperty"><bean:message key="boton.modificarTipoEdicto" bundle="resources" /></c:set>	
				    					
									<display:column media="html" class="listado_representantes" headerClass="cabecera_tabla ancho-20">
								
										<center>
											<html:link action="/ModificarTiposEdictosFrontAction.do" paramId="idTipoEdictoSelecionado" paramName="nuevalistaTipoEdicto" paramProperty="idTipoEdicto">			
												<img title="${modificarTipoEdictoProperty}" src="${pageContext.request.contextPath}/img/ico16-editar.gif" alt="${modificarTipoEdictoProperty}"/>
											</html:link>
										</center>							
										
									</display:column>
							
									<c:set var="eliminarTipoEdictoProperty"><bean:message key="boton.eliminarTipoEdicto" bundle="resources" /></c:set>
									<c:set var="eliminarTipoEdictoConfirmacionProperty"><bean:message key="boton.eliminarTipoEdictoConfirmacion" bundle="resources" /></c:set>
								
									<display:column media="html" class="listado_expedientes" headerClass="cabecera_tabla ancho-20">					
										
										<center>
											<html:link action="/EliminarTiposEdictosDo.do" paramId="idTipoEdictoSelecionado" paramName="nuevalistaTipoEdicto" paramProperty="idTipoEdicto">
												<img title="${eliminarTipoEdictoProperty}" onclick="return confirmarBorrado('${eliminarTipoEdictoConfirmacionProperty}');"
													  src="${pageContext.request.contextPath}/img/ico16-borrar.gif"
													  alt="${eliminarTipoEdictoProperty}"/>	
											</html:link>
										</center>
										
									</display:column>
								
								</display:table>		
	  					</logic:notEmpty>
	  				
	  					<logic:empty name="VisualizarTiposEdictosForm" property="nuevalistaTipoEdicto"> 				
	  						<label><bean:message key="listaTiposEdictos.vacia" bundle="resources"/></label>	  				
	  					</logic:empty>	  					
					  				  								
			</html:form>
			
			<br/>
			
			<html:form action="/CrearTiposEdictosFrontAction.do" method="post" enctype="multipart/form-data">				
				<div class="botonera">						
					<html:submit><bean:message key="boton.nuevoTipoEdicto" bundle="resources"/></html:submit>
				</div>					
			</html:form>
									
				
