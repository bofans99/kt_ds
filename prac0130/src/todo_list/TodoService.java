package todo_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import list_address_book.Address;

public class TodoService {

	private List<ToDoVO> ToDoList = new ArrayList<>();

	/**
	 * 할일 등록
	 * 순번은 ToDoList의 size로 생성하고 조회수는 0을 초기화
	 * @param todo 제목
	 */
	public void create(String todo) {
		ToDoVO ToDoVO = new ToDoVO();
		ToDoVO.setNumber(ToDoList.size());
		ToDoVO.setTodo(todo);
		ToDoVO.setDon(false);
		ToDoList.add(ToDoVO);

	}
	
	/**
	 * 할일 수정
	 * @param index 게시글의 인덱스
	 * @param todo 제목
	 */
	public void update(int index, boolean don) {
		ToDoVO ToDoVO = ToDoList.get(index);
		ToDoVO.setDon(don);
	}

	/**
	 * 할일 삭제
	 * @param index 삭제하려는 할일 인덱스
	 */
	public void delete(int index) {
		ToDoList.remove(index);

	}

	/**
	 * 할일 조회
	 */
	public void read() {
		if(ToDoList.size()==0) {
			System.out.println("할일이 존재하지 않습니다.");
			return ;//종료
		}
		for (ToDoVO td : ToDoList) {
			String don ="";
			if(td.isDon()) {  don = "O"; }
			else {  don = "X"; }
			System.out.print("할일 "+(td.getNumber()+1)+". ");
			System.out.print("[" + don +"}");
			System.out.println(td.getTodo());
		}
	}

	public static void main(String[] args) {
		TodoService TdService = new TodoService();
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("==============");
			System.out.println("메뉴 입력");
			System.out.println("1.등록");
			System.out.println("2.수정");
			System.out.println("3.삭제");
			System.out.println("4.조회");
			System.out.println("5.종료");
			System.out.println("==============");
			int menu = scan.nextInt();
			scan.nextLine();
			if(menu==1) {
				System.out.println("할일 입력");
				String todo = scan.nextLine();
				TdService.create(todo);
				System.out.println("게시글 등록 완.");
				//TdService.readAllForeach();
				//TdService.read(0);
			}else if (menu==2) {
				System.out.println("수정할 글번호입력");
				int num = scan.nextInt();
				scan.nextLine();
				System.out.println("완료는 Y / 미완료는 N");
				String YN = scan.next();
				if(YN.equals("Y")||YN.equals("y")) {
					TdService.update((num-1), true);
					System.out.println("완료로 변경되었습니다.");
				}else if(YN.equals("N")||YN.equals("n")) {
					TdService.update((num-1), false);
					System.out.println("미완료로 변경되었습니다.");
				}else {
					System.out.println("Y나 N만 입력하라고");
				}
			}else if (menu==3) {
				System.out.println("삭제할 할일번호입력");
				int dm = scan.nextInt();
				TdService.delete(dm-1);
				System.out.println("삭제 완.");
			}else if (menu==4) {
				TdService.read();
			}else if(menu==5){
				System.out.println("종료합니다.");
				break;
			}else {
				System.out.println("메뉴의 번호를 입력하세요.");
			}
		}
	}
}




