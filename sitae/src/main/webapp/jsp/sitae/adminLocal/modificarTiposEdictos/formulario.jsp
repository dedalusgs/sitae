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

				<h3><bean:message key="servicio.gestionTiposEdictos" bundle="resources"/></h3>				
											
			    			    		  
	  		    <c:set var="modificarTipoEdictoConfirmacionProperty"><bean:message key="boton.modificarTipoEdictoConfirmacion" bundle="resources" /></c:set>
	  		  	<html:form action="/ModificarTiposEdictosDo.do" onsubmit="return confirmarModificacion('${modificarTipoEdictoConfirmacionProperty}');" method="post" enctype="multipart/form-data">
	  		  	
	  		  	<logic:messagesPresent>
			 		<div class="error">
			  			<html:errors/>
			 		</div>				 	
				</logic:messagesPresent>
	  		     
	  		     <fieldset>
				 
			   		<legend><bean:message key="modificarTipoEdicto.titulo" bundle="resources"/></legend>																		
							<div class="detalle">
                    			<label><bean:message key="datostipoedicto.nombre" bundle="resources" ></bean:message></label>
                    			<html:text name="ModificarTiposEdictosForm" property="tipoEdicto.nombre" />
                    		</div>
                    		                    	                    																				
					</fieldset>
				
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
	  		  								 
	
