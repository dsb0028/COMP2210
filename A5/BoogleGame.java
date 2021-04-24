import java.util.TreeSet;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Defines the methods needed to play a word search game.
 *
 * @author Daniel Benjamin (dsb0028@auburn.edu)
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2019/10/30
 * 
 */

public class BoogleGame implements WordSearchGame {
   private int height;
   private int width;
   private String [][] board;
   private TreeSet<String> lexicon;
   private boolean [][] visited;
   private ArrayList<Position> path;
   private String currentWord;
   private SortedSet<String> allWords;
   private ArrayList<Integer> path1; 
   private final int MAX_NEIGHBORS = 8;

   public BoogleGame() {
      lexicon = null;     
      board = new String[4][4];
      board[0][0] = "A"; 
      board[0][1] = "B"; 
      board[0][2] = "C"; 
      board[0][3] = "D"; 
      board[1][0] = "E"; 
      board[1][1] = "F"; 
      board[1][2] = "G"; 
      board[1][3] = "H"; 
      board[2][0] = "I"; 
      board[2][1] = "J"; 
      board[2][2] = "K"; 
      board[2][3] = "L"; 
      board[3][0] = "M"; 
      board[3][1] = "N"; 
      board[3][2] = "O"; 
      board[3][3] = "P";   
      width = board.length;
      height = board[0].length;        
      markAllUnvisited();
   }
   
   public void markAllUnvisited() {
      visited = new boolean[width][height];
      for (boolean[] row : visited) {
         Arrays.fill(row, false);
      }
   }
   
   private class Position {
      int x;
      int y;
   
      /** Constructs a Position with coordinates (x,y). */
      public Position(int x, int y) {
         this.x = x;
         this.y = y;
      }
   
      /** Returns a string representation of this Position. */
      @Override
      public String toString() {
         return "(" + x + ", " + y + ")";
      }
   
