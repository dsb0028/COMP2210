import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;


public class IteratorErrorTest {


   /** A test that always fails. **/
   @Test public void testSearchFoundAtRear() {
      List<Integer> ilist = new ArrayList<Integer>();
      ilist.add(2);
      ilist.add(4);
      ilist.add(6);
      ilist.add(8);
      ilist.add(10);
      int expected = 4;
      int actual = IteratorError.<Integer>search(ilist, 10);
      Assert.assertEquals("testSearchFoundAtRear(IteratorErrorTest):", expected, actual);
   }
}
