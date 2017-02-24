<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@page import="java.util.Locale"%>
<%@page import="org.apache.struts.Globals"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java"%>

<div id="top">
	<ul>
		<li class="first">
			<bean:message key="portal.bienvenidos" bundle="resources" />
		</li>
		<%
			Locale locale = (Locale) session.getAttribute(Globals.LOCALE_KEY);
		%>
		<%
			if (locale != null) {
		%>
		<%
			if (locale.getLanguage().equals("va")) {
		%>
		<li><%=session.getAttribute("fechaSesionVA")%></li>
		<%
			} else {
		%>
		<li><%=session.getAttribute("fechaSesionES")%></li>
		<%
			}
		%>
		<%
			}
		%>
	</ul>

	<script type="text/javascript">
			function idioma(){
			$(" #idioma ul li ul").css({display: "none"}); // Opera Fix
			$(" #idioma ul li").click(function(){
				$(this).find('ul').slideToggle(0);
				}
			);
			}
			$(document).ready(function(){					
				idioma();
			});
			</script>


	<div id="idioma">
		<ul>
			<li>
				<%
					if (locale != null) {
				%>
				<%
					if (locale.getLanguage().equals("va")) {
				%>
				<p class="val">
					<bean:message key="lenguajes.va" bundle="resources" />
				</p>
				<ul>
					<li>
						<p class="cast">
							<c:set var="lenguajesEsProperty">
								<bean:message key="lenguajes.es" bundle="resources" />
							</c:set>
							<html:link title="${lenguajesEsProperty}"
								action="./CambiarLenguajeDoAction.do?idioma=es&servicioNavegacion=-1&grupoNavegacion=-1'">
								<bean:message key="lenguajes.es" bundle="resources" />
							</html:link>
						</p>
					</li>
				</ul>
				<%
					} else {
				%>
				<p class="cast">
					<bean:message key="lenguajes.es" bundle="resources" />
				</p>
				<ul>
					<li>
						<p class="val">
							<c:set var="lenguajesVaProperty">
								<bean:message key="lenguajes.va" bundle="resources" />
							</c:set>
							<html:link title="${lenguajesVaProperty}"
								action="./CambiarLenguajeDoAction.do?idioma=va&servicioNavegacion=-1&grupoNavegacion=-1">
								<bean:message key="lenguajes.va" bundle="resources" />
							</html:link>
						</p>
					</li>
				</ul>
				<%
					}
				%>
				<%
					}
				%>
			</li>
		</ul>
	</div>
</div>

