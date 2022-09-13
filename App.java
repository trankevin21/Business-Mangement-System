import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.FileWriter; 
import java.io.IOException;
import java.io.File;

public class App {
	
	public static ArrayList<User> users = new ArrayList<>();
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {//User Interface
		String continueExit;
		startUser();
	       do {
	           System.out.println("Enter your ID number: ");
	           String IDNum = scan.next();
	           System.out.println("Please enter your Password: ");
	           String passwordNum = scan.next();
	           
	           int error = 0;
	           for (int i = 0; i < users.size(); i++) {

	               if (users.get(i).getID().equals(IDNum) && users.get(i).getpassword().equals(passwordNum)) {//Login with User ID and Password Verification
	            	   error = 1;
	                   
	                   if (users.get(i).userADMIN() == 3 && users.get(i).workStatus() == true) {
	                       int optionManager;
	                       
	                       do {//Manager Menu
	                           System.out.println("(1) Add/Delete & Lock/Unlock Account\r\n" + "(2) User Info\r\n" + "(3) Schedule\r\n" + "(4) Messages\r\n" + "(5) Record Work Time\r\n" + "(6) Payroll\r\n" + "(7) PayCheck\r\n" + "(8) Exit");
	                           System.out.print("Select an option: ");
	                           optionManager = scan.nextInt();
	                           
	                           if(optionManager == 1) {//Add or Delete User
	                        	   int addDel;
	                        	   do {
	                        	   System.out.println("(1) Add user\r\n" + "(2) Delete user\r\n" + "(3) Lock/Unlock Account\r\n" + "(4) Go Back");
	                        	   System.out.print("Select an option: ");
	                        	   addDel = scan.nextInt();
	                        	   if(addDel == 1) {//Add new User
	                        		   addUser();
	                        	   }else if(addDel == 2) {//Delete User
	                        		   delUser();
	                        	   }else if(addDel == 3) {//Lock or Unlock Account
	                        		   lockUser();
	                        	   }else if(addDel == 4) {
	                        		   
	                        	   }else {
	                        		   System.out.println("Error! Try Again!");
	                        	   }
	                           		} while (addDel != 4);
	                        	   
	                           }else if(optionManager == 2) {//User Info
	                        	   int optionInfo;
	                        	   do {
	                        	   System.out.println("(1) List user contacts\r\n" + "(2) List full user infomation\r\n" + "(3) Go Back");
	                        	   System.out.print("Select an option: ");
	                        	   optionInfo = scan.nextInt();
	                        	   if(optionInfo == 1) {//User Contact Info
	                        		   listUser();
	                        	   }else if(optionInfo == 2) {//All User Data
	                        		   fullListUser();
	                        	   }else if(optionInfo == 3) {
	                        		   
	                        	   }else {
	                        		   System.out.println("Error! Try Again!");
	                        	   }
	                           		} while (optionInfo != 3);
	                       
	                           }else if(optionManager == 3) {//View Schedule and Make Schedule for workers
	                        	   int optionSchedule;
	                        	   do {
	                        	   System.out.println("(1) View Schedule\r\n" + "(2) Make Schedule\r\n" + "(3) Go Back");
	                        	   System.out.print("Select an option: ");
	                        	   optionSchedule = scan.nextInt();
	                        	   if(optionSchedule == 1) {//View Schedule
	                        		   viewSchedule(i);
	                        	   }else if(optionSchedule == 2) {//Make Schedule
	                        		   makeSchedule();
	                        	   }else if(optionSchedule == 3) {
	                        		   
	                        	   }else {
	                        		   System.out.println("Error! Try Again!");
	                        	   }
	                           		} while (optionSchedule != 3);
	                              
	                           }else if(optionManager == 4) {//Messages
	                        	   int optionMessage;
	                        	   do {
	                        	   System.out.println("(1) View Task\r\n" + "(2) Make Task\r\n" + "(3) View Announcement\r\n" + "(4) Make Announcement\r\n" + "(5) Go Back");
	                        	   System.out.print("Select an option: ");
	                        	   optionMessage = scan.nextInt();
	                        	   if(optionMessage == 1) {//View Task
	                        		   viewTask(i);
	                        	   }else if(optionMessage == 2) {//Make Task
	                        		   makeTask();
	                        	   }else if(optionMessage == 3) {//View Announcement
	                        		   viewAnnouncement(i);
	                        	   }else if(optionMessage == 4) {//Make Announcement
	                        		   makeAnnouncement();
	                        	   }else if(optionMessage == 5) {
	                        		   
	                        	   }else {
	                        		   System.out.println("Error! Try Again!");
	                        	   }
	                           		} while (optionMessage != 5);
	                        	   
	                           }else if(optionManager == 5) {//Record the time worked
	                        	   recordHours(i);
	                        	   
	                           }else if(optionManager == 6) {//Send out paychecks to everyone
	                        	   payRoll();
	                        	   
	                           }else if(optionManager == 7) {//View and withdrawal paychecks
	                        	   payCheck(i);   
	                        	   
	                           }else if(optionManager == 8) {//Exit
	                               System.out.println("Logged out!");

	                           }else {
	                               System.out.println("Invalid! Try Again!");
	                           }
	                       } while (optionManager != 8);
	                       
	                   } else if(users.get(i).userADMIN() == 2 && users.get(i).workStatus() == true) {

	                       int optionLeader;
	                       do {//Leader User Menu
	                           System.out.println("(1) Messages\r\n" + "(2) View Schedule\r\n" + "(3) Contacts Info\r\n" + "(4) Record Hours\r\n" + "(5) Paycheck\r\n" + "(6) Exit");
	                           System.out.print("Select an option: ");
	                           optionLeader = scan.nextInt();
	                           
	                           if(optionLeader == 1) {//View Tasks and Announcement
	                        	   int optionMessage;
	                        	   do {
	                        	   System.out.println("(1) View Task\r\n" + "(2) Make Task\r\n" + "(3) View Announcement\r\n" + "(4) Make Announcement\r\n" + "(5) Go Back");
	                        	   System.out.print("Select an option: ");
	                        	   optionMessage = scan.nextInt();
	                        	   if(optionMessage == 1) {//View Task
	                        		   viewTask(i);
	                        	   }else if(optionMessage == 2) {//Make Task
	                        		   makeTask();
	                        	   }else if(optionMessage == 3) {//View Announcement
	                        		   viewAnnouncement(i);
	                        	   }else if(optionMessage == 4) {//Make Announcement
	                        		   makeAnnouncement();
	                        	   }else if(optionMessage == 5) {
	                        		   
	                        	   }else {
	                        		   System.out.println("Error! Try Again!");
	                        	   }
	                           		} while (optionMessage != 5);
	                               
	                           }else if(optionLeader == 2) {//View Schedule
	                        	   viewSchedule(i);
	                               
	                           }else if(optionLeader == 3) {//Users Contact Info
	                        	   listUser();
	                               
	                           }else if(optionLeader == 4) {//Record the time worked
	                        	   recordHours(i);
	                               
	                           }else if(optionLeader == 5) {//View and withdrawal paychecks
	                        	   payCheck(i);
	                               
	                           }else if(optionLeader == 6) {//Exit
	                               System.out.println("Logged out successfully!");
	                               
	                           }else {
	                               System.out.println("Invalid! Try Again!");
	                           }

	                       } while (optionLeader != 6);
	                   } else if(users.get(i).userADMIN() == 1 && users.get(i).workStatus() == true) {
	                	   int optionEmployee;
	                       do {//Employee User Menu
	                           System.out.println("(1) Messages\r\n" + "(2) View Schedule\r\n" + "(3) Contacts Info\r\n" + "(4) Record Hours\r\n" + "(5) Paycheck\r\n" + "(6) Exit");
	                           System.out.print("Select an option: ");
	                           optionEmployee = scan.nextInt();
	                           
	                           if(optionEmployee == 1) {//View Tasks and Announcement
	                        	   int optionMessage;
	                        	   do {
	                        	   System.out.println("(1) View Task\r\n" + "(2) View Announcement\r\n" + "(3) Go Back");
	                        	   System.out.print("Select an option: ");
	                        	   optionMessage = scan.nextInt();
	                        	   if(optionMessage == 1) {//View Task
	                        		   viewTask(i);
	                        	   }else if(optionMessage == 2) {//View Announcement
	                        		   viewAnnouncement(i);
	                        	   }else if(optionMessage == 3) {
	                        		   
	                        	   }else {
	                        		   System.out.println("Error! Try Again!");
	                        	   }
	                           		} while (optionMessage != 3);
	                               
	                               
	                           }else if(optionEmployee == 2) {//View Schedule
	                        	   viewSchedule(i);
	                               
	                           }else if(optionEmployee == 3) {//Users Contact Info
	                        	   listUser();
	                               
	                           }else if(optionEmployee == 4) {//Record the time worked
	                        	   recordHours(i);
	                               
	                           }else if(optionEmployee == 5) {//View and withdrawal paychecks
	                        	   payCheck(i);

	                           }else if(optionEmployee == 6) {//Exit
	                               System.out.println("Logged out successfully!");
	                               
	                           }else {
	                               System.out.println("Invalid! Try Again!");
	                           }

	                       } while (optionEmployee != 6);
	                   } else if(users.get(i).workStatus() == false){
	                	   int optionLocked;
	                	   System.out.println("Account Locked!");
	                	   
	                       do {//Locked User Menu
	                           System.out.println("(1) Paycheck\r\n" + "(2) Exit");
	                           System.out.print("Select an option: ");
	                           optionLocked = scan.nextInt();
	                           
	                           if(optionLocked == 1) {//View and withdrawal paychecks
	                        	   payCheck(i);

	                           }else if(optionLocked == 2) {//Exit
	                               System.out.println("Logged out successfully!");
	                               
	                           }else {
	                               System.out.println("Invalid! Try Again!");
	                           }

	                       } while (optionLocked != 2);
	                   } else {
	                	   System.out.println("Error! Try Again!");
	                   }
	               }
	           }
	           if (error == 0) {

	               System.out.println("User not found!");
	           }

	           System.out.println("Continue y/n");
	           continueExit = scan.next();
	       } while (!continueExit.equalsIgnoreCase("n"));
	   }
	
