public class User {
	private String ID;
	private String password;
	private int userADMIN; //1-Employee 2-Leader 3-Manager
	private boolean workStatus;
	
	private Work work;
	private Message message;
	private Personal personal;
	
	public User(String ID,String password2,int userADMIN,boolean workStatus,Work work,Message message,Personal personal) {
		super();
		this.ID = ID;
		password = password2;
		this.userADMIN = userADMIN;
		this.workStatus = workStatus;
		this.work = work;
		this.message = message;
		this.personal = personal;
	}
	
	public String getID() {
		return ID;
	}
	
	public String getpassword() {
		return password;
	}
	public void setPassword(String password2) {
		password = password2;
	}
	
	public int userADMIN() {
		return userADMIN;
	}
	public void setuserADMIN(int level) {
		this.userADMIN = level;
	}
	
	public boolean workStatus() {
		return workStatus;
	}
	public void setWorkStatus(boolean status) {
		this.workStatus = status;
	}
	
	public Work getWork() {
		return work;
	}
	
	public Message getMessage() {
		return message;
	}
	
	public Personal getPersonal() {
		return personal;
	}
	
	public String toString() {
		return "User [ID=" + ID +", userADMIN=" + userADMIN +", workStatus=" + workStatus +", work=" + work +"message=" + message +"personal=" + personal +"]";
	}
}
