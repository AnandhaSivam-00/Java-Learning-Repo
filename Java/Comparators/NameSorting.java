// To sort people's names based on their heights in descending order.

import java.util.*;

public class NameSorting {
  protected static String[] sortPeople(String[] names, int[] heights) {
    Integer index[] = new Integer[heights.length];
    int i;

    for(i=0; i<heights.length; i++) {
        index[i] = i;
    }

    Arrays.sort(index, (a, b) -> heights[b] - heights[a]);

    String sortedNames[] = new String[heights.length];
    for(i=0; i<heights.length; i++) {
        sortedNames[i] = names[index[i]];
    }

    return sortedNames; 
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String names[] = new String[n];
    int heights[] = new int[n];

    for(int i=0; i<n; i++) {
      names[i] = sc.next();
      heights[i] = sc.nextInt();
    }

    String sortedNames[] = sortPeople(names, heights);

    for(int i=0; i<n; i++) {
      System.out.println(sortedNames[i]);
    }
  }
}

