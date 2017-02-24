<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	
		<h3><bean:message key="servicio.gestionCentrosProcedencia" bundle="resources"/></h3>		 
			
			<html:form action="/AltaCentroDo.do" method="post" enctype="multipart/form-data">			
				 
				<logic:messagesPresent>
			 		<div class="error">
			  			<html:errors/>
			 		</div>				 	
				</logic:messagesPresent>			    

			  	<fieldset>	
			  	
			  		<legend><bean:message key="altaCentro.titulo" bundle="resources"/></legend>					
					 	
					 	<div class="detalle"> 
					 	   <label><bean:message key="datoscentro.nombre" bundle="resources"/>(*)</label>
							<html:text name="AltaCentroForm" property="centro.nombre"/>
						 </div>
						 <div class="detalle"> 
					 	   <label><bean:message key="datoscentro.descripcion" bundle="resources"/>(*)</label>
							<html:textarea name="AltaCentroForm" property="centro.descripcion"/>
						 </div>  
					 
					</fieldset>
	
 				<div align="right">
					<i><bean:message key="campos.obligatorios" bundle="resources" /></i>
				</div>
					
				<div class="hr">
					<hr />
				</div>
									
				<div class="botonera">
						<html:submit>						
							<bean:message key="boton.guardar" bundle="resources"/>
						</html:submit>
				</div>				
			       		
				</html:form>
				
				<html:form action="/VisualizarCentroFrontAction.do?volver=si">
					<div align="center" class="botonera border">
						<html:submit><bean:message key="boton.volver" bundle="resources"/></html:submit>  
					</div>  	
				</html:form> 
							
