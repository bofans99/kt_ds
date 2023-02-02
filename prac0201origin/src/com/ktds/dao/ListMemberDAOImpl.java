package com.ktds.dao;
import java.util.ArrayList;
import java.util.List;

import com.ktds.vo.MemberVO;
public class ListMemberDAOImpl implements MemberDAO{
	private List<MemberVO> dataSource;
	public ListMemberDAOImpl() {
		dataSource = new ArrayList<>();
	}
	@Override
	public int create(MemberVO memberVO) {
		dataSource.add(memberVO);
		System.out.println("ListMemberDAOImpl.create");

		return 1;
	}
	@Override
	public List<MemberVO> readAll() {
		return dataSource;
	}
}
