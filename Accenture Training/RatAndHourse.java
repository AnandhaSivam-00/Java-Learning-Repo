// The function accepts two positive integers ‘r’ and ‘unit’ and a positive integer array 
// ‘arr’ of size ‘n’ as its argument ‘r’ represents the number of rats present in an area, 
// ‘unit’ is the amount of food each rat consumes and each ith element of array ‘arr’ represents the 
// amount of food present in ‘i+1’ house number, where 0 <= i
// Input Format

// Line 1: Number of rats (positive integer) Line 2: Food consumption per rat (positive integer) Line 3: Number of houses (positive integer) Line 4: Food in each house (space-separated positive integers)

// Constraints
// 1 <= Number of rats (r) <= 10^5 1 <= Food consumption per rat (unit) <= 100 1 <= Number of houses (n) <= 10^5 1 <= Amount of food in each house <= 100

// Output Format
// An integer representing the house number with enough food for all rats. Return -1 if the array is null. Return 0 if total house food is insufficient for all rats.

// Sample Input 0
// 5
// 3
// 4
// 2 1 5 2
// Sample Output 0
// 0

// Sample Input 1
// 10
// 1
// 7
// 2 4 1 6 3 7 9
// Sample Output 1
// 4


import java.util.*;

public class RatAndHouse {
    protected static int findingHouseNumber(int arr[], int n, int rat, int unit) {
        if(n == 0) {
            return -1;
        }
        
        int totFood = rat * unit;
        for(int i=0; i<n; i++) {
            totFood -= arr[i];
            if(totFood <= 0) {
                return i+1;
            }
        }
        
        return 0;
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int rat = sc.nextInt(), unit = sc.nextInt(), n = sc.nextInt();
        int arr[] = new int[n];
        
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.println(findingHouseNumber(arr, n, rat, unit));
    }
}
