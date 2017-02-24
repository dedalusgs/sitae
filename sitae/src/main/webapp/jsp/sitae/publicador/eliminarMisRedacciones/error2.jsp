<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>

				
				<h3><bean:message key="servicio.misRedacciones" bundle="resources"/></h3>
				
				<h4><bean:message key="eliminarEdicto.titulo" bundle="resources"/></h4>							
						<div  class="error" >
							 <p><bean:message key="borrado.errorEdictoBBDD2" bundle="resources"/></p>
						</div>
								  
						<html:form action="/VisualizarMisRedaccionesFrontAction.do">
								<div class="botonera border">
								    <html:submit><bean:message key="boton.volver" bundle="resources"/></html:submit>  
								</div>  	
						</html:form> 
							
			