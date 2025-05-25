<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Add List</title>
<link href="${pageContext.request.contextPath}/css/list/addList.css"
	rel="stylesheet" type="text/css">
</head>

<body>
	<form class="add-form"
		action="${pageContext.request.contextPath}/todo/add" method="post">
		<input type="text" name="content" placeholder="할 일을 입력하세요" required />
		<button type="submit">추가</button>
	</form>

	<script type="text/javascript">
		// JS 전역에 contextPath 저장
		window.contextPath = "${pageContext.request.contextPath}";
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/itemDelete.js"></script>
</body>

</html>
