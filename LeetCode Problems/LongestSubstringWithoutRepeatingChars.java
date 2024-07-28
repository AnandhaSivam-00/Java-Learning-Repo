class Solution {
    public int lengthOfLongestSubstring(String s) {
        String tempStr = "";
        int i=0, maxLen = Integer.MIN_VALUE;

        for(i=0; i<s.length(); i++) {
            if(tempStr.indexOf(s.charAt(i)) != -1) {
                maxLen = Math.max(maxLen, tempStr.length());
                tempStr = tempStr.substring(tempStr.indexOf(s.charAt(i))+1);
            }
            tempStr += Character.toString(s.charAt(i));
        }

        maxLen = Math.max(maxLen, tempStr.length());

        return maxLen;
    }
}