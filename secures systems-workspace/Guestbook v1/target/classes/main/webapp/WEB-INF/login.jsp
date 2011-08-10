<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Guestbook</title>
</head>

<body>
<script type="text/javascript"> 
	var redirect = function(){
		location.href="register.html";
	} 
</script>
	<h1 align="center">Guestbook - Login</h1>
	<div align="center">
		<form:form method="POST" commandName="login">
			<table>
				<tr>
					<td>Name:</td>
					<td><form:input path="name" type="text" value="name"
							name="name" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:input path="password" type="password"
							value="password" name="password" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login" name="login" /></td>
					<td>
					<input type="button" name="register" value="Register"
     	 				onclick="redirect()">
					</td>
				</tr>
				<tr>
					<td colspan="2"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>