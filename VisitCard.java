public class VisitCard extends About{
  private String fonction;
  private String companyName;
  public VisitCard(String lastName, String firstName,String birthdate, String fonction, String companyName) {
    super(lastName, firstName, birthdate);
    this.fonction = fonction;
    this.companyName = companyName;
  }

  public String getFonction() {
    return fonction;
  }

  public void setFonction(String fonction) {
    this.fonction = fonction;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }
}
