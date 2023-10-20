public class BankAccount {

    // instansvariabler
    private int accountNumber;
    private double balance;

    // constructor
    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // getter
    public int getAccountNumber() {
        return this.accountNumber;
    }

    // logik som säkerställer att användare ej kan ta ut pengar om saldot är 0
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

    // toString metod för att det hela tiden syns i terminalen
    // när användare skapar ett nytt konto
    public String toString() {
        return "Kontonumret " + this.accountNumber + " skapades nu";
    }
}
