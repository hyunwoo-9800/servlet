<%@page import="dto.BusLocationListDTO.BusLocation"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="controller.*, dao.*, dto.*, java.util.List"%>

<%
	List<BusLocation> items = null;

    String serviceKey = "3O0NpT1ikZKiN7sY5jvXQSvYU1CBwrv8r4lwNNFLbbow7IS6joHFtkIHnwiZbMPNuRFFVahSfFc7rFPkuhH7bg%3D%3D";
    String routeId = "200000150";
    String srcUrl = "https://apis.data.go.kr/6410000/buslocationservice/v2/getBusLocationListv2";

    try {
        BusLocationListDTO data = (BusLocationListDTO) ApiExplorer.getApiJsonData(serviceKey, srcUrl, routeId, BusLocationListDTO.class);

        if (data.getResponse() != null &&
            data.getResponse().getMsgBody() != null &&
            data.getResponse().getMsgBody().getBusLocationList() != null &&
            !data.getResponse().getMsgBody().getBusLocationList().isEmpty()) {

            items = data.getResponse().getMsgBody().getBusLocationList();

            BusLocationListDAO dao = new BusLocationListDAO();
            dao.insertData(data);
        }

    } catch (Exception e) {
    	
        e.printStackTrace();
        
    }
%>

<!DOCTYPE html>
<html>

	<head>
	    <meta charset="UTF-8">
	    <title>경기도 버스위치정보</title>
	    <link href="index.css" rel="stylesheet" type="text/css">
	</head>
	
	<body>
	
		<%
			
			BusLocationListDAO selectDao = new BusLocationListDAO();
			List<BusLocation> selectList = selectDao.getList();
		
		%>
	
	    <table border="1">
	        <thead>
	            <tr>
	                <th>혼잡도</th>
	                <th>저상버스 여부</th>
	                <th>차량 번호판</th>
	                <th>남은 좌석 수</th>
	                <th>버스 노선 ID</th>
	                <th>노선 유형 코드</th>
	                <th>차량 상태 코드</th>
	                <th>정류장 ID</th>
	                <th>노선 내 정류장 순번</th>
	                <th>태그 없는 승차 여부 코드</th>
	                <th>차량 고유 ID</th>
	            </tr>
	        </thead>
	        <tbody>
	            <%
		            if (selectList != null) {
		                for (BusLocation item : selectList) {
	            %>
	            <tr>
	                <td><%=item.getCrowded()%></td>
	                <td><%=item.getLowPlate()%></td>
	                <td><%=item.getPlateNo()%></td>
	                <td><%=item.getRemainSeatCnt()%></td>
	                <td><%=item.getRouteId()%></td>
	                <td><%=item.getRouteTypeCd()%></td>
	                <td><%=item.getStateCd()%></td>
	                <td><%=item.getStationId()%></td>
	                <td><%=item.getStationSeq()%></td>
	                <td><%=item.getTaglessCd()%></td>
	                <td><%=item.getVehId()%></td>
	            </tr>
	            <%
		                }
		            }
	            %>
	        </tbody>
	    </table>
	
	</body>
</html>
