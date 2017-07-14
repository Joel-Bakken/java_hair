import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Stylist {
  private String name;
  private int id;


  public Stylist(String name) {
    this.name = name;
  }


  public String getName() {
    return name;
  }

  public String getId() {
    return id;
  }
}
