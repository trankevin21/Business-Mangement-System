public class Message {
	private String announcement;
	private String task;
	
	public Message(String announcement, String task) {//Messages will be save on each array element/index
		super();
		this.announcement = announcement;
		this.task = task;
	}
	
	public String getAnnouncement() {
		return announcement;
	}
	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}
	
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	
}
