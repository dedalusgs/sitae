<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link type="text/css" rel="stylesheet" href="js/modal.css" />

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/modal.js"></script>	

<body class="popup">

	<div id="cuerpo">
	
		<div id="contenido" >
				
			<div class="fondo-top">
			
			<html:form action="/PublicarEdictoCrearDo.do" method="post" enctype="multipart/form-data">							    

			  	<fieldset>	
			  	
			  		<legend><span><label><bean:message key="crearEdicto.titulo" bundle="resources"/></label></span></legend>					
					
						<div class="detalle"> 
					 	   <label><bean:message key="datosedicto.codigo" bundle="resources"/></label>
							<html:text name="CrearEdictoMisRedaccionesForm" property="edicto.codigo" readonly="true"/>
						</div> 
					
					 	<div class="detalle"> 
					 	   <label><bean:message key="datosedicto.titulo" bundle="resources"/></label>
							<html:text name="CrearEdictoMisRedaccionesForm" property="edicto.titulo" readonly="true"/>
						</div> 
						
						<div class="detalle">
							<label><bean:message key="datosedicto.numExp" bundle="resources"/></label>
							<html:text name="CrearEdictoMisRedaccionesForm" property="edicto.numExp" readonly="true"/>
						</div>
						
					 	<div class="detalle"> 
					 		<label><bean:message key="datosedicto.descripcion" bundle="resources"/></label>
							<html:textarea  name="CrearEdictoMisRedaccionesForm" property="edicto.descripcion" readonly="true"/>
						</div>		
						
						<div class="detalle"> 
					 		<label><bean:message key="datosedicto.centroProcedencia" bundle="resources"/></label>
							<html:text name="CrearEdictoMisRedaccionesForm" property="centro" readonly="true"/>
						</div>	
						
						<div class="detalle"> 
					 		<label><bean:message key="datosedicto.tipoEdicto" bundle="resources"/></label>
							<html:text name="CrearEdictoMisRedaccionesForm" property="tipoEdicto" readonly="true"/>
						</div>						   	  		
			   	  		
			   	  		<div>
							<label>
								<bean:message key="datosedicto.fechaPublicacionPropuesta" bundle="resources" />
							</label>
							<br><html:text  style="width:30%;"
								name="CrearEdictoMisRedaccionesForm" property="fechaPublicacion" 
								styleId="i_date" readonly="true" />
							<html:image bundle="resources" altKey="seleciona.fecha"
								styleClass="input_img" titleKey="seleciona.fecha"
								src="${pageContext.request.contextPath}/images/calendar.gif"
								styleId="i_trigger" onclick="return false;"
								onmouseover="this.src='${pageContext.request.contextPath}/images/calendar_on.gif';"
								onmouseout="this.src='${pageContext.request.contextPath}/images/calendar.gif';" />
						</div>	
						
									<script type="text/javascript">

Calendar.setup( {
	inputField : "i_date",
	dateFormat : "%d/%m/%Y",
	showsTime : false,
	timeFormat : "24",
	trigger : "i_trigger",
	onSelect   : function() { this.hide() }
	
});
</script>
					
						
						<div class="detalle">
							<label><bean:message key="datosedicto.diasPublicados" bundle="resources"/></label>
							<html:text name="CrearEdictoMisRedaccionesForm" property="diasPublicados" styleId="objetoEdicto" readonly="true"  />
						</div>
						
						<div>
							<label>
								<bean:message key="datosedicto.fechaRetiradaPropuesta" bundle="resources" />
							</label>
							<html:text  style="width:30%;"
								name="CrearEdictoMisRedaccionesForm" property="fechaRetirada" 
								styleId="i_fecha" readonly="true" />
							<html:image bundle="resources" altKey="seleciona.fecha"
								styleClass="input_img" titleKey="seleciona.fecha"
								src="${pageContext.request.contextPath}/images/calendar.gif"
								styleId="trigger"
								onmouseover="this.src='${pageContext.request.contextPath}/images/calendar_on.gif';"
								onmouseout="this.src='${pageContext.request.contextPath}/images/calendar.gif';" />
						</div>	
						
						
						<script type="text/javascript">
												
							Calendar.setup({
								inputField     :    "i_fecha",
								ifFormat       :    "%d/%m/%Y",
								showsTime      :    false,
								timeFormat     :    "24",
								button         :    "trigger"
							});
												
						</script>	
						
					</fieldset>				
					
				<div class="hr">
					<hr />
				</div>
					
				<fieldset>
					<div class="botonera">
						<html:submit styleId="button" styleClass="button"><bean:message key="boton.publicarEdicto" bundle="resources"/></html:submit>
					</div>
				</fieldset>
			       		
			</html:form>
				

			<html:form action="/VisualizarMisRedaccionesFrontAction.do">
				<div align="center" class="msj-botonera">
					<html:submit><bean:message key="boton.volver" bundle="resources"/></html:submit>  
				</div>  
			</html:form> 

				
			</div>
			
			<div class="fondo-bottom"></div>
			
		</div>
		
	</div>
	
</body>



