<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.py.vo.Goods"%>
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
<script>
function validate(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("表单信息不能为空");
form.elements[i].focus();
return false;
}
}
if(isNaN(form.freeprice.value)){
alert("价格只能为数字");
return false;
}
if(form.freeprice.value-form.nowprice.value>=0){
alert("您输入特价商品的价格应该比原来的价格低，请重新输入！！！");
return false;
}
}
</script>
</head>
<%
	int goodsId = Integer.parseInt(request.getParameter("goodsId"));
	float nowprice = Float.parseFloat(request.getParameter("nowprice"));
	float freeprice = Float.parseFloat(request.getParameter("freeprice"));
	int mark = Integer.parseInt(request.getParameter("mark"));
%>

<body>
	<jsp:include page="bg-up.jsp" flush="true"></jsp:include>
	<div id="bgMain">
		<jsp:include page="bg-left.jsp" flush="true"></jsp:include>
		<div id="bgRight">
			<div class="bgRightText font30" style="font-family:黑体">修改商品特价</div>
		<form action="GoodsServlet.do?method=updateGoodsPrice&goodsId=<%=goodsId%>" method="post" name="goodsForm" onsubmit="return validate(this)">
			<div class="bgRightForm">
				<div class="bgInput">
					<span class="input5Text">商品定价：</span><input class="input5" name="nowprice" type="text" value="<%=nowprice%>"/>
				</div>
				<div class="bgInput">
					<span class="input5Text">商品特价：</span><input class="input5" name="freeprice" type="text" value="<%=freeprice%>"/>
				</div>
				<div class="bgInput">
					<span class="input5Text">是否特价：</span>
					<%
						if(mark==1){
					 %>
					<input name="mark" type="radio" value="0"  />否 
					<input name="mark" type="radio" value="1" checked="checked"/>是
					<%
						}else{
					 %>
					<input name="mark" type="radio" value="0" checked="checked"/>否 
					<input name="mark" type="radio" value="1"/>是
					 <%
					 	}
					  %>
				</div>
				<div class="bgInput">
					<input type="image" src="images/save.jpg" style="width:51px; height:20px"/>
				</div>
			</div>
		</form>
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
