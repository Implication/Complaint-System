<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/complaintsystem/submitComplaint" method="post" id="complaintForm">
	Message:<br /><textarea style="height:160px; font-size: 14pt;" name="complaint" ></textarea><br />
	Email: <input type="text" name="email" /><br />
	Name: <input type="text" name="name" /><br />
	<input type = "submit" value="submit" /><br />
</form>


</body>
</html>