package com.spring.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.member.vo.MemberVO;

// MemberDAO 구현 클래스
public class MemberDAOImpl implements MemberDAO {

	// DB연결
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// 유저 리스트 조회용 메서드
	@Override
	public List selectAllMembers() throws DataAccessException {
		// TODO Auto-generated method stub
		
		String query = "SELECT "
						+ "ID, "
						+ "PWD, "
						+ "NAME, "
						+ "EMAIL, "
						+ "JOINDATE "
						+ "FROM T_MEMBER "
						+ "ORDER BY JOINDATE DESC";
		
		List memberList = new ArrayList();
		
		memberList = this.jdbcTemplate.query(query, new RowMapper() {
			
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				MemberVO memberVO = new MemberVO();
				memberVO.setId(rs.getString("id"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setJoinDate(rs.getDate("joinDate"));
				return memberVO;
				
			}
			
			
		});
		
		return memberList;
		
	} // selectAllMembers 종료

	// 유저 저장용 메서드
	@Override
	public int addMember(MemberVO memberVO) throws DataAccessException {
		// TODO Auto-generated method stub
		
		String id = memberVO.getId();
		String pwd = memberVO.getPwd();
		String name = memberVO.getName();
		String email = memberVO.getEmail();
		
		String query = "INSERT INTO T_MEMBER VALUES("
				+ "'" + id 		+ "' ,"
				+ "'" + pwd 	+ "' ,"
				+ "'" + name 	+ "' ,"
				+ "'" + email 	+ "' ,"
				+ ")";
		
		System.out.println(query);
		
		int result = jdbcTemplate.update(query);
		
		System.out.println(result);
		
		return result;
		
	} // addMember 종료

} // class 끝
