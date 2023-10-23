import java.util.ArrayList;
import java.util.Scanner;

public class Register {

    // instansvariabler
    private int accountNumber;
    private int checkAccount;
    private int userChoice;
    private boolean isAccount;
    private boolean secondMenu;
    private boolean isExist;

    private Scanner scanner = new Scanner(System.in);

    // skapar min array
    ArrayList<BankAccount> listOfAccounts = new ArrayList<>();

    // i addAccount metoden skapar användaren ett konto
    public void addAccount() {
        isExist = false;

        System.out.print("Ange kontonummer> ");
        accountNumber = scanner.nextInt();

        for (BankAccount account : listOfAccounts) {

            if (accountNumber == account.getAccountNumber()) {
                isExist = true;
            }

        }

        if (!isExist) {

            listOfAccounts.add(new BankAccount(accountNumber, 0));

            // Visa alla konton --> för läraren att kunna se, visar array
            // Det här är för att visa varje gång nytt konto skapas
            BankAccount newAccount = new BankAccount(accountNumber, 0);
            System.out.println(newAccount.toString()); // Visar nya kontot som skapas

            isExist = false;

        } else {

            System.out.println("Kontot existerar redan, försök igen: ");
            isExist = true;

        }

    }

    // Här kollar manageAccount metoden om användaren anger rätt konto nummer -->
    // beviljas inlogg
    // om det är fel inlogg --> inlogg nekas
    public void manageAccount() {

        System.out.print("Ange kontonummer> ");
        checkAccount = scanner.nextInt();

        isAccount = false;

        // om inlogg beviljas --> ny meny kommer upp + befintlig kontonummer syns
        for (int i = 0; i < listOfAccounts.size(); i++) {

            if (checkAccount == listOfAccounts.get(i).getAccountNumber()) {
                isAccount = true;

                do {
                    System.out.println("****KONTOMENY**** - konto:" + checkAccount);
                    System.out.println("1. Ta ut pengar");
                    System.out.println("2. Sätt in pengar");
                    System.out.println("3. Visa saldo");
                    System.out.println("4. Avsluta");
                    System.out.print("Ange menyval> ");
                    userChoice = scanner.nextInt();

                    switch (userChoice) {
                        case 1:
                            System.out.print("Ange belopp att ta ut: ");
                            double amount = scanner.nextDouble();
                            listOfAccounts.get(i).withdraw(amount);
                            secondMenu = true;
                            break;

                        case 2:
                            System.out.print("Ange belopp att sätta in: ");
                            double depositAmount = scanner.nextDouble();
                            listOfAccounts.get(i).deposit(depositAmount);
                            secondMenu = true;
                            break;

                        case 3:
                            listOfAccounts.get(i).balance();
                            secondMenu = true;
                            break;

                        case 4:
                            System.out.println("Du valde att avsluta. Ha det bra");
                            secondMenu = false;
                            break;

                        default:
                            System.out.println("Du måste ange val i menyn.");
                            secondMenu = true;
                            break;
                    }

                } while (secondMenu);

            }

        }

        // logik om en användare försöker logga in med något som inte finns
        // if ligger utanför i och med att den annars körs i varje fall
        // om den ej ligger utanför

        if (!isAccount)
            System.out.println("Kontot du angett finns inte. Försök igen:");
    }
}
