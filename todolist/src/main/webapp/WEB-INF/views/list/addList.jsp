<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- addList.jsp -->
<html>

	<head>
		<title>Add List</title>
		<link href="${pageContext.request.contextPath}/css/list/addList.css"
			rel="stylesheet" type="text/css">
	</head>

	<body>
		
		<!-- 할 일 목록 추가용 form -->
		<form class="add-form"
			action="${pageContext.request.contextPath}/todo/add" method="post"
			accept-charset="UTF-8">
			<input type="text" name="content" placeholder="할 일을 입력하세요" required />
			
			<!-- 중요도 선택 박스 -->
			<select name="priority">
				<option value="낮음">낮음</option>
				<option value="보통">보통</option>
				<option value="높음">높음</option>
			</select>
			
			<button type="submit">추가</button>
			
		</form>
	
		<script type="text/javascript">
			// JS 전역에 contextPath 저장
			window.contextPath = "${pageContext.request.contextPath}";
		</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/itemDelete.js">
		</script>
		
	</body>

</html>
