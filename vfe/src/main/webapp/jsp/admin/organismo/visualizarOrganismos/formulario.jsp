<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/displaytag.tld" prefix="display"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<%@page import="java.util.Locale,org.apache.struts.Globals"%>

<script type="text/javascript">
			
		function confirmarBorrado(mensaje){
			if(confirm(mensaje)){
	  			return true;
	    	}else{
	  			return false;
	   		}
		}
				
	</script>

<h3><bean:message key="servicio.gestionOrganismos"
	bundle="resources" /></h3>

<display:table name="${VisualizarOrganismoForm.nuevalistaOrganismos}"
	id="nuevalistaOrganismos" pagesize="10" sort="list"
	requestURI="./VisualizarOrganismoFrontAction.do">

	<c:set var="organismoProperty">
		<bean:message key="cabecera.organismo" bundle="resources" />
	</c:set>

	<%
		Locale locale = (Locale) session
					.getAttribute(Globals.LOCALE_KEY);
	%>

	<%
		if (locale != null) {
	%>
	<%
		if (locale.getLanguage().equals("va")) {
	%>
	<display:column class="listado_representantes"
		headerClass="cabecera_tabla" property="nombreVa"
		title="${organismoProperty}" />
	<%
		} else {
	%>
	<display:column class="listado_representantes"
		headerClass="cabecera_tabla" property="nombre"
		title="${organismoProperty}" />
	<%
		}
	%>
	<%
		}
	%>

	<c:set var="modificarOrganismoProperty">
		<bean:message key="boton.modificarOrganismo" bundle="resources" />
	</c:set>

	<display:column class="listado_representantes"
		headerClass="cabecera_tabla ancho-20">

		<center><html:link action="/ModificarOrganismoFrontAction.do"
			paramId="idOrganismoSelecionado" paramName="nuevalistaOrganismos"
			paramProperty="idOrg">
			<img title="${modificarOrganismoProperty} "
				src="${pageContext.request.contextPath}/img/ico16-editar.gif"
				alt="${modificarOrganismoProperty} " />
		</html:link></center>

	</display:column>

	<c:set var="eliminarOrganismoProperty">
		<bean:message key="boton.eliminarOrganismo" bundle="resources" />
	</c:set>
	<c:set var="eliminarOrganismoConfirmacionProperty">
		<bean:message key="boton.eliminarOrganismoConfirmacion"
			bundle="resources" />
	</c:set>

	<display:column class="listado_expedientes"
		headerClass="cabecera_tabla ancho-20">

		<center><html:link action="/BajaOrganismoDo.do"
			paramId="idOrganismoSelecionado" paramName="nuevalistaOrganismos"
			paramProperty="idOrg">
			<img title="${eliminarOrganismoProperty}"
				onclick="return confirmarBorrado('${eliminarOrganismoConfirmacionProperty}');"
				src="${pageContext.request.contextPath}/img/ico16-borrar.gif"
				alt="${eliminarOrganismoProperty}" />
		</html:link></center>

	</display:column>

	<c:set var="verInformacionOrganismoProperty">
		<bean:message key="boton.verInformacionOrganismo" bundle="resources" />
	</c:set>

	<display:column class="listado_expedientes"
		headerClass="cabecera_tabla ancho-20">

		<center><html:link
			action="/MuestraInformacionOrganismoFrontAction.do"
			paramId="idOrganismoSelecionado" paramName="nuevalistaOrganismos"
			paramProperty="idOrg">
			<img title="${verInformacionOrganismoProperty}"
				src="${pageContext.request.contextPath}/img/ico16-buscar.gif"
				alt="${verInformacionOrganismoProperty}" />
		</html:link></center>

	</display:column>

</display:table>


<html:form action="/AltaOrganismoFrontAction.do" method="post"
	enctype="multipart/form-data">

	<div class="botonera"><html:submit>
		<bean:message key="boton.nuevoOrganismo" bundle="resources" />
	</html:submit></div>

</html:form>

<form action="./IndexAdmin.do">
<div class="botonera border"> <input
	 type="submit"  bundle="resources" value='<bean:message key="boton.volver" bundle="resources" />'  ></input>   </div>
</form>

