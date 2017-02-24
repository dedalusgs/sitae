<%@ page contentType="text/html"
    pageEncoding="UTF-8" language="java"%>
    <%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
    <%@page import="es.novasoft.comun.constantes.Constantes"%>
    <div id="contenido-menu-principal">
		<ul>
			<li><a title='<bean:message key="portal.inicio" bundle="resources"/>' href="./InitDoAction.do?grupoNavegacion=-1&servicioNavegacion=-1"><bean:message key="portal.inicio" bundle="resources"/></a></li>
		</ul>
	</div>
				
   <ul class="menu-login">
                	<c:if test="${((LoginCertificadoForm==null) || LoginCertificadoForm.registrado==false)}">
                		<% String accesoNif = Constantes.getPropiedad("accesoNif");                		
                		if (accesoNif!=null && !accesoNif.equals("N")){ 
                		%>				                
	                    <li>
                    		<html:form action="/LoginCertificadoFront.do?grupoNavegacion=-1&servicioNavegacion=-1" method="post" enctype="multipart/form-data">                    									  					
								<span style="width:25px;float:left;color:white;" ><bean:message key="datosusuario.NIF" bundle="resources" /></span>				
			 					<input style="width:100px;" type="text" size="8" name="nif" value=""/>		 				 			 					
			 					<span style="width:5px;float:left;color:white;" ></span>
				 				<html:submit style="width:50px; height:20px! important;"><bean:message key="boton.entrar" bundle="resources"/></html:submit>			 							
		 					</html:form>
                    	</li>
                    	<% } %>
                    	<!--  
                    	<li>							
							<a  href="./LoginConCertificadoFront.do">
								<img title='<bean:message key="boton.certificado" bundle="resources" />' src="img/ico-restringido-usuario.gif" />
								<bean:message key="boton.certificado" bundle="resources" />
							</a>
						</li>
						 -->                   	              
                    </c:if>
                    <c:if test="${(LoginCertificadoForm.registrado==true)}">                    	
							<c:if test="${(LoginCertificadoForm.nombreUsuario!='') && (LoginCertificadoForm.nombreUsuario!=null)}">						 	
	                    		<li class="user" style="color:white;"><bean:write name="LoginCertificadoForm" property="nombreUsuario"  /></li>                    
	                    	</c:if>
	                    	<li><a title='<bean:message key="portal.salir" bundle="resources"/>' href="logout.jsp"><bean:message key="portal.salir" bundle="resources"/></a></li>	                    
                    </c:if>
   </ul>    
