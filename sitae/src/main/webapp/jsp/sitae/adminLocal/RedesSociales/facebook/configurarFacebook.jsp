<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>
	

<script>
(function($){
    //  inspired by DISQUS
    $.oauthpopup = function(options)
    {
        if (!options || !options.path) {
            throw new Error("options.path must not be empty");
        }
        options = $.extend({
            windowName: 'ConexiónFacebook' // should not include space for IE
          , windowOptions: 'location=0,status=0,width=800,height=600'
          , callback: function(){ window.location.href='./CallBackFacebook.do?recarga=si'; }
        }, options);

        var oauthWindow   = window.open(options.path, options.windowName, options.windowOptions);
        var oauthInterval = window.setInterval(function(){
            if (oauthWindow.closed) {
                window.clearInterval(oauthInterval);
                options.callback();
            }
        }, 1000);
    };

    //bind to element and pop oauth when clicked
    $.fn.oauthpopup = function(options) {
        $this = $(this);
        $this.click($.oauthpopup.bind(this, options));
    };
    
    
})(jQuery);
</script>
	
								
					<h3><bean:message key="redesSociales.tituloGestion" bundle="resources"/></h3>
					<form><fieldset> 
					<legend><bean:message key="redesSociales.ConfigurarFacebook" bundle="resources"/></legend>
					<div><p><bean:message key="redesSociales.facebook.mensaje1" bundle="resources"/></p>
					<br/><p><bean:message key="redesSociales.facebook.mensaje2" bundle="resources"/></p>
					<br/><p><bean:message key="redesSociales.facebook.mensaje3" bundle="resources"/></p>
					</div>		
					</fieldset></form>	
					<div style="float:right"><a id="clickme" href="#"><img src="./images/FacebookButton.png" /></a></div>
		    		<div style="clear:both"><br/><br/></div>  	
	  				
	  				
	  				<div class="botonera"><a href="./VisualizarRedesFront.do"><bean:message key="boton.volver" bundle="resources"/></a></div>
	  			<script type="text/javascript">
	  			$('#clickme').oauthpopup({path:'${urlFacebook}'});
			</script>
					
												

