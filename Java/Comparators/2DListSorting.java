// Given an array of integers, create a 2D array where the first element is a distinct value 
// from the array and the second element is the frequency of that value in the array, 
// Sort the resulting array in descending order by frequency. If multiple values have 
// the same frequency, sort them in ascending order by value.

// Example

// arr = [3, 3, 1, 2, 1]

// There are two values, 3 and 1, each with a frequency of 2, and one value 2 with a frequency 
// of 1: [[3, 2], [1, 2], [2, 1]]

// Sort the 2-dimensional array descending by frequency: [[3,2], [1, 2], [2, 1]]

// Sort the 2-dimensional array ascending by value for values with matching 
// frequencies: [[1,2], [3, 2], [2, 1]]



import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'groupSort' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<List<Integer>> groupSort(List<Integer> arr) {
    // Write your code here
        List<List<Integer>> resultArray = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int i=0; i<arr.size(); i++) {
            freqMap.put(arr.get(i), freqMap.getOrDefault(arr.get(i), 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            List<Integer> temp = new ArrayList<>();
            temp.add(entry.getKey());
            temp.add(entry.getValue());
            resultArray.add(temp);
        }

        Collections.sort(resultArray, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> a, List<Integer> b) {
                if(a.get(1).equals(b.get(1))) {
                    return a.get(0).compareTo(b.get(0));
                }
                else {
                    return b.get(1).compareTo(a.get(1));
                }
            }
        });

        return resultArray;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<List<Integer>> result = Result.groupSort(arr);

        result.stream()
            .map(
                r -> r.stream()
                    .map(Object::toString)
                    .collect(joining(" "))
            )
            .map(r -> r + "\n")
            .collect(toList())
            .forEach(e -> {
                try {
                    bufferedWriter.write(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
