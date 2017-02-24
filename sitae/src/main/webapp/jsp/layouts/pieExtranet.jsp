<%@page import="es.novasoft.comun.constantes.Constantes"%>
<%@ page contentType="text/html"
     pageEncoding="ISO-8859-15" language="java"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="es.novasoft.comun.utils.OrganismoVisualizar"%>	
<%@page import="java.util.Locale, org.apache.struts.Globals"%>
<%
	String version=Constantes.getPropiedad(Constantes.VERSION);
	request.setAttribute("version", version);

%>

		<% OrganismoVisualizar organismoVisualizar = (OrganismoVisualizar)session.getAttribute("organismoSesion"); %>
		<%if(organismoVisualizar != null){%>						
			
			<% Locale locale = (Locale)session.getAttribute(Globals.LOCALE_KEY); %>
	
			<% if (locale!=null){ %>	
					<%if(locale.getLanguage().equals("va")){%>
						<p>	
			  			<% if( (!organismoVisualizar.getNombreVa().equals(""))){%>	
							<strong><%=organismoVisualizar.getNombreVa() %></strong>
						<%}%>	
						<% if( (!organismoVisualizar.getDireccionVa().equals(""))){%>	
							<%=organismoVisualizar.getDireccionVa() %>
						<%}%>												
						</p>	
					<%}else {%>
						<p>
						<% if( (!organismoVisualizar.getNombre().equals(""))){%>	
							<strong><%=organismoVisualizar.getNombre() %></strong>
						<%}%>
						
						<% if( (!organismoVisualizar.getDireccion().equals(""))){%>	
							<%=organismoVisualizar.getDireccion() %>
						<%}%>
						
						</p>
					<%}%>	  
				<%}%>	
					<c:if test="${((LoginCertificadoForm==null) || LoginCertificadoForm.registrado==false)}">	
							<p>
								<a  title='<bean:message key="boton.certificado" bundle="resources" />' href="./LoginConCertificadoFront.do">
									<img title='<bean:message key="boton.certificado" bundle="resources" />' src="img/ico-restringido-usuario.gif" />
									<bean:message key="boton.certificado" bundle="resources" />
								</a>
							</p>							
					</c:if>
				
				<ul>
					<li class="first">${version}</li>
					<li><a href="ServiciosPortalFrontAction.do?accion=contacto&grupoNavegacion=-2&servicioNavegacion=-30" title='<bean:message key="servicio.contacto" bundle="resources"/>'><bean:message key="servicio.contacto" bundle="resources"/></a></li>				
<%--					<li><a href="#" title='<bean:message key="servicio.ayuda" bundle="resources"/>'><bean:message key="servicio.ayuda" bundle="resources"/></a></li>				--%>
					<li><a href="ServiciosPortalFrontAction.do?accion=ayuda&grupoNavegacion=-2&servicioNavegacion=-31" title='<bean:message key="servicio.ayuda" bundle="resources"/>'><bean:message key="servicio.ayuda" bundle="resources"/></a></li>
					<li><a href="ServiciosPortalFrontAction.do?accion=mapaWeb&grupoNavegacion=-2&servicioNavegacion=-32" title='<bean:message key="servicio.mapaWeb" bundle="resources"/>'><bean:message key="servicio.mapaWeb" bundle="resources"/></a></li>
					<li><a href="ServiciosPortalFrontAction.do?accion=accesibilidad&grupoNavegacion=-2&servicioNavegacion=-33" title='<bean:message key="servicio.accesibilidad" bundle="resources"/>'><bean:message key="servicio.accesibilidad" bundle="resources"/></a></li>
					<li><a href="ServiciosPortalFrontAction.do?accion=avisoLegal&grupoNavegacion=-2&servicioNavegacion=-34" title='<bean:message key="servicio.avisoLegal" bundle="resources"/>'><bean:message key="servicio.avisoLegal" bundle="resources"/></a></li>
					<li><a href="ServiciosPortalFrontAction.do?accion=acercaDe&grupoNavegacion=-2&servicioNavegacion=-35" title='<bean:message key="servicio.acercaDe" bundle="resources"/>'><bean:message key="servicio.acercaDe" bundle="resources"/></a></li>
					
				</ul>
				<ul style="clear:both;width: 180px;">
				<li class="first"><a id="destacado_vfe" href="/vfe"  title='<bean:message key="servicio.vfe" bundle="resources"/>'><bean:message key="servicio.vfe" bundle="resources"/></a></li>
					</ul>
																					
		<%}else {%>
				<p><strong></strong></p>
<%--				<ul>--%>
<%--					<li class="first"><a href="#" title='<bean:message key="servicio.contacto" bundle="resources"/>'><bean:message key="servicio.contacto" bundle="resources"/></a></li>				--%>
<%--					<li><a href="#" title='<bean:message key="servicio.ayuda" bundle="resources"/>'><bean:message key="servicio.ayuda" bundle="resources"/></a></li>				--%>
<%--					<li><a href="#" title='<bean:message key="servicio.mapaWeb" bundle="resources"/>'><bean:message key="servicio.mapaWeb" bundle="resources"/></a></li>--%>
<%--					<li><a href="#" title='<bean:message key="servicio.accesibilidad" bundle="resources"/>'><bean:message key="servicio.accesibilidad" bundle="resources"/></a></li>--%>
<%--					<li><a href="#" title='<bean:message key="servicio.avisoLegal" bundle="resources"/>'><bean:message key="servicio.avisoLegal" bundle="resources"/></a></li>--%>
<%--					<li><a href="#" title='<bean:message key="servicio.acercaDe" bundle="resources"/>'><bean:message key="servicio.acercaDe" bundle="resources"/></a></li>--%>
<%--				</ul>				--%>
		<%}%>	
		  	