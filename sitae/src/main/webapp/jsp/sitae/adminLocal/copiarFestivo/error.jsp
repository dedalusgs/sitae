<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>


			<h3><bean:message key="servicio.gestionFestivos" bundle="resources"/></h3>							 
				 <h4><bean:message key="festivo.tituloCopiarFestivo" bundle="resources"/></h4>
							<div class="error" >
					 <p><bean:message key="borrado.errorBBDD" bundle="resources"/></p>
				</div>					  
				<html:form action="/VisualizarFestivoFrontAction.do">
							<div align="center" class="botonera border">
							    <html:submit><bean:message key="boton.volver" bundle="resources"/></html:submit>  
							</div>  	
					</html:form> 
												
					