package com.py.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.py.service.LinkService;
import com.py.service.impl.LinkServiceImpl;
import com.py.vo.Link;

@SuppressWarnings("serial")
public class LinkServlet extends HttpServlet {
	private LinkService linkservice = new LinkServiceImpl();//初始化Service对象
	private String result = null;//声明result
	private boolean flag = false;//声明标识符
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if("selectLink".equals(method)){
			List<Link> list = null;
			list = linkservice.selectLink();
			int pageNumber = list.size();
			int maxPage = pageNumber;
			String number = request.getParameter("i");
			if (maxPage % 10 == 0)
				maxPage = maxPage/10;
			else {
				maxPage = maxPage / 10 + 1;
			}
			if (number == null) {
				number = "0";
			}
			request.setAttribute("number", String.valueOf(number));
			request.setAttribute("maxPage", String.valueOf(maxPage));
			request.setAttribute("pageNumber", String.valueOf(pageNumber));
			request.setAttribute("list", list);
			request.getRequestDispatcher("background/bg-linkSelect.jsp")
			.forward(request, response);
		}
		else if("deleteLinkById".equals(method)){
			int id = Integer.parseInt(request.getParameter("id"));
			flag = linkservice.deleteLinkById(id);
			result = linkservice.getResult();
			if (flag) {
				response.sendRedirect("LinkServlet.do?method=selectLink");
			} else {
				request.setAttribute("result", result);
				request.getRequestDispatcher(
						"LinkServlet.do?method=selectLink").forward(
						request, response);
			}
		}
		else if("insertLink".equals(method)){
			Link link = new Link();
			link.setLinkName(request.getParameter("linkName"));
			link.setLinkAddress(request.getParameter("linkAddress"));
			flag = linkservice.insertLink(link);
			result = linkservice.getResult();
			if (flag) {
				response.sendRedirect("LinkServlet.do?method=selectLink");
			} else {
				request.setAttribute("result", result);
				request.getRequestDispatcher(
						"background/bg-linkInsert.jsp").forward(
						request, response);
			}
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
}
