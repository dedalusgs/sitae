/**
 * Autor: fjroa - Novasoft - Jaen (2011) 
 * Archivo: SessionExpirationFilter.java
 * Creado: 02-jun-2011
 * Version: 1.0
 * Descripcion:
 */
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

// TODO: Auto-generated Javadoc
/**
 * The Class SessionExpirationFilter.
 */
public class SessionExpirationFilter implements Filter {

	// HashMap de tamaño limitado con los ids de las últimas sesiones
	// expiradas
	// en la intranet
	/** The sesiones expiradas. */
	private static Map<String, String> sesionesExpiradas;

	// INIT PARAMS
	/** The expired url. */
	private String expiredUrl; // Redirección sesión expirada

	/** The max expired sessions. */
	private int maxExpiredSessions; // Número máximo de sesiones expiradas que

	// recordar

	/**
	 * Adds the expired session id.
	 * 
	 * @param sessId
	 *            the sess id
	 * @param userLogin
	 *            the user login
	 */
	public static void addExpiredSessionId(String sessId, String userLogin) {
		sesionesExpiradas.put(sessId, userLogin);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig arg0) throws ServletException {

		maxExpiredSessions = Integer.parseInt(arg0
				.getInitParameter("maxExpiredSessions"));
		setExpiredUrl(arg0.getInitParameter("url"));
		sesionesExpiradas = new SesionesExpiradasMap(maxExpiredSessions);
	}

	/**
	 * Sets the expired url.
	 * 
	 * @param expiredUrl
	 *            the new expired url
	 */
	public void setExpiredUrl(String expiredUrl) {
		this.expiredUrl = expiredUrl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * The Class SesionesExpiradasMap.
	 */
	private class SesionesExpiradasMap implements Map<String, String> {

		/** The sesiones expiradas. */
		private HashMap<String, String> sesionesExpiradas;

		/** The keys. */
		private ArrayBlockingQueue<String> keys;

		/**
		 * Instantiates a new sesiones expiradas map.
		 * 
		 * @param maxExpiredSessions
		 *            the max expired sessions
		 */
		public SesionesExpiradasMap(int maxExpiredSessions) {
			this.sesionesExpiradas = new HashMap<String, String>(
					maxExpiredSessions, 1);
			this.keys = new ArrayBlockingQueue<String>(maxExpiredSessions, true);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Map#clear()
		 */
		public void clear() {
			this.keys.clear();
			this.sesionesExpiradas.clear();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Map#containsKey(java.lang.Object)
		 */
		public boolean containsKey(Object arg0) {
			return this.sesionesExpiradas.containsKey(arg0);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Map#containsValue(java.lang.Object)
		 */
		public boolean containsValue(Object arg0) {
			return this.sesionesExpiradas.containsValue(arg0);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Map#entrySet()
		 */
		public Set<java.util.Map.Entry<String, String>> entrySet() {
			return this.sesionesExpiradas.entrySet();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Map#get(java.lang.Object)
		 */
		public String get(Object arg0) {
			return this.sesionesExpiradas.get(arg0);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Map#isEmpty()
		 */
		public boolean isEmpty() {
			return this.sesionesExpiradas.isEmpty();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Map#keySet()
		 */
		public Set<String> keySet() {
			return this.sesionesExpiradas.keySet();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
		 */
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

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Map#putAll(java.util.Map)
		 */
		public void putAll(Map<? extends String, ? extends String> arg0) {

			for (Entry e : arg0.entrySet()) {
				this.put((String) e.getKey(), (String) e.getValue());
			}

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Map#remove(java.lang.Object)
		 */
		public String remove(Object arg0) {
			this.keys.remove(arg0);
			return this.sesionesExpiradas.remove(arg0);

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Map#size()
		 */
		public int size() {
			return this.sesionesExpiradas.size();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Map#values()
		 */
		public Collection<String> values() {
			return this.sesionesExpiradas.values();
		}

	}
}