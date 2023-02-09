package com.ktdsuniversity.edu.cafe.menu.mgmt.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ktdsuniversity.edu.cafe.menu.mgmt.vo.MenuMgntVO;


public class MenuMgntDAOImpl implements MenuMgntDAO{

	private Map<String, List<MenuMgntVO>> dataSource;
	
	public MenuMgntDAOImpl() {
		dataSource = new HashMap<>();
		dataSource.put("커피", new ArrayList<>());
		dataSource.put("음료", new ArrayList<>());
		dataSource.put("티", new ArrayList<>());
		dataSource.put("디저트", new ArrayList<>());
		
	}

	@Override
	public int create(String category, MenuMgntVO menuMgntVO) {
		List<MenuMgntVO> categoryItem = dataSource.get(category);
		categoryItem.add(menuMgntVO);
		return 1;
	}

	@Override
	public int update(String category, int itemIdx, MenuMgntVO menuMgntVO) {
		List<MenuMgntVO> categoryItem = dataSource.get(category);
		categoryItem.set(itemIdx, menuMgntVO);
		
		return 1;
	}

	@Override
	public int delete(String category, int itemIdx) {
		List<MenuMgntVO> categoryItem = dataSource.get(category);
		categoryItem.remove(itemIdx);
		return 1;
	}

	@Override
	public MenuMgntVO read(String category, int itemIdx) {
		return dataSource.get(category).get(itemIdx);
	}

	@Override
	public List<MenuMgntVO> readSome(String category) {
		List<MenuMgntVO> categoryItem = dataSource.get(category);
		return categoryItem;
	}

	@Override
	public Map<String, List<MenuMgntVO>> readAll() {
		return dataSource;
	}



}
