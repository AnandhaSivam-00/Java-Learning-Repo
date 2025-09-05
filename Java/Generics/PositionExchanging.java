// Write a generic method to exchange the positions of two 
// different elements in an array.

import java.util.*;

class Exchanger {
  protected static <T> void exchange(T[] arr, int pos1, int pos2) {
    T temp = arr[pos1];
    arr[pos1] = arr[pos2];
    arr[pos2] = temp;
  }
}

public class PositionExchanging {
  public static void main(String[] args) {
    Integer[] arr = {1, 2, 3, 4, 5};
    Exchanger.exchange(arr, 0, 4);

    System.out.println(Arrays.toString(arr));
  }
}
