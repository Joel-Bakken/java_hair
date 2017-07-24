import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class StylistTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Stylist firstStylist = new Stylist("Kelle");
    Stylist secondStylist = new Stylist("Kelle");
    assertTrue(firstStylist.equals(secondStylist));
  }

  @Test
  public void save_savesIntoDatabase_true() {
    Stylist myStylist = new Stylist("Kelle");
    myStylist.save();
    assertTrue(Stylist.all().get(0).equals(myStylist));
  }

  @Test
  public void all_returnsAllInstancesOfStylist_true() {
    Stylist firstStylist = new Stylist("Kelle");
    firstStylist.save();
    Stylist secondStylist = new Stylist("Joel");
    secondStylist.save();
    assertEquals(true, Stylist.all().get(0).equals(firstStylist));
    assertEquals(true, Stylist.all().get(1).equals(secondStylist));
  }

  @Test
  public void save_assignsIdToObject() {
    Stylist myStylist = new Stylist("Kelle");
    myStylist.save();
    Stylist savedStylist = Stylist.all().get(0);
    assertEquals(myStylist.getId(), savedStylist.getId());
  }

  @Test
  public void getClients_retrievesALlClientsFromDatabase_clientsList() {
    Stylist myStylist = new Stylist("Kelle");
    myStylist.save();
    Client firstClient = new Client("Joel", "blah blah", myStylist.getId());
    firstClient.save();
    Client secondClient = new Client("Kenneth", "blah blah", myStylist.getId());
    secondClient.save();
    Client[] clients = new Client[] { firstClient, secondClient };
    assertTrue(myStylist.getClients().containsAll(Arrays.asList(clients)));
  }

  @Test
  public void stylist_instantiatesCorrectly_true() {
    Stylist testStylist = new Stylist("Kelle");
    assertEquals(true, testStylist instanceof Stylist);
  }

  @Test
  public void getName_stylistInstantiatesWithName_Home() {
    Stylist testStylist = new Stylist("Kelle");
    assertEquals("Kelle", testStylist.getName());
  }

  @Test
  public void getId_stylistsInstantiateWithAnId_1() {
    Stylist testStylist = new Stylist("Kelle");
    testStylist.save();
    assertTrue(testStylist.getId() > 0);
  }

  @Test
   public void find_returnsStylistWithSameId_secondStylist() {
     Stylist firstStylist = new Stylist("Kelle");
     firstStylist.save();
     Stylist secondStylist = new Stylist("Patrick");
     secondStylist.save();
     assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
   }

   @Test
   public void update_updatesStylistName_true() {
     Stylist testStylist = new Stylist("Kelle");
     testStylist.save();
     testStylist.update("Tammy");
     assertEquals("Tammy", Stylist.find(testStylist.getId()).getName());
   }

}
