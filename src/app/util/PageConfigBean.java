package app.util;

public class PageConfigBean {
	
	private String body;
	private String title;
	
	public PageConfigBean(){
		
	}
	
	public PageConfigBean(String body, String title) {
		this.body = body;
		this.title = title;
	}
	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
}
