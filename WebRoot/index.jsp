<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<title>FancyT</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel = "icon"  href="/shop.ico" type="image/x-icon">
<link rel = "shortcut icon"  href="/shop.ico" type="image/x-icon">
</head>
<body>
	<jsp:include page="fg-header.jsp" flush="true" />
	<jsp:include page="fg-nav.jsp" flush="true" />
	<jsp:include page="fg-banner.jsp" flush="true" />
	<div id="main">
		<jsp:include page="fg-sort.jsp" flush="true" />
		<jsp:include page="fg-goods.jsp" flush="true" />
	</div>
	<jsp:include page="fg-footer.jsp" flush="true" />
</body>
</html>
