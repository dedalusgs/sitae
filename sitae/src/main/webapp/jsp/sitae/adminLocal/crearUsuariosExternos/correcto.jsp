<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	
						<h3><bean:message key="servicio.gestionUsuarios" bundle="resources"/></h3>					
						<h4><bean:message key="altaUsuario.titulo" bundle="resources"/></h4>
						<div class="correcto">
						       <p><bean:message key="resultado.exitoUsuarioCreado" bundle="resources"/></p>
						</div>
						
						<% Integer perfil = (Integer) request.getAttribute("perfilSeleccionado"); %>
						<% String nif = (String) request.getAttribute("nifSeleccionado"); %>
						<%if(perfil.equals(new Integer(3))){%>		
							<div align="right">
								<i><bean:message key="nota.asignarCentros" bundle="resources" /></i>
							</div>
						
							<div class="hr"><hr /> </div>
							
							<html:form action="/ModificarUsuariosFrontAction.do">
								<input type="hidden" name="idUsuarioSeleccionado" value="<%=nif%>"/>
								<div align="center" class="botonera">
									 <html:submit><bean:message key="boton.asignar" bundle="resources"/></html:submit>  
								</div>  	
							</html:form> 		
						<%}%>
		
						
						
										
						<html:form action="/VisualizarUsuariosFrontAction.do">
							<div align="center" class="botonera border">
								 <html:submit><bean:message key="boton.volver" bundle="resources"/></html:submit>  
							</div>  	
						</html:form> 				