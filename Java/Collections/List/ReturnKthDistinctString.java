import java.util.*;

public class ReturnKthDistinctString {
  protected static String findingKthDistinctString(String str[], int k) {
    List<String> nonDuplicates = new ArrayList<>();
    Set<String> duplicates = new HashSet<>();
    boolean isVisited;

    for(int i=0; i<str.length; i++) {
      isVisited = false;
      for(int j=i+1; j<str.length; j++) {
        if(str[i].equals(str[j]) || duplicates.contains(str[i])) {
          duplicates.add(str[i]);
          isVisited = true;
          break;
        }
      }

      if(!isVisited && !duplicates.contains(str[i])) {
        nonDuplicates.add(str[i]);
        k--;

        if(k == 0) {
          return str[i];
        }
      }
    }
    return "";
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String str = sc.nextLine();
    String strArr[] = str.split(" ");

    int k = sc.nextInt();

    System.out.println(findingKthDistinctString(strArr, k));
  }
}