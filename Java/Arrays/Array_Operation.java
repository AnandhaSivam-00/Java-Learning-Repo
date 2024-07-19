
import java.util.*;
import java.util.HashMap;

public class Array_Operation {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Integer> result = new HashMap<>();

        int size = sc.nextInt();
        int arr[] = new int[size];
        int freq;

        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<size; i++) {
            freq = 0;
            for(int j=0; j<size; j++) {
                if(arr[i] == arr[j]) {
                    freq++;
                }
            }

            if(!result.containsKey(arr[i])) {
                result.put(arr[i], freq);
            }
        }

        for(Map.Entry<Integer, Integer> items : result.entrySet()) {
            System.out.println(items.getKey() + " " + items.getValue());
        }

    }
}
