import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MonotonicArrayOrNot {
    protected static boolean isMonotonic(int arr[], int n) {
        int incCount = 1, decCount = 1;

        for(int i=1; i<n; i++) {
            if(arr[i-1] < arr[i]) {
                incCount++;
            }
            else if(arr[i-1] > arr[i]) {
                decCount++;
            }
        }

        if(incCount == n || decCount == n) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        if(isMonotonic(arr, n)) {
            System.out.println("Monotonic");
        }
        else {
            System.out.println("Not Monotonic");
        }
    }
}