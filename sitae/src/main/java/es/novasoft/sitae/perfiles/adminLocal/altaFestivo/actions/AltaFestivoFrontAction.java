package es.novasoft.sitae.perfiles.adminLocal.altaFestivo.actions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.ResetForm;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminLocal.altaFestivo.forms.AltaFestivoForm;

public class AltaFestivoFrontAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {
			UsuarioAutentificado ciudadano = null;

			if (isCancelled(request)) {
				// Elimina los forms anticuados
				ResetForm.removeBean(mapping, request);
				return forward(request, mapping, ActionBase.CANCEL_KEY);
			}
			
			Calendar fecha=new GregorianCalendar();
		    
			Integer Anio =(Integer)request.getSession().getAttribute("anio");
		    AltaFestivoForm formulario=(AltaFestivoForm)form;
		    fecha.set(Calendar.YEAR,Anio);
		    fecha.set(Calendar.MONTH,Integer.parseInt(formulario.getMes()));
		    Integer cantidadDias=fecha.getActualMaximum(Calendar.DAY_OF_MONTH);
		       
		    ArrayList<LabelValueBean> listaDeDias=new ArrayList<LabelValueBean>();
		    LabelValueBean parAux = null;
		    for (int i = 1; i<=cantidadDias; i++){
		    	parAux=new LabelValueBean(Integer.toString(i),Integer.toString(i));
		    	listaDeDias.add(parAux);
		    }
		    formulario.setListaDeDias(listaDeDias);
		    request.setAttribute("AltaFestivoForm", formulario);
		    
			

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en AltaCentroFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);

	}

}
