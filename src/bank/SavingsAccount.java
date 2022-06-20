package bank;
/* 
* This is a blueprint for a savings class. This 
* class takes full advantage of the Object Orientated 
* Principle inheritance. The class of savings account 
* is the child class of the class account. This particular
* class inherits all of the functionality and variables 
* from the account class. Although this class inherits 
* certain characteristics from the account class, it too
* has functionality and variables that are unique and local 
* to this class.  
 */
public class SavingsAccount extends Account{	// Start class
	// Instance variable -> Belong to the Savings Account class
	private int interestRate = 8;
	
	// Constructor with four parameters 
	public SavingsAccount(String accountName, String accountPin, int accountBalance, int interestRate) {
		// Super keyword used to invoke the parent constructor -> Account class 
		super(accountName, accountPin, accountBalance);
		// The member variable of interest Rate is set equal to its local variable of interest rate
		this.interestRate = interestRate; 
	}	// End constructor
	
	// Deposit method -> Void method -> Returns nothing -> Takes integer as parameter
	public void DepositAccount(int amount) {
		// Gets & Sets being utilized because of inheritance
		setAccountBalance(getAccountBalance() + amount + interestRate);
		// Display the new users balance
		System.out.println(toString());
	}	// End method

	// Method to override the default toString -> Method type of String -> Must return String
	@Override
	public String toString() {
		return "Savings Account = [" + super.toString() + ", INTEREST: " + interestRate  + "]";
	}	// End toString

	// Gets & Sets -> Perform Encapsulation 
	public int getInterestRate() {
		return interestRate;
	}	// End get

	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}	// End set
	
	
	
}	// End class
