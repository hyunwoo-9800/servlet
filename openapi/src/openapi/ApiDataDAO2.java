package openapi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import openapi.ApiDataDTO2.Item;

// 데이터 insert용 클래스
public class ApiDataDAO2 {

	// 커넥션 풀 변수
	private Connection con;
	private PreparedStatement ps;
	private DataSource dataFactory;

	// 생성자
	public ApiDataDAO2() {

		try {

			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();

		}

	}

	// 테이블에 저장
	public int insertData(ApiDataDTO2 data) {

		int result = 0;

		try {

			con = dataFactory.getConnection();

			String sql = "insert into T_TOUR(TRRSRTNM, " +
											  "TRRSRTSE, " +
											  "RDNMADR, " +
											  "LNMADR, " +
											  "LATITUDE, " +
											  "LONGITUDE, " +
											  "AR, " +
											  "CNVNNCFCLTY, " +
											  "STAYNGINFO, " +
											  "MVMAMSMTFCLTY, " +
											  "RECRTCLTURFCLTY, " +
											  "HOSPITALITYFCLTY, " +
											  "SPORTFCLTY, " +
											  "APPNDATE, " +
											  "ACEPTNCCO, " +
											  "PRKPLCECO, " +
											  "TRRSRTINTRCN, " +
											  "PHONENUMBER, " +
											  "INSTITUTIONNM, " +
											  "REFERENCEDATE, " +
											  "INSTTCODE, " +
											  "INSTTNM) " +
											  "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			List<Item> itemList = data.getResponse().getBody().getItems();
			int count = 0;

			for (Item item : itemList) {

				ps = con.prepareStatement(sql);

				ps.setString(1, item.getTrrsrtNm());
				ps.setString(2, item.getTrrsrtSe());
				ps.setString(3, item.getRdnmadr());
				ps.setString(4, item.getLnmadr());
				ps.setString(5, item.getLatitude());
				ps.setString(6, item.getLongitude());
				ps.setString(7, item.getAr());
				ps.setString(8, item.getCnvnncFclty());
				ps.setString(9, item.getStayngInfo());
				ps.setString(10, item.getMvmAmsmtFclty());
				ps.setString(11, item.getRecrtClturFclty());
				ps.setString(12, item.getHospitalityFclty());
				ps.setString(13, item.getSportFclty());
				ps.setString(14, item.getAppnDate());
				ps.setString(15, item.getAceptncCo());
				ps.setString(16, item.getPrkplceCo());
				ps.setString(17, item.getTrrsrtIntrcn());
				ps.setString(18, item.getPhoneNumber());
				ps.setString(19, item.getInstitutionNm());
				ps.setString(20, item.getReferenceDate());
				ps.setString(21, item.getInsttCode());
				ps.setString(22, item.getInsttNm());

				result = ps.executeUpdate();
				
				if (result < 1) {
					
					throw new Exception("입력 중 오류 발생");
					
				}
				
				if (10 < count++) {
					
					break;
					
				}

			}

		} catch (Exception e) {
			
			// TODO: handle exception
			System.out.println("SQL 구문 실행 중 예외 발생 : " + e.toString());
		
		}  finally {
			
			try {
				
				ps.close();
				con.close();
				
			} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
		}
		
		return result;

	} // 메서드 종료
	
	// data 조회용 메서드
	public List<Item> getList() {
		
		// 데이터를 저장할 변수
		List<Item> itemList = new ArrayList<>();
		
		try {
			
			String sql = "select * from t_tour";
			con = dataFactory.getConnection();
			
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			// 읽어올 데이터가 있다면
			while(rs.next()) {
				
				Item item = new Item();
				
				item.setTrrsrtNm(rs.getString("TRRSRTNM"));
				item.setTrrsrtSe(rs.getString("TRRSRTSE"));
				item.setRdnmadr(rs.getString("RDNMADR"));
				item.setLnmadr(rs.getString("LNMADR"));
				item.setLatitude(rs.getString("LATITUDE"));
				item.setLongitude(rs.getString("LONGITUDE"));
				item.setAr(rs.getString("AR"));
				item.setCnvnncFclty(rs.getString("CNVNNCFCLTY"));
				item.setStayngInfo(rs.getString("STAYNGINFO"));
				item.setMvmAmsmtFclty(rs.getString("MVMAMSMTFCLTY"));
				item.setRecrtClturFclty(rs.getString("RECRTCLTURFCLTY"));
				item.setHospitalityFclty(rs.getString("HOSPITALITYFCLTY"));
				item.setSportFclty(rs.getString("SPORTFCLTY"));
				item.setAppnDate(rs.getString("APPNDATE"));
				item.setAceptncCo(rs.getString("ACEPTNCCO"));
				item.setPrkplceCo(rs.getString("PRKPLCECO"));
				item.setTrrsrtIntrcn(rs.getString("TRRSRTINTRCN"));
				item.setPhoneNumber(rs.getString("PHONENUMBER"));
				item.setInstitutionNm(rs.getString("INSTITUTIONNM"));
				item.setReferenceDate(rs.getString("REFERENCEDATE"));
				item.setInsttCode(rs.getString("INSTTCODE"));
				item.setInsttNm(rs.getString("INSTTNM"));

				itemList.add(item);
				
			}
			
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("조회 중 에러 발생");
			
		} finally {
			
			try {
				
				ps.close();
				con.close();
				
			} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
		}
		
		return itemList;
		
		
	} // 메서드 종료
	

} // class 끝
