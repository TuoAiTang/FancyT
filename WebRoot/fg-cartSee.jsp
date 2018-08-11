<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.py.vo.SellGoods"%>
<%@ page import="com.py.factory.DAOFactory"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<title>电子商务网站</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<jsp:include page="fg-header.jsp" flush="true" />
	<jsp:include page="fg-nav.jsp" flush="true" />
	<div id="main">
		<div class="iconCart"></div>
		<hr />
		<br />
		<%
			if(session.getAttribute("cart")==null){
		%>
		<div class="cart">
			<div class="cartNo">您还没有购物！！！</div>
		</div>
		<%
			}else{
		%>
		<form method="post" action="CartServlet.do?method=cartModify"
			name="form">
			<div class="cart">
				<div class="cartText1">序号</div>
				<div class="cartText1">商品的名称</div>
				<div class="cartText1">商品价格</div>
				<div class="cartText1">商品数量</div>
				<div class="cartText1">总金额</div>
				<div class="clear"></div>
				<%
					float sum=0;
				    	@SuppressWarnings("unchecked") 
				    	Vector<SellGoods> cart=(Vector<SellGoods>)session.getAttribute("cart");
				    	for(int i=0;i<cart.size();i++){
				       		SellGoods sellgoods=(SellGoods)cart.elementAt(i);
				       		sum=sum+sellgoods.number*sellgoods.price;
				       		System.out.print("sum="+sum);
				%>
		<script>
		function check(form){
		if(isNaN(form.num<%=i%>.value)
			||form.num<%=i%>.value==""||form.num<%=i%>.value==0||form.num<%=i%>.value<0) {
							alert("请输入正确数量");
							form.num<%=i%>.focus();
							return;
						}
			form.submit();
		}
		</script>
				<div class="cartText1"><%=i+1%></div>
				<div class="cartText1"><%=DAOFactory.getGoodsDAOInstance().selectGoodsByGoodsId(sellgoods.Id).getTshirtName()%></div>
				<div class="cartText1"><%=sellgoods.price%>元
				</div>
				<div class="cartText1">
					<input name="num<%=i%>" style="width:30px; height:30px; line-height:30px; text-align:center;" type="text"
						value="<%=sellgoods.number%>" onblur="check(this.form)" />
				</div>
				<div class="cartText1"><%=sellgoods.number*sellgoods.price%>元
				</div>
				<div class="clear"></div>
				<%
					}
				%>
				<div class="cartText2">
					合计总金额：￥<%=sum%></div>
				<div class="clear"></div>
				<div class="cartButtons">
					<div class="cartButton">
						<a href="CartServlet.do?method=cartClear"><img
							src="images/icon_cart_06.gif" />
						</a>
					</div>
					<div class="cartButton">
						<a href="fg-cartSee.jsp"><img src="images/icon_cart_07.gif" />
						</a>
					</div>
					<div class="cartButton">
						<a href="index.jsp"><img src="images/icon_cart_02.gif" />
						</a>
					</div>
					<div class="cartButton">
						<a href="fg-orderSubmit.jsp"><img
							src="images/icon_cart_03.gif" />
						</a>
					</div>
				</div>
				<%
					}
				%>
			</div>
		</form>
	</div>
	<jsp:include page="fg-footer.jsp" flush="true" />
</body>
</html>
