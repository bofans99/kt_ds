package com.ktdsuniversity.edu.cafe.menu.mgmt.controller;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import com.ktdsuniversity.edu.cafe.menu.mgmt.service.MenuMgntService;
import com.ktdsuniversity.edu.cafe.menu.mgmt.service.MenuMgntServiceImpl;
import com.ktdsuniversity.edu.cafe.menu.mgmt.vo.MenuMgntVO;

public class MenuMgntController {

	public static void main(String[] args) {
		MenuMgntController controller = new MenuMgntController();
		MenuMgntService service = new MenuMgntServiceImpl();
		//MenuMgntVO menuMgnt = new MenuMgntVO();

		Scanner scan = new Scanner(System.in);
		System.out.println("Cafe Menu Management System");
		while (true) {
			try {

				controller.printMenu();
				System.out.println("메뉴 입력(숫자): ");
				int menu = scan.nextInt();
				if (menu == 1) {// 1.등록
					controller.printCategory();
					System.out.println("등록할 카테고리를 입력하세요(숫자): ");
					int category = scan.nextInt();
					scan.nextLine();

					System.out.println("등록할 아이템명을 입력하세요(문자): ");
					String categoryItem = scan.nextLine();

					MenuMgntVO menuMgnt = new MenuMgntVO();
					menuMgnt.setItemName(categoryItem);
					service.create(controller.toCategoryName(category), menuMgnt);
					System.out.println(categoryItem + " 메뉴가 등록되었습니다.");
				} else if (menu == 2) {// 2.수정
					controller.printMenu();

					System.out.print("수정할 메뉴 카테고리를 입력하세요(숫자): ");
					int category = scan.nextInt();
					scan.nextLine();

					System.out.print("수정할 아이템 인덱스를 입력하세요(숫자): ");
					int itemIdx = scan.nextInt();

					if (service.readSome(controller.toCategoryName(category)).size()==0||itemIdx > service.readSome(controller.toCategoryName(category)).size()) {
						System.out.println("아이템이 존재하지않습니다.");
					} else {
						System.out.print("수정할 아이템명을 입력하세요(문자): ");
						String categoryItem = scan.nextLine();

						MenuMgntVO menuMgnt = new MenuMgntVO();
						menuMgnt.setItemName(categoryItem);
						service.update(controller.toCategoryName(category), itemIdx, menuMgnt);

						System.out.println(categoryItem + "로 수정되었습니다.");
					}
				} else if (menu == 3) {// 3.삭제
					controller.printCategory();

					System.out.print("삭제할 메뉴의 카테고리를 입력하세요(숫자): ");
					int category = scan.nextInt();
					scan.nextLine();
					
					System.out.print("삭제할 아이템 인덱스를 입력하세요(숫자): ");
					int itemIdx = scan.nextInt();
					// scan.nextLine();

					if (service.readSome(controller.toCategoryName(category)).size()==0||itemIdx > service.readSome(controller.toCategoryName(category)).size()) {
						System.out.println("아이템이 존재하지않습니다.");
					} else {
						service.delete(controller.toCategoryName(category), itemIdx);
						System.out.println(itemIdx + "번 삭제완");
					}
				} else if (menu == 4) {// 4. 조회(1개)
					controller.printCategory();
					
					System.out.print("조회할 메뉴의 카테고리를 입력하세요(숫자): ");
					int category = scan.nextInt();
					scan.nextLine();
					
					System.out.print("조회할 아이템 인덱스를 입력하세요(숫자): ");
					int itemIdx = scan.nextInt();
					scan.nextLine();
					if (service.readSome(controller.toCategoryName(category)).size()==0||itemIdx > service.readSome(controller.toCategoryName(category)).size()) {	
						System.out.println("아이템이 존재하지않습니다.");
					}else {
						System.out.println(service.read(controller.toCategoryName(category),itemIdx).getItemName());
					}
				} else if (menu == 5) {// 5. 조회(종목별로)
					controller.printCategory();
					
					System.out.print("조회할 카테고리를 입력하세요(숫자): ");
					int category = scan.nextInt();
					scan.nextLine();
					
					System.out.println("< " + controller.toCategoryName(category) + " >");
					for (MenuMgntVO list : service.readSome(controller.toCategoryName(category))) {
						System.out.println(list.getItemName());
					}
				} else if (menu == 6) {// 6. 조회(전체)
					Map<String, List<MenuMgntVO>> mapList = new HashMap<>(service.readAll());
					for (Map.Entry<String, List<MenuMgntVO>> category : mapList.entrySet()) {
						System.out.println("< " + category.getKey() + " >");
						for (MenuMgntVO list : category.getValue()) {
							System.out.println(list.getItemName());
						}
					}
				} else if (menu == 7) {
					System.out.println("종료합니다.");
					break;
				} else {
					System.out.println("메뉴에 있는 숫자번호를 입력하세요.");
				}
			} catch (InputMismatchException ime) {
				scan = new Scanner(System.in);
				System.out.println("숫자만 입력가능.");
			}
		}
	}

	public String toCategoryName(int categoryNum) {
		if (categoryNum == 1) {
			return "커피";
		} else if (categoryNum == 2) {
			return "음료";
		} else if (categoryNum == 3) {
			return "티";
		} else if (categoryNum == 4) {
			return "디저트";
		} else {
			return "";
		}
	}

	public void printMenu() {
		System.out.println("==============");
		System.out.println("1. 등록");
		System.out.println("2. 수정");
		System.out.println("3. 삭제");
		System.out.println("4. 조회(1개)");
		System.out.println("5. 조회(종목별로)");
		System.out.println("6. 조회(전체)");
		System.out.println("7. 종료");
		System.out.println("==============");
	}

	public void printCategory() {
		System.out.println("==============");
		System.out.println("1. 커피");
		System.out.println("2. 음료");
		System.out.println("3. 티");
		System.out.println("4. 디저트");
		System.out.println("5. 뒤로가기");
		System.out.println("==============");
	}

}
