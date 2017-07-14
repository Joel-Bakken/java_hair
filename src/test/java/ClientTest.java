import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {

  String testDetails = "This is a test string that tests the details textarea for details about the client and what they like/want";


  @Test
  public void Client_instantiatesCorrectly_true() {
    Client testClient = new Client("Joel", testDetails);
    assertEquals(true, testClient instanceof Client);
  }

  @Test
  public void getName_instantiatesWithName_Joel() {
    Client testClient = new Client("Joel", testDetails);
    assertEquals("Joel", testClient.getName());
  }

  @Test
  public void getDetails_instantiatesWithDetails_true() {
    Client myClient = new Client("Joel", testDetails);
    assertEquals(testDetails, myClient.getDetails());
  }
}
