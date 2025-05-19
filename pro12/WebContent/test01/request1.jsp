<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% 
	request.setAttribute("name", "고길동");
	request.setAttribute("address", "우리집");
	
%>

<!DOCTYPE html>

<html>

	<head>
		<title>request</title>
		<meta charset="UTF-8">
	</head>
	
	<body>
		<%
		
		RequestDispatcher dispatch = request.getRequestDispatcher("request2.jsp");
		dispatch.forward(request, response);
		
		%>
	</body>
	
</html>