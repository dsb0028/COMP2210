import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;


public class StudentTest {

   /** Test for compareTo method in Student Class. **/
   @Test public void compareToTest() {
      Student s1 = new Student("Knuth", "Don", 3);
      Student s2 = new Student("Knuth", "Don", 2);
      int expected = 1;
      int actual = s1.compareTo(s2);
      Assert.assertEquals(expected, actual);
   }
   
   /** Test for compareTo method in Student Class. **/
   @Test public void sameFirstNameCompareToTest() {
      Student s1 = new Student("Knuth", "Don", 2);
      Student s2 = new Student("Knowitall", "Don", 1);
      int expected = 1;
      int actual = s1.compareTo(s2);
      Assert.assertEquals(expected, actual);
   }
   
   /** Test for compareTo method in Student Class. **/
   @Test public void sameLastNameCompareToTest() {
      Student s1 = new Student("Knuth", "Don", 2);
      Student s2 = new Student("Knuth", "Alan", 1);
      int expected = -1;
      int actual = s1.compareTo(s2);
      Assert.assertEquals(expected, actual);
   }
}
