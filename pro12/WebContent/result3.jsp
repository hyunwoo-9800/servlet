<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	request.setCharacterEncoding("UTF-8");
	
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
%>

<html>

	<head>
	<meta charset="UTF-8">
	<title>결과 출력 창</title>
	</head>
	
	<body>
	
		<h1>결과 출력</h1>
		
		<%
			if (user_id == null || user_id.length() == 0) {
		%>
		
		아이디를 입력하세요.<br>
		
		<a href="/pro12/login.html">로그인 하기</a>
		
		<%
		
			} else {
	
				if (user_id.equals("admin")) {
					
		%>
	
		<h1>관리자로 로그인 했습니다.</h1>
		
		<form>
	
			<input type="button" value="회원정보 삭제하기"></input>
			<input type="button" value="회원정보 수정하기"></input>
	
		</form>
	
		<%
				
				} else {
					
		%>
	
		<h1>환영합니다.<%=user_id%>님</h1>
	
		<%
				}
			}
		%>
	
	</body>

</html>