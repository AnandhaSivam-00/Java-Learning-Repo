import java.util.*;
class Pattern_Half_Diamond {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();

      for(int row=1;row<=size;row++){
        for(int space=1;space<=size-row;space++)
            System.out.print(" ");
        for(int col=1;col<=row;col++)
            System.out.print("* ");
        System.out.println();
      }
      for(int row=size-1;row>0;row--){
      for(int space=1;space<=size-row;space++)
          System.out.print(" ");
        for(int col=1;col<=row;col++)
            System.out.print("* ");
        System.out.println();
      }
  }
}