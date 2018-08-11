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
if(!/^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$/.test(form.publishdate.value)){
alert("请输入正确的日期格式，如：1111-11-11");
return false;
}
if(isNaN(document.form.nowpirce.value)&&isNaN(document.form.freepirce.value)){
alert("价格只能为数字");
return false;
}
return true;
}
</script>
</head>
<%
	List<Sort> sortList = DAOFactory.getSortDAOInstance().selectSort();
	String Picture = request.getParameter("picture");
%>
<body>
	<jsp:include page="bg-up.jsp" flush="true"></jsp:include>
	<div id="bgMain">
		<jsp:include page="bg-left.jsp" flush="true"></jsp:include>
		<div id="bgRight">
			<div class="bgRightText font30" style="font-family:黑体">添加商品信息</div>
			<form action="GoodsServlet.do?method=insertGoods" method="post" name="goodsForm" onsubmit="return validate(this)">
			<div class="bgRightTable">
				<table class="tableBorder" style="width:80%;">
							<tr>
								<td style="background-color:#CCCCCC">商品图片</td>
								<td colspan="3"><input name="picture" type="hidden" value="goodspicture/<%=Picture%>" /> <%
								 	if (request.getParameter("picture") == null) {
								 %> 
								 <a href="background/bg-goodsInsertUpload.jsp">上传图片</a> <%
								 	} else {
								 %> 
								 	图片已经上传
								 <%
								 	}
								 %>
								</td>
							</tr>
							<tr>
								<td style=" width:20%;background-color:#CCCCCC">商品名称</td>
								<td style=" width:30%;"><input class="input6" name="tshirtName" type="text"/></td>
								<td style=" width:20%; background-color:#CCCCCC">所属类别</td>
								<td style=" width:30%;">
									<select name="sortId" >
										<option value="">------请选择------</option>
										<%
											for (int i = 0; i < sortList.size(); i++) {
												Sort sort = (Sort) sortList.get(i);
										%>
										<option value="<%=sort.getSortId()%>"><%=sort.getSortName()%></option>
										<%
											}
										%>
									</select>
								</td>
							</tr>
							<tr>
								<td style="background-color:#CCCCCC">品牌</td>
								<td><input name="brands" type="text" class="input6" /></td>
								<td style="background-color:#CCCCCC">发售时间</td>
								<td><input name="publishdate" type="text" class="input6" /></td>
							</tr>
							<tr>
								<td style="background-color:#CCCCCC">商品订价</td>
								<td>￥ <input name="nowprice" type="text" class="input7" />&nbsp;元</td>
								<td style="background-color:#CCCCCC">商品特价</td>
								<td>￥ <input name="freeprice" type="text" class="input7" />&nbsp;元</td>
							</tr>
							<tr>
								<td style="background-color:#CCCCCC">是否特价</td>
								<td colspan="3"><input name="mark" type="radio" value="0"/>否 
												<input name="mark" type="radio" value="1" />是</td>
							</tr>
							<tr>
								<td style="height:150px; background-color:#CCCCCC">简介</td>
								<td colspan="3"><textarea name="introduce" cols="60"
										rows="10"></textarea></td>
							</tr>
						</table>
				<input type="image" src="images/save.jpg" style="width:51px; height:20px" />
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
