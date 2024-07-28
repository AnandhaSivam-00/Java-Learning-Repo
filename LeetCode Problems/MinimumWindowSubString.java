class Solution {
    public String minWindow(String s, String t) {
        int slen = s.length();
        int tlen = t.length();

        if(slen < tlen) {
            return "";
        }
        else {
            char sCh[] = s.toCharArray();
            char tCh[] = t.toCharArray();
            int i,j, tLen = t.length(), sLen = s.length(), count, start = 0, end = 0, minLength = Integer.MAX_VALUE;

            int freq[] = new int[128];

            for(i=0; i<tlen; i++) {
                freq[tCh[i]]++;
            }

            for(i=0; i<=sLen - tLen; i++) {
                j = i;
                count = 0;
                int temp[] = freq.clone();

                while(j < sLen) {
                    if(temp[sCh[j]] > 0) {
                        temp[sCh[j]]--;
                        //System.out.println(sCh[j] + " " + temp[sCh[j]]);
                        count++;
                    }

                    if(count == tLen && j - i <  minLength) {
                        minLength = j - i;
                        start = i;
                        end = j;
                        break;
                    }
                    j++;
                }
            }
            return s.substring(start, end+1);
        }
    }
}