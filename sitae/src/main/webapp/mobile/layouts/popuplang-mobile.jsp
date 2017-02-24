<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@page import="java.util.Locale"%>
<%@page import="org.apache.struts.Globals"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java"%>

<div data-role="popup" id="popupMenu" data-theme="a">
        <ul data-role="listview" data-inset="true" style="min-width:210px;">
            <li data-role="list-divider"><bean:message key="mobile.home.elija.idioma" bundle="resources"/></li>
            <li><a  data-transition="pop" data-inset="true" rel="external"  href="./CambiarLenguajeFrontAction.do?idioma=va"><bean:message key="lenguaje.va" bundle="resources"/></a></li>
            <li><a data-transition="pop"  rel="external" href="./CambiarLenguajeFrontAction.do?idioma=es" ><bean:message key="lenguaje.es" bundle="resources"/></a></li>
           
        </ul>
</div>