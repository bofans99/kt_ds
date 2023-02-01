package todo_list_ans;

public class TodoItemVo {
	   
	//상수
	//변수
	private String itemName;
	private boolean isSuccess;
	//생성자
	
	public TodoItemVO(String itemName) {
	   setItemName(itemName);
	   // boolean 타입의 기본값은 false이기 때문에 초기화 필요 X
	}
	//Getter Setter생성