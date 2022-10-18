package board_assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex05_Review2 {
	private Scanner scan ;
	private static Ex05_Review2 instance = new Ex05_Review2();
	public static Ex05_Review2 getInstance() {
		return instance;
	}
	private  List<Board> board;
	public void init() {
		scan = new Scanner(System.in);
		board = new ArrayList<Board>();
		board.add(new Board("첫번째 게시글","고길동","왔다 갑니다! 즐거운 하루 되세요!"));
		board.add(new Board("안녕하세요!","이길동","대출은 OOO-OOOO!!"));
		board.add(new Board("털어갑니다.","홍길동","베풀면서 삽시다!!!"));
	}
	public void loginMenu(String log, int index) {
		while(true) {
			System.out.println(log+"님 환영합니다.");
			System.out.println("1.글목록보기 2.글작성 3.로그아웃");
			int select = scan.nextInt();
			if(select == 1) {
				boardList();
			}else if(select == 2) {
				writing(index);
			}else if(select == 3) {
				log = logout(log);
				System.out.println("로그아웃");
				break;
			}else {
				System.out.println("잘못 입력 하셨습니다.");
			}
		}
	}

	private void viewPost() {
		System.out.println("--------------------------------------");
		// 3) 글 상세보기는 글번호를 입력하면 제목, 작성자, 글 내용을 출력
		System.out.println("상세보기");
		System.out.print("보고싶은 글 번호를 입력하세요>>");
		int boardNum = scan.nextInt()-1;
		
		if(0<=boardNum && boardNum<board.size()) {
			String title = board.get(boardNum).getTitle();
			String writer = board.get(boardNum).getWiter();
			String content = board.get(boardNum).getContent();
			
			System.out.printf("%s \t %s \n",title,writer);
			System.out.println(content);
			updateAndDelete(boardNum);
		}else {
			System.out.println("해당 번호의 게시글이 없습니다.");
		}
		
	}
	private void updateAndDelete(int boardNum) {
			System.out.println("1.글수정 2. 글삭제 3.뒤로가기");
			System.out.print(">>");
			int selectNum = scan.nextInt();
			
			switch(selectNum) {
			case 1:
				System.out.println("글을 수정합니다.");
				System.out.println("글 비밀번호를 입력하세요!");
				System.out.print(">>");
				String password = scan.nextLine();
				
				if(Ex05_Review.list.get(boardNum).getPw().equals(password)) {
					System.out.print("제목를 입력하세요 >>");
					String title = scan.nextLine();
					System.out.print("글내용를 입력하세요 >>");
					String content = scan.nextLine();
					
					board.get(boardNum).setTitle(title);
					board.get(boardNum).setContent(content);
					
					System.out.println("수정이 완료되었습니다.");
				}else {
					System.out.println("비밀번호가 틀렸습니다.");
				}
				
				break;
			case 2:
				System.out.println("글을 삭제합니다.");
				System.out.println("글 비밀번호를 입력하세요!");
				System.out.print(">>");
				password = scan.next();
				
				if(Ex05_Review.list.get(boardNum).getPw().equals(password)) {
					board.remove(boardNum);
					System.out.println("삭제가 완료되었습니다.");
				}else {
					System.out.println("비밀번호가 틀렸습니다.");
				}
				
				break;
			case 3:
				System.out.println("뒤로가기");
				break;
			}
			
			
			// 6) 위 기능이 정상적으로 작동했는지 전체 글 내용을 출력해 봅시다.
			//boardList();
			
			}
		
	private void writing(int index) {
		System.out.println("글 작성");
		System.out.println("제목를 입력하세요 >>");
		String title = scan.next();
		String writer = "\t "+Ex05_Review.list.get(index).getName();
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
			System.out.printf("%d번글 : %s \t %s \n",(i+1),title,writer);
		}	
		viewPost();
	}
}
