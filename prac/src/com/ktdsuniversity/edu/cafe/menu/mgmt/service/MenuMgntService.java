package com.ktdsuniversity.edu.cafe.menu.mgmt.service;

import java.util.List;
import java.util.Map;

import com.ktdsuniversity.edu.cafe.menu.mgmt.vo.MenuMgntVO;

public interface MenuMgntService {
	public boolean create(String category,MenuMgntVO menuMgntVO);
	
	public boolean update(String category, int itemIdx, MenuMgntVO menuMgntVO);
	
	public boolean delete(String category, int itemIdx);
	
	public MenuMgntVO read(String category, int itemIdx);
	
	public List<MenuMgntVO> readSome(String category);
	
	public Map<String, List<MenuMgntVO>> readAll();
}

