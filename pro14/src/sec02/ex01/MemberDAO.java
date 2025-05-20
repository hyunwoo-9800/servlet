package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	
	// 커넥션 풀 변수
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	// 커넥션 풀
	public MemberDAO() {
		
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

	// 멤버 출력용 메서드
	public List listMembers() {
		
		List list = new ArrayList();
		
		try {
			
			// db 연결
			con = dataFactory.getConnection();
			
			String query = "SELECT * FROM T_MEMBER ORDER BY JOINDATE DESC ";
			System.out.println("prepareStatememt: " + query);
			
			// db에서 데이터를 가져옴
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			// 가져온 데이터가 있으면
			while (rs.next()) {
				
				// 가져온 데이터를 변수에 저장
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				// 변수에 저장된 데이터를 vo객체에 저장
				MemberBean vo = new MemberBean();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				
				list.add(vo);
				
			}
			
			rs.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				pstmt.close();
				con.close();
				
			} catch (Exception e2) {
				
				// TODO: handle exception
				
			}
			
		}
		
		return list;
		
	} // listMembers 메서드 종료

	// 멤버를 추가할 메서드
	public void addMember(MemberBean memberBean) {
		
		try {
			
			// db 연결
			Connection con = dataFactory.getConnection();
			
			List aList = new ArrayList();
			
			// 사용자가 입력한 값을 저장
			String id = memberBean.getId();
			String pwd = memberBean.getPwd();
			String name = memberBean.getName();
			String email = memberBean.getEmail();
			
			String query = "INSERT INTO T_MEMBER";
			query += " (ID, PWD, NAME, EMAIL)";
			query += " values(?, ?, ?, ?)";
			
			System.out.println("prepareStatememt: " + query);
			
			// db에 insert 처리
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	} // addMember 메서드 종료
	
} // class 끝
