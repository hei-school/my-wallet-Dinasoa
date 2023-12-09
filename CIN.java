public class CIN extends About {
  private String deliveryDate;

  public CIN(String lastName, String firstName, String birthdate, String deliveryDate) {
    super(lastName, firstName, birthdate);
    this.deliveryDate = deliveryDate;
  }


  public String getDeliveryDate() {
    return deliveryDate;
  }


}
