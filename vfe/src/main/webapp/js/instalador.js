/**
 * Depende de deployJava.js, de time.js y de constantes.js [opcional].
 *
 * Si se ha definido baseDownloadURL se usa como URL base para la descarga de los instalables.
 *
 * cargarAppletFirma(build, oldDeployment):
 *      Carga el applet de firma en la variable "clienteFirma". El applet no esta cargado hasta que clienteFirmaCargado= true.
 *      El metodo carga el Cliente via JNLP si esta soportado (Java 6u10 o superior) o si no, carga el Bootloader como applet,
 *      comprueba que el cliente este instalado y actualilzado y seguidamente lo carga. Si se indica como segundo parametro el
 *      valor true, el cliente se instalara siempre y se cargara desde un directorio local del usuario.
 *
 * cargarAppletInstalador():
 *      Carga el applet de instalacion (BootLoader) en la variable "instalador".
 *
 * instalar(build):
 *      Carga el applet instalador (si no se ha cargado), instala la construccion del cliente en local y devuelve el directorio de
 *      instalacion (null en caso contrario).
 *
 * actualizar():
 *      Carga el applet instalador (si no se ha cargado), actualiza la version instalada en local y devuelve true si el proceso
 *      finaliza correctamente (false si no).
 *
 * desinstalar():
 *      Carga el applet instalador (si no se ha cargado), desinstala el cliente de firma de local y devuelve true si el proceso
 *      finaliza correctamente (false si no).
 *
 * isInstalado(build):
 *      Carga el applet instalador (si no se ha cargado) y comprueba que este instalada la construccion indicada o una superior.
 *      Si no se indica ninguna se comprueba que este instalada la construccion basica del cliente. Devuelve true si la comprobacion
 *      fue positiva y false en caso contrario.
 *
 * isActualizado():
 *      Carga el applet instalador (si no se ha cargado) y devuelve true si el cliente de firma esta actualizado (coinciden las
 *      versiones local/remota) en local (false si no).
 *
 * getDirectorioInstalacion():
 *      Carga el applet instalador (si no se ha cargado) y devuelve la ruta de instalacion del cliente de firma en local.
 *
 * getVersion():
 *      Carga el applet instalador (si no se ha cargado) y devuelve la version del instalador.
 *
 * getVersionCliente():
 *      Carga el applet instalador (si no se ha cargado), comprueba que el cliente este instalado y si lo esta devuelve la version del cliente.
 *
 */
var instalador;
var instaladorCargado = false;
var clienteFirma;
var appletArq;

function cargarAppletFirma(build, oldDeployment)
{
	/* Definimos las contruccion que se va a utilizar */
	var confBuild = configureBuild(build);

	if (oldDeployment == "true") {
		oldDeployment = true;
	} else if (oldDeployment != true) {
		oldDeployment = false;
	}

	// Si no se ha pedido instalar, comprobamos si es necesario por estar ejecutandose
	// sobre una JVM de 64bits (debemos instalar SunMSCAPI)
	if(!oldDeployment) {
		if (appletArq == undefined)
		{
			cargarAppletArquitectura();
		}

		if (appletArq.isJRE64bits())
		{
			oldDeployment = true;
		}
	}


	/*
	 * Si se nos pide explicitamente el despliegue tradicional o tenemos una inferior a la JRE 1.6.0_u10, cargamos el
	 * Bootloader, instalamos, actualizamos y usamos el despliegue de Applet.
	 */
	if (oldDeployment || !deployJava.versionCheck("1.6.0_10+")) {
		configurarInstalador(confBuild, oldDeployment);
		if (!prepararInstalacion(confBuild, oldDeployment)) {
			return;
		}
	}

	/* Si ya se cargado, no continuamos con el proceso */
	if (clienteFirma != undefined) {
		return;
	}

	var attributes;
	var parameters;
	var version;

	

	/* Si no se nos pide explicitamente el despliegue tradicional y tenemos una JRE 1.6.0_u10 o superior, usamos el despliegue JNLP. */
	if (!oldDeployment && deployJava.versionCheck("1.6.0_10+")) {

   		attributes = {id:'firmaApplet',
		 		  width:1,
		 		  height:1
		};
		parameters = {jnlp_href:confBuild+'_afirma.jnlp',
		   		  userAgent:window.navigator.userAgent,
				  appName:window.navigator.appName,
				  showExpiratedCertificates:showExpiratedCertificates,
				  showMozillaSmartCardWarning:showMozillaSmartCardWarning,
				  java_arguments:'-Djnlp.packEnabled=true -Xms512M -Xms512M -Xmx512M'
		};
   		version = '1.6';

	} else {	/* Despliegue tradicional / Java 5 / Java 6 (64bits) */

		/* Definicion de las constantes necesarias */
		var installationDirectory = instalador.getInstallationDirectory();
		var jarArchive = 'file:///' + installationDirectory + '/afirma5_coreV3.jar';

		attributes = {id:'firmaApplet',
				  code:'es.gob.afirma.cliente.SignApplet.class',
				  archive:jarArchive,
				  width:1, height:1
		};
		parameters = {userAgent:window.navigator.userAgent,
				  appName:window.navigator.appName,
				  installDirectory:installDirectory,
				  showExpiratedCertificates:showExpiratedCertificates,
				  showMozillaSmartCardWarning:showMozillaSmartCardWarning,
				  java_arguments:'-Xmx512M'
		};
		version = '1.5';
	}

 	deployJava.runApplet(attributes, parameters, version);

	clienteFirma = document.getElementById("firmaApplet");

	/* Realizamos una espera para que de tiempo a cargarse el applet */
	for (var i = 0; i < 100; i++) {
		try {
			setTimeOut("clienteFirma != undefined && clienteFirma.isInitialized()", 100);
			break;
		} catch (e) {
			/*
			 * Capturamos la excepcion que se produciria si no se hubiese cargado aun el applet, aunque no se lanzaria
			 * una vez estuviese cargado aunque no iniciado
			 */
		}
	}
}

/*
 * Carga el cliente de firma.
 */
function configurarInstalador(confBuild, oldDeployment)
{
	// Comprobamos que el instalador esta cargado
	if(instalador == undefined)
	{
		cargarAppletInstalador();
	}
	
	// Esperamos a que el instalador se cargue
	if( instaladorCargado == false )
	{
		whenTry("instaladorCargado == true", "cargarAppletFirma('"+confBuild+"', " + oldDeployment + ")", "No se ha podido cargar el applet instalador");
		return;
	}
}

/*
 * Instala y actualiza el cliente de firma.
 */
function prepararInstalacion(confBuild, oldDeployment)
{
	var params = confBuild + "," + oldDeployment;

	/* Comprobamos que el applet de firma esta instalado */
	if( isInstalado(confBuild) == false )
	{
		instalar(confBuild, "cargarAppletFirma", params);
		return false;
	}
	else if( isActualizado() == false )
	{
		/*
		 * Le preguntamos al usuario si se desea actualizar y, en caso de que no actualice o se produzca un error,
		 * se indicara que se ejecutara la version ya instalada
		 */ 
		if( confirm("Se va a proceder a actualizar el cliente de firma. ¿Desea proceder?") )
		{
			instalador.actualizar("cargarAppletFirma", params);
			return false;
		}
		else
		{
			alert("Se ejecutar\u00E1 la versi\u00F3n instalada del Cliente @firma.");
		}
	}
	return true;
}

function cargarAppletInstalador()
{
	if(instalador == undefined)
	{
		/* Definicion de las constantes necesarias */
		var codeBaseVar = '.';
		if(base != undefined) {
			if(base.toLowerCase().substring(0, 7) != "file://" && 
					base.toLowerCase().substring(0, 7) != "http://" &&
					base.toLowerCase().substring(0, 8) != "https://") {
				codeBaseVar = './' + base;
			}
			else {
				codeBaseVar = base;
			}
		}

		var attributes = {id:'instaladorApplet',
					code:'es.gob.afirma.install.AfirmaBootLoader.class',	
					archive:codeBaseVar+'/afirmaBootLoader.jar',
					width:1, height:1};
		var parameters = {userAgent:window.navigator.userAgent,
					appName:window.navigator.appName,
					installDirectory:installDirectory,
					oldVersionsAction:oldVersionsAction};
		var version = '1.5';

		try {
			deployJava.runApplet(attributes, parameters, version);
		} catch(e) {}

		instalador = document.getElementById("instaladorApplet");
		
		/* Realizamos una espera para que de tiempo a cargarse el applet */
		whenTry("instalador.isIniciado() == true", "instaladorCargado = true");

		for(var i=0; i<100; i++) {
			try {
				setTimeOut("instalador != undefined && instalador.isIniciado()", 100);
				break;
			} catch(e) {
				// Capturamos la excepcion que se produciria si no se hubiese cargado aun el applet, aunque no se lanzaria
				// una vez estuviese cargado aunque no iniciado
			}
		}


		// Si hay definida una URL desde la que descargar los instalables, la establecemos
		if(baseDownloadURL != undefined) {
			if(baseDownloadURL.toLowerCase().substring(0, 7) != "file://" && 
					baseDownloadURL.toLowerCase().substring(0, 7) != "http://" &&
					baseDownloadURL.toLowerCase().substring(0, 8) != "https://") {

				var url = document.location.toString();
				instalador.setBaseDownloadURL(url.substring(0, url.lastIndexOf("/")) + '/' + baseDownloadURL);
			}
			else {
				instalador.setBaseDownloadURL(baseDownloadURL);
			}
		}
	}
}


