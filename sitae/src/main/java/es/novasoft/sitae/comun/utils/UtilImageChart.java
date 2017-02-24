package es.novasoft.sitae.comun.utils;

import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.eastwood.ChartEngine;
import org.jfree.eastwood.Parameters;


import es.novasoft.comun.constantes.ServiceConstants;
import es.novasoft.comun.exceptions.ServiceException;
import es.novasoft.comun.factory.spring.Factory;
import es.novasoft.sitae.business.objects.Edicto;
import es.novasoft.sitae.business.objects.Organismo;
import es.novasoft.sitae.business.services.interfaz.EdictoService;
import es.novasoft.sitae.business.services.interfaz.OrganismoService;
import es.novasoft.sitae.business.services.interfaz.RelacionUsuOrgCentroPerfService;
import es.novasoft.sitae.business.services.interfaz.UsuarioService;

public class UtilImageChart {
	private static final Log log = LogFactory.getLog(UtilImageChart.class);
	
	private static final OrganismoService organismoService = (OrganismoService) Factory
			.getBean(ServiceConstants.ORGANISMO_SERVICIO_BEAN_NAME);
	
	private static final EdictoService edictoService = (EdictoService) Factory
			.getBean(ServiceConstants.EDICTO_BEAN_NAME);
	
	
	public static String generarURLEstadisticasPublicacion(String organismoString, String fechaInicio, String fechaFin, Boolean tituloBoolean) throws ServiceException, UnsupportedEncodingException{
		
		StringBuffer url=new StringBuffer("chart?chxl=0:|"); 
		
		try{
		if (organismoString !=null && organismoString.equals("")){
			
			String titulo="Estadísticas de Publicación. "+fechaInicio+" - "+fechaFin;
			Integer total=0;
			StringBuffer datos=new StringBuffer("&chd=t:");
			List listadoResultados= edictoService.contarEdictosOrganismosFechas(fechaInicio, fechaFin);		
			if (listadoResultados.size()>0){
				Long max=new Long(0);
				for(Iterator it= listadoResultados.iterator();it.hasNext();){
					   Object[] row = (Object[]) it.next();  
					 total=total+new Integer(row[1].toString()); 
					 url.append(java.net.URLEncoder.encode(row[0]+": "+row[1],"UTF-8"));
					 datos.insert(7,row[1]);
					 if (max<(Long)row[1]) max=(Long)row[1];
					if (it.hasNext()) {
								url.append("|");
								datos.insert(7,"|");
					}
				}
				//chds=0,<%=form.getMaxFrecuencia()%>&
				String tamanio="670x";
				if (((listadoResultados.size()* 40)+40)>530){
					tamanio+="530";
				}else{
					tamanio+=(listadoResultados.size()* 40)+40;
				}
				titulo=titulo+" \n Total Anuncios Publicados: "+total;
				if (tituloBoolean==false) titulo="Total Anuncios Publicados: "+total;
				 url.append("&chxs=0,000000,8,-1,l,000000&chxt=y&chbh=a,8&chs="+tamanio+"&cht=bhg&chco=80C65A,C6D9FD,224499,FF0000,A2C180,4D89D9&chds=0,"+max+"&chtt="+java.net.URLEncoder.encode(titulo, "UTF-8"));
				 url.append(datos);
			}else {
				url=new StringBuffer("NO");
			}

		
		}else {
			
			if (organismoString !=null && !organismoString.equals("")){
				Integer total=0;
				Organismo organismo=organismoService.findById(Integer.parseInt(organismoString));
				String titulo="Estadísticas de Publicación de "+organismo.getNombre()+". "+fechaInicio+" - "+fechaFin;
				StringBuffer datos=new StringBuffer("&chd=t:");
				List listadoResultados= edictoService.contarEdictosOrganismoFechas(organismo,fechaInicio, fechaFin);						
				if (listadoResultados.size()>0){
					Long max=new Long(0);
					for(Iterator it= listadoResultados.iterator();it.hasNext();){
						Object[] row = (Object[]) it.next();  					   
						url.append(java.net.URLEncoder.encode(row[0]+": "+row[1],"UTF-8"));
						datos.insert(7,row[1]);
						total=total+new Integer(row[1].toString()); 
						if (max<(Long)row[1]) max=(Long)row[1];
						if (it.hasNext()) {
									url.append("|");
									datos.insert(7,"|");
						}
					}
					//chds=0,<%=form.getMaxFrecuencia()%>&
					String tamanio="670x";
					if (((listadoResultados.size()* 40)+40)>530){
						tamanio+="530";
					}else{
						tamanio+=(listadoResultados.size()* 40)+40;
					}
					titulo=titulo+" \n Total Anuncios Publicados: "+total;
					if (tituloBoolean==false) titulo="Total Anuncios Publicados: "+total; 
					 url.append("&chxs=0,000000,8,-1,l,000000&chxt=y&chbh=a,8&chs="+tamanio+"&cht=bhg&chco=80C65A,C6D9FD,224499,FF0000,A2C180,4D89D9&chds=0,"+max+"&chtt="+java.net.URLEncoder.encode(titulo, "UTF-8"));
					 url.append(datos);
				}else {
					url=new StringBuffer("NO");
				}
				
			}
		}
		} catch (ServiceException e){
			
			log.error(e,e);
			throw e;
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			log.error(e,e);
			throw e;
		}
		
		return url.toString();
		
		
		
	}

	
	
public static String generarURLEstadisticasPublicacionOrgExter(String organismoString, String fechaInicio, String fechaFin, Boolean tituloBoolean) throws ServiceException, UnsupportedEncodingException{
		
		StringBuffer url=new StringBuffer("chart?chxl=0:|"); 
		
		try{
		if (organismoString !=null && organismoString.equals("")){
			
			String titulo="Estadísticas de Procedencia. "+fechaInicio+" - "+fechaFin;
			Integer total=0;
			StringBuffer datos=new StringBuffer("&chd=t:");
			List listadoResultados= edictoService.contarEdictosOrgExtOrganismosFechas(fechaInicio, fechaFin);		
			if (listadoResultados.size()>0){
				Long max=new Long(0);
				for(Iterator it= listadoResultados.iterator();it.hasNext();){
					 Object[] row = (Object[]) it.next();  
					 total=total+new Integer(row[0].toString()); 
					 url.append(java.net.URLEncoder.encode(row[1]+": "+row[0],"UTF-8"));
					 datos.insert(7,row[0]);
					 if (max<(Long)row[0]) max=(Long)row[0];
					if (it.hasNext()) {
								url.append("|");
								datos.insert(7,"|");
					}
				}
				//chds=0,<%=form.getMaxFrecuencia()%>&
				String tamanio="670x";
				if (((listadoResultados.size()* 40)+40)>530){
					tamanio+="530";
				}else{
					tamanio+=(listadoResultados.size()* 40)+40;
				}
				titulo=titulo+" \n Total Anuncios Publicados: "+total;
				if (tituloBoolean==false) titulo="Total Anuncios Publicados: "+total;
				 url.append("&chxs=0,000000,8,-1,l,000000&chxt=y&chbh=a,8&chs="+tamanio+"&cht=bhg&chco=224499,FF0000,A2C180,4D89D9,80C65A,C6D9FD&chds=0,"+max+"&chtt="+java.net.URLEncoder.encode(titulo, "UTF-8"));
				 url.append(datos);
			}else {
				url=new StringBuffer("NO");
			}

		
		}else {
			
			if (organismoString !=null && !organismoString.equals("")){
				Integer total=0;
				Organismo organismo=organismoService.findById(Integer.parseInt(organismoString));
				String titulo="Estadísticas de Procedencia de "+organismo.getNombre()+". "+fechaInicio+" - "+fechaFin;
				StringBuffer datos=new StringBuffer("&chd=t:");
				List listadoResultados= edictoService.contarEdictosOrgExtOrganismoFechas(organismo,fechaInicio, fechaFin);						
				if (listadoResultados.size()>0){
					Long max=new Long(0);
					for(Iterator it= listadoResultados.iterator();it.hasNext();){
						Object[] row = (Object[]) it.next();  					   
						url.append(java.net.URLEncoder.encode(row[1]+": "+row[0],"UTF-8"));
						datos.insert(7,row[0]);
						total=total+new Integer(row[0].toString()); 
						if (max<(Long)row[0]) max=(Long)row[0];
						if (it.hasNext()) {
									url.append("|");
									datos.insert(7,"|");
						}
					}
					//chds=0,<%=form.getMaxFrecuencia()%>&
					String tamanio="670x";
					if (((listadoResultados.size()* 40)+40)>530){
						tamanio+="530";
					}else{
						tamanio+=(listadoResultados.size()* 40)+40;
					}
					titulo=titulo+" \n Total Anuncios Publicados: "+total;
					if (tituloBoolean==false) titulo="Total Anuncios Publicados: "+total;
					 url.append("&chxs=0,000000,8,-1,l,000000&chxt=y&chbh=a,8&chs="+tamanio+"&cht=bhg&chco=224499,FF0000,A2C180,4D89D9,80C65A,C6D9FD&chds=0,"+max+"&chtt="+java.net.URLEncoder.encode(titulo, "UTF-8"));
					 url.append(datos);
				}else {
					url=new StringBuffer("NO");
				}
				
			}
		}
		} catch (ServiceException e){
			
			log.error(e,e);
			throw e;
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			log.error(e,e);
			throw e;
		}
		
		return url.toString();
		
		
		
	}

	
	
	
	
