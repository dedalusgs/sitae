/*
 * Utilidades comunes a toda la aplicación 
 */
 
/*
* Metodo para comprobar la extension de un fichero, se utiliza principalmente en los upload de los fichero
* en el evento onchange.
*/

function comprobarExtensionFichero(elem, mensaje1, mensaje2) {
						
	        var filePath = elem.value;
	
	        if(filePath.indexOf('.') == -1)
	            return false;
	        
	        var validExtensions = new Array();
	        var ext = filePath.substring(filePath.lastIndexOf('.') + 1).toLowerCase();
	            
	        validExtensions[10] = 'pdf';
	    
	        for(var i = 0; i < validExtensions.length; i++) {
	            if(ext == validExtensions[i])
	                return true;
	        }	        	       
	        alert(mensaje1 + ' ' + ext.toUpperCase() + ' '+ mensaje2);        
   		return false;
 }