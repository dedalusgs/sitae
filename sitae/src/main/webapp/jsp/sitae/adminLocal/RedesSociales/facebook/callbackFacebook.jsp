<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>



<h3><bean:message key="redesSociales.tituloGestion" bundle="resources"/></h3>
<h4><bean:message key="redesSociales.ConfigurarFacebook" bundle="resources"/></h4>	
					<div><p><bean:message key="redesSociales.facebook.mensajeSeleccionusuario" bundle="resources"/></p><br/></div>

	  				<logic:notEmpty name="listadoCuentas">
	  				
	  				<table>
	  				<thead> <tr><th> <bean:message key="redesSociales.facebook.seleccionusuario.tabla1" bundle="resources"/></th> <th></th></tr> </thead>
	  				<tbody>
	  					
	  				
	  					<c:forEach var="redSocial" items="${listadoCuentas}">
	  					<tr>
	  						<td>
	  							<span style="float:left"><img src="${redSocial.urlImgUser}"/></span><span style="float:left;paddin-left:10px;padding-top:10px" ><p>Nombre: ${redSocial.nombre}</p><p>Url: ${redSocial.urlUser}</p></span>			
	  						</td>
	  						<td>
	  							<div class="botonera"> <a href ="./CallBackFacebook.do?idSeleccionado=${redSocial.idCuenta}"><bean:message key="redesSociales.facebook.seleccionar" bundle="resources"/></a></div>
	  						</td>
	  					</tr>
	  					
	  					</c:forEach>  	
	  					</tbody>			
	  				</table>
	  				</logic:notEmpty>
	  				
	  				<br/>
	  				
	  				<div class="botonera border"><a href="VisualizarRedesFront.do"><bean:message key="redesSociales.cancelar" bundle="resources"/></a></div>
	  				
								
															

