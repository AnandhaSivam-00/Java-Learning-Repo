import java.util.*;

public class LargestTwoOddIntegers {
  protected static int findingLargestDigitNumber(int num) {
    int firstLarge = Integer.MIN_VALUE, secondLarge = Integer.MIN_VALUE, temp;

    temp = num;

    while()
  
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt(), i, j, maxNum = Integer.MIN_VALUE;

    String strNum = Integer.toString(num), temp;

    for(i=0; i<strNum.length(); i++) {
      for(j=0; j<strNum.length(); j++) {
        if(i != j) {
          temp = Character.toString(strNum.charAt(i)) + Character.toString(strNum.charAt(j));
          
          if(Integer.parseInt(temp) % 2 != 0 && Integer.parseInt(temp) > maxNum) {
            maxNum = Integer.parseInt(temp);
          }
        }
      }
    }

    if(maxNum == Integer.MIN_VALUE) { 
      System.out.println("-1"); 
    }
    else {
      System.out.println(maxNum);
    }

    System.out.print(findingTwoDigitNumber(num));
  }
}