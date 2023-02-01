package todo_list_ans;

import java.util.ArrayList;
import java.util.List;

public class TodoItemService {

	public class TodoItemService {
		   //상수
		   
		   //변수
		   private List <TodoItemVO> todoItemList;
		   
		   //생성자
		   public TodoItemService() {
		      todoItemList = new ArrayList<>();
		   }
		   
		   //Getter Setter
		   public List <TodoItemVO> getTodoItemList() {
		      return todoItemList;
		   }
		   public void setTodoItemList(List<TodoItemVO> todoItemList) {
		      this.todoItemList = todoItemList;
		   }
		   
		   //Method
		   public void create (String itemName) {
		      TodoItemList.add(new TodoItemList(itemName));
		   }
		   
		   public void update (int index, boolean isSuccess) {
		      TodoItemVO todoItem = todoItemList.get(index);
		      todo.setSuccess(isSuccess);
		   }

		   public void delete (int index) {
		      todoItemList.remove(index);
		   }
		   
		   public void read () {
		      for (TodoItemVO todoItem: todoItemList){
		         // String successSymbol = " ";
		         // if (todoItem.isSuccess()) {
		         //     successSymbol = "X";
		         String successSymbol = todoItem.isSuccess() ? "X" : " " ;
		         System.out.println("[" + successSymbol + "]" + todoItem.getItemName());
		      }
		      
		      for (TodoItemVO todoItem: todoItemList) {
		    	  System.out.println("총 " + todoItemList.size() + "개의 아이템이 조회되었습니다.");
		      }
		   }
	}

		   public static void main (String[] args) {
		      TodoItemService service = new TodoItemService();
		      Scanner scan = new Scanner(System.in);

		      System.out.println("<TODO LIST>");
		      
		      while (true) {
		         System.out.println("=========================");
		         System.out.println("1. 등록");
		         System.out.println("2. 수정");
		         System.out.println("3. 삭제");
		         System.out.println("4. 조회");
		         System.out.println("5. 종료");         
		         System.out.println("=========================");
		         System.out.println("메뉴를 입력하세요: ");
		         
		         int menu = scan.nextInt();
		         scan.nextLine();
		         
		         if (menu == 1) {
		            System.out.println("TODO명을 입력하세요: ");
		            String itemName = scan.nextLine();
		            service.creatd(itemName);
		            System.out.println("아이템이 등록되었습니다.");         
		         }

		         else if (menu == 2) {
		            System.out.println("수정할 아이템 번호를 입력하세요: ");
		            int itemIndex = scan.nextInt();
		            scan.nextLine();
		            
		            int listLength = service.getTodoItemList().size();
		            if (listLength <= itemIndex) {
		               System.out.println("아이템이 존재하지 않습니다.");
		            }
		            else {
		               System.out.println("아이템이 완료되었다면 \"Y\"를 입력하세요: " );
		               String yn = scan.nextLine();
		               
		               boolean isY = yn.equalsIgnoreCase("Y");
		               service.update(itemIndex, isY);
		               //service.update(itemIndex, yn.equalsIgnoreCase("Y"));
		               //service.update(itemIndex, yn.toUpperCase().equals("Y"));
		               //service.update(itemIndex, yn.toLowerCase().equals("y"));
		               TodoItemVO todoItem = service.getTodoItemList().get(itemIndex);
		               if (isY) {
		                  System.out.println("[" + todoItem.getItemName() + "]" + "이 완료되었습니다.");
		               }
		               else {
		                  System.out.println("[" + todoItem.getItemName() + "]" + "이 미완료되었습니다.");
		         }

		         else if (menu == 3) {
		            System.out.println("삭제할 아이템 번호를 입력하세요: ");
		            int itemIndex = scan.nextInt();
		            scan.nextLine();
		            
		            int listLength = service.getTodoItemList().size();
		            if (listLength <= itemIndex ) {
		               System.out.println("아이템이 존재하지 않습니다.");
		            }
		            else {
		               todo.delete(itemIndex);
		               System.out.println("아이템이 삭제되었습니다.");
		         }

		         else if (menu == 4) {
		            service.read();
		         }
		   
		         else {
		            System.out.println("프로그램이 종료되었습니다.");
		            break;
		         }
		   }
	
}
