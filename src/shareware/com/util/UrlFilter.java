package com.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UrlFilter extends HttpServlet implements Filter {

	private static final long serialVersionUID = 1L;

	private static List<String> excludeList;

	public void init(FilterConfig filterConfig) throws ServletException {
		String excludeUrl = PropertiesUtil.getProperty("excludeUrl");
		String[] array = excludeUrl.split("\\|");
		excludeList = Arrays.asList(array);
	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			HttpSession session = httpRequest.getSession();
			// 判断请求的url是否在受保护的范围内,如果是，进行权限判断，否直接进入下一步
			String url = httpRequest.getRequestURI();
			int lastIndex = url.lastIndexOf("/");
			url = url.substring(lastIndex + 1, url.length());
			if (!excludeList.contains(url)) {// 如果是受保护资源
				if (session.getAttribute("userId") == null) {
					String path = httpRequest.getContextPath();
					httpResponse.sendRedirect(path + "/login.jsp");
				}
			}
			chain.doFilter(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
