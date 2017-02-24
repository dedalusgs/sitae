package es.accv.fandango.test.wss4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

import es.novasoft.comun.constantes.Constantes;

/**
 * <a href="mailto:tsztelak@gmail.com">Tomasz Sztelak</a>
 * 
 */
public class PasswordHandler implements CallbackHandler {
	private Properties info = new Properties();
	private String contrasena;

	public PasswordHandler() {

		contrasena = Constantes.getPropiedad("fandango.alias.password");

	}

	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {

		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
		String id = pc.getIdentifer();
		pc.setPassword(this.contrasena);
	}

}
