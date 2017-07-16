import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Client_instantiatesCorrectly_true() {
    Client testClient = new Client("Joel", 1);
    assertEquals(true, testClient instanceof Client);
  }

  @Test
  public void Client_instantiatesWithdetails_String() {
    Client testClient = new Client("Joel", 1);
    assertEquals("Joel", testClient.getdetails());
  }

  @Test
  public void all_returnsAllInstancesOfClient_true() {
    Client firstClient = new Client("Joel", 1);
    firstClient.save();
    Client secondClient = new Client("Patrick", 1);
    secondClient.save();
    assertEquals(true, Client.all().get(0).equals(firstClient));
    assertEquals(true, Client.all().get(1).equals(secondClient));
  }

  @Test
  public void clear_emptiesAllClientsFromArrayList_0() {
    Client testClient = new Client("Joel", 1);
    assertEquals(Client.all().size(), 0);
  }

  @Test
  public void getId_clientsInstantiateWithAnID_1() {
    Client testClient = new Client("Joel", 1);
    testClient.save();
    assertTrue(testClient.getId() > 0);
  }

  @Test
  public void find_returnsClientWithSameId_secondClient() {
    Client firstClient = new Client("Joel", 1);
    firstClient.save();
    Client secondClient = new Client("Patrick", 1);
    secondClient.save();
    assertEquals(Client.find(secondClient.getId()), secondClient);
  }

  @Test
  public void equals_returnsTrueIfdetailssAretheSame() {
    Client firstClient = new Client("Joel", 1);
    Client secondClient = new Client("Joel", 1);
    assertTrue(firstClient.equals(secondClient));
  }

  @Test
  public void save_returnsTrueIfdetailssAretheSame() {
    Client testClient = new Client("Joel", 1);
    testClient.save();
    assertTrue(Client.all().get(0).equals(testClient));
  }

  @Test
  public void save_assignsIdToObject() {
    Client testClient = new Client("Joel", 1);
    testClient.save();
    Client savedClient = Client.all().get(0);
    assertEquals(testClient.getId(), savedClient.getId());
  }

  @Test
  public void save_savesCategoryIdIntoDB_true() {
    Category testStylist = new Category("Kelle");
    testStylist.save();
    Client testClient = new Client("Joel", testStylist.getId());
    testClient.save();
    Client savedClient = Client.find(testClient.getId());
    assertEquals(savedClient.getCategoryId(), testStylist.getId());
  }

  @Test
  public void update_updatesClientdetails_true() {
    Client testClient = new Client("Joel", 1);
    testClient.save();
    testClient.update("Tammy");
    assertEquals("Tammy", Client.find(testClient.getId()).getdetails());
  }

  @Test
  public void delete_deletesClient_true() {
    Client testClient = new Client("Joel", 1);
    testClient.save();
    int testClientId = testClient.getId();
    testClient.delete();
    assertEquals(null, Client.find(testClientId));
  }

}
