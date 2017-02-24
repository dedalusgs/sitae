<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

			<h3><bean:message key="servicio.gestionTiposEdictos" bundle="resources"/></h3>
			
			<html:form action="/CrearTiposEdictosDo.do" method="post" enctype="multipart/form-data">			
				 
				<logic:messagesPresent>
			 		<div class="error">
			  			<html:errors/>
			 		</div>				 	
				</logic:messagesPresent>			    

			  	<fieldset>	
			  	
			  		<legend><bean:message key="crearEdicto.titulo" bundle="resources"/></legend>					
										 	
					 	<div class="detalle"> 
					 	   <label><bean:message key="tipoEdicto.nombre" bundle="resources"/>(*)</label>
							<html:text name="CrearTiposEdictosForm" property="tipoEdicto.nombre"/>
						 </div> 
						
				</fieldset>
	
 				<div align="right">
					<i><bean:message key="campos.obligatorios" bundle="resources" /></i>
				</div>
					
				<div class="hr">
					<hr />
				</div>
					
				
					<div class="botonera">
						<html:submit><bean:message key="boton.guardar" bundle="resources"/></html:submit>
					</div>
			       		
				</html:form>
				
				<html:form action="/VisualizarTiposEdictosFrontAction.do">
					<div align="center" class="botonera border">
						<html:submit><bean:message key="boton.volver" bundle="resources"/></html:submit>  
					</div>  	
				</html:form> 						
