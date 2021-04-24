import java.util.Iterator;
import java.util.Random;
import java.util.NoSuchElementException;
/**
 * LinkedDoubleEndedList.java.
 * Implements the DoubleEndedList Interface.
 *
 * @author Daniel Benjamin (dsb0028@auburn.edu)
 * @version 10/14/2019
 */
 
public class LinkedDoubleEndedList<T> implements DoubleEndedList<T> {
   private Node front;
   private Node rear;
   private int size;
   
   public LinkedDoubleEndedList() {
      front = null;
      rear = null;
      size = 0;
   }
   private class Node {
      private T element;
      private Node next;
      private Node prev;
      public Node(T e) {
         element = e;
         prev = null;
         next = null;
      }
      
      public Node(T element, Node next, Node prev) {
         this.element = element;
         this.next = next;
         this.prev = prev;
      }  
   }
   
   private class LinkedIterator implements Iterator<T> {
      private Node current = front;
      
      public T next() {
         if(!hasNext()) {
            throw new NoSuchElementException();
         }
         
         T tmp = current.element;
         current = current.next;
         return tmp;
      }
      
      public boolean hasNext() {
         return current != null;
      }
      
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }
   
   public int size() {
      return size;
   }
   
   public boolean isEmpty() {
      return size == 0;
   }
   
   public Iterator<T> iterator() {
      return new LinkedIterator();
   }
   
   public void addFirst(T element) {
      if (element == null) {
         throw new IllegalArgumentException();
      }
      Node tmp = new Node(element, front, null);
      if(front != null ) {
         front.prev = tmp;
      }
      front = tmp;
      if(rear == null) { 
         rear = tmp;
      }
      size++;
   }
   
   public void addLast(T element) {
      if (element == null) {
         throw new IllegalArgumentException();
      }
   
      Node tmp = new Node(element, null, rear);
      if(rear != null) {
         rear.next = tmp;
      }
      rear = tmp;
      if(front == null) { 
         front = tmp;
      }
      size++;     
   }
   
   public T removeFirst() {
      Node n = locate(front.element);
      if(size == 0) {
         return null;
      }
      if(size == 1) {
         front = null;
         size = 0;
      }
        
      if(contains(n.element)) {
         front = front.next;
         front.prev = null;
         size--;
      }   
       
      return n.element;  
   }
   private Node locate(T element) {
      Node n = front;
      while (n != null) {
         if (n.element.equals(element))
            return n;
         n = n.next;
      }
      return null;
   }
   public boolean contains(T element) {
      return locate(element) != null;
   }
 
   public T removeLast() {
      if (size == 0) {
         throw new NoSuchElementException();
      }
      Node temp = rear;
      if(front == rear) {
         front = null;
      }
      
      else {
         rear.prev.next = null;
      }
      rear = rear.prev;
      temp.prev = null;
      size--;
      return temp.element;
   }
}