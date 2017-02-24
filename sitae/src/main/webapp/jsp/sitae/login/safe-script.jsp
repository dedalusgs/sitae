<%@page import="es.novasoft.comun.constantes.Constantes"%>

<script type="text/javascript" src="<%= Constantes.getPropiedad("urlBaseApplet") %>/js/deployJava.js"></script>
<script type="text/javascript" src="<%= Constantes.getPropiedad("urlBaseApplet") %>/js/installer_aut_simple.js"></script>

<script type="text/javascript">	

	baseDownloadURL = "<%= Constantes.getPropiedad("urlBaseApplet") %>";

	
	function appletFinalizado(s, codigoError){
		 
		if(codigoError == 00){
			window.location.href="./EntrarConCertificadoDoAction.do?certificado=" + s;
		}
		else{
			window.location.href= "./ErrorAcceso.do";
		}
   
}	

</script>