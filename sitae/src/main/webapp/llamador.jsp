<html>
<body>

----- PDF ------- <br><br>

<form action="respuesta.jsp" method="POST">

cliente-config.wsdd: <input type="text" name="clienteWSDD" size="50"><br>
end-point: <input type="text" name="endPoint" size="50"><br>

URL: <input type="text" name="url" size="50"><br>
Título: <input type="text" name="titulo" size="50"><br>
<input type="submit">

</form>

----- Resto ------- <br><br>

<form action="respuesta.jsp" method="POST">

cliente-config.wsdd: <input type="text" name="clienteWSDD" size="50"><br>
end-point: <input type="text" name="endPoint" size="50"><br>
dir-etc: <input type="text" name="dirEtc" size="50"><br>

Tipo de firma: 
	<select name="tipoFirma">
		<option value="1">CMS</option>
		<option value="2">PKCS#7</option>
		<option value="3">Token</option>
	</select><br>
Título: <input type="text" name="titulo" size="50"><br>
Revocado: <input type="checkbox" name="revocado"><br>
<input type="submit">

</form>

</body>
</html>