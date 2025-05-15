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

import openapi.ApiDataDTO.Item;

// 데이터 insert용 클래스
public class ApiDataDAO {

	// 커넥션 풀 변수
	private Connection con;
	private PreparedStatement ps;
	private DataSource dataFactory;

	// 생성자
	public ApiDataDAO() {

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
	public int insertData(ApiDataDTO data) {

		int result = 0;

		try {

			con = dataFactory.getConnection();

			String sql = "insert into t_cross(REGION_CD, " +
											  "INT_PLAN_NO, " +
											  "HOLY_PLAN_DD, " +
											  "INT_NO, " +
											  "HOLY_PLAN_MM, " +
											  "INT_NM, " +
											  "COLLCT_DTIME, " +
											  "PLAN_SN) " +
											  "values(?, ?, ?, ?, ?, ?, ?, ?)";

			List<Item> itemList = data.getItemList();
			int count = 0;

			for (Item item : itemList) {

				ps = con.prepareStatement(sql);
				System.out.println("sql = " + sql);
				System.out.println(
							item.getRegionCd() + ":" +
							item.getIntPlanNo() + ":" +
							item.getHolyPlanDd() + ":" +
							item.getIntNo() + ":" +
							item.getHolyPlanMm() + ":" +
							item.getIntNm() + ":" +
							item.getCollctDtime() + ":" +
							item.getPlanSn() + ":");

				ps.setString(1, item.getRegionCd());
				ps.setString(2, item.getIntPlanNo());
				ps.setString(3, item.getHolyPlanDd());
				ps.setString(4, item.getIntNo());
				ps.setString(5, item.getHolyPlanMm());
				ps.setString(6, item.getIntNm());
				ps.setString(7, item.getCollctDtime());
				ps.setString(8, item.getPlanSn());

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
			
			String sql = "select * from t_cross";
			con = dataFactory.getConnection();
			
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			
			// 읽어올 데이터가 있다면
			while(rs.next()) {
				
				Item item = new Item();
				item.setRegionCd(rs.getString("REGION_CD"));
				item.setIntPlanNo(rs.getString("INT_PLAN_NO"));
				item.setHolyPlanDd((rs.getString("HOLY_PLAN_DD")));
				item.setIntNo(rs.getString("INT_NO"));
				item.setHolyPlanMm(rs.getString("HOLY_PLAN_MM"));
				item.setIntNm(rs.getString("INT_NM"));
				item.setCollctDtime(rs.getString("COLLCT_DTIME"));
				item.setPlanSn(rs.getString("PLAN_SN"));
				
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
