import java.util.Scanner;

class ATMMachine {

    public double withdraw(double userBalance, double amount){
        return userBalance - amount;
    }

    public double deposit(double userBalance, double amount){
        return userBalance + amount;
    }

    public boolean checkBalance(double userBalance, double amount){
        return amount <= userBalance;
    }

}

class userAccount{
    double accountBalance;
    userAccount(double accountBalance){
        this.accountBalance = accountBalance;
    }
}

public class ATMInterface {

    static final double INITIAL_AMOUNT = 500;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        userAccount account = new userAccount(INITIAL_AMOUNT);
        ATMMachine machine = new ATMMachine();
        System.out.println("-- W E L C O M E --");
        while (true){
            System.out.println("1- Withdraw amount");
            System.out.println("2- Deposit amount");
            System.out.println("3- Check account balance");
            System.out.println("4- Exit");
            System.out.print("Choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter amount: ");
                    double withdrawAmount = input.nextDouble();
                    if (!machine.checkBalance(account.accountBalance, withdrawAmount)) {
                        System.out.println("No enough balance.");
                    } else {
                        account.accountBalance = machine.withdraw(account.accountBalance, withdrawAmount);
                        System.out.println("Amount withdrawn and current account balance is: " + account.accountBalance);
                    }
                }
                case 2 -> {
                    System.out.print("Enter amount: ");
                    double depositAmount = input.nextDouble();
                    account.accountBalance = machine.deposit(account.accountBalance, depositAmount);
                    System.out.println("Amount deposited and current account balance is: " + account.accountBalance);
                }
                case 3 -> System.out.println("Current account balance is: " + account.accountBalance);
                case 4 -> {
                    System.out.println("See you soon!");
                    return;
                }
                default -> System.out.println("Invalid choice, Try again!");
            }
        }
    }
}