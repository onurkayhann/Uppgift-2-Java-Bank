import java.util.ArrayList;
import java.util.Scanner;

public class Register {

    Scanner scanner = new Scanner(System.in);
    ArrayList<BankAccount> listOfAccounts = new ArrayList<>();

    public void addAccount() {

        System.out.print("Ange kontonummer> ");
        int accountNumber = scanner.nextInt();

        listOfAccounts.add(new BankAccount(accountNumber));
        System.out.println("Kontot skapades");

        // Show all accounts
        for (BankAccount account : listOfAccounts) {
            System.out.println(account.toString());
        }
    }
}
