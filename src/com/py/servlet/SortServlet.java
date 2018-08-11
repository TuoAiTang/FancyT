package com.py.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.py.service.SortService;
import com.py.service.impl.SortServiceImpl;
import com.py.vo.Sort;

@SuppressWarnings("serial")
public class SortServlet extends HttpServlet {
	private SortService sortservice = new SortServiceImpl();//初始化Service对象
	private String result = null;//声明result
	private boolean flag = false;//声明标识符
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if("selectSort".equals(method)){
			List<Sort> list = null;
			list = sortservice.selectSort();
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
			request.getRequestDispatcher("background/bg-sortSelect.jsp")
			.forward(request, response);
		}
		else if("insertSort".equals(method)){
			Sort sort = new Sort();
			sort.setSortName(request.getParameter("sortName"));
			flag = sortservice.insertSort(sort);
			result = sortservice.getResult();
			if (flag) {
				response.sendRedirect("SortServlet.do?method=selectSort");
			} else {
				request.setAttribute("result", result);
				request.getRequestDispatcher(
						"background/bg-sortInsert.jsp").forward(
						request, response);
			}
		}
		else if("deleteSortBySortId".equals(method)){
			int sortId = Integer.parseInt(request.getParameter("sortId"));
			flag = sortservice.deleteSortBySortId(sortId);
			result = sortservice.getResult();
			if (flag) {
				response.sendRedirect("SortServlet.do?method=selectSort");
			} else {
				request.setAttribute("result", result);
				request.getRequestDispatcher(
						"SortServlet.do?method=selectSort").forward(
						request, response);
			}
			
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

}
