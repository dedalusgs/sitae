package es.novasoft.comun.struts;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class EncodingFilter.
 */
public class EncodingFilter extends HttpServlet implements Filter {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(EncodingFilter.class);

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */

	public void init(FilterConfig filterconfig) {
		filterConfig = filterconfig;
		encoding = filterconfig.getInitParameter(ENCODING);
		LOGGER.debug(
			"EncodingFilter ver. 1.2 (c) Coldbeans info@servletsuite.com");
	}

	/**
	 * Sets the filter config.
	 * 
	 * @param s
	 *            the new filter config
	 */
	public void setFilterConfig(String s) {
	}

	/**
	 * Sets the filter config.
	 *
	 * @param filterConfig the new filter config
	 */
	public void setFilterConfig(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
		encoding = this.filterConfig.getInitParameter(ENCODING);
		LOGGER
		.debug("EncodingFilter ver. 1.3 (c) Coldbeans info@servletsuite.com");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest servletrequest,
			ServletResponse servletresponse, FilterChain filterchain)
			throws IOException, ServletException {
		try {
			servletrequest.setCharacterEncoding(encoding);
		} catch (UnsupportedEncodingException unsupportedencodingexception) {
			filterConfig.getServletContext().log(
					unsupportedencodingexception.getMessage());
		}
		filterchain.doFilter(servletrequest, servletresponse);
	}

	/** The Constant ENCODING. */
	private static final String ENCODING = "encoding";

	/** The filter config. */
	private FilterConfig filterConfig;

	/** The encoding. */
	private String encoding;
}
