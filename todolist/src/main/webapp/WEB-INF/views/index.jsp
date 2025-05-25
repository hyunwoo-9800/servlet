<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To Do List</title>
</head>
<body>
	<!-- 헤더 부분 -->
	<jsp:include page="./include/header.jsp" />

	<!-- 할 일 목록 -->
	<jsp:include page="./list/list.jsp" />
	
	<!-- 푸터 부분 -->
	<jsp:include page="./include/footer.jsp" />
</body>
</html>