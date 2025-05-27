<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- list.jsp -->
<html>

	<head>
		<title>To Do List</title>
		<link href="${pageContext.request.contextPath}/css/list/list.css"
			rel="stylesheet">
		<link rel="stylesheet"
			href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
			integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
			crossorigin="anonymous" referrerpolicy="no-referrer" />
	</head>

	<body>
	
		<!-- 할 일 목록 추가 페이지 가져오기 -->
		<jsp:include page="./addList.jsp" />
	
		<!-- 선택한 필터에 따라 보여줄 목록을 정함 -->
		<c:set var="filterVal" value="${param.filter}" />
	
		<div class="filters">
	
			<form action="todoList" method="get" style="display: inline;">
				<input type="hidden" name="filter" value="all" />
				<button type="submit"
					class="${filterVal == 'all' || empty filterVal ? 'active' : ''}">전체</button>
			</form>
	
			<form action="todoList" method="get" style="display: inline;">
				<input type="hidden" name="filter" value="0" />
				<button type="submit" class="${filterVal == '0' ? 'active' : ''}">미완료</button>
			</form>
	
			<form action="todoList" method="get" style="display: inline;">
				<input type="hidden" name="filter" value="1" />
				<button type="submit" class="${filterVal == '1' ? 'active' : ''}">완료</button>
			</form>
	
			<form action="todoList" method="get" style="display: inline;">
			  <input type="hidden" name="important" value="1" />
			  <button type="submit" class="${param.important == '1' ? 'active' : ''}">중요</button>
			</form>
	
		</div>
	
		<!-- 할 일 목록 -->
		<ul class="todo-list">
	
			<!-- 선택한 필터에 해당하는 목록이 없을 경우 -->
			<c:if test="${empty todoList}">
				<li class="empty-message">해당 항목이 없습니다.</li>
			</c:if>
	
			<c:forEach var="todo" items="${todoList}">
	
				<li class="todo-item ${todo.status == '1' ? 'completed' : ''}"
					data-id="${todo.itemNum}">
					
					${todo.content}
					
					<span class="status-text">
						<c:choose>
							<c:when test="${todo.status == '1'}">(완료)</c:when>
							<c:otherwise>(미완료)</c:otherwise>
						</c:choose>
					</span>
				
				<!-- 중요, 삭제 버튼 추가 -->
					<div class="todo-actions">
					
						<button class="important">
						
							<c:choose>
								<c:when test="${todo.important == '0'}">
									<span><i class="fa-solid fa-star" style="color: #bec4cf;"></i></span>
								</c:when>
								<c:otherwise>
									<i class="fa-solid fa-star" style="color: #FFD43B;"></i>
								</c:otherwise>
							</c:choose>
							
						</button>
						
						<span class="priority-badge">${todo.priority}</span>
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
			src="${pageContext.request.contextPath}/js/statusUpdate.js">
		</script>
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/importantToggle.js">
		</script>
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/itemDelete.js">
		</script>
	
	</body>

</html>
