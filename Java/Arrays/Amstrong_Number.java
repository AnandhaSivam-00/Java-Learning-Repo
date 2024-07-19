import java.util.*;

public class Amstrong_Number {

  protected static boolean isAmstrong(int num) {
    String strNum = Integer.toString(num);
    int sum = 0, temp = num, rem;

    while(temp != 0) {
      rem = temp % 10;
      sum += Math.pow(rem, strNum.length());
      temp /= 10;
    }

    if(sum == num) {
      return true;
    }
    else {
      return false;
    }
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int startNum = sc.nextInt(), endNum = sc.nextInt();

    for(int i=startNum; i<=endNum; i++) {
      if(isAmstrong(i)) {
        System.out.print(i + " ");
      }
    }
  }
}