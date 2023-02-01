package board_menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import list_address_book.Address;




public class BoardService {

	private List<BoardVO> boardList = new ArrayList<>();

	/**
	 * 게시글 등록
	 * 순번은 boardList의 size로 생성하고 조회수는 0을 초기화
	 * @param subject 제목
	 * @param writer 작성자
	 */
	public void create(String subject, String writer) {
		BoardVO boardVO = new BoardVO();
		boardVO.setNumber(boardList.size());
		boardVO.setSubject(subject);
		boardVO.setWriter(writer);
		boardVO.setReadCnt(0);
		boardList.add(boardVO);

	}
	
	/**
	 * 게시글 수정
	 * 제목만 수정할 수 있다.
	 * @param index 게시글의 인덱스
	 * @param subject 제목
	 */
	public void update(int index, String subject) {
		BoardVO boardVO = boardList.get(index);
		boardVO.setSubject(subject);

	}

	/**
	 * 게시글 삭제
	 * 한 건의 게신글만 삭제할 수 있다.
	 * @param index 삭제하려는 게시글의 인덱스
	 */
	public void delete(int index) {
		boardList.remove(index);

	}

	/**
	 * 게시글 조회
	 * @param index 조회하려는 게시글의 인덱스
	 */
	public void read(int index) {
		if(boardList.size()<index) {
			System.out.println(index +"번 게시글은 존재하지 않습니다.");
			return ;//종료
		}
		
		BoardVO boardVO = boardList.get(index);
		int readCnt = boardVO.getReadCnt();
		boardVO.setReadCnt(readCnt);
		System.out.println("글번호 : " + boardVO.getNumber());
		System.out.println("제목 : " + boardVO.getSubject());
		System.out.println("작성자 : " + boardVO.getWriter());
		System.out.println("조회수 : " + boardVO.getReadCnt());
	}

	public void readAllForeach() {
		for (BoardVO bd : boardList) {
			System.out.println("글번호 : " + bd.getNumber());
			System.out.println("제목 : " + bd.getSubject());
			System.out.println("작성자 : " + bd.getWriter());
			System.out.println("조회수 : " + bd.getReadCnt());;
		}
	}
	
	public static void main(String[] args) {
		BoardService BdService = new BoardService();
		
		Scanner scan = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("메뉴 입력");
			System.out.println("1.등록");
			System.out.println("2.수정");
			System.out.println("3.삭제");
			System.out.println("4.조회");
			System.out.println("5.종료");
			
			int menu = scan.nextInt();
			scan.nextLine();
			
			if(menu==1) {
				System.out.println("글제목입력");
				String subject = scan.nextLine();
				System.out.println("작성자입력");
				String writer = scan.nextLine();
				BdService.create(subject, writer);
				System.out.println("게시글 등록 완.");
				//BdService.readAllForeach();
				//BdService.read(0);
				
			}else if (menu==2) {
				System.out.println("수정할 글번호입력");
				int num = scan.nextInt();
				System.out.println("수정될 제목입력");
				String subject = scan.nextLine();
				BdService.update(num, subject);
				System.out.println("제목 수정 완.");
				
			}else if (menu==3) {
				System.out.println("삭제할 글번호입력");
				scan.nextLine();
				int dm = scan.nextInt();
				BdService.delete(dm);
				System.out.println("삭제 완.");
				
			}else if (menu==4) {
				System.out.println("조회할 글번호입력");
				scan.nextLine();
				int rm = scan.nextInt();
				BdService.read(rm);
				
			}else{
				System.out.println("종료합니다.");
				break;
			}
		}
		
	}

}
