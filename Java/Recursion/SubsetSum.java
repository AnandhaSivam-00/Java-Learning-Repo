import java.util.*;

public class SubsetSum {
  protected static void subsetSum(int arr[], int n, int i, List<Integer> currSubset, List<Integer> ans) {
    if(i == n) {
      int sum = 0;
      for(int j=0; j<currSubset.size(); j++) {
        sum += currSubset.get(j);
      }
      ans.add(sum);
      return;
    }

    currSubset.add(arr[i]);
    subsetSum(arr, n, i+1, currSubset, ans);
    currSubset.remove(currSubset.size()-1);
    subsetSum(arr, n, i+1, currSubset, ans);
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int arr[] = new int[n];
    for(int i=0; i<n; i++) {
      arr[i] = sc.nextInt();
    }

    List<Integer> currSubset = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();

    subsetSum(arr, n, 0, currSubset, ans);

    Collections.sort(ans);
    for(int i=0; i<ans.size(); i++) {
      System.out.print(ans.get(i) + " ");
    }
  }
}