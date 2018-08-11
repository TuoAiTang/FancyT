<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
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
function deleteManager(date) {
  if(confirm("确定要删除吗？")){
    window.location="ManagerServlet.do?method=deleteManagerByAccount&account="+date;
	}
  }
</script>
</head>
<%
@SuppressWarnings("unchecked") 
List<Manager> list=(List<Manager>)request.getAttribute("list");
Manager manager=(Manager)session.getAttribute("manager");
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
			<div class="bgRightText font30" style="font-family:黑体">管理员信息查询</div>
			<div class="bgRightTable">
				<table class="tableBorder" style="width:80%">
						<tr style="background-color:#CCCCCC">
							<td style="width:20%">编号</td>
							<td style="width:20%">管理员账号</td>
							<td style="width:20%">真实姓名</td>
							<td style="width:20%">联系方式</td>
							<td style="width:20%">操作</td>
						</tr>
						<%for(int i=start;i<over;i++){
          					manager=(Manager)list.get(i);
          				%>
						<tr>
							<td><%=i+1%></td>
							<td><%=manager.getAccount()%></td>
							<td><%=manager.getReallyName()%></td>
							<td><%=manager.getTel()%></td>
							<td>
								<%if(manager.getSign()!=0){ %>
									<a href="javascript:deleteManager('<%=manager.getAccount()%>')">删除</a>
								<%
								  }else{
								%>
									主管理员&nbsp;<a href="background/bg-managerUpdate.jsp">修改</a>
								<%}%>
							</td>
						</tr>
						<%}%>
				</table>
				<img src="images/bg_add.gif" width="9" height="9"/>
				<a href="background/bg-managerInsert.jsp">&nbsp;添加后台管理员&nbsp;</a>
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
						<a href="ManagerServlet.do?method=selectManager&i=<%=number-1%>">上一页</a>
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
						<a href="ManagerServlet.do?method=selectManager&i=<%=number+1%>">下一页</a>
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
