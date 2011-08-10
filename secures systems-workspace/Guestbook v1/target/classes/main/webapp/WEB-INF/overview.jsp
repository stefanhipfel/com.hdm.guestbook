<%@page import="java.text.DateFormat"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="com.hdm.guestbook.dao.*"%>
<%@page import="com.hdm.guestbook.model.*"%>

<jsp:useBean id="overviewDao" type="com.hdm.guestbook.dao.OverviewDao" scope="request" />

<html>
<head>
<title>Guestbook</title>
</head>

<body>
	<script type="text/javascript"> 
		var redirect = function(){
			location.href="post.html";
		} 
	</script>
	<h1 align="center">Guestbook - Overview</h1>
	<div align="center">
		<form:form method="POST" commandName="login">
			<input type="button" name="NewEntry" value="Add new Entry" onclick="redirect()">
     	</form:form>
     	<table width="50%" border="1" bordercolor="WHITE">
     		<%
				for (Overview overview : overviewDao.getAllEntries()) {
			%>
				<tr bordercolor="BLACK">
					<td>#<%=overview.getId()%></td>
					<td>from <%=overview.getUser()%></td>
					<td><%=overview.getTimetamp().toString()%></td>
				</tr>
				<tr bordercolor="BLACK">
					<td colspan="3"><%=overview.getText()%></td>
				</tr>
				<tr height="20"/>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>