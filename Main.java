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
                        + "\n3- Faire un retrait en cash"
                        + "\n4- Deposer une carte de credit"
                        + "\n5- Recuperer une carte de credit"
                        + "\n6- Deposer une CIN"
                        + "\n7- Recuperer et afficher les informations de la CIN"
                        + "\n8- Deposer un permis de conduire"
                        + "\n9- Recuperer et afficher les informations du permis de conduire"
                        + "\n10- Deposer une carte de visite"
                        + "\n11- Recuperer une ou plusieurs cartes de visite"
                        + "\n12- Quitter");

                System.out.print("Votre choix: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        Wallet.showBalance();
                        break;
                    case 2:
                        Wallet.depositCash();
                        break;
                    case 3:
                        Wallet.withdrawCash();
                        break;
                    case 4:
                        Wallet.depositCard();
                        break;
                    case 5:
                        Wallet.recoveredCard();
                        break;
                    case 6:
                       Wallet.depositCIN();
                       break;
                    case 7:
                        Wallet.retrieveAndShowCIN();
                        break;
                    case 8:
                        Wallet.depositDriverLicense();
                        break;
                    case 9:
                        Wallet.retrieveAndShowDriverLicense();
                        break;
                    case 10:
                        Wallet.depositVisitCard();
                        break;
                    case 11:
                        Wallet.retrieveVisitCards();
                        break;
                    case 12:
                        System.out.println("Merci d'utiliser le service Wallet. Au revoir!");
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez choisir une option valide.");
                }
            } while (choice != 12);
        }
    }
}

