package net.marcoreis.ecommerce.controlador.filtro;

import java.io.IOException;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.bean.SessionScoped;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

//@Named
@SessionScoped
public class FiltroLogging implements Serializable, Filter {

	private static final long serialVersionUID = 1472782644963167647L;
	private static Logger LOGGER = Logger
			.getLogger(FiltroLogging.class);
	private String lastLoggedUri = "";

	private FilterConfig filterConfig = null;
	// @Inject
	// VisitController visitController;

	@Override
	public void init(FilterConfig filterConfig)
			throws ServletException {
		this.filterConfig = filterConfig;
	}

	/**
	 * Log requests of interest with the VisitController.
	 */
	@Override
	public void doFilter(ServletRequest request,
			ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {

		// Run the other filters.
		filterChain.doFilter(request, response);

		if (request instanceof HttpServletRequest) {
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			String uri = httpServletRequest.getRequestURI();

			String regex = "((/{1}\\w+$)|(/{1}\\w+\\.jsf$))";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(uri);
			while (m.find()) {
				LOGGER.info("match " + m.group());
				break;
			}
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
}