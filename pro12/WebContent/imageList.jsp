<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
	<meta charset="UTF-8">
	<title>이미지리스트창</title>
	<link href="./imageList.css" rel="stylesheet" type="text/css">
	</head>

	<body>
		<ul class="lst_type">
			<li>
				<span style='margin-left: 50px'>이미지 </span>
				<span>이미지 이름</span>
				<span>선택하기</span></li>
				
			<%
			
				for (int i = 1; i < 10; i++) {
				
			%>
			<li>
			
				<a href='#' style='margin-left: 50px'>
					<img src='./images/image.jpg' width='90' height='90' alt='iamge' />
				</a>
				
				<a href='#'><strong>이미지 이름: test <%= i %></strong></a>
				
				<a href='#'><input type="checkbox"></input> </a>
			
			</li>
			
			<%
				}
			%>
			
		</ul>
		
	</body>
	
</html>