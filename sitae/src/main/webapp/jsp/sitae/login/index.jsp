<%@ page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<jsp:directive.page import="java.util.Locale"/>
<jsp:directive.page import="org.apache.struts.Globals"/>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  	<div class="menu">	  	 	
		<h2><bean:message key="comun.publico" bundle="resources" /></h2>		
		<html:form action="/InitDoAction" method="post">		
			<c:forEach var="organismo" items="${IndexForm.organismos}">
  				<li> 				      			
     				<a href="${organismo.urlIndexJSP}">${organismo.nombre}</a> 	
    			</li>
 			</c:forEach>	
	</html:form>	

</div>


	
			

