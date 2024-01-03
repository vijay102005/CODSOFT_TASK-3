import java.util.Scanner;
class BankAccount{
	private double balance;
	public BankAccount(double intialBalance){
		this.balance=intialBalance;
	}
	public double getBalance(){
		return balance;
	}
	public void deposit(double amount){
		balance+=amount;
		System.out.println("Deposited: $"+amount);
	}
	public boolean withdraw(double amount){
		if(amount<=balance){
			balance-=amount;
			System.out.println("Withdrawn: $"+amount);
			return true;
		}
		else{
			System.out.println("Withdrawn: $"+amount);
			return false;
		}
	}
}
class ATM{
	private BankAccount userAccount;

	public ATM(BankAccount userAccount){
		this.userAccount=userAccount;
	}
	public void displayMenu(){
		System.out.println("ATM Menu:");
		System.out.println("1. Check Balance");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Exit");
	}
	public void performTransaction(int option){
		Scanner sc=new Scanner(System.in);
		switch(option){
		case 1:
			System.out.println("Balance: $"+userAccount.getBalance());
			break;
		case 2:
			System.out.print("Enter deposit amount: $");
			double depositAmount=sc.nextDouble();
			userAccount.deposit(depositAmount);
			break;
		case 3:
			System.out.println("Enter withdrawal amount: $");
			double withdrawalAmount=sc.nextDouble();
			userAccount.withdraw(withdrawalAmount);
			break;
		case 4:
			System.out.println("Existing. Thank you");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid option. Please choose a valid option.");

		}
	}

}
public class task3{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		BankAccount userAccount=new BankAccount(2000);
		ATM atm=new ATM(userAccount);
		while(true){
			atm.displayMenu();
			System.out.print("Enter option (1-4): ");
			int option =sc.nextInt();
			atm.performTransaction(option);
		}
	}
}
