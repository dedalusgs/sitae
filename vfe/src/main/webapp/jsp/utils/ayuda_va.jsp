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
					AJUDA
				</h2>
				<h3>
					Guia d'usuari
				</h3>
				<a name="indice"></a>
				<div class="content">
					<h5>
						L'usuari final t� la t� funcionalitat seg�ent:
					</h5>
					<br>
					<li>
						<ul style='margin-bottom: 1em'>
							�
							<a
								href="ServiciosPortalFrontAction.do?accion=ayuda&grupoNavegacion=-2&servicioNavegacion=-31#seccion1"><b>Consultar
									els edictes en vigor o publicats a m�s dels �ltims edictes
									publicats</b> </a> , podent-se descarregar l'edicte i el certificat de
							publicaci� de l'edicte.
						</ul>
						<ul style='margin-bottom: 1em'>
							�
							<a
								href="ServiciosPortalFrontAction.do?accion=ayuda&grupoNavegacion=-2&servicioNavegacion=-31#seccion2">
								<b>Consultar els edictes que estan historificados</b> </a>,
							podent-se descarregar l'edicte i el certificat de dilig�ncia de
							l'edicte.
						</ul>
						<ul style='margin-bottom: 1em'>
							�
							<a
								href="ServiciosPortalFrontAction.do?accion=ayuda&grupoNavegacion=-2&servicioNavegacion=-31#seccion3">
								<b>Realitzar una busca avan�ada dels edictes publicats i
									historificados</b> </a>, podent descarregara l'edicte, certificat de
							publicaci� de l'edicte i el certificat de dilig�ncia de l'edicte
						</ul>
					</li>

					<br />
					<br />
				</div>
				<a name="seccion1"></a>
				<div class="content">
					<h4>
						EDETS EN VIGOR O PUBLICATS I �LTIMS EDICTES PUBLICATS.
					</h4>
					<p>
						L'usuari pot consultar els edictes en vigor o publicats a m�s dels
						�ltims edictes publicats per mitj� del seg�ent llistat.
					</p>
					<img width="600" src="images/ayuda1.PNG"></img>
					<br>
					<p>
						Els elements que es mostren s�n els comuns i a m�s es mostren:
					</p>
					<li>
						<ul style='margin-bottom: 1em'>
							� Icona
							<img src="img/ico-descarga-edicto.gif"></img>
							<span style='margin-left: 2em'> : Descarregar PDF de l'Edicte associat a la publicaci� d'un Edicte. </span>
						</ul>
						<ul style='margin-bottom: 1em'>
							� Icona
							<img src="img/ico-descargar-publicacion.gif"></img>
							<span style='margin-left: 2em'> : Descarregar PDF Certificat Publicaci� Edicte associat a la publicaci� d'un Edicte. </span>
						</ul>
						<ul style='margin-bottom: 1em'>
							L'usuari podr� consultar l'edicte del detall seleccionat.
						</ul>
					</li>
					<img width="600" src="images/ayuda2.PNG"></img>
					<br />
					<p>
						Els elements que es mostren s�n els comuns i a m�s es mostren:
					<p>
					<li>
						<ul style='margin-bottom: 1em'>
							<b>Enlla� Desc�rrega Edicte: </b> Descarregar PDF de l'Edicte associat a la publicaci� d'un Edicte.
						</ul>
						<ul style='margin-bottom: 1em'>
							<b>Enlla� descarregar Publicaci� Edicte: </b> Descarregar PDF Certificat Publicaci� Edicte associat a l'Edictes en vigor.
						</ul>
					</li>
					<br />
					<a
						href="ServiciosPortalFrontAction.do?accion=ayuda&grupoNavegacion=-2&servicioNavegacion=-31#indice">
						<div class="botonera">
							<input type="submit" value="Pujar" />
						</div> </a>

					<br />
				</div>
				<a name="seccion2"></a>
				<div class="content">
					<h4>
						HIST�RIC D'EDICTES.
					</h4>
					<p>
						L'usuari pot consultar l'hist�ric d'edictes retirats per mitj� del seg�ent llistat.
					</p>
					<img width="600" src="images/ayuda3.PNG"></img>
					<br>
					<p>
						Els elements que es mostren s�n els comuns i a m�s es mostren:
					</p>
					<li>
						<ul style='margin-bottom: 1em'>
							� Icona
							<img src="img/ico-descarga-edicto.gif"></img>
							<span style='margin-left: 2em'> : Descarregar PDF de l'Edicte associat a la publicaci� d'un Edicte. </span>
						</ul>
						<ul style='margin-bottom: 1em'>
							� Icona
							<img src="img/ico-descargar-diligencia.gif"></img>
							<span style='margin-left: 2em'> : Descarregar PDF Certificat de dilig�ncia d'Edicte associat a la retirada d'un Edicte </span>
						</ul>
						<ul style='margin-bottom: 1em'>
							L'usuari podr� consultar l'edicte del detall seleccionat.
						</ul>
					</li>
					<img width="600" src="images/ayuda4.PNG"></img>
					<br />
					<p>
						Els elements que es mostren s�n els comuns i a m�s es mostren:
					<p>
					<li>
						<ul style='margin-bottom: 1em'>
							<b>Enlla� Desc�rrega Edicte: </b> Descarregar PDF de l'Edicte associat a la publicaci� d'un Edicte.
						</ul>
						<ul style='margin-bottom: 1em'>
							<b>Enlla� descarregar Certificat de Dilig�ncia de l'Edicte: </b>
							Descarregar PDF Certificat de Dilig�ncia de l'Edicte associat a l'Edictes en Retirada.
						</ul>
					</li>
					<br />
					<a
						href="ServiciosPortalFrontAction.do?accion=ayuda&grupoNavegacion=-2&servicioNavegacion=-31#indice">
						<div class="botonera">
							<input type="submit" value="Pujar" />
						</div> </a>
					<br />
				</div>
				<a name="seccion3"></a>
				<div class="content">
					<h4>
						BUSCA AVAN�ADA
					</h4>
					<p>
						L'usuari pot consultar els edictes publicats, com els edictes retirats per mitj� de la seg�ent busca i llistat d'edictes.
					</p>
					<img width="600" src="images/ayuda5.PNG"></img>
					<br>
					<p>
						Els elements que es mostren s�n els comuns i a m�s es mostren:
					</p>
					<li>
						<ul style='margin-bottom: 1em'>
							� Icona
							<img src="img/ico-descarga-edicto.gif"></img>
							<span style='margin-left: 2em'> : Descarregar PDF de l'Edicte associat a la publicaci� d'un Edicte. </span>
						</ul>
						<ul style='margin-bottom: 1em'>
							� Icona
							<img src="img/ico-descargar-publicacion.gif"></img>
							<span style='margin-left: 2em'> : Descarregar PDF Certificat Publicaci� Edicte associat a l'Edictes en vigor. </span>
						</ul>
						<ul style='margin-bottom: 1em'>
							� Icona
							<img src="img/ico-descargar-diligencia.gif"></img>
							<span style='margin-left: 2em'> :
								Descarregar PDF Certificat de Dilig�ncia de l'Edicte associat a l'Edictes en Retirada. </span>
						</ul>
						<ul style='margin-bottom: 1em'>
							L'usuari podr� consultar l'edicte del detall seleccionat.
						</ul>
					</li>
					<img width="600" src="images/ayuda6.PNG"></img>
					<br>
					<br />
					<p>
						Els elements que es mostren s�n els comuns i a m�s es mostren:
					<p>
					<li>
						<ul style='margin-bottom: 1em'>
							<b>Enlla� Desc�rrega Edicte: </b> Descarregar PDF de l'Edicte associat a la publicaci� d'un Edicte.
						</ul>
						<ul style='margin-bottom: 1em'>
							<b>Enlla� descarregar Publicaci� Edicte: </b> Descarregar PDF Certificat Publicaci� Edicte associat a l'Edictes en vigor.
						</ul>
						<ul style='margin-bottom: 1em'>
							<b>Enlla� descarregar Certificat de Dilig�ncia de l'Edicte: </b>
							Descarregar PDF Certificat de Dilig�ncia de l'Edicte associat a l'Edictes en Retirada.
						</ul>
					</li>
					<br>
					<p>
						Estos enlla�os es mostraren depenent de l'estat de l'edicte.
					</p>
					<br />
					<a
						href="ServiciosPortalFrontAction.do?accion=ayuda&grupoNavegacion=-2&servicioNavegacion=-31#indice">
						<div class="botonera">
							<input type="submit" value="Pujar" />
						</div> </a>

					<br />
				</div>

			</div>
		</div>
	</body>
</html>
