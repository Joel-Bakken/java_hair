import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {

    @Test
    public void Stylist_instantiatesCorrectly_True() {
      Stylist testStylist = new Stylist("Joel");
      assertEquals(true, testStylist instanceof Stylist);
      }

    @Test
    public void getName_instantiatesWithName_joel() {
      Stylist testStylist = new Stylist("Joel");
      assertEquals("Joel", testStylist.getName());
    }


}
