public class BankAccount {
    private int accountNumber;
    private double balance;

    public BankAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        // this.balance = balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public String toString() {
        return "Account number is: " + this.accountNumber;
    }
}
