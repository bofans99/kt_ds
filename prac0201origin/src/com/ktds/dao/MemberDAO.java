package com.ktds.dao;

import java.util.List;
import java.util.Map;

import com.ktds.vo.MemberVO;

public interface MemberDAO {
	public int create(MemberVO memberVO);
	public List<MemberVO> readAll();

}
