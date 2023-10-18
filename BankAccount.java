public class BankAccount {
    private int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void withdraw(double amount) {

        if (balance <= 0)
            System.out.println("Du har inte tillräckligt med pengar.");

        else {
            System.out.println("Du lyckades att ta ut " + amount + "kr.");
            this.balance -= amount;
        }

    }

    public void deposit(double depositAmount) {
        System.out.println("Du satte in " + depositAmount + "kr.");
        this.balance = balance + depositAmount;
    }

    public void balance() {
        System.out.println("Ditt saldo är " + balance);
    }

    public String toString() {
        return "Account number is: " + this.accountNumber;
    }
}