	static void startUser() {//Reads the text file and imports the data for user
		//Default Starting Users
		/*users.add(new User("333", "1234", 3, true, new Work(10.25, 9, 0, "Monday-Friday 9am-5pm"), new Message("Everyone is off on Christmas!","Boarding meeting @2:30pm"), new Personal("John", "Smith", "Male", "01/02/2003", 18, "123456789", "317-123-4567", "johnsmith@iu.edu", "420 University Blvd, Indianapolis, IN 46202")));
		users.add(new User("222", "1234", 2, true, new Work(9.50, 5, 0, "Monday-Friday 8:30am-6pm"), new Message("Everyone is off on Christmas!","Team meeting @9:00am"), new Personal("Henry", "Doe", "Male", "03/02/2001", 20, "223456789", "317-323-9953", "henrydoe@iu.edu", "420 University Blvd, Indianapolis, IN 46202")));
		users.add(new User("111", "1234", 1, true, new Work(8.50, 3, 25, "Monday-Friday 8:30am-6pm"), new Message("Everyone is off on Christmas!","Team meeting @9:00am"), new Personal("Jane", "Doe", "Female", "04/05/2000", 21, "623556489", "317-615-7429", "janedoe@iu.edu", "420 University Blvd, Indianapolis, IN 46202")));
		users.add(new User("444", "1234", 2, true, new Work(9.25, 10, 100, "Monday-Friday 8:30am-6pm"), new Message("Everyone is off on Christmas!","Team meeting @9:00am"), new Personal("Elon", "Musk", "Male", "06/12/2000", 21, "423249332", "317-357-3525", "elonmusk@iu.edu", "420 University Blvd, Indianapolis, IN 46202")));
		*/
		try {
	        Scanner pdfImport = new Scanner(new File("save.txt"));
	        pdfImport.useDelimiter("~~");
	        
	        while (pdfImport.hasNextLine()) {
	        	String newFirstName = pdfImport.next();
	        	String newLastName = pdfImport.next();
	        	int newUserADMIN = pdfImport.nextInt();
	        	boolean newWorkstatus = pdfImport.nextBoolean();
	        	String newUserID = pdfImport.next();
	        	String newUserPassword = pdfImport.next();
	        	Double newWage = pdfImport.nextDouble();
	        	Double newTotalTime = pdfImport.nextDouble();
	        	Double newPayout = pdfImport.nextDouble();
	        	String newSchedule = pdfImport.next();
	        	String newAnnouncement = pdfImport.next();
	        	String newTask = pdfImport.next();
	        	String newGender = pdfImport.next();
	        	String newDOB = pdfImport.next();
	        	Double newAge = pdfImport.nextDouble();
	        	String newSS = pdfImport.next();
	        	String newEmail = pdfImport.next();
	        	String newPhoneNum = pdfImport.next();
	        	String newAddress = pdfImport.next();
	        	String temp = pdfImport.next();
	        	users.add(new User(newUserID, newUserPassword, newUserADMIN, newWorkstatus, 
	        			new Work(newWage, newTotalTime, newPayout, newSchedule), 
	        			new Message(newAnnouncement, newTask), 
	        			new Personal(newFirstName, newLastName, newGender, newDOB, newAge, newSS, newPhoneNum, newEmail, newAddress)));
	        	
	        	

	        }
	        
	        pdfImport.close();
	    } catch (IOException e) {
	    	System.out.println("An error occurred.");
		    e.printStackTrace();
	    }
		
	}
	
