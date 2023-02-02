package com.ktds.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ktds.vo.MemberVO;
public class MapMemberDAOImpl implements MemberDAO{

	private Map<String, MemberVO> dataSource;
	
	public MapMemberDAOImpl() {
		dataSource = new HashMap<>();
	}
	@Override
	public int create(MemberVO memberVO) {
		dataSource.put(memberVO.getId(), memberVO);
		System.out.println("MapMemberDAOImpl.create");
		return 1;
	}
	@Override
	public List<MemberVO> readAll() {
		return dataSource.entrySet()
				.stream()
				.map(entry -> entry.getValue())
				.collect(Collectors.toList());
	}
}
