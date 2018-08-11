<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.py.vo.Sort"%>
<%@ page import="com.py.factory.DAOFactory"%>
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
</head>
<%
	List<Sort> sortList= DAOFactory.getSortDAOInstance().selectSort();
%>
<body>
<div id="sort">
    	<ul>
    	<%
			for(int i=0;i<sortList.size();i++){
			     Sort sort=(Sort)sortList.get(i);
		 %>
        	<li><a class="a3" href="GoodsServlet.do?method=selectGoodsBySortId&sortId=<%=sort.getSortId()%>"
                style="text-decoration: none" ><%=sort.getSortName()%></a></li>
        <%
        	}
         %>
        </ul>
</div>
</body>
</html>
