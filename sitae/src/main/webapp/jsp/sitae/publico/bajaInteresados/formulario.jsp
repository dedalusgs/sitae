<%@page import="net.tanesha.recaptcha.ReCaptchaImpl"%>
<%@page import="es.novasoft.comun.utils.OrganismoVisualizar"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<%@page import="java.util.Locale"%>
<%@page import="org.apache.struts.Globals"%>




<%

	OrganismoVisualizar organismoVisualizar = (OrganismoVisualizar) session.getAttribute("organismoSesion");
	Locale locale = (Locale) session.getAttribute(Globals.LOCALE_KEY);
	String nombreOrganismo = organismoVisualizar.getNombre();
	if (locale.equals("va")) nombreOrganismo=organismoVisualizar.getNombreVa();
	request.setAttribute("nombreOrganismo", nombreOrganismo);
	
	String publicKey=(String)request.getAttribute("captchaPublicKey");
	String privateKey=(String)request.getAttribute("captchaPrivateKey");

	ReCaptchaImpl c = new ReCaptchaImpl();
	c.setIncludeNoscript(true);
	c.setPrivateKey(privateKey);
	c.setPublicKey(publicKey);
	c.setRecaptchaServer("https://www.google.com/recaptcha/api");
	
%>

	<h3>
		<bean:message key="listaCorreo.bajasuscripcion.titulo" bundle="resources" />  
	</h3>

<div class="content">
	<p>
		<bean:message key="listaCorreo.bajasuscripcion.mensajeIns1" bundle="resources" /> 
	</p>
		
	
</div>
<logic:messagesPresent>
			 		<div class="error">
			  			<html:errors/>
			 		</div>				 	
				</logic:messagesPresent>
<html:form action="BajaSuscripcionDo.do"  method="post" enctype="multipart/form-data">			
				 
							    

			  	<fieldset>	
			  					
						 <legend><bean:message key="listaCorreo.altasuscripcion.relleneform" bundle="resources" /></legend>					
					 	
					 	<div class="detalle"> 
					 	   <label><bean:message key="listaCorreo.form.direccionCorreo" bundle="resources" /> (*)</label>
							<html:text name="BajaSuscripcionForm" property="correo"/>
						 </div>
						 <div class="detalle"> 
					 	  <label><bean:message key="listaCorreo.form.codigoVerificacion" bundle="resources" /> (*)</label>
							<% out.print(c.createRecaptchaHtml(null, null)); %>
						 </div>
					 
					</fieldset>
					<div align="right">
					<i><bean:message key="campos.obligatorios" bundle="resources" /></i>
				</div>
					
				<div class="hr">
					<hr />
				</div>
									
				<div class="botonera">
						<html:submit>						
							<bean:message key="boton.enviar" bundle="resources"/>
						</html:submit>
				</div>		
	</html:form>
 				
					
				<div class="botonera border"><a href="./"><bean:message key="boton.volver"  bundle="resources"/></a></div>





