<%@ page contentType="text/html" pageEncoding="UTF-8"
	language="java"%>
<jsp:directive.page import="org.apache.axis.encoding.Base64" />
<jsp:directive.page import="java.util.UUID" />
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.Locale, org.apache.struts.Globals"%>
<%@page import="es.novasoft.comun.utils.OrganismoVisualizar"%>


<% Locale locale = (Locale)session.getAttribute(Globals.LOCALE_KEY); 
	request.setAttribute("langu",locale.getLanguage());

%>


<!DOCTYPE html>


<html:html xhtml="true" >
<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<c:if test="${MuestraInformacionEdictoPublicoForm!=null}">

<!-- FACEBOOK -->
<meta content='article' property='og:type'/>
<meta content='${organismoSesion.dominio}' property='og:site_name'/>
<meta content='${MuestraInformacionEdictoPublicoForm.edicto.titulo}' property='og:title'/>
<!-- <meta expr:content='data:post.url' property='og:url'/>-->
<meta content='${organismoSesion.url}${organismoSesion.imagen}' property='og:image'/>
<meta content='${MuestraInformacionEdictoPublicoForm.edicto.descripcion}' property='og:description'/>

<!-- TWITTER CARDS -->
<meta content='summary' name='twitter:card'/>
<meta content='@${organismoSesion.twitter.urlUser}' name='twitter:site'/>
<meta content='@${organismoSesion.twitter.urlUser}' name='twitter:creator'/>
<meta content='https://${organismoSesion.dominio}' name='twitter:domain'/>
<meta content='${organismoSesion.url}/MuestraInformacionEdictoPublicoFrontAction.do?accion=busquedaAvanzada&grupoNavegacion=0&servicioNavegacion=-4&idEdictoSeleccionado=${MuestraInformacionEdictoPublicoForm.edicto.idEdicto}' name='twitter:url'/>
<meta content='${MuestraInformacionEdictoPublicoForm.edicto.titulo}' name='twitter:title'/>
<meta content='${MuestraInformacionEdictoPublicoForm.edicto.descripcion}' name='twitter:description'/>


