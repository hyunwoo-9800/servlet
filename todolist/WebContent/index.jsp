<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="todoList" class="java.util.HashMap"></jsp:useBean>

<%
	request.setCharacterEncoding("UTF-8");
	todoList.put(1, "JSP 공부하기(미완료)");
	todoList.put(2, "Spring 이해하기(완료)");
	todoList.put(3, "To Do List 만들기(미완료)");
%>

<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title>To Do List</title>
		<link href="./css/index.css" rel="stylesheet" type="text/css">
	</head>
	
	<body>
	
		<%@ include file="../views/header.jsp"%>
	
		<h2>할 일 목록</h2>
	
		<nav>
			<ul>
				
				<c:forEach var="list" items="${todoList}">
					<li><c:out value="${list.value}"/></li>
				</c:forEach>
				
			</ul>
		</nav>
		
	</body>

</html>