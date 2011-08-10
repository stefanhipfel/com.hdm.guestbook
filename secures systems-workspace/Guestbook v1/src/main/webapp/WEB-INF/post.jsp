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
	<h1 align="center">Guestbook - New Entry</h1>
	<div align="center">
	
		<form:form method="POST" commandName="entry">
			<textarea rows="10" cols="30" name="textarea" > </textarea>
			<br/>
			<input type="submit" name="submit" value="Submit"	 />
		</form:form>
	</div>
</body>
</html>