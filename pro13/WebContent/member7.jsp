<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.SimpleDateFormat, sec01.ex01.*" %>
<jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page"></jsp:useBean>
<jsp:setProperty name="m" property="*"></jsp:setProperty>
<jsp:setProperty name="m" property="joinDate" value="${request.param.joinDate}"></jsp:setProperty>

<%
    request.setCharacterEncoding("UTF-8");

    // DB에 회원 추가
    MemberDAO dao = new MemberDAO();
    dao.addMember(m);

    // 모든 회원 목록 가져오기
    List<MemberBean> membersList = dao.listMembers();

    // 날짜 포맷 정의
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>

<!DOCTYPE html>

<html>

	<head>
	    <meta charset="UTF-8">
	    <title>회원 목록창</title>
	</head>
	
	<body>
	
	    <table align="center" width="100%" border="1" cellspacing="0">
	    
	        <tr align="center" bgcolor="#99ccff">
	            <td width="10%">아이디</td>
	            <td width="10%">비밀번호</td>
	            <td width="10%">이름</td>
	            <td width="30%">이메일</td>
	            <td width="20%">가입일</td>
	        </tr>
	
	        <%
	            if (membersList == null || membersList.size() == 0) {
	        %>
	        
	        <tr>
	            <td colspan="5" align="center">
	                <b>등록된 회원이 없습니다.</b>
	            </td>
	        </tr>
	        
	        <%
	        
	            } else {
	            	
	                for (MemberBean member : membersList) {
	                	
	                    String joinDateStr = "";
	                    
	                    if (member.getJoinDate() != null) {
	                    	
	                        joinDateStr = sdf.format(member.getJoinDate());
	                    }
	        %>
	        
	        <tr align="center">
	            <td><%= member.getId() %></td>
	            <td><%= member.getPwd() %></td>
	            <td><%= member.getName() %></td>
	            <td><%= member.getEmail() %></td>
	            <td><%= joinDateStr %></td>
	        </tr>
	        
	        <%
	                } // end for
	                
	            } // end if
	        %>
	        
	        <tr height="1" bgcolor="#99ccff">
	            <td colspan="5"></td>
	        </tr>
	    </table>
	</body>
</html>
