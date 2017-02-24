<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'ayuda.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>

		<div id="cuerpo">

			<div id="contenido">
				<h2>
					AYUDA
				</h2>
				<h3>
					Guia de usuario
				</h3>
				<a name="indice"></a>
				<div class="content">
					<h5>
						El usuario final tiene la tiene siguiente funcionalidad:
					</h5>
					<br>
					<li>
						<ul style='margin-bottom: 1em'>
							·
							<a
								href="ServiciosPortalFrontAction.do?accion=ayuda&grupoNavegacion=-2&servicioNavegacion=-31#seccion1"><b>Consultar
									los edictos en vigor o publicados además de los últimos edictos
									publicados</b> </a>, pudiéndose descargar el edicto y el certificado de
							publicación del edicto.
						</ul>
						<ul style='margin-bottom: 1em'>
							·
							<a
								href="ServiciosPortalFrontAction.do?accion=ayuda&grupoNavegacion=-2&servicioNavegacion=-31#seccion2">
								<b>Consultar los edictos que están historificados</b> </a>,
							pudiéndose descargar el edicto y el certificado de diligencia del
							edicto.
						</ul>
						<ul style='margin-bottom: 1em'>
							·
							<a
								href="ServiciosPortalFrontAction.do?accion=ayuda&grupoNavegacion=-2&servicioNavegacion=-31#seccion3">
								<b>Realizar una búsqueda avanzada de los edictos publicados
									e historificados</b> </a>, pudiendo descargase el edicto, certificado
							de publicación del edicto y el certificado de diligencia del
							edicto.
						</ul>
					</li>

					<br />
					<br />
				</div>
				<a name="seccion1"></a>
				<div class="content">
					<h4>
						EDITOS EN VIGOR O PUBLICADOS Y ÚLTIMOS EDICTOS PUBLICADOS.
					</h4>
					<p>
						El usuario puede consultar los edictos en vigor o publicados
						además de los últimos edictos publicados mediante el siguiente
						listado.
					</p>
					<img width="600" src="images/ayuda1.PNG"></img>
					<br>
					<p>
						Los elementos que se muestran son los comunes y además se
						muestran:
					</p>
					<li>
						<ul style='margin-bottom: 1em'>
							· Icono
							<img src="img/ico-descarga-edicto.gif"></img>
							<span style='margin-left: 2em'> : Descargar PDF del Edicto
								asociado a la publicación de un Edicto. </span>
						</ul>
						<ul style='margin-bottom: 1em'>
							· Icono
							<img src="img/ico-descargar-publicacion.gif"></img>
							<span style='margin-left: 2em'> : Descargar PDF
								Certificado Publicación Edicto asociado a la publicación de un
								Edicto. </span>
						</ul>
						<ul style='margin-bottom: 1em'>
							El usuario podrá consultar el edicto del detalle seleccionado.
						</ul>
					</li>
					<img width="600" src="images/ayuda2.PNG"></img>
					<br />
					<p>
						Los elementos que se muestran son los comunes y además se
						muestran:
					<p>
					<li>
						<ul style='margin-bottom: 1em'>
							<b>Enlace Descarga Edicto: </b> Descargar PDF del Edicto asociado
							a la publicación de un Edicto.
						</ul>
						<ul style='margin-bottom: 1em'>
							<b>Enlace descargar Publicación Edicto: </b> Descargar PDF
							Certificado Publicación Edicto asociado a la Edictos en vigor.
						</ul>
					</li>
					<br />
					<a
						href="ServiciosPortalFrontAction.do?accion=ayuda&grupoNavegacion=-2&servicioNavegacion=-31#indice">
						<div class="botonera">
							<input type="submit" value="Subir" />
						</div> </a>

					<br />
				</div>
				<a name="seccion2"></a>
				<div class="content">
					<h4>
						HISTÓRICO DE EDICTOS.
					</h4>
					<p>
						El usuario puede consultar el histórico de edictos retirados
						mediante el siguiente listado.
					</p>
					<img width="600" src="images/ayuda3.PNG"></img>
					<br>
					<p>
						Los elementos que se muestran son los comunes y además se
						muestran:
					</p>
					<li>
						<ul style='margin-bottom: 1em'>
							· Icono
							<img src="img/ico-descarga-edicto.gif"></img>
							<span style='margin-left: 2em'> : Descargar PDF del Edicto
								asociado a la publicación de un Edicto. </span>
						</ul>
						<ul style='margin-bottom: 1em'>
							· Icono
							<img src="img/ico-descargar-diligencia.gif"></img>
							<span style='margin-left: 2em'> : Descargar PDF
								Certificado de diligencia de Edicto asociado a la retirada de un
								Edicto. </span>
						</ul>
						<ul style='margin-bottom: 1em'>
							El usuario podrá consultar el edicto del detalle seleccionado.
						</ul>
					</li>
					<img width="600" src="images/ayuda4.PNG"></img>
					<br />
					<p>
						Los elementos que se muestran son los comunes y además se
						muestran:
					<p>
					<li>
						<ul style='margin-bottom: 1em'>
							<b>Enlace Descarga Edicto: </b> Descargar PDF del Edicto asociado
							a la publicación de un Edicto.
						</ul>
						<ul style='margin-bottom: 1em'>
							<b>Enlace descargar Certificado de Diligencia del Edicto: </b>
							Descargar PDF Certificado de Diligencia del Edicto asociado a la
							Edictos en Retirada.
						</ul>
					</li>
					<br />
					<a
						href="ServiciosPortalFrontAction.do?accion=ayuda&grupoNavegacion=-2&servicioNavegacion=-31#indice">
						<div class="botonera">
							<input type="submit" value="Subir" />
						</div> </a>
					<br />
				</div>
				<a name="seccion3"></a>
				<div class="content">
					<h4>
						BÚSQUEDA AVANZADA
					</h4>
					<p>
						El usuario puede consultar los edictos publicados, como los
						edictos retirados mediante la siguiente búsqueda y listado de
						edictos.
					</p>
					<img width="600" src="images/ayuda5.PNG"></img>
					<br>
					<p>
						Los elementos que se muestran son los comunes y además se
						muestran:
					</p>
					<li>
						<ul style='margin-bottom: 1em'>
							· Icono
							<img src="img/ico-descarga-edicto.gif"></img>
							<span style='margin-left: 2em'> : Descargar PDF del Edicto
								asociado a la publicación de un Edicto. </span>
						</ul>
						<ul style='margin-bottom: 1em'>
							· Icono
							<img src="img/ico-descargar-publicacion.gif"></img>
							<span style='margin-left: 2em'> : Descargar PDF
								Certificado Publicación Edicto asociado a la publicación de un
								Edicto. </span>
						</ul>
						<ul style='margin-bottom: 1em'>
							· Icono
							<img src="img/ico-descargar-diligencia.gif"></img>
							<span style='margin-left: 2em'> : Descargar PDF
								Certificado de diligencia de Edicto asociado a la retirada de un
								Edicto. </span>
						</ul>
						<ul style='margin-bottom: 1em'>
							El usuario podrá consultar el edicto del detalle seleccionado.
						</ul>
					</li>
					<img width="600" src="images/ayuda6.PNG"></img>
					<br>
					<br />
					<p>
						Los elementos que se muestran son los comunes y además se
						muestran:
					<p>
					<li>
						<ul style='margin-bottom: 1em'>
							<b>Enlace Descarga Edicto: </b> Descargar PDF del Edicto asociado
							a la publicación de un Edicto.
						</ul>
						<ul style='margin-bottom: 1em'>
							<b>Enlace descargar Publicación Edicto: </b> Descargar PDF
							Certificado Publicación Edicto asociado a la Edictos en vigor.
						</ul>
						<ul style='margin-bottom: 1em'>
							<b>Enlace descargar Certificado de Diligencia del Edicto: </b>
							Descargar PDF Certificado de Diligencia del Edicto asociado a la
							Edictos en Retirada.
						</ul>
					</li>
					<br>
					<p>
						Estos enlaces se mostraran dependiendo del estado del edicto.
					</p>
					<br />
					<a
						href="ServiciosPortalFrontAction.do?accion=ayuda&grupoNavegacion=-2&servicioNavegacion=-31#indice">
						<div class="botonera">
							<input type="submit" value="Subir" />
						</div> </a>

					<br />
				</div>

			</div>
		</div>
	</body>
</html>
