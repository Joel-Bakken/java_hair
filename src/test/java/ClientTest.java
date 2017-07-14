import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class ClientTest {

  String testDetails = "This is a test string that tests the details textarea for details about the client and what they like/want";

  @Rule
  public DatabaseRule database = new DatabaseRule();


  @Test
  public void Client_instantiatesCorrectly_true() {
    Client testClient = new Client("Joel", testDetails, 1);
    assertEquals(true, testClient instanceof Client);
  }

  @Test
  public void getName_instantiatesWithName_Joel() {
    Client testClient = new Client("Joel", testDetails, 1);
    assertEquals("Joel", testClient.getName());
  }

  @Test
  public void getDetails_instantiatesWithDetails_true() {
    Client testClient = new Client("Joel", testDetails, 1);
    assertEquals(testDetails, testClient.getDetails());
  }

  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Client firstClient = new Client("Joel", testDetails, 1);
    Client secondClient = new Client("Joel", testDetails, 1);
    assertTrue(firstClient.equals(secondClient));
  }

  @Test
  public void all_returnsAllInstancesOfClient_true() {
    Client firstClient = new Client("Joel", testDetails, 1);
    firstClient.save();
    Client secondClient = new Client("Kelsea", testDetails, 1);
    secondClient.save();
    assertEquals(true, Client.all().get(0).equals(firstClient));
    assertEquals(true, Client.all().get(1).equals(secondClient));
  }

  @Test
  public void save_assignsIdToObject() {
    Client testClient = new Client("Joel", testDetails, 1);
    testClient.save();
    Client savedClient = Client.all().get(0);
    assertEquals(testClient.getId(), savedClient.getId());
  }

  @Test
  public void getId_clientInstantiatesWithAnId_1() {
    Client testClient = new Client("Joel", testDetails, 1);
    testClient.save();
    assertTrue(testClient.getId() > 0);
  }

  @Test
  public void find_returnsClientWithSameId_secondClient() {
    Client firstClient = new Client("Joel", testDetails, 1);
    firstClient.save();
    Client secondClient = new Client("Kelsea", testDetails, 1);
    secondClient.save();
    assertEquals(Client.find(secondClient.getId()), secondClient);
  }

}
