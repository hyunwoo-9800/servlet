<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>To Do List</title>
<link href="${pageContext.request.contextPath}/css/list/list.css"
	rel="stylesheet">
</head>

<body>
	<!-- 할 일 목록 추가 -->
	<jsp:include page="./addList.jsp" />

	<ul class="todo-list">
		<c:forEach var="todo" items="${todoList}">
			<li class="todo-item ${todo.status == '1' ? 'completed' : ''}"
				data-id="${todo.itemNum}">${todo.content}<span
				class="status-text"> <c:choose>
						<c:when test="${todo.status == '1'}">(완료)</c:when>
						<c:otherwise>(미완료)</c:otherwise>
					</c:choose>
			</span> <!-- 삭제 버튼 추가 -->
				<div class="todo-actions">
					<button class="delete-btn" data-id="${todo.itemNum}">삭제</button>
				</div>
			</li>
		</c:forEach>
	</ul>

	<script type="text/javascript">
		// JS 전역에 contextPath 저장
		window.contextPath = "${pageContext.request.contextPath}";
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/statusUpdate.js"></script>
</body>

</html>
