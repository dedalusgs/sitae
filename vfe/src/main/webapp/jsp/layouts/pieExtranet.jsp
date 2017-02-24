<%@ page contentType="text/html"
     pageEncoding="ISO-8859-15" language="java"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="es.novasoft.castellon.vfe.business.objects.Organismo"%>	
<%@page import="java.util.Locale, org.apache.struts.Globals"%>

		<% Organismo organismoVisualizar = (Organismo)session.getAttribute("organismoSesion"); %>
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
					<c:if test="${((LoginForm==null) || LoginForm.registrado==false)}">	
							<p>
								<a  title='<bean:message key="boton.certificado" bundle="resources" />' href="./LoginFront.do">
									<img title='<bean:message key="boton.certificado" bundle="resources" />' src="img/ico-restringido-usuario.gif" />
									<bean:message key="boton.certificado" bundle="resources" />
								</a>
							</p>							
					</c:if>
					<c:if test="${!((LoginForm==null) || LoginForm.registrado==false)}">	
<!--							<p>-->
<!--								<a  title='<bean:message key="boton.certificado" bundle="resources" />' href="./IndexAdmin.do">-->
<!--									<img title='<bean:message key="boton.certificado" bundle="resources" />' src="img/ico-restringido-usuario.gif" />-->
<!--									<bean:message key="boton.certificado" bundle="resources" />-->
<!--								</a>-->
<!--							</p>							-->
					</c:if>
																		
		<%}else {%>
				<p><strong></strong></p>
		<%}%>	
		  	