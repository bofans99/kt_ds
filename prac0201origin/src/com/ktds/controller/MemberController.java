package com.ktds.controller;

import java.util.List;

import com.ktds.service.MemberService;
import com.ktds.service.MemberServiceImpl;
import com.ktds.service.SecondMemberServiceImpl;
import com.ktds.vo.MemberVO;

public class MemberController {
	public static void main(String[] args) {
		
		//MemberService service = new MemberServiceImpl(); 
		MemberService service = new SecondMemberServiceImpl();
		
		MemberVO member = new MemberVO();
		member.setId("id1");
		member.setPw("pw1");
		member.setReadNum(1);
		member.setPageNum(0);
		service.create(member);
		
		member = new MemberVO();
		member.setId("id2");
		member.setPw("pw2");
		member.setReadNum(2);
		member.setPageNum(0);
		service.create(member);

		member = new MemberVO();
		member.setId("id3");
		member.setPw("pw3");
		member.setReadNum(3);
		member.setPageNum(0);
		service.create(member);

		List<MemberVO> memList = service.readAll();
		for(MemberVO eachMember : memList) {
			System.out.println(eachMember.getId());
			System.out.println(eachMember.getPw());
			System.out.println(eachMember.getReadNum());
			System.out.println(eachMember.getPageNum());
		}
	}
}
