<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- addList.jsp -->
<html>

	<head>
		<title>Add List</title>
		<link href="${pageContext.request.contextPath}/css/list/addList.css"
			rel="stylesheet" type="text/css">
		<link rel="stylesheet"
			href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
			crossorigin="anonymous" />
	</head>

	<body>
	
		<form class="add-form"
			action="${pageContext.request.contextPath}/todo/add" method="post"
			accept-charset="UTF-8">
	
			<!-- 카테고리 버튼 -->
			<div class="category-buttons">
				<button type="button" class="category" value="일반">
					<i class="fa-solid fa-house"></i> 일반
				</button>
				<button type="button" class="category" value="업무">
					<i class="fa-solid fa-briefcase"></i> 업무
				</button>
				<button type="button" class="category" value="운동">
					<i class="fa-solid fa-person-running"></i> 운동
				</button>
				<button type="button" class="category" value="개인">
					<i class="fa-solid fa-user"></i> 개인
				</button>
			</div>
	
			<input type="hidden" name="category" id="selectedCategory" />
	
			<!-- 입력창 + 셀렉트 + 버튼 묶기 -->
			<div class="input-row">
				<input type="text" name="content" placeholder="할 일을 입력하세요" required />
				<select name="priority" class="priority-select">
					<option value="낮음">낮음</option>
					<option value="보통">보통</option>
					<option value="높음">높음</option>
				</select>
				<button type="submit">추가</button>
			</div>
			
		</form>
	
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/selectCategory.js">
		</script>
	
	</body>
</html>
