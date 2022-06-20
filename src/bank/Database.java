package bank;
/* 
 * In this class is where all of the accounts are
 * stored in a database like manner. Having the accounts
 * separate generally just improves overall modularity 
 * of the program. Ultimately removing as much as possible
 * from the main method. Of course, this class has no main 
 * method and is used by the main method to access the 
 * accounts when going through the login stage. 
 */

public class Database {	// Start class
	// An array of the type Account -> Stores all bank accounts
	// Holds both types of accounts ->Savings<- ->Current<-
	static Account[] bankAccounts = {
		new CurrentAccount("Dylan", "4444", 800, 6),
		new CurrentAccount("Nathan", "5555", 900, 5),
		new CurrentAccount("Justin", "6666", 1000, 4),
		new SavingsAccount("Jordan", "1111", 500, 2),
		new SavingsAccount("Shauna", "2222", 600, 3),
		new SavingsAccount("Sean", "3333", 700, 4)	
	};	// End Array
	
}	// End class
