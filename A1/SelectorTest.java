import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;


public class SelectorTest {
   
   @Test public void kminTest() {
      int a[] = {2, 8, 7, 3, 4};
      int k = 2;
      int expected = 3;
      int actual = Selector.kmin(a, k);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void kmaxTestforIllegalArgumentException() {
      int [] a = {5, 5};
      int k = 2;
      int expected = 9;
      int actual = Selector.kmax(a, k);
      Assert.assertEquals(expected, actual); 
   }
   @Test public void kminTest2() {
      int a[] = {2, 8, 8, 7, 3, 3, 4};
      int k = 3;
      int expected = 4;
      int actual = Selector.kmax(a, k);
      Assert.assertEquals(expected, actual);
   }
   
   /** A test for floor method from Selector class. **/
   @Test public void floorTest() {
      int a[] = {2, 8, 7, 3, 4};
      int key = 6;
      int expected = 4;
      int actual = Selector.floor(a, key);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void floorTest1() {
      int a[] = {5, 9, 1, 7, 3};
      int key = 1;
      int expected = 1;
      int actual = Selector.floor(a, key);
      Assert.assertEquals(expected, actual);
   }
   @Test public void floorTest2() {
      int a[] = {8, 7, 6, 5, 4};
      int key = 9;
      int expected = 8;
      int actual = Selector.floor(a, key);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void floorTest3() {
      int a[] = {2, 8, 8, 7, 3, 3, 4};
      int key = 5;
      int expected = 4;
      int actual = Selector.floor(a, key);
      Assert.assertEquals(expected, actual);
   }

   @Test public void floorTest4() {
      int [] a = {1, 2};
      int key = -11;
      try {
         Selector.floor(a, key);
         Assert.fail("Did not throw IllegalArgument Exception.");
      }
                          
      catch (IllegalArgumentException e) {
         Assert.assertTrue(true);
      }  
   }
   @Test public void ceilingTest() {
      int a[] = {2, 4, 8};
      int key = 3;
      int expected = 4;
      int actual = Selector.ceiling(a, key);
      Assert.assertEquals(expected, actual);
   }
   @Test public void ceilingTest1() {
      int a[] = {5, 9, 1, 7, 3};
      int key = 7;
      int expected = 7;
      int actual = Selector.ceiling(a, key);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void ceilingTest2() {
      int a[] = {8, 7, 6, 5, 4};
      int key = 0;
      int expected = 4;
      int actual = Selector.ceiling(a, key);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void ceilingTest3() {
      int a[] = {2, 8, 7, 3, 4};
      int key = 5;
      int expected = 7;
      int actual = Selector.ceiling(a, key);
      Assert.assertEquals(expected, actual);
   }


}
