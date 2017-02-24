<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>

					<h3><bean:message key="servicio.gestionOrganismosExternos" bundle="resources"/></h3>
					<h4><bean:message key="altaOrganismoExterno.titulo" bundle="resources"/></h4>												
					
					<div class="error" >
							<p><bean:message key="resultado.errorBBDD" bundle="resources"/></p>
					</div>								 
					<html:form action="/VisualizarOrganismoExternoFrontAction.do">
						<div class="botonera border">
							 <html:submit><bean:message key="boton.volver" bundle="resources"/></html:submit>  
						</div>  	
					</html:form> 				