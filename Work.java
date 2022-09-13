public class Work {
	private double wage;
	private double totalTime;
	private double payOut;
	private String schedule;
	
	public Work(double wage,double totalTime, double payOut, String schedule) {
		super();
		this.wage = wage;
		this.totalTime = totalTime;
		this.payOut = payOut;
		this.schedule = schedule;
	}
	
	public double getwage() {
		return wage;
	}
	public void setwage(double wage) {
		this.wage = wage;
	}
	
	public double getpayOut() {
		return payOut;
	}
	public void setpayout(double payout) {
		this.payOut = payout;
	}
	
	public double gettotalTime() {
		return totalTime;
	}
	
	public void calcTime(double recordTime) {//Time in hours
		this.totalTime += recordTime;
	}
	
	public void payRoll() {
		double check = this.wage * this.totalTime;
		this.payOut += check;
		this.totalTime = 0;//Total time resets when payroll is created
	}
	
	public String getSchedgule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
}
