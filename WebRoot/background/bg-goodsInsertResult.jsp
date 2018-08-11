<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.jspsmart.upload.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.*"%>
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
	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
	Date myDate = new Date();
	String time=formatter.format(myDate);
    // 新建一个SmartUpload对象  
    SmartUpload smartUpload = new SmartUpload();  
    // 上传初始化  
    smartUpload.initialize(pageContext);  
    //设置上传限制  
    //1.限制每个上传文件的最大长度为10MB  
    smartUpload.setMaxFileSize(10 * 1024 * 1024);  
    //2.限制总上传文件的长度  
    smartUpload.setTotalMaxFileSize(30 * 1024 * 1024);  
    //3.设定允许上传的文件  
    smartUpload.setAllowedFilesList("jpg,gif,png");  
    //4.设定禁止上传的文件  
    smartUpload.setDeniedFilesList("exe,bat,jsp,htm,html");  
    //上传文件  
    smartUpload.upload();  
    //将上传的文件全部保存到指定目录  
    File myfile= smartUpload.getFiles().getFile(0);
    String FileName = null;
    if (myfile .getFileExt().length()>0){
    	String filename = time;
    myfile.saveAs("/goodspicture/"+filename+"."+myfile.getFileExt(),SmartUpload.SAVE_VIRTUAL);
    FileName =filename+"."+myfile.getFileExt();
    }
%>
<body>
	<jsp:include page="bg-up.jsp" flush="true"></jsp:include>
	<div id="bgMain">
		<jsp:include page="bg-left.jsp" flush="true"></jsp:include>
		<div id="bgRight">
			<div class="bgRightText font30" style="font-family:黑体">上传商品图片</div>
			<form action="bg-goodsInsertResult.jsp" method="post" enctype="multipart/form-data">
			<div class="bgRightTable">
				<table class="tableBorder" style="width:50%;">
						<tr>
							<td style="width:30%; background-color:#CCCCCC">商品图片</td>
							<td style="width:70%;"><img src="goodspicture/<%=FileName%>" style="width:140px; height:200px"/></td>
						</tr>
				</table>
				<br/>
				<a href="background/bg-goodsInsert.jsp?picture=<%=FileName%>">提交</a>
			</div>
		</form>		
		</div>
		<div class="clear"></div>
	</div>
	<jsp:include page="bg-down.jsp" flush="true"></jsp:include>
</body>
</html>
