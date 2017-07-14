import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {

    @Test
    public void stylist_instantiatesCorrectly_True() {
      Stylist testStylist = new Stylist("Joel");
      assertEquals(true, testStylist instanceof Stylist);
      }
}
