import java.util.List;

public class DriverLicence extends About{
  private List<String> type;
  public DriverLicence(String lastName, String firstName, String birthdate, List<String> type) {
    super(lastName, firstName, birthdate);
    this.type = type;
  }

  public List<String> getType() {
    return type;
  }

  public void setType(List<String> type) {
    this.type = type;
  }
}
