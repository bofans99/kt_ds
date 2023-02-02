package com.ktds.service;

import java.util.List;

import com.ktds.dao.MapMemberDAOImpl;
import com.ktds.dao.MemberDAO;
import com.ktds.vo.MemberVO;

public class MemberServiceImpl 
implements MemberService{
	private MemberDAO memberDAO;
	public MemberServiceImpl () {
		memberDAO = new MapMemberDAOImpl();
	}
	@Override
	public boolean create(MemberVO memberVO) {
		System.out.println("MemberServiceImpl.create");
		return memberDAO.create(memberVO) > 0;
	}
	@Override
	public List<MemberVO> readAll() {
		return memberDAO.readAll();
	}
}
