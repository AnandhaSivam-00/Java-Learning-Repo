// Given a string s, reverse only all the vowels in the string and return it.
// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both 
//lower and upper cases, more than once.
// Example 1:

// Input: s = "hello"
// Output: "holle"
// Example 2:

// Input: s = "leetcode"
// Output: "leotcede"

// Constraints:

// 1 <= s.length <= 3 * 105
// s consist of printable ASCII characters.

class Solution {
    public String reverseVowels(String s) {
        char result[] = new char[s.length()];
        String vowelStr = "aAeEiIoOuU";

        int i=0, j=s.length()-1;

        while(i <= j) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);

            if(!vowelStr.contains(Character.toString(ch1))) {
                result[i] = ch1;
                i++;
            }
            else if(!vowelStr.contains(Character.toString(ch2))) {
                result[j] = ch2;
                j--;
            }
            else {
                result[i] = ch2;
                result[j] = ch1;
                i++;
                j--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(i=0; i<result.length; i++) {
            sb.append(result[i]);
        }

        return sb.toString();
    }
}