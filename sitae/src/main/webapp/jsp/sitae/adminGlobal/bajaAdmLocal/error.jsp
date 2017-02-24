<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>

					<h3><bean:message key="servicio.gestionAdministradoresLocales" bundle="resources"/></h3>					
					<h4><bean:message key="bajaAdminLocal.titulo" bundle="resources"/></h4>
				
					
						<div class="error" >
							 <p><bean:message key="borrado.errorAdminLocalBBDD" bundle="resources"/></p>
						</div>
								  
						<html:form action="/VisualizarAdmLocalFrontAction.do?actualizando=si">
								<div class="botonera border">
								    <html:submit><bean:message key="boton.volver" bundle="resources"/></html:submit>  
								</div>  	
						</html:form> 
								