package board_assignment;

public class Board {

	private String title;
	private String witer;
	private String content;
	
	public Board(String title, String witer, String content) {
		this.title = title;
		this.witer = witer;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWiter() {
		return witer;
	}

	public void setWiter(String witer) {
		this.witer = witer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
