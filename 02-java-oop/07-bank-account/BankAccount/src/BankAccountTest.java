
public class BankAccountTest {

	public static void main(String[] args) {
	        BankAccount checking = new BankAccount();
	        System.out.println("This is my Account number: " + checking.getAccountNumber());
	        System.out.println("Checking Balance is: " + checking.getCheckingBalance());
	        checking.getDepositAmount("Checking", 100.00); 	    //FIRST deposit    
	        System.out.println("Checking Balance is: " + checking.getCheckingBalance());
	        checking.getDepositAmount("Checking", 150.00); 	//SECOND deposit
	        System.out.println("Checking Balance is: " + checking.getCheckingBalance());
	        checking.getWithdrawAmount("Checking", 260.00); 	    //FIRST withdraw  
	        System.out.println("Checking Balance is: " + checking.getCheckingBalance());
	       
	        BankAccount savings = new BankAccount();
	        System.out.println("This is my Account number: " + savings.getAccountNumber());
	        System.out.println("Savings Balance is: " + savings.getSavingsBalance());
	        savings.getDepositAmount("Savings", 50.00); //FIRST deposit	        
	        System.out.println("Savings Balance is: " + savings.getSavingsBalance());
	        savings.getDepositAmount("Savings", 25.00);  //SECOND deposit
	        System.out.println("Savings Balance is: " + savings.getSavingsBalance());
	 
	        
	        System.out.println("Total Balance is: " + BankAccount.getAccountsBalance());	        
	        System.out.println("Number of Accounts: " + BankAccount.accountsCount());
	
	

	}
}

		
