import java.util.*;

public class Longest_SubString_WithoutRep {
  
  public static int lengthOfLongestSubstringCount(String s) {
    String tempStr = "", resultStr = "";
    int i=0, maxLen = Integer.MIN_VALUE;

    for(i=0; i<s.length(); i++) {
      if(tempStr.indexOf(s.charAt(i)) != -1) {
        // maxLen = Math.max(maxLen, tempStr.length());
        if(tempStr.length() > maxLen) {
          maxLen = tempStr.length();
          resultStr = tempStr;
        }
        tempStr = tempStr.substring(tempStr.indexOf(s.charAt(i))+1);
      }
      tempStr += Character.toString(s.charAt(i));
    }

    if(tempStr.length() > maxLen) {
      maxLen = tempStr.length();
      resultStr = tempStr;
    }
    
    System.out.println(resultStr);

    return maxLen;
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    System.out.println(lengthOfLongestSubstringCount(str));
  }
}