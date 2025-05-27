package com.spring.ex03;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memDAO;

	public void setMemberDAO(MemberDAO memDAO) {

		this.memDAO = memDAO;

	}

	@Override
	public void listMembers() {
		// TODO Auto-generated method stub

		memDAO.listMembers();

	} // main 끝

} // class 끝
