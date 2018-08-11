<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.py.vo.Order"%>
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
<script>
 function deleteOrder(date) {
  if(confirm("确定要删除吗？")){
    window.location="OrderServlet.do?method=deleteOrderByOrderId&orderId="+date;
	}
  }
</script>
</head>
<%
@SuppressWarnings("unchecked") 
List<Order> list=(List<Order>)request.getAttribute("list");
int number=Integer.parseInt((String)request.getAttribute("number"));
int maxPage=Integer.parseInt((String)request.getAttribute("maxPage"));
int pageNumber=Integer.parseInt((String)request.getAttribute("pageNumber"));
int start=number*10;//开始条数
int over=(number+1)*10;//结束条数
int count=pageNumber-over;//还剩多少条记录
if(count<=0){
  over=pageNumber;
}
%>
<body>
	<jsp:include page="bg-up.jsp" flush="true"></jsp:include>
	<div id="bgMain">
		<jsp:include page="bg-left.jsp" flush="true"></jsp:include>
		<div id="bgRight">
			<div class="bgRightText font30" style="font-family:黑体">订单信息查询</div>
			<div class="bgRightTable">
				<table class="tableBorder" style="width:99%">
						<tr style="background-color:#CCCCCC">
							<td style="width:5%">编号</td>
          					<td style="width:20%">订单编号</td>
          					<td style="width:11%">会员账号</td>
          					<td style="width:20%">送货地址</td>
         					<td style="width:5%">是否出货</td>
        					<td style="width:10%">订货时间</td>
   							<td style="width:20%">操作</td>
						</tr>
						<%
							for (int i = start; i < over; i++) {
								Order order=(Order)list.get(i);
						%>
						<tr>
							<td style="height:30px"><%=i+1%></td>
							<td><%=order.getOrderId()%></td>
							<td><%=order.getAccount()%></td>
							<td><%=order.getAddress()%></td>
							<td>
								<%if(order.getSign()==0){%>
                    				否
             					<%}else{%>
                    				是
          						<%}%>
							</td>
							<td><%=order.getCreaTime().toString().substring(0,19)%></td>
							<td>
								<a href="OrderServlet.do?method=selectOrderDetailByOrderId&orderId=<%=order.getOrderId()%>">详细信息</a>                           
	     						<%if(order.getSign()==1){%>
									 已出
		 						<%
									}else{
								%>
		  						<a href="OrderServlet.do?method=updateOrderSign&orderId=<%=order.getOrderId()%>">出货</a>
		 						<%}%>
		 						<a href="javascript:deleteOrder('<%=order.getOrderId()%>')">删除</a>
							</td>
						</tr>
						<%
							}
						%>
					</table>
			</div>
					<div class="page">
					<div class="pageOne">
						共为<%=maxPage%>页
					</div>
					<div class="pageOne">
						共有<%=pageNumber%>条记录
					</div>
					<div class="pageOne">
						当前为第<%=number + 1%>页
					</div>
					<%
						if ((number + 1) == 1) {
					%>
					<div class="pageOne">上一页</div>
					<%
						} else {
					%>
					<div class="pageOne">
						<a href="OrderServlet.do?method=selectOrder&i=<%=number-1%>">上一页</a>
					</div>
					<%
						}
					%>
					<%
						if (maxPage <= (number + 1)) {
					%>
					<div class="pageOne">下一页</div>
					<%
						} else {
					%>
					<div class="pageOne">
						<a href="OrderServlet.do?method=selectOrder&i=<%=number+1%>">下一页</a>
					</div>
					<%
						}
					%>
					
				</div>
			<%
				String result = (String) request.getAttribute("result");
				if (result!=null) {	
 			%>
 				<div class="bgRightText font24 red"><%=result %></div>
 			<%
 				}
 			%>
		</div>
		<div class="clear"></div>
	</div>
	<jsp:include page="bg-down.jsp" flush="true"></jsp:include>
</body>
</html>
