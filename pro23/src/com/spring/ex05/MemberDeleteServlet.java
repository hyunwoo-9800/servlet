package com.spring.ex05;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.ex01.MemberVO;

@WebServlet("/delete.do")
public class MemberDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");

		String id = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
		id = id.replaceAll(".*\"id\"\\s*:\\s*\"(.*?)\".*", "$1"); // 간단한 JSON 파싱

		MemberDAO dao = new MemberDAO();
		dao.deleteMember(id);

		response.getWriter().write("{\"success\": true}");
	}
}


