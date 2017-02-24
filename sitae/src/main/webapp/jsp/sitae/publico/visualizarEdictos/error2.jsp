<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>
<html:html xhtml="true">

			<div id="contenido" >
				<h1><bean:message key="visualizarListaEdictos.titulo" bundle="resources"/></h1>
				<div class="fondo-top">
				
					<div   align="center" class="msj-error" >
						<span><bean:message key="visualizarListaEdictos.error2" bundle="resources"/></span>
					</div>
					
					<div align="center" class="msj-botonera">
						<input type="submit" id="enviar" value='<bean:message key="boton.volver" bundle="resources"/>' onclick="history.back()" />						  
					</div>  	
								
				</div>
				
			</div>

</html:html>
