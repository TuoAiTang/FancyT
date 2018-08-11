<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.py.vo.Affiche"%>
<%@ page import="com.py.factory.DAOFactory"%>
<%@ page import="com.py.vo.Member"%>
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
<title>FancyT,潮流t，上ft</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="fg-header.jsp" flush="true" />
	<jsp:include page="fg-nav.jsp" flush="true" />
	<div id="main">
		<div class="fgLogo">
			<img src="images/logo_up.png" width="122"
				height="40" />
		</div>

		<%
			Member member = null;
  			if(session.getAttribute("member")!=null){
  				member = (Member)session.getAttribute("member");
    		}
    		List<Member> memberList = DAOFactory.getMemberDAOInstance().selectMember();
    		String account = member.getAccount();
    		member = DAOFactory.getMemberDAOInstance().selectMemberByAccount(account);
		%>

		<div class="fgText">
			我的积分：<%=member.getIntergrate()%>
		</div>
		<div class="fgForm">
		<table class="table table-hover" width="40">
				<thead>
					<th style="width:33%; color:#FF3333;">用户名</th>
					<th style="width:33%; color:#FF3333;">排行</th>
					<th style="width:33%; color:#FF3333;">积分</th>
				</thead>
				<tbody>
				<%
					for(int memberNumber=0;memberNumber<memberList.size();memberNumber++){
						Member m = (Member) memberList.get(memberNumber);
						String style = "background-color:#FFFFFF";
						if(m.getAccount().equals(member.getAccount())){
							style = "background-color:#FF6666";}
				%>
				
				<tr style=<%=style%>>
					<td><%=m.getAccount()%></td>
					<td style="color:#009900;"><%=( memberNumber + 1 )%></td>
					<td style="color:#009900;"><%=m.getIntergrate()%></td>
				</tr>
				<%
					}
				%>
				
			</tbody>
		</table>
		
	</div>


	<jsp:include page="fg-footer.jsp" flush="true" />
</body>
</html>
