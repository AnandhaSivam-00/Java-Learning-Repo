
public class StringReverse {
    /**
     * Task: return the reverse of a string.
     * There are multiple good ways to solve this problem.
     *
     * You could do some math to grab characters from the end of the String using a typical for loop.
     * For instance, you could use build a String by writing a for loop that decrements rather than increments, grabbing
     * characters from the String starting from the end.
     * You could also look into the methods provided by StringBuilder.
     *
     * @param str a String.
     * @return the reverse of str.
     */
    public String reverse(String str){
        char chArray[] = str.toCharArray();
        int i = 0, j = str.length() - 1;

        while(i < j) {
            char temp = chArray[i];
            chArray[i] = chArray[j];
            chArray[j] = temp;
            i++;
            j--;
        }
        return new String(chArray);
    }
}
