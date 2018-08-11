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
<body>
	<div id="banner">
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
  </ol>
 
  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <a href="http://www.uniqlo.cn/search.htm?spm=0.0.0.0.3aPL7H&scid=1361831233&scname=UyBTYW5kZXJzb24%3D&checkedRange=true&queryType=cat">
      <img src="images/b4.png" >
      </a>
    </div>
    <div class="item">
            <img src="images/b1.png" >
    </div>
    <div class="item">
            <img src="images/b2.png" >
    </div>
 
    <div class="item">
            <img src="images/b3.png" >
    </div>
 
  </div>
 
  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <img src="images/back.png" width="30px" height="30px" style="margin-top: 40px;margin-bottom: 20px; margin-right: 20px">
 
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <img src="images/more.png" width="30px" height="30px" style="margin-top: 40px;margin-bottom: 20px; margin-left: 20px" >
 
  </a>
 </div>

</div>
</body>
</html>
