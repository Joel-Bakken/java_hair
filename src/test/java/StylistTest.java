import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class StylistTest {

  String testDetails = "This is a test string that tests the details textarea for details about the client and what they like/want";

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Stylist_instantiatesCorrectly_True() {
    Stylist testStylist = new Stylist("Kelle");
    assertEquals(true, testStylist instanceof Stylist);
    }

  @Test
  public void getName_instantiatesWithName_kelle() {
    Stylist testStylist = new Stylist("Kelle");
    assertEquals("Kelle", testStylist.getName());
  }

  @Test
  public void save_savesIntoDatabase_true() {
    Stylist testStylist = new Stylist("Kelle");
    testStylist.save();
    assertTrue(Stylist.all().get(0).equals(testStylist));
  }

  @Test
  public void save_assignsIdToObject() {
    Stylist testStylist = new Stylist("Kelle");
    testStylist.save();
    Stylist savedStylist = Stylist.all().get(0);
    assertEquals(testStylist.getId(), savedStylist.getId());
  }

  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Stylist firstStylist = new Stylist("Kelle");
    Stylist secondStylist = new Stylist("Kelle");
    assertTrue(firstStylist.equals(secondStylist));
  }

  @Test
  public void all_returnsAllInstancesOfStylist_true() {
    Stylist firstStylist = new Stylist("Kelle");
    firstStylist.save();
    Stylist secondStylist = new Stylist("Kathryn");
    secondStylist.save();
    assertEquals(true, Stylist.all().get(0).equals(firstStylist));
    assertEquals(true, Stylist.all().get(1).equals(secondStylist));
  }
  @Test
  public void find_returnsStylistWithSameId_secondStylist() {
    Stylist firstStylist = new Stylist("Kelle");
    firstStylist.save();
    Stylist secondStylist = new Stylist("Kathryn");
    secondStylist.save();
    assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
  }
  @Test
  public void findDuplicate_returnsIDIfStylistNamesAreSame() {
    Stylist testStylist = new Stylist("Kelle");
    testStylist.save();
    String testStylist1 = "Kelle";
    assertEquals(Stylist.all().get(0).getId(), testStylist.findDuplicate("Kelle"));
  }

  @Test
  public void getClients_initiallyReturnsEmptyList_ArrayList() {
    Stylist testStylist = new Stylist("Kelle");
    assertEquals(0, testStylist.getClients().size());
  }

  @Test
  public void getClients_retrievesAllClientsFromDatabase_clientsList() {
    Stylist myStylist = new Stylist("Kelle");
    myStylist.save();
    Client firstClient = new Client("Joel", testDetails, myStylist.getId());
    firstClient.save();
    Client secondClient = new Client("Kelsea", testDetails, myStylist.getId());
    secondClient.save();
    Client[] clients = new Client[] { firstClient, secondClient };
    assertTrue(myStylist.getClients().containsAll(Arrays.asList(clients)));
  }

}
