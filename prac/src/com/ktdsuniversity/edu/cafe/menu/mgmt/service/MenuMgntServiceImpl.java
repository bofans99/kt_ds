package com.ktdsuniversity.edu.cafe.menu.mgmt.service;

import java.util.List;
import java.util.Map;

import com.ktdsuniversity.edu.cafe.menu.mgmt.dao.MenuMgntDAO;
import com.ktdsuniversity.edu.cafe.menu.mgmt.dao.MenuMgntDAOImpl;
import com.ktdsuniversity.edu.cafe.menu.mgmt.vo.MenuMgntVO;

public class MenuMgntServiceImpl implements MenuMgntService{

	private MenuMgntDAO menuMgntDAO;	
	
	public MenuMgntServiceImpl () {
		menuMgntDAO = new MenuMgntDAOImpl();

	}

	@Override
	public boolean create(String category, MenuMgntVO menuMgntVO) {
		return menuMgntDAO.create(category,menuMgntVO) > 0;
	}

	@Override
	public boolean update(String category, int itemIdx, MenuMgntVO menuMgntVO) {
		return menuMgntDAO.update(category, itemIdx, menuMgntVO)>0;
	}

	@Override
	public boolean delete(String category, int itemIdx) {
		return menuMgntDAO.delete(category, itemIdx)>0;
	}

	@Override
	public MenuMgntVO read(String category, int itemIdx) {
		return menuMgntDAO.read(category, itemIdx);
	}

	@Override
	public List<MenuMgntVO> readSome(String category) {
		return menuMgntDAO.readSome(category);
	}

	@Override
	public Map<String, List<MenuMgntVO>> readAll() {
		return menuMgntDAO.readAll();
	}

}
