import java.util.*;

public class Non_Duplicate_UpperCase_Chars {
  public static void main(String args[]) {
    boolean visited[] = new boolean[125];
    Scanner sc = new Scanner(System.in);

    String str = sc.nextLine(), resultStr = "";

    for(int i=0; i<str.length(); i++) {
      if(visited[(int)str.charAt(i)] == false && str.charAt(i) >= 65 && str.charAt(i) <= 90) {
        resultStr += Character.toString(str.charAt(i));
        visited[(int)str.charAt(i)] = true;
      }
    }

    System.out.print(resultStr);
  }
}