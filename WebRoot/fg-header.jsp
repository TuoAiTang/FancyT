<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.py.vo.Member"%>
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
<script src="js/jquery.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
<script>
	function quit() {
		if (confirm("没有要买的东西了吗？")) {
			window.location.href = "MemberServlet.do?method=logoutMember";
		}
	}
</script>
<script>
var xmlhttp;
function getLenovo(){
            var keyword = document.getElementById("keyword").value;
  			if(keyword != ""){

  				var url = "GoodsServlet.do?method=getLenovoByKeyword&keyword="+keyword;
 
				xmlhttp =new XMLHttpRequest();
				xmlhttp.onreadystatechange=checkResult; //响应函数
				xmlhttp.open("POST",url,true);   //设置访问的页面
				xmlhttp.send(null);  //执行访问
				$("#lns").show();
			}else{
				 document.getElementById('lns').innerHTML="";
                 $("#lns").hide();
			}             	
    }
function checkResult(){
  if (xmlhttp.readyState==4 && xmlhttp.status==200){

  	 document.getElementById('lns').innerHTML=xmlhttp.responseText;
  } 
}
</script>
<style type="text/css">
#lns {
            position:absolute;
            width:250px;
            margin-top: 55px;
            margin-left: 150px;
            z-index:999;
            display:none;
}

</style>
</head>
<body>
	<div id="header_unique">
		<div class="logo">
			<a href="index.jsp"><img src="images/logo.png" width="135"
				height="55" />
			</a>
		</div>
		<form name="form" method="post"
			action="GoodsServlet.do?method=selectByKeywords">
			<div class="search">
				<input type="text" id="keyword" class="form-control" onkeyup="getLenovo()"
				style="width:250px; height:30px;margin-top:10px; margin-left:150px;float:left;" name="keywords"/> 
				<div id="lns"></div>
				<input type="submit"
					class="btn btn-danger" style="width:50px; height:32px; margin-top:10px; margin-left:8px; float:left;" value="搜索">
			</div>
		</form>
		<%
			if (session.getAttribute("member") == null) {
		%>
		<div class="login">
			<a href="fg-memberLogin.jsp" style="width:80px; height:32px; margin-top:10px;color:white;flot:right"><span><img src="images/get_fancy.png" style="width:90px; height:40px margin-top:10px;"></span></a>
		</div>
		<%
			} else {
				Member member = (Member) session.getAttribute("member");
		%>
		<div class="login">
			<font class="red" style="font-size:1.2em;"><%=member.getAccount()%></font>，你好&nbsp;<span style="font-size:1.2em"><%=application.getAttribute("online_number")%></span><span style="font-size:0.3em">人在线&nbsp;</span><a
				href="javascript:quit()" style="text-decoration: none;" ><span><img src="images/logout.png" width="20" height="20"></span>退出</a>	
		</div>
		<%
			}
		%>
	</div>
</body>
</html>
