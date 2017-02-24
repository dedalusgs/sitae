<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script language="Javascript">		
		
		function confirmarLiberacion(mensaje){
			if(confirm(mensaje)){
	  			return true;
	    	}else{
	  			return false;
	   		}
		}
		
</script>


		
			
			<h3><bean:message key="servicio.misPublicaciones" bundle="resources"/></h3>
			
		    		<c:set var="liberarPublicacionConfirmacionProperty"><bean:message key="boton.liberarPublicacionConfirmacion" bundle="resources" /></c:set>
		    
					<html:form action="/LiberarPublicacionDo.do" onsubmit="return confirmarLiberacion('${liberarPublicacionConfirmacionProperty}');"  method="post" enctype="multipart/form-data">
				
						<logic:messagesPresent>
							<div class="error">
						  		<html:errors/>
					 		</div>
			 			</logic:messagesPresent>			 						 		
			 			<fieldset>
			 				<legend><bean:message key="liberarPublicacion.titulo" bundle="resources"/></legend>
			   	  			<div class="detalle"> 
					 			<label><bean:message key="datosedicto.motivos" bundle="resources"/>(*)</label>
								<html:textarea name="LiberarPublicacionForm" property="motivos"/>
							</div>
			   	  			
						</fieldset>
						
						<div align="right">
								<i><bean:message key="campos.obligatorios" bundle="resources" /></i>
						</div>
							
						<div class="hr">
							<hr />
						</div>						
												
						<div class="botonera">
							<html:submit><bean:message key="boton.liberarPublicacion" bundle="resources"/></html:submit>
						</div>
						
							
		  			</html:form>
				

					<html:form action="/VisualizarEdictoPublicadorFrontAction.do" method="post" enctype="multipart/form-data">
				
						<div class="botonera border">						
							<html:submit><bean:message key="boton.volver" bundle="resources"/></html:submit>
						</div>
					
					</html:form> 

