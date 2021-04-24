import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;


public class PointTest {

   /** A test for the compareTo method in the Point class. **/
   @Test public void compareToPointTest() { 
      Point one = new Point(3, 3);
      Point two = new Point(1, 1);
      Point three = new Point(1, 3);
      Point four = new Point(1, 1);
      int expected = 1;
      int actual = one.compareTo(two); 
      int expected1 = -1;
      int actual1 = two.compareTo(three); 
      int expected2 = 0;
      int actual2 = two.compareTo(four); 
      Assert.assertEquals(expected, actual);
      Assert.assertEquals(expected1, actual1);
      Assert.assertEquals(expected2, actual2);
   }
   
   @Test public void slopeToTest() {
      Point one = new Point(1, 2);
      Point two = new Point(1, 6);
      Point three = new Point(2, 2);
      Point four = new Point (1, 2);
      Point five = new Point(3, 1);
      double expected = 0;
      double actual = one.slopeTo(three);
      Assert.assertEquals(expected, actual, 0);
      double expected1 = Double.POSITIVE_INFINITY;
      double actual1 = one.slopeTo(two);
      Assert.assertEquals(expected1, actual1, 0);
      double expected2 = Double.NEGATIVE_INFINITY;
      double actual2 = one.slopeTo(four);
      Assert.assertEquals(expected2, actual2, 0);
      double expected3 = -2.5;
      double actual3 = two.slopeTo(five);
      Assert.assertEquals(expected3, actual3, 0);
   }
   
   @Test public void comparePointBySlopeTest() {
      Point p1 = new Point(3, 3);
      Point p2 = new Point(5, 2);
      Point p3 = new Point(1, 1);
      Point p4 = new Point(4, 5);
      int expected = -1;
      int actual = p3.slopeOrder.compare(p1, p4);
      Assert.assertEquals(expected, actual);
   } 
}
