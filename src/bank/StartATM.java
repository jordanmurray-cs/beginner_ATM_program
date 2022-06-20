package bank;

/* 
 * From the user perspective, this is where the login takes
 * place. Many of the functions carried out within the main 
 * method is functionality hard coded within the account 
 * class. For the whole program itself this is where the 
 * program is first executed. This is because this class 
 * is where the main method is located.
 */

public class StartATM {	// Start class
	public static void main(String[] args) {	// Start main
		// Counter variable representing number of attempts the user has
		int counter = 3;
		
		// While loop will run indefinitely under the condition the counter is != 0
		while(counter != 0) {
			// Take user input
			System.out.println("Enter your pin: ");
			
			// Validation method is being used to validate user input
			// It is being called from the account class
			// As well as, the Scanner class is being accessed from the account class
			String pinAttempt = bank.Account.Validate(bank.Account.input.next());
			
			// Loop through all account in the Database class
			// Check if the pin entered matches any pin in the accounts array 
			for(int i = 0; i < Database.bankAccounts.length; i++) {
				// The login method is being used from the account class 
				Database.bankAccounts[i].LoginAccount(pinAttempt);
			}	// End for
			
			// Counter variable gets decremented
			counter--;
			
			// Inform user of the amount of pin attempts left
			System.out.println("Incorrect Pin.\nPlease try again\nAttempts remaining: " + counter);
			
		}	// End while
		
		// If condition of the while loop evaluates to true - While loop breaks
		// User is informed that the pin limit has been reached 
		System.out.println("You exceeded your pin attempt limit.");

	}	// End main
	

}	// End class
