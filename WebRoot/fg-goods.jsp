<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.py.vo.Goods"%>
<%@ page import="com.py.vo.Member"%>
<%@ page import="com.py.factory.DAOFactory"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<title>电子商务网站</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<%
	List<Goods> freeList = DAOFactory.getGoodsDAOInstance().selectGoodsByMark(1);
	List<Goods> nowList = DAOFactory.getGoodsDAOInstance().selectGoodsByMark(0);
%>
<body>
	<div id="content">
		<div id="goodsFree">
			<div class="iconFree">
				<a href="GoodsServlet.do?method=selectGoodsByMark&mark=1" style="text-decoration: none">
					<img src="images/more_2.png" width="25" height="25"/>更多
				</a>
			</div>
			<hr />
			<div class="goodsFree">
			<%
					//一行仅能显示6件商品。
								        
				int free=0;
				int num1=0;
				if(freeList.size()<=6)
				{
					free=freeList.size();
					num1=0;
				}else{
					free=freeList.size();
					num1=free-6;
				}
					for(int i=num1;i<free;i++)
				{
					 Goods freeGoods=(Goods)freeList.get(i);
			%>
				<div class="goodsOne">
					<div class="goodsOneImg">
						<a href="GoodsServlet.do?method=selectGoodsByGoodsId&goodsId=<%=freeGoods.getGoodsId()%>&sign=fg">
							<img src="<%=freeGoods.getPicture()%>" width="140" height="200" />
						</a>
					</div>
					<div class="goodsOneText">
						<div><%=freeGoods.getTshirtName()%></div>
						<div class="btn disabled"><font style="text-decoration:line-through;">￥<%=freeGoods.getNowprice()%></font></div>
						<div class="red">￥<%=freeGoods.getFreeprice()%></div>
						<div>
							<a href="GoodsServlet.do?method=selectGoodsByGoodsId&goodsId=<%=freeGoods.getGoodsId()%>&sign=fg">
							<img src="images/detail.png" width="25" height="25"/>
							</a>	
						</div>
					</div>
				</div>
			<%
				}
			 %>
				<div class="clear"></div>
			</div>
		</div>
		<div id="goodsNew">
			<div class="iconNew">
				<a href="GoodsServlet.do?method=selectGoodsByMark&mark=0">
					<img src="images/more_2.png" width="25" height="25" style="text-decoration: none;" />更多
				</a>
			</div>
			<hr />
			<div class="goodsNew">
			<%
					//一行仅能显示6件商品。
					int now=0;
					int num2=0;
					if(nowList.size()<=6)
						{
							now=nowList.size();
							num2=0;
						}else{
							now=nowList.size();
							num2=now-6;
						}
							for(int i=num2;i<now;i++)
						{
							Goods nowGoods=(Goods)nowList.get(i);
				%>
				<div class="goodsOne">
					<div class="goodsOneImg">
						<a href="GoodsServlet.do?method=selectGoodsByGoodsId&goodsId=<%=nowGoods.getGoodsId()%>&sign=fg">
							<img src="<%=nowGoods.getPicture()%>" width="140" height="200" />
						</a>
					</div>
					<div class="goodsOneText">
						<div><%=nowGoods.getTshirtName()%></div>
						<div>￥<%=nowGoods.getNowprice()%></div>
						<div>
							<a href="GoodsServlet.do?method=selectGoodsByGoodsId&goodsId=<%=nowGoods.getGoodsId()%>&sign=fg">
								<img src="images/detail.png" width="25" height="25" />
							</a>
						</div>
					</div>
				</div>
				<%
					}
				 %>
				<div class="clear"></div>
			</div>
		</div>
	</div>
</body>
</html>
