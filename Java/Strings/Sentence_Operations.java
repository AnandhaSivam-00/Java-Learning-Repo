import java.util.*;

public class Sentence_Operations {
  protected static void printResult(List<String> results) {
    int i;
    for(i=0; i<results.size(); i++) {
      System.out.println(results.get(i));
    }
  }
  
  protected static List<String> onlyThreeLetterWords(String strArr[]) {
    List<String> threeLetterWords = new ArrayList<>();
    int i, j, count;

    for(i=0; i<strArr.length; i++) {
      count = 0;
      for(j=0; j<strArr[i].length(); j++) {
        if(Character.isLetter(strArr[i].charAt(j))) {
          count++;
        }
      }

      if(count >= 3) {
        threeLetterWords.add(strArr[i]);
      }
    }
    
    return threeLetterWords;
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    String[] strArr = str.split(" ");

    System.out.println("Words with 3 letters :");
    printResult(onlyThreeLetterWords(strArr));
    
  }
}