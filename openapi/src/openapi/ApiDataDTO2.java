package openapi;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import openapi.ApiDataDTO.Item;

// 공공 데이터 저장용 DTO클래스
@Data
@NoArgsConstructor
public class ApiDataDTO2 {

	private response response;
	private header header;
	private body body;

	// 데이터를 list로 저장하기 위함
	private List<Item> itemList;
	
	@Data
	@NoArgsConstructor
	public static class response {

		private header header;

		private body body;

	}

	@Data
	@NoArgsConstructor
	public static class header {

		private String resultCode;

		private String resultMsg;

		private String type;

	}

	@Data
	@NoArgsConstructor
	public static class body {

		private List<Item> items;

		private int totalCount;

		private String numOfRows;

		private String pageNo;

	}

	@Data
	@NoArgsConstructor
	public static class Item {

        private String trrsrtNm;
        
        private String trrsrtSe;
        
        private String rdnmadr;
        
        private String lnmadr;
        
        private String latitude;
        
        private String longitude;
        
        private String ar;
        
        private String cnvnncFclty;
        
        private String stayngInfo;
        
        private String mvmAmsmtFclty;
        
        private String recrtClturFclty;
        
        private String hospitalityFclty;
        
        private String sportFclty;
        
        private String appnDate;
        
        private String aceptncCo;
        
        private String prkplceCo;
        
        private String trrsrtIntrcn;
        
        private String phoneNumber;
        
        private String institutionNm;
        
        private String referenceDate;
        
        private String insttCode;
        
        private String insttNm;

	}

} // class 끝