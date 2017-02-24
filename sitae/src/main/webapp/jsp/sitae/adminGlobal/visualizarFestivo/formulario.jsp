<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>
<%@page import="java.util.* ,es.novasoft.sitae.perfiles.adminLocal.visualizarFestivo.forms.VisualizarFestivoForm" %>
	<link type="text/css" rel="stylesheet" href="js/modal.css" />


<%

Calendar fechaActual= new GregorianCalendar();

Integer anioActual= fechaActual.get(Calendar.YEAR);

request.setAttribute("anioActual", anioActual);


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
		
		function confirmarcopia(mensaje){
			if(confirm(mensaje)){
	  			return true;
	    	}else{
	  			return false;
	   		}
		}
		
		function enviar(){
			formulario=document.getElementById("formularioAnio");
			activarModal();
			formulario.submit();
		}
				
	</script>

										
							
		    			  <html:form action="/VisualizarFestivoGlobFrontAction.do?actualizaAnio=si" method="post" enctype="multipart/form-data" styleId="formularioAnio">
								<fieldset>
										<legend>
											<bean:message key="festivo.anioActivo" bundle="resources" />
										</legend>
								
										<div class="detalle">
										<html:select property="anio" onchange="javascript:enviar();">
								
													<html:optionsCollection property="listadoAnios"
														label="label" value="value" />
										</html:select>
												
										
										</div>

						</fieldset>
								
								</html:form>
		    			  <h3><bean:message key="festivos.tituloFestivosNacionales" bundle="resources"/></h3>	
		    			   <html:form action="/AltaFestivoGlobFrontAction.do" method="post" enctype="multipart/form-data">   	
		    			 <logic:notEmpty name="VisualizarFestivoForm" property="diasFestivosNacionales" >	
		    				  	
	  					 <display:table export="true" name="${VisualizarFestivoForm.diasFestivosNacionales}"  id="diasFestivosNacionales" pagesize="10" sort="list"
	  					 requestURI="./VisualizarFestivoGlobFrontAction.do">
	  					 
							<c:set var="nombreProperty"><bean:message key="cabecera.nombre" bundle="resources" /></c:set>
							
							<c:set var="fechaProperty"><bean:message key="cabecera.fecha" bundle="resources" /></c:set>
							
							
							<display:column class="listado_representantes" headerClass="cabecera_tabla" property="fechaString" title="${fechaProperty}"/>		   
    						<display:column class="cabecera_tabla ancho-600" headerClass="cabecera_tabla ancho-600" property="nombre" title="${nombreProperty}"/>    												
							
							<c:if test="${VisualizarFestivoForm.anio >= anioActual}" >
							<c:set var="modificarFestivoProperty"><bean:message key="boton.modificarFestivo" bundle="resources" /></c:set>
						
							<display:column media="html" class="listado_representantes" headerClass="cabecera_tabla ancho-20">
								
								<center>
									<html:link action="/ModificarFestivoGlobFrontAction.do" paramId="idFestivoSeleccionado" paramName="diasFestivosNacionales" paramProperty="id">			
										<img title="${modificarFestivoProperty}" src="${pageContext.request.contextPath}/img/ico16-editar.gif" alt="${modificarFestivoProperty}"/>
									</html:link>
								</center>							
								
							</display:column>
							
							<c:set var="eliminarFestivoProperty"><bean:message key="boton.eliminarFestivo" bundle="resources" /></c:set>
							<c:set var="eliminarFestivoConfirmacionProperty"><bean:message key="boton.eliminarFestivoConfirmacion" bundle="resources" /></c:set>
							<display:column media="html" class="listado_expedientes" headerClass="cabecera_tabla ancho-20">					
								
								<center>
									<html:link action="/EliminarFestivoGlobDo.do" paramId="idFestivoSeleccionado" paramName="diasFestivosNacionales" paramProperty="id">
										<img title="${eliminarFestivoProperty}" onclick="return confirmarBorrado('${eliminarFestivoConfirmacionProperty}');"
											  src="${pageContext.request.contextPath}/img/ico16-borrar.gif"
											  alt="${eliminarFestivoProperty}"/>	
									</html:link>
								</center>
								
							</display:column>
							</c:if>
							
	

						 </display:table>
						 </logic:notEmpty>
						 
						 <logic:empty name="VisualizarFestivoForm" property="diasFestivosNacionales"> 				
	  						<span class="bold"><bean:message key="festivos.listadoFestivo" bundle="resources"/></span>	  				
									
	  					
	  					</logic:empty>	
	  				<br/>
	  				
	  				<c:if test="${VisualizarFestivoForm.anio >= anioActual}" >
	  				
	  				
				
						<div class="botonera">						
							<html:submit><bean:message key="boton.nuevoFestivo" bundle="resources"/></html:submit>
						</div>
					</c:if>
					</html:form>
					<c:if test="${VisualizarFestivoForm.anio >= anioActual}" >	
					<logic:empty name="VisualizarFestivoForm" property="diasFestivosNacionales"> 				
	  						 
	  						 <c:set var="copiarFestivoConfirmacionProperty"><bean:message key="festivo.confirmarCopia" bundle="resources" /></c:set>
	  						  <span class="bold"><bean:message key="festivos.copiarFestivo" bundle="resources"/></span>	  				
							
							<html:form action="/CopiarFestivoGlobDoAction.do" method="post" enctype="multipart/form-data">
				
							<div class="botonera">						
								<html:submit onclick="return confirmarBorrado('${copiarFestivoConfirmacionProperty}');"><bean:message key="boton.copiarFestivos" bundle="resources"/></html:submit>
							</div>
					
						</html:form>	
							    
							<div></div>
						 					
	  					
	  					</logic:empty>	
	  					</c:if>
	
