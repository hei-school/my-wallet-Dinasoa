public class Card {
  private String type;
  private double amount;
  private String expirationDate;
  private String cardHolder;
  private String cardNumber;

  public Card(String type, double amount, String expirationDate, String cardHolder, String cardNumber) {
    this.type = type;
    this.amount = amount;
    this.expirationDate = expirationDate;
    this.cardHolder = cardHolder;
    this.cardNumber = cardNumber;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(String expirationDate) {
    this.expirationDate = expirationDate;
  }

  public String getCardHolder() {
    return cardHolder;
  }

  public void setCardHolder(String cardHolder) {
    this.cardHolder = cardHolder;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }
}
