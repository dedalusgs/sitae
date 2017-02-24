<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
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

				<h3><bean:message key="servicio.gestionOrganismosExternos" bundle="resources"/></h3>
								    			   
		  
	  		  	<c:set var="modificarOrganismoConfirmacionProperty"><bean:message key="boton.modificarOrganismoConfirmacion" bundle="resources" /></c:set>
	  		  	<html:form action="/ModificarOrganismoExternoDo.do" onsubmit="return confirmarModificacion('${modificarOrganismoConfirmacionProperty}');" method="post" enctype="multipart/form-data">
	  		  	
	  		  	<logic:messagesPresent>
			 		<div class="error">
			  			<html:errors/>
			 		</div>				 	
				</logic:messagesPresent>
	  		     
	  		     <fieldset>
				 
			   		<legend><bean:message key="modificarOrganismo.titulo" bundle="resources"/></legend>
							
							<div class="detalle">
                    			<label><bean:message key="datosorganismo.cif" bundle="resources" /></label>
                    			<html:text name="ModificarOrganismoExternoForm" property="organismoExterno.cif" disabled="true" />
                    		</div>										
							
							<div class="detalle">
                    			<label><bean:message key="datosorganismo.nombre" bundle="resources" />(*)</label>
                    			<html:text name="ModificarOrganismoExternoForm" property="organismoExterno.nombre" maxlength="50" />
                    		</div>
                    		                    		                    		
                    		<div class="detalle">
                    			<label><bean:message key="datosorganismo.direccion" bundle="resources" />(*)</label>
                    			<html:text name="ModificarOrganismoExternoForm" property="organismoExterno.direccion" maxlength="100" />
                    		</div>     
                    		
                    		<div class="detalle">
                    			<label><bean:message key="datosorganismo.telefono" bundle="resources" />(*)</label>
                    			<html:text name="ModificarOrganismoExternoForm" property="organismoExterno.telefono" maxlength="10" />
                    		</div>  
                    		
                    		<div class="detalle">
                    			<label><bean:message key="datosorganismo.fax" bundle="resources" />(*)</label>
                    			<html:text name="ModificarOrganismoExternoForm" property="organismoExterno.fax" maxlength="10" />
                    		</div>  
                    		
                    		<div class="detalle">
                    			<label><bean:message key="datosorganismo.email" bundle="resources" />(*)</label>
                    			<html:text name="ModificarOrganismoExternoForm" property="organismoExterno.email" maxlength="50" />
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
	  		  	
	  		  	<html:form action="/VisualizarOrganismoExternoFrontAction.do">
					<div class="botonera border">
						<html:submit><bean:message key="boton.volver" bundle="resources"/></html:submit>  
					</div>  	
				</html:form>   
	  		  					
		
