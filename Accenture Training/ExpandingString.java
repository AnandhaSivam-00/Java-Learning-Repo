import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ExpandingString {
    protected static String expandedString(String str) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(Character.isDigit(ch)) {
                int num = Integer.valueOf(Character.toString(ch));

                while(num > 0) {
                    sb.append(str.charAt(i-1));
                    num--;
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(expandedString(str));
    }
}