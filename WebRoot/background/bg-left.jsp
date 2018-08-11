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
	function quit() {
		if (confirm("确定要退出后台吗？")) {
			window.location.href = "ManagerServlet.do?method=logoutManager";
		}
	}
</script>
</head>
<%
	Manager manager = (Manager) session.getAttribute("manager");
%>
<body>
	<div id="bgLeft">
		<img src="images/bg_left1.jpg" width="200" height="60" />
		<%
			if (manager.getSign() == 1||manager.getSign() == 0) {
		%>
		<div class="leftBox">
			<div class="leftBoxText">
				<a href="GoodsServlet.do?method=selectGoods" >商品设置</a>
			</div>
			<div class="leftBoxText">
				<font color="#FFFFFF">Goods Manage</font>
			</div>
		</div>
		<div class="leftBox">
			<div class="leftBoxText">
				<a href="SortServlet.do?method=selectSort" >类别设置</a>
			</div>
			<div class="leftBoxText">
				<font color="#FFFFFF">Sort Manage</font>
			</div>
		</div>
		<%
			}
		 %>
		<%
			if (manager.getSign() == 2||manager.getSign() == 0) {
		%>
		<div class="leftBox">
			<div class="leftBoxText">
				<a href="MemberServlet.do?method=selectMember">会员设置</a>
			</div>
			<div class="leftBoxText">
				<font color="#FFFFFF">Member Manage</font>
			</div>
		</div>
		<div class="leftBox">
			<div class="leftBoxText">
				<a href="LeavewordsServlet.do?method=selectLeavewords">用户留言设置</a>
			</div>
			<div class="leftBoxText">
				<font color="#FFFFFF">Leavewords Manage</font>
			</div>
		</div>
		<%
			}
		 %>
		<%
			if (manager.getSign() == 0) {
		%>
		<div class="leftBox">
			<div class="leftBoxText">
				<a href="ManagerServlet.do?method=selectManager">管理员设置</a>
			</div>
			<div class="leftBoxText">
				<font color="#FFFFFF">Admin Manage</font>
			</div>
		</div>
		<%
			} else {
		%>
		<div class="leftBox">
			<div class="leftBoxText">
				<a href="background/bg-managerUpdate.jsp">修改管理员信息</a>
			</div>
			<div class="leftBoxText">
				<font color="#FFFFFF">Amend Admin</font>
			</div>
		</div>
		<%
			}
		%>
		<%
			if (manager.getSign() == 3||manager.getSign() == 0) {
		%>
		<div class="leftBox">
			<div class="leftBoxText">
				<a href="OrderServlet.do?method=selectOrder">订单设置</a>
			</div>
			<div class="leftBoxText">
				<font color="#FFFFFF">Order Manage</font>
			</div>
		</div>
		<div class="leftBox">
			<div class="leftBoxText">
				<a href="background/bg-orderCount.jsp">订单规划</a>
			</div>
			<div class="leftBoxText">
				<font color="#FFFFFF">Order Count</font>
			</div>
		</div>
		<%
			}
		 %>
		<div class="leftBox">
			<div class="leftBoxText">
				<a href="AfficheServlet.do?method=selectAffiche&sign=bg">公告设置</a>
			</div>
			<div class="leftBoxText">
				<font color="#FFFFFF">Affiche Manage</font>
			</div>
		</div>
		<div class="leftBox">
			<div class="leftBoxText">
				<a href="LinkServlet.do?method=selectLink">友情链接设置</a>
			</div>
			<div class="leftBoxText">
				<font color="#FFFFFF">Link Manage</font>
			</div>
		</div>
		<div class="leftBox">
			<div class="leftBoxText">
				<a href="javascript:quit()" >安全退出</a>
			</div>
			<div class="leftBoxText">
				<font color="#FFFFFF">Save Quit</font>
			</div>
		</div>
	</div>
</body>
</html>
