import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class UniqueElements {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean isVisited[] = new boolean[n];
        boolean flag;
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<n; i++) {
            flag = false;
            if(!isVisited[i]) {
                for(int j=i+1; j<n; j++) {
                    if(arr[i] == arr[j]) {
                        flag = true;
                        isVisited[j] = true;
                    }
                }
                if(!flag) {
                    result.add(arr[i]);
                }
            }
        }

        if(result.size() == 0) {
            System.out.println("No unique elements in the array");
        }
        else {
            for(int item : result) {
                System.out.print(item + " ");
            }
        }

    }
}