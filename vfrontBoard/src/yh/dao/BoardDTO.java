package yh.dao;

public class BoardDTO {
	
	String title;
	String content;
	public BoardDTO(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	public BoardDTO() {
		super();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Board [title=" + title + ", content=" + content + "]";
	}
	
	
	

}
