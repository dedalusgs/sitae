<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>
 
		
						
				<h3><bean:message key="servicio.gestionUsuariosFirmantes" bundle="resources"/></h3>			  		 
	  		  	<html:form action="/MuestraInformacionUsuarioFirmanteFrontAction.do" method="post" enctype="multipart/form-data">
	  		  	
	  		  	<logic:messagesPresent>
			 		<div class="error">
			  			<html:errors/>
			 		</div>				 	
				</logic:messagesPresent>
	  		     
	  		     <fieldset>
				 
			   		<legend><bean:message key="muestraInformacionUsuarioFirmante.titulo" bundle="resources"/></legend>					
						
							<div class="detalle"> 
						 	   <label><bean:message key="datosusuario.NIF" bundle="resources"/></label>
								<bean:write name="MuestraInformacionUsuarioFirmanteForm" property="usuario.numDocumento"/>
							</div> 
						 	
						 	<div class="detalle"> 
						 	   <label><bean:message key="datosusuario.nombre" bundle="resources"/></label>
								<bean:write name="MuestraInformacionUsuarioFirmanteForm" property="usuario.nombre"/>
							</div> 
							
						 	<div class="detalle"> 
						 		<label><bean:message key="datosusuario.apellido1" bundle="resources"/></label>
								<bean:write name="MuestraInformacionUsuarioFirmanteForm" property="usuario.apellido1"/>
							</div>
							
							<div class="detalle">	
								<label><bean:message key="datosusuario.apellido2" bundle="resources"/></label>
								<bean:write name="MuestraInformacionUsuarioFirmanteForm" property="usuario.apellido2" />
							</div>
							
							<div class="detalle">	
								<label><bean:message key="datosusuario.cargo" bundle="resources"/></label>
								<bean:write name="MuestraInformacionUsuarioFirmanteForm" property="usuario.cargo"/>
							</div>	
					</fieldset>  

	  		  	</html:form>									
			
				<html:form action="/VisualizarUsuariosFirmantesFrontAction.do">
					<div class="botonera  border">
						<html:submit><bean:message key="boton.volver" bundle="resources"/>
						</html:submit>  
					</div>  	
				</html:form> 							  		  	
	  		  								
