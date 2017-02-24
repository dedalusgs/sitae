<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="es" xml:lang="es" xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
		<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
		<title>Error Acceso</title>

	</head>
	<body>
		

		<div class="errores">
			<div class="errores">
			<p><strong>
				<bean:message key="error.acceso" bundle="resources"/>
			</strong>
			</p>
		</div> 
		</div> 
		
		<br/>
		
		<div class="hr"><hr/></div>
        
<div class="botonera">
	<input type="submit" id="enviar" value="<bean:message key="boton.volver" bundle="resources"/>" onclick="history.back()" />
</div>  
		
	</body>
</html>
