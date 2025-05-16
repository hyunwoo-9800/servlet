<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% 
	String name = (String)session.getAttribute("name");
	session.setAttribute("address", "여긴 어딘가");
%>

<!DOCTYPE html>

<html>

	<head>
		<title>session 내장 객체 테스트2</title>
		<meta charset="UTF-8">
	</head>
	
	<body>
		이름은 <%= name %> 입니다. <br>
		<a href = session2.jsp>두 번째 페이지로 이동</a>
	</body>
	
</html>