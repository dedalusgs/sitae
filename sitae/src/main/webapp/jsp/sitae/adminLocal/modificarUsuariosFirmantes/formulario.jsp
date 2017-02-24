<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@taglib prefix="fn" uri="/WEB-INF/tld/fn.tld" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>
	
	<script type="text/javascript">
						
		function confirmarModificacion(mensaje){
			if(confirm(mensaje)){				
	  			return true
	    	}else{
	  			return false;
	   		}
		}
		
				
	</script>



				<h3><bean:message key="servicio.gestionUsuariosFirmantes" bundle="resources"/></h3>			
				    			    		 
				<c:set var="modificarAdmLocalConfirmarProperty"><bean:message key="boton.modificarAdmLocalConfirmar" bundle="resources" /></c:set>
	  		  
	  		  	<html:form action="/ModificarUsuariosFirmantesDo.do" onsubmit="return confirmarModificacion('${modificarAdmLocalConfirmarProperty}');"  method="post" enctype="multipart/form-data">
	  		  	
	  		  	<logic:messagesPresent>
			 		<div class="error">
			  			<html:errors/>
			 		</div>				 	
				</logic:messagesPresent>
	  		     
	  		     <fieldset>
				 
			   		<legend><bean:message key="modificarUsuarioFirmante.titulo" bundle="resources"/></legend>					
						
							<div class="detalle"> 
						 	   <label><bean:message key="datosusuario.NIF" bundle="resources"/></label>
								<html:text name="ModificarUsuariosFirmantesForm" disabled="true" property="usuarioFirmante.numDocumento"/>
							</div> 
						 	
						 	<div class="detalle"> 
						 	   <label><bean:message key="datosusuario.nombre" bundle="resources"/>(*)</label>
								<html:text name="ModificarUsuariosFirmantesForm" maxlength="20" property="usuarioFirmante.nombre"/>
							</div> 
							
						 	<div class="detalle"> 
						 		<label><bean:message key="datosusuario.apellido1" bundle="resources"/>(*)</label>
								<html:text name="ModificarUsuariosFirmantesForm" maxlength="20" property="usuarioFirmante.apellido1"/>
							</div>
							
							<div class="detalle">	
								<label><bean:message key="datosusuario.apellido2" bundle="resources"/>(*)</label>
								<html:text name="ModificarUsuariosFirmantesForm" maxlength="20" property="usuarioFirmante.apellido2"/>
							</div>
							<div class="detalle">	
								<label><bean:message key="datosusuario.cargo" bundle="resources"/>(*)</label>
								<html:text name="ModificarUsuariosFirmantesForm" maxlength="30" property="usuarioFirmante.cargo"/>
							</div>
							
				</fieldset>		
				<div align="right">
						<i><bean:message key="campos.obligatorios" bundle="resources" /></i>
					</div>
					
					<div class="hr"><hr /> </div>
					
					<div class="botonera">
								<html:submit><bean:message key="boton.guardar" bundle="resources"/></html:submit>
					</div>			
			</html:form>
			
			
			
			<html:form action="/VisualizarUsuariosFirmantesFrontAction.do">
				<div class="botonera border">				
					<html:submit><bean:message key="boton.volver" bundle="resources"/></html:submit>  
				</div>	
			</html:form> 		
