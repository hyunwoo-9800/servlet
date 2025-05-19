<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("utf-8");
%> 

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>include1.jsp</title>
	</head>
	
	<body>
	  안녕하세요. 메인 디쉬 JSP 시작입니다!!!
	<br>
		<jsp:include page="main_image.jsp" flush="true">
			<jsp:param name="name" value="이미지"></jsp:param>
			<jsp:param name="imgName" value="image.jpg"></jsp:param>
		</jsp:include>
	
	<br>
	  안녕하세요. 메인 디쉬 JSP 끝 부분입니다.!!!
	</body>
	
</html>