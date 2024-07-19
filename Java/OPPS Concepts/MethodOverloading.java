//Calculator Class
public class MethodOverloading {

  // Add funtions with two parameters
  int add(int num1, int num2) {
    return num1 + num2;
  }

  // Add funtions with three parameters
  int add(int num1, int num2, int num3 ) {
    return num1 + num2 + num3;
  }

  // Add funtions with four parameters
  int add(int num1, int num2, int num3, int num4 ) {
    return num1 + num2 + num3 + num4;
  }

  public static void main(String args[]) {
    MethodOverloading cal = new MethodOverloading();

    System.out.println("10 + 20 =  " + cal.add(10, 20));
    System.out.println("10 + 20 + 30 =  " + cal.add(10, 20, 30));
    System.out.println("10 + 20 + 30 + 40 =  " + cal.add(10, 20, 30, 40));
  }

}