import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Client {
  private String name;
  private String details;
  private int id;

  public Client(String name, String details) {
    this.name = name;
    this.details = details;
  }

  public String getName() {
    return name;
  }

  public String getDetails() {
    return details;
  }

}
