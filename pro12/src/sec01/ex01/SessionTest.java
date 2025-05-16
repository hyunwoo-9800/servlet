package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest
 */
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();
		session.setAttribute("name", "고길동");
		pw.println("<head><title>session 내장 객체 테스트1</title></head>");
		pw.println("<html><body>");
		pw.println("<h1>세션에 이름을 바인딩합니다.</h1>");
		pw.println("<a href = '/pro12/test01/session1.jsp'>첫 번째 페이지로 이동하기</a>");
		pw.println("</html></body>");
	}

}
