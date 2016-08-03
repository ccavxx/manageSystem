package com.tmh.web.filter.xss;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XssFilter implements Filter {

	protected static final Logger logger = LoggerFactory.getLogger(XssFilter.class);
	private String excludeUrl = "";
	private String redirecturl = "";

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String url = req.getRequestURI();
		url = url.substring(url.lastIndexOf("/") + 1, url.length());
		if (url == null || url.equals("")) {
			res.sendRedirect(req.getContextPath() + redirecturl);
		} else {
			// 对不需要防御xss的请求进行过滤，
			String []excludeUrls=excludeUrl.split(",");
			for (int i = 0; i < excludeUrls.length; i++) {
				if (url.equals(excludeUrl)) {
					chain.doFilter(request, response);
				}
			}
			chain.doFilter(new XSSHttpServletRequestWrapper((HttpServletRequest) request), response);
		}
	}

	public void init(FilterConfig conf) throws ServletException {
		excludeUrl = "index.do";
		redirecturl="index.do";
	}

	public void destroy() {

	}

}
