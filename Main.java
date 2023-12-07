import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        if (Auth.authentication() == true) {
            do {
                System.out.println("Bienvenue dans 'Wallet' , veuillez choisir une action à effectuer:"
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

