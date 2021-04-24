import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.File;
import java.util.Scanner;
import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

public class ExtractorTest {   

   /** A test that always fails. **/
   @Test public void extractorConstructorTest() throws java.io.FileNotFoundException {
      String filename = "input0a";
      File file1 = new File(filename);
      Scanner extractor = new Scanner(file1);
      Assert.assertEquals("Default test added by jGRASP. Delete "
            + "this test once you have added your own.", 0, 1);
   }
   
   @Test public void getLinesFastWithNoCollinearPointsTest() {
      Collection<Point> c = new TreeSet<Point>();
      c.add(new Point(1, 5));
      c.add(new Point(7, 8));
      c.add(new Point(6, 12));
      c.add(new Point(12, 16));
      Extractor extr = new Extractor(c);
      SortedSet<Line> expected = null;
      SortedSet<Line> actual = extr.getLinesBrute();
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void getLinesFastWithOneLineTest() {
      Collection<Point> c = new TreeSet<Point>();
      c.add(new Point(1, 5));
      c.add(new Point(7, 5));
      c.add(new Point(6, 5));
      c.add(new Point(12, 5));
      Extractor extr = new Extractor(c);
      Line n = new Line(c);
      SortedSet<Line> expected = null;
      SortedSet<Line> actual = extr.getLinesBrute();
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void getLinesFastWithTwoLinesTest() {
      Collection<Point> c = new TreeSet<Point>();
      c.add(new Point(1, 5));
      c.add(new Point(7, 5));
      c.add(new Point(6, 5));
      c.add(new Point(12, 5));
      c.add(new Point(13, 7));
      c.add(new Point(14, 7));
      c.add(new Point(20, 7));
      c.add(new Point(30, 7));
      Extractor extr = new Extractor(c);
      Line n = new Line(c);
      SortedSet<Line> expected = null;
      SortedSet<Line> actual = extr.getLinesBrute();
      Assert.assertEquals(expected, actual);
   
   
   }
}