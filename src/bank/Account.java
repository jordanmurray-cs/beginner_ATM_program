package bank;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* This is a blueprint for bank account. This 
 * class has no main method. This class is used
 * by other classes within the program. Various
 * different attributes all relating to an account
 * will all be identified in this class. Within
 * this particular program attributes take the form
 * of member variables. The member variables are
 * certain variables that belong to the class. In
 * this case its identifying info like name, balance
 * pin, etc. A constructor is present in this class
 * so objects can effectively be made whenever the
 * need arises. This class also contains a to String
 * method to display user info whenever the program
 * is running. Encapsulation is performed through the
 * medium of Gets & Sets methods. Encapsulation is a
 * way accessing private member variables through the
 * means of wrapping private data fields in methods
 * to assist with accessibility. Other behaviour's that
 * essentially can be found in this class would be
 * your average ATM functionality like deposit,
 * withdraw, change pin etc., all present within
 * this class. 
 */

public class Account {	// Start class
	// Scanner class imported from the Java standard library
	//	--> Allows input from the user  
	static Scanner input = new Scanner(System.in);
	String displayPrint = "\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+-+-+";
	
	// Fields
	private String accountName;
	private String accountPin;
	private int accountBalance;
	private int accountID;
	private static int nextID = 1001;
	
	// Constructor with four parameters
	public Account(String accountName, String accountPin, int accountBalance) {
		this.accountName = accountName;
		this.accountPin = accountPin;
		this.accountBalance = accountBalance;
		// Every time an object is created the next ID value gets decremented and set as the current users ID
		this.accountID = nextID--;
		
	}	// End constructor
	
	// Empty constructor -> To allow the creation of an object without any parameters
	public Account() {}
	
	// Gets & Sets 
	//	--> Perform encapsulation
	//	--> Secure way of accessing and modifying private fields
	public String getAccountName() {
		return accountName;
	}	// End get

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}	// End set

	public String getAccountPin() {
		return accountPin;
	}	// End get

	public void setAccountPin(String accountPin) {
		this.accountPin = accountPin;
	}	// End set

	public int getAccountBalance() {
		return accountBalance;
	}	// End get

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}	// End set

	public int getAccountID() {
		return accountID;
	}	// End get

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}	// End set

	// toString -> Override the default toString -> The method is type String since it is returing a String
	@Override
	public String toString() {
		return "NAME: " 
				+ accountName 
				+ ", PIN: " 
				+ accountPin 
				+ ", BALANCE: " 
				+ accountBalance  
				+ ", ID: " 
				+ getAccountID();
		
	}	// End method
	
	// Bank options method -> Displays all functionality in a user friendly manner  
	public void BankOperations() {
		while(true) {
			System.out.println(displayPrint);
			// Display bank functionality available
			System.out.println("Please Choose of The Following:\n1. Bank Statement\n2. Deposit\n3. Withdraw\n4. Change Pin\n5. Logout");
			System.out.println(displayPrint);
			
			// Switch statement takes user input as parameter
			switch(input.next()) {
				case "1":
					// Prints the toString method displaying all user information
					System.out.println(toString());
					break;
				case "2":
					System.out.println("Enter amount to deposit: ");
					// Call deposit method -> parse the result of the validation method from user input
					DepositAccount(Integer.parseInt(Validate(input.next())));
					break;
				case "3":
					System.out.println("Enter amount to withdraw: ");
					// Call withdraw method -> parse the result of the validation method from user input
					WithdrawalAccount(Integer.parseInt(Validate(input.next())));
					break;
				case "4":
					System.out.println("Enter your new pin: ");
					// Call the change pin method while validating that String is being entered
					ChangeAccountPin(Validate(input.next()));
					break;
				case "5":
					// Transition method helps display exiting message more pleasantly 
					TransitionMessage("Goodbye, " + getAccountName());
					System.out.println(displayPrint);
					
					// Display termination date of program -> Replicate real time ATM simulation data
					
					// Creating a Data Formatter object from the Java standard library 
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
					// Creating a Date object from the Java standard library  
					Date date = new Date();  
					System.out.println("Terminated at: " + formatter.format(date));
					System.out.println(displayPrint);
					System.exit(0);
					break;
				default:
					// If a key stroke is entered that is not between 1-5 this will prompt 
					System.out.println("Invaild. Please re-check and try again");
					break;
					
			}	// End switch
			
		}	// End while
		
	}	// End method
	
	
	public void TransitionMessage(String message) {
		for(int i = 0; i < message.length(); i++ ) {
			// Try & Catch statement -> contain an errors that might occur 
			try {
				// Each iteration of the for loop a single character of the message will display
				System.out.print(message.charAt(i));
				Thread.currentThread();
				// The current running thread sleeps for 100ms
				Thread.sleep(100);
			}	// End try
			
			catch(Exception e) {
				// If the program catches an error it will display it in the console
				System.out.println(e);
			}	// End catch
			
		}	// End for		
		
	}	// End method

	// Deposit method -> Takes integer as parameter
	public void DepositAccount(int amount) {
		// Sets the account balance equal to the current balance plus the amount 
		setAccountBalance(getAccountBalance() + amount);
		// Call the toString method to display the users new balance
		System.out.println(toString());
		
	}	// End method

	// Withdraw method -> Takes integer as parameter
	public void WithdrawalAccount(int amount) {
		if(amount <= getAccountBalance()) {
			// Sets the account balance equal to the current balance minus the amount  
			setAccountBalance(getAccountBalance() - amount);
			// Call the toString method to display the users new balance
			System.out.println(toString());
		}	// End if
		
		else {
			System.out.println("Insufficent funds.\nPlease try again");
		}	// End else
		
	} // End method	
	
	// Method to change the user pin -> Takes String as parameter
	public void ChangeAccountPin(String pinChange) {
		// For loop -> Loops through all of the accounts in the database class
		for(int i = 0; i < Database.bankAccounts.length; i++){
			// Check if new pin matches the current pin
			if(pinChange.matches(getAccountPin())) {
				System.out.println(displayPrint);
				System.out.println("This is your current pin\nNo changes made");
				// Send user back to the bank options menu 
				BankOperations();				
			}	// End if
			
			// Check if the new pin matches any other pin in the array 
			else if(pinChange.matches(Database.bankAccounts[i].getAccountPin())) {
				System.out.println(displayPrint);
				System.out.println("Pin already in use\nPlease re-check and try again");
				// Send user back to the bank options menu 
				BankOperations();
			} // End if
			
		}	// End for
		
		// Upon passing the two edge cases the pin is then changed
		setAccountPin(pinChange);
		System.out.println("Pin succesfully changed");
		
	}	// End method
	
	// Login method -> Used within the main method -> Takes String as parameter
	public void LoginAccount(String pin) {
		// Conditional statement to check if the pin entered matches a user pin
		if(pin.matches(getAccountPin())){
			// Welcoming printout message for bank user
			TransitionMessage("Welcome, " + getAccountName());
			// Send user to the bank options menu 
			BankOperations();
		}	// End if
		
	}	// End method
	
	// Validation method -> Used to validate all user input taken from the program 
	// -> Takes String as parameter -> Method returns a String 
	public static String Validate(String valid) {
		while(!valid.matches("\\d+")) {
			System.out.println("Please enter a number");
			valid = input.next();
		}	// End while
		
		return valid;
		
	}	// End method
	
}	// End class
