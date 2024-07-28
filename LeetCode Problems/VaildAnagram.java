class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() < t.length()) {
            return false;
        }

        char str1[] = s.toCharArray();
        char str2[] = t.toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);

        int i = 0;
        while(i < s.length() && i < t.length() && str1[i] == str2[i]) {
            i++;
        }

        if(i == s.length()) {
            return true;
        }
        else {
            return false;
        }
    }
}