public class Personal {
	private String firstName;
	private String lastName;
	
	private String gender;
	private String DOB;//Format: 01/01/2000
	private double age;
	private String SS;//Format: 123456789
	
	private String phoneNum;//Format: 317-123-4567
	private String email;//Example: johnsmith@iu.edu
	
	private String address;//Format: 420 University Blvd, Indianapolis, IN 46202
	
	public Personal(String firstName,String lastName,String gender,String DOB,double age,String SS,String phoneNum,String email, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.gender = gender;
		this.DOB = DOB;
		this.age = age;
		this.SS = SS;
		
		this.phoneNum = phoneNum;
		this.email = email;
		
		this.address = address;
	}
	
	
	public String getfirstName() {
		return firstName;
	}
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getlastName() {
		return lastName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getgender() {
		return gender;
	}
	public void setgender(String gender) {
		this.gender = gender;
	}
	
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String DOB) {
		this.DOB = DOB;
	}
	
	public double getage() {
		return age;
	}
	public void setage(double age) {
		this.age = age;
	}
	
	public String getSS() {
		return SS;
	}
	public void setSS(String SS) {
		this.SS = SS;
	}
	
	public String getphoneNum() {
		return phoneNum;
	}
	public void setphoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	
	public String getaddress() {
		return address;
	}
	public void setaddress(String address) {
		this.address = address;
	}
}
