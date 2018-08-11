<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.py.vo.Leavewords"%>
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
	function deleteType(date) {
		if (confirm("确定要删除吗？")) {
			window.location.href = "LeavewordsServlet.do?method=deleteLeavewordsById&id=" + date;
		}
	}
</script>
</head>
<%
@SuppressWarnings("unchecked") 
List<Leavewords> list=(List<Leavewords>)request.getAttribute("list");
int number=Integer.parseInt((String)request.getAttribute("number"));
int maxPage=Integer.parseInt((String)request.getAttribute("maxPage"));
int pageNumber=Integer.parseInt((String)request.getAttribute("pageNumber"));
int start=number*10;//开始条数
int over=(number+1)*10;//结束条数
int count=pageNumber-over;//还剩多少条记录
if(count<=0){
  over=pageNumber;
}
%>
<body>
	<jsp:include page="bg-up.jsp" flush="true"></jsp:include>
	<div id="bgMain">
		<jsp:include page="bg-left.jsp" flush="true"></jsp:include>
		<div id="bgRight">
			<div class="bgRightText font30" style="font-family:黑体">用户留言信息查询</div>
			<div class="bgRightTable">
				<table class="tableBorder" style="width:80%">
						<tr style="background-color:#CCCCCC">
							<td style="width:10%">编号</td>
							<td style="width:20%">用户账号</td>
							<td style="width:20%">商品编号</td>
							<td style="width:25%">留言标题</td>
							<td style="width:25%">操作</td>
						</tr>
						<%
							for (int i = start; i < over; i++) {
								Leavewords leavewords = (Leavewords) list.get(i);
						%>
						<tr>
							<td><%=i + 1%></td>
							<td><%=leavewords.getAccount()%></td>
							<td><%=leavewords.getGoodsId()%></td>
							<td><%=leavewords.getTitle()%></td>
							<td><a href="LeavewordsServlet.do?method=selectLeavewordsById&id=<%=leavewords.getId()%>">详细信息</a>&nbsp;&nbsp;
								<a href="javascript:deleteType('<%=leavewords.getId()%>')">删除</a>
							</td>
						</tr>
						<%
							}
						%>
					</table>
			</div>
					<div class="page">
					<div class="pageOne">
						共为<%=maxPage%>页
					</div>
					<div class="pageOne">
						共有<%=pageNumber%>条记录
					</div>
					<div class="pageOne">
						当前为第<%=number + 1%>页
					</div>
					<%
						if ((number + 1) == 1) {
					%>
					<div class="pageOne">上一页</div>
					<%
						} else {
					%>
					<div class="pageOne">
						<a href="LeavewordsServlet.do?method=selectLeavewords&i=<%=number-1%>">上一页</a>
					</div>
					<%
						}
					%>
					<%
						if (maxPage <= (number + 1)) {
					%>
					<div class="pageOne">下一页</div>
					<%
						} else {
					%>
					<div class="pageOne">
						<a href="LeavewordsServlet.do?method=selectLeavewords&i=<%=number+1%>">下一页</a>
					</div>
					<%
						}
					%>
					
				</div>
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
