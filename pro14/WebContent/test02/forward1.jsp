<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	request.setAttribute("id", "여긴누구");
	request.setAttribute("pwd", "1234");
	session.setAttribute("name", "난어디");
	application.setAttribute("email", "test@test.com");
%>

<html>

	<head>
		<meta charset="UTF-8">
		<title>forward1</title>
	</head>
	
	<body>
		<jsp:forward page="member1.jsp" />
	</body>
	
</html>
