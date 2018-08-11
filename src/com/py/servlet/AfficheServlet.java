package com.py.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.py.service.AfficheService;
import com.py.service.impl.AfficheServiceImpl;
import com.py.vo.Affiche;
@SuppressWarnings("serial")
public class AfficheServlet extends HttpServlet {
	private AfficheService afficheservice = new AfficheServiceImpl();//初始化Service对象
	private String result = null;//声明result
	private boolean flag = false;//声明标识符
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if("selectAfficheById".equals(method)){
			int id = Integer.parseInt(request.getParameter("id"));
			String sign = request.getParameter("sign");
			Affiche affiche = null;
			affiche = afficheservice.selectAfficheById(id);
			request.setAttribute("affiche", affiche);
			if (sign.equals("fg")) {
				request.getRequestDispatcher("fg-afficheDetail.jsp").forward(
						request, response);
			} else if (sign.equals("bg")) {
				request.getRequestDispatcher(
						"background/bg-afficheDetailSelect.jsp").forward(
						request, response);
			}
		}
		else if("selectAffiche".equals(method)){
			String sign = request.getParameter("sign");
			List<Affiche> list = null;
			list = afficheservice.selectAffiche();
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
			if (sign.equals("fg")) {
				request.getRequestDispatcher("fg-afficheSelect.jsp").forward(
						request, response);
			} else if (sign.equals("bg")) {
				request.getRequestDispatcher("background/bg-afficheSelect.jsp")
						.forward(request, response);
			}
		}
		else if("deleteAfficheById".equals(method)){
			int id = Integer.parseInt(request.getParameter("id"));
			flag = afficheservice.deleteAfficheById(id);
			result = afficheservice.getResult();
			if(flag){
				response.sendRedirect(
						"AfficheServlet.do?method=selectAffiche&sign=bg");
			}else{
				request.setAttribute("result", result);
				request.getRequestDispatcher(
						"AfficheServlet.do?method=selectAffiche&sign=bg").forward(
						request, response);
			}
		}
		else if("insertAffiche".equals(method)){
			Affiche affiche = new Affiche();
			affiche.setAffiche(request.getParameter("affiche"));
			affiche.setContent(request.getParameter("content"));
			flag = afficheservice.insertAffiche(affiche);
			result = afficheservice.getResult();
			if(flag){
				response.sendRedirect(
						"AfficheServlet.do?method=selectAffiche&sign=bg");
			}else{
				request.setAttribute("result", result);
				request.getRequestDispatcher(
						"background/bg-afficheInsert.jsp").forward(
						request, response);
			}
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

}
