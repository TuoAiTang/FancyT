<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
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
function validate(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("表单信息不能为空");
form.elements[i].focus();
return false;
}
}
return true;
}
</script>
</head>
<body>
	<jsp:include page="bg-up.jsp" flush="true"></jsp:include>
	<div id="bgMain">
		<jsp:include page="bg-left.jsp" flush="true"></jsp:include>
		<div id="bgRight">
			<div class="bgRightText font30" style="font-family:黑体">添加公告信息</div>
			<form action="AfficheServlet.do?method=insertAffiche" method="post"  name="afficheForm" onsubmit="return validate(this)">
			<div class="bgRightForm">
				<div class="bgInput">
					<span class="input5Text">公告标题</span><input class="input5" name="affiche" type="text"/>
				</div>
				<div class="bgInput">
					<textarea name="content" class="textarea3"></textarea>
				</div>
				<div class="bgInput">
					<input type="image" src="images/save.jpg" style="width:51px; height:20px"/>
				</div>
			</div>
			</form>
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
