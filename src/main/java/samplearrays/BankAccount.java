package samplearrays;

public class BankAccount {
    String name;
    double currentBalance;
    private Double[] transactions;
    private int transactionId;

    public BankAccount(String name, int startingBalance){
        this.name = name;
        this.currentBalance = startingBalance;

        this.transactionId = 0;
        this.transactions = new Double[1000];
    }

    public void deposit(double amount){
        if(amount < 0) {
            System.out.println("Invalid amount");
            return;
        }

        System.out.println(name + " has deposited an amount of " + amount);
        System.out.println("Previous balance: " + currentBalance);

        transactions[transactionId] = amount;
        transactionId++;

        currentBalance += amount;

        System.out.println("Current balance: " + currentBalance );
    }

    public void withdraw(double amount){
        if(amount < 0 ) {
            System.out.println("Invalid amount");
            return;
        }
        if(amount > currentBalance) {
            System.out.println("Insufficient balance");
            return;
        }

        System.out.println(name + " has withdrawn an amount of " + amount);
        System.out.println("Previous balance: " + currentBalance);

        transactions[transactionId] = -amount;
        transactionId++;

        currentBalance -= amount;

        System.out.println("Current balance: " + currentBalance );
    }

    public void displayTransactions(){
        System.out.println("Transactions History:");

        for(int i = 0; i < transactionId; i++) {
            System.out.println("Transaction " + i + ": " + transactions[i]);
        }
    }

    public void displayBalance(){
        System.out.println("Current balance: " + currentBalance);
    }

    public static void main(String[] args) {
        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----
    }
}
