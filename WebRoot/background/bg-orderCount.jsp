<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.py.vo.Order"%>
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
	String[] address = new String[] { "北京交通大学", "北京林业大学","清华大学","北京邮电大学", "天安门", 
			"北京大学", "北京师范大学", "北京航空航天大学", "中国农业大学", "中国政法大学", "中央财经大学","北京工业大学","对外经济贸易大学", 
			"北京化工大学","首都医科大学", "中国地质大学", "北京理工大学", "北京科技大学", "北京石油大学","北京电影学院"};
	int[] num = new int[20];
	for (int i = 0; i < address.length; i++) {
		num[i] = DAOFactory.getOrderDAOInstance().selectOrderByAddress(
				address[i]);
	}
%>
<body>
	<jsp:include page="bg-up.jsp" flush="true"></jsp:include>
	<div id="bgMain">
		<jsp:include page="bg-left.jsp" flush="true"></jsp:include>
		<div id="bgRight">
			<div class="bgRightText font30" style="font-family:黑体">订单信息统计</div>
			<div class="bgRightTable">
				<div class="bgRightTable2">
					<div class="bgRightTable2Text1">配送地址</div>
					<div class="bgRightTable2Text2">订单数量</div>
					<div class="bgRightTable2Text1">配送地址</div>
					<div class="bgRightTable2Text2">订单数量</div>
					<%
						for(int i=0;i<address.length;i++){
						
					 %>
					 	<div class="bgRightTable2Text1"><%=address[i]%></div>
						<div class="bgRightTable2Text2" id="num<%=i%>"><%=num[i]%></div>
					<%
					 	}
					 %>
				</div>
				<div class="clear"></div>
		<script>
		function designOrder(){
		    var n0 = document.getElementById("num0").innerHTML;
			var n1 = document.getElementById("num1").innerHTML;
			var n2 = document.getElementById("num2").innerHTML;
			var n3 = document.getElementById("num3").innerHTML;
			var n4 = document.getElementById("num4").innerHTML;
			var n5 = document.getElementById("num5").innerHTML;
			var n6 = document.getElementById("num6").innerHTML;
			var n7 = document.getElementById("num7").innerHTML;
			var n8 = document.getElementById("num8").innerHTML;
			var n9 = document.getElementById("num9").innerHTML;
			var n10 = document.getElementById("num10").innerHTML;
			var n11 = document.getElementById("num11").innerHTML;
			var n12 = document.getElementById("num12").innerHTML;
			var n13 = document.getElementById("num13").innerHTML;
			var n14 = document.getElementById("num14").innerHTML;
			var n15 = document.getElementById("num15").innerHTML;
			var n16 = document.getElementById("num16").innerHTML;
			var n17 = document.getElementById("num17").innerHTML;
			var n18 = document.getElementById("num18").innerHTML;
			var n19 = document.getElementById("num19").innerHTML;
			var url ="index.html?"+"num0="+n0+"&num1="+n1+"&num2="+n2+"&num3="+n3+"&num4="+n4+"&num5="+n5+"&num6="+n6+"&num7="+n7
			+"&num8="+n8+"&num9="+n9+"&num10="+n10+"&num11="+n11+"&num12="+n12+"&num13="+n13+"&num14="+n14+"&num15="+n15
			+"&num16="+n16+"&num17="+n17+"&num18="+n18+"&num19="+n19;
			//window.location = "http://path.ec-logistics.cn/"+url;//IE
			window.location = "http://localhost:8080/Web/"+url;
		}
	</script>
				<a href="javascript:history.back();">返回</a>&nbsp;&nbsp;<a href="javascript:designOrder();">规划</a><br />
			</div>
		</div>
		<div class="clear"></div>
	</div>

	<jsp:include page="bg-down.jsp" flush="true"></jsp:include>
</body>
</html>
