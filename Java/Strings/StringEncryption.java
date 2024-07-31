import java.util.*;

public class StringEncryption {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), k = sc.nextInt();

        String str = sc.next();
        StringBuilder encryptedStr = new StringBuilder();

        char ch, encryptedChar;

        for(int i=0; i<str.length(); i++) {
            ch = str.charAt(i);

            if(Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                encryptedChar = (char) (((ch - base + k) % 26) + base);
                encryptedStr.append(encryptedChar);
            }
            else if(Character.isDigit(ch)) {
                char base = '0';
                encryptedChar = (char) (((ch - base + k) % 10) + base);
                encryptedStr.append(encryptedChar);
            }
            else {
                encryptedStr.append(ch);
            }
        }

        System.out.println(encryptedStr.toString());
    }
}