</c:if>
		<% OrganismoVisualizar organismoVisualizar = (OrganismoVisualizar)session.getAttribute("organismoSesion");  %>
	<%if(organismoVisualizar != null){%>
		
		<link href="css/<%=organismoVisualizar.getTema() %>/color.css" rel="stylesheet" type="text/css" media="screen" />
	<%}else{%>
		<link href="css/verde/color.css" rel="stylesheet" type="text/css" media="screen" />
	<%}%>	
	<c:set var="tema" value="verde"/>
	<c:if test="${not empty organismoSesion}">
		<c:set var="tema" value="${organismoSesion.tema}" />
	
	</c:if>
	
		<title>SITAE - <bean:message key="mobile.home.nombretablon" bundle="resources"/></title>
		<link rel="stylesheet" href="jquerymob/themes/sitae-${tema}.css" />
		<link rel="stylesheet" href="jquerymob/themes/jquery.mobile.icons.min.css" />
		<link rel="stylesheet" href="jquerymob/themes/custom-${tema}.css" />
		<link rel="stylesheet" href="jquerymob/themes/custom.css" />
		<link rel="stylesheet" href="jquerymob/jquery.mobile.structure-1.4.0.min.css" />
		<script src="jquerymob/jquery-1.10.2.min.js"></script>
		<script src="jquerymob/jquery.mobile-1.4.0.min.js"></script>
		 <script src="jquerymob/ui/jquery.ui.datepicker.js"></script>
		<link rel="stylesheet" href="jquerymob/jquery.mobile.datepicker.css" />
		<script src="./jquerymob/jquery.mobile.datepicker.js"></script>
		
		<script>
  $(function() {
    
 //Array para dar formato en español
  $.datepicker.regional['es'] = 
  {
  closeText: 'Cerrar', 
  prevText: 'Previo', 
  nextText: 'Próximo',
  
  monthNames: ['Enero','Febrero','Marzo','Abril','Mayo','Junio',
  'Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
  monthNamesShort: ['Ene','Feb','Mar','Abr','May','Jun',
  'Jul','Ago','Sep','Oct','Nov','Dic'],
  monthStatus: 'Ver otro mes', yearStatus: 'Ver otro año',
  dayNames: ['Domingo','Lunes','Martes','Miércoles','Jueves','Viernes','Sábado'],
  dayNamesShort: ['Dom','Lun','Mar','Mie','Jue','Vie','Sáb'],
  dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sa'],
  dateFormat: 'dd/mm/yy', firstDay: 1, 
  initStatus: 'Selecciona la fecha', isRTL: false};
 $.datepicker.setDefaults($.datepicker.regional['es']);
 
 
   
  });
  </script>
 
				<!--Start Cookie Script-->
	<script type="text/javascript" src="../js/jquery.cookie.js"></script>
<script type="text/javascript" src="../js/jquery.cookiecuttr.js"></script>
<link href="../js/cookiecuttr.css" rel="stylesheet" type="text/css"/>
		<script type="text/javascript">
		
		$(document).ready(function(){
			$.mobile.pageLoadErrorMessage = '<bean:message key="mobile.home.paginaNoExiste" bundle="resources"/>';
			$.mobile.fixedToolbars.show(true);
			$.mobile.defaultDialogTransition='slideup';
			$.mobile.defaultPageTransition='flip';
// 			$.datepicker.formatDate( "DD/MM/yyyy", new Date(), {
// 				  dayNamesShort: $.datepicker.regional[ "es" ].dayNamesShort,
// 				  dayNames: $.datepicker.regional[ "es" ].dayNames,
// 				  monthNamesShort: $.datepicker.regional[ "es" ].monthNamesShort,
// 				  monthNames: $.datepicker.regional[ "es" ].monthNames
// 				});
			$("#mostrar").click(function(e){
			    $.mobile.loadingMessage = "<bean:message key="mobile.home.cargando" bundle="resources"/>";
			$.mobile.showPageLoadingMsg('');
			});

			$("#ocultar").click(function(e){
			$.mobile.hidePageLoadingMsg();
			});
			});
		$( document ).on( "pagecreate", ".jqm-demos", function( event ) {
			var search,
				page = $( this ),
				that = this,
				searchUrl = ( $( this ).hasClass( "jqm-home" ) ) ? "_search/" : "../_search/",
				searchContents = $( ".jqm-search ul.jqm-list" ).find( "li:not(.ui-collapsible)" ),
				version = $.mobile.version || "dev",
				words = version.split( "-" ),
				ver = words[0],
				str = words[1] || "",
				text = ver;

// 			
// 			// Global navmenu panel
			$( ".jqm-navmenu-panel ul" ).listview();

			$( document ).on( "panelopen", ".jqm-search-panel", function() {
				$( this ).find( "input" ).focus();
			})

			$( ".jqm-navmenu-link" ).on( "click", function() {
				page.find( ".jqm-navmenu-panel:not(.jqm-panel-page-nav)" ).panel( "open" );
			});

		if(jQuery.cookie("cc_cookie_accept") == "cc_cookie_accept") {
//Código que no queremos que cargue hasta que el usuario acepte. Aquí pondríamos el código de Google Analytics o lo que nos interese.
}

    jQuery.cookieCuttr({
      cookieDeclineButton: false,
      cookiePolicyLink: true,
      cookieAnalyticsMessage: "Este sitio web utiliza cookies para que usted tenga la mejor experiencia de usuario. Si continúa navegando está dando su consentimiento para la aceptación de las mencionadas cookies y la aceptación de nuestra política de cookies.",
      cookieAcceptButtonText: "De acuerdo",
      cookieDeclineButtonText: "No acepto",
      cookieWhatAreLinkText: "Más información",
      cookieWhatAreTheyLink: "./MobileServiciosPortalFrontAction.do?accion=avisoLegal"
    });

		});
		
		</script>
	
	
	
<!--End Cookie Script-->
	</head>

<c:set var="opcionMobile" scope="request"><tiles:getAsString name="menu"/></c:set>
<body>
<div data-role="page" class="jqm-demos jqm-home">
		<tiles:insert name="top"/>
			
			<div role="main" class="ui-content jqm-content">
				<div class="redesSociales">
			<a href="../AltaSuscripcionFront.do?grupoNavegacion=5&servicioNavegacion=-5" target="_blank" title="<bean:message key="redesSociales.listacorreo.siga" bundle="resources"/>"><img src="../images/email-32.png" ></img></a>
			<c:if test="${not empty organismoSesion.facebook}" >
					<a href="${organismoSesion.facebook.urlUser}"  target="_blank" title="<bean:message key="redesSociales.facebook.siga" bundle="resources"/>"><img src="imagenes/facebook-32.png" ></img></a>
			</c:if>
			<c:if test="${not empty organismoSesion.twitter}" >
				<a href="https://twitter.com/${organismoSesion.twitter.urlUser}" target="_blank" title="<bean:message key="redesSociales.twitter.siga" bundle="resources"/>"><img src="imagenes/twitter-32.png" ></img></a>
			</c:if>
			<c:if test="${not empty organismoSesion.google}" >
				<a href="${organismoSesion.google.urlUser}" target="_blank" title="<bean:message key="redesSociales.google.siga" bundle="resources"/>"><img src="imagenes/google+-32.png" ></img></a>
			</c:if>
			
			
			</div>	
				
					<tiles:insert name="cuerpo"/>
					
				
				
			</div>
				<tiles:insert name="menu2"/>
				<tiles:insert name="footer"/>
				<tiles:insert name="popuplang"/>
</div>
</body>
</html:html>

				

