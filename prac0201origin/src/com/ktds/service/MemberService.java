package com.ktds.service;

import java.util.List;
import java.util.Map;

import com.ktds.vo.MemberVO;

public interface MemberService {
	public boolean create(MemberVO memberVO);
	public List<MemberVO> readAll();
	
}

