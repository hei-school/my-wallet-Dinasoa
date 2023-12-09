import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wallet {
  private static double solde = 0;
  private static List<Card> cards = new ArrayList<>();
  private static List<CIN> identityCard = new ArrayList<>();
  private static List<DriverLicence> driverLicense = new ArrayList<>();
  private static List<String> driverLicenseTypes = new ArrayList<>();
  private static List<VisitCard> visitCards = new ArrayList<>();

  public static void showBalance() {
    System.out.println("Votre solde actuel: " + solde + " Ar");
  }

  public static void depositCash() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Veuillez saisir le montant à déposer: Ar");
    double amount = scanner.nextDouble();
    if (amount > 0) {
      solde += amount;
      System.out.println("Dépôt effectué!");
    } else {
      System.out.println("Le montant que vous avez saisi est invalide, veuillez vérifier!");
    }
  }

  public static void withdrawCash() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Veuillez saisir le montant à retirer: Ar");
    double amount = scanner.nextDouble();
    if (amount > 0) {
      if (amount <= solde) {
        solde -= amount;
        System.out.println("Retrait effectué.");
      } else {
        System.out.println("Votre solde est insuffisant.");
      }
    } else {
      System.out.println("Montant invalide.");
    }
  }

  public static void depositCard() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Veuillez saisir le type de carte: ");
    String type = scanner.nextLine();
    System.out.print("Veuillez saisir le montant dans votre carte: ");
    double amount = scanner.nextDouble();
    scanner.nextLine();
    System.out.print("Veuillez saisir la date d'expiration de la carte: ");
    String expirationDate = scanner.nextLine();
    System.out.print("Veuillez saisir le propriétaire de cette carte: ");
    String cardHolder = scanner.nextLine();
    System.out.print("Veuillez saisir le numéro de carte: ");
    String cardNumber = scanner.nextLine();

    Card card = new Card(type, amount, expirationDate, cardHolder, cardNumber);
    solde += card.getAmount();
    cards.add(card);

    System.out.println("Votre carte bancaire a bien été déposée.");
  }

  public static void recoveredCard() {
    Scanner scanner = new Scanner(System.in);
    if (cards.size() >= 1) {
      System.out.println("Cartes disponibles à récupérer:");
      for (int i = 0; i < cards.size(); i++) {
        System.out.println((i + 1) + "- Type: " + cards.get(i).getType() + ", Numéro de carte: " + cards.get(i).getCardNumber());
      }

      System.out.print("Quelle carte voulez-vous récupérer (entrez le numéro correspondant): ");
      int question = scanner.nextInt();

      if (question >= 1 && question <= cards.size()) {
        int cardIndex = question - 1;
        Card recoveredCard = cards.remove(cardIndex);
        solde -= recoveredCard.getAmount();
        System.out.println("La carte récupérée: Type - " + recoveredCard.getType() + ", Numéro de carte - " + recoveredCard.getCardNumber());
      } else {
        System.out.println("Veuillez ne saisir que les choix proposés.");
      }
    } else {
      System.out.println("Vous n'avez aucune carte à récupérer");
    }
  }

  public static void depositCIN() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Veuillez entrer les informations sur votre CIN: ");
    System.out.println("Nom: ");
    String lastname = scanner.nextLine();
    System.out.println("Prenom: ");
    String firstname = scanner.nextLine();
    System.out.println("Date de naissance: ");
    String birthdate = scanner.nextLine();
    System.out.println("Date de delivrance: ");
    String deliveryDate = scanner.nextLine();

    CIN identity = new CIN(firstname, lastname, birthdate, deliveryDate);

    if (identityCard.isEmpty()) {
      identityCard.add(identity);
      System.out.println("Depot de CIN effectué.");
    } else if (identityCard.size() == 1) {
      System.out.println("Votre CIN devrait être unique.");
    }
  }

  public static void retrieveAndShowCIN() {
    if (!identityCard.isEmpty()) {
      System.out.println("CIN récupérée.");
      System.out.println("Les détails de votre CIN: ");
      System.out.println("Nom: " + identityCard.get(0).getLastName());
      System.out.println("Prenom: " + identityCard.get(0).getFirstName());
      System.out.println("Date de naissance: " + identityCard.get(0).getBirthdate());
      System.out.println("Date de delivrance: " + identityCard.get(0).getDeliveryDate());

      identityCard.remove(0);
    } else {
      System.out.println("Aucune carte d'identité identifiée.");
    }
  }

  public static void depositDriverLicense() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Veuillez entrer les informations sur votre permis de conduire: ");
    String lastname = scanner.nextLine();
    String firstname = scanner.nextLine();
    String birthdate = scanner.nextLine();
    String type = scanner.nextLine();

    if (type.contains(",")) {
      String[] types = type.split(",");
      for (String t : types) {
        driverLicenseTypes.add(t.trim());
      }
    }

    if (driverLicense.isEmpty()) {
      driverLicense.add(new DriverLicence(firstname, lastname, birthdate, driverLicenseTypes));
      System.out.println("Depot effectué.");
    } else {
      System.out.println("Votre permis de conduire devrait être unique.");
    }
  }

  public static void retrieveAndShowDriverLicense() {
    if (!driverLicense.isEmpty()) {
      System.out.println("Permis de conduire récupéré.");
      System.out.println("Les détails de votre permis: ");
      System.out.println("Nom: " + driverLicense.get(0).getLastName());
      System.out.println("Prenom: " + driverLicense.get(0).getFirstName());
      System.out.println("Date de naissance: " + driverLicense.get(0).getBirthdate());
      System.out.println("Type: ");

      if (!driverLicenseTypes.isEmpty()) {
        for (int i = 0; i < driverLicenseTypes.size(); i++) {
          System.out.println((i + 1) + " - " + driverLicenseTypes.get(i));
        }
      }
      driverLicense.clear();
    } else {
      System.out.println("Aucun permis de conduire identifié.");
    }
  }

  public static void depositVisitCard() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Veuillez renseigner les informations de votre carte de visite: ");
    System.out.println("Nom: ");
    String lastname = scanner.nextLine();
    System.out.println("Prenom: ");
    String firstname = scanner.nextLine();
    System.out.println("Fonction: ");
    String fonction = scanner.nextLine();
    System.out.println("Entreprise: ");
    String companyName = scanner.nextLine();

    if (visitCards.size() <= 3) {
      visitCards.add(new VisitCard(lastname, firstname, "",  fonction, companyName));
      System.out.println("Carte de visite enregistrée.");
    } else {
      System.out.println("Plus d'espace.");
    }
  }

  public static void retrieveVisitCards() {
    Scanner scanner = new Scanner(System.in);
    List<Integer> cardsToRemove = new ArrayList<>();

    if (visitCards.isEmpty()) {
      System.out.println("Vous n'avez aucune carte de visite dans votre wallet.");
      return;
    }

    if (visitCards.size() > 1) {
      System.out.println("Sélectionnez les cartes que vous voulez récupérer (ex: 1,2):");
      for (int i = 0; i < visitCards.size(); i++) {
        System.out.println((i + 1) + " - " + visitCards.get(i).getCompanyName());
      }

      System.out.print("Carte à récupérer: ");
      String choice = scanner.nextLine();
      if (choice.contains(",")) {
        String[] indices = choice.split(",");
        for (String index : indices) {
          int cardIndex = Integer.parseInt(index.trim()) - 1;
          if (isValidIndex(cardIndex, visitCards.size())) {
            cardsToRemove.add(cardIndex);
          } else {
            System.out.println("Index invalide: " + (cardIndex + 1));
          }
        }
      } else if (!choice.contains(",")) {
        int cardIndex = Integer.parseInt(choice.trim()) - 1;
        if (isValidIndex(cardIndex, visitCards.size())) {
          cardsToRemove.add(cardIndex);
        } else {
          System.out.println("Index invalide: " + (cardIndex + 1));
        }
      }
    } else {
      cardsToRemove.add(0);
    }

    for (int i = cardsToRemove.size() - 1; i >= 0; i--) {
      int index = cardsToRemove.get(i);
      VisitCard removedCard = visitCards.remove(index);
      System.out.println("Carte récupérée: " + removedCard.getCompanyName());
    }
  }

  private static boolean isValidIndex(int index, int size) {
    return index >= 0 && index < size;
  }
}
