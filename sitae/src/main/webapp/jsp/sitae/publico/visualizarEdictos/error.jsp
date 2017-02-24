<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>

								
				<% String accionPublico = (String)session.getAttribute("accionPublico");%>	
			    <c:if test="${(accionPublico=='edictosVigor')}">			
					<h3><bean:message key="edictosVigor.titulo" bundle="resources"/></h3>
				</c:if>
			 	<c:if test="${(accionPublico=='historicoEdictos')}">							
					<h3><bean:message key="historicoEdictos.titulo" bundle="resources"/></h3>
				</c:if>
			 	<c:if test="${(accionPublico=='busquedaAvanzada')}">			
					<h3><bean:message key="busquedaAvanzada.titulo" bundle="resources"/></h3>
				</c:if>					 												
													
				<h4><bean:message key="visualizarListaEdictos.titulo" bundle="resources"/></h4>
				<div class="error" >
					<p><bean:message key="visualizarListaEdictos.error" bundle="resources"/></p>
				</div>													
				

