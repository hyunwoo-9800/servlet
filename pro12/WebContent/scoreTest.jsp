<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% 
	request.setCharacterEncoding("UTF-8");
	int score = Integer.parseInt(request.getParameter("score"));
%>

<!DOCTYPE html>

<html>

	<head>
		<title>점수 출력창</title>
		<meta charset="UTF-8">
	</head>
	
	<body>
	
		<h1>시험점수 <%= score %>점</h1> <br> 
		
		<%
		
			if(90 <= score) {
			
		%>
		
		 <h1>A학점입니다.<hl>
		 
		 <%
		 
 			} else if(80 <= score  && score< 90) {
 				
 		 %>
 		 
 		 <h1>B학점입니다.<hl>
		 <%
		 
 			} else if(70 <= score  && score< 80) {
 				
 		 %>
 		 
 		 <h1>C학점입니다.<hl>
		 <%
		 
 			} else if(60 <= score  && score< 70) {
 				
 		 %>
 		 
 		 <h1>D학점입니다.<hl>
 		 
		 <%
		 
 			} else {
 				
 		 %>
 		 
 		 <h1>F학점입니다.<hl>
 		 <%
 		 
 			}
 		 %>
	</body>
</html>