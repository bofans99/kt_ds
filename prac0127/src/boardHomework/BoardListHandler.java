package boardHomework;

import java.util.ArrayList;
import java.util.List;

public class BoardListHandler {


	private List<board> boardList = new ArrayList<>();
	public static int total = 0;
	
	//1.등록 -제목,작성자,순번,조회수 등록
	public void create(String title, String writer) {
		board board = new board();
		++total;
		board.setTitle(title);
		board.setWriter(writer);
		board.setViews(0);
		boardList.add(board);
		
		//return total;
	}

	//2.전체 글 출력
	public void print(int index) {

		System.out.println("~~~~~~~~~~~~~~~게시판~~~~~~~~~~~~~~~");
		//board board = boardList.get(index-1);
		for (int i = 0; i < index; i++) {

			board board = boardList.get(i);
			System.out.println("<글번호 : " + (i+1) + ">");
			System.out.println("제목 : " + board.getTitle());
			System.out.println("작성자 : " + board.getWriter());
			System.out.println("조회수 : " + board.getViews());
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		}
	}
	
	//3.수정 -제목만 수정 가능
	public void update(int index, String title) {
		board board = boardList.get(index);
		board.setTitle(title);
		System.out.println("ㅁㅁㅁㅁ수정완료ㅁㅁㅁㅁ.");
	}

	//4.삭제 -한 게시글만 삭제 가능
	public void delete(int index) {
		--total;
		//board.setTotal(++total);
		boardList.remove(index);
		System.out.println("ㅁㅁㅁㅁ삭제완료ㅁㅁㅁㅁ.");
	}

	//5.조회 -제목,작성자,순번,조회수 출력  -게시글을 조회하면 조회수가 1증가  
	public void read(int index) {
		board board = boardList.get(index);
		int views = board.getViews();//현재 조회수 받아와서 할당
		board.setViews(++views);//조회수 증가

		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("<글번호 : " + (index+1) + ">");
		System.out.println("제목 : " + board.getTitle());
		System.out.println("작성자 : " + board.getWriter());
		System.out.println("조회수 : " + board.getViews());
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	}



	
	public static void main(String[] args) {
		BoardListHandler handler = new BoardListHandler();
		
		handler.create("밥먹는방법", "이유나");
		handler.create("집에가는방법", "이순신");
		handler.print(total);//전체출력
		
		handler.update(1, "제목바꿨다");
		handler.print(total);
		
		handler.delete(0);
		handler.print(total);
	}

}
