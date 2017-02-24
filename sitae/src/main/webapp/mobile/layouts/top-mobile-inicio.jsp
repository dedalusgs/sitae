<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@page import="java.util.Locale"%>
<%@page import="org.apache.struts.Globals"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java"%>

<c:set var="nombre">${organismoSesion.nombre}</c:set>
<c:set var="titulo">Tablón de Anuncios Electrónicos</c:set>
<c:if test="${langu eq 'va' }">
	<c:set var="nombre">${organismoSesion.nombreVa}</c:set>
	<c:set var="titulo">Tauler d'Anuncis Electrònic</c:set>
	
</c:if>

<div data-role="header" class="jqm-header"  data-position="fixed">
				<h2> <span class="texto">${titulo}</span><br/> <span class="titulo">SITAE</span> </h2><h3>${nombre}</h3>
				
				<a href="#" id="jqm-navmenu-link" data-theme="b" class="jqm-navmenu-link ui-btn ui-btn-icon-notext ui-corner-all ui-icon-bars ui-nodisc-icon  ui-btn-left">Menu</a>
				<a href="#popupMenu" data-rel="popup" data-theme="b" data-transition="flip" class="jqm-search-link ui-btn ui-btn-icon-notext ui-corner-all ui-icon-comment ui-nodisc-icon  ui-btn-right">Idioma</a>
</div>