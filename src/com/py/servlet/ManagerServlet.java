package com.py.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.py.service.ManagerService;
import com.py.service.impl.ManagerServiceImpl;
import com.py.vo.Manager;

@SuppressWarnings("serial")
public class ManagerServlet extends HttpServlet {
	private ManagerService managerservice = new ManagerServiceImpl();//初始化Service对象
	HttpSession session = null;//声明HttpSession对象
	private String result = null;//声明result
	private boolean flag = false;//声明标识符
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if("selectManagerLogin".equals(method)){
			Manager manager = null;
			session = request.getSession();// 得到session
			String account = request.getParameter("account");
			String password = request.getParameter("password");
			manager = managerservice.selectManagerLogin(account, password);
			result = managerservice.getResult();
			if (result==null) {
				session.setAttribute("manager", manager);// 将manager保存在session范围内
				response.sendRedirect("GoodsServlet.do?method=selectGoods");
			}else {
				request.setAttribute("result", result);
				request.getRequestDispatcher(
						"/background/bg-managerLogin.jsp").forward(
						request, response);
			}
		}
		else if("selectManager".equals(method)){
			List<Manager> list = null;
			list = managerservice.selectManager();
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
			request.getRequestDispatcher("/background/bg-managerSelect.jsp")
			.forward(request, response);
		}
		else if("deleteManagerByAccount".equals(method)){
			String account = request.getParameter("account");
			flag = managerservice.deleteManagerByAccount(account);
			result = managerservice.getResult();
			if(flag){
				response.sendRedirect("ManagerServlet.do?method=selectManager");// 避免重复删除
			}else{
				request.setAttribute("result", result);
				request.getRequestDispatcher(
						"ManagerServlet.do?method=selectManager").forward(
						request, response);
			}
			
		}
		else if("insertManager".equals(method)){
			Manager manager = new Manager();
			manager.setAccount(request.getParameter("account"));
			manager.setPassword(request.getParameter("password"));
			manager.setReallyName(request.getParameter("reallyName"));
			manager.setTel(request.getParameter("tel"));
			manager.setSign(Integer.valueOf(request.getParameter("sign")));
			flag = managerservice.insertManager(manager);
			result = managerservice.getResult();
			if(flag){
				response.sendRedirect("ManagerServlet.do?method=selectManager");// 使用客户端跳转，避免重复提交
			}else{
				request.setAttribute("result", result);
				request.getRequestDispatcher(
						"background/bg-managerInsert.jsp").forward(
						request, response);
			}
			
		}
		else if("updateManager".equals(method)){
			session = request.getSession();// 得到session
			Manager manager = new Manager();
			manager.setAccount(request.getParameter("account"));
			manager.setPassword(request.getParameter("password"));
			manager.setReallyName(request.getParameter("reallyName"));
			manager.setTel(request.getParameter("tel"));
			flag = managerservice.updateManager(manager);
			result = managerservice.getResult();
			if(flag){
				session.removeAttribute("manager");// 删除session范围内的manager属性
				session.setAttribute("manager", manager);// 将manager保存在session范围内
				response.sendRedirect("background/bg-managerUpdate.jsp");
			}else{
				request.setAttribute("result", result);
				request.getRequestDispatcher(
						"background/bg-managerUpdate.jsp").forward(request,
						response);
			}
			
		}
		else if("logoutManager".equals(method)){
			session = request.getSession();// 得到session
			session.invalidate();
			response.sendRedirect("background/bg-managerLogin.jsp");
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
}
