<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>

	
				<h3><bean:message key="comun.tiposEdictos" bundle="resources"/></h3>				
						
						<h4><bean:message key="eliminarTipoEdicto.titulo" bundle="resources"/></h4>											
						<div class="error" >
								 <p><bean:message key="borrado.errorTipoEdictoBBDD" bundle="resources"/></p>
							</div>
										 
						<html:form action="/VisualizarTiposEdictosFrontAction.do">
								<div align="center" class="botonera border">
								    <html:submit><bean:message key="boton.volver" bundle="resources"/></html:submit>  
								</div>  	
						</html:form> 
							
