class Solution {
    public boolean wordPattern(String pattern, String s) {
        String strArr[] = s.split(" ");

        if(pattern.length() != strArr.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        int i;
        char ch;

        for(i=0; i<pattern.length(); i++) {
            ch = pattern.charAt(i);

            if(!map.containsKey(ch)) {
                if(map.containsValue(strArr[i])) {
                    return false;
                }
                map.put(ch, strArr[i]);
            }
            else {
                if(!map.get(ch).equals(strArr[i])) {
                    return false;
                }
            }
        }

        return true;
    }
}