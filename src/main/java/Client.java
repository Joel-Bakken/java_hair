import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Client {
  private String name;
  private String details;
  private int id;
  private int stylistId;

  public Client(String name, String details, int stylistId) {
    this.name = name;
    this.details = details;
    this.stylistId = stylistId;
  }

  public String getName() {
    return name;
  }

  public String getdetails() {
    return details;
  }

  public static List<Client> all() {
     String sql = "SELECT id, details, stylistId FROM clients";
     try(Connection con = DB.sql2o.open()) {
       return con.createQuery(sql).executeAndFetch(Client.class);
     }
   }

  public int getId()  {
    return id;
  }

  public static Client find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients where id=:id";
      Client client = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Client.class);
      return client;
    }
  }

  @Override
  public boolean equals(Object otherClient){
    if (!(otherClient instanceof Client)) {
      return false;
    } else {
      Client newClient = (Client) otherClient;
      return this.getName().equals(newClient.getName()) &&
             this.getdetails().equals(newClient.getdetails()) &&
             this.getId() == newClient.getId() &&
             this.getStylistId() == newClient.getStylistId();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients(name, details, stylistId) VALUES (: name, :details, :stylistId);";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("details", this.details)
        .addParameter("stylistId", this.stylistId)
        .executeUpdate()
        .getKey();
    }
  }

  public int getStylistId() {
    return stylistId;
  }

  public void update(String details) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE clients SET details = :details WHERE id = :id";
      con.createQuery(sql)
        .addParameter("details", details)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
    String sql = "DELETE FROM clients WHERE id = :id;";
    con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }
}
