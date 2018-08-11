<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.py.vo.Member"%>
<%@ page import="com.py.vo.Order"%>
<%@ page import="com.py.vo.OrderDetail"%>
<%@ page import="com.py.factory.DAOFactory" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<title>FancyT,潮流t，上ft</title>itle>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<%
	Member member = (Member)session.getAttribute("member");
	List<Order>orderList = DAOFactory.getOrderDAOInstance().selectOrderByAccount(member.getAccount());
%>
<body>
	<jsp:include page="fg-header.jsp" flush="true" />
	<jsp:include page="fg-nav.jsp" flush="true" />
	<div id="main">
		<div class="iconOrder"></div>		
		<hr/>
		<br/>		
		<div class="fgForm">
			<div class="fgText">
				<strong>订单查看</strong>
			</div>
			<%
				if(orderList.size()==0){
			%>
			<div class="fgText">没有订货信息</div>
			<%
				}else{
			%>
			<table class="table table-hover" width="80">
				<thead>
					<th style="width:20%; height:21px">订单编号</th>
					<th style="width:15%">电话</th>
					<th style="width:20%">地址</th>

					<th style="width:20%">订货时间</th>
					<th style="width:10%">出货</th>
					<th style="width:15%">操作</th>
				</thead>
				<tbody>
				<%
					for(int orderNumber=0;orderNumber<orderList.size();orderNumber++){
						Order order=(Order)orderList.get(orderNumber);
				%>
				
				<tr style="background-color:#FFFFFF">
					<td style="height:24px;"><%=order.getOrderId()%></td>

					<td><%=order.getTel()%></td>
					<td><%=order.getAddress()%></td>

					<td><%=order.getCreaTime().toString().substring(0,19)%></td>
					<td>
						<%
							if(order.getSign()==0){
						%>否<%
							}else{
						%>是<%
							}
						%>
					</td>
					<td><a href="fg-orderDetail.jsp?orderId=<%=order.getOrderId()%>">查看明细</a>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
			</table>
			<br/>
			<%
				if(request.getParameter("orderId")!=null){
			%>
			<div class="fgText">
				<strong>订单明细</strong>
			</div>
			<table class="table table-hover" width="80">
				<thead>
					<td style="width:25%; height:21px">订单编号</td>
					<td style="width:25%">商品名称</td>
					<td style="width:25%">商品价格</td>
					<td style="width:25%">商品数量</td>
				</thead>
				<tbody>
					<%
					float sum=0;
					List<OrderDetail> orderDetailList=DAOFactory.getOrderDetailDAOInstance().selectOrderDetailByOrderId(request.getParameter("orderId"));
					for(int orderDetailNumber=0;orderDetailNumber<orderDetailList.size();orderDetailNumber++){
						OrderDetail orderDetail=(OrderDetail)orderDetailList.get(orderDetailNumber);
						sum=sum+orderDetail.getPrice()*orderDetail.getNumber();
				%>
				<tr>
					<td style="height:21px"><%=orderDetail.getOrderId()%></td>
					<td><%=DAOFactory.getGoodsDAOInstance().selectGoodsByGoodsId(orderDetail.getGoodsId()).getTshirtName()%></td>
					<td><%=orderDetail.getPrice()%>元</td>
					<td><%=orderDetail.getNumber()%></td>
				</tr>
				<%
					}
				%>
				</tbody>
				
			</table>
			<div class="fgText">
				Total：￥<%=sum%>
			</div>
			<%
				}
			%>
			<%
				}
			%>
		</div>
		</div>
	<jsp:include page="fg-footer.jsp" flush="true" />
</body>
</html>
