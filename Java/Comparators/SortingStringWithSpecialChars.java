// John wants to learn alphabet ordering. He was given a task of ordering the alphabets within a word in a given string and also arrange words based on its maximum to minimum length. If more than one word have same length, then arrange words based on first letter in alphabetical order. If any of the word contains other than character, then place at end of the word. Write a program to help john to order it.

// Note: Assume the minimum word size is two, each word contains at least one character.

// Example 1:

// Sample Input: THE PRICE OF BREAD IN RS

// Sample Output: ABDER CEIPER EHT FO IN RS




import java.util.*;
import java.util.stream.*;

public class SortingStringWithSpecialChars {
    protected static String wordSorting(String s) {
        List<String> charArr = Arrays.asList(s.split(""));

        Collections.sort(charArr, String.CASE_INSENSITIVE_ORDER);

        return String.join("", charArr);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine(), tempStr;

        int i, j;
        boolean flag;

        List<String> sorted = new ArrayList<>();
        List<String> others = new ArrayList<>();

        List<String> wordSorted = Arrays.asList(str.split(" "));
            // .stream()
            // .sorted()
            // .collect(Collectors.toList());

        for(i=0; i<wordSorted.size(); i++) {
            tempStr = wordSorted.get(i);
            flag = false;
            for(j=0; j<tempStr.length(); j++) {
                if(!Character.isLetter(tempStr.charAt(j))) {
                    others.add(tempStr);
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                sorted.add(wordSorting(wordSorted.get(i)));
            }
        }

        Collections.sort(
            sorted, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    if(a.length() == b.length()) {
                        return a.charAt(0) - b.charAt(0);
                    }
                    return b.length() - a.length();
                }
            }); 

        sorted.addAll(others);


        System.out.println(String.join(" ", sorted).trim());
    }
}


