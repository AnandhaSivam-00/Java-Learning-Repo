class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()) {
            return false;
        }
        else {
            Map<Character, Integer> freqMap = new HashMap<>();
            int i, j, wordLen = s1.length(), count;
            char ch;

            for(i=0; i<wordLen; i++) {
                freqMap.put(s1.charAt(i), freqMap.getOrDefault(s1.charAt(i), 0) + 1);
            }

            for(i=0; i<=s2.length() - wordLen; i++) {
                Map<Character, Integer> temp = new HashMap<>(freqMap);

                j = i;
                count = 0;

                while(j < s2.length()) {
                    ch = s2.charAt(j);

                    if(temp.containsKey(ch) && temp.get(ch) > 0){
                        temp.put(ch, temp.get(ch)-1);
                        count++;
                    }
                    else {
                        break;
                    }
                    j++;
                }

                if(wordLen == count) {
                    return true;
                }
            }
        }
        return false;
    }
}