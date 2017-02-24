<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script language="Javascript">		
		
		function confirmarPublicacion(mensaje){
			if(confirm(mensaje)){
	  			return true;
	    	}else{
	  			return false;
	   		}
		}
		
</script>


<body class="popup">
	<div id="cuerpo">

	<div id="contenido" > 
		<div>
			<h1><bean:message key="publicarEdicto.titulo" bundle="resources"/></h1>
		</div>
		
		<div class="fondo-top">
		    
					<html:form action="/PublicarEdictoDo.do" onsubmit="return confirmarPublicacion('¿Seguro que desea publicar el edicto?');"  method="post" enctype="multipart/form-data">
				
						<logic:messagesPresent>
							<div class="error">
						  		<html:errors/>
					 		</div>
			 			</logic:messagesPresent>
			 			
						
						<fieldset>
							<div class="botonera">
								<html:submit><bean:message key="boton.publicarEdicto" bundle="resources"/></html:submit>
							</div>
						</fieldset> 
							
		  			</html:form>
				

					<html:form action="/VisualizarEdictoPublicadorFrontAction.do" method="post" enctype="multipart/form-data">
				
						<div class="botonera">						
							<html:submit><bean:message key="boton.volver" bundle="resources"/></html:submit>
						</div>
					
					</html:form> 

		</div>
			
	</div>
	
	</div>
	</body>
