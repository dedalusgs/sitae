<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>



						<h3><bean:message key="servicio.gestionUsuarios" bundle="resources"/></h3>									 
			   			<h4><bean:message key="bajaUsuario.titulo" bundle="resources"/></h4>			   							
						<div class="correcto" >
							<p><bean:message key="borrado.exitoUsuario" bundle="resources"/></p>
						</div>								 
						<html:form action="/VisualizarUsuariosFrontAction.do">
							<div class="botonera border">
								 <html:submit><bean:message key="boton.volver" bundle="resources"/></html:submit>  
							</div>  	
						</html:form> 											