<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.py.vo.Member"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<title>FancyT,潮流t，上ft</title>>
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
if(!/^[a-zA-Z0-9_-]{6,16}$/.test(form.password.value)){
alert("密码由6-16位字符组成");
return false;
}
if(form.passwordOld.value!=form.oldPassword.value){
alert("原密码错误");
return false;
}
if(form.password.value!=form.passwordOne.value){
alert("您两次输入的密码不一致，请重新输入");
return false;
}
if(!/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/.test(form.email.value)){
alert("邮箱格式不正确，请输入正确格式，如：123456789@123.com");
return false;
}
if(!/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/.test(form.tel.value)){
alert("手机号码格式错误");
return false;
}
if(!/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(form.idCard.value)){
alert("请入正确身份证号码");
return false;
}
return true;
}
</script>
</head>

<body>
	<jsp:include page="fg-header.jsp" flush="true" />
	<jsp:include page="fg-nav.jsp" flush="true" />
	<div id="main">
		<div class="iconUpdate"></div>
		<hr/>
		<div class="fgLogo">
			<img src="images/logo_up.png" width="122"
				height="40" />
		</div>
		<%
			Member member = null;
  			if(session.getAttribute("member")!=null){
  				member = (Member)session.getAttribute("member");
    		}
		%>
		<form name="memberForm" method="post" action="MemberServlet.do?method=updateMember"
			onsubmit="return validate(this)">
			<div class="fgForm">
				<div class="fgInput">				
					<span class="input3Text">会员账号：</span><input class="form-control" name="account" type="text" value="<%=member.getAccount()%>" disabled="disabled"  style="display: inline; width:180px;height:30px"/>
					<input type="hidden" name="account" value="<%=member.getAccount()%>" />
				</div>
				<div class="fgInput">
					<input type="hidden" name="passwordOld" value="<%=member.getPassword()%>"/>
					<span class="input3Text">原密码：</span><input class="form-control" name="oldPassword" type="password"  style="display: inline; width:180px;height:30px"/>
				</div>
				<div class="fgInput">
					<span class="input3Text">新密码：</span><input class="form-control" name="password" type="password"   style="display: inline; width:180px;height:30px"/>
				</div>
				<div class="fgInput">
					<span class="input3Text">密码确认：</span><input class="form-control" name="passwordOne" type="password"  style="display: inline; width:180px;height:30px"/>
				</div>
				<div class="fgInput">
					<span class="input3Text">真实姓名：</span><input class="form-control" name="reallyName" type="text" value="<%=member.getReallyName()%>"  style="display: inline; width:180px;height:30px" />
				</div>
				<div class="fgInput">
					<span class="input3Text">Email：</span><input class="form-control" name="email" type="text" value="<%=member.getEmail()%>"  style="display: inline; width:180px;height:30px"/>
				</div>
				<div class="fgInput">
					<span class="input3Text">手机号码：</span><input class="form-control" name="tel" type="text" value="<%=member.getTel()%>"  style="display: inline; width:180px;height:30px"/>
				</div>
				<div class="fgInput">
					<span class="input3Text">身份证号：</span><input class="form-control" name="idCard" type="text" value="<%=member.getIdCard()%>"  style="display: inline; width:180px;height:30px" />
				</div>
				<div class="fgInput">
					<input type="submit" class="btn btn-danger" value="提交" />
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="fg-footer.jsp" flush="true" />
	<%
		String result = (String) request.getAttribute("result");
		if (result!=null) {	
 	%>
 		<script>alert('<%=result%>');</script>		
 	<%
 		}
  	 %>	
</body>
</html>
