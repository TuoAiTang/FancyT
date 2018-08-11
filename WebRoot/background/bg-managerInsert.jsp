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
if(!/^[a-z0-9]+$/.test(form.account.value)){
alert("请输入有数字和小写字母组成的用户名");
return false;
}
if(!/^[a-zA-Z0-9_-]{6,16}$/.test(form.password.value)){
alert("密码由6-16位字符组成");
return false;
}
if(form.password.value!=form.passwordOne.value){
alert("您两次输入的密码不一致，请重新输入");
return false;
}
if(!/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/.test(form.tel.value)){
alert("手机号码格式错误");
return false;
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
			<div class="bgRightText font30" style="font-family:黑体">添加管理员信息</div>
			<form action="ManagerServlet.do?method=insertManager" method="post"  name="managerForm" onsubmit="return validate(this)">
			<div class="bgRightForm">
				<div class="bgInput">
					<span class="input5Text">用户名：</span><input class="input5" name="account" type="text"/>
				</div>
				<div class="bgInput">
					<span class="input5Text">密码：</span><input class="input5" name="password" type="password"/>
				</div>
				<div class="bgInput">
					<span class="input5Text">密码验证：</span><input class="input5" name="passwordOne" type="password"/>
				</div>
				<div class="bgInput">
					<span class="input5Text">姓名：</span><input class="input5" name="reallyName" type="text"/>
				</div>
				<div class="bgInput">
					<span class="input5Text">电话：</span><input class="input5" name="tel" type="text"/>
				</div>
				<div class="bgInput">
					<span class="input5Text">类型：</span>
					<select class="input5" name="sign">
					<option value="">-------------请选择-------------</option>
					<option value="1">商品管理员</option>
					<option value="2">会员管理员</option>
					<option value="3">订单管理员</option>
					</select>
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
