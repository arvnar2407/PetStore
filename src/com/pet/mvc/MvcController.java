package com.pet.mvc;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MvcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map handlers = null;

	public MvcController() {
		super();

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String path = getServletContext()
				.getRealPath("/WEB-INF/mvc.properties");
		try {
			handlers = MvcUtil.buildHandler(path);
		} catch (MvcException e) {
			throw new ServletException(
					"Unable to configure controller servlet", e);
		}

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		String url = path.substring(7, path.indexOf("."));
	
		HttpRequestHandler handler = (HttpRequestHandler) handlers.get(url);
		if (handler != null) {
			handler.handle(request, response);
		} else {
			throw new ServletException("No matching handler available");
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
