<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.py.vo.Sort"%>
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
			window.location = "SortServlet.do?method=deleteSortBySortId&sortId=" + date;
		}
	}
</script>
</head>
<%
@SuppressWarnings("unchecked") 
List<Sort> list=(List<Sort>)request.getAttribute("list");
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
			<div class="bgRightText font30" style="font-family:黑体">商品类别信息查询</div>
			<div class="bgRightTable">
				<table class="tableBorder" style="width:80%">
						<tr style="background-color:#CCCCCC">
							<td style="width:33%">编号</td>
							<td style="width:34%">类别名称</td>
							<td style="width:33%">操作</td>
						</tr>
						<%
							for (int i = start; i < over; i++) {
								Sort sort = (Sort) list.get(i);
						%>
						<tr>
							<td><%=i + 1%></td>
							<td><%=sort.getSortName()%></td>
							<td><a href="javascript:deleteType('<%=sort.getSortId()%>')">删除</a>
							</td>
						</tr>
						<%
							}
						%>
					</table>
				<img src="images/bg_add.gif" width="9" height="9"/>
				<a href="background/bg-sortInsert.jsp">&nbsp;添加商品类别&nbsp;</a>
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
						<a href="SortServlet.do?method=selectSort&i=<%=number-1%>">上一页</a>
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
						<a href="SortServlet.do?method=selectSort&i=<%=number+1%>">下一页</a>
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
