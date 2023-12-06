import java.util.ArrayList;
import java.util.Scanner;

public class Wallet {

  private static ArrayList<String> transactions = new ArrayList<>();
  private static double solde = 0;
  private static double monthlyBudget = 200000;
  private static final String defaultUsername = "Dinasoa";
  private static final String defaultPassword = "averystrongpassword";

  public static void showBalance() {
    System.out.println("Votre solde actuel: " + solde + " Ar");
  }

  public static void deposit() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Veuillez saisir le montant à déposer: Ar ");
    String amountStr = scanner.nextLine();
    try {
      double amount = Double.parseDouble(amountStr);
      if (amount > 0) {
        solde += amount;
        transactions.add("Dépôt de " + amount + " Ar");
        System.out.println("Dépôt effectué!");
      } else {
        System.out.println("Le montant que vous avez saisi est invalide, veuillez vérifier!");
      }
    } catch (NumberFormatException e) {
      System.out.println("Montant invalide. Veuillez saisir un nombre valide.");
    }
  }

  public static void withdraw() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Veuillez saisir le montant à retirer: Ar ");
    String amountStr = scanner.nextLine();
    try {
      double amount = Double.parseDouble(amountStr);
      if (amount > 0) {
        if (amount <= solde) {
          solde -= amount;
          transactions.add("Retrait de " + amount + " Ar");
          System.out.println("Retrait effectué.");
        } else {
          System.out.println("Votre solde est insuffisant.");
        }
      } else {
        System.out.println("Montant invalide.");
      }
    } catch (NumberFormatException e) {
      System.out.println("Montant invalide. Veuillez saisir un nombre valide.");
    }
  }

  public static void showTransactions() {
    System.out.println("Historique de transactions:");
    for (String transaction : transactions) {
      System.out.println(transaction);
    }
  }

  public static void setMonthlyBudget() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Veuillez saisir votre nouveau budget mensuel: Ar ");
    String budgetStr = scanner.nextLine();
    try {
      double budget = Double.parseDouble(budgetStr);
      if (budget > 0) {
        monthlyBudget = budget;
        System.out.println("Votre budget mensuel a été mis à jour: " + monthlyBudget + " Ar");
      } else {
        System.out.println("Montant invalide.");
      }
    } catch (NumberFormatException e) {
      System.out.println("Montant invalide. Veuillez saisir un nombre valide.");
    }
  }

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
            + "\n6- Quitter");

        System.out.print("Votre choix: ");
        choice = scanner.nextInt();

        switch (choice) {
          case 1:
            showBalance();
            break;
          case 2:
            deposit();
            break;
          case 3:
            withdraw();
            break;
          case 4:
            showTransactions();
            break;
          case 5:
            setMonthlyBudget();
            break;
          case 6:
            System.out.println("Merci d'utiliser le service Wallet. Au revoir!");
            break;
          default:
            System.out.println("Choix invalide. Veuillez choisir une option valide.");
        }
      } while (choice != 6);
    }
  }
}
