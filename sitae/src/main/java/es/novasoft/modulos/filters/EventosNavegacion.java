package es.novasoft.modulos.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EventosNavegacion implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (request instanceof HttpServletRequest) {
			if (((HttpServletRequest) request)
					.getParameter("servicioNavegacion") != null) {
				String servicioNavegacion = ((HttpServletRequest) request)
						.getParameter("servicioNavegacion");
				((HttpServletRequest) request).getSession().setAttribute(
						"idServicioNavegacion", servicioNavegacion);
			}
			if (((HttpServletRequest) request).getParameter("grupoNavegacion") != null) {
				String grupoNavegacion = ((HttpServletRequest) request)
						.getParameter("grupoNavegacion");
				((HttpServletRequest) request).getSession().setAttribute(
						"idGrupoNavegacion", grupoNavegacion);
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
