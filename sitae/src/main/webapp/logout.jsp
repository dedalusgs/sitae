<%@ page language="java" import="javax.servlet.http.HttpSession" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@page import="es.novasoft.comun.utils.OrganismoVisualizar"%>

<script languaje="javascript" type="text/javascript">
	window.history.go(1);
</script>
<script languaje="javascript" type="text/javascript">

function Cerrar_Sesion_Ir_Inicio(codigoOrganismo) {
	
	document.redirigir.action = "./InitDoAction.do?action=logout";		
	document.redirigir.submit();	
}

</script >
  <%  	
  	if (session!=null) {
		OrganismoVisualizar organismoVisualizar = (OrganismoVisualizar)session.getAttribute("organismoSesion");		
		if (organismoVisualizar!=null){		
		%>
		<body onload="Cerrar_Sesion_Ir_Inicio('<%=organismoVisualizar.getCodigo() %>')" >
			<form name="redirigir" method="post" action="" enctype="multipart/form-data">
			</form>&nbsp;&nbsp; &nbsp;	
			<body><br><br></body>
			<%request.getSession().invalidate();%> 
		<% } else { %>
			<jsp:forward page="/sesionExpirada.jsp">
				<jsp:param name="url" value="index.jsp"/>
			</jsp:forward>
		<% } %>
		
	<% } else {%>
			<jsp:forward page="/sesionExpirada.jsp">
				<jsp:param name="url" value="index.jsp"/>
			</jsp:forward>
		
	<% } %>

