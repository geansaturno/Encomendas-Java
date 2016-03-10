package app.util;

public class PageConfigBean {
	
	private String body;
	private String title;
	private String activeMenu;
	
	public PageConfigBean(){
		
	}
	
	public PageConfigBean(String body, String title, String activeMenu) {
		this.body = body;
		this.title = title;
		this.activeMenu = activeMenu;
	}
	
	public String getActiveMenu() {
		return activeMenu;
	}

	public void setActiveMenu(String activeMenu) {
		this.activeMenu = activeMenu;
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
