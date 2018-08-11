<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.py.vo.Manager"%>
<%@ page import="com.py.tool.CountTime" %>
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

<body>
	<%
		CountTime counttime = new CountTime();
	 %>
	<%
		if (session.getAttribute("manager") == null) {
			out.print("<script>alert('您已经与服务器断开连接，请重新登录！');window.location.href='bg-managerLogin.jsp';</script>");
		} else{
			Manager manager = (Manager) session.getAttribute("manager");
			int sign = manager.getSign();
			String managerSort = null;
			if(sign==0){
				managerSort = "总管理员";
			}else if(sign==1){
				managerSort = "商品管理员";
			}else if(sign==2){
				managerSort = "用户管理员";
			}else if(sign==3){
				managerSort = "订单管理员";
			}
	%>
	<div id="bgUp">
		<div class="upText1">
			<font class="white font24 bold">电子商务网站后台管理</font>
		</div>
		<div class="upText2">
			<font color="#FFFFFF">当前登录：<%=manager.getAccount()%>&nbsp;&nbsp;<%=managerSort%>&nbsp;&nbsp;&nbsp;今天是<%=counttime.currentlyTime()%></font>
		</div>
	</div>
	<%
		}
	%>
</body>
</html>
