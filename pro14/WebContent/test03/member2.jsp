<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,sec01.ex01.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="membersList" class="java.util.ArrayList"></jsp:useBean>
<jsp:useBean id="membersMap" class="java.util.HashMap"></jsp:useBean>

<%
	request.setCharacterEncoding("UTF-8");
	membersMap.put("id", "졸려");
	membersMap.put("pwd", "1111");
	membersMap.put("name", "졸려");
	membersMap.put("email", "졸려@test.com");
	MemberBean m1 = new MemberBean("집에갈래", "1234", "고투홈", "gotoHome@test.com");
	MemberBean m2 = new MemberBean("여긴어디", "2222", "여긴어디", "goBack@test.com");
	membersList.add(m1);
	membersList.add(m2);
	membersMap.put("membersList", membersList);
%>
<c:set var="membersList" value="${membersMap.membersList}"></c:set>

<html>

	<head>
		<meta charset="UTF-8">
		<title>회원 정보 출력 창</title>
	</head>
	
	<body>
	
		<table border=”1” align="center">
		
			<tr align=center bgcolor="#99ccff">
			
				<td width="20%">
					<b>아이디</b>
				</td>
				
				<td width="20%">
					<b>비밀번호</b>
				</td>
				
				<td width="20%">
					<b>이름</b>
				</td>
				
				<td width="20%">
					<b>이메일</b>
				</td>
				
			</tr>
			
			<tr align="center">
				<td>${ membersMap.id }</td>
				<td>${ membersMap.pwd }</td>
				<td>${ membersMap.name }</td>
				<td>${ membersMap.email }</td>
			</tr>
			
			<tr align="center">
				<td>${ membersList[0].id }</td>
				<td>${ membersList[0].pwd }</td>
				<td>${ membersList[0].name }</td>
				<td>${ membersList[0].email }</td>
			</tr>
			
			<tr align="center">
				<td>${ membersList[1].id }</td>
				<td>${ membersList[1].pwd }</td>
				<td>${ membersList[1].name }</td>
				<td>${ membersList[1].email }</td>
			</tr>
			
		</table>
		
	</body>
	
</html>
