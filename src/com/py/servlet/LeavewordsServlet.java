package com.py.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.py.service.LeavewordsService;
import com.py.service.MemberService;
import com.py.service.impl.LeavewordsServiceImpl;
import com.py.service.impl.MemberServiceImpl;
import com.py.vo.Leavewords;
import com.py.vo.Member;

@SuppressWarnings("serial")
public class LeavewordsServlet extends HttpServlet {
	private LeavewordsService leavewordsservice = new LeavewordsServiceImpl();//初始化Service对象
	private MemberService memberservice = new MemberServiceImpl();
	private String result = null;//声明result
	private boolean flag = false;//声明标识符
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if("selectLeavewords".equals(method)){
			List<Leavewords> list = null;
			list = leavewordsservice.selectLeavewords();
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
			request.getRequestDispatcher("background/bg-leavewordsSelect.jsp")
			.forward(request, response);
		}
		else if("selectLeavewordsById".equals(method)){
			int id = Integer.parseInt(request.getParameter("id"));
			Leavewords leavewords = null;
			leavewords = leavewordsservice.selectLeavewordsById(id);
			request.setAttribute("leavewords", leavewords);
			request.getRequestDispatcher(
					"background/bg-leavewordsDetailSelect.jsp").forward(
					request, response);
			
		}
		else if("insertLeavewords".equals(method)){
			Leavewords leavewords = new Leavewords();
			String  account = request.getParameter("account");
			Member member = memberservice.selectMemberByAccount(account);
			leavewords.setGoodsId(Integer.valueOf(request.getParameter("goodsId")));
			leavewords.setAccount(account);
			leavewords.setTitle(request.getParameter("title"));
			//String content = request.getParameter("content");
			//System.out.println("content" + content);
			leavewords.setContent(request.getParameter("content"));
			flag = leavewordsservice.insertLeavewords(leavewords);
			result = leavewordsservice.getResult();
			if(flag){
				member.setIntergrate(member.getIntergrate() + 30);//一次评论加30积分
				memberservice.updateMember(member);
				response.sendRedirect("GoodsServlet.do?method=selectGoodsByGoodsId&goodsId="
						+ leavewords.getGoodsId()+"&sign=fg");
			}else{
				request.setAttribute("result", result);
				request.getRequestDispatcher(
						"GoodsServlet.do?method=selectGoodsByGoodsId&goodsId="
								+ leavewords.getGoodsId()+"&sign=fg").forward(request, response);
			}
		}
		else if("deleteLeavewordsById".equals(method)){
			int id = Integer.parseInt(request.getParameter("id"));
			flag = leavewordsservice.deleteLeavewordsById(id);
			result = leavewordsservice.getResult();
			if(flag){
				response.sendRedirect("LeavewordsServlet.do?method=selectLeavewords");
			}else{
				request.setAttribute("result", result);
				request.getRequestDispatcher(
						"LeavewordsServlet.do?method=selectLeavewords").forward(
						request, response);
			}
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

}
