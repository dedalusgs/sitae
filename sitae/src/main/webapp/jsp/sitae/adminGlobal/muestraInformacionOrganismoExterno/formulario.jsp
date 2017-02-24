<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>


				<h3><bean:message key="servicio.gestionOrganismosExternos" bundle="resources"/></h3>	
					    			    	  		 
	  		  	<html:form action="/MuestraInformacionOrganismoExternoFrontAction.do" method="post" enctype="multipart/form-data">
	  		  	
	  		  	<logic:messagesPresent>
			 		<div class="error">
			  			<html:errors/>
			 		</div>				 	
				</logic:messagesPresent>
	  		     
	  		     <fieldset>
				 
			   			<legend><bean:message key="muestraInformacionOrganismoExterno.titulo" bundle="resources"/></legend>					
							
							<div class="detalle">
                    			<label><bean:message key="datosorganismo.cif" bundle="resources" /></label>
                    			<bean:write name="MuestraInformacionOrganismoExternoForm" property="organismoExterno.cif" />
                    		</div>						
							
							<div class="detalle">
                    			<label><bean:message key="datosorganismo.nombre" bundle="resources" /></label>
                    			<bean:write name="MuestraInformacionOrganismoExternoForm" property="organismoExterno.nombre" />
                    		</div>
                    		                    		                    	
                    		<div class="detalle">
                    			<label><bean:message key="datosorganismo.direccion" bundle="resources" /></label>
                    			<bean:write name="MuestraInformacionOrganismoExternoForm" property="organismoExterno.direccion" />
                    		</div>     
                    		
                    		<div class="detalle">
                    			<label><bean:message key="datosorganismo.telefono" bundle="resources" /></label>
                    			<bean:write name="MuestraInformacionOrganismoExternoForm" property="organismoExterno.telefono" />
                    		</div>  
                    		
                    		<div class="detalle">
                    			<label><bean:message key="datosorganismo.fax" bundle="resources" /></label>
                    			<bean:write name="MuestraInformacionOrganismoExternoForm" property="organismoExterno.fax"/>
                    		</div>  
                    		
                    		<div class="detalle">
                    			<label><bean:message key="datosorganismo.email" bundle="resources" /></label>
                    			<bean:write name="MuestraInformacionOrganismoExternoForm" property="organismoExterno.email"/>
                    		</div>  	
                    		                    															
					</fieldset>  

	  		  	</html:form>

				<html:form action="/VisualizarOrganismoExternoFrontAction.do">
					<div align="center" class="botonera border">
						<html:submit><bean:message key="boton.volver" bundle="resources"/>
						</html:submit>  
					</div>  	
				</html:form> 							  		  	  
