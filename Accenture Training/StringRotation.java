import java.util.*;

public class StringRotation {
  protected static String rightRotation(String str, int k) {
    StringBuilder sb = new StringBuilder();

    for(int i=0; i<str.length(); i++) {
      int index = (i + k + 1) % str.length();
      sb.append(str.charAt(index));
    }

    return sb.toString();
  }

  protected static String leftRotation(String str, int k) {
    StringBuilder sb = new StringBuilder();

    for(int i=0; i<str.length(); i++) {
      int index = (i + k) % str.length();
      sb.append(str.charAt(index));
    }

    return sb.toString();
  }

  protected static String shortcutForString(String str, int k) {
    StringBuilder sb = new StringBuilder(str + str);

    int temp = sb.length() - k - 1;
    int start = Math.abs(str.length() - temp);
    int end = start + str.length();

    return sb.substring(start, end);
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    String str = sc.nextLine();
    int rotationCount = sc.nextInt();

    rotationCount = rotationCount % str.length();
    StringBuilder sb = new StringBuilder();

    for(int i=0; i<str.length(); i++) {
      int index = (i + rotationCount + 1) % str.length();
      sb.append(str.charAt(index));
    }

    System.out.println(rightRotation(str, rotationCount));
    System.out.println(leftRotation(str, rotationCount));
    System.out.println(shortcutForString(str, rotationCount));
  }
}