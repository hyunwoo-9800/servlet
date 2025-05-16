<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%

	int dan =  Integer.parseInt(request.getParameter("dan"));

%>

<html>

<head>
<meta charset="UTF-8">
<title><%= dan %>단 출력</title>
</head>
<body>

	
	<table border="1"  width="500px">
		<tr align="center" bgcolor="#FFFF00">
			<td colspan="2"><%= dan %>단 출력</td>
		</tr>

		<% for (int i = 1; i < 10; i++) { %>

		<tr align="center">
			<td><%= dan %> * <%= i %></td>
			<td><%= i * dan %></td>
		</tr>

		<% } %>

	</table>


</body>

</html>