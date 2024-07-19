import java.util.*;
public class Pattern_Alpha_Triangle {
  protected static void nonChangingRow(String str) {
    for(int row=0; row<str.length(); row++) {
      for(int col=0; col<=row; col++) {
        System.out.print(str.charAt(col) + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  protected static void changingRow(String str) {
    
    int strSize = str.length(), pointer = 0;
    
    for(int row=0; row<strSize; row++) {
      for(int col=0; col<=row; col++) {
        System.out.print(str.charAt(pointer) + " ");
        pointer++;
        if(pointer >= strSize) {
          pointer = 0;
        }
      }
      System.out.println();
    }
    System.out.println();
  }

  protected static void changingRowWithClearWords(String str) {
    int strSize = str.length();

    for(int row=0; row<strSize; row++) {
      for(int col=0; col<=row; col++) {
        System.out.print(str.charAt(row) + " ");
      }
      
      System.out.println();
    }
    System.out.println();
  }

  protected static void nonChangingRowInversion(String str) {
    for(int row=str.length()-1; row>=0; row--) {
      for(int col=0; col<=row; col++) {
        System.out.print(str.charAt(col) + " ");
      }
      System.out.println();
    }

    System.out.println();
  }

  protected static void fullTriangleWithRev(String str) {
    int forwardPtr, revPtr;
    for(int row=0; row<str.length(); row++) {
      
      forwardPtr = 0;
      revPtr = row - 1;
      
      for(int space=0; space<str.length()-row-1; space++) {
        System.out.print(" ");
      }

      for(int col=0; col<=row; col++) {
        System.out.print(str.charAt(forwardPtr));
        forwardPtr++;
      }

      for(int col=0; col<row; col++) {
        System.out.print(str.charAt(revPtr));
        revPtr--;
      }
      System.out.println();
    }

    System.out.println();
  }

  protected static void changingRowWithClearWordsRev(String str) {
    int pointer;
    for(int row=0; row<str.length(); row++) {
      pointer = str.length() - row - 1;
      for(int col=0; col<=row; col++) {
        System.out.print(str.charAt(pointer) + " ");
        pointer++;
      }
      System.out.println();
    }

    System.out.println();
  }

  protected static void twoFacedTriangle(String str) {
    for(int row=0; row<str.length(); row++) {
      for(int col=0; col<=row; col++) {
        System.out.print(str.charAt(col));
      }

      for(int space=0; space<str.length()*2 - row*2 - 2; space++) {
        System.out.print(" ");
      }

      for(int col=0; col<=row; col++) {
        System.out.print(str.charAt(row - col));
      }
      System.out.println();
    }
    System.out.println();
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    String givenStr = sc.next();

    givenStr = givenStr.toUpperCase();

    // nonChangingRow(givenStr);
    // changingRow(givenStr);
    // changingRowWithClearWords(givenStr);
    // nonChangingRowInversion(givenStr);
    // fullTriangleWithRev(givenStr);
    // changingRowWithClearWordsRev(givenStr);
    twoFacedTriangle(givenStr);
  }
}

