<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.py.vo.Manager"%>
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
<script>
function validate(form){
if(document.form.account.value==""){
alert("请输入管理员账号");
form.account.focus();
return false;
}
if(document.form.password.value==""){
alert("请输入管理员密码");
form.password.focus();
return false;
}
if(!/^[a-z0-9]+$/.test(form.account.value)){
alert("请输入由数字和小写字母组成的用户名");
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

<body class="nobg">
	<div class="bgLogin">
		<form name="managerForm" method="post"
			action="ManagerServlet.do?method=selectManagerLogin"
			onsubmit="return validate(this)">
			<div class="bgloginForm">
				<span class="input4Text yellow bold">用户名：</span><input
					class="input4" name="account" type="text" /> <span
					class="input4Text yellow bold">密码：</span><input class="input4"
					name="password" type="password" /> <input name="Submit"
					class="input4Img" type="image" src="images/bg_login.gif" />
			</div>
		</form>
	</div>
	<%
		String result = (String) request.getAttribute("result");
		if (result != null) {
	%>
	<script>alert('<%=result%>');</script>
	<%
		}
	%>
</body>
</html>
