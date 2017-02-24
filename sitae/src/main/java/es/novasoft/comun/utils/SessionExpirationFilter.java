package es.novasoft.comun.utils;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionExpirationFilter implements Filter {

	// HashMap de tamaño limitado con los ids de las últimas sesiones expiradas
	// en la intranet
	private static Map<String, String> sesionesExpiradas;

	// INIT PARAMS
	private String expiredUrl;// Redirección sesión expirada

	private int maxExpiredSessions;// Número máximo de sesiones expiradas que
									// recordar

	public static void addExpiredSessionId(String sessId, String userLogin) {
		sesionesExpiradas.put(sessId, userLogin);
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		HttpSession session = httpRequest.getSession(false);

		if (session == null) {
			// o no había sesión o ha expirado
			String reqSessId = httpRequest.getRequestedSessionId();
			String user = (String) sesionesExpiradas.remove(reqSessId);

			if (user != null) {
				// La sesión había expirado, redirigir al action de sesión
				// expirada
				String targetUrl = httpRequest.getContextPath() + expiredUrl;
				httpResponse.sendRedirect(httpResponse
						.encodeRedirectURL(targetUrl));
				return;
			}
		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {

		maxExpiredSessions = Integer.parseInt(arg0
				.getInitParameter("maxExpiredSessions"));
		setExpiredUrl(arg0.getInitParameter("url"));
		sesionesExpiradas = new SesionesExpiradasMap(maxExpiredSessions);
	}

	public void setExpiredUrl(String expiredUrl) {
		this.expiredUrl = expiredUrl;
	}

	public void destroy() {
	}

	private class SesionesExpiradasMap implements Map<String, String> {
		private HashMap<String, String> sesionesExpiradas;

		private ArrayBlockingQueue<String> keys;

		public SesionesExpiradasMap(int maxExpiredSessions) {
			this.sesionesExpiradas = new HashMap<String, String>(
					maxExpiredSessions, 1);
			this.keys = new ArrayBlockingQueue<String>(maxExpiredSessions, true);
		}

		public void clear() {
			this.keys.clear();
			this.sesionesExpiradas.clear();
		}

		public boolean containsKey(Object arg0) {
			return this.sesionesExpiradas.containsKey(arg0);
		}

		public boolean containsValue(Object arg0) {
			return this.sesionesExpiradas.containsValue(arg0);
		}

		public Set<java.util.Map.Entry<String, String>> entrySet() {
			return this.sesionesExpiradas.entrySet();
		}

		public String get(Object arg0) {
			return this.sesionesExpiradas.get(arg0);
		}

		public boolean isEmpty() {
			return this.sesionesExpiradas.isEmpty();
		}

		public Set<String> keySet() {
			return this.sesionesExpiradas.keySet();
		}

		public String put(String sessId, String userLogin) {
			String prevValue = null;

			if (this.keys.remainingCapacity() < 1) {
				// no hay espacio en la cola, eliminar el id de sesión expirada
				// más antiguo
				this.sesionesExpiradas.remove(this.keys.poll());
			}
			if (this.keys.offer(sessId)) {
				// Hay espacio en la cola, introducir el sessId en el map
				prevValue = this.sesionesExpiradas.put(sessId, userLogin);
			}
			return prevValue;

		}

		public void putAll(Map<? extends String, ? extends String> arg0) {

			for (Entry e : arg0.entrySet()) {
				this.put((String) e.getKey(), (String) e.getValue());
			}

		}

		public String remove(Object arg0) {
			this.keys.remove(arg0);
			return this.sesionesExpiradas.remove(arg0);

		}

		public int size() {
			return this.sesionesExpiradas.size();
		}

		public Collection<String> values() {
			return this.sesionesExpiradas.values();
		}

	}
}