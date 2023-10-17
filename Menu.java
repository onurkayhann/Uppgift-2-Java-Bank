import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private Register registerAccount = new Register();

    // instansvariabler
    boolean runMenu = true;
    int selection;

    public Menu() {
        startMenu();
    }

    // Startmenyn
    public void startMenu() {

        do {
            System.out.println("****HUVUDMENY****");
            System.out.println("1. Skapa konto");
            System.out.println("2. Administrera konto");
            System.out.println("3. Avsluta");
            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    registerAccount.addAccount();
                    break;

                case 2:

                case 3:
                    System.out.println("Du lämnar nu banken. Välkommen åter!");
                    runMenu = false;
                    break;

                default:
                    System.out.println("Finns inget sånt val. Du skickas tillbaka till menyn.");
            }
        } while (runMenu);

    }

}