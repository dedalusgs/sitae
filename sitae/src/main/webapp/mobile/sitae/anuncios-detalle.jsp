<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@page import="java.util.Locale"%>
<%@page import="org.apache.struts.Globals"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java"%>




<h4><bean:message key="muestraInformacionEdicto.titulo" bundle="resources" /> </h4>
			<p><bean:message key="mobile.detalle.texto" bundle="resources" /> </p>
			
<div class="addthis_toolbox addthis_default_style addthis_32x32_style">
<a class="addthis_button_facebook"></a>
<a class="addthis_button_twitter"></a>
<a class="addthis_button_google_plusone_share"></a>
<a class="addthis_button_email"></a>
<a class="addthis_button_compact"></a><a class="addthis_counter addthis_bubble_style"></a>
</div>
<script type="text/javascript">var addthis_config = {"data_track_addressbar":true};</script>
<script type="text/javascript" src="//s7.addthis.com/js/300/addthis_widget.js#pubid=ra-52a829ba0e57c14f"></script>
<!-- AddThis Button END -->
			<div data-role="fieldcontain">
			<label class="label_titulo">
				<bean:message key="datosedicto.titulo" bundle="resources" />
			</label>
			<p>	
				<c:if test="${langu == 'va' }">
					<bean:write name="MuestraInformacionEdictoPublicoForm"
						property="edicto.tituloVa" />
				</c:if>
				<c:if test="${langu != 'va' }">
					<bean:write name="MuestraInformacionEdictoPublicoForm"
						property="edicto.titulo" />
				</c:if>
			</p>
			</div>
			<c:if test="${langu != 'va' }">
			<logic:notEmpty name="MuestraInformacionEdictoPublicoForm"
			property="edicto.descripcion">
			<div data-role="fieldcontain">
			<label class="label_titulo">
				<bean:message key="datosedicto.descripcion" bundle="resources" />
			</label>
			<p>
				<bean:write name="MuestraInformacionEdictoPublicoForm"
						property="edicto.descripcion" />
			</p>
			</div>
			</logic:notEmpty>
			</c:if>
			
			<c:if test="${langu == 'va' }">
			<logic:notEmpty name="MuestraInformacionEdictoPublicoForm"
			property="edicto.descripcionVa">
			<div data-role="fieldcontain">
			<label class="label_titulo">
				<bean:message key="datosedicto.descripcion" bundle="resources" />
			</label>
			<p>
				<bean:write name="MuestraInformacionEdictoPublicoForm"
						property="edicto.descripcionVa" />
			</p>
			</div>
			</logic:notEmpty>
			</c:if>

		<div data-role="fieldcontain">
			<label class="label_titulo">
				<bean:message key="datosedicto.tipoEdicto" bundle="resources" />
			</label>
			<p>
				<bean:write name="MuestraInformacionEdictoPublicoForm"
					property="edicto.tipoEdicto.nombre" />
			</p>
		</div>
		
			<logic:notEmpty name="MuestraInformacionEdictoPublicoForm"
			property="edicto.numExp">
		<div data-role="fieldcontain">
			<label class="label_titulo">
				<bean:message key="datosedicto.numExp" bundle="resources" />
			</label>
			<p>
				<bean:write name="MuestraInformacionEdictoPublicoForm"
					property="edicto.numExp" />
				
			</p>
			</div>
		</logic:notEmpty>
		
		<logic:empty name="MuestraInformacionEdictoPublicoForm"
			property="edicto.organismoExterno">
			<div data-role="fieldcontain">
				<label class="label_titulo">
					<bean:message key="datosedicto.procedencia" bundle="resources" />
				</label>
				<p>
					<bean:write name="MuestraInformacionEdictoPublicoForm"
						property="edicto.centro.nombre" />
				</p>
			</div>
		</logic:empty>

		<logic:notEmpty name="MuestraInformacionEdictoPublicoForm"
			property="edicto.organismoExterno">
			<div data-role="fieldcontain">
			<label class="label_titulo">
					<bean:message key="datosedicto.procedencia" bundle="resources" />
				</label>
				<p>
					<bean:write name="MuestraInformacionEdictoPublicoForm"
						property="edicto.organismoExterno.nombre" />
				</p>
			</div>
		</logic:notEmpty>

	<logic:notEmpty name="MuestraInformacionEdictoPublicoForm"
		property="edicto.sustituyeA">
			
			<div data-role="fieldcontain">
			
			<label class="label_titulo">
					<bean:message key="muestraInformacionEdicto.sustituye" bundle="resources" />
				</label>
				<p>
		<html:link title="${verInformacionEdictoProperty}"
					action="/MuestraInformacionFrontAction.do"
					paramId="idEdictoSeleccionado" paramName="MuestraInformacionEdictoPublicoForm"
					paramProperty="edicto.sustituyeA.idEdicto">
					<c:if test="${langu == 'va' }">
						<bean:write name="MuestraInformacionEdictoPublicoForm" property="edicto.sustituyeA.tituloVa" />
					</c:if>
					<c:if test="${langu != 'va' }">
						<bean:write name="MuestraInformacionEdictoPublicoForm" property="edicto.sustituyeA.titulo" />
					</c:if>
				</html:link>
				</p>
			</div>

	</logic:notEmpty>
	<logic:notEqual name="MuestraInformacionEdictoPublicoForm"
			property="nombrePublicador" value="">

			<logic:notEqual name="MuestraInformacionEdictoPublicoForm"
				property="fechaPublicacion" value="">

				<div data-role="fieldcontain">
					<label class="label_titulo">
						<bean:message key="datosedicto.fechaPublicacion"
							bundle="resources" />
					</label>
					<p>
						<bean:write name="MuestraInformacionEdictoPublicoForm"
							property="fechaPublicacion" />
					</p>
				</div>

			</logic:notEqual>
			<logic:notEqual name="MuestraInformacionEdictoPublicoForm"
				property="fechaRetirada" value="">

				<div data-role="fieldcontain">
					<label class="label_titulo">
						<bean:message key="datosedicto.fechaPublicacionFin"
							bundle="resources" />
					</label>
					<p>
						<bean:write name="MuestraInformacionEdictoPublicoForm"
							property="fechaRetirada" />
					</p>
				</div>

			</logic:notEqual>
			<logic:equal name="MuestraInformacionEdictoPublicoForm"
				property="fechaRetirada" value="">
				<div data-role="fieldcontain">
					<label class="label_titulo">
						<bean:message key="datosedicto.fechaRetirada" bundle="resources" />
					</label>
					<p>
						<bean:write name="MuestraInformacionEdictoPublicoForm"
							property="fechaPropuestaRetirada" />
					</p>
				</div>
			</logic:equal>
			<logic:notEqual name="MuestraInformacionEdictoPublicoForm"
				property="nombreDespublicador" value="">
				
				<div data-role="fieldcontain">
					<label class="label_titulo">
						<bean:message key="datosedicto.motivos" bundle="resources" />
					</label>
					<p>
						<c:if test="${langu == 'va' }">
						<bean:write name="MuestraInformacionEdictoPublicoForm"
							property="edicto.motivoBajaVa" />
						</c:if>
						<c:if test="${langu != 'va' }">
						<bean:write name="MuestraInformacionEdictoPublicoForm"
							property="edicto.motivoBaja" />
						</c:if>
					</p>
				</div>
			</logic:notEqual>
		</logic:notEqual>
		<div data-role="fieldcontain">
			<label class="label_titulo">
				<bean:message key="datosedicto.estado" bundle="resources" />
			</label>
			<p>
				<bean:write name="MuestraInformacionEdictoPublicoForm"
					property="edicto.estado.nombre" />
			</p>
		</div>

	



		<c:set var="descargarEdictoProperty">
				    <bean:message key="boton.descargarEdicto" bundle="resources"/>
			</c:set>
			<c:set var="descargarCerficadoDiligenciaEdictoProperty">
			     <bean:message key="boton.descargarCerficadoDiligenciaEdicto" bundle="resources"/>
			</c:set>
			<c:set var="descargarDiligenciaEdictoProperty">
				<bean:message key="boton.descargarDiligenciaEdicto" bundle="resources" /> 
			</c:set>
		
		    <c:if test="${(MuestraInformacionEdictoPublicoForm.edicto.estado.nombre!='RETIRADO')}">
			<div data-role="fieldcontain">
			<label class="label_titulo">
			<bean:message key="mobile.detalle.documento" bundle="resources" />
			</label>
				<p>
				<a data-role="button" target="_blank" data-theme="b" class=" ui-btn   ui-corner-all ui-icon-action ui-nodisc-icon ui-alt-icon"
					title='<bean:message key="boton.descargarEdicto" bundle="resources"/>'
					href="../DescargarAnuncio.do?codigo=${MuestraInformacionEdictoPublicoForm.edicto.codigo}">
						<img title="${descargarEdictoProperty}"
							src="${pageContext.request.contextPath}/img/ico-descarga-edicto.gif"
							alt="${descargarEdictoProperty}" /><bean:message key="boton.descargarEdicto" bundle="resources" />
						
						</a>
						
				</p>
			</div>
			<div data-role="fieldcontain">
			<label class="label_titulo">
				<bean:message key="mobile.detalle.certificado" bundle="resources" />
				</label>
				<p>
				<a target="_blank" class=" ui-btn   ui-corner-all ui-icon-action ui-nodisc-icon ui-alt-icon"
					title='<bean:message key="boton.descargarCerficadoPublicacionEdicto" bundle="resources"/>'
					href="../DescargarCertificadoPublicacion.do?codigo=${MuestraInformacionEdictoPublicoForm.edicto.codigo}">
						<img title="${descargarCerficadoDiligenciaEdictoProperty}"
								src="${pageContext.request.contextPath}/img/ico-descargar-publicacion.gif"
								alt="${descargarCerficadoDiligenciaEdictoProperty}" /> <bean:message key="boton.descargarEdicto" bundle="resources" />
				</a>
				</p>
			</div>
			</c:if>
			
			 <c:if test="${(MuestraInformacionEdictoPublicoForm.edicto.estado.nombre=='RETIRADO')}">
			<div data-role="fieldcontain">
			<label class="label_titulo">
			<bean:message key="mobile.detalle.documento" bundle="resources" />
			</label>
				<p>
				<a data-role="button" target="_blank" data-theme="b" class=" ui-btn   ui-corner-all ui-icon-action ui-nodisc-icon ui-alt-icon"
					title='<bean:message key="boton.descargarEdicto" bundle="resources"/>'
					href="../DescargarAnuncioRetirado.do?codigo=${MuestraInformacionEdictoPublicoForm.edicto.codigo}">
						<img title="${descargarEdictoProperty}"
							src="${pageContext.request.contextPath}/img/ico-descarga-edicto.gif"
							alt="${descargarEdictoProperty}" /><bean:message key="boton.descargarEdicto" bundle="resources" />
						
						</a>
						
				</p>
			</div>
			<div data-role="fieldcontain">
			<label class="label_titulo">
				<bean:message key="mobile.detalle.certificado" bundle="resources" />
				</label>
				<p>
				<a target="_blank" class=" ui-btn   ui-corner-all ui-icon-action ui-nodisc-icon ui-alt-icon"
					title='<bean:message key="boton.descargarCerficadoPublicacionEdicto" bundle="resources"/>'
					href="../DescargarInformeRevision.do?codigo=${MuestraInformacionEdictoPublicoForm.edicto.codigo}">
						<img title="${descargarCerficadoDiligenciaEdictoProperty}"
								src="${pageContext.request.contextPath}/img/ico-descargar-publicacion.gif"
								alt="${descargarCerficadoDiligenciaEdictoProperty}" /> <bean:message key="boton.descargarEdicto" bundle="resources" />
				</a>
				</p>
			</div>
			
			<div data-role="fieldcontain">
			<label class="label_titulo">
				<bean:message key="mobile.detalle.diligencia" bundle="resources" />
				</label>
				<p>
				<a target="_blank"  data-theme="b" class=" ui-btn   ui-corner-all ui-icon-action ui-nodisc-icon ui-alt-icon"
					title='${descargarDiligenciaEdictoProperty}'
					href="../DescargarDiligencia.do?codigo=${MuestraInformacionEdictoPublicoForm.edicto.codigo}">		
					<bean:message key="boton.descargarEdicto" bundle="resources" />
					<img title="${descargarDiligenciaEdictoProperty}"
								src="${pageContext.request.contextPath}/img/ico-descargar-diligencia.gif"
								alt="${descargarDiligenciaEdictoProperty}" />
				</a>
				</p>
			</div>	
			
		</c:if>

			

	      	
			
			
		

	