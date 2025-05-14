<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="openapi.*,openapi.ApiDataDTO.*, java.util.List"%>

<%
	List<Item> itemList = null;
	
	String serviceKey = "3O0NpT1ikZKiN7sY5jvXQSvYU1CBwrv8r4lwNNFLbbow7IS6joHFtkIHnwiZbMPNuRFFVahSfFc7rFPkuhH7bg%3D%3D";
	String srcUrl = "http://apis.data.go.kr/1320000/PlanCrossRoadInfoService/getPlanCRHDInfo";
	
	try {
		
		Class<ApiDataDTO> dto = ApiDataDTO.class;
		ApiDataDTO data = (ApiDataDTO) ApiExplorer.getApiJsonData(serviceKey, srcUrl, dto);
	
		if (data.getItemList() != null && data.getItemList().size() > 0) {
			
			itemList = data.getItemList();
			
		}
		
		/* insert 용 */
		if (itemList != null && !itemList.isEmpty()) {
			
			ApiDataDAO insertDao = new ApiDataDAO();
			insertDao.insertData(data);
			
		}
		
	} catch (Exception e) {
		
		System.out.println(e.getMessage());
		
	}
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>공공 데이터</title>
		<link href="index.css" rel="stylesheet" type="text/css">
	</head>
	
	<body>
		<!-- 데이터 조회용 -->
		<%
			ApiDataDAO selectDao = new ApiDataDAO();
			List<Item> selectList = selectDao.getList();
		
		%>

<%-- 		<%
			if (itemList != null && !itemList.isEmpty()) {
		%> --%>
		<table>
		
			<thead>
				<tr>
					<th>지역 코드</th>
					<th>계획 번호</th>
					<th>계획 일</th>
					<th>교차로 번호</th>
					<th>계획 월</th>
					<th>교차로 이름</th>
					<th>수집 일시</th>
					<th>계획 일련번호</th>
				</tr>
			</thead>
			
			<tbody>
				<%
				for (Item item : selectList) {
				%>
				<tr>
					<td><%=item.getRegionCd()%></td>
					<td><%=item.getIntPlanNo()%></td>
					<td><%=item.getHolyPlanDd()%></td>
					<td><%=item.getIntNo()%></td>
					<td><%=item.getHolyPlanMm()%></td>
					<td><%=item.getIntNm()%></td>
					<td><%=item.getCollctDtime()%></td>
					<td><%=item.getPlanSn()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
			
		</table>
		
<%--  		<%
		}
		%> --%>
		
	</body>
	
</html>