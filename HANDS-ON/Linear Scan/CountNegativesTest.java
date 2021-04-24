import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class CountNegativesTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test for CountNegatives(). **/
   @Test public void CountNegativesTest() {
      int a[] = {-1,-2,3,4};
      
      int count = CountNegatives.countNegatives(a);
      Assert.assertEquals(2, count);
   }
}
