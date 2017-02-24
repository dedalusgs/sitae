package es.novasoft.sitae.perfiles.adminGlobal.modificarFestivo.actions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.comun.struts.ActionBase;
import es.novasoft.comun.utils.ResetForm;
import es.novasoft.sitae.business.objects.Festivo;
import es.novasoft.sitae.business.services.interfaz.FestivoService;
import es.novasoft.sitae.login.business.objects.UsuarioAutentificado;
import es.novasoft.sitae.perfiles.adminGlobal.modificarFestivo.forms.ModificarFestivoForm;

public class ModificarFestivoFrontAction extends ActionBase {

	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {
            
			if (isCancelled(request)) {
				// Elimina los forms anticuados
				ResetForm.removeBean(mapping, request);
				return forward(request, mapping, ActionBase.CANCEL_KEY);
			}
			
			FestivoService festivoService = (FestivoService) Factory
					.getBean(ServiceConstants.FESTIVO_SERVICIO_BEAN_NAME);

			UsuarioAutentificado ciudadano = null;

			
			ModificarFestivoForm formulario = (ModificarFestivoForm) form;

			if (request.getAttribute("numeroErrores") == null) {

				Festivo festivo = new Festivo();

				String idFestivo = (String) request
						.getParameter("idFestivoSeleccionado");

				if (idFestivo != null && !idFestivo.equals("")) {
					festivo = festivoService.findById(Integer.valueOf(idFestivo));
					formulario.setFestivo(festivo);
					Calendar fecha=new GregorianCalendar();
				    Integer Anio =(Integer)request.getSession().getAttribute("anio");
				   
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

					request.setAttribute("ModificarFestivoForm", formulario);
					
					
				}else {
					return forward(request, mapping, ActionBase.ERROR_KEY);
					
				}
				
				

			}

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error en ModificarFestivoFront", e);
			return forward(request, mapping, ActionBase.ERROR_KEY);
		}
		return forward(request, mapping, ActionBase.SUCCESS_KEY);
	}
}
