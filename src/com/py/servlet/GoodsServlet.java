package com.py.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.py.service.GoodsService;
import com.py.service.impl.GoodsServiceImpl;
import com.py.vo.Goods;

@SuppressWarnings("serial")
public class GoodsServlet extends HttpServlet {
	private GoodsService goodsservice = new GoodsServiceImpl();//初始化Service对象
	private String result = null;//声明result
	private boolean flag = false;//声明标识符
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if("selectGoodsBySortId".equals(method)){
			int sortId = Integer.parseInt(request.getParameter("sortId"));
			List<Goods> list= null;
			list = goodsservice.selectGoodsBySortId(sortId);
			int pageNumber = list.size();
			int maxPage = pageNumber;
			String number = request.getParameter("i");
			if (maxPage % 6 == 0)
				maxPage = maxPage / 6;
			else {
				maxPage = maxPage / 6 + 1;
			}
			if (number == null) {
				number = "0";
			}
			request.setAttribute("number", String.valueOf(number));
			request.setAttribute("maxPage", String.valueOf(maxPage));
			request.setAttribute("pageNumber", String.valueOf(pageNumber));
			request.setAttribute("list", list);
			request.getRequestDispatcher("fg-selectSortGoods.jsp").forward(
					request, response);		
		}
		else if("selectGoodsByMark".equals(method)){
			int mark = Integer.parseInt(request.getParameter("mark"));
			List<Goods> list = null;
			list = goodsservice.selectGoodsByMark(mark);
			int pageNumber = list.size();
			int maxPage = pageNumber;
			String number = request.getParameter("i");
			if (maxPage % 6 == 0)
				maxPage = maxPage / 6;
			else {
				maxPage = maxPage / 6 + 1;
			}
			if (number == null) {
				number = "0";
			}
			request.setAttribute("number", String.valueOf(number));
			request.setAttribute("maxPage", String.valueOf(maxPage));
			request.setAttribute("pageNumber", String.valueOf(pageNumber));
			request.setAttribute("list", list);
			if (mark == 1) {
				request.getRequestDispatcher("fg-selectFreeGoods.jsp").forward(
						request, response);
			} else {
				request.getRequestDispatcher("fg-selectNowGoods.jsp").forward(
						request, response);
			}
		}
		else if("selectByKeywords".equals(method)){
			String keywords = request.getParameter("keywords");
			//判断编码格式
			if(keywords.equals(new String(keywords.getBytes("ISO-8859-1"), "ISO-8859-1"))) {
				keywords = new String(keywords.getBytes("ISO-8859-1"),"UTF-8");
			}			
			List<Goods> list = null;
			list = goodsservice.selectByKeywords(keywords);
			int pageNumber = list.size();
			int maxPage = pageNumber;
			String number = request.getParameter("i");
			if (maxPage % 6 == 0)
				maxPage = maxPage / 6;
			else {
				maxPage = maxPage / 6 + 1;
			}
			if (number == null) {
				number = "0";
			}
			request.setAttribute("number", String.valueOf(number));
			request.setAttribute("maxPage", String.valueOf(maxPage));
			request.setAttribute("pageNumber", String.valueOf(pageNumber));
			request.setAttribute("list", list);
			request.setAttribute("keywords", keywords);
			request.getRequestDispatcher("fg-selectKeywords.jsp").forward(
					request, response);
		}
		else if("selectGoods".equals(method)){
			List<Goods> list = null;
			list = goodsservice.selectGoods();
			int pageNumber = list.size();
			int maxPage = pageNumber;
			String number = request.getParameter("i");
			if (maxPage % 10 == 0)
				maxPage = maxPage / 10;
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
			request.getRequestDispatcher("background/bg-goodsSelect.jsp")
			.forward(request, response);
		}
		else if("selectGoodsByGoodsId".equals(method)){
			String sign = request.getParameter("sign");
			int goodsId = Integer.parseInt(request.getParameter("goodsId"));
			Goods goods =null;
			goods = goodsservice.selectGoodsByGoodsId(goodsId);
			request.setAttribute("goods", goods);
			if (sign.equals("fg")) {
				
				request.getRequestDispatcher("fg-goodsSelectOne.jsp").forward(
						request, response);
			} else if (sign.equals("bg")) {
				request.getRequestDispatcher(
						"background/bg-goodsDetailSelect.jsp").forward(request,
						response);
			}
		}
		else if("deleteGoodsByGoodsId".equals(method)){
			int goodsId = Integer.parseInt(request.getParameter("goodsId"));
			flag = goodsservice.deleteGoodsByGoodsId(goodsId);
			result = goodsservice.getResult();
			if(flag){
				response.sendRedirect("GoodsServlet.do?method=selectGoods");
			}else{
				request.setAttribute("result", result);
				request.getRequestDispatcher(
						"GoodsServlet.do?method=selectGoods").forward(
						request, response);
			}
		}
		else if("insertGoods".equals(method)){
			Goods goods = new Goods();
			goods.setTshirtName(request.getParameter("tshirtName"));
			goods.setSortId(Integer.valueOf(request.getParameter("sortId")));
			goods.setIntroduce(request.getParameter("introduce"));
			goods.setBrands(request.getParameter("brands"));
			goods.setPublishdate(request.getParameter("publishdate"));
			goods.setNowprice(Float.valueOf(request.getParameter("nowprice")));
			goods.setFreeprice(Float.valueOf(request.getParameter("freeprice")));
			goods.setPicture(request.getParameter("picture"));
			flag = goodsservice.insertGoods(goods);
			result = goodsservice.getResult();
			if(flag){
				response.sendRedirect("GoodsServlet.do?method=selectGoods");
			}else{
				request.setAttribute("result", result);
				request.getRequestDispatcher(
						"background/bg-goodsInsert.jsp").forward(
						request, response);
			}
		}
		else if("updateGoodsPrice".equals(method)){
			Goods goods = new Goods();
			goods.setGoodsId(Integer.valueOf(request.getParameter("goodsId")));
			goods.setNowprice(Float.valueOf(request.getParameter("nowprice")));
			goods.setFreeprice(Float.valueOf(request.getParameter("freeprice")));
			goods.setMark(Integer.valueOf(request.getParameter("mark")));
			flag = goodsservice.updateGoodsPrice(goods);
			result = goodsservice.getResult();
			if(flag){
				response.sendRedirect("GoodsServlet.do?method=selectGoods");
			}else{
				request.setAttribute("result", "修改失败");
				request.getRequestDispatcher(
						"background/bg-goodsPriceManager.jsp?goodsId="
								+ goods.getGoodsId() + "&nowprice=" + goods.getNowprice()
								+ "&freeprice=" + goods.getFreeprice() + "&mark="
								+ goods.getMark()).forward(request, response);
			}
		}
		else if("getLenovoByKeyword".equals(method)){
			String keyword = request.getParameter("keyword");
			keyword = new String(keyword.getBytes("ISO-8859-1"),"UTF-8"); 
			List<Goods> gdl = new ArrayList<Goods>();
			gdl = goodsservice.selectByKeywords(keyword);
			//采用HashSet存储，避免重复添加
			HashSet<String> lenovolist = new HashSet<String>();
			Iterator<Goods> it = gdl.iterator();
			while(it.hasNext()) {
				Goods gd = it.next();
				lenovolist.add(gd.getBrands());
				lenovolist.add(gd.getTshirtName());
			}
			Iterator<String> iter = lenovolist.iterator();
			while(iter.hasNext()&&(lenovolist.size()> 4)) {
				String str = iter.next();
				if(str.indexOf(keyword) == -1) {
					iter.remove();
				}
			}
			StringBuffer sb = new StringBuffer();
			String li_format = "<li class='form-control'><a href='GoodsServlet.do?method=selectByKeywords&keywords=%s' style='text-decoration:none;'>%s<span style='color:blue;'>%s</span>%s</li>";
			for (String string : lenovolist) {
				String left = "";
				String mid = "";
				String right = "";
				String[] split = string.split(keyword, 2);
				if(string.indexOf(keyword) == -1) {
					left = string;
				}
				else if(split.length == 1) {
					left = split[0];
					mid = keyword;
				}else if(split.length == 2) {
					left = split[0];
					mid = keyword;
					right = split[1];
				}
				String str = String.format(li_format, string, left, mid, right);
				sb.append(str);
			}
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();	
			out.print(sb.toString());		
		}
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

}
