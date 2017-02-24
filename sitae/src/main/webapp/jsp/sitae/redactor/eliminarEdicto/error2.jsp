<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>


				
					<h3><bean:message key="servicio.gestionEdictos" bundle="resources"/></h3>	

					<fieldset>
							<legend><bean:message key="eliminarEdicto.titulo" bundle="resources"/></legend>			
							<div class="msj-error" >												
								 <span><bean:message key="borrado.errorEdictoBBDD2" bundle="resources"/></span>
							</div>
					</fieldset>
					<html:form action="/VisualizarEdictoFrontAction.do">
						<div align="center" class="botonera border">
							<html:submit><bean:message key="boton.volver" bundle="resources"/></html:submit>  
						</div>  	
					</html:form> 