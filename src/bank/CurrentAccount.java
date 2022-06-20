package bank;
/* This is a blueprint class for an current 
 * account. Very similar to the savings account 
 * class in the sense that inheritance is what 
 * is being performed in this class. This class
 * is inheriting from the account class. Although
 * this class is inheriting the functionality of
 * the methods that are available in the account 
 * class, it too has methods unique to this class.
 * Although the account class has an withdraw and 
 * deposit method, this class also has the exact 
 * same methods. The difference being that within 
 * this current class different operations are 
 * carried within the particular methods. For any
 * operation done i.e., deposit and withdraw, a
 * transaction charge is subtracted from the users
 * account. This class also has its own toString method
 * that is unique from the default toString that is
 * present within the account class. This toString 
 * is unique to current account only.	
 */
public class CurrentAccount extends Account {	// Start class
	// Instance variables -> Belongs to the class
	private int transactionCharge = 5;
	
	// Constructor with three parameters 
	public CurrentAccount(String accountName, String accountPin, int accountBalance, int transactionCharge) {
		// Super keyword -> Invokes the parent constructor which is the Account class
		super(accountName, accountPin, accountBalance);
		// This keyword -> Used to identify the transactionCharge belonging to the class 
		this.transactionCharge = transactionCharge;
	}	// End constructor

	// toString -> override the default toString created by the class
	@Override
	public String toString() {
		return "Current Account = [" + super.toString() + ", CHARGE: " + transactionCharge  + "]";
	}	// End toString
	
	// Deposit method 
	public void DepositAccount(int amount) {
		/*
		 * Because inheritance is being used within this class
		 * all of the gets and sets in the account class are 
		 * available to use within this class
		 */
		// The users balance is set to the current balance plus the amount minus the transaction charge
		setAccountBalance(getAccountBalance() + amount - transactionCharge);
		// Print the new users balance
		System.out.println(toString());
	}	// End method
	
	// Withdraw method 
	public void WithdrawalAccount(int amount) {
		if(amount <= getAccountBalance()) {
			// Users balance set to current balance minus the amount and the transaction charge
			setAccountBalance(getAccountBalance() - amount - transactionCharge);
			// Print the new users balance
			System.out.println(toString());
		}	// End if
		
		else {
			// User is prompted if the amount entered is greater than the balance
			System.out.println("Insufficent funds.\nPlease re-check and try again.");
		}	// End else
		
	}	// End method
	
	// Get & Set methods -> Perform encapsulation -> Wrapping of private member variables in methods
	public int getTransactionCharge() {
		return transactionCharge;
	}	// End get
	
	public void setTransactionCharge(int charge) {
		this.transactionCharge = charge;
	}	// End set
	
}	// End class
