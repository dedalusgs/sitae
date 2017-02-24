<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>


<body class="popup">

	<div id="cuerpo">
	
		<div id="contenido" >
		
			<div id="lenguajes">				
					<html:link page="/CambiarLenguajeDoAction.do?idioma=es&acceso=privado"><bean:message key="lenguajes.es" bundle="resources"/></html:link>
					<html:link page="/CambiarLenguajeDoAction.do?idioma=va&acceso=privado"><bean:message key="lenguajes.va" bundle="resources"/></html:link>
			</div>
			
			<c:if test="${(LoginCertificadoForm.opcionPerfil=='ADMINISTRADOR GLOBAL')}">
				<h2><bean:message key="comun.AdmGlobal" bundle="resources"/></h2>
			</c:if>
		
			<c:if test="${(LoginCertificadoForm.opcionPerfil=='ADMINISTRADOR LOCAL')}">
				<h2><bean:message key="comun.AdmLocal" bundle="resources"/></h2>
			</c:if>	
			
			<c:if test="${(LoginCertificadoForm.opcionPerfil=='PUBLICADOR')}">
				<h2><bean:message key="comun.publicador" bundle="resources"/></h2>
			</c:if>
		
			<c:if test="${(LoginCertificadoForm.opcionPerfil=='REDACTOR')}">
				<h2><bean:message key="comun.redactor" bundle="resources"/></h2>
			</c:if>		
			
			<div class="fondo-top">
			
			<html:form action="/LoginCertificadoDoAction.do" method="post" enctype="multipart/form-data">			
				 
				<logic:messagesPresent>
			 		<div class="error">
			  			<html:errors/>
			 		</div>				 	
				</logic:messagesPresent>			    
		
			  	<fieldset>	
			  	
			    		<div class="detalle">
							<label><bean:message key="datosorganismo.usuario" bundle="resources"/>:</label>
							<html:text name="LoginCertificadoForm" property="nombreUsuario"  readonly="true" />
						  </div> 
					 	<div class="detalle"> 
					 	   <label><bean:message key="datosorganismo.titulo" bundle="resources"/>:</label>
							<html:text name="LoginCertificadoForm" property="nombreOrganismo" readonly="true"/>
						 </div> 
												
						<ul id="pestanas">
						
						<nested:iterate name="LoginCertificadoForm" property="listaFuncionalidad" id="funcionalidad" indexId="i">
				
							<c:if test="${funcionalidad.idFuncionalidad eq 1}">
													
								<li class="activa">
									<span class="fondo-pes-iz"></span>																				
										<html:link action="./VisualizarAdmLocalFrontAction.do?actualizando=si"><bean:message key="servicio.gestionAdministradoresLocales" bundle="resources"/></html:link>
									<span class="fondo-pes-der"></span>
								</li> 
							
							</c:if>
							
							<c:if test="${funcionalidad.idFuncionalidad eq 2}">
													
								<li class="activa">
									<span class="fondo-pes-iz"></span>
										<html:link action="./VisualizarOrganismoFrontAction.do"><bean:message key="servicio.gestionOrganismos" bundle="resources"/></html:link>										
									<span class="fondo-pes-der"></span>
								</li> 
							
							</c:if>
							
							<c:if test="${funcionalidad.idFuncionalidad eq 3}">
													
								<li class="activa">
									<span class="fondo-pes-iz"></span>
									    <html:link action="./VisualizarUsuariosFrontAction.do"><bean:message key="servicio.gestionUsuarios" bundle="resources"/></html:link>
									<span class="fondo-pes-der"></span>
								</li> 
							
							</c:if>
							
							
							<c:if test="${funcionalidad.idFuncionalidad eq 5}">
													
								<li class="activa">
									<span class="fondo-pes-iz"></span>
									   <html:link action="./VisualizarEdictoPublicadorFrontAction.do"><bean:message key="servicio.misPublicaciones" bundle="resources"/></html:link>
									<span class="fondo-pes-der"></span>
								</li> 
							
							</c:if>
							
							<c:if test="${funcionalidad.idFuncionalidad eq 6}">
							
								<c:if test="${(LoginCertificadoForm.opcionPerfil=='PUBLICADOR')}">
									<li class="activa">
										<span class="fondo-pes-iz"></span>
										 	<html:link action="./VisualizarMisRedaccionesFrontAction.do"><bean:message key="servicio.misRedacciones" bundle="resources"/></html:link>
										<span class="fondo-pes-der"></span>
									</li> 
								</c:if>
		
								<c:if test="${(LoginCertificadoForm.opcionPerfil=='REDACTOR')}">
									<li class="activa">
										<span class="fondo-pes-iz"></span>
										<html:link action="./VisualizarEdictoFrontAction.do"><bean:message key="servicio.gestionEdictos" bundle="resources"/></html:link>											
										<span class="fondo-pes-der"></span>
									</li> 
								</c:if>		
								
								<c:if test="${(LoginCertificadoForm.opcionPerfil=='ADMINISTRADOR LOCAL')}">
									<li class="activa">
										<span class="fondo-pes-iz"></span>											
										    <html:link action="./VisualizarMisRedaccionesFrontAction.do"><bean:message key="servicio.misRedacciones" bundle="resources"/></html:link>
										<span class="fondo-pes-der"></span>
									</li> 
								</c:if>								
													
							</c:if>
							
							<c:if test="${funcionalidad.idFuncionalidad eq 7}">
													
								<li class="activa">
									<span class="fondo-pes-iz"></span>
									  	<html:link action="./VisualizarCentroFrontAction.do"><bean:message key="servicio.gestionCentrosProcedencia" bundle="resources"/></html:link>										
									<span class="fondo-pes-der"></span>
								</li> 
							
							</c:if>
							
							<c:if test="${funcionalidad.idFuncionalidad eq 41}">
													
								<li class="activa">
									<span class="fondo-pes-iz"></span>
										<html:link action="./VisualizarPublicacionesSinAsignarFrontAction.do"><bean:message key="servicio.publicacionesSinAsignar" bundle="resources"/></html:link>	
									<span class="fondo-pes-der"></span>
								</li> 
							
							</c:if>
							
							<c:if test="${funcionalidad.idFuncionalidad eq 61}">
									<li class="activa"><span class="fondo-pes-iz"></span>
											<html:link action="./VisualizarTiposEdictosFrontAction.do"><bean:message key="servicio.gestionTiposEdictos" bundle="resources"/></html:link>										
										<span class="fondo-pes-der"></span>
									</li> 
							</c:if>	
						
						</nested:iterate>
						
						</ul>
							
				</fieldset> 
					
				<div class="hr">
					<hr />
				</div>
								       		
			</html:form>
			
			<html:form action="/LoginCertificadoFront.do" method="post" enctype="multipart/form-data">
				
				<div class="botonera">						
					<html:submit><bean:message key="boton.volver" bundle="resources"/></html:submit>
				</div>
					
			</html:form> 
				
			</div>
			
			<div class="fondo-bottom"></div>
			
		</div>
		
	</div>
	
</body>