	static void printSave() {//Saves user data to text file
		
		try {
		      FileWriter pdfSave = new FileWriter("save.txt");
		      for (int userlist = 0; userlist < users.size(); userlist++) {
		    	  		pdfSave.write("~~"+ users.get(userlist).getPersonal().getfirstName() + "~~" + users.get(userlist).getPersonal().getlastName() + "~~" 
		    	  				+ users.get(userlist).userADMIN() + "~~" + users.get(userlist).workStatus() + "~~" + users.get(userlist).getID() + "~~" + users.get(userlist).getpassword() + "~~" 
		    	  				+ users.get(userlist).getWork().getwage() + "~~" + users.get(userlist).getWork().gettotalTime() + "~~" + users.get(userlist).getWork().getpayOut() + "~~" + users.get(userlist).getWork().getSchedgule()+ "~~"
		    	  				+ users.get(userlist).getMessage().getAnnouncement() + "~~" + users.get(userlist).getMessage().getTask() + "~~" 
		    	  				+ users.get(userlist).getPersonal().getgender() + "~~" + users.get(userlist).getPersonal().getDOB() + "~~" + users.get(userlist).getPersonal().getage() + "~~" 
		    	  				+ users.get(userlist).getPersonal().getSS() + "~~" + users.get(userlist).getPersonal().getemail() + "~~" + users.get(userlist).getPersonal().getphoneNum() + "~~" 
		    	  				+ users.get(userlist).getPersonal().getaddress() + "~~" + "." + "\r\n");
		      }
		      
		      pdfSave.close();
		      System.out.println("Successfully Saved!");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	static void addUser() {//Add New User
		   System.out.println("Enter New User ID Number: ");
	       String newUserID = scan.next();
	        
	        System.out.println("Enter New User Password: ");
	        String newUserPassword = scan.next();	 
	 	   
	        System.out.println("(1) Employee\r\n" + "(2) Leader\r\n" + "(3) Manager");
	        System.out.println("Enter User permission Level: ");
	        int newUserADMIN = scan.nextInt();
	        
	 	   System.out.println("Enter First Name: ");
	        String newFirstName = scan.next();
	        
	        System.out.println("Enter Last Name: ");
	        String newLastName = scan.next();
	        
	        System.out.println("Enter Hourly Wage: ");
	        double newWage = scan.nextDouble();
	        
	        System.out.println("Enter Gender: ");
	        String newGender = scan.next();
	        
	        System.out.println("Enter Date of Birth: ");
	        String newDOB = scan.next();
	        
	        System.out.println("Enter Age: ");
	        double newAge = scan.nextDouble();
	        
	        System.out.println("Enter Social Security Number: ");
	        String newSS = scan.next();
	        
	        System.out.println("Enter Phone Number: ");
	        String newPhoneNum = scan.next();
	        
	        System.out.println("Enter Email Address: ");
	        String newEmail = scan.next();
	        
	        System.out.println("Enter Home Address: ");
	        scan.nextLine();
	        String newAddress = scan.nextLine();
	    
	 	   users.add(new User(newUserID, newUserPassword, newUserADMIN, true, new Work(newWage, 0, 0, null), new Message("Welcome!", "Settle in and go to meeting @10:30am"), new Personal(newFirstName, newLastName, newGender, newDOB, newAge, newSS, newPhoneNum, newEmail, newAddress)));
	 	   printSave();
	   }
	
	static void delUser() {//Search for user to Delete
		 for (int userlist = 0; userlist < users.size(); userlist++) {
             System.out.println("Name: " + users.get(userlist).getPersonal().getfirstName() + " " + users.get(userlist).getPersonal().getlastName() + " ----- " +"User ID: " + users.get(userlist).getID());
         }
  	   
  	   System.out.println("\n\nEnter User ID to be terminated: ");
         String delAccountNum = scan.next();
         int userTerminated = 0;

         Iterator<User> data = users.iterator();
         while (data.hasNext()) {

             if (data.next().getID().equals(delAccountNum)) {
          	   userTerminated = 1;
          	   data.remove();
          	   printSave();
             }
         }

         if (userTerminated == 1) {
             System.out.println("User Terminated");
             
         } else {
             System.out.println("User " + delAccountNum + " not found!");
         }
    }
	
	static void lockUser() {//Lock User's Account
		System.out.println("\nAccount Unlocked");
		for(int i= 0; i < 15; i++) {
			System.out.print("*");
		}
		System.out.println("");
		for (int userlist = 0; userlist < users.size(); userlist++) {
			if(users.get(userlist).workStatus() == true) {
				System.out.println("Name: " + users.get(userlist).getPersonal().getfirstName() + " " + users.get(userlist).getPersonal().getlastName() + " ----- " + "User ID: " + users.get(userlist).getID());
				System.out.println("\n");
			} 
        }
		
		System.out.println("\nAccount Locked");
		for(int i= 0; i < 15; i++) {
			System.out.print("*");
		}
		
		System.out.println("");
		for (int userlist1 = 0; userlist1 < users.size(); userlist1++) {
			if(users.get(userlist1).workStatus() == false) {
				System.out.println("Name: " + users.get(userlist1).getPersonal().getfirstName() + " " + users.get(userlist1).getPersonal().getlastName() + " ----- " + "User ID: " + users.get(userlist1).getID());
				System.out.println("\n");
			} 
        }
		
		 System.out.println("\n\nEnter User ID to Lock Account: ");
         String userIDLock = scan.next();
         
         System.out.println("(1) Unlock\r\n" + "(2) Lock");
         System.out.print("Select an option: ");
         int optionLock = scan.nextInt();
         
         int userLock = 0;
         for (int userlist2 = 0; userlist2 < users.size(); userlist2++) {
 			if(users.get(userlist2).getID().equals(userIDLock)) {
 				if(optionLock == 1) {
 					users.get(userlist2).setWorkStatus(true);;
 					userLock = 1;
 					printSave();
 				} else if(optionLock == 2) {
 					users.get(userlist2).setWorkStatus(false);;
 					userLock = 2;
 					printSave();
 				}
 			}
         }
      

         if (userLock == 1) {
             System.out.println("User Account Unlocked!");
         	} else if(userLock == 2) {
         		System.out.println("User Account Locked!");
         	} else {
         		System.out.println("Error! Try Again!");
         		}
    }
	
	
	static void listUser() {//List users contact info
		for (int userlist = 0; userlist < users.size(); userlist++) {
            System.out.println("Name: " + users.get(userlist).getPersonal().getfirstName() + " " + users.get(userlist).getPersonal().getlastName());
            System.out.println("Email: " + users.get(userlist).getPersonal().getemail());
            System.out.println("Phone: " + users.get(userlist).getPersonal().getphoneNum() + "\n");
        }
	}
	
	static void fullListUser() {//List all users data
		System.out.println("\n  Workers");
		for(int i= 0; i < 15; i++) {
			System.out.print("*");
		}
		System.out.println("");
		
		for (int userlist = 0; userlist < users.size(); userlist++) {
			if(users.get(userlist).workStatus() == true) {
				System.out.println("Name: " + users.get(userlist).getPersonal().getfirstName() + " " + users.get(userlist).getPersonal().getlastName());
				System.out.println("User Permission Level: " + users.get(userlist).userADMIN());
				System.out.println("User ID: " + users.get(userlist).getID());
				System.out.println("Password: " + users.get(userlist).getpassword());
				
				System.out.println("Wage: $" + users.get(userlist).getWork().getwage() + " /Hour");
				System.out.println("Total Work Time: " + users.get(userlist).getWork().gettotalTime() + " Hours");
				System.out.println("Payout: $" + users.get(userlist).getWork().getpayOut());
				
				
				System.out.println("Gender: " + users.get(userlist).getPersonal().getgender());
				System.out.println("DOB: " + users.get(userlist).getPersonal().getDOB());
				System.out.println("Age: " + (int) users.get(userlist).getPersonal().getage() + " years");
				System.out.println("SSN: " + users.get(userlist).getPersonal().getSS());
            	System.out.println("Email: " + users.get(userlist).getPersonal().getemail());
            	System.out.println("Phone: " + users.get(userlist).getPersonal().getphoneNum());
            	System.out.println("Address: " + users.get(userlist).getPersonal().getaddress() + "\n");
			}
        }
		
		System.out.println("\n  EX-Workers");
		for(int i= 0; i < 15; i++) {
			System.out.print("*");
		}
		System.out.println("");
		for (int userlist = 0; userlist < users.size(); userlist++) {
			if(users.get(userlist).workStatus() == false) {
				System.out.println("Name: " + users.get(userlist).getPersonal().getfirstName() + " " + users.get(userlist).getPersonal().getlastName());
				System.out.println("User Permission Level: " + users.get(userlist).userADMIN());
				System.out.println("User ID: " + users.get(userlist).getID());
				System.out.println("Password: " + users.get(userlist).getpassword());
				
				System.out.println("Wage: $" + users.get(userlist).getWork().getwage() + " /Hour");
				System.out.println("Total Work Time: " + users.get(userlist).getWork().gettotalTime() + " Hours");
				System.out.println("Payout: $" + users.get(userlist).getWork().getpayOut());
				
				
				System.out.println("Gender: " + users.get(userlist).getPersonal().getgender());
				System.out.println("DOB: " + users.get(userlist).getPersonal().getDOB());
				System.out.println("Age: " + (int) users.get(userlist).getPersonal().getage() + " years");
				System.out.println("SSN: " + users.get(userlist).getPersonal().getSS());
            	System.out.println("Email: " + users.get(userlist).getPersonal().getemail());
            	System.out.println("Phone: " + users.get(userlist).getPersonal().getphoneNum());
            	System.out.println("Address: " + users.get(userlist).getPersonal().getaddress() + "\n");
	
			}
		}
	}
	
	static void recordHours(int i) {//Record the time worked
		System.out.println("Record Time in 24 hour (Ex: 15.00)");
		System.out.println("Enter Clock-In Time: ");
        double clockIN = scan.nextDouble();
        System.out.println("Enter Clock-Out Time: ");
        double clockOUT = scan.nextDouble();
        
        double totalMIN;
        double totalHOUR;
        
        double inHOUR = (int) clockIN;//Difference from time in and time out
        double inMIN = (clockIN - inHOUR) * 100;
        double outHOUR = (int) clockOUT;
        double outMIN = (clockOUT - outHOUR) * 100;
         		
        if(inMIN != 0) {
        	totalMIN = (int) ((60 - inMIN) + outMIN);
        	inHOUR++;
        } else {
        	totalMIN = (int) outMIN;
        }
        
        totalHOUR = (int) (outHOUR - inHOUR);
      
        System.out.println("\nHour: " + totalHOUR + " " +"Minutes: " + totalMIN);
        System.out.println("Work Time added to time paid!");
        
        double recordTime = totalHOUR + (totalMIN / 60);
        users.get(i).getWork().calcTime(recordTime);
        printSave();
    }
	
	static void payRoll() {//Send out paychecks to everyone
		for (int userlist = 0; userlist < users.size(); userlist++) {
			users.get(userlist).getWork().payRoll();
			System.out.println("Name: " + users.get(userlist).getPersonal().getfirstName() + " " + users.get(userlist).getPersonal().getlastName());
			System.out.println("User ID: " + users.get(userlist).getID());
			System.out.println("Payout: $" + users.get(userlist).getWork().getpayOut());
			System.out.println("\n");
        }
		System.out.println("Pay Checks Sent Out!");
		printSave();
	}
	
	static void payCheck(int i) {//View and withdrawal paychecks
		System.out.println("Payout: $" + users.get(i).getWork().getpayOut());
		
		System.out.println("Withdrawal y/n");
        String withdrawal = scan.next();
        if(withdrawal.equalsIgnoreCase("y")) {
        	users.get(i).getWork().setpayout(0);
        	System.out.println("Pay Check Cashed Out!");
        	printSave();
        }
	}
	
	static void viewSchedule(int i) {//View Workers Schedule
				System.out.println("Schedule: " + users.get(i).getWork().getSchedgule());
				System.out.println("\n");
	}
	
	static void makeSchedule() {//Make Workers Schedule
		for (int userlist = 0; userlist < users.size(); userlist++) {
			if(users.get(userlist).workStatus() == true) {
				System.out.println("Name: " + users.get(userlist).getPersonal().getfirstName() + " " + users.get(userlist).getPersonal().getlastName() + " ----- " +"User ID: " + users.get(userlist).getID());
				System.out.println("Schedule: " + users.get(userlist).getWork().getSchedgule());
				System.out.println("\n");
			}
        }
		
		 System.out.println("\n\nEnter User ID to Schedule: ");
         String userIDSchedule = scan.next();
         int userScheduled = 0;
         
         for (int userlist1 = 0; userlist1 < users.size(); userlist1++) {
 			if(users.get(userlist1).getID().equals(userIDSchedule)) {
 				System.out.println("Enter User Schedule: ");
 				scan.nextLine();
 		        String changeSchedule = scan.nextLine();
 		        users.get(userlist1).getWork().setSchedule(changeSchedule);
 		       userScheduled = 1;
 		      printSave();
 			}
         }
      

         if (userScheduled == 1) {
             System.out.println("User Scheduled!");
             
         } else {
             System.out.println("User " + userIDSchedule + " not found!");
         }
	}
	
	static void viewTask(int i) {
		System.out.println("Task: " + users.get(i).getMessage().getTask());
		System.out.println("\n");
	}
	
	static void makeTask() {//Make Workers Task
		for (int userlist = 0; userlist < users.size(); userlist++) {
			if(users.get(userlist).workStatus() == true) {
				System.out.println("Name: " + users.get(userlist).getPersonal().getfirstName() + " " + users.get(userlist).getPersonal().getlastName() + " ----- " + "User ID: " + users.get(userlist).getID());
				System.out.println("Task: " + users.get(userlist).getMessage().getTask());
				System.out.println("\n");
			}
        }
		
		 System.out.println("\n\nEnter User ID to assign Task: ");
         String userIDTask = scan.next();
         int userTask = 0;
         
         for (int userlist1 = 0; userlist1 < users.size(); userlist1++) {
 			if(users.get(userlist1).getID().equals(userIDTask)) {
 				System.out.println("Enter User Task: ");
 				scan.nextLine();
 		        String changeTask = scan.nextLine();
 		        users.get(userlist1).getMessage().setTask(changeTask);
 		       userTask = 1;
 		       printSave();
 			}
         }
      

         if (userTask == 1) {
             System.out.println("User Task Assigned!");
             
         } else {
             System.out.println("User " + userIDTask + " not found!");
         }
	}
	
	static void viewAnnouncement(int i) {//View Announcement
		System.out.println("Announcement: " + users.get(i).getMessage().getAnnouncement());
		System.out.println("\n");
	}
	
	static void makeAnnouncement() {//Make Workers Announcement
		System.out.println("Enter Business Wide Announcement: ");
		scan.nextLine();
		String changeAnnouncement = scan.nextLine();
		
		for (int userlist = 0; userlist < users.size(); userlist++) {		
		    users.get(userlist).getMessage().setAnnouncement(changeAnnouncement);
        }
		
		System.out.println("Announcement Posted!");
		printSave();
	}
}
