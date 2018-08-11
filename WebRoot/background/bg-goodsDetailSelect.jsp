<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	function checkEmpty(form) {
		for (i = 0; i < form.length; i++) {
			if (form.elements[i].value == "") {
				alert("表单信息不能为空");
				return false;
			}
		}
	}
</script>
</head>
<%
	Goods goods = (Goods) request.getAttribute("goods");
	String sortName = DAOFactory.getSortDAOInstance().selectSortBySortId(goods.getSortId()).getSortName();
%>
<body>
	<jsp:include page="bg-up.jsp" flush="true"></jsp:include>
	<div id="bgMain">
		<jsp:include page="bg-left.jsp" flush="true"></jsp:include>
		<div id="bgRight">
			<div class="bgRightText font30" style="font-family:黑体">查看商品的详细情况</div>
			<div class="bgRightTable">
				<table class="tableBorder" style="width:99%;">
						<tr>
							<td width="15%" style="background-color:#CCCCCC">商品名称</td>
							<td width="35%"><%=goods.getTshirtName()%></td>
							<td width="15%" style="background-color:#CCCCCC">品牌</td>
							<td width="35%"><%=goods.getBrands()%></td>
						</tr>
						<tr>
							<td style="background-color:#CCCCCC">商品类别</td>
							<td><%=sortName%></td>
							<td style="background-color:#CCCCCC">发售时间</td>
							<td><%=goods.getPublishdate()%></td>
						</tr>
						<tr>							
							<%
								if(goods.getMark()==0){
							 %>
							<td style="background-color:#CCCCCC">商品定价</td>
							<td><%=goods.getNowprice()%>元</td>
							<td style="background-color:#CCCCCC">商品特价</td>
							<td style="text-decoration:line-through;"><%=goods.getFreeprice()%>元</td>
							<%
								}else{
							 %>
							<td style="background-color:#CCCCCC">商品定价</td>
							<td style="text-decoration:line-through;"><%=goods.getNowprice()%>元</td>
							<td style="background-color:#CCCCCC">商品特价</td>
							<td><%=goods.getFreeprice()%>元</td>
							<%
								}
							 %>							
						</tr>
						<tr>
							<td style="background-color:#CCCCCC">商品图片</td>
							<td colspan="3"><img src="<%=goods.getPicture()%>"
								style="width:140px; height:200px"/>
							</td>
						</tr>
						<tr>
							<td style="background-color:#CCCCCC">商品简介</td>
							<td colspan="3"><%=goods.getIntroduce()%></td>
						</tr>
					</table>
				<br />
					<a href="background/bg-goodsPriceManager.jsp?goodsId=<%=goods.getGoodsId()%>&nowprice=<%=goods.getNowprice()%>&freeprice=<%=goods.getFreeprice()%>&mark=<%=goods.getMark()%>">设置特价商品</a>
					<a href="javascript:history.back();">返回</a>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<jsp:include page="bg-down.jsp" flush="true"></jsp:include>
</body>
</html>
