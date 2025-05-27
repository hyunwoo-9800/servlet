package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	
	// 커넥션 풀 변수
	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;
	
	// db 연결
	public MemberDAO() {
		
		try {
			
			InitialContext ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

	// 멤버 리스트 검색용 메서드
	public List<MemberVO> listMembers() {
		
		List<MemberVO> membersList = new ArrayList();
		
		try {
			
			conn = dataFactory.getConnection();
			
			String query = "SELECT * FROM  T_MEMBER ORDER BY JOINDATE DESC";
			System.out.println(query);
			
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				System.out.println("id:" + id);
				
				MemberVO memberVO = new MemberVO(id, pwd, name, email, joinDate);
				
				membersList.add(memberVO);
				
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return membersList;
		
	} // listMembers 종료

	// 멤버 추가용 메서드
	public void addMember(MemberVO m) {
		
		try {
			
			conn = dataFactory.getConnection();
			
			String id = m.getId();
			String pwd = m.getPwd();
			String name = m.getName();
			String email = m.getEmail();
			
			String query = "INSERT INTO T_MEMBER(ID, PWD, NAME, EMAIL)" + " VALUES(?, ? ,? ,?)";
			System.out.println(query);
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
	} // addMember 종료
	
} // claas 끝