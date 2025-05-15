<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="openapi.*,openapi.ApiDataDTO2.*, java.util.List"%>

<%
	List<ApiDataDTO2.Item> items = null;
	
	String serviceKey = "azuwE8nDzBbDI%2B2BHA9LYLCpF7ePjarJFg7tcbHh4zmHPfB2wSM16DNtPwCQAW%2FvIFn94C%2FUoMNeh1dbu4dnJg%3D%3D";
	String srcUrl = "http://api.data.go.kr/openapi/tn_pubr_public_trrsrt_api";
	
	try {
	
		Class<ApiDataDTO2> dto = ApiDataDTO2.class;
		ApiDataDTO2 data = (ApiDataDTO2) ApiExplorer2.getApiJsonData(serviceKey, srcUrl, dto);
	
		if (0 < data.getResponse().getBody().getItems().size()) {
	
			items = data.getResponse().getBody().getItems();
	
		}
		
		/* insert 용 */
		if (items != null && !items.isEmpty()) {
			
			ApiDataDAO2 insertDao = new ApiDataDAO2();
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
		<title>관광 표준 데이터</title>
		<!-- <link href="index.css" rel="stylesheet" type="text/css"> -->
	</head>
	
	<body>
	
		<%
			/* if (items != null && !items.isEmpty()) { */
			ApiDataDAO2 selectDao = new ApiDataDAO2();
			List<Item> selectList = selectDao.getList();
		%>
	
		<table border="1">
	
			<thead>
				<tr>
					<th>관광지명</th>
					<th>관광지구분</th>
					<th>소재지도로명주소</th>
					<th>소재지지번주소</th>
					<th>위도</th>
					<th>경도</th>
					<th>면적</th>
					<th>공공편익시설정보</th>
					<th>숙박시설정보</th>
					<th>운동및오락시설정보</th>
					<th>휴양및문화시설정보</th>
					<th>접객시설정보</th>
					<th>지원시설정보</th>
					<th>지정일자</th>
					<th>수용인원수</th>
					<th>주차가능수</th>
					<th>관리기관전화번호</th>
					<th>관광지소개</th>
					<th>관리기관명</th>
					<th>데이터기준일자</th>
					<th>제공기관코드</th>
				</tr>
			</thead>
	
			<tbody>
			
				<%
					for (ApiDataDTO2.Item item : selectList) {
				%>
				
				<tr>
                <td><%= item.getTrrsrtNm() %></td>
                <td><%= item.getTrrsrtSe() %></td>
                <td><%= item.getRdnmadr() %></td>
                <td><%= item.getLnmadr() %></td>
                <td><%= item.getLatitude() %></td>
                <td><%= item.getLongitude() %></td>
                <td><%= item.getAr() %></td>
                <td><%= item.getCnvnncFclty() %></td>
                <td><%= item.getStayngInfo() %></td>
                <td><%= item.getMvmAmsmtFclty() %></td>
                <td><%= item.getRecrtClturFclty() %></td>
                <td><%= item.getHospitalityFclty() %></td>
                <td><%= item.getSportFclty() %></td>
                <td><%= item.getAppnDate() %></td>
                <td><%= item.getAceptncCo() %></td>
                <td><%= item.getPrkplceCo() %></td>
                <td><%= item.getPhoneNumber() %></td>
                <td><%= item.getTrrsrtIntrcn() %></td>
                <td><%= item.getInstitutionNm() %></td>
                <td><%= item.getReferenceDate() %></td>
                <td><%= item.getInsttCode() %></td>
				</tr>
				<%
					}
				%>
			</tbody>
	
		</table>
	
<%-- 		<%
			} else {
		%> --%>
		
<%-- 		<p>데이터가 없거나 로드하는 중 오류가 발생했습니다.</p>
		
		<%
			}
		%> --%>
	
	
</body>

</html>