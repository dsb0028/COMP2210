import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;   

public class LinkedDoubleEndedListTest {

   /** A test for size() method. **/
   @Test public void sizeTest() {
      LinkedDoubleEndedList lDB = new LinkedDoubleEndedList();
      int expected = 0;
      int actual = lDB.size();
      Assert.assertEquals("Test size() method when list is empty.", expected, actual);
   }
   
   @Test public void sizeTest1() {
      LinkedDoubleEndedList lDB = new LinkedDoubleEndedList();
      for(int i = 0; i < 10; i++) {
         lDB.addFirst(i);
      }
      int expected = 10;
      int actual = lDB.size();
      Assert.assertEquals("Test size() method when list has two elements.", expected, actual);
   }
   
   @Test public void sizeTest2() {
      LinkedDoubleEndedList lDB = new LinkedDoubleEndedList();
      try {
         lDB.addFirst(1);
         lDB.addFirst(2);
         lDB.removeFirst();
         lDB.removeFirst();
         //lDB.removeFirst();   
         Assert.fail("Did not throw NullPointerException.");
      }
      
      catch(NullPointerException e) {
         Assert.assertTrue(true);
      }
   
   }
   
   @Test public void sizeTest3() {
      LinkedDoubleEndedList<Integer> lDB = new LinkedDoubleEndedList<Integer>();
      for (int i = 0; i < 10; i++) {
         lDB.addFirst(i);
      }
   
   // removeFirst until empty
      for (int i = 9; i >= 0; i--) {
         int expected = i;
         int actual = lDB.removeFirst();
         System.out.println(actual);
         Assert.assertEquals(expected, actual);
      } 
      Assert.assertTrue(lDB.isEmpty());
           
   // addFirst multiple elements
      for (int i = 0; i < 10; i++) {
         lDB.addFirst(i);
      }
      
      int expected = 10;
      int actual = lDB.size();
      Assert.assertEquals("AddRemoveOrder: addFirst multiple elements, removeFirst until empty, addFirst multiple elements.", expected, actual);
   }
   
    @Test public void removeFirstTest()
   
   @Test public void removeFirstTest() {
      LinkedDoubleEndedList lDB = new LinkedDoubleEndedList();
      lDB.addFirst(1);
      lDB.addFirst(2);
      Object expected = 2;
      Object actual = lDB.removeFirst();
      Assert.assertEquals("Test size() method when list has two elements.", expected, actual);
   
   }
}
