import java.util.HashMap;
import java.util.Map;

public class MostCommonCharacter {
    /**
     * Find the most common character in str.
     * You could use a HashMap that maps a Character key to an Int value to represent how many times a Character has
     * been spotted.
     * @param str A String.
     * @return the most common character within str.
     */
    public char recurringChar(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for(char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        int maxFreq = Integer.MIN_VALUE;
        char maxRepeatedChar = ' ';

        for(Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if(entry.getValue() > maxFreq) {
                maxRepeatedChar = entry.getKey();
                maxFreq = entry.getValue();
            }
        }
        return maxRepeatedChar;
    }
}
