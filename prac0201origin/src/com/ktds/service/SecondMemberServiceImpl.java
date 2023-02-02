package com.ktds.service;

import java.util.List;
import java.util.Map;

import com.ktds.dao.ListMemberDAOImpl;
import com.ktds.dao.MapMemberDAOImpl;
import com.ktds.dao.MemberDAO;
import com.ktds.vo.MemberVO;

public class SecondMemberServiceImpl 
implements MemberService{
	private MemberDAO memberDAO;
	public SecondMemberServiceImpl () {
		//memberDAO = new MapMemberDAOImpl();
		memberDAO = new ListMemberDAOImpl();

	}
	@Override
	public boolean create(MemberVO memberVO) {
		System.out.println("SecondMemberServiceImpl.create");
		return memberDAO.create(memberVO) > 0;
	}
	@Override
	public List<MemberVO> readAll() {
		return memberDAO.readAll();
	}
}
