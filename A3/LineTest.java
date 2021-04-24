import java.util.Collection;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.TreeSet;

public class LineTest {
   @Test public void testLineConstructor() {
      Collection<Point> c = new TreeSet<Point>();
      c.add(new Point(1, 1));
      c.add(new Point(7, 1));
      c.add(new Point(3, 1));
      c.add(new Point(5, 3));
      Line l1 = new Line(c);
      //Assert.assertEquals(expected, actual);
   }
   
   @Test public void testLast() {
      Collection<Point> c = new TreeSet<Point>();
      // c.add(new Point(1, 1));
      // c.add(new Point(7, 1));
      // c.add(new Point(3, 1));
      // c.add(new Point(5, 3));
      Line l1 = new Line(c);
      Point expected = null;
      Point actual = l1.last();
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void addTest() {
      Collection<Point> c = new TreeSet<Point>();
      // c.add(new Point(1, 1));
      // c.add(new Point(7, 1));
      // c.add(new Point(3, 1));
      // c.add(new Point(5, 1));
      Line l1 = new Line(c);
      boolean actual = l1.add(new Point(8, 1));
      Assert.assertTrue(actual);
   }
   
   @Test public void compareToTest() {
   
   }
}
