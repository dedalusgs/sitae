<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>

				
					<h3><bean:message key="servicio.gestionEdictos" bundle="resources"/></h3>	
					
						<h4><bean:message key="crearEdicto.titulo" bundle="resources"/></h4>																
						<div class="correcto">
						       <span><bean:message key="creado.exitoEdicto" bundle="resources"/></span>
						</div>					
					<html:form action="/VisualizarEdictoFrontAction.do">
						<div class="botonera border">
							<html:submit><bean:message key="boton.volver" bundle="resources"/></html:submit>  
						</div>  
					</html:form> 
						
