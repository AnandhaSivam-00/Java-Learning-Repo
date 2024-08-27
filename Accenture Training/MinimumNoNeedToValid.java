import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MinimumNoNeedToValid {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int hashCount = 0, astrickCount = 0;

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) =='*') {
                astrickCount++;
            }
            else {
                hashCount++;
            }
        }

        System.out.println(astrickCount - hashCount);
    }
}