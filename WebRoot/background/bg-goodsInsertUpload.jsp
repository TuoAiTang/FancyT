<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<body>
	<jsp:include page="bg-up.jsp" flush="true"></jsp:include>
	<div id="bgMain">
		<jsp:include page="bg-left.jsp" flush="true"></jsp:include>
		<div id="bgRight">
			<div class="bgRightText font30" style="font-family:黑体">上传商品图片</div>
			<form action="background/bg-goodsInsertResult.jsp" method="post" enctype="multipart/form-data">
			<div class="bgRightTable">
				<table class="tableBorder" style="width:50%;">
						<tr>
							<td style="width:30%; background-color:#CCCCCC">商品图片</td>
							<td style="width:70%"><input name="file" type="file"/></td>
						</tr>
					</table>
					<br/>
				<input type="image" src="images/save.jpg" style="width:51px; height:20px"/>
			</div>
		</form>		
		</div>
		<div class="clear"></div>
	</div>
	<jsp:include page="bg-down.jsp" flush="true"></jsp:include>
</body>
</html>
