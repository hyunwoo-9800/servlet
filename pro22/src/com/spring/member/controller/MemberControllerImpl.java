package com.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.member.service.MemberService;

// 컨트롤러 인터페이스 구현 클래스
public class MemberControllerImpl extends MultiActionController implements MemberController {

	private MemberService memberService;

	public void setMemberService(MemberService memberService) {

		this.memberService = memberService;

	}

	// 멤버 조회용 컨트롤러
	@Override
	public ModelAndView listMembers(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// TODO Auto-generated method stub
		String viewName = getViewName(req);
		List membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);

		return mav;
	}

	/**
	 * 요청 URI로부터 뷰 이름(View Name)을 추출합니다.
	 * <p>
	 * 이 메서드는 요청 URI에서 컨텍스트 경로, 쿼리스트링, 세미콜론 파라미터, 확장자 등을 제거하고,
	 * 마지막 경로 요소(파일명)를 뷰 이름으로 반환합니다.
	 * 예: "/app/board/list.do" → "/list"
	 *
	 * @param request HttpServletRequest 객체
	 * @return 뷰 이름 (확장자 없이 마지막 경로 부분, 슬래시 포함)
	 * @throws Exception 예외 발생 시
	 */
	private String getViewName(HttpServletRequest request) throws Exception {

		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");

		if (uri == null || uri.trim().equals("")) {

			uri = request.getRequestURI();

		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {

			begin = contextPath.length();

		}

		int end;

		if (uri.indexOf(";") != -1) {

			end = uri.indexOf(";");

		} else if (uri.indexOf("?") != -1) {

			end = uri.indexOf("?");

		} else {

			end = uri.length();

		}

		String fileName = uri.substring(begin, end);

		if (fileName.indexOf(".") != -1) {

			fileName = fileName.substring(0, fileName.lastIndexOf("."));

		}

		if (fileName.lastIndexOf("/") != -1) {

			fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());

		}

		return fileName;

	}

} // class끝
