<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>


		  				  			
	  		  	<h3><bean:message key="servicio.gestionCentrosProcedencia" bundle="resources"/></h3>
	  		  	<html:form action="/MuestraInformacionCentroFrontAction.do" method="post" enctype="multipart/form-data">
	  		  	
	  		  	<logic:messagesPresent>
			 		<div class="error">
			  			<html:errors/>
			 		</div>				 	
				</logic:messagesPresent>
	  		     
	  		     <fieldset>
				 <legend><bean:message key="muestraInformacionCentro.titulo" bundle="resources"/></legend>										
							<div class="detalle">
                    			<label><bean:message key="datoscentro.nombre" bundle="resources" /></label>                    			
                    			<bean:write name="MuestraInformacionCentroForm" property="centro.nombre"/>
                    		</div>
							
							<div class="detalle">
                    			<label><bean:message key="datoscentro.descripcion" bundle="resources" /></label>
                    			<bean:write name="MuestraInformacionCentroForm" property="centro.descripcion"/>
                    		</div>
                    		                    		                    		                    	
							<logic:notEmpty name="listaUsuarios">							
					
			  					 <display:table name="${MuestraInformacionCentroForm.listaUsuarios}"  id="idUsuario" pagesize="10" sort="list"
			  					 requestURI="./MuestraInformacionCentroFrontAction.do">
									
									<c:set var="nifProperty"><bean:message key="cabecera.nif" bundle="resources" /></c:set>	   
										   
									<display:column class="listado_representantes" headerClass="cabecera_tabla" property="numDocumento" title="${nifProperty}"/>		   
		    						
		    						<c:set var="nombreProperty"><bean:message key="cabecera.nombre" bundle="resources" /></c:set>
		    						
		    						<display:column class="listado_representantes" headerClass="cabecera_tabla" property="nombre" title="${nombreProperty}"/>
				
									<c:set var="primerApellidoProperty"><bean:message key="cabecera.primer_apellido" bundle="resources" /></c:set>
								
									<display:column class="listado_representantes" headerClass="cabecera_tabla" property="apellido1" title="${primerApellidoProperty}"/>
									
									<c:set var="segundoApellidoProperty"><bean:message key="cabecera.segundo_apellido" bundle="resources" /></c:set>		   
		    						
		    						<display:column class="listado_representantes" headerClass="cabecera_tabla" property="apellido2" title="${segundoApellidoProperty}"/>
		    						
		    						<c:set var="emailProperty"><bean:message key="cabecera.email" bundle="resources" /></c:set>
		    						
		    						<display:column class="listado_representantes" headerClass="cabecera_tabla" property="email" title="${emailProperty}"/>
		    						
		    						<c:set var="telefonoProperty"><bean:message key="cabecera.telefono" bundle="resources" /></c:set>	
		    						
		    						<display:column class="listado_representantes" headerClass="cabecera_tabla" property="telefono" title="${telefonoProperty}" />
		    						
		    						<c:set var="movilProperty"><bean:message key="cabecera.movil" bundle="resources" /></c:set>
		    						
		    						<display:column class="listado_representantes" headerClass="cabecera_tabla" property="movil" title="${movilProperty}"/>		   	   
		    						
								 </display:table>
						 
	  						
	  						
	  						</logic:notEmpty>
							
							<logic:empty name="listaUsuarios">
								<label> <bean:message key="listaPublicadoresCentro.vacia" bundle="resources"/></label>
							</logic:empty>
													
					</fieldset>  

	  		  	</html:form>

				<html:form action="/VisualizarCentroFrontAction.do">
					<div align="center" class="botonera border">
						<html:submit><bean:message key="boton.volver" bundle="resources"/>
						</html:submit>  
					</div>  	
				</html:form> 							  		  	
  

