<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.py.vo.Manager"%>
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
if(form.selectPassword.value!=form.old.value){
alert("您输入原密码不正确，请重新输入");
return false;
}
if(!/^[a-zA-Z0-9_-]{6,16}$/.test(form.password.value)){
alert("密码由6-16位字符组成");
return false;
}
if(form.password.value!=form.passwordNext.value){
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
<%
Manager manager=(Manager)session.getAttribute("manager");
%>
<body>
	<jsp:include page="bg-up.jsp" flush="true"></jsp:include>
	<div id="bgMain">
		<jsp:include page="bg-left.jsp" flush="true"></jsp:include>
		<div id="bgRight">
			<div class="bgRightText font30" style="font-family:黑体">修改管理员信息</div>
			<form action="ManagerServlet.do?method=updateManager" method="post"  name="managerForm" onsubmit="return validate(this)">
			<div class="bgRightForm">
				<div class="bgInput">
					<span class="input5Text">账号：</span><input class="input5" name="account" type="text" value="<%=manager.getAccount()%>" disabled="disabled"/>
					<input name="account" type="hidden"  value="<%=manager.getAccount()%>"/>
				</div>
				<div class="bgInput">
					<span class="input5Text">原密码：</span><input class="input5" name="old" type="password"/>
					<input name="selectPassword" type="hidden"  value="<%=manager.getPassword()%>"/>
				</div>
				<div class="bgInput">
					<span class="input5Text">新密码：</span><input class="input5" name="password" type="password"/>
				</div>
				<div class="bgInput">
					<span class="input5Text">新密码确认：</span><input class="input5" name="passwordNext" type="password"/>
				</div>
				<div class="bgInput">
					<span class="input5Text">真实姓名：</span><input class="input5" name="reallyName" type="text" value="<%=manager.getReallyName()%>"/>
				</div>
				<div class="bgInput">
					<span class="input5Text">电&nbsp;话：</span><input class="input5" name="tel" type="text" value="<%=manager.getTel()%>"/>
					<input name="sign" type="hidden"  value="<%=manager.getSign()%>"/>
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