      /** Returns all the neighbors of this Position. */
      public Position[] neighbors() {
         Position[] nbrs = new Position[MAX_NEIGHBORS];
         int count = 0;
         Position p;
         for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
               if (!((i == 0) && (j == 0))) {
                  p = new Position(x + i, y + j);
                  if (isValid(p)) {
                     nbrs[count++] = p;
                  }
               }
            }
         }
         return Arrays.copyOf(nbrs, count);
      }
   }

   private boolean isValid(Position p) {
      return (p.x >= 0) && (p.x < width) && 
            (p.y >= 0) && (p.y < height);
   }

   private void visit(Position p) {
      visited[p.x][p.y] = true;
   }
   
   private boolean isVisited(Position p) {
      return visited[p.x][p.y];
   }
   
   private void markPathVisited() {
      for (int i = 0; i < path.size(); i++) {
         visit(path.get(i));
      }
   }

  
   /**
    * Loads the lexicon into a data structure for later use. 
    * 
    * @param fileName A string containing the name of the file to be opened.
    * @throws IllegalArgumentException if fileName is null
    * @throws IllegalArgumentException if fileName cannot be opened.
    */
   public void loadLexicon(String fileName) {
      if(fileName == null) {
         throw new IllegalArgumentException("file is null");
      }
      
      try {
         Scanner sc = new Scanner(new File(fileName));
         lexicon = new TreeSet<String>();
         while(sc.hasNext()) {
            String uniqueWord = sc.next().toUpperCase().trim();
            lexicon.add(uniqueWord);
            sc.nextLine();
         }
      }
      
      catch (java.io.FileNotFoundException e) {
         throw new IllegalArgumentException("file cannot be opened");
      }
   }
   
   /**
    * Stores the incoming array of Strings in a data structure that will make
    * it convenient to find words.
    * 
    * @param letterArray This array of length N^2 stores the contents of the
    *     game board in row-major order. Thus, index 0 stores the contents of board
    *     position (0,0) and index length-1 stores the contents of board position
    *     (N-1,N-1). Note that the board must be square and that the strings inside
    *     may be longer than one character.
    * @throws IllegalArgumentException if letterArray is null, or is  not
    *     square.
    */
   public void setBoard(String[] letterArray) {
      if (letterArray == null) {
         throw new IllegalArgumentException();
      }
      int N = letterArray.length;
      int n = (int)Math.sqrt(N);
      if ((n * n) != N) {
         throw new IllegalArgumentException();
      }
      board = new String[n][n];
      int width = n;
      int height = n;
      int index = 0;
      for (int i = 0; i < height; i++) {
         for (int j = 0; j < width; j++) {
            board[i][j] = letterArray[index];
            index++;
         }
      }
      markAllUnvisited();     
   }
   
   /**
    * Creates a String representation of the board, suitable for printing to
    *   standard out. Note that this method can always be called since
    *   implementing classes should have a default board.
    */
   public String getBoard() {
      String strBoard = "";
      for (int i = 0; i < height; i ++) {
         if (i > 0) {
            strBoard += "\n";
         }
         for (int j = 0; j < width; j++) {
            strBoard += board[i][j] + " ";
         }
      }
      return strBoard;
   }
   
   /**
    * Retrieves all valid words on the game board, according to the stated game
    * rules.
    * 
    * @param minimumWordLength The minimum allowed length (i.e., number of
    *     characters) for any word found on the board.
    * @return java.util.SortedSet which contains all the words of minimum length
    *     found on the game board and in the lexicon.
    * @throws IllegalArgumentException if minimumWordLength < 1
    * @throws IllegalStateException if loadLexicon has not been called.
    */
   public SortedSet<String> getAllValidWords(int minimumWordLength) {
      if (minimumWordLength < 1) {
         throw new IllegalArgumentException();
      }
      if (lexicon == null) {
         throw new IllegalStateException();
      }
      path = new ArrayList<Position>();
      allWords = new TreeSet<String>();
      currentWord = "";
      for (int i = 0; i < height; i++) {
         for (int j = 0; j < width; j++) {
            currentWord = board[i][j];
            if (isValidWord(currentWord) && currentWord.length() >= minimumWordLength) {
               allWords.add(currentWord);
            }
            if (isValidPrefix(currentWord)) {
               Position temp = new Position(i,j);
               path.add(temp);
               dfsForGetAllValidWords(i, j, minimumWordLength); 
               path.remove(temp);
            }
         }
      }
      return allWords;
   }
   
   private void dfsForGetAllValidWords(int x, int y, int minimumWordLength) {
      Position start = new Position(x, y);
      markAllUnvisited(); 
      markPathVisited();          
      for (Position neighbor : start.neighbors()) {
         if (!isVisited(neighbor)) {
            visit(neighbor);
            if (isValidPrefix(currentWord + board[neighbor.x][neighbor.y])) {
               currentWord += board[neighbor.x][neighbor.y];
               path.add(neighbor);
               if (isValidWord(currentWord) && currentWord.length() >= minimumWordLength) {
                  allWords.add(currentWord);
               }
               dfsForGetAllValidWords(neighbor.x, neighbor.y, minimumWordLength);
               path.remove(neighbor);
               int endIndex = currentWord.length() - board[neighbor.x][neighbor.y].length();
               currentWord = currentWord.substring(0, endIndex);
            }
         }
      }
      markAllUnvisited(); 
      markPathVisited(); 
   }
   
  /**
   * Computes the cummulative score for the scorable words in the given set.
   * To be scorable, a word must (1) have at least the minimum number of characters,
   * (2) be in the lexicon, and (3) be on the board. Each scorable word is
   * awarded one point for the minimum number of characters, and one point for 
   * each character beyond the minimum number.
   *
   * @param words The set of words that are to be scored.
   * @param minimumWordLength The minimum number of characters required per word
   * @return the cummulative score of all scorable words in the set
   * @throws IllegalArgumentException if minimumWordLength < 1
   * @throws IllegalStateException if loadLexicon has not been called.
   */  
   public int getScoreForWords(SortedSet<String> words, int minimumWordLength) {
      if (minimumWordLength < 1) {
         throw new IllegalArgumentException();
      }
      if (lexicon == null) {
         throw new IllegalStateException();
      }
      int score = 0;
      Iterator<String> itr = words.iterator();
      while (itr.hasNext()) {
         String word = itr.next();
         if (word.length() >= minimumWordLength && isValidWord(word)
             && !isOnBoard(word).isEmpty()) {
            score += (word.length() - minimumWordLength) + 1;
         }
      }
      return score;      
   }
   
   /**
    * Determines if the given word is in the lexicon.
    * 
    * @param wordToCheck The word to validate
    * @return true if wordToCheck appears in lexicon, false otherwise.
    * @throws IllegalArgumentException if wordToCheck is null.
    * @throws IllegalStateException if loadLexicon has not been called.
    */
   public boolean isValidWord(String wordToCheck) {
      if (lexicon == null) {
         throw new IllegalStateException();
      }
      if (wordToCheck == null) {
         throw new IllegalArgumentException();
      }
      wordToCheck = wordToCheck.toUpperCase();
      return lexicon.contains(wordToCheck);
   }
   
   /**
    * Determines if there is at least one word in the lexicon with the 
    * given prefix.
    * 
    * @param prefixToCheck The prefix to validate
    * @return true if prefixToCheck appears in lexicon, false otherwise.
    * @throws IllegalArgumentException if prefixToCheck is null.
    * @throws IllegalStateException if loadLexicon has not been called.
    */
   public boolean isValidPrefix(String prefixToCheck) {
      if (lexicon == null) {
         throw new IllegalStateException();
      }
      if (prefixToCheck == null) {
         throw new IllegalArgumentException();
      }
      prefixToCheck = prefixToCheck.toUpperCase();
      String word = lexicon.ceiling(prefixToCheck);
      if (word != null) {
         return word.startsWith(prefixToCheck);
      }
      return false;      
   }
      
   /**
    * Determines if the given word is in on the game board. If so, it returns
    * the path that makes up the word.
    * @param wordToCheck The word to validate
    * @return java.util.List containing java.lang.Integer objects with  the path
    *     that makes up the word on the game board. If word is not on the game
    *     board, return an empty list. Positions on the board are numbered from zero
    *     top to bottom, left to right (i.e., in row-major order). Thus, on an NxN
    *     board, the upper left position is numbered 0 and the lower right position
    *     is numbered N^2 - 1.
    * @throws IllegalArgumentException if wordToCheck is null.
    * @throws IllegalStateException if loadLexicon has not been called.
    */
   public List<Integer> isOnBoard(String wordToCheck) {
      if (wordToCheck == null) {
         throw new IllegalArgumentException();
      }
      if (lexicon == null) {
         throw new IllegalStateException();
      }
      path = new ArrayList<Position>();
      wordToCheck = wordToCheck.toUpperCase();
      currentWord = "";
      path1 = new ArrayList<Integer>();
      for (int i = 0; i < height; i++) {
         for (int j = 0; j < width; j++) {
            if (wordToCheck.equals(board[i][j])) {
               path1.add(i * width + j); 
               return path1;
            }
            if (wordToCheck.startsWith(board[i][j])) {
               Position pos = new Position(i, j);
               path.add(pos); 
               currentWord = board[i][j]; 
               dfsForIsOnBoard(i, j, wordToCheck);   
               if (!wordToCheck.equals(currentWord)) {
                  path.remove(pos);
               }
               else {
                  for (Position p: path) {
                     path1.add((p.x * width) + p.y);
                  } 
                  return path1;
               }
            }
         }
      }
      return path1;
   }
   
   private void dfsForIsOnBoard(int x, int y, String wordToCheck) {
      Position start = new Position(x, y);
      markAllUnvisited(); 
      markPathVisited(); 
      for (Position p: start.neighbors()) {
         if (!isVisited(p)) {
            visit(p);
            if (wordToCheck.startsWith(currentWord + board[p.x][p.y])) {
               currentWord += board[p.x][p.y];                   
               path.add(p);
               dfsForIsOnBoard(p.x, p.y, wordToCheck);
               if (wordToCheck.equals(currentWord)) {
                  return;
               }
               else {
                  path.remove(p);
                  int endIndex = currentWord.length() - board[p.x][p.y].length();
                  currentWord = currentWord.substring(0, endIndex);
               }
            }
         }
      }
      markAllUnvisited(); 
      markPathVisited();       }
}