import java.util.*;
public class Palindromic_String_With_Encoding {
  protected static boolean isPalindrome(String str) {
    int i = 0, j = str.length() - 1;
    while(i < j) {
      if(str.charAt(i) != str.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }

    return true;
  }
  
  protected static List<String> checkForPalindrome(String strArr[]) {
    List<String> isPalindrome = new ArrayList<>();

    for(String str : strArr) {
      if(isPalindrome(str.toLowerCase())) {
        isPalindrome.add("Palindrome");
      }
      else {
        isPalindrome.add("Not Palindrome");
      }
    }
    return isPalindrome;
  }

  protected static List<String> stringEncoding(String strArr[]) {
    System.out.println("Enter a Encoding Number : ");
    int i, encoding = new Scanner(System.in).nextInt();
    String tempStr = "";
    int charNum;
    
    List<String> encoded = new ArrayList<>();

    for(String str : strArr) {
      tempStr = "";

      for(i=0; i<str.length(); i++) {
        if(Character.isLowerCase(str.charAt(i))) {
          charNum = (int)str.charAt(i) + encoding;
          
          if(charNum >= 97 && charNum <= 122) {
            tempStr += Character.toString((char)charNum);
          }
          else {
            tempStr += Character.toString((char)(charNum % 122) + 96);
          }
        }
        else if(Character.isUpperCase(str.charAt(i))) {
          charNum = (int)str.charAt(i) + encoding;

          if(charNum >= 65 && charNum <= 90) {
            tempStr += Character.toString((char)charNum);
          }
          else {
            tempStr += Character.toString((char)(charNum % 90) + 64);
          }
        }
        else {
          tempStr += Character.toString(str.charAt(i));
        }
      }
      
      encoded.add(tempStr);
    }

    return encoded;
  }

  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int noOfStrings = sc.nextInt(), i;

    String op[] = new String[noOfStrings];
    for(i=0; i<noOfStrings; i++) {
      op[i] = sc.next();
    }

    List<String> palindromicStrings = checkForPalindrome(op);
    System.out.println("Is Palindromic String:");
    for(i=0; i<noOfStrings; i++) {
      System.out.println(op[i] + " : " + palindromicStrings.get(i));
    }

    
    List<String> encodedStrings = stringEncoding(op);
    System.out.println("Encoded String:");
    for(i=0; i<noOfStrings; i++) {
      System.out.println(op[i] + " is encoded as " + encodedStrings.get(i));
    }
  }
}