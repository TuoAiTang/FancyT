<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.py.vo.Member"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<base href="<%=basePath%>"/>
<title>FancyT,潮流t，上ft</title>
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
return true;
}
</script>
<script>
var xmlhttp1;
function check(){
  var account = document.getElementById("account").value;
  var url = "MemberServlet.do?method=checkMemberAccount&sign=login&account="+account;
 
  xmlhttp1 =new XMLHttpRequest();
  xmlhttp1.onreadystatechange=checkResult_1; //响应函数
  xmlhttp1.open("POST",url,true);   //设置访问的页面
  xmlhttp1.send(null);  //执行访问
}
 
function checkResult_1(){
  if (xmlhttp1.readyState==4 && xmlhttp1.status==200)
    document.getElementById('checkResult').innerHTML=xmlhttp1.responseText;
  
}
 
</script>
</head>

<body>
	<jsp:include page="fg-header.jsp" flush="true" />
	<jsp:include page="fg-nav.jsp" flush="true" />
	<div id="main">
		<div class="iconLogin"></div>
		<hr />
		<div class="fgLogo">
			<img src="images/logo_up.png" width="122"
				height="40" />
		</div>
		<br>
		<form name="memberForm" method="post"
			action="MemberServlet.do?method=selectMemberLogin"
			onsubmit="return validate(this)">
			<div class="fgForm">
				<div class="fgInput" style="margin-top: 5px">
				<span id="checkResult"></span>
				</div>
				<div class="fgInput">
					<span class="input3Text">用户名：</span><input class="form-control" id="account" onkeyup="check()"
						name="account" type="text" style="display: inline; width:180px;height:30px" />
				</div>
				<div class="fgInput">
					<span class="input3Text">密码：</span><input
						class="form-control" name="password" type="password" style="display: inline; width:180px;height:30px"/>
				</div>
				<div class="fgInput">
					<input type="image" src="images/get_fancy_long.png"
						style="width:240px; height:30px;" /><br/>
				</div>
				<div class="fgInput">
					<a href="fg-memberRegister.jsp"><img src="images/sign_up_long.png" style="width:240px; height:30px;"></a>
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
