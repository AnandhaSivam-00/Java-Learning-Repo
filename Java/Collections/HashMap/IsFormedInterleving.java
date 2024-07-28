// You are given 3 strings: first,  second, and  third.  third String is said to be a shuffle of first and second if it can be formed by interleaving the characters of first and second String in a way that maintains the left to right ordering of the characters from each string.

// Example: 1

// Input : "abc","def","dabecf"

// Output: true

// Example: 2

// Input :"abc","def","dakecf"

// Output: false



import java.util.*;

public class IsFormedInterleving {
    protected static boolean checkOperation(String str1, String str2, String str3) {

        Map<Character, Integer> freqMap = new HashMap<>();

        for(char i : str1.toCharArray()) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        for(char j : str2.toCharArray()) {
            freqMap.put(j, freqMap.getOrDefault(j, 0) + 1);
        }

        for(char k : str3.toCharArray()) {
            if(!freqMap.containsKey(k)) {
                return false;
            }

            if(freqMap.get(k) > 0) {
                freqMap.put(k, freqMap.get(k) - 1);
            }
            else if(freqMap.get(k) == 0) {
                freqMap.remove(k);
            }
        }

        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        str = str.replace("\"", "");

        String strArr[] = str.split(",");

        System.out.println(checkOperation(strArr[0], strArr[1], strArr[2]));
    }
}
