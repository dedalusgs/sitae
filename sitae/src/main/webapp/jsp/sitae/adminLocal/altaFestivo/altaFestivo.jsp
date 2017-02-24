<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language='java' import='java.util.*,es.novasoft.sitae.perfiles.adminLocal.altaFestivo.forms.AltaFestivoForm,org.apache.struts.util.LabelValueBean' %>
<%

	
    
	Integer Anio =(Integer)session.getAttribute("anio");
   
    
    %>


<script type="text/javascript">
<!--

//-->

var anioValido=<%=Anio%>;



function recargarDias(){
	
	var selectMes=document.getElementById("mes");
	var selectDia=document.getElementById("dia");
	var indice = selectMes.selectedIndex; 
    var valor = selectMes.options[indice].value;
    var valormes=parseInt(valor)+1;
    var diasMes=new Date(anioValido || new Date().getFullYear(), valormes, 0).getDate();
    while (selectDia.length > 0) {
    	selectDia.remove(0);
    }
        
    for (i=diasMes;i>0;i--) { 
    	var option = document.createElement('option');
    	selectDia.options.add(option, 0);
    	selectDia.options[0].value = i;
    	selectDia.options[0].label = i;
    } 
    
}

</script>
	
		<h3><bean:message key="servicio.gestionFestivos" bundle="resources"/></h3>		 
			
			<html:form action="/AltaFestivoDo.do" method="post" enctype="multipart/form-data">			
				 
				<logic:messagesPresent>
			 		<div class="error">
			  			<html:errors/>
			 		</div>				 	
				</logic:messagesPresent>			    

			  	<fieldset>	
			  	
			  		<legend><bean:message key="festivo.tituloNuevo" bundle="resources"/></legend>					
					 	
					 	<div class="detalle"> 
					 	   <label><bean:message key="festivo.nombre" bundle="resources"/>(*)</label>
							<html:text name="AltaFestivoForm" property="nombre"/>
						 </div>
						 <div class="detalle"> 
					 	   <label><bean:message key="festivo.mes" bundle="resources"/>(*)</label>
							
							<html:select property="mes" styleId="mes" onchange="javascript:recargarDias();">
								    <html:option value="0"><bean:message key="mes.enero" bundle="resources"/></html:option>
								    <html:option value="1"><bean:message key="mes.febrero" bundle="resources"/></html:option>
								    <html:option value="2"><bean:message key="mes.marzo" bundle="resources"/></html:option>
								    <html:option value="3"><bean:message key="mes.abril" bundle="resources"/></html:option>
								    <html:option value="4"><bean:message key="mes.mayo" bundle="resources"/></html:option>
								    <html:option value="5"><bean:message key="mes.junio" bundle="resources"/></html:option>
								    <html:option value="6"><bean:message key="mes.julio" bundle="resources"/></html:option>
								    <html:option value="7"><bean:message key="mes.agosto" bundle="resources"/></html:option>
								    <html:option value="8"><bean:message key="mes.septiembre" bundle="resources"/></html:option>
								    <html:option value="9"><bean:message key="mes.octubre" bundle="resources"/></html:option>
								    <html:option value="10"><bean:message key="mes.noviembre" bundle="resources"/></html:option>
								    <html:option value="11"><bean:message key="mes.diciembre" bundle="resources"/></html:option>
							</html:select>
						 </div>
						 <div class="detalle"> 
					 	   <label><bean:message key="festivo.dia" bundle="resources"/>(*)</label>
							<html:select property="dia" styleId="dia" >
								<html:optionsCollection   property="listaDeDias" label="label" value="value"  />
								</html:select>
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
							<bean:message key="boton.guardar" bundle="resources"/>
						</html:submit>
				</div>				
			       		
				</html:form>
				

				<html:form action="/AltaFestivoFrontAction.do?volver=si">
				<div align="center" class="botonera border">
				<html:cancel >
				          <bean:message key="boton.volver" bundle="resources"/>
				</html:cancel>  
				 </div>
			
				</html:form> 
							
				
							
