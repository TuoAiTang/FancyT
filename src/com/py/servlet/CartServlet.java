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
			HttpSession session = request.getSession();// 得到session
			Vector<SellGoods> cart=(Vector<SellGoods>)session.getAttribute("cart");//从session中取得属性cart内容
			if(cart==null){
				cart=new Vector<SellGoods>();//如果session范围中不存在cart属性，则新建SellGoods类型的Vector
			}else{
			  for(int i=0;i<cart.size();i++){
			   SellGoods goods=(SellGoods)cart.elementAt(i);
			   if(goods.Id==sellgoods.Id){
			     goods.number++;
			     cart.setElementAt(goods,i);
			     flag=false;//判断原cart中是否存在新添加的商品
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
			HttpSession session = request.getSession();// 得到session
			session.removeAttribute("cart");
			response.sendRedirect("fg-cartSee.jsp");		
		}
		if("cartModify".equals(method)){
			HttpSession session = request.getSession();// 得到session
			Vector<SellGoods> cart=(Vector<SellGoods>)session.getAttribute("cart");
			Vector<SellGoods> newcart=new Vector<SellGoods>();//声明新的购物车对象
			for(int i=0;i<cart.size();i++){
				SellGoods mygoodselement=(SellGoods)cart.elementAt(i);//获取每个商品的对象
				String num=request.getParameter("num"+i);
				try{
					int newnum=Integer.parseInt(num);
					mygoodselement.number=newnum;//增加相同的商品数量
					if(newnum!=0){
					newcart.addElement(mygoodselement);//将新商品放入新购物车对象中
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			session.setAttribute("cart",newcart);//将newcart对象保存在session中
			response.sendRedirect("fg-cartSee.jsp");//客户端跳转到fg-cartSee.jsp
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
			this.doPost(request,response);
	}
}
