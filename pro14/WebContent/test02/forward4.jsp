<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	request.setAttribute("id", "sleep");
	request.setAttribute("pwd", "1234");
	session.setAttribute("name", "졸려");
	application.setAttribute("email", "sleep@test.com");
%>

<html>

	<head>
		<meta charset="UTF-8">
		<title>forward2</title>
	</head>
	
	<body>
		<jsp:forward page="member4.jsp"></jsp:forward>
	</body>

</html>