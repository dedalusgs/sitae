<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="es.novasoft.comun.utils.OrganismoVisualizar"%>
	
	<% OrganismoVisualizar organismoVisualizar = (OrganismoVisualizar)session.getAttribute("organismoSesion");
	Object locale=(Object)session.getAttribute("org.apache.struts.action.LOCALE");
	String localeString=locale.toString();

	%>
	<%if(organismoVisualizar != null){%>
				<h4><bean:message key="servicio.avisoLegal" bundle="resources"/></h4>		
					<div id="accesibilidad">
							
						<p><bean:message key="contacto.comentario" bundle="resources"/></p>

						<h5><bean:message key="contacto.titulo" bundle="resources"/></h5>
						<% if (localeString.equalsIgnoreCase("es_ES")){ %>
							<p><%=organismoVisualizar.getNombre()%></p>
							<p><%=organismoVisualizar.getDireccion()%></p>
							<p><bean:message key="contacto.telefono" bundle="resources"/>: <%=organismoVisualizar.getTelefono()%></p>
							<p><bean:message key="contacto.fax" bundle="resources"/>: <%=organismoVisualizar.getFax()%></p>
							<p><bean:message key="contacto.email" bundle="resources"/>: <%=organismoVisualizar.getEmail()%></p>	
						<%}else { %>
							<p><%=organismoVisualizar.getNombreVa()%></p>
							<p><%=organismoVisualizar.getDireccionVa()%></p>
							<p><bean:message key="contacto.telefono" bundle="resources"/>: <%=organismoVisualizar.getTelefono()%></p>
							<p><bean:message key="contacto.fax" bundle="resources"/>: <%=organismoVisualizar.getFax()%></p>
							<p><bean:message key="contacto.email" bundle="resources"/>: <%=organismoVisualizar.getEmail()%></p>	
						
												
					<%	}%>
					</div>
		
	<%}%>	
				
