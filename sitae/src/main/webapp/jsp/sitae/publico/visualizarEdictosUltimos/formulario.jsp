<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="es.novasoft.comun.utils.OrganismoVisualizar"%>
<%@page import="java.util.Locale,org.apache.struts.Globals"%>

<div class="content">
	<p>
		<bean:message key="ultimosEdictosPublicados.texto1" bundle="resources" />
		<span class="bold"><bean:message
				key="ultimosEdictosPublicados.texto2" bundle="resources" />
		</span>

		<%
			OrganismoVisualizar organismoVisualizar = (OrganismoVisualizar) session
					.getAttribute("organismoSesion");
		%>

		<%
			if (organismoVisualizar != null) {
		%>

		<%
			Locale locale = (Locale) session
						.getAttribute(Globals.LOCALE_KEY);
		%>

		<%
			if (locale != null) {
		%>
		<%
			if (locale.getLanguage().equals("va")) {
		%>
		<%
			if ((!organismoVisualizar.getNombreVa().equals(""))) {
		%>
		<span class="bold"><%=organismoVisualizar.getNombreVa()%></span>
		<%
			}
		%>
		<%
			} else {
		%>
		<%
			if ((!organismoVisualizar.getNombre().equals(""))) {
		%>
		<span class="bold"><%=organismoVisualizar.getNombre()%></span>
		<%
			}
		%>
		<%
			}
		%>
		<%
			}
		%>
		<%
			}
		%>
		<bean:message key="ultimosEdictosPublicados.texto3" bundle="resources" />
	</p>
</div>

<h3>
	<bean:message key="ultimosEdictosPublicados.titulo" bundle="resources" />
</h3>

<c:set var="verInformacionEdictoProperty">
	<bean:message key="boton.verInformacionEdicto" bundle="resources" />
</c:set>
<c:set var="descargarEdictoProperty">
	<bean:message key="boton.descargarEdicto" bundle="resources" />
</c:set>
<c:set var="descargarCerficadoPublicacionEdictoProperty">
	<bean:message key="boton.descargarCerficadoPublicacionEdicto"
		bundle="resources" />
</c:set>
<c:set var="descargarCerficadoDiligenciaEdictoProperty">
	<bean:message key="boton.descargarCerficadoDiligenciaEdicto"
		bundle="resources" />
</c:set>

