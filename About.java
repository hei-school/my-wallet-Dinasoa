public class About {
  private String lastName;
  private String firstName;
  private String birthdate;

  public String getLastName() {
    return lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getBirthdate() {
    return birthdate;
  }

  public About(String lastName, String firstName, String birthdate) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.birthdate = birthdate;
  }

}
