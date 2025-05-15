package dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

// 공공데이터 저장용 클래스
@Data
@NoArgsConstructor
public class BusLocationListDTO {
	private Response response;

	// response 데이터
	@Data
	@NoArgsConstructor
	@JsonIgnoreProperties(ignoreUnknown = true) // comMsgHeader 무시
	public static class Response {
		private MsgHeader msgHeader;
		private MsgBody msgBody;
	}

	// MsgHeader 데이터
	@Data
	@NoArgsConstructor
	public static class MsgHeader {
		private String queryTime;
		private int resultCode;
		private String resultMessage;
	}

	// msgBody 데이터
	@Data
	@NoArgsConstructor
	public static class MsgBody {
		private List<BusLocation> busLocationList;
	}

	// msgBody의 버스 리스트
	@Data
	@NoArgsConstructor
	public static class BusLocation {
		private String crowded;
		private String lowPlate;
		private String plateNo;
		private String remainSeatCnt;
		private String routeId;
		private String routeTypeCd;
		private String stateCd;
		private String stationId;
		private String stationSeq;
		private String taglessCd;
		private String vehId;
	}
}
