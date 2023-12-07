import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Scanner;

public class Wallet {
  private static final ArrayList<Transaction> transactions = new ArrayList<>();
  private static double solde = 0;
  private static double monthlyBudget = 200000;

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
        Transaction transaction = new Transaction(amount, "Depot");
        transactions.add(transaction);
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
          Transaction transaction = new Transaction(amount, "Retrait");
          transactions.add(transaction);
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
    for (Transaction transaction : transactions) {
      System.out.println(transaction.getTransactionType() + " de " + transaction.getAmount());
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
        System.out.println("Votre budget mensuel a été mis à jour: " + budget + " Ar");
      } else {
        System.out.println("Montant invalide.");
      }
    } catch (NumberFormatException e) {
      System.out.println("Montant invalide. Veuillez saisir un nombre valide.");
    }
  }

  public static void showMonthlyBudget(){
    System.out.println("Votre budget mensuel est: " + monthlyBudget);
  }
}
