<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.py.vo.Member"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<title>电子商务网站</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<%
Member member=(Member)request.getAttribute("member");
%>
<body>
	<jsp:include page="bg-up.jsp" flush="true"></jsp:include>
	<div id="bgMain">
		<jsp:include page="bg-left.jsp" flush="true"></jsp:include>
		<div id="bgRight">
			<div class="bgRightText font30" style="font-family:黑体">会员信息查询</div>
			<div class="bgRightTable">
				<table class="tableBorder" style="width:50%;">
						<tr style="height:40px">
							<td style="width:50%; background-color:#CCC">会员账号</td><td style="width:50%"><%=member.getAccount()%></td>
						</tr>
						<tr style="height:40px">
							<td style="background-color:#CCC">会员姓名</td><td><%=member.getReallyName()%></td>
						</tr>
						<tr style="height:40px">
							<td style="background-color:#CCC">会员邮箱</td><td><%=member.getEmail()%></td>						
						</tr>
						<tr style="height:40px">
							<td style="background-color:#CCC">联系方式</td><td><%=member.getTel()%></td>						
						</tr>
						<tr style="height:40px">
							<td style="background-color:#CCC">身份证号</td><td><%=member.getIdCard()%></td>						
						</tr>						
				</table>
				<a href="javascript:history.back();">返回</a>
			</div>	
		</div>
		<div class="clear"></div>
	</div>
	<jsp:include page="bg-down.jsp" flush="true"></jsp:include>
</body>
</html>
