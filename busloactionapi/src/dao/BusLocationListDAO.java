package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.BusLocationListDTO;
import dto.BusLocationListDTO.BusLocation;

// 데이터 insert용 클래스
public class BusLocationListDAO {

	// 커넥션 풀 변수
	private Connection con;
	private PreparedStatement ps;
	private DataSource dataFactory;

	// 생성자
	public BusLocationListDAO() {

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
	public int insertData(BusLocationListDTO data) {

		int result = 0;

		try {

			con = dataFactory.getConnection();

			String sql = "INSERT INTO BUSLOCATION(" +
											  "CROWDED," +
											  "LOWPLATE, " +
											  "PLATENO, " +
											  "REMAINSEATCNT, " +
											  "ROUTEID, " +
											  "ROUTETYPECD, " +
											  "STATECD, " +
											  "STATIONID, " +
											  "STATIONSEQ, " +
											  "TAGLESSCD, " +
											  "VEHID) " +
											  "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			List<BusLocation> itemList = data.getResponse().getMsgBody().getBusLocationList();
			int count = 0;

			for (BusLocation item : itemList) {

				ps = con.prepareStatement(sql);

				ps.setString(1, item.getCrowded());
				ps.setString(2, item.getLowPlate());
				ps.setString(3, item.getPlateNo());
				ps.setString(4, item.getRemainSeatCnt());
				ps.setString(5, item.getRouteId());
				ps.setString(6, item.getRouteTypeCd());
				ps.setString(7, item.getStateCd());
				ps.setString(8, item.getStationId());
				ps.setString(9, item.getStationSeq());
				ps.setString(10, item.getTaglessCd());
				ps.setString(11, item.getVehId());

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
	public List<BusLocation> getList() {
		
		// 데이터를 저장할 변수
		List<BusLocation> itemList = new ArrayList<>();
		
		try {
			
			String sql = "select * from BUSLOCATION";
			con = dataFactory.getConnection();
			
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			// 읽어올 데이터가 있다면
			while(rs.next()) {
				
				BusLocation item = new BusLocation();
				
				item.setCrowded(rs.getString("CROWDED"));
				item.setLowPlate(rs.getString("LOWPLATE"));
				item.setPlateNo(rs.getString("PLATENO"));
				item.setRemainSeatCnt(rs.getString("REMAINSEATCNT"));
				item.setRouteId(rs.getString("ROUTEID"));
				item.setRouteTypeCd(rs.getString("ROUTETYPECD"));
				item.setStateCd(rs.getString("STATECD"));
				item.setStationId(rs.getString("STATIONID"));
				item.setStationSeq(rs.getString("STATIONSEQ"));
				item.setTaglessCd(rs.getString("TAGLESSCD"));
				item.setVehId(rs.getString("VEHID"));

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
