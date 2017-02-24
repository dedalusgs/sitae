<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>

<script type="text/javascript">
  (function() {
    var po = document.createElement('script');
    po.type = 'text/javascript'; po.async = true;
    po.src = 'https://plus.google.com/js/client:plusone.js';
    var s = document.getElementsByTagName('script')[0];
    s.parentNode.insertBefore(po, s);
  })();
  </script>
  
  
<script type="text/javascript">
var helper = (function() {
  var authResult = undefined;

  return {
    /**
     * Hides the sign-in button and connects the server-side app after
     * the user successfully signs in.
     *
     * @param {Object} authResult An Object which contains the access token and
     *   other authentication information.
     */
    onSignInCallback: function(authResult) {
    	
    	
    		if (authResult['access_token']) {
	    		window.location.href = './GooglePlusCallbackAction.do?state=${state}&code='+authResult.code;
	    	}else if (authResult['error']){
	    		if (authResult['error']!= "immediate_failed") {
	    			window.location.href = './GooglePlusCallbackAction.do';
	    		}
	    	}
    	
    },
  };
})();



/**
 * Calls the helper method that handles the authentication flow.
 *
 * @param {Object} authResult An Object which contains the access token and
 *   other authentication information.
 */
function onSignInCallback(authResult) {
  helper.onSignInCallback(authResult);
}
</script>	

<script>
(function($){
    //  inspired by DISQUS
    $.oauthpopup = function(options)
    {
        if (!options || !options.path) {
            throw new Error("options.path must not be empty");
        }
        options = $.extend({
            windowName: 'ConexiónGooglePlus' // should not include space for IE
          , windowOptions: 'location=0,status=0,width=800,height=400'
          , callback: function(){ window.location.href='./ConfigurarGooglePlusFront.do?twitterOk=${twitterOk}'; }
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
					<legend><bean:message key="redesSociales.ConfigurarGoogle" bundle="resources"/></legend>
					<div><p><bean:message key="redesSociales.google.mensaje1" bundle="resources"/></p>
					<br/><p><bean:message key="redesSociales.google.mensaje2" bundle="resources"/></p>
					<br/>
					</div>		
					</fieldset></form>	
					
					<div style="float:right"><a id="clickme" href="#"><img style="width:200px;" src="./images/googleplus-button.jpg" /></a></div>
		    		

		    		<div style="clear:both"><br/><br/></div>  	
	  				
	  				
	  				<div class="botonera"><a href="VisualizarRedesFront.do"><bean:message key="boton.volver" bundle="resources"/></a></div>
	  			
	  			<iframe style="display:none" src="https://accounts.google.com/logout"></iframe>

					<script type="text/javascript">
	  			$('#clickme').oauthpopup({path:'${urlCallback}'});
			</script>
												

