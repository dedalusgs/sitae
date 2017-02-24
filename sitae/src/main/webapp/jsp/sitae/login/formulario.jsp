<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script language="Javascript">		
		
		function CambiaOrganismo(objetoOrganismo) {
				document.LoginCertificadoForm.action = "./LoginCertificadoFront.do?recarga=si" ;
				document.LoginCertificadoForm.submit();
		}
						
		
</script>

<body class="popup">

	<div id="cuerpo">
	
	<div id="contenido" > 
		<div>
			<h1><bean:message key="login.usuario" bundle="resources"/></h1>
		</div>
		
		<div class="fondo-top">
			<html:form action="/LoginCertificadoDoAction.do" method="post" enctype="multipart/form-data">
				<logic:messagesPresent>
					<div class="error">
				  		<html:errors/>
			 		</div>
			 	</logic:messagesPresent>
			     
			
				<fieldset>
				
  					<div class="detalle">
							<label><bean:message key="datosorganismo.titulo" bundle="resources" /></label>							
							<html:select styleClass=""  
								property="opcionOrganismo" title="Organismo"
								styleId="objetoOrganismo"
								onchange="CambiaOrganismo(objetoOrganismo);">
								<html:option value=""><bean:message key="select.seleccione" bundle="resources" /></html:option>
								<html:optionsCollection property="listaOrganismos" label="nombre" value="cif"/>
							</html:select>							
					</div>
					
					<div>	
						<label><bean:message key="datosperfil.titulo" bundle="resources"/></label>
							
							<html:select property="opcionPerfil">
								<html:option value="" key="select.seleccione" bundle="resources" ></html:option>
								<html:optionsCollection property="listaPerfiles" label="nombre" value="nombre"/>								   	  			
							</html:select>		
					</div>		
				    
  				</fieldset>
  				   			
				<div class="hr">
					<hr />
				</div>
				
				<div class="fondo-top">
					<fieldset>
						<div class="botonera">
							<html:submit><bean:message key="boton.entrar" bundle="resources"/></html:submit>
						</div>
					</fieldset>
				</div>					
			</html:form>
			
					
				
	</div>		
	</div>
	</div>

	
</body>
