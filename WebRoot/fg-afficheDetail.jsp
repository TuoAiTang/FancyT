<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.py.vo.Affiche"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<title>电子商务网站</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<%
Affiche affiche=(Affiche)request.getAttribute("affiche");

%>
<body>
	<jsp:include page="fg-header.jsp" flush="true" />
	<jsp:include page="fg-nav.jsp" flush="true" />
	<div id="main">
		<div class="iconAffiche"></div>
		<hr />
		<div class="afficheDetail">
			<div class="afficheDetailTitle font24" style="color:red"><%=affiche.getAffiche()%></div>
			<div class="afficheDetailCreaTime"><%=affiche.getCreaTime().toString().substring(0,19)%></div>
			<textarea class="form-control" style="width:600px; height:300px; margin:0 auto;">
			<%=affiche.getContent()%></textarea>
		</div>
	</div>
	<jsp:include page="fg-footer.jsp" flush="true" />
</body>
</html>
