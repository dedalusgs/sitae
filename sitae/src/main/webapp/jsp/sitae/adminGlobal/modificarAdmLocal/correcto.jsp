<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
				
				
					<h3><bean:message key="servicio.gestionAdministradoresLocales" bundle="resources"/></h3>					
					<h4><bean:message key="modificarAdminLocal.titulo" bundle="resources"/></h4>
					
						<div class="correcto">
						       <p><bean:message key="resultado.exitoBBDD" bundle="resources"/></p>
						</div>
						
						<html:form action="/VisualizarAdmLocalFrontAction.do?actualizando=si">
								<div align="center" class="botonera border">
								    <html:submit><bean:message key="boton.volver" bundle="resources"/></html:submit>  
								</div>  	
						</html:form> 		
