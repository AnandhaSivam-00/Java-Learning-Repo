// Within a collection of strings, your task is to employ Binary Search to identify the longest common prefix. 
// Devise a solution that efficiently determines the shared prefix among the given strings, 
// utilizing the principles of Binary Search.

// Example:

// Input: strings = ["flower", "flow", "flight"]
// Output: Longest Common Prefix: 'fl'

import java.util.*;

public class LongestCommonPrefix {
  protected static boolean checkForContains(String str[], int len, String tempStr, int start, int end) {
    for(int i=0; i<len; i++) {
      if(!tempStr.equals(str[i].substring(start, end))) {
        return false;
      }
    }

    return true;
  }
  
  protected static String longestCommonPrefix(String[] str, int len, int smallLen) {
    int start = 0;
    int end = smallLen-1;
    StringBuilder prefix = new StringBuilder();

    while(start <= end) {
      int mid = start + (end - start) / 2;

      String tempStr = str[0].substring(start, mid+1);

      if(checkForContains(str, len, tempStr, start, mid+1)) {
        prefix.append(tempStr);
        start = mid + 1;
      }
      else {
        end = mid - 1;
      }
    }

    return prefix.toString();
  }  
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] strings = new String[sc.nextInt()];
    int strLen = strings.length;
    
    for(int i=0; i<strLen; i++) {
      strings[i] = sc.next();
    }
    
    int smallStrLength = Integer.MAX_VALUE, i = 0;

    for(i=0; i<strLen; i++) {
      smallStrLength = Math.min(smallStrLength, strings[i].length());
    }

    System.out.println(longestCommonPrefix(strings, strLen, smallStrLength));
  }
}