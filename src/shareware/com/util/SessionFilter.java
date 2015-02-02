package com.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Title SessionFilter.java
 * @Description AOP做日志处理保存request
 * @author Wang
 * @date Nov 9, 2009
 */
public class SessionFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
