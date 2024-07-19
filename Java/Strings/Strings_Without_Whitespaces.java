import java.util.*;

public class Strings_Without_Whitespaces {
  protected static List<String> reverseCase(String strArr[]) {
    List<String> revList = new ArrayList<>();
    int i;
    String tempStr = "";

    for(String str : strArr) {
      tempStr = "";
      for(i = 0; i < str.length(); i++) {
        if(Character.isUpperCase(str.charAt(i))) {
          tempStr += Character.toLowerCase(str.charAt(i));
        } 
        else {
          tempStr += Character.toUpperCase(str.charAt(i));
        }
      }
      revList.add(tempStr);
    }
    return revList;
  }
  
  protected static List<String> removeWhitespaces(String strArr[]) {
    List<String> lists = new ArrayList<>();
    int i;
    String tempStr;

    for(String str : strArr) {
      tempStr = "";
      for(i=0; i<str.length(); i++) {
        if(str.charAt(i) != ' ') {
          tempStr += Character.toString(str.charAt(i));
        }
      }
      lists.add(tempStr);
    }

    return lists;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int noOfStrings = sc.nextInt(), i;
    
    String op[] = new String[noOfStrings + 1];
    for(i=0; i<=noOfStrings; i++) {
      op[i] = sc.nextLine();
    }
    
    System.out.print("Removed Whitespace Strings:");
    for(String str : removeWhitespaces(op)) {
      System.out.println(str);
    }

    System.out.println();

    System.out.print("Reverse Cased Strings:");
    for(String str : reverseCase(op)) {
      System.out.println(str);
    }
  }
}