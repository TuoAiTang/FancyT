<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.py.vo.Goods"%>
<%@ page import="java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<title>FancyT,潮流t，上ft</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<%
	@SuppressWarnings("unchecked") 
List<Goods> sortList = (List<Goods>) request.getAttribute("list");
int number=Integer.parseInt((String)request.getAttribute("number"));
int maxPage=Integer.parseInt((String)request.getAttribute("maxPage"));
int pageNumber=Integer.parseInt((String)request.getAttribute("pageNumber"));
int start=number*6;//开始条数
int over=(number+1)*6;//结束条数
int count=pageNumber-over;//还剩多少条记录
if(count<=0){
  over=pageNumber;
  }
%>
<body>
	<jsp:include page="fg-header.jsp" flush="true" />
	<jsp:include page="fg-nav.jsp" flush="true" />
	<div id="main">
		<jsp:include page="fg-sort.jsp" flush="true" />
		<div id="content">
			<div class="iconSort"></div>
			<hr />
			<br />
			<%
				if(sortList.size()==0){
			%>
			<div class="goodsTwoNo">没有商品的信息</div>
			<%
				}else{
			              for(int i=start;i<over;i++){
			              Goods sortGoods=(Goods)sortList.get(i);
			%>
			<div class="goodsTwo">
				<div class="goodsTwoImg">
					<a href="GoodsServlet.do?method=selectGoodsByGoodsId&goodsId=<%=sortGoods.getGoodsId()%>&sign=fg">
						<img src="<%=sortGoods.getPicture()%>" width="140" height="200" />
					</a>
				</div>
				<div class="goodsTwoTextarea1">
					<p>
						简介：<%=sortGoods.getIntroduce()%></p>
				</div>
				<div class="goodsTwoTextarea2">
					<p><%=sortGoods.getTshirtName()%></p>
					<%
						if(sortGoods.getMark()==0){
					%>
					<p class="blue">
						现价：<%=sortGoods.getNowprice()%>元
					</p>
					<%
						}else{
					%>
					<p class="red" style="text-decoration:line-through;">
						原价：<%=sortGoods.getNowprice()%>元
					</p>
					<p class="blue">
						现价：<%=sortGoods.getFreeprice()%>元
					</p>
					<%
						}
					%>
					<%
						if(session.getAttribute("member")!=null){
					%>
					<p style="line-height:90px">
						<a href="GoodsServlet.do?method=selectGoodsByGoodsId&goodsId=<%=sortGoods.getGoodsId()%>&sign=fg">查看详细内容</a>
					</p>
					<%
						}else{
					%>
					<p style="line-height:90px">
						<a href="fg-memberLogin.jsp" class="a6">登录后才能购买</a>
					</p>
					<%
						}
					%>
				</div>
			</div>
			<div class="clear"></div>
			<hr />
			<br />
			<%
				}
			%>
			<%
				}
			%>
			<%
				int sortId = 0;
					if(sortList.size()>0){
				Goods sortGoods=(Goods)sortList.get(0);
				sortId = sortGoods.getSortId();
					}
			%>
			<div class="page">
				<div class="pageOne">
					共为<%=maxPage%>页
				</div>
				<div class="pageOne">
					共有<%=pageNumber%>条记录
				</div>
				<div class="pageOne">
					当前为第<%=number+1%>页
				</div>
				<%
					if((number+1)==1){
				%>
				<div class="pageOne">上一页</div>
				<%
					}else{
				%>
				<div class="pageOne">
					<a
						href="GoodsServlet.do?method=selectGoodsBySortId&sortId=<%=sortId%>&i=<%=number-1%>">上一页</a>
				</div>
				<%
					}
				%>
				<%
					if(maxPage<=(number+1)){
				%>
				<div class="pageOne">下一页</div>
				<%
					}else{
				%>
				<div class="pageOne">
					<a
						href="GoodsServlet.do?method=selectGoodsBySortId&sortId=<%=sortId%>&i=<%=number+1%>">下一页</a>
				</div>
				<%
					}
				%>
			</div>
		</div>
	</div>
	<jsp:include page="fg-footer.jsp" flush="true" />
</body>
</html>
