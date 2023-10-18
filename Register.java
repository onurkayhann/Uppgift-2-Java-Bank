import java.util.ArrayList;
import java.util.Scanner;

public class Register {

    // instansvariabler
    private Scanner scanner = new Scanner(System.in);
    private int accountNumber;
    private boolean isAccount;
    private int checkAccount;
    private boolean secondMenu;
    private boolean isExist;

    ArrayList<BankAccount> listOfAccounts = new ArrayList<>();

    public void addAccount() {
        isExist = false;

        System.out.print("Ange kontonummer> ");
        accountNumber = scanner.nextInt();

        // Show all accounts --> for the teacher to debug, shows the array
        for (BankAccount account : listOfAccounts) {
            System.out.println(account.toString());

            if (accountNumber == account.getAccountNumber()) {
                isExist = true;
            }

        }

        if (!isExist) {
            System.out.println("Kontot skapades, grattis!");
            listOfAccounts.add(new BankAccount(accountNumber, 0));
            isExist = false; // kan också vara false - diskuterar sen med läraren
        } else {
            System.out.println("Kontot existerar redan, försök igen: ");
            isExist = true;
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

        if (!isAccount)
            System.out.println("Kontot du angett finns inte. Försök igen:");

    }
}
