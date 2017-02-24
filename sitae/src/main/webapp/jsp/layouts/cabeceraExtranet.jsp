<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@page import="es.novasoft.comun.utils.OrganismoVisualizar"%>
<%@page import="java.util.Locale, org.apache.struts.Globals"%>

<%@ page contentType="text/html"
    pageEncoding="UTF-8" language="java"%>
    <% Locale locale = (Locale)session.getAttribute(Globals.LOCALE_KEY); %>
    <% OrganismoVisualizar organismoVisualizar = (OrganismoVisualizar)session.getAttribute("organismoSesion"); %>
	<div id="cabecera">
		<div id="celda_izq">			
				<% if (locale!=null){ %>	
					<%if(locale.getLanguage().equals("va")){%>	
			  			<h1 style="padding-left:30px;" class="logo_va">
					<%}else {%>
						<h1 style="padding-left:30px;">
					<%}%>	  
				<%}%>				            
            <% if (organismoVisualizar!=null){ %>	
           		<a href="./InitDoAction.do?servicioNavegacion=-1&grupoNavegacion=-1" title="<bean:message key='portal.titulo' bundle='resources'/>">
            	<span><bean:message key="portal.titulo" bundle="resources"/></span></a>
           	<% }else { %>
           		<a href="#" title="<bean:message key='portal.titulo' bundle='resources'/>">
            	<span><bean:message key="portal.titulo" bundle="resources"/></span></a>
           	<% } %>	
            </h1>          
		</div>		
		<div id="celda_der">		
		<%if(organismoVisualizar != null){%>
			<%if(organismoVisualizar.getImagen() != null){%>		
				<img title="<%=organismoVisualizar.getNombre() %>" height="68" src="<%=organismoVisualizar.getImagen() %>" alt="<%=organismoVisualizar.getNombre() %>" />
			<%}else {%>
				<img src="img/escudo.png" alt="Ayuntamiento sin escudo" />
			<%}%>			
			
	
			<% if (locale!=null){ %>	
					<%if(locale.getLanguage().equals("va")){%>	
			  			<% if( (!organismoVisualizar.getNombreVa().equals(""))){%>	
							<p><%=organismoVisualizar.getNombreVa() %></p>
						<%}else {%>
							<p></p>
						<%}%>
					<%}else {%>
						<% if( (!organismoVisualizar.getNombre().equals(""))){%>	
							<p><%=organismoVisualizar.getNombre() %></p>
						<%}else {%>
							<p></p>
						<%}%>
					<%}%>	  
				<%}%>											
		<%}%>							
		</div>							 
	</div>
		