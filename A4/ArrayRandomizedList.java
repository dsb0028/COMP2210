import java.util.Iterator;
import java.util.Random;
import java.util.NoSuchElementException;

public class ArrayRandomizedList<T> implements RandomizedList<T> {
   private static final int DEFAULT_CAPACITY = 5; 
   private T[] elements;
   private int size;
   
   public ArrayRandomizedList() {
      this(DEFAULT_CAPACITY);
   }
   
   @SuppressWarnings("unchecked")
   public ArrayRandomizedList(int capacity) {
      elements = (T[]) new Object[capacity];
      size = 0;
   }
   public int size() {
      return size;
   }
   
   public class ArrayIterator<T> implements Iterator<T> {
      private T[] items;
      private int count;
      private int current;
      
      public ArrayIterator(T[] elements, int size) {
         items = elements;
         count = size;
         current = 0;
      }
      
      public boolean hasNext() {
         return (current < count);
      }
      
      public T next() {
         if(!hasNext()) {
            throw new NoSuchElementException();
         }
         return items[current++];
      }
      
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }
   
   public boolean isEmpty() {
      return size == 0;
   }
   @SuppressWarnings("unchecked")
   public Iterator<T> iterator() {
      return new ArrayIterator(elements, size);
   }
   
   public void add(T element) {
      if(element == null) {
         throw new IllegalArgumentException();
      }
      ensureCapacity();
      elements[size] = element;
      size++;
   } 
   
   @SuppressWarnings("unchecked")
    private void ensureCapacity() {
      if (size < elements.length)
         return;
      T[] newArray = (T[]) new Object[elements.length * 2];
      for (int i = 0; i < size; i++)
         newArray[i] = elements[i];
      elements = newArray;
   }

   
   public T remove() {
      if(isEmpty()) {
         return null;
      }
      Random rgen = new Random();
      int randomPosition = rgen.nextInt(elements.length);
      T element = elements[randomPosition];
      int i = locate(element);
      elements[i] = elements[--size];
      elements[size] = null;
      return elements[i];
   }
   
   private int locate(T element) {
      for (int i = 0; i < size; i++) {
         if (elements[i].equals(element))
            return i;
      }
      return -1;
   }
   
   public T sample() {
      if(isEmpty()) {
         return null;
      }
      Random rgen = new Random();
      int randomPosition = rgen.nextInt(elements.length);
      return elements[randomPosition];
   }
}