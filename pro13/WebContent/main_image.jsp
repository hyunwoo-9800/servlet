<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String imgName = request.getParameter("imgName");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지</title>
</head>
<body>
	<br>
	<br>
	<h1>
		이름은
		<%=name%>입니다.
	</h1>
	<br>
	<br>
	<img src="./images/<%=imgName%>" />
</body>
</html>