<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>
	
<script type="text/javascript">
		function confirmarBorrado(mensaje){
		if(confirm(mensaje)){
  			return true;
    	}else{
  			return false;
   		}
	}				
</script>

						<h3><bean:message key="servicio.gestionOrganismosExternos" bundle="resources"/></h3>			
		
						<h3><bean:message key="visualizarListaOrganismosExternos.titulo" bundle="resources"/></h3>
												
	  					 <display:table export="true"name="${VisualizarOrganismoExternoForm.nuevalistaOrganismos}"  id="nuevalistaOrganismos" pagesize="10" sort="list"
	  					 requestURI="./VisualizarOrganismoExternoFrontAction.do">
						
							<c:set var="cifProperty"><bean:message key="cabecera.cif" bundle="resources" /></c:set>
								   
							<display:column class="listado_representantes" headerClass="cabecera_tabla ancho-20" property="cif" title="${cifProperty}"/>		   
   
   							<c:set var="organismoProperty"><bean:message key="cabecera.organismo" bundle="resources" /></c:set>
    						
    						<display:column class="listado_representantes" headerClass="cabecera_tabla" property="nombre" title="${organismoProperty}"/>
						
							<c:set var="modificarOrganismoProperty"><bean:message key="boton.modificarOrganismo" bundle="resources" /></c:set>
						
							<display:column media="html" class="listado_representantes" headerClass="cabecera_tabla ancho-20">
								
								<center>
									<html:link action="/ModificarOrganismoExternoFrontAction.do" paramId="idOrganismoSelecionado" paramName="nuevalistaOrganismos" paramProperty="idOrg">			
										<img title="${modificarOrganismoProperty} " src="${pageContext.request.contextPath}/img/ico16-editar.gif" alt="${modificarOrganismoProperty} "/>
									</html:link>
								</center>							
								
							</display:column>
							
							<c:set var="eliminarOrganismoProperty"><bean:message key="boton.eliminarOrganismo" bundle="resources" /></c:set>
							<c:set var="eliminarOrganismoConfirmacionProperty"><bean:message key="boton.eliminarOrganismoConfirmacion" bundle="resources" /></c:set>
							
							<display:column media="html" class="listado_expedientes" headerClass="cabecera_tabla ancho-20">					
								
								<center>
									<html:link action="/BajaOrganismoExternoDo.do" paramId="idOrganismoSelecionado" paramName="nuevalistaOrganismos" paramProperty="idOrg">
										<img title="${eliminarOrganismoProperty}" onclick="return confirmarBorrado('${eliminarOrganismoConfirmacionProperty}');"
											  src="${pageContext.request.contextPath}/img/ico16-borrar.gif"
											  alt="${eliminarOrganismoProperty}"/>	
									</html:link>
								</center>
								
							</display:column>
							
							<c:set var="verInformacionOrganismoProperty"><bean:message key="boton.verInformacionOrganismo" bundle="resources" /></c:set>							
							
							<display:column media="html" class="listado_expedientes" headerClass="cabecera_tabla ancho-20">					
								
									<center>
										<html:link action="/MuestraInformacionOrganismoExternoFrontAction.do" paramId="idOrganismoSelecionado" paramName="nuevalistaOrganismos" paramProperty="idOrg">
											<img title="${verInformacionOrganismoProperty}" src="${pageContext.request.contextPath}/img/ico16-buscar.gif" alt="${verInformacionOrganismoProperty}"/>	
										</html:link>
									</center>
								
							</display:column>

						 </display:table>
					<br/>	 	  					  				
	  				<html:form action="/AltaOrganismoExternoFrontAction.do" method="post" enctype="multipart/form-data">
				
						<div class="botonera">						
							<html:submit><bean:message key="boton.nuevoOrganismo" bundle="resources"/></html:submit>
						</div>
					
					</html:form>															
	  		  	 					
		 
		

