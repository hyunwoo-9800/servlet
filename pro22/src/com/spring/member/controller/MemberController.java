package com.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

// 컨트롤러 인터페이스
public interface MemberController {

	public ModelAndView listMembers(HttpServletRequest req, HttpServletResponse res) throws Exception;
	
} // 인터페이스 끝
