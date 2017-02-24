<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

				
						<h3><bean:message key="servicio.gestionAdministradoresLocales" bundle="resources"/></h3>					
						<h4><bean:message key="altaAdmLocal.titulo" bundle="resources"/></h4>
					
						<div class="correcto">
						       <p><bean:message key="resultado.exitoBBDD" bundle="resources"/></p>
						</div>
												
						<% String nif = (String) request.getAttribute("nifSeleccionado"); %>							
							<div align="right">
								<i><bean:message key="nota.asignarOrganismos" bundle="resources" /></i>
							</div>
						
							<div class="hr"><hr /> </div>
							
							<html:form action="/ModificarAdmLocalFrontAction.do">
								<input type="hidden" name="idAdmLocalSelecionado" value="<%=nif%>"/>
								<div align="center" class="botonera">
									 <html:submit><bean:message key="boton.asignar" bundle="resources"/></html:submit>  
								</div>  	
							</html:form> 						
						
						<html:form action="/VisualizarAdmLocalFrontAction.do?volver=si">
							<div class="botonera border">
								 <html:submit><bean:message key="boton.volver" bundle="resources"/></html:submit>  
							</div>  	
						</html:form> 				
