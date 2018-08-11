package com.py.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.py.service.MemberService;
import com.py.service.OrderService;
import com.py.service.impl.MemberServiceImpl;
import com.py.service.impl.OrderServiceImpl;
import com.py.vo.Order;
import com.py.vo.OrderDetail;
import com.py.vo.SellGoods;
import com.py.vo.Member;

@SuppressWarnings("serial")
public class OrderServlet extends HttpServlet {
	private OrderService orderservice = new OrderServiceImpl();//��ʼ��Service����
	private MemberService memberservice = new MemberServiceImpl();//��ʼ��memberservice
	HttpSession session = null;//����HttpSession����
	private String result = null;//����result
	private boolean flag = false;//������ʶ��

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if ("insertOrder".equals(method)) {
			session = request.getSession();// �õ�session
			@SuppressWarnings("unchecked")
			Vector<SellGoods> cart = (Vector<SellGoods>) session.getAttribute("cart");//��ȡsession��Χ�ڹ��ﳵcart
			Order order = new Order();//ʵ����order����	
			String account = request.getParameter("account");
			List<OrderDetail> list = new ArrayList<OrderDetail>();//����List����			
			String orderId = request.getParameter("orderId").trim();//��ȡ������
			order.setOrderId(orderId);
			order.setAccount(account);
			order.setReallyName(request.getParameter("reallyName"));
			order.setAddress(request.getParameter("address"));
			order.setTel(request.getParameter("tel"));
			order.setSetMoney(request.getParameter("setMoney"));
			order.setPost(request.getParameter("post"));
			order.setBz(request.getParameter("bz"));
			for (int i = 0; i < cart.size(); i++) {
				SellGoods sellgoods = (SellGoods) cart.elementAt(i);
				OrderDetail orderdetail = new OrderDetail();//ʵ����OrderDetail����
				orderdetail.setOrderId(orderId);
				orderdetail.setGoodsId(sellgoods.Id);
				orderdetail.setPrice(sellgoods.price);
				orderdetail.setNumber(sellgoods.number);
				list.add(orderdetail);
			}
			flag = orderservice.insertOrder(order, list);//���ɶ���
			result = orderservice.getResult();
			if(flag){
				Member member = memberservice.selectMemberByAccount(account);
				member.setIntergrate(member.getIntergrate() + 50);//һ�ζ�����50����
				memberservice.updateMember(member);
				session.removeAttribute("cart");
				response.sendRedirect("fg-orderDetail.jsp");
			}else{
				request.setAttribute("result", result);
				request.getRequestDispatcher("fg-orderSubmit.jsp")
						.forward(request, response);
			}
		}
		else if("selectOrder".equals(method)){
			List<Order> list = null;
			list = orderservice.selectOrder();
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
			request.getRequestDispatcher("background/bg-orderSelect.jsp")
			.forward(request, response);
		}
		else if("selectOrderDetailByOrderId".equals(method)){
			String orderId = request.getParameter("orderId");
			List<OrderDetail> list = null;
			list = orderservice.selectOrderDetailByOrderId(orderId);
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
			request.getRequestDispatcher(
					"background/bg-orderDetailSelect.jsp").forward(request,
					response);
		}
		else if("updateOrderSign".equals(method)){
			String orderId = request.getParameter("orderId");
			flag = orderservice.updateOrderSign(orderId);
			result = orderservice.getResult();
			if(flag){
				response.sendRedirect("OrderServlet.do?method=selectOrder");
			}else{
				request.setAttribute("result", result);
				request.getRequestDispatcher(
						"OrderServlet.do?method=selectOrder").forward(
						request, response);
			}
			
		}
		else if("deleteOrderByOrderId".equals(method)){
			String orderId = request.getParameter("orderId");
			flag = orderservice.deleteOrderByOrderId(orderId);
			result = orderservice.getResult();
			if(flag){
				response.sendRedirect("OrderServlet.do?method=selectOrder");
			}else{
				request.setAttribute("result", result);
				request.getRequestDispatcher(
						"OrderServlet.do?method=selectOrder").forward(
						request, response);
			}
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
}
