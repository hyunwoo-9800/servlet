<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%!

	String name = "홍길동";
	public String getName() {
		
		return name;
		
	}

%>

<%
	
	String age = request.getParameter("age");

%>

<html>

	<head>
		<meta charset="UTF-8">
		<title>스크립틀릿 연습</title>
	</head>
	
	<body>
		<h1>안녕하세요 <%= name %>님</h1>
		<h1>나이는 <%= age %>살입니다.</h1>
	</body>
	
</html>