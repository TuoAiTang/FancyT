package com.py.tool;
import java.io.*;
import javax.servlet.*;
public class EncodingFilter implements Filter {
	private String charSet;
	public void init(FilterConfig config) throws ServletException {

		this.charSet = config.getInitParameter("charSet");// 接收初始化的参数
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(this.charSet);//设置统一字符
		chain.doFilter(request, response);
	}
	public void destroy() {
	}
}
