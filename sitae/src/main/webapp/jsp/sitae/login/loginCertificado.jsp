<div >
	
	<jsp:directive.page contentType="text/html;charset=UTF-8" />
	
	
	

	
    <c:if test="${not empty param.login_error}">
      <div class="errors">
        <p>
          <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
          
        </p>
      </div>
    </c:if>
	<c:if test="${empty param.login_error}">
		<p><spring:message code="security_login_message" /></p>
	</c:if>

	<div>
		<script type="text/javascript">
		  	//-- Si la versión de Java no es superior a la 1.6.0_10 mostrar mensaje
			if (deployJava.versionCheck("1.6.0_10+")) {
				//tipo, datosGenerados
				loadAutenticacionSimpleApplet("CERTIFICADO", "datosgenerados","CAGVA|ACCV-CA1|ACCV-CA2|CATEST1|SUB_CA_WINDOWS3|ACCVCA-120|ACCVCA-110|AC DNIE 001|AC DNIE 002|AC DNIE 003");
			} else {
				alert("Necesitas Java superior a 1.6.0.10 para poder ejecutar el applet");
			}
		
		</script>
	
		<p>
			Accediendo con certificado...	
		</p>
		<p>
			Esta operación puede tardar unos segundos
		</p>
	</div>
	
  

	
</div>