import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FirstNonRepeatingChar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        boolean flag;
        int len = str.length();
        boolean isVisited[] = new boolean[len];

        for(int i=0; i<len; i++) {
            flag = false;
            if(!isVisited[i]) {
                for(int j=i+1; j<len; j++) {
                    if(str.charAt(i) == str.charAt(j)) {
                        flag = true;
                        isVisited[j] = true;
                    }
                }

                if(!flag) {
                    System.out.println(str.charAt(i));
                    break;
                }
            }
        }
    }
}