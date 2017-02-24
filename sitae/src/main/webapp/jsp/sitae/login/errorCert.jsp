<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<html:html xhtml="true">
<body class="popup">

	<div id="cuerpo">
		<div id="contenido">
		
		<%
			String error=(String)request.getSession().getAttribute("valuerror");
			String causerror=(String)request.getSession().getAttribute("causerror");
		
		 %>

			<h2><bean:message key="login.usuario" bundle="resources" /></h2>

			<div class="fondo-top">

				<div align="center" class="error">


					<p class="error">
						<bean:message key="<%=causerror%>" bundle="resources" />
						<br /><span class="minusculas"><bean:message key="<%=error%>" bundle="resources" /></span><br />
					</p>

					<%--								<span><bean:message key="error.certificado" bundle="resources"/></span>--%>
				</div>


				<html:form action="/InitDoAction.do">
					<div align="center" class="botonera">
						<html:submit>
							<bean:message key="boton.volver" bundle="resources" />
						</html:submit>
					</div>
				</html:form>
			</div>


		</div>
	</div>
</body>
</html:html>
