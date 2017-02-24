<%@ page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
				
		<c:if test="${(LoginCertificadoForm!=null)}">	
			<c:if test="${(LoginCertificadoForm.administradorGlobal==true)}">		
			<div class="menu">
				<h2><bean:message key="comun.AdmGlobal" bundle="resources"/></h2>
				<ul class="admin">		
					<logic:iterate id="funcionalidades" name="LoginCertificadoForm" property="funcionalidadesAdministradorGlobal">	
					<li>			
						<c:if test="${(funcionalidades.funcionalidad.idFuncionalidad==1)}">		
						    <c:set var="gestionAdministradoresLocalesProperty"><bean:message key="servicio.gestionAdministradoresLocales" bundle="resources" /></c:set>
							<html:link title="${gestionAdministradoresLocalesProperty}" action="./VisualizarAdmLocalFrontAction.do?actualizando=si&grupoNavegacion=1" paramId="servicioNavegacion" paramName="funcionalidades" paramProperty="funcionalidad.idFuncionalidad"><bean:message key="servicio.gestionAdministradoresLocales" bundle="resources"/></html:link>
						</c:if>					
						<c:if test="${(funcionalidades.funcionalidad.idFuncionalidad==2)}">
							<c:set var="gestionOrganismosProperty"><bean:message key="servicio.gestionOrganismos" bundle="resources" /></c:set>
							<html:link title="${gestionOrganismosProperty}" action="./VisualizarOrganismoFrontAction.do?grupoNavegacion=1" paramId="servicioNavegacion" paramName="funcionalidades" paramProperty="funcionalidad.idFuncionalidad"><bean:message key="servicio.gestionOrganismos" bundle="resources"/></html:link>
						</c:if>												
						<c:if test="${(funcionalidades.funcionalidad.idFuncionalidad==81)}">
							<c:set var="gestionOrganismosExternosProperty"><bean:message key="servicio.gestionOrganismosExternos" bundle="resources" /></c:set>
							<html:link title="${gestionOrganismosExternosProperty}" action="./VisualizarOrganismoExternoFrontAction.do?grupoNavegacion=1" paramId="servicioNavegacion" paramName="funcionalidades" paramProperty="funcionalidad.idFuncionalidad"><bean:message key="servicio.gestionOrganismosExternos" bundle="resources"/></html:link>
						</c:if>	
						<c:if test="${(funcionalidades.funcionalidad.idFuncionalidad==121)}">
								<c:set var="gestionFestivoProperty"><bean:message key="servicio.gestionFestivos" bundle="resources" /></c:set>
								<html:link title="${gestionFestivoProperty}" action="./VisualizarFestivoGlobFrontAction.do?grupoNavegacion=1" paramId="servicioNavegacion" paramName="funcionalidades" paramProperty="funcionalidad.idFuncionalidad"><bean:message key="servicio.gestionFestivos" bundle="resources"/></html:link>							
							</c:if>	
						<c:if test="${(funcionalidades.funcionalidad.idFuncionalidad==122)}">
								<c:set var="estadisticaPublicacionProperty"><bean:message key="servicio.estadisticasPublicacion" bundle="resources" /></c:set>
								<html:link title="${estadisticaPublicacionProperty}" action="./EstadisticasPublicacionFrontAction.do?grupoNavegacion=1" paramId="servicioNavegacion" paramName="funcionalidades" paramProperty="funcionalidad.idFuncionalidad"><bean:message key="servicio.estadisticasPublicacion" bundle="resources"/></html:link>							
							</c:if>										
					</li> 
					</logic:iterate> 			
				</ul>
			</div>	
			</c:if>
					
			<c:if test="${(LoginCertificadoForm.administradorLocal==true)}">
			<div class="menu">
				<h2><bean:message key="comun.AdmLocal" bundle="resources"/></h2>
				<ul class="admin">				
					<logic:iterate id="funcionalidades" name="LoginCertificadoForm" property="funcionalidadesAdministradorLocal">
						<li>														
							<c:if test="${(funcionalidades.funcionalidad.idFuncionalidad==6)}">
								<c:set var="misRedaccionesProperty"><bean:message key="servicio.misRedacciones" bundle="resources" /></c:set>
								<html:link title="${misRedaccionesProperty}" action="./VisualizarMisRedaccionesFrontAction.do?grupoNavegacion=2" paramId="servicioNavegacion" paramName="funcionalidades" paramProperty="funcionalidad.idFuncionalidad"><bean:message key="servicio.misRedacciones" bundle="resources"/></html:link>							
							</c:if>							
							<c:if test="${(funcionalidades.funcionalidad.idFuncionalidad==5)}">
								<c:set var="misPublicacionesProperty"><bean:message key="servicio.publicaciones" bundle="resources" /></c:set>
								<html:link title="${misPublicacionesProperty}" action="./VisualizarEdictoPublicadorFrontAction.do?grupoNavegacion=2" paramId="servicioNavegacion" paramName="funcionalidades" paramProperty="funcionalidad.idFuncionalidad"><bean:message key="servicio.publicaciones" bundle="resources"/></html:link>							
							</c:if>
							<c:if test="${(funcionalidades.funcionalidad.idFuncionalidad==41)}">
								<c:set var="publicacionesSinAsignarProperty"><bean:message key="servicio.publicacionesSinAsignar" bundle="resources" /></c:set>
								<html:link title="${publicacionesSinAsignarProperty}" action="./VisualizarPublicacionesSinAsignarFrontAction.do?grupoNavegacion=2" paramId="servicioNavegacion" paramName="funcionalidades" paramProperty="funcionalidad.idFuncionalidad"><bean:message key="servicio.publicacionesSinAsignar" bundle="resources"/></html:link>							
							</c:if>
							<c:if test="${(funcionalidades.funcionalidad.idFuncionalidad==3)}">
								<c:set var="gestionUsuariosProperty"><bean:message key="servicio.gestionUsuarios" bundle="resources" /></c:set>
								<html:link title="${gestionUsuariosProperty}" action="./VisualizarUsuariosFrontAction.do?grupoNavegacion=2" paramId="servicioNavegacion" paramName="funcionalidades" paramProperty="funcionalidad.idFuncionalidad"><bean:message key="servicio.gestionUsuarios" bundle="resources"/></html:link>							
							</c:if>
							<c:if test="${(funcionalidades.funcionalidad.idFuncionalidad==7)}">
								<c:set var="gestionCentrosProcedenciaProperty"><bean:message key="servicio.gestionCentrosProcedencia" bundle="resources" /></c:set>
								<html:link title="${gestionCentrosProcedenciaProperty}" action="./VisualizarCentroFrontAction.do?grupoNavegacion=2" paramId="servicioNavegacion" paramName="funcionalidades" paramProperty="funcionalidad.idFuncionalidad"><bean:message key="servicio.gestionCentrosProcedencia" bundle="resources"/></html:link>							
							</c:if>
							<c:if test="${(funcionalidades.funcionalidad.idFuncionalidad==61)}">
								<c:set var="gestionTiposEdictosProperty"><bean:message key="servicio.gestionTiposEdictos" bundle="resources" /></c:set>
								<html:link title="${gestionTiposEdictosProperty}" action="./VisualizarTiposEdictosFrontAction.do?grupoNavegacion=2" paramId="servicioNavegacion" paramName="funcionalidades" paramProperty="funcionalidad.idFuncionalidad"><bean:message key="servicio.gestionTiposEdictos" bundle="resources"/></html:link>							
							</c:if>	
							<c:if test="${(funcionalidades.funcionalidad.idFuncionalidad==121)}">
								<c:set var="gestionFestivoProperty"><bean:message key="servicio.gestionFestivos" bundle="resources" /></c:set>
								<html:link title="${gestionFestivoProperty}" action="./VisualizarFestivoFrontAction.do?grupoNavegacion=2" paramId="servicioNavegacion" paramName="funcionalidades" paramProperty="funcionalidad.idFuncionalidad"><bean:message key="servicio.gestionFestivos" bundle="resources"/></html:link>							
							</c:if>	
							<c:if test="${(funcionalidades.funcionalidad.idFuncionalidad==122)}">
								<c:set var="estadisticaPublicacionProperty"><bean:message key="servicio.estadisticasPublicacion" bundle="resources" /></c:set>
								<html:link title="${estadisticaPublicacionProperty}" action="./EstadisticasPublicacionLocFrontAction.do?grupoNavegacion=2" paramId="servicioNavegacion" paramName="funcionalidades" paramProperty="funcionalidad.idFuncionalidad"><bean:message key="servicio.estadisticasPublicacion" bundle="resources"/></html:link>							
							</c:if>	
							<c:if test="${(funcionalidades.funcionalidad.idFuncionalidad==123)}">
								<c:set var="redesSocialesProperty"><bean:message key="servicio.redesSociales" bundle="resources" /></c:set>
								<html:link title="${redesSocialesProperty}" action="./VisualizarRedesFront.do?grupoNavegacion=2" paramId="servicioNavegacion" paramName="funcionalidades" paramProperty="funcionalidad.idFuncionalidad"><bean:message key="servicio.redesSociales" bundle="resources"/></html:link>							
							</c:if>					
