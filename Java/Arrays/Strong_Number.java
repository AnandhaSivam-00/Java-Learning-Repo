import java.util.*;

public class Strong_Number {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int sum = 0, temp = num, rem;
    
    while(temp != 0) {
      rem = temp % 10;
      sum += factorial(rem);
      temp /= 10;
    }
    
    if(sum == num) {
      System.out.println("Strong Number");
    }
    else {
      System.out.println("Not a Strong Number");
    }
  }
  
  public static int factorial(int num) {
    int fact = 1;
    
    for(int i=1; i<=num; i++) {
      fact *= i;
    }
    
    return fact;
  }
}