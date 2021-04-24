import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Extractor.java. Implements feature extraction for collinear points in
 * two dimensional data.
 *
 * @author  Daniel Benjamin (dsb0028@auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 10/7/2019
 *
 */
public class Extractor {
   
   /** raw data: all (x,y) points from source data. */
   private Point[] points;
   
   /** lines identified from raw data. */
   private SortedSet<Line> lines;
  
   /**
    * Builds an extractor based on the points in the file named by filename. 
    */
   public Extractor(String filename) throws java.io.FileNotFoundException {
      File data = new File(filename);
      Scanner extr = new Scanner(data);
      int N = extr.nextInt();
      for(int i = 0; i < N; i++) {
         extr.next();
         int x = extr.nextInt();
         extr.next();
         int y = extr.nextInt();
         points[i] = new Point(x,y);
      }
   }
  
   /**
    * Builds an extractor based on the points in the Collection named by pcoll. 
    *
    * THIS METHOD IS PROVIDED FOR YOU AND MUST NOT BE CHANGED.
    */
   public Extractor(Collection<Point> pcoll) {
      points = pcoll.toArray(new Point[]{});
   }
  
   /**
    * Returns a sorted set of all line segments of exactly four collinear
    * points. Uses a brute-force combinatorial strategy. Returns an empty set
    * if there are no qualifying line segments.
    */
   public SortedSet<Line> getLinesBrute() {
      lines = new TreeSet<Line>();
      for(int i = 0; i < points.length; i++) {
         for(int j = i + 1; j < points.length; j++) {
            for(int k = j + 1; k < points.length; k++) {
               for(int l = k + 1; l < points.length; l++) {
                  Line n = new Line();
                  n.add(points[i]);
                  n.add(points[j]);
                  n.add(points[k]);
                  n.add(points[l]);
                  if (n.length() == 4) {
                     lines.add(n);
                  }
               }
            }
         }
      }
      return lines;
   }
  
   /**
    * Returns a sorted set of all line segments of at least four collinear
    * points. The line segments are maximal; that is, no sub-segments are
    * identified separately. A sort-and-scan strategy is used. Returns an empty
    * set if there are no qualifying line segments.
    */
   public SortedSet<Line> getLinesFast() {
      lines = new TreeSet<Line>();
      Arrays.sort(points);
      for(int i = 0; i < points.length; i++) {
         Point [] sortedPoints = Arrays.copyOf(points, points.length);
         Line n = new Line();
         n.add(points[i]);
         Arrays.sort(sortedPoints, points[i].slopeOrder);
         for(int j = i; j < sortedPoints.length; j++) {
            n.add(sortedPoints[j]);
            if(!n.add(sortedPoints[j])) {
               if(n.length() == 4) {
                  lines.add(n);
                  n = new Line();
                  n.add(points[i]);
                  n.add(sortedPoints[j]); 
               }
            }
         }
      }
      return lines;
   }
   
}
