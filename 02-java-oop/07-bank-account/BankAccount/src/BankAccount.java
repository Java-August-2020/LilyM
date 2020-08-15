import java.util.Random;

public class BankAccount {
    private double checkBalance;
    private double savBalance; 
    
    private static int numberOfAccounts = 0;  	//variable is private (if public access it directly)
    private static double totalAmountAllAccts = 0;  //variable is private so needs to be access by a static method
    
    private String accountNumber;
    
    public BankAccount() {    //constructor
  	  this.accountNumber = randomAccountNumber();   //random 10 digit account# 
  	  numberOfAccounts++;
    }
    
    public static int accountsCount() {  //static method to access STATIC member variables
        return numberOfAccounts;  //as per instantiations of constructor
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    
    
    private double depositMoney (String acctNameParam, double depositParam) {
        if(acctNameParam.equals("Checking")) {
        	checkBalance = getCheckingBalance() + depositParam;
        	totalAmountAllAccts += depositParam;
        }else if(acctNameParam.equals("Savings")) {
        	savBalance = getSavingsBalance() + depositParam;
        	totalAmountAllAccts += depositParam;
    	} 
        return depositParam; 
    }
    
    public double getDepositAmount(String accountName, double depositAmount) {
        return depositMoney(accountName, depositAmount);
    }
    
    public double getCheckingBalance() {
        return checkBalance;
    }

    public double getSavingsBalance() {
        return savBalance;
    }
       
    public static double getAccountsBalance() {	  //static method to access STATIC member variables	
        return totalAmountAllAccts;  //remember -this static member variable can be use throughout the package
    }
    
    
    private double withdrawMoney (String acctNameParam, double withdrawParam) {
        if(acctNameParam.equals("Checking")) {
        	if(withdrawParam > checkBalance) {
        		System.out.println("Insufficient Funds. Your balance is: " + checkBalance);
        	}else {
        	//	checkBalance -= withdrawParam;
        		checkBalance = getCheckingBalance() - withdrawParam;
        		totalAmountAllAccts -= withdrawParam;
        	}
        }else if(acctNameParam.equals("Savings")) {
        	if(withdrawParam > savBalance) {
        		System.out.println("Insufficient Funds. Your balance is: " + savBalance);
        	}else {
         //	savBalance -= withdrawParam;
        	savBalance = getSavingsBalance() - withdrawParam;
        	totalAmountAllAccts -= withdrawParam;
        	}
    	} 
        return withdrawParam; 
    }
    public double getWithdrawAmount(String accountName, double withdrawAmount) {
        return withdrawMoney(accountName, withdrawAmount);
    }
    
    
    //how to get this value in the TEST section???

//    private int randomAccountNumber2() {
//        String random = "";
//        int randomNumber = 0;
////        for (int i = 0; i < 10; i++) {
//            randomNumber = (int) (Math.random() * (999999999 - 10000000 + 1));
////            random += Integer.toString(randomNumber);
////        }
//            System.out.println("This is my random number: " + randomNumber * 10);
//            
//        return randomNumber;
//    }
    
    private String randomAccountNumber() {
        String random = "";
        int randomNumber = 0;
        for (int i = 0; i < 10; i++) {
            randomNumber = (int) (Math.random() * (9 - 0 + 1));
            random += Integer.toString(randomNumber);
        }
//            System.out.println("This is my random number: " + random);
            
        return random;
    }
    
    

    
}


