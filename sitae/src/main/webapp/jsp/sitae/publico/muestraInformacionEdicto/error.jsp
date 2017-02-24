<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>

		 

		  	<h4><bean:message key="muestraInformacionEdicto.titulo" bundle="resources"/></h4>	
		  							
			<div class="error" >
				<p><bean:message key="muestraInformacionEdicto.error" bundle="resources"/></p>
			</div>			
			<% String accionPublico = (String)session.getAttribute("accionPublico");%>				
			 <c:if test="${(accionPublico=='busquedaAvanzada')}">			
				<html:form action="/VisualizarEdictoPublicoFrontAction.do?accion=busquedaAvanzada&volver=">
				<div class="botonera border">
						<html:submit><bean:message key="boton.volver" bundle="resources"/>
						</html:submit>  
					</div>  	
				</html:form> 
			</c:if>
			
			 <c:if test="${(accionPublico=='edictosVigor')}">			
				<html:form action="/VisualizarEdictoPublicoFrontAction.do?accion=edictosVigor">
				<div class="botonera border">
						<html:submit><bean:message key="boton.volver" bundle="resources"/>
						</html:submit>  
					</div>  	
				</html:form> 
			</c:if>
			 <c:if test="${(accionPublico=='historicoEdictos')}">			
				<html:form action="/VisualizarEdictoPublicoFrontAction.do?accion=historicoEdictos&filtrar=s">
				<div class="botonera border">
						<html:submit><bean:message key="boton.volver" bundle="resources"/>
						</html:submit>  
					</div>  	
				</html:form> 
			</c:if>
			 <c:if test="${(accionPublico=='inicio')}">			
				<html:form action="/InitDoAction.do">
				<div class="botonera border">
						<html:submit><bean:message key="boton.volver" bundle="resources"/>
						</html:submit>  
					</div>  	
				</html:form> 
			</c:if>					 												
