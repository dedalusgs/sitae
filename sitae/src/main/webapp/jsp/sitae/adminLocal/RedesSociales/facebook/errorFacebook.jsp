<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
						
						<h3><bean:message key="redesSociales.tituloGestion" bundle="resources"/></h3>
						<h4><bean:message key="redesSociales.ConfigurarFacebook" bundle="resources"/></h4>			
			   				
							<div class="error" >
								<c:if test="${errorFacebook=='noConcededido' }">
								<p><bean:message key="redesSociales.facebook.error.mensaje11" bundle="resources"/></p>
								<p><bean:message key="redesSociales.facebook.error.mensaje12" bundle="resources"/></p>	
								</c:if>	
								<c:if test="${errorFacebook!='noConcededido' }">
								<p> <bean:message key="redesSociales.facebook.error.mensaje2" bundle="resources"/></p>
								</c:if>
								
							</div>
								  
						<div class="botonera"><a href="./VisualizarRedesFront.do"><bean:message key="boton.volver" bundle="resources"/></a></div>
							
					