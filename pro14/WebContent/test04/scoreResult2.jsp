<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<html>

	<head>
		<meta charset="UTF-8">
		<title>학점 변환 결과</title>
	</head>
	
	<body>
		<c:set var="score" value="${param.score }" />
		
		<h1>
			시험점수
			<c:out value="${score }" />
		</h1>
		
		<br>
		
		<c:choose>
		
			<c:when test="${ 0 <= score && score <= 100 }">
				<c:choose>
					<c:when test="${ 90 <= score && score < 100 }">
						<h1>A학점입니다.</h1>
					</c:when>
					<c:when test="${ 80<= score && score < 90 }">
						<h1>B학점입니다.</h1>
					</c:when>
					<c:when test="${ 70 <= score && score < 80 }">
						<h1>C학점입니다.</h1>
					</c:when>
					<c:when test="${ 60 <= score && score < 70 }">
						<h1>D학점입니다.</h1>
					</c:when>
					<c:otherwise>
						<h1>F학점입니다.</h1>
					</c:otherwise>
				</c:choose>
			</c:when>
			
			<c:otherwise>
				<h1>점수를 잘못 입력했습니다. 다시입력하세요</h1>
				<a href="scoreTest.jsp">점수 입력 창으로 이동</a>
			</c:otherwise>
			
		</c:choose>
		
	</body>
	
</html>
