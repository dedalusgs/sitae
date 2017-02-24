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


function ActualizaFechaPublicacion (input)
{
  //check to see if its in a correct format
  
  //var input=document.getElementById(inputId);
  var cadena=input.value;
  
  var objRegExp = /^\d{2}\/\d{2}\/\d{4}$/;

  if(!objRegExp.test(cadena)){
	  input.value="";
	  
    alert("El formato de fecha debe corresponderse con 'dd/mm/aaaa'. Por favor asegurese que es correcto"); 
    input.focus();
    return false;
  }
  else {
    //var strSeparator = cadena.substring(2,3)
    //create a lookup for months not equal to Feb.
    var arrayDate = cadena.split('/');

    var arrayLookup = { '01' : 31,'03' : 31,
      '04' : 30,'05' : 31,
      '06' : 30,'07' : 31,
      '08' : 31,'09' : 30,
      '10' : 31,'11' : 30,'12' : 31
    }

    var intDay = parseInt(arrayDate[0],10);
    var intMonth = parseInt(arrayDate[1],10);
    var intYear = parseInt(arrayDate[2],10);
    //check if month value and day value agree

    if (arrayLookup[arrayDate[1]] != null) {
      if (intDay <= arrayLookup[arrayDate[1]] && intDay != 0
        && intYear > 1975 && intYear < 2050)
        return true;     //found in lookup table, good date
    }

    //check for February (bugfix 20050322)
    //bugfix for parseInt kevin
    //bugfix biss year  O.Jp Voutat

    if (intMonth == 2) {
      var intYear = parseInt(arrayDate[2]);

      if (intDay > 0 && intDay < 29) {
        return true;
      }
      else if (intDay == 29) {
        if ((intYear % 4 == 0) && (intYear % 100 != 0) ||
            (intYear % 400 == 0)) {
          // year div by 4 and ((not div by 100) or div by 400) ->ok
          return true;
        }
      }
    }
    input.value="";
    alert("La fecha introducida no existe, por favor, introdúzcala de nuevo teniendo en cuenta que el formato de fecha debe ser 'dd/mm/aaaa'.");
    input.focus();
    return false;
  }

  
}



function GEdictoActualizadoFechaInicio(){
	
	var  diasInput=document.getElementById("diasPublicacion");
	var fechaInicioInput=document.getElementById("i_date");
	var fechaFinInput=document.getElementById("i_fecha");
	var form=document.CrearEdictoMisRedaccionesForm;
	if (form==null){
		form=document.ModificarMisRedaccionesForm;
	}
	if (form==null){
		form=document.CrearEdictoForm;
	}
	if (form==null){
		form=document.ModificarEdictoForm;
	}
	if (form==null){
		form=document.ActualizarEdictoPublicadoForm;
	}
	var tipoDiasInput=form.tipoPublicacion;
	var dias=diasInput.value;
	var formatoAdecuado=ActualizaFechaPublicacion(fechaInicioInput);
	var formatoDias=isNaN(dias);
	if (formatoDias==true){
		alert ("El campo 'número de Dias' debe se un número");
		return;
	}
	if(formatoAdecuado==true){
		var i;
		for (i=0;i<tipoDiasInput.length;i++){ 
	      	 if (tipoDiasInput[i].checked) 
	         	 break; 
	   	} 
		var tipoPub=tipoDiasInput[i].value;
		
		var fechaIni=fechaInicioInput.value;
		activarModal();
		AjaxSitae.calcularFechaFinPublicacion( fechaIni,  dias, tipoPub, actualizarFechaFin);
		
	}
}

function actualizarFechaFin(resultado){
	
	var fechaFinInput=document.getElementById("i_fecha");
	fechaFinInput.value=resultado;
	closeModal();
}

function GEdictoActualizadoFechaFin(){
	
	var  diasInput=document.getElementById("diasPublicacion");
	var fechaInicioInput=document.getElementById("i_date");
	var fechaFinInput=document.getElementById("i_fecha");
	var tipoDiasInput=document.CrearEdictoMisRedaccionesForm;
	var form=document.CrearEdictoMisRedaccionesForm;
	if (form==null){
		form=document.ModificarMisRedaccionesForm;
	}
	if (form==null){
		form=document.CrearEdictoForm;
	}
	if (form==null){
		form=document.ModificarEdictoForm;
	}
	if (form==null){
		form=document.ActualizarEdictoPublicadoForm;
	}
	
	var tipoDiasInput=form.tipoPublicacion;
	var dias=diasInput.value;
	var formatoAdecuado=ActualizaFechaPublicacion(fechaInicioInput);
	var formatoAdecuado=ActualizaFechaPublicacion(fechaFinInput);
	var formatoDias=isNaN(dias);
	if (formatoDias==true){
		alert ("El campo 'número de Dias' debe se un número");
		return;
	}
	if(formatoAdecuado==true){
		var i;
		for (i=0;i<tipoDiasInput.length;i++){ 
	      	 if (tipoDiasInput[i].checked) 
	         	 break; 
	   	} 
		var tipoPub=tipoDiasInput[i].value;
		
		var fechaIni=fechaInicioInput.value;
		var fechaFin=fechaFinInput.value;
		activarModal();
		AjaxSitae.calcularDiasPublicacion( fechaIni,  fechaFin, tipoPub, actualizarDiasExpo);
		
	}
}

function actualizarDiasExpo(resultado){
	
	var  diasInput=document.getElementById("diasPublicacion");
	diasInput.value=resultado;
	closeModal();
}

		