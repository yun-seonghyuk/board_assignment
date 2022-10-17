package board_assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex05_Review {
	static Scanner scan = new Scanner(System.in);
	static String log = null;
	//static public Ex05_Review instance = new Ex05_Review();
	static List<Member> list = new ArrayList<Member>();
	public static void main(String[] args) {
		// 메뉴 구성으로 구조화를 해봅니다.
		
		// 1) Ex03에서 사용한 로그인 프로그램을 만들어 봅니다.   Ex05_1_Review.java
		//    메뉴]  1.회원가입 2.로그인  3.종료
		
		// 2) Ex04에서 사용한 게시판 프로그램을 만들어 봅니다.    Ex05_2_Review.java
		//    메뉴1]  1.글목록보기 2.글작성  3.종료
		
		//    메뉴2] 1-1.글 수정 1-2.글삭제 3.뒤로가기
		
		// 3) [최종]  로그인 프로그램과 게시판 프로그램을 합쳐보세요.
		//    - 로그인한 사람만 글작성을 할수 있다.
		//    - 로그인을 안한 사람은 글 목록보기와 게시글 상세보기까지만 할수 있다.
		//    - 로그인 한 사람이 게시글 상세보기를 했을 때 자기 글의 경우 글 수정, 삭제가 가능하고, 
		//	  - 다른 사람의 글은 상세보기만 가능하다
		//    - 로그인 한 사람 프로그램 종료전 로그아웃을 해야 합니다.
		
		list.add(new Member("aaa","1234","윤성혁"));
		list.add(new Member("bbb","2345","정지오"));
		list.add(new Member("ccc","3456","김재세"));
		Ex05_Review2.instance.init();
		new  Ex05_Review();
	}
	Ex05_Review (){
		mainMenu(log);
	}
	public static void mainMenu(String log){
		while(true) {
			System.out.println(log);
			System.out.println("1. 회원가입 2. 로그인 3. 글 목록보기 4.종료");
			System.out.println(">>");
			int select = scan.nextInt();
			if(select == 1) {
				join();
			}else if(select == 2) {
				login(log);
			}else if(select == 3) {
				Ex05_Review2.instance.boardList();
			}else if(select == 4){
				System.out.println("프로그램 종료.");
				break;
			}else {
				System.out.println("잘못입력하셨습니다.");
			}
		}
	}
	private static void login(String log) {
		if(log != null) {
			System.out.println("이미 로그인 되었습니다.");
			
		}else {
			System.out.println("아이디 입력 : ");
			String id = scan.next();
			System.out.println("비밀번호 입력 : ");
			String pw = scan.next();
			boolean check = false;
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getId().equals(id)&&
					list.get(i).getPw().equals(pw)) {
					log = list.get(i).getId();
					check = true;
					break;
				}
			}
			if(check == true) {
				System.out.println("로그인 성공");
				Ex05_Review2.instance.loginMenu(log);
				
			}else {
				System.out.println("로그인 실패");
			}
		}
	}
	private static void join() {
		System.out.println("아이디 입력 : ");
		String id = scan.next();
		boolean check = false;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				check = true;
				break;
			}
		}
		if(check == true) {
			System.out.println("이미 아이디가 있습니다.");
		}else {
			System.out.println("비밀번호 입력 : ");
			String pw = scan.next();
			System.out.println("이름 입력 : ");
			String name = scan.next();
			list.add(new Member(id,pw,name));
			System.out.println("회원가입을 축하합니다.");
		}
		
	}
}