<!--							<c:if test="${(funcionalidades.funcionalidad.idFuncionalidad==101)}">-->
<!--								<c:set var="gestionUsuariosFirmantesProperty"><bean:message key="servicio.gestionUsuariosFirmantes" bundle="resources" /></c:set>-->
<!--								<html:link title="${gestionUsuariosFirmantesProperty}" action="./VisualizarUsuariosFirmantesFrontAction.do?grupoNavegacion=2" paramId="servicioNavegacion" paramName="funcionalidades" paramProperty="funcionalidad.idFuncionalidad"><bean:message key="servicio.gestionUsuariosFirmantes" bundle="resources"/></html:link>							-->
<!--							</c:if>													-->
						</li>				
					</logic:iterate> 																
				</ul>
			</div>					
			</c:if>	
			
			<c:if test="${(LoginCertificadoForm.publicador==true)}">
			<div class="menu">
				<h2><bean:message key="comun.publicador" bundle="resources"/></h2>				
				<ul class="admin">					
					<logic:iterate id="funcionalidades" name="LoginCertificadoForm" property="funcionalidadesPublicador">
					<li>						
						<c:if test="${(funcionalidades.funcionalidad.idFuncionalidad==6)}">
							<c:set var="misRedaccionesProperty"><bean:message key="servicio.misRedacciones" bundle="resources" /></c:set>
							<html:link title="${misRedaccionesProperty}" action="./VisualizarMisRedaccionesFrontAction.do?grupoNavegacion=3" paramId="servicioNavegacion" paramName="funcionalidades" paramProperty="funcionalidad.idFuncionalidad"><bean:message key="servicio.misRedacciones" bundle="resources"/></html:link>
						</c:if>
						<c:if test="${(funcionalidades.funcionalidad.idFuncionalidad==5)}">
							<c:set var="misPublicacionesProperty"><bean:message key="servicio.misPublicaciones" bundle="resources" /></c:set>
							<html:link title="${misPublicacionesProperty}" action="./VisualizarEdictoPublicadorFrontAction.do?grupoNavegacion=3" paramId="servicioNavegacion" paramName="funcionalidades" paramProperty="funcionalidad.idFuncionalidad"><bean:message key="servicio.misPublicaciones" bundle="resources"/></html:link>						
						</c:if>
						<c:if test="${(funcionalidades.funcionalidad.idFuncionalidad==41)}">	
							<c:set var="publicacionesSinAsignarProperty"><bean:message key="servicio.publicacionesSinAsignar" bundle="resources" /></c:set>		
							<html:link title="${publicacionesSinAsignarProperty}" action="./VisualizarPublicacionesSinAsignarFrontAction.do?grupoNavegacion=3" paramId="servicioNavegacion" paramName="funcionalidades" paramProperty="funcionalidad.idFuncionalidad"><bean:message key="servicio.publicacionesSinAsignar" bundle="resources"/></html:link>
						</c:if>
					</li>
					</logic:iterate>					
				</ul>	
				</div>			
			</c:if>
			<c:if test="${(LoginCertificadoForm.redactor==true)}">
				<div class="menu">
				<h2><bean:message key="comun.redactor" bundle="resources"/></h2>				
				<ul class="admin">
					<logic:iterate id="funcionalidades" name="LoginCertificadoForm" property="funcionalidadesRedactor">
						<li>
							<c:if test="${(funcionalidades.funcionalidad.idFuncionalidad==6)}">
								<c:set var="gestionEdictosProperty"><bean:message key="servicio.gestionEdictos" bundle="resources" /></c:set>
								<html:link title="${gestionEdictosProperty}" action="./VisualizarEdictoFrontAction.do?grupoNavegacion=4&servicioNavegacion=-20"><bean:message key="servicio.gestionEdictos" bundle="resources"/></html:link>
							</c:if>
						</li>	
					</logic:iterate>			
				</ul>
				</div>				
			</c:if>
			
		</c:if>			 		
	