import java.util.*;

public class StarRemoval {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    String str = sc.nextLine();
    str = str.trim();

    StringBuilder sb = new StringBuilder();

    for(int i=0; i<str.length(); i++) {
      if(str.charAt(i) != '*') {
        sb.append(str.charAt(i));
      }
      else if(i != 0 && sb.length() != 0) {
        sb.deleteCharAt(sb.length()-1);
      }
    }

    System.out.println(sb.toString());
  }
}