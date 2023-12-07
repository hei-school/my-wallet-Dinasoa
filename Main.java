import java.util.Scanner;

public class Main {

    private static final String defaultUsername = "Dinasoa";
    private static final String defaultPassword = "averystrongpassword";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez entrer votre nom d'utilisateur: ");
        String username = scanner.nextLine();
        System.out.print("Veuillez confirmer votre identité en tapant le mot de passe: ");
        String userPassword = scanner.nextLine();

        if (!username.equals(defaultUsername) || !userPassword.equals(defaultPassword)) {
            System.out.println("Oups, vous n'avez pas accès à ce wallet, désolé.");
        } else {
            int choice;

            do {
                System.out.println("Bienvenue dans 'Wallet' " + defaultUsername + ", veuillez choisir une action à effectuer:"
                        + "\n1- Voir le solde dans mon compte"
                        + "\n2- Faire un dépôt"
                        + "\n3- Faire un retrait"
                        + "\n4- Afficher l'historique des transactions"
                        + "\n5- Mettre à jour le budget mensuel"
                        + "\n6- Afficher le budget mensuel"
                        + "\n7- Quitter");

                System.out.print("Votre choix: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        Wallet.showBalance();
                        break;
                    case 2:
                        Wallet.deposit();
                        break;
                    case 3:
                        Wallet.withdraw();
                        break;
                    case 4:
                        Wallet.showTransactions();
                        break;
                    case 5:
                        Wallet.setMonthlyBudget();
                        break;
                    case 6:
                        Wallet.showMonthlyBudget();
                    case 7:
                        System.out.println("Merci d'utiliser le service Wallet. Au revoir!");
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez choisir une option valide.");
                }
            } while (choice != 7);
        }
    }
}
