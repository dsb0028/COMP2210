import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
import java.util.Collection;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;

public class SelectorTest {
   // static class HandoutExamples.Data {
      // String  stringVal;
      // Integer integerVal;
   // 
      // public HandoutExamples.Data(String sval, Integer ival) {
         // stringVal = sval;
         // integerVal = ival;
      // }
   // 
      // @Override
      // /**
      //  * Returns a string representation of this HandoutExamples.Data.
      //  * @return a formatted string with s and i values
      //  */
      // public String toString() {
         // return "(" + stringVal + ", " + integerVal + ")";
      // }
   // }
   
   @Test public void minTest() {
      Collection<Integer> c1 = Arrays.<Integer>asList(new Integer[]{2,8,7,3,4});
      Comparator comp = HandoutExamples.ascendingInteger;
      int expected = 2;
      int actual = Selector.min(c1, comp);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void maxTest() {
      Collection<Integer> c1 = Arrays.<Integer>asList(new Integer[]{2,8,7,3,4});
      Comparator comp = HandoutExamples.ascendingInteger;
      int expected = 8;
      int actual = Selector.max(c1, comp);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void ceilingTest() {
      Collection<Integer> c1 = Arrays.<Integer>asList(new Integer[]{2,8,7,3,4});
      int key = 1;
      Comparator comp = HandoutExamples.ascendingInteger;
      int expected = 2;
      int actual = Selector.ceiling(c1, key, comp);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void ceilingTest1() {
      Collection<Integer> c1 = Arrays.<Integer>asList(new Integer[]{9, 7});
      int key = 11;
      Comparator comp = HandoutExamples.ascendingInteger;
      try {
         Selector.ceiling(c1, key, comp);
         Assert.fail("Did not throw NoSuchElementException.");
      }
                          
      catch (java.util.NoSuchElementException e) {
         Assert.assertTrue(true);
      }  
   
   }
   
   /** Test for ceiling given the collection contains only one element.*/
   @Test public void ceilingTest2() {
      Collection<Integer> c1 = Arrays.<Integer>asList(new Integer[]{7});
      int key = 7;
      Comparator comp = HandoutExamples.ascendingInteger;
      int expected = 7;
      int actual = Selector.ceiling(c1, key, comp);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void ceilingTest3() {
      Collection<Integer> c1 = Arrays.<Integer>asList(new Integer[]{9, 7});
      int key = 7;
      Comparator comp = HandoutExamples.ascendingInteger;
      int expected = 7;
      int actual = Selector.ceiling(c1, key, comp);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void kmaxTest() {
      Collection<Integer> c1 = Arrays.<Integer>asList(new Integer[]{2,8,7,3,4});
      Collection<HandoutExamples.Data> c4 = Arrays.<HandoutExamples.Data>asList(new HandoutExamples.Data[]{
            new HandoutExamples.Data("A",5), new HandoutExamples.Data("B", 4), new HandoutExamples.Data("C", 3), 
            new HandoutExamples.Data("D", 2), new HandoutExamples.Data("E", 1)});
      int k = 2;
      int k1 = 4;
      Comparator comp = HandoutExamples.ascendingInteger;
      Comparator comp1 = HandoutExamples.ascendingStringData;
      int expected = 7;
      String string1 = "B";
      int int1 = 4;
      HandoutExamples.Data expected1 = new HandoutExamples.Data(string1, int1);
      HandoutExamples.Data actual1 = Selector.<HandoutExamples.Data>kmax(c4, k1, comp1);
      int actual = Selector.kmax(c1, k, comp);
      Assert.assertEquals(expected, actual);
      Assert.assertEquals(expected1, actual1);
      
   }
}
