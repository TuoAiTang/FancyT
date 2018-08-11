<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.py.vo.Member"%>
<jsp:useBean id="date" class="java.util.Date"></jsp:useBean>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<title>FancyT,潮流t，上ft</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function validate(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("表单信息不能为空");
form.elements[i].focus();
return false;
}
}
if(!/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/.test(form.tel.value)){
alert("手机号码格式错误");
return false;
}
return true;
}
</script>
</head>
<%
	Member form = (Member) session.getAttribute("member");
	long time = date.getTime();
	String orderId =  String.valueOf(time);
%>
<body>
	<jsp:include page="fg-header.jsp" flush="true" />
	<jsp:include page="fg-nav.jsp" flush="true" />
	<div id="main">
			<div class="logo">
			<a href="index.jsp"><img src="images/cash_register.png" width="70"
				height="70" />
			</a>
		</div>
			<div class="fgText">
				<font color="#FF0000">注意：本站每日12点前下的订单将于当日16点前进行配送。</font>
			</div>
			<form name="orderForm" method="post" action="OrderServlet.do?method=insertOrder" onsubmit="return validate(this)">
			<div class="fgForm">			
				<div class="fgInput">
					<span class="input3Text">订单编号：</span><input class="form-control" name="orderId" type="text" value="<%=orderId%>" disabled="disabled"
					 style="display: inline; width:180px;height:30px"/>
					<input class="input3" name="orderId" type="hidden" value="<%=orderId%>"/><!-- long型的毫秒数     -->
				</div>
				<div class="fgInput">
					<span class="input3Text">会员名称：</span><input class="form-control" name="account" type="text" value="<%=form.getAccount()%>" disabled="disabled"  style="display: inline; width:180px;height:30px"/>
					<input class="input3" name="account" type="hidden" value="<%=form.getAccount()%>"/>
				</div>
				<div class="fgInput">
					<span class="input3Text">真实姓名：</span><input class="form-control" type="text" name="reallyName" value="<%=form.getReallyName()%>"
					 style="display: inline; width:180px;height:30px"/>
				</div>
				<div class="fgInput">
					<span class="input3Text">送货地址：</span><select class="form-control" name="address"  style="display: inline; width:180px;height:30px">
						<option value="">-----------请选择-----------</option>
						<option value="清华大学">清华大学</option>
						<option value="北京大学">北京大学</option>
						<option value="北京邮电大学">北京邮电大学</option>
						<option value="中国农业大学">中国农业大学</option>
						<option value="中国人民大学">中国人民大学</option>						
						<option value="北京科技大学">北京科技大学</option>
						<option value="天安门">天安门</option>
						<option value="北京林业大学">北京林业大学</option>
						<option value="北京师范大学">北京师范大学</option>
						<option value="北京航空航天大学">北京航空航天大学</option>
						<option value="中国政法大学">中国政法大学</option>
						<option value="中央财经大学">中央财经大学</option>
						<option value="北京工业大学">北京工业大学</option>
						<option value="北京化工大学">北京化工大学</option>
						<option value="对外经济贸易大学">对外经济贸易大学</option>
						<option value="首都医科大学">首都医科大学</option>
						<option value="中国地质大学">中国地质大学</option>
						<option value="北京理工大学">北京理工大学</option>
						<option value="北京石油大学">北京石油大学</option>
						<option value="北京电影学院">北京电影学院</option>						
					</select>
				</div>
				<div class="fgInput">
					<span class="input3Text">联系电话：</span><input class="form-control" type="text" name="tel"  style="display: inline; width:180px;height:30px"/>
				</div>
				<div class="fgInput">
					<span class="input3Text">付款方式：</span><select class="form-control" name="setMoney"  style="display: inline; width:180px;height:30px">
						<option value="">-----------请选择-----------</option>
						<option value="银行付款">银行付款</option>
						<option value="邮政付款">邮政付款</option>
						<option value="现金支付">现金支付</option>
						<option value="支付宝">支付宝</option>
						<option value="微信支付">微信支付</option>
					</select>
				</div>
				<div class="fgInput">
					<span class="input3Text">运输方式：</span><select class="form-control" name="post"  style="display: inline; width:180px;height:30px">
						<option value="">-----------请选择-----------</option>
						<option value="普通邮寄">普通邮寄</option>
						<option value="特快专递">特快专递</option>
						<option value="EMS专递">EMS</option>
					</select>
				</div>
				<div class="fgInput">
					<span class="input3Text">备注信息：</span><input class="form-control" type="text" name="bz"  style="display: inline; width:180px;height:30px"/>
				</div>
				<div class="fgInput">		 
					<input type="reset" name="reset" value="清除"/ class="btn btn-danger"> &nbsp;
					<input type="submit" name="Submit" value="提交" class="btn btn-success" /> &nbsp;
					<input type="button" name="back" value="返回" onclick="javasrcipt:history.go(-1)" class="btn active" />
				</div>	
		</div>
		</form>
	</div>
	<jsp:include page="fg-footer.jsp" flush="true" />
	<%
		String result = (String) request.getAttribute("result");
		if (result!=null) {	
 	%>
 		<script>alert('<%=result%>');</script>		
 	<%
 		}
  	 %>
</body>
</html>
