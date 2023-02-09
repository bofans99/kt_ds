package com.ktdsuniversity.edu.cafe.menu.mgmt.dao;

import java.util.List;
import java.util.Map;

import com.ktdsuniversity.edu.cafe.menu.mgmt.vo.MenuMgntVO;

public interface MenuMgntDAO {
	public int create(String category, MenuMgntVO menuMgntVO);
	
	public int update(String category, int itemIdx, MenuMgntVO menuMgntVO);
	
	public int delete(String category, int itemIdx);
	
	public MenuMgntVO read(String category, int itemIdx);
	
	public List<MenuMgntVO> readSome(String category);
	
	public Map<String, List<MenuMgntVO>> readAll();

}
