<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>
	
	<script type="text/javascript">
			
		function confirmarBorrado(mensaje){
			if(confirm(mensaje)){
	  			return true;
	    	}else{
	  			return false;
	   		}
		}
				
	</script>

										
					<h3><bean:message key="servicio.gestionCentrosProcedencia" bundle="resources"/></h3>			
		    			    		  	
	  					 <display:table export="true" name="${VisualizarCentroForm.nuevalistaCentros}"  id="nuevalistaCentros" pagesize="10" sort="list"
	  					 requestURI="./VisualizarCentroFrontAction.do">
	  					 
							<c:set var="nombreProperty"><bean:message key="cabecera.nombre" bundle="resources" /></c:set>
							
							<display:column class="listado_representantes" headerClass="cabecera_tabla" property="nombre" title="${nombreProperty}"/>		   
    						    												
							<c:set var="modificarCentroProperty"><bean:message key="boton.modificarCentro" bundle="resources" /></c:set>
						
							<display:column media="html" class="listado_representantes" headerClass="cabecera_tabla ancho-20">
								
								<center>
									<html:link action="/ModificarCentroFrontAction.do" paramId="idCentroSeleccionado" paramName="nuevalistaCentros" paramProperty="idCentro">			
										<img title="${modificarCentroProperty}" src="${pageContext.request.contextPath}/img/ico16-editar.gif" alt="${modificarCentroProperty}"/>
									</html:link>
								</center>							
								
							</display:column>
							
							<c:set var="eliminarCentroProperty"><bean:message key="boton.eliminarCentro" bundle="resources" /></c:set>
							<c:set var="eliminarCentroConfirmacionProperty"><bean:message key="boton.eliminarCentroConfirmacion" bundle="resources" /></c:set>
							<display:column media="html" class="listado_expedientes" headerClass="cabecera_tabla ancho-20">					
								
								<center>
									<html:link action="/BajaCentroDo.do" paramId="idCentroSeleccionado" paramName="nuevalistaCentros" paramProperty="idCentro">
										<img title="${eliminarCentroProperty}" onclick="return confirmarBorrado('${eliminarCentroConfirmacionProperty}');"
											  src="${pageContext.request.contextPath}/img/ico16-borrar.gif"
											  alt="${eliminarCentroProperty}"/>	
									</html:link>
								</center>
								
							</display:column>
							
							<c:set var="verInformacionCentroProperty"><bean:message key="boton.verInformacionCentro" bundle="resources" /></c:set>
							
							<display:column media="html" class="listado_expedientes" headerClass="cabecera_tabla ancho-20">					
								
									<center>
										<html:link action="/MuestraInformacionCentroFrontAction.do" paramId="idCentroSeleccionado" paramName="nuevalistaCentros" paramProperty="idCentro">
											<img title="${verInformacionCentroProperty}" src="${pageContext.request.contextPath}/img/ico16-buscar.gif" alt="${verInformacionCentroProperty}"/>	
										</html:link>
									</center>
								
							</display:column>

						 </display:table>
						 
	  				<br/>
	  				
	  				<html:form action="/AltaCentroFrontAction.do" method="post" enctype="multipart/form-data">
				
						<div class="botonera">						
							<html:submit><bean:message key="boton.nuevoCentro" bundle="resources"/></html:submit>
						</div>
					
					</html:form>										

