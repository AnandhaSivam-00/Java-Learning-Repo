import java.util.*;
import java.util.stream.*; 

// To Reverse a words in a string

public class Concept_3 {
  protected static String reverseWords(String str) {
    String words[] = str.split(" ");
    
    String reversed = "";
    
    for(int i=0; i<words.length; i++) {
      String tempStr[] = words[i].split("");
      
      String sortedStr = Arrays.asList(tempStr)
        .stream()
        .sorted()
        .collect(Collectors.joining("")); // To join various elements of a character or string array into a single string object

      reversed += (sortedStr + " ");
    }
    return reversed.trim();
  }

  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    System.out.println(reverseWords(sc.nextLine()));
  }
}