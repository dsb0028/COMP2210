import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class MinOfThreeTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Test for min1. **/
   @Test public void min1Test() {
      int a = 2;
      int b = 2;
      int c = 1;
      int actual = MinOfThree.min1(a,b,c);
      int expected = 1;
      Assert.assertEquals(expected, actual);
   }
   @Test public void min1Test1() {
      int a = 2;
      int b = 2;
      int c = 3;
      int actual = MinOfThree.min1(a,b,c);
      int expected = 2;
      Assert.assertEquals(expected, actual);
   }
   @Test public void min1Test2() {
      int a = 3;
      int b = 6;
      int c = 1;
      int actual = MinOfThree.min1(a,b,c);
      int expected = 1;
      Assert.assertEquals(expected, actual);
   }
   @Test public void min1Test3() {
      int a = 3;
      int b = 1;
      int c = 2;
      int actual = MinOfThree.min1(a,b,c);
      int expected = 1;
      Assert.assertEquals(expected, actual);
   }

   
   
   @Test public void min2Test() {
      int a = 1;
      int b = 2;
      int c = 2;
      int actual = MinOfThree.min2(a,b,c);
      int expected = 1;
      Assert.assertEquals(expected, actual);
   }
   @Test public void min2Test1() {
      int a = 1;
      int b = 3;
      int c = 2;
      int actual = MinOfThree.min2(a,b,c);
      int expected = 1;
      Assert.assertEquals(expected, actual);
   }
   @Test public void min2Test2() {
      int a = 3;
      int b = 2;
      int c = 1;
      int actual = MinOfThree.min2(a,b,c);
      int expected = 1;
      Assert.assertEquals(expected, actual);
   }

}
