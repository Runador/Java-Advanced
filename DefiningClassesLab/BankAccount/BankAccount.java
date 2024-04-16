package DefiningClassesLab.BankAccount;

public class BankAccount {

    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int counter = 1;
    private int id;
    private double balance;

    BankAccount() {
        this.id = counter++;
    }

    public int getCounter() {
        return BankAccount.counter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static void setInterestRate(double interest) {
        BankAccount.interestRate = interest;
    }

    public double getInterestRate(int years) {
        return BankAccount.interestRate * years * this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    /*@Override
    public String toString() {
        return String.format("Account ID created");
    }*/

}
