<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<link href="css/estilos.css" rel="stylesheet" type="text/css"
	media="all" />

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>



		<title>SITAE Acceso Restringido</title>



		<script language="javascript" src="js/time.js"></script>
		<script language="javascript" src="js/deployJava.js"></script>
		<script language="javascript" src="js/instalador.js"></script>
		<script language="javascript" src="js/firma.js"></script>
		<script language="javascript" src="js/constantes.js"></script>
		<script type="text/javascript" language="javascript" src="js/deployJava.js"></script>	
		<script type="text/javascript" language="javascript">
		
	function firmarAF5(){
		cargarAppletFirma('COMPLETA');
		clienteFirma.initialize();
		clienteFirma.setData(document.formIndex.uuid.value);
	 	clienteFirma.setSignatureMode('EXPLICIT');
	 	clienteFirma.setSignatureFormat("XADES");
	 	clienteFirma.setShowHashMessage(false);
	 	clienteFirma.setCertFilter('{SUBJECT.DN#NOT_MATCHES#{".*(FIRMA).*"}}');

		firmar();
		var certB64 = clienteFirma.getSignCertificateBase64Encoded();
		
		if (certB64 == "" || certB64 == undefined) {
			document.formIndex.action='./ErrorAcceso.do';//OJO!!!
			document.formIndex.submit();
		} else {
			document.formIndex.fichero.value = clienteFirma.getSignatureBase64Encoded();
			document.formIndex.firma_ok.value = "1";
			document.formIndex.action = "./LoginConCertificadoDoAction.do"; //OJO!!!
			document.formIndex.submit();
		}	
	}	

	</script>


	</head>

	<body>
	

		<div>
			<form id="formulario" name="formIndex" method="post"
				style="color:#2A6632">
				<input type="text" id="uuid" name="uuid"
					style="visibility: hidden; display: none;"
					value="<%=request.getSession().getAttribute("loginUUID")%>">
				<input type="text" id="fichero" name="fichero"
					style="visibility: hidden; display: none;" value="">
				<input type="text" id="firma_ok" name="firma_ok"
					style="visibility: hidden; display: none;" value="0">
				<p id="aaa" style="display:none">
					<!--ACCESO_RESTRINGIDO-->
					Para el acceso a la información restringida, debe autenticarse
					firmando dicho acceso
				</p>
			</form>
		</div>

	<div id="contenido">
				<h2><bean:message key="login.usuario" bundle="resources" /></h2>
				<div class="mensaje">
					<img src="/sitae/img/loader.gif"/>
				</div>
				
		</div>
		

		<script type="text/javascript" language="javascript">
			firmarAF5();
		</script>



	</body>
</html>
