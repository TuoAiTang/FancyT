<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.py.vo.Leavewords"%>
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
<%
Leavewords leavewords=(Leavewords)request.getAttribute("leavewords");

%>
<body>
	<jsp:include page="bg-up.jsp" flush="true"></jsp:include>
	<div id="bgMain">
		<jsp:include page="bg-left.jsp" flush="true"></jsp:include>
		<div id="bgRight">
			<div class="bgRightText font30" style="font-family:黑体">用户留言信息详细查询</div>
			<div class="bgRightTable">
				<table class="tableBorder" style="width:50%;">
						<tr>
							<td style="width:50%; background-color:#CCC">用户账号</td><td style="width:50%"><%=leavewords.getAccount()%></td>
						</tr>
						<tr>
							<td style="background-color:#CCC">商品编号</td><td><%=leavewords.getGoodsId()%></td>
						</tr>
						<tr>
							<td style="background-color:#CCC">留言标题</td><td><%=leavewords.getTitle()%></td>						
						</tr>
						<tr>
							<td style="background-color:#CCC">留言时间</td><td><%=leavewords.getCreaTime()%></td>						
						</tr>										
				</table>
				<div class="textarea2"><%=leavewords.getContent() %></div>
				<a href="javascript:history.back();">返回</a>
			</div>	
		</div>
		<div class="clear"></div>
	</div>
	<jsp:include page="bg-down.jsp" flush="true"></jsp:include>
</body>
</html>
