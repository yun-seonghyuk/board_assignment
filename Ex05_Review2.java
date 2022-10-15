package board_assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex05_Review2 {
	static Scanner scan = new Scanner(System.in);
	static public Ex05_Review2 instance = new Ex05_Review2();
	static List<Board> board = new ArrayList<Board>();
	public void init() {
		board.add(new Board("첫번째 게시글","고길동","왔다 갑니다! 즐거운 하루 되세요!"));
		board.add(new Board("안녕하세요!","이길동","대출은 OOO-OOOO!!"));
		board.add(new Board("털어갑니다.","홍길동","베풀면서 삽시다!!!"));
	}
	public void loginMenu(String log) {
		while(true) {
			System.out.println(log+"님 환영합니다.");
//			board.add(new Board("첫번째 게시글","고길동","왔다 갑니다! 즐거운 하루 되세요!"));
//			board.add(new Board("안녕하세요!","이길동","대출은 OOO-OOOO!!"));
//			board.add(new Board("털어갑니다.","홍길동","베풀면서 삽시다!!!"));
			System.out.println("1.글목록보기 2.글작성 3.로그아웃");
			int select = scan.nextInt();
			if(select == 1) {
				
			}else if(select == 2) {
				writing();
			}else if(select == 3) {
				log = logout(log);
				System.out.println("로그아웃");
				break;
			}else {
				System.out.println("잘못 입력 하셨습니다.");
			}
		}
	}

	private void writing() {
		System.out.println("글 작성");
		System.out.println("작성자를 입력하세요 >>");
		String writer = scan.next();
		System.out.println("제목를 입력하세요 >>");
		String title = scan.next();
		System.out.println("글내용를 입력하세요 >>");
		String content = scan.next();
		
		board.add(new Board(title,writer,content));
		
		boardList();
		
	}

	private String logout(String log) {
		log = null;
		return log;
	}
	public void boardList() {
		for(int i=board.size()-1; i >= 0;i--) {
			String title = board.get(i).getTitle();
			String writer = board.get(i).getWiter();
			
			System.out.printf("%d번글 : %s \t%s\n",(i+1),title,writer);
		}	
	}
}
