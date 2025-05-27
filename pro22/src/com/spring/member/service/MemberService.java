package com.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

// 서비스 인터페이스
public interface MemberService {

	public List listMembers() throws DataAccessException;

} // 인터페이스 종료
