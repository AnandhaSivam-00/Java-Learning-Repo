import java.util.*;

public class FindLastWordLength {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    String str = sc.nextLine();
    StringBuilder sb = new StringBuilder();

    int strLen = str.length();

    for(int i = strLen - 1; i >= 0; i--) {
      if(str.charAt(i) != ' ') {
        sb.append(str.charAt(i));
      }
      else if(sb.length() > 0) {
        break;
      }
    }
    System.out.println(sb.length());
  }
}