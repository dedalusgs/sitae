<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

			
			<h3><bean:message key="servicio.gestionOrganismos" bundle="resources"/></h3>	

			
			<html:form action="/AltaOrganismoDo.do" method="post" enctype="multipart/form-data">			
				 
				<logic:messagesPresent>
			 		<div class="error">
			  			<html:errors/>
			 		</div>				 	
				</logic:messagesPresent>			    

			  	<fieldset>	
			  	
			  		<legend><bean:message key="altaOrganismo.titulo" bundle="resources"/></legend>					
					
					 	<div class="detalle"> 
                    		<label><bean:message key="datosorganismo.codigo" bundle="resources" />(*)</label>
                    		<html:text name="AltaOrganismoForm" property="organismo.codigo" maxlength="255" />
                    	</div>
					 	
					 	<div class="detalle"> 
					 	   <label><bean:message key="datosorganismo.nombre" bundle="resources"/>(*)</label>
					 	   	<div style="float:left;">          
					 	  		<div class="subRayado"><bean:message key="lenguaje.es" bundle="resources" /></div>
						   		<html:text name="AltaOrganismoForm" property="organismo.nombre" maxlength="50"/>
						   		<div style="display: block;height:1px; margin: 8px 0;"></div>				   					   	
    							<div class="subRayado"><bean:message key="lenguaje.va" bundle="resources" /></div> 
								<html:text name="AltaOrganismoForm" property="organismo.nombreVa" maxlength="50"/>														
						 	</div>
						 </div> 						 					 	          			                    				                    		                  
						
						<div class="detalle">	
							<label><bean:message key="datosorganismo.direccion" bundle="resources"/>(*)</label>						
							<div style="float:left;">          
					 	  		<div class="subRayado"><bean:message key="lenguaje.es" bundle="resources"/></div>
						   		<html:text name="AltaOrganismoForm" property="organismo.direccion" maxlength="100"/>
						   		<div style="display: block;height:1px; margin: 8px 0;"></div>				   					   	
    							<div class="subRayado"><bean:message key="lenguaje.va" bundle="resources"/></div> 
								<html:text name="AltaOrganismoForm" property="organismo.direccionVa" maxlength="100"/>														
						 	</div>
						</div>
						<div class="detalle">	
							<label><bean:message key="datosorganismo.telefono" bundle="resources"/>(*)</label>
							<html:text name="AltaOrganismoForm" property="organismo.telefono" maxlength="10"/>
						</div>

						<div class="detalle">
							<label><bean:message key="datosorganismo.fax" bundle="resources"/>(*)</label>
							<html:text name="AltaOrganismoForm" property="organismo.fax" maxlength="10"/>
						</div>
						<div class="detalle">
							<label><bean:message key="datosorganismo.email" bundle="resources"/>(*)</label>
							<html:text name="AltaOrganismoForm" property="organismo.email" maxlength="50"/>
						</div>
						
						<div class="detalle">
							<label><bean:message key="datosorganismo.dominio" bundle="resources"/>(*)</label>
							<html:text name="AltaOrganismoForm" property="organismo.dominio" maxlength="300"/>
						</div>	
							
						<div>	
							<label><bean:message key="datosorganismo.tema" bundle="resources"/>(*)</label>
							<html:select property="opcion">
								<logic:equal name="AltaOrganismoForm" property="opcion" value="">
									<html:option value=""><bean:message key="select.seleccione" bundle="resources" /></html:option>
								</logic:equal>
							   		<html:optionsCollection property="listaTemas" label="nombre" value="id"/>								   
					        </html:select>				   	  		
						</div>
						
						<div class="detalle">
							<label><bean:message key="datosorganismo.imagen" bundle="resources"/>(*)</label>
							<html:file name="AltaOrganismoForm" property="imagen" styleClass="file"/>
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
				
				<html:form action="/VisualizarOrganismoFrontAction.do?volver=si">
					<div align="center" class="botonera border">
						<html:submit><bean:message key="boton.volver" bundle="resources"/></html:submit>  
					</div>  	
				</html:form> 
				