	    public static ByteArrayOutputStream generarImagen(String url) throws Exception{
		
		 ByteArrayOutputStream out = new ByteArrayOutputStream();
        Map params=null;
        URL uri=new URL("http://www.www.es/"+url);
       
    
		try {
			params = Parameters.parseQueryString( uri.getQuery());
		} catch (UnsupportedEncodingException e) {
			log.error(e,e);
			throw new Exception();
		}
        float fontSize = 12F;
        Font font = new Font("Dialog", 0, (int)fontSize);
    

        org.jfree.chart.JFreeChart chart = ChartEngine.buildChart(params, font);
        if(chart != null)
        {
            
            String size[] = (String[])(String[])params.get("chs");
            int dims[] = new int[2];
            if(size != null){
            	 int result[] = new int[2];
            	 int splitIndex = size[0].indexOf('x');
	            String xStr = size[0].substring(0, splitIndex);
	            String yStr = size[0].substring(splitIndex + 1);
	            int x = Integer.parseInt(xStr);
	            int y = Integer.parseInt(yStr);
	            if(x <= 1000 && y <= 1000 && x * y < 0x57e40)
	            {
	                dims[0] = x;
	                dims[1] = y;
	            } else
	            {
	                throw new Exception("Invalid chart dimensions: " + xStr + ", " + yStr);
	            }
            }
            else
                dims = (new int[] {
                    200, 125
                });
            ChartUtilities.writeChartAsPNG(out, chart, dims[0], dims[1]);
        }
        out.close();
        
        return out;
   
	}
	
	
	public UtilImageChart() {
			
		super ();
	
	}

}
