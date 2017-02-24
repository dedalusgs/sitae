<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@page import="java.util.Locale"%>
<%@page import="org.apache.struts.Globals"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java"%>

<c:set scope="request"  var="nombre">${organismoSesion.nombre}</c:set>
<c:set scope="request"  var="titulo">Tablón de Anuncios Electrónicos</c:set>
<c:if test="${langu eq 'va' }">
	<c:set scope="request"  var="nombre">${organismoSesion.nombreVa}</c:set>
	<c:set scope="request"  var="titulo">Tauler d'Anuncis Electrònic</c:set>
	
</c:if>

<div data-role="header" class="jqm-header"  data-position="fixed" >
				<h2> <span class="texto">${titulo}</span><br/> <span class="titulo">SITAE</span> </h2><h3>${nombre}</h3>
				<a href="#" id="jqm-navmenu-link" data-theme="b" class="jqm-navmenu-link ui-btn ui-btn-icon-notext ui-corner-all ui-icon-bars ui-nodisc-icon  ui-btn-left"></a>
				<a href="#" data-icon="back" data-theme="b" data-rel="back" title="Volver"  class="  ui-btn-right ui-btn ui-icon-back ui-btn-icon-notext ui-nodisc-icon ui-corner-all"></a>


	
</div>