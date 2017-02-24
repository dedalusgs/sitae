<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<html:html xhtml="true">	
	<head>		 
	<!--[if IE 6]>
        <link rel="stylesheet" type="text/css" href="css/ie6_only.css" />
        <link href="css/IE6.css" rel="stylesheet" type="text/css" />
    <![endif]-->
    <!--[if IE 7]>
        <link rel="stylesheet" type="text/css" href="css/ie7_only.css" />
        <link href="css/IE7.css" rel="stylesheet" type="text/css" />
    <![endif]-->
    <!--[if IE 8]>
        <link href="css/IE8.css" rel="stylesheet" type="text/css" />
    <![endif]-->   		   		   	    
    <link href="css/estilos.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="css/verde/color.css" rel="stylesheet" type="text/css" media="screen" />
	</head>
		 <body style="text-align:center;">
		 	<div style="width: 700px;">				
				<div class="error">
					<p><bean:message key="resultado.errorBBDD" bundle="resources"/></p>
				</div>					  																			  								
			</div>
		</body>
							
</html:html>