function cargarAppletArquitectura()
{
	if(appletArq == undefined)
	{
		/* Definicion de las constantes necesarias */
		var codeBaseVar = '.';
		if(base != undefined) {
			if(base.toLowerCase().substring(0, 7) != "file://" && 
					base.toLowerCase().substring(0, 7) != "http://" &&
					base.toLowerCase().substring(0, 8) != "https://") {
				codeBaseVar = './' + base;
			}
			else {
				codeBaseVar = base;
			}
		}

		var attributes = {id:'arqApplet',
					code:'es.gob.afirma.deploy.util.JREArchDetector.class',	
					archive:codeBaseVar+'/archDetector.jar',
					width:1, height:1};
		var version = '1.5';

		try {
			deployJava.runApplet(attributes, null, version);
		} catch(e) {}

		appletArq = document.getElementById("arqApplet");
	}
}


function instalar(build, jsMethodName, jsMethodParams)
{

	// Definimos las contruccion que se va a utilizar
	var confBuild = configureBuild(build);

	if(instalador == undefined)
	{
		cargarAppletInstalador();
	}
	
	if(isInstalado(confBuild)) {
		alert("El cliente de @firma 5 ya est\u00E1 instalado");
		return true;
	}

	// Si se ha indicado una construccion de alguna manera (por defecto o por parametro), se instala esa
	var installDir;
	if(jsMethodName == undefined || jsMethodName == null)
	{
		installDir = instalador.instalar(confBuild);
	} else {
		if(jsMethodParams == undefined)
		{
			jsMethodParams = null;
		}

		installDir = instalador.instalar(confBuild, jsMethodName, jsMethodParams);
	}

	return installDir;
}

function actualizar(askConfirm)
{
	if(instalador == undefined)
	{
		cargarAppletInstalador();
	}
	
	if( askConfirm == true && !confirm("Se va a proceder a actualizar el cliente de firma. ¿Desea proceder?")) {
		return false;
	}

	return instalador.actualizar();
}

function desinstalar()
{
	if(instalador == undefined)
	{
		cargarAppletInstalador();
	}

	return instalador.desinstalar();
}

function isInstalado(build)
{
	if(instalador == undefined)
	{
		cargarAppletInstalador();
	}
	
	// Definimos las contruccion que se va a utilizar
	var confBuild = configureBuild(build);

	// Si se ha indicado una construccion de alguna manera (por defecto o por parametro), se comprueba esa

	return instalador.isInstalado(confBuild);
}

function isActualizado()
{
	if(instalador == undefined)
	{
		cargarAppletInstalador();
	}

	return instalador.isActualizado();
}

function getDirectorioInstalacion()
{
	if(instalador == undefined)
	{
		cargarAppletInstalador();
	}
	
	return instalador.getInstallationDirectory();
}

function getVersion()
{
	if(instalador == undefined)
	{
		cargarAppletInstalador();
	}
	
	return instalador.getVersion();
}

function getVersionCliente()
{
	if(instalador == undefined)
	{
		cargarAppletInstalador();
	}
	
	return instalador.getClientVersion();
}

/**
 * Si no se ha indicado una construccion por parametro, ni hay establecida una por defecto en "constantes.js", se instala la 'LITE'
 */
function configureBuild(build)
{
	var confBuild = null;
	if(build != null && build != undefined)
	{
		confBuild = build;
	}
	else if(defaultBuild != null && defaultBuild != undefined) {
		confBuild = defaultBuild;
	}
	else {
		confBuild = 'LITE';
	}
	return confBuild;
}
