<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.py.vo.Affiche"%>
<%@ page import="com.py.factory.DAOFactory"%>
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
</head>
<%
@SuppressWarnings("unchecked") 
List<Affiche> list = (List<Affiche>) request.getAttribute("list");
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
	<jsp:include page="fg-header.jsp" flush="true" />
	<jsp:include page="fg-nav.jsp" flush="true" />
	<div id="main">
		<div class="iconAffiche"></div>
		<hr />		
		<%
			if(list.size()==0){
		%>
		<div class="afficheTableNo">无商城公告信息</div>
		<%
			}else{
		%>
		<div class="afficheTable">
		<ul>
			<%
				for (int i = start; i < over; i++) {
								Affiche affiche = (Affiche) list.get(i);
			%>
			<li><img src="images/hot.png" width="20" height="20" /><span style="color:red; font-size: 0.7em;">[公告]</span><a
				href="AfficheServlet.do?method=selectAfficheById&id=<%=affiche.getId()%>&sign=fg"><%=affiche.getAffiche()%>
				&nbsp;&nbsp;&nbsp;[<%=affiche.getCreaTime() %>]
				</a>
			</li>
			<%
				}
			%>
		</ul>
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
						<a href="AfficheServlet.do?method=selectAffiche&i=<%=number-1%>&sign=fg">上一页</a>
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
						<a href="AfficheServlet.do?method=selectAffiche&i=<%=number+1%>&sign=fg">下一页</a>
					</div>
					<%
						}
					%>	
			</div>
		<%
			}
		 %>
	</div>
	<jsp:include page="fg-footer.jsp" flush="true" />
</body>
</html>
