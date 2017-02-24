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



<!-- 		<script language="javascript" src="js/time.js"></script> -->
<!-- 		<script language="javascript" src="js/deployJava.js"></script> -->
<!-- 		<script language="javascript" src="js/instalador.js"></script> -->
<!-- 		<script language="javascript" src="js/firma.js"></script> -->
<!-- 		<script language="javascript" src="js/constantes.js"></script> -->
<!-- 		<script type="text/javascript" language="javascript" src="js/deployJava.js"></script>	 -->
		<script type="text/javascript" src="js/deployJava.js"></script>
		<script type="text/javascript" src="js/miniapplet.js"></script>
		<script type="text/javascript" language="javascript">
		
		
	function saveSignatureCallback(signatureB64) {
			// F


			document.formIndex.fichero.value = signatureB64;
			document.formIndex.firma_ok.value = "1";
			document.formIndex.action = "./LoginConCertificadoDoAction.do"; //OJO!!!
			document.formIndex.submit();
			
		}
		
		
	
		function doSign() {
			try {
				var data ="<xml>111111111</xml>";
				// document.images["img_afirma"].src = "<%=request.getContextPath()%>/images/ico32_ok.gif";
				MiniApplet.sign(
					data,
					"SHA512withRSA",
				    "XAdES",
					"",
					saveSignatureCallback);
			
			} catch(e) {
				try {
			    muestra_info_errores();
			    
				if (MiniApplet.getErrorType()=="es.gob.afirma.keystores.AOCertificatesNotFoundException"){
					alert(" No se han encontrado certificados instalados en el sistema");
					//muestra_info_errores();
					}else {
					alert("Error: " + MiniApplet.getErrorMessage());
						document.formIndex.action='./ErrorAcceso.do';//OJO!!!
						document.formIndex.submit();
						
					//alert("Se ha producido un error obteniendo su certificado en la operacion de autenticaci&oacuten Se le redirigirá hacia la página principal");
					//window.top.location.href="https://sede.huetorvega.es/huetor-vega/";
					
					}
					
				} catch(ex) {
					if (MiniApplet.getErrorType()=="es.gob.afirma.keystores.AOCertificatesNotFoundException"){
					alert(" No se han encontrado certificados instalados en el sistema");
					}else {
					
					alert("Error: " + MiniApplet.getErrorMessage());
					document.formIndex.action='./ErrorAcceso.do';//OJO!!!
						document.formIndex.submit();
					}
				}
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
					
				<h3> Atención, va a proceder a identificarse en el sistema.</h3>
				<p>Para poder identinficiarse en el sistema debe disponer de certificado digital correctamente instalado.</p>
				<p>Además debe de tener instalado en su sistema el software de Autofirma, el cual le permite utilizar su certificado electrónico</p>
				<p>Para obtener el Software de autofirma pulse <a  target ="_blank"href="http://firmaelectronica.gob.es/Home/Descargas.html">aquí</a></p>
				<p><a target ="_blank" href="http://firmaelectronica.gob.es/Home/Descargas.html" ><img src="./images/autofirma.png" style="width: 200px"/></a></p>
				<br/><br/>
				<p>Para iniciar la autentificación en el sistema pulse el siguiente botón</p>
				<div class="botonera">
					<input type="button" value="Iniciar Identificacion" onclick="cargar()" />
				</div>
				</div>
				
		</div>
		

		<script type="text/javascript" language="javascript">
			 function cargar(){
			 MiniApplet.cargarAppAfirma('./js');
			   doSign();
			   }
		</script>



	</body>
</html>
