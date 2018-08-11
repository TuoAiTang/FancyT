package com.py.servlet;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.py.vo.SellGoods;


@SuppressWarnings("serial")
public class CartServlet extends HttpServlet {
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		String method = request.getParameter("method");
		
		if("cartAdd".equals(method)){
			int goodsId = Integer.parseInt(request.getParameter("goodsId"));
			float goodsPrice = Float.parseFloat(request.getParameter("price"));
			boolean flag=true;
			SellGoods sellgoods=new SellGoods();
			sellgoods.Id=goodsId;
			sellgoods.price=goodsPrice;
			sellgoods.number=1;			
			HttpSession session = request.getSession();// �õ�session
			Vector<SellGoods> cart=(Vector<SellGoods>)session.getAttribute("cart");//��session��ȡ������cart����
			if(cart==null){
				cart=new Vector<SellGoods>();//���session��Χ�в�����cart���ԣ����½�SellGoods���͵�Vector
			}else{
			  for(int i=0;i<cart.size();i++){
			   SellGoods goods=(SellGoods)cart.elementAt(i);
			   if(goods.Id==sellgoods.Id){
			     goods.number++;
			     cart.setElementAt(goods,i);
			     flag=false;//�ж�ԭcart���Ƿ��������ӵ���Ʒ
			   }
			}
			}
			if(flag){
				cart.add(sellgoods);
				session.setAttribute("cart",cart);
			}
			response.sendRedirect("fg-cartSee.jsp");
		}
		if("cartClear".equals(method)){
			HttpSession session = request.getSession();// �õ�session
			session.removeAttribute("cart");
			response.sendRedirect("fg-cartSee.jsp");		
		}
		if("cartModify".equals(method)){
			HttpSession session = request.getSession();// �õ�session
			Vector<SellGoods> cart=(Vector<SellGoods>)session.getAttribute("cart");
			Vector<SellGoods> newcart=new Vector<SellGoods>();//�����µĹ��ﳵ����
			for(int i=0;i<cart.size();i++){
				SellGoods mygoodselement=(SellGoods)cart.elementAt(i);//��ȡÿ����Ʒ�Ķ���
				String num=request.getParameter("num"+i);
				try{
					int newnum=Integer.parseInt(num);
					mygoodselement.number=newnum;//������ͬ����Ʒ����
					if(newnum!=0){
					newcart.addElement(mygoodselement);//������Ʒ�����¹��ﳵ������
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			session.setAttribute("cart",newcart);//��newcart���󱣴���session��
			response.sendRedirect("fg-cartSee.jsp");//�ͻ�����ת��fg-cartSee.jsp
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
			this.doPost(request,response);
	}
}
