import java.util.*;

public class First_Letter_After_Alpha {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    String resultStr = "";

    // To convert the string to char array
    char[] charArr = str.toCharArray();

    Arrays.sort(charArr);

    // Converting char array to string
    resultStr = String.valueOf(charArr);
    System.out.print(resultStr);
  }
}