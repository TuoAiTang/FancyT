<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.py.vo.Manager"%>
<jsp:useBean id="countTime" scope="request" class="com.py.tool.CountTime" />
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
		if (session.getAttribute("manager") == null) {
			out.print("<script type='text/javascript'>alert('您已经与服务器断开连接，请重新登录！');window.location.href='bg-login.jsp';</script>");
		} else {
			Manager manager = (Manager) session.getAttribute("manager");
	%>
	<div id="up">
		<div class="upText1">
			<font color="#000000">电子商务网站后台管理</font>
		</div>
		<div class="upText2">
			<font color="#FFFFFF">当前登录：<%=manager.getAccount()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>
		</div>
	</div>
	<%
		}
	%>
</body>
</html>
