import java.util.*;

public class DistinctPairs {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(), i, j;
    int[] arr = new int[n];

    for(i=0; i<n; i++) {
      arr[i] = sc.nextInt();
    }

    HashMap<Integer, Integer[]> map = new HashMap<>();

    for(i=0; i<n; i++) {
      for(j=i+1; j<n; j++) {
        if(!map.containsKey(arr[i] + arr[j])) {
          map.put(arr[i] + arr[j], new Integer[] {arr[i], arr[j]});
        }
        else {
          System.out.println("(" + arr[i] + "," + arr[j] + ")" + " and " + "(" + map.get(arr[i] + arr[j])[0] + "," + map.get(arr[i] + arr[j])[1] + ")");
          i = n;
          j = n;
        }
      }
    }
  }
}