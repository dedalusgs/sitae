<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<%
	String accionPublico = (String) session
			.getAttribute("accionPublico");
%>

	<h3>
		<bean:message key="servicio.estadisticasPublicacion" bundle="resources" />
	</h3>

<html:form
	action="/EstadisticasPublicacionLocDoAction.do"
	method="post" enctype="multipart/form-data">
	<logic:messagesPresent>
		<div class="error">
			<html:errors />
		</div>
	</logic:messagesPresent>

	
		<fieldset>
			<legend>
				<bean:message key="estadisticas.parametrosCalculo" bundle="resources" />
			</legend>
			<html:hidden name="EstadisticasPublicacionForm" property="opcionOrganismo"/>
						
			
			<div class="detalle">
				<label>
					<bean:message key="estadisticas.fechaInicio"	bundle="resources" />
					
				</label>
				<html:text maxlength="10" name="EstadisticasPublicacionForm"
					property="fechaInicio" styleId="i_date_inicio"
					readonly="false" styleClass="detalleCalendar"
					onchange="ActualizaFechaPublicacion(i_date_inicio)" />
				<html:image bundle="resources" altKey="seleciona.fecha"
					styleClass="input_img" titleKey="seleciona.fecha"
					src="${pageContext.request.contextPath}/img/calendar.gif"
					styleId="i_trigger_inicio" onclick="return false;"
					onmouseover="this.src='${pageContext.request.contextPath}/img/calendar.gif';"
					onmouseout="this.src='${pageContext.request.contextPath}/img/calendar.gif';" />
			</div>
	<script type="text/javascript">

	
	

Calendar.setup( {
	inputField : "i_date_inicio",
	dateFormat : "%d/%m/%Y",
	showsTime : false,
	timeFormat : "24",
	trigger : "i_trigger_inicio",
	onSelect   : function() { this.hide(); }
	
});</script> 

			<div class="detalle">
				<label>
						<bean:message key="estadisticas.fechaFin"	bundle="resources" />
				</label>
				<html:text maxlength="10" name="EstadisticasPublicacionForm"
					property="fechaFin" styleId="i_date_fin"
					readonly="false" styleClass="detalleCalendar"
					onchange="ActualizaFechaPublicacion(i_date_fin)" />
				<html:image bundle="resources" altKey="seleciona.fecha"
					styleClass="input_img" titleKey="seleciona.fecha"
					src="${pageContext.request.contextPath}/img/calendar.gif"
					styleId="i_trigger_fin" onclick="return false;"
					onmouseover="this.src='${pageContext.request.contextPath}/img/calendar.gif';"
					onmouseout="this.src='${pageContext.request.contextPath}/img/calendar.gif';" />
			</div>

			<script type="text/javascript">

Calendar.setup( {
	inputField : "i_date_fin",
	dateFormat : "%d/%m/%Y",
	showsTime : false,
	timeFormat : "24",
	trigger : "i_trigger_fin",
	onSelect   : function() { this.hide() }
	
});
</script>

		</fieldset>
		<div class="botonera">
			<html:submit>
				<bean:message key="estadisticas.generar" bundle="resources" />
			</html:submit>
		</div>
	
</html:form>

<logic:notEmpty name="EstadisticasPublicacionForm" property="urlImageChart">
	<div>
		<c:choose>
			<c:when test="${EstadisticasPublicacionForm.urlImageChart=='NO'}">
				<span class="bold"><bean:message key="estadisticas.sinResultados" bundle="resources" /></span>
			</c:when>
			<c:otherwise>
			<div style="margin-bottom:20px;">
				<h4><bean:message key="estadisticas.titulo1" bundle="resources" />  ${EstadisticasPublicacionForm.fechaInicio} - ${EstadisticasPublicacionForm.fechaFin}</h4>
				<img src="${EstadisticasPublicacionForm.urlImageChart}"	  alt="Resultado Estadísticas" />
			</div>
			<hr/>
			<div style="margin-top:20px;">
			<h4><bean:message key="estadisticas.titulo2" bundle="resources" /> ${EstadisticasPublicacionForm.fechaInicio} - ${EstadisticasPublicacionForm.fechaFin}</h4>
				<img src="${EstadisticasPublicacionForm.urlImageChartExtern}"	  alt="Resultado Estadísticas" />
			</div>
			
			<div class="botonera">
				<a href="DescargarEstadisticasCSV.do?org=${EstadisticasPublicacionForm.opcionOrganismo}&fechaInicio=${EstadisticasPublicacionForm.fechaInicio}&fechaFin=${EstadisticasPublicacionForm.fechaFin}" ><bean:message key="estadisticas.descargarCSV" bundle="resources" /></a>
				<a href="DescargarEstadisticasPDF.do?org=${EstadisticasPublicacionForm.opcionOrganismo}&fechaInicio=${EstadisticasPublicacionForm.fechaInicio}&fechaFin=${EstadisticasPublicacionForm.fechaFin}" ><bean:message key="estadisticas.descargarPDF" bundle="resources" /></a>
			</div>
			</c:otherwise>
		</c:choose>
	</div>
</logic:notEmpty>