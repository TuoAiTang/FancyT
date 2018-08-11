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
	<div id="bgDown" class="lightgrey font12">
		版权所有：电子商务与快递物流综合信息技术实训平台<br/>
    	Copyright&copy;All Rights Reserved<br/>
   		邮编：100876
	</div>
</body>
</html>
