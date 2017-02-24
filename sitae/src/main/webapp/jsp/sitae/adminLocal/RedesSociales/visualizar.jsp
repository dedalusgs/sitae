<%@page import="es.novasoft.comun.constantes.Constantes"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>

<%
Boolean siGoogle= new Boolean(Constantes.getPropiedad("social.googleplus.activado"));
request.setAttribute("siGoogle", siGoogle);
%>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/modal.js"></script>	
	<script type="text/javascript">
			
		function confirmarBorrado(mensaje){
			if(confirm(mensaje)){
	  			return true;
	    	}else{
	  			return false;
	   		}
		}
		
				
	</script>
					<c:set var="mensajeCancelar"><bean:message key="redesSociales.confirmareliminar" bundle="resources" /></c:set>
					<c:set var="cancelar"><bean:message key="redesSociales.cancelar" bundle="resources" /></c:set>			
					<h3><bean:message key="redesSociales.tituloGestion" bundle="resources"/></h3>			
		    			    		  	
	  				<form>
	  					<fieldset>
	  					<legend>Facebook</legend>
	  					<logic:empty name="organismo" property="facebook"> 
	  					<div><bean:message key="redesSociales.sinConfiguracion" bundle="resources"/></div>
	  					<div class="botonera"> <a href ="./ConfigurarFacebookFront.do"><bean:message key="redesSociales.establecer" bundle="resources"/></a></div>
	  					</logic:empty>
	  					<logic:notEmpty name="organismo" property="facebook">
	  					<div> 	<span style="float:left"><img  src="${organismo.facebook.urlImgUser}" style="border:solid white 3px;"/></span><span style="float:left;padding-left:20px;padding-top:10px" ><p><bean:message key="redesSociales.nombre" bundle="resources"/>: ${organismo.facebook.nombre}</p><p><bean:message key="redesSociales.url" bundle="resources"/>: ${organismo.facebook.urlUser}</p></span></div>
	  					<div class="botonera"> 
	  						<html:link action="./CancelarFacebookFront.do"  onclick="return confirmarBorrado('${mensajeCancelar}');" title="${cancelar}">${cancelar}
							</html:link>
	  					 	<a href ="./ConfigurarFacebookFront.do"><bean:message key="boton.modificar" bundle="resources"/></a>
	  					 </div>
	  					</logic:notEmpty> 
	  					</fieldset>
	  				
	  				</form>	 
	  				
	  					    		  	
	  				<form>
	  					<fieldset>
	  					<legend>Twitter</legend>
	  					<logic:empty name="organismo" property="twitter"> 
	  					<div><bean:message key="redesSociales.sinConfiguracion" bundle="resources"/></div>
	  					<div class="botonera"> <a href ="./ConfigurarTwitterFront.do"><bean:message key="redesSociales.establecer" bundle="resources"/></a></div>
	  					</logic:empty>
	  					<logic:notEmpty name="organismo" property="twitter">
	  					<div> 	<span style="float:left"><img style="border:solid white 3px; border-radius:5 px;" src="${organismo.twitter.urlImgUser}"/></span><span style="float:left;padding-left:20px;padding-top:10px" ><p><bean:message key="redesSociales.nombre" bundle="resources"/>: ${organismo.twitter.nombre}</p><p><bean:message key="redesSociales.usuario" bundle="resources"/>: @${organismo.twitter.urlUser}</p></span></div>
	  					<div class="botonera"><html:link action="./CancelarTwitterFront.do"  onclick="return confirmarBorrado('${mensajeCancelar}');" title="${cancelar}">${cancelar}
							</html:link>  <a href ="./ConfigurarTwitterFront.do"><bean:message key="boton.modificar" bundle="resources"/></a></div>
	  					</logic:notEmpty> 
	  					</fieldset>
	  				
	  				</form>	 
	  				
	  					  <c:if test="${siGoogle eq true}"> 		  	
	  				<form>
	  					<fieldset>
	  					<legend>Google +</legend>
	  					<logic:empty name="organismo" property="google"> 
	  					<div><bean:message key="redesSociales.sinConfiguracion" bundle="resources"/></div>
	  					<div class="botonera"> <a href ="./ConfigurarGooglePlusFront.do"><bean:message key="redesSociales.establecer" bundle="resources"/></a></div>
	  					</logic:empty>
	  					<logic:notEmpty name="organismo" property="google">
	  					<div> 	<span style="float:left"><img style="border:solid white 3px; border-radius:5px;" src="${organismo.google.urlImgUser}"/></span><span style="float:left;padding-left:20px;padding-top:10px" >
	  					<p><bean:message key="redesSociales.nombre" bundle="resources"/>: ${organismo.google.nombre}</p><p><bean:message key="redesSociales.url" bundle="resources"/>: ${organismo.google.urlUser}</p></span></div>
	  					<div class="botonera"> <html:link action="./CancelarGooglePlusFront.do"  onclick="return confirmarBorrado('${mensajeCancelar}');" title="${cancelar}">${cancelar}
							</html:link><a href ="./ConfigurarGooglePlusFront.do"><bean:message key="boton.modificar" bundle="resources"/></a></div>
	  					</logic:notEmpty> 
	  					</fieldset>
	  				
	  				</form>	 
	  				</c:if> 
	  				
	  														

