import java.util.*;

public class Printing_Numbers {
  static int counter;
  
  protected static void setStaticVariable(int value) {
    counter = value;
  }
  
  protected static void printNumbers(int num) {
    System.out.print(counter + " ");
    if(counter == num) {
      return;
    }
    counter++;
    printNumbers(num);
  }

  protected static void printNumbersWithoutStaticVariable(int counting, int num) {
    System.out.print(counting + " ");
    
    if(counting == num) {
      return;
    }
    printNumbersWithoutStaticVariable(counting + 1, num);
  }
  
  public static void main(String args[]) {

    // Reason for the static not used inside the main class
    Scanner sc = new Scanner(System.in);

    int fromNum = sc.nextInt(), toNum = sc.nextInt();

    // For initializing the static variable
    setStaticVariable(fromNum);

    //Calling the recursive function
    System.out.print("With use of Static variable : ");
    printNumbers(toNum);
    System.out.println();

    System.out.print("Without use of Static variable : ");
    printNumbersWithoutStaticVariable(fromNum, toNum);
  }
}