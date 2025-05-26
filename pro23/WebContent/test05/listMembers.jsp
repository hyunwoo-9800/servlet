<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
request.setCharacterEncoding("UTF-8");
%>


<html>
<head>
<meta charset=UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
	<table border="1" align="center" width="80%">
		<tr align="center" bgcolor="lightgreen">
			<td><b>아이디</b></td>
			<td><b>비밀번호</b></td>
			<td><b>이름</b></td>
			<td><b>이메일</b></td>
			<td><b>가입일</b></td>
			<td><b>삭제하기</b></td>
		</tr>

		<c:forEach var="member" items="${membersList}">
			<tr align="center">
				<td>${member.id}</td>
				<td>${member.pwd}</td>
				<td>${member.name}</td>
				<td>${member.email}</td>
				<td>${member.joinDate}</td>
				<td>
					<button class="delete-btn" data-id="${member.id}">삭제</button>
				</td>
			</tr>
		</c:forEach>
	</table>
		<a  href="${contextPath}/test05/memberForm.jsp"><h1 style="text-align:center">회원가입</h1></a>

	<script type="text/javascript">
	document.addEventListener('DOMContentLoaded', function() {
		const contextPath = "${contextPath}";
		// 삭제 버튼들
		const deleteBtns = document.querySelectorAll('.delete-btn'); // 삭제 버튼들

		// 각 삭제 버튼 클릭 시 할 일 삭제
		deleteBtns.forEach(button => {
			button.addEventListener('click', () => {
				const id = button.dataset.id; // 삭제할 항목의 ID

				// 삭제 요청
				fetch(contextPath + "/delete.do", {
					method: 'POST',
					headers: { 'Content-Type': 'application/json' },
					body: JSON.stringify({ id: id })
				})
					.then(response => response.json())
					.then(result => {
						if (result.success) {
							location.reload(); // 삭제 후 페이지 갱신
						} // 성공 시 알림을 띄우지 않음
					});
			});
		});
	});

	</script>

</body>
</html>
