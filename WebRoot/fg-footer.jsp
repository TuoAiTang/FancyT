<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.py.vo.Link"%>
<%@ page import="com.py.vo.Affiche"%>
<%@ page import="com.py.vo.Footprint"%>
<%@ page import="com.py.vo.Goods"%>
<%@ page import="com.py.vo.Member"%>
<%@ page import="com.py.factory.DAOFactory"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<title>电子商务网站</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<script>
$(function(){
var div1 = $("#fp_detail");
var div2 = $("#myaffiche")
    $("#fold").click(function(){
      div1.hide(300);
      div2.hide(300);
    });
   $("#unfold").click(function(){
      div1.show(300);
      div2.show(300);
   });
});   
</script>
<%
	List<Link> linkList = DAOFactory.getLinkDAOInstance().selectLink();
    List<Affiche> afficheList= DAOFactory.getAfficheDAOInstance().selectAffiche();
    Member member = null;
    List<Footprint> fpList = new ArrayList<Footprint>();
    if(session.getAttribute("member") != null){
    	member = (Member) session.getAttribute("member");
}
    if(member != null){
    	fpList = DAOFactory.getFootprintDAOInstance().selectThreeFpByAccount(member.getAccount());
}

%>
<body>
	<div id="footer">
		<hr class="hrRed" />
		<div class="iconAd">
			<img src="images/fg_ad.gif" width="960" height="76" />
		</div>
		<div class="link">
			<%
				for(int i=0;i<linkList.size();i++){
				   Link link=(Link)linkList.get(i);
			%>
			<div class="linkName">
				<a href="<%=link.getLinkAddress()%>" class="a4"><%=link.getLinkName()%></a>
			</div>
			<%
				}
			%>
			<div class="clear"></div>
		</div>
		<div class="bgLoginA">
			<a href="background/bg-managerLogin.jsp" class="a5">进入后台</a>
		</div>
		<div class="caution lightgrey font12">
			版权所有：Fancy-T<br/>
    		Copyright&copy;All Rights Reserved<br/>
   			邮编：100000
		</div>
		<div class="clear"></div>
	</div>

	<div id="footprint" style="width:135px; height:400px; position:fixed; left:0; top:200px;">
		<a id="unfold"><img src="images/footprint.png" width="45" height="45" style="display: inline"></a>
		<a id="fold"><img src="images/fold_1.png" width="45" height="45" style="display: inline">
			</a>
		<div id="fp_detail" class="panel-body" style="display:none;">
		<%
			if(fpList.size()==0){
		%>
		<div class="afficheNo">空空如也！</div>
		<%
			}else{
		%>
		<ul class="list-group" style="margin-left: 0;">
			<%
				for(int i=0;i<fpList.size();i++){
					Footprint fp = (Footprint) fpList.get(i);
					Goods gd = DAOFactory.getGoodsDAOInstance().selectGoodsByGoodsId(fp.getGoodsId());
			%>
			<li class="list-group-item" style="width: 0 auto; height: 120px">
				<a href="GoodsServlet.do?method=selectGoodsByGoodsId&goodsId=<%=gd.getGoodsId()%>&sign=fg"
				style="text-decoration: none">
				<img src="<%=gd.getPicture()%>" width="70" height="100" style="display:inline"/>
				</a>
			<%
				}}
			%>
		</ul>
	</div>
	</div>

	<div id="myaffiche" class="affiche">
		<div class="panel panel-default">
			<div class="panel-heading"> 
				<img src="images/message.png" width="20" height="20">
				<div style="float:right">
			<a href="AfficheServlet.do?method=selectAffiche&sign=fg" style="text-decoration: none;"><img src="images/more_message.png" width="20" height="20"></a>
		</div>
			</div>
		
		
		<div class="clear"></div>
		<div class="panel-body">
		<%
			if(afficheList.size()==0){
		%>
		<div class="afficheNo">无商城公告信息</div>
		<%
			}else{
		%>
		<ul class="list-group" style="margin-left: 0;">
			<%
				for(int i=0;i<afficheList.size();i++){
					Affiche affiche=(Affiche)afficheList.get(i);
			%>
			<li class="list-group-item" style="width: 0 auto; height: 35px"><img src="images/hot.png" width="20" height="20" /><span style="color:red; font-size: 0.7em;">[公告]</span><a
				href="AfficheServlet.do?method=selectAfficheById&id=<%=affiche.getId()%>&sign=fg"
				style="text-decoration: none"> <%=affiche.getAffiche()%></a>
			</li>
			<%
				}}
			%>
		</ul>
	</div>
	</div>
	</div>
</body>
</html>
