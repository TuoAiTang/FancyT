package com.py.tool;
import java.io.*;
import javax.servlet.*;
public class EncodingFilter implements Filter {
	private String charSet;
	public void init(FilterConfig config) throws ServletException {

		this.charSet = config.getInitParameter("charSet");// ���ճ�ʼ���Ĳ���
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(this.charSet);//����ͳһ�ַ�
		chain.doFilter(request, response);
	}
	public void destroy() {
	}
}
