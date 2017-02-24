<%@ page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<jsp:directive.page import="java.util.Locale"/>
<jsp:directive.page import="org.apache.struts.Globals"/>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%
	if (request.getSession()!=null){
		request.getSession().invalidate();					
	} 
 %>
<jsp:forward page="/InitDoAction.do" />

	

