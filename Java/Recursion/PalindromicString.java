import java.util.*;
public class PalindromicString {
  protected static boolean isPalindrome(String str) {
    if(str.length() == 0 || str.length() == 1) {
      return true;
    }
    if(str.charAt(0) == str.charAt(str.length()-1)) {
      return isPalindrome(str.substring(1, str.length()-1));
    }
    return false;
  }

  protected static boolean checkPalindrome(String str) {
    
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String str = sc.next();

    if(isPalindrome(str)) {
      System.out.println("Yes");
    }
    else {
      System.out.println("No");
    }
  }
}