<logic:notEmpty name="VisualizarEdictoPublicoUltimosForm"
	property="listaPublicados">
	<table>
		<thead>
			<tr>
				<th abbr="Tit" class="ancho-400">
					<bean:message key="cabecera.titulo" bundle="resources" />
				</th>
				<th abbr="TipEdic">
					<bean:message key="cabecera.tipo_de_edicto" bundle="resources" />
				</th>
				<th abbr="AreaPro">
					<bean:message key="cabecera.centro_de_procedencia"
						bundle="resources" />
				</th>
				<th abbr="Fec">
					<bean:message key="cabecera.fecha_publicacion" bundle="resources" />
				</th>
				<th abbr="Fec_Ret">
					<bean:message key="cabecera.fecha_retirada" bundle="resources" />
				</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<logic:iterate id="listaPublicados"
				name="VisualizarEdictoPublicoUltimosForm" property="listaPublicados"
				indexId="indicePublicados">
				<c:if test="${(indicePublicados %2)==0}">
					<tr>
						<td>
							<html:link title="${verInformacionEdictoProperty}"
								action="/MuestraInformacionEdictoPublicoFrontAction.do?accion=inicio"
								paramId="idEdictoSeleccionado" paramName="listaPublicados"
								paramProperty="id" styleClass="icon-edictos">
								<bean:write name="listaPublicados" property="titulo" />
							</html:link>

							<div style="padding-left: 35px;"
								id="setDescripcion${listaPublicados.id}">
								<bean:write name="listaPublicados" property="descripcionCorta" />
							</div>

							<script type="text/javascript">
												$(function() { $('#setDescripcion${listaPublicados.id}').tooltip({ delay: 0, showURL: false,
														bodyHandler: function() {		
														return $("#textDescripcion${listaPublicados.id}").text();
												}  }); });
											</script>

							<div id="textDescripcion${listaPublicados.id}"
								style="display: none;">
								<bean:write name="listaPublicados" property="descripcion" />
							</div>

						</td>
						<td>
							<bean:write name="listaPublicados" property="tipoEdicto" />
						</td>
						<td>
							<bean:write name="listaPublicados" property="nombreCentro" />
						</td>
						<td>
							<bean:write name="listaPublicados" property="fechaPublicacion" />
						</td>
						<td>
							<bean:write name="listaPublicados"
								property="fechaRetiradaPropuesta" />
						</td>
						<td>
							<center>
								<html:link target="_blank"
									href="DescargarAnuncio.do?codigo=${listaPublicados.codigo}">
									<img title="${descargarEdictoProperty}"
										src="${pageContext.request.contextPath}/img/ico-descarga-edicto.gif"
										alt="${descargarEdictoProperty}" />
								</html:link>
							</center>
						</td>
						<td>
							<center>
								<html:link target="_blank"
									href="DescargarCertificadoPublicacion.do?codigo=${listaPublicados.codigo}">
									<img title="${descargarCerficadoPublicacionEdictoProperty}"
										src="${pageContext.request.contextPath}/img/ico-descargar-publicacion.gif"
										alt="${descargarCerficadoPublicacionEdictoProperty}" />
								</html:link>
							</center>
						</td>

					</tr>
				</c:if>
				<c:if test="${(indicePublicados %2)!=0}">
					<tr class="FilaPar">
						<td>

							<html:link title="${verInformacionEdictoProperty}"
								action="/MuestraInformacionEdictoPublicoFrontAction.do?accion=inicio"
								paramId="idEdictoSeleccionado" paramName="listaPublicados"
								paramProperty="id" styleClass="icon-edictos">
								<bean:write name="listaPublicados" property="titulo" />
							</html:link>

							<div style="padding-left: 35px;"
								id="setDescripcion${listaPublicados.id}">
								<bean:write name="listaPublicados" property="descripcionCorta" />
							</div>

							<script type="text/javascript">
												$(function() { $('#setDescripcion${listaPublicados.id}').tooltip({ delay: 0, showURL: false,
														bodyHandler: function() {		
														return $("#textDescripcion${listaPublicados.id}").text();
												}  }); });
											</script>

							<div id="textDescripcion${listaPublicados.id}"
								style="display: none;">
								<bean:write name="listaPublicados" property="descripcion" />
							</div>

						</td>
						<td>
							<bean:write name="listaPublicados" property="tipoEdicto" />
						</td>
						<td>
							<bean:write name="listaPublicados" property="nombreCentro" />
						</td>
						<td>
							<bean:write name="listaPublicados" property="fechaPublicacion" />
						</td>
						<td>
							<bean:write name="listaPublicados"
								property="fechaRetiradaPropuesta" />
						</td>
						<td>
							<center>
								<html:link target="_blank"
									href="DescargarAnuncio.do?codigo=${listaPublicados.codigo}">
									<img title="${descargarEdictoProperty}"
										src="${pageContext.request.contextPath}/img/ico-descarga-edicto.gif"
										alt="${descargarEdictoProperty}" />
								</html:link>
							</center>
						</td>
						<td>
							<center>
								<html:link target="_blank"
									href="DescargarCertificadoPublicacion.do?codigo=${listaPublicados.codigo}">
									<img title="${descargarCerficadoPublicacionEdictoProperty}"
										src="${pageContext.request.contextPath}/img/ico-descargar-publicacion.gif"
										alt="${descargarCerficadoPublicacionEdictoProperty}" />
								</html:link>
							</center>
						</td>
					</tr>
				</c:if>


			</logic:iterate>
		</tbody>
	</table>
</logic:notEmpty>

<logic:empty name="VisualizarEdictoPublicoUltimosForm"
	property="listaPublicados">
	<span class="bold"><bean:message key="listaEdictos.vacia"
			bundle="resources" />
	</span>
</logic:empty>
