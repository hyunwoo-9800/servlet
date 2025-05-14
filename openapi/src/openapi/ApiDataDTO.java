package openapi;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

// 공공 데이터 저장용 DTO클래스
@Data
@NoArgsConstructor
public class ApiDataDTO {

	// 데이터를 list로 저장하기 위함
	private List<Item> itemList;

	@Data
	@NoArgsConstructor
	// 저장할 데이터 지정
	public static class Item {

		@JsonProperty("REGION_CD")
		private String regionCd;

		@JsonProperty("INT_PLAN_NO")
		private String intPlanNo;

		@JsonProperty("HOLY_PLAN_DD")
		private String holyPlanDd;

		@JsonProperty("INT_NO")
		private String intNo;

		@JsonProperty("HOLY_PLAN_MM")
		private String holyPlanMm;

		@JsonProperty("INT_NM")
		private String intNm;

		@JsonProperty("COLLCT_DTIME")
		private String collctDtime;

		@JsonProperty("PLAN_SN")
		private String planSn;
	}

} // class 끝