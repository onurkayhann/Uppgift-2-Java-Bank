import java.util.ArrayList;
import java.util.Scanner;

public class Register {

    // instansvariabler
    private Scanner scanner = new Scanner(System.in);
    private int accountNumber;
    private boolean isAccount;
    private int checkAccount;
    private boolean secondMenu = true;

    ArrayList<BankAccount> listOfAccounts = new ArrayList<>();

    public void addAccount() {

        System.out.print("Ange kontonummer> ");
        accountNumber = scanner.nextInt();

        listOfAccounts.add(new BankAccount(accountNumber));

        // Show all accounts --> for the teacher to debug, shows the array
        for (BankAccount account : listOfAccounts) {
            System.out.println(account.toString());
        }
    }

    public void manageAccount() {
        System.out.print("Ange kontonummer> ");
        checkAccount = scanner.nextInt();
        isAccount = false;

        for (int i = 0; i < listOfAccounts.size(); i++) {

            if (checkAccount == listOfAccounts.get(i).getAccountNumber()) {
                System.out.println("Kontot exsiterar!!!!");
                isAccount = true;

                do {
                    System.out.println("****KONTOMENY**** - konto:" + checkAccount);
                    System.out.println("1. Ta ut pengar");
                    System.out.println("2. Sätt in pengar");
                    System.out.println("3. Visa saldo");
                    System.out.println("4. Avsluta");
                    System.out.print("Ange menyval> ");
                    int userChoice = scanner.nextInt();

                    switch (userChoice) {
                        case 1:
                            System.out.println("Du valde att ta ut pengar");
                            break;

                        case 2:
                            System.out.println("Du valde att sätta in pengar");
                            break;

                        case 3:
                            System.out.println("Du vill se saldot");
                            break;

                        case 4:
                            System.out.println("Du valde att avsluta. Ha det bra");
                            secondMenu = false;
                            break;
                    }

                    break;

                } while (secondMenu);

            }

        }

        if (!isAccount)
            System.out.println("Kontot du angett finns inte. Försök igen:");

    }
}
