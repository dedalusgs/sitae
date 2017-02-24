<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>

		
			<h3><bean:message key="servicio.misRedacciones" bundle="resources"/></h3>
			
				<h4><bean:message key="cancelarPublicacion.titulo" bundle="resources"/></h4>							
						<div class="correcto">
						       <p><bean:message key="cancelarPublicacion.envio" bundle="resources"/></p>
						</div>
														
				<html:form action="/VisualizarMisRedaccionesFrontAction.do">
						<div align="center" class="botonera border">
							<html:submit><bean:message key="boton.volver" bundle="resources"/></html:submit>  
						</div>  	
				</html:form> 